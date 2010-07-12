/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.EntradaSalidaCabecera;
import py.com.platinum.entity.EntradaSalidaDetalle;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.InventarioCabecera;
import py.com.platinum.entity.InventarioDetalle;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class InventarioCabeceraController extends AbstractJpaDao <InventarioCabecera> {

    public boolean existe(String codInventario){

        String SQL = "SELECT o FROM InventarioCabecera o WHERE o.codInventario = :codInventario";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codInventario", codInventario);

        List<InventarioCabecera> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public InventarioCabeceraController() {
        super();
    }

    @Override
    public InventarioCabecera findById(Long id) {
        return (InventarioCabecera) this.findById(InventarioCabecera.class, id);
    }

    @Override
    public List<InventarioCabecera> getAll(String orderBy) {
        return this.getAll(InventarioCabecera.class, orderBy);
    }

    public List<InventarioCabecera> getAllFiltered(String codigo, String codDeposito, Date Fecha1, Date Fecha2,String estado) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM InventarioCabecera o WHERE o.codInventario= o.codInventario";

        if (codigo != null && !codigo.equals("99999") && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codInventario) like upper(:codigo)";
        }

        if (codDeposito != null && !codDeposito.equals("")) {
            SQL = SQL + " and UPPER(o.codDeposito.codDeposito) like upper(:codDeposito)";
        }

        if (estado != null && !estado.equals("")) {
            SQL = SQL + " and UPPER(o.estado) like upper(:estado)";
        }

        if (Fecha1 != null && !Fecha1.equals("")) {
            SQL = SQL + " and o.fecInventario >= :Fecha1";
        }

        if (Fecha2 != null && !Fecha2.equals("")) {
            SQL = SQL + " and o.fecInventario <= :Fecha2";
        }

   
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codigo != null && !codigo.equals("99999") && !codigo.equals("")) {
            q.setParameter("codigo", codigo);
        }

        if (codDeposito != null && !codDeposito.equals("")) {
            q.setParameter("codDeposito", "%"+codDeposito+"%");
        }


        if (estado != null && !estado.equals("")) {
            q.setParameter("estado", "%"+estado+"%");
        }
        if (Fecha1 != null && !Fecha1.equals("")) {
            q.setParameter("Fecha1", Fecha1);
        }
        if (Fecha2 != null && !Fecha2.equals("")) {
            q.setParameter("Fecha2", Fecha2);
        }

        List<InventarioCabecera> entities = q.getResultList();
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



    public ControllerResult deleteCabDet(InventarioCabecera cab, InventarioDetalle[] det) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        InventarioDetalle[] detallesInventario = det;
        InventarioCabecera InventarioCabecera = cab;
        try {
            em.getTransaction().begin();

            /// ELIMINACION DE LOS DETALLES
            if (detallesInventario != null) {
                for (int i = 0; i < detallesInventario.length; i++) {
                    InventarioDetalle fdet = new InventarioDetalle();
                    fdet = detallesInventario[i];
                    em.remove(em.merge(fdet));
               }
            }
             //// FIN DE ELIMINACION DE LOS DETALLES

            //// ELIMINACION DE LA CABECERA
                InventarioCabecera = cab;
                em.remove(em.merge(InventarioCabecera));
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

    public ControllerResult createCabDet(InventarioCabecera cab, InventarioDetalle[] det) throws RuntimeException {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        InventarioDetalle[] detallesInventario = det;
        InventarioCabecera inventarioCabecera = cab;

        try {
            tx.begin();

          //// CARGA DE LA CABECERA
            em.persist(inventarioCabecera);
          //// FIN DE LA CARGA DE LA CABECERA

            //// CARGA DE LOS DETALLES

            for (int i = 0; i < detallesInventario.length; i++) {

                    InventarioDetalle fdet = new InventarioDetalle();
                    fdet = detallesInventario[i];
                    fdet.setCodInventario(inventarioCabecera);
                    em.persist(em.merge(fdet));
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


    public ControllerResult updateCabDet(InventarioCabecera cab, InventarioDetalle[] det)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        InventarioDetalle[] detallesInventario = det;
        InventarioCabecera InventarioCabecera = cab;

        try {
            em.getTransaction().begin();

            //// ACTUALIZAR DETALLES
            InventarioCabecera = cab;
            for (int i = 0; i < detallesInventario.length; i++) {
                 InventarioDetalle fdet = new InventarioDetalle();
                 fdet = detallesInventario[i];
                 em.merge(fdet);
            
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
    public ControllerResult updateCabDetClose(InventarioCabecera cab, InventarioDetalle[] det)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        Deposito dep = cab.getCodDeposito();

        InventarioDetalle[] detallesInventario = det;
        InventarioCabecera InventarioCabecera = cab;

        try {
            em.getTransaction().begin();

            // PREPARAMOS LOS MOVIMIENTOS EN DEPOSITO EN CASO DE  DIFERENCIAS

            EntradaSalidaDetalle[] detallesEntradaSalida;
            EntradaSalidaDetalle  detalleEntradaSalida;
            List<EntradaSalidaDetalle>  detalleEntradaSalidaList = new ArrayList();
            detallesEntradaSalida = (EntradaSalidaDetalle[]) detalleEntradaSalidaList.toArray(new EntradaSalidaDetalle[0]);

            //// ACTUALIZAR DETALLES
            InventarioCabecera = cab;
            for (int i = 0; i < detallesInventario.length; i++) {
                 InventarioDetalle fdet = new InventarioDetalle();
                 fdet = detallesInventario[i];
                 em.merge(fdet);
                 ///// AJUSTAR LAS EXISTENCIAS EN EL DEPOSITO EN CUESTION
                 Existencia exi = new Existencia();
                 exi = new ExistenciaController().getExistencia(null, fdet.getCodProducto().getCodProducto(), dep.getCodDeposito());
                 if (exi.getCantidadExistencia().longValue() != fdet.getCantidadcontada().longValue()) {
                     
                     
                     //// preparamos los detalles de movimientos
                     detalleEntradaSalida = new EntradaSalidaDetalle();
                     detalleEntradaSalida.setCodProducto(fdet.getCodProducto());
                     if (exi.getCantidadExistencia().longValue() < fdet.getCantidadcontada().longValue()) {
                            detalleEntradaSalida.setTipoEntradaSalida("E");
                            detalleEntradaSalida.setCantidadEntSal(BigInteger.valueOf(fdet.getCantidadcontada().longValue() - exi.getCantidadExistencia().longValue()));
                     }else{
                            detalleEntradaSalida.setTipoEntradaSalida("S");
                            detalleEntradaSalida.setCantidadEntSal(BigInteger.valueOf(exi.getCantidadExistencia().longValue() - fdet.getCantidadcontada().longValue()));
                     }
                     detalleEntradaSalida.setFechaAlta(new Date());
                     detalleEntradaSalida.setObservacion("Ajuste de Inventario");
                     detalleEntradaSalidaList.add(detalleEntradaSalida);
                     detallesEntradaSalida = (EntradaSalidaDetalle[]) detalleEntradaSalidaList.toArray(new EntradaSalidaDetalle[0]);


                        exi.setCantidadExistencia(fdet.getCantidadcontada());
                        em.merge(exi);

                 }

            }
            //// FIN ACTUALIZAR LAS EXISTENCIAS
            //// FIN ACTUALIZAR DETALLES

            /// en el caso de registrarse algun ajuste se insertaran los movimientos en deposito
            if (detallesEntradaSalida != null && detallesEntradaSalida.length > 0) {
                            Deposito d = cab.getCodDeposito();
                            Empleado emp = cab.getCodEmpleado();
                            String textoCabecera;
                            textoCabecera = "Movimiento en deposito Generado por AJUSTE DE INVENTARIO NRO: "+cab.getCodInventario().toString();

                            EntradaSalidaCabecera entSalCab = new EntradaSalidaCabecera();


                            entSalCab.setCodDeposito(d);
                            entSalCab.setCodEmpleado(emp);
                            entSalCab.setCodEncargado(emp);
                            entSalCab.setFechaEntradaSalida(new Date());
                            entSalCab.setObservacion(textoCabecera);
                            entSalCab.setFechaAlta(new Date());
                            em.persist(entSalCab);

                             for (int i = 0; i < detallesEntradaSalida.length; i++) {
                                EntradaSalidaDetalle entradaSalidaDetalle = detallesEntradaSalida[i];
                                entradaSalidaDetalle.setCodEntradaSalida(em.merge(entSalCab));
                                em.persist(em.merge(entradaSalidaDetalle));
                             }


            }
            ///// ACTUALIZAR CABECERA
                    cab.setEstado("C");
                    em.merge(cab);
            ///// FIN ACTUALIZAR CABECERA
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro de inventario actualizado correctamente. Se ajustaron las existencias en deposito y se cerro el inventario");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error durante la actualizacion y cierre del Inventario");
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


     public ControllerResult anularCabDet(InventarioCabecera cab, InventarioDetalle[] det)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        InventarioDetalle[] detallesInventario = det;
        InventarioCabecera InventarioCabecera = cab;

        try {
            em.getTransaction().begin();

            //// ACTUALIZAR DETALLES
            InventarioCabecera = cab;
            for (int i = 0; i < detallesInventario.length; i++) {
                 InventarioDetalle fdet = new InventarioDetalle();
                 fdet = detallesInventario[i];
                 fdet.setEstado("N");
                 fdet.setFechaModif(new Date());
                 em.merge(fdet);

             }
             //// FIN ACTUALIZAR DETALLES

            ///// ACTUALIZAR CABECERA
                cab.setEstado("N");
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
