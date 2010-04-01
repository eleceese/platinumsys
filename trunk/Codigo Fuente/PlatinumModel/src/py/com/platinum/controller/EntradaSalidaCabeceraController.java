/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.EntradaSalidaCabecera;
import py.com.platinum.entity.EntradaSalidaDetalle;
import py.com.platinum.entity.Equivalencia;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.RecursoAsignado;

/**
 *
 * @author FerBoy
 */
public class EntradaSalidaCabeceraController extends AbstractJpaDao <EntradaSalidaCabecera> {

    
    public EntradaSalidaCabeceraController() {
        super();
    }

    @Override
    public EntradaSalidaCabecera findById(Long id) {
        return (EntradaSalidaCabecera) this.findById(EntradaSalidaCabecera.class, id);
    }

    @Override
    public List<EntradaSalidaCabecera> getAll(String orderBy) {
        return this.getAll(EntradaSalidaCabecera.class, orderBy);
    }

    public List<EntradaSalidaCabecera> getAllFiltered(String codEntradaSalida, String codDeposito, String codEmpleado) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM EntradaSalidaCabecera o WHERE o.codEntradaSalida= o.codEntradaSalida";

        if (codEntradaSalida != null) {
            SQL = SQL + " and UPPER(o.codEntradaSalida) like UPPER(:codEntradaSalida)";
        }

        if (codDeposito != null) {
            SQL = SQL + " and UPPER(o.codDeposito.codDeposito) like UPPER(:codDeposito)";
        }

        if (codEmpleado != null) {
            SQL = SQL + " and UPPER(o.codEmpleado) like UPPER(:codEmpleado)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

         if (codEntradaSalida != null) {
            q.setParameter("codEntradaSalida", "%"+codEntradaSalida+"%");
        }
         if (codDeposito != null) {
            q.setParameter("codDeposito", "%"+codDeposito+"%");
        }
         if (codEmpleado != null) {
            q.setParameter("codEmpleado", "%"+codEmpleado+"%");
        }

        List<EntradaSalidaCabecera> entities = q.getResultList();
        em.close();

        return entities;

      }

//public static void main (String[] v) {
//        ProductoController productoController = new ProductoController();
//        Producto producto = new Producto();
//        producto = productoController.findById(Long.valueOf("1000"));
//        System.out.println(producto.getDescripcion());
//        productoController.delete(producto);
//        };



    public ControllerResult deleteCabDet(EntradaSalidaCabecera cab, EntradaSalidaDetalle[] det) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        EntradaSalidaDetalle[] detallesEntSal = det;
        EntradaSalidaCabecera entradaSalidaCabecera = cab;
        try {
            em.getTransaction().begin();

            /// ELIMINACION DE LOS DETALLES
            if (detallesEntSal != null) {
                for (int i = 0; i < detallesEntSal.length; i++) {
                    EntradaSalidaDetalle entSaldet = new EntradaSalidaDetalle();
                    entSaldet = detallesEntSal[i];
                    em.remove(em.merge(entSaldet));
               }
            }
             //// FIN DE ELIMINACION DE LOS DETALLES

            //// ELIMINACION DE LA CABECERA
                entradaSalidaCabecera = cab;
                em.remove(em.merge(entradaSalidaCabecera));
            ///FIN ELIMINACION DE LA CABECERA

                em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro eliminado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrid un error durante la Eliminacion del Registro ");
            try {
                em.getTransaction().rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            em.close();
            return r;
        }
    }

    public ControllerResult createCabDet(EntradaSalidaCabecera cab, EntradaSalidaDetalle[] det) throws RuntimeException {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        EntradaSalidaDetalle[] detallesEntSal = det;
        EntradaSalidaCabecera EntradaSalidaCabecera = cab;

        try {
            tx.begin();

          //// CARGA DE LA CABECERA
            em.persist(EntradaSalidaCabecera);
          //// FIN DE LA CARGA DE LA CABECERA

            //// CARGA DE LOS DETALLES

            for (int i = 0; i < detallesEntSal.length; i++) {

                    EntradaSalidaDetalle entSaldet = new EntradaSalidaDetalle();
                    entSaldet = detallesEntSal[i];
                    entSaldet.setCodEntradaSalida(EntradaSalidaCabecera);


                    ///// Actualizacion de la utilizacion a traves de la equivalencia

                                Producto p = null;
                                OrdenTrabajoDetalle otDet = null;
                                p = entSaldet.getCodProducto();

                                Long cantidad = null;
                                cantidad = Long.valueOf(entSaldet.getCantidadEntSal().toString());
                                if (entSaldet.getCodOrdenTrabajoDetalle().getCodOrdenTrabajoDet() != null) {
                                    otDet = otDet = entSaldet.getCodOrdenTrabajoDetalle();
                                }

                                if (otDet != null && p != null && cantidad != null) {

                                        RecursoAsignado rAsignado = new RecursoAsignado();
                                        RecursoAsignadoController rController = new RecursoAsignadoController();
                                        rAsignado = rController.getRecursoPorEquiv(otDet.getCodOrdenTrabajoDet(),p.getCodProducto());
                                        
                                            Equivalencia eq = new EquivalenciaController().getEqPorProductos(rAsignado.getCodProducto().getCodProducto(), p.getCodProducto());
                                            double relacion = eq.getRelacion().doubleValue();
                                            double retirado = relacion * cantidad;
                                            rAsignado.setCantidadReal(rAsignado.getCantidadReal() + Math.round(retirado));
                                            em.merge(rAsignado);
                                     }

                    //////////////////


                     //////////////////Actualizacion de las Existencias en Deposito
                     Existencia exist = new Existencia();
                     exist = new ExistenciaController().getExistencia(null, entSaldet.getCodProducto().getCodProducto(), entSaldet.getCodEntradaSalida().getCodDeposito().getCodDeposito());

                     BigInteger cantidadNueva = exist.getCantidadExistencia();
                     cantidadNueva = BigInteger.valueOf(cantidadNueva.longValue() - entSaldet.getCantidadEntSal().longValue());
                     exist.setCantidadExistencia(cantidadNueva);
                     em.merge(exist);
                                
                     //////////////////

                    em.persist(entSaldet);






            }
            //// FIN DE CARGA DE LOS DETALLES

            tx.commit();
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error en la creacion del Registro ");
            try {
                tx.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            em.close();
            return r;
        }
    }


    public ControllerResult updateCabDet(EntradaSalidaCabecera cab, EntradaSalidaDetalle[] det, EntradaSalidaDetalle[] detEli)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        EntradaSalidaDetalle[] detallesEntSal = det;
        EntradaSalidaDetalle[] detallesEntSalEliminada = detEli;
        EntradaSalidaCabecera entradaSalidaCabecera = cab;

        try {
            em.getTransaction().begin();
            // ELIMINAR LOS DETALLES BORRADOS DE LA GRILLA
            if (detallesEntSalEliminada.length > 0) {

                        for (int i = 0; i < detallesEntSalEliminada.length; i++) {
                            EntradaSalidaDetalle entSalElim = new EntradaSalidaDetalle();
                            entSalElim = detallesEntSalEliminada[i];
                            EntradaSalidaDetalle entradaSalidaDetalle = em.find(EntradaSalidaDetalle.class, entSalElim.getCodEntSalDetalle());
                            em.remove(entradaSalidaDetalle);
                         }
             }
             // fin de la eliminacion

            //// ACTUALIZAR DETALLES
            entradaSalidaCabecera = cab;
            for (int i = 0; i < detallesEntSal.length; i++) {
                 EntradaSalidaDetalle entSaldet = new EntradaSalidaDetalle();
                 entSaldet = detallesEntSal[i];
                 if (entSaldet.getCodEntSalDetalle() != null) {
                        em.merge(entSaldet);
                 }else{
                        entSaldet.setCodEntradaSalida(entradaSalidaCabecera);
                        em.persist(entSaldet);
                 }
             }
             //// FIN ACTUALIZAR DETALLES

            ///// ACTUALIZAR CABECERA
                    em.merge(cab);
            ///// FIN ACTUALIZAR CABECERA
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro actualizado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error al actualizar el registro ");
            try {
                em.getTransaction().rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            em.close();
            return r;
        }
    }

}
