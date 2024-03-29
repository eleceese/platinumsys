/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.CostosFijos;
import py.com.platinum.entity.HistoricoCosto;
import py.com.platinum.entity.HistoricoPrecio;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetCostoH;
import py.com.platinum.entity.OrdenTrabajoDetCostoMat;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.RecursoAsignado;
import py.com.platinum.entity.TareaAsignada;

/**
 *
 * @author FerBoy
 */
public class OrdenTrabajoCabeceraController extends AbstractJpaDao <OrdenTrabajo> {

    public boolean existe(String numeroOrdenTrabajo){

        String SQL = "SELECT o FROM OrdenTrabajo o WHERE o.numeroOrdenTrabajo = :numeroOrdenTrabajo";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("numeroOrdenTrabajo", numeroOrdenTrabajo);

        List<OrdenTrabajo> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public OrdenTrabajoCabeceraController() {
        super();
    }

    @Override
    public OrdenTrabajo findById(Long id) {
        return (OrdenTrabajo) this.findById(OrdenTrabajo.class, id);
    }

    @Override
    public List<OrdenTrabajo> getAll(String orderBy) {
        return this.getAll(OrdenTrabajo.class, orderBy);
    }

    public List<OrdenTrabajo> getAllFiltered(String numeroOrdenTrabajo, String codProducto, String estado, Date fechaOt) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM OrdenTrabajo o WHERE o.codOrdenTrabjo= o.codOrdenTrabjo";

        if (numeroOrdenTrabajo != null && !numeroOrdenTrabajo.equals("99999") && !numeroOrdenTrabajo.equals("")) {
            SQL = SQL + " and UPPER(o.codOrdenTrabjo) like upper(:numeroOrdenTrabajo)";
        }

        if (codProducto != null && !codProducto.equals("99999") && !codProducto.equals("")) {
            SQL = SQL + " and UPPER(o.codProductoOt.codProducto)like upper(:codProducto)";
        }

        if (estado != null && !estado.equals("99999") && !estado.equals("")) {
            SQL = SQL + " and UPPER(o.estadoOt) like upper(:estado)";
        }

        if (fechaOt != null) {
            SQL = SQL + " and o.fechaOt = :fechaOt";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (numeroOrdenTrabajo != null && !numeroOrdenTrabajo.equals("99999") && !numeroOrdenTrabajo.equals("")) {
            q.setParameter("numeroOrdenTrabajo", numeroOrdenTrabajo);
        }

        if (codProducto != null && !codProducto.equals("99999") && !codProducto.equals("")) {
            q.setParameter("codProducto", "%"+codProducto+"%");
        }

        if (estado != null && !estado.equals("99999") && !estado.equals("")) {
            q.setParameter("estado", "%"+estado+"%");
        }

        if (fechaOt != null) {
            q.setParameter("fechaOt", fechaOt);
        }

        List<OrdenTrabajo> entities = q.getResultList();
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

    public ControllerResult createCabDet(OrdenTrabajo cab, OrdenTrabajoDetalle[] det) throws RuntimeException {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        OrdenTrabajoDetalle[] detallesOt = det;
        OrdenTrabajo ordenTrabajo = cab;

        try {
            tx.begin();

          //// CARGA DE LA CABECERA
            em.persist(ordenTrabajo);
          //// FIN DE LA CARGA DE LA CABECERA

            //// CARGA DE LOS DETALLES

            for (int i = 0; i < detallesOt.length; i++) {
                    ordenTrabajo = cab;
                    OrdenTrabajoDetalle oDet = new OrdenTrabajoDetalle();
                    oDet = detallesOt[i];
                    oDet.setCodOrdenTrabajo(ordenTrabajo);
                    em.persist(oDet);

                    ///// CARGA DE LOS RECURSOS Y TAREAS DE LOS DETALLES
                    List<RecursoAsignado> recursoAsignadoList = oDet.getRecursoAsignadoListList();
                    OrdenTrabajoDetalle oDetInsertada = (oDet);
                    for (int j = 0; j < recursoAsignadoList.size(); j++) {

                            RecursoAsignado recursoAsignado = new RecursoAsignado ();
                            recursoAsignado = recursoAsignadoList.get(j);
                            recursoAsignado.setCodOrdenTrabDet(oDetInsertada);
                            em.persist(em.merge(recursoAsignado));
                    }
                    //// CARGA DE LOS RECURSOS

                    /// CARGA DE LAS TAREAS
                    List<TareaAsignada> tareaAsignadaList = oDet.getTareaAsignadaListList();
                    for (int j = 0; j < tareaAsignadaList.size(); j++) {
                        TareaAsignada tareaAsignada = new TareaAsignada();
                        tareaAsignada = tareaAsignadaList.get(j);
                        tareaAsignada.setCodDetOrdenTrabaj(oDetInsertada);
                        em.persist(em.merge(tareaAsignada));
                    }
                    /// FIN CARGA DE LAS TAREAS
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

 public ControllerResult updateCabDet(OrdenTrabajo cab, OrdenTrabajoDetalle[] det, OrdenTrabajoDetalle[] detElim, TareaAsignada[] tarAsignElim, RecursoAsignado[] recAsigElim)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        OrdenTrabajo ordenTrabajoCabecera = cab;
        OrdenTrabajoDetalle[] detallesOrdenTrabajo = det;
        OrdenTrabajoDetalle[] detallesOrdenTrabajoElim = detElim;

        TareaAsignada[] tareasAsignadasElim = tarAsignElim;
        RecursoAsignado[] recursosAsignadosElim = recAsigElim;



        try {
            em.getTransaction().begin();

            // ELIMINAR LOS DETALLES DE RECURSOS ASIGNADOS BORRADOS DE LA GRILLA

            if (recursosAsignadosElim.length > 0) {
                        for (int i = 0; i < recursosAsignadosElim.length; i++) {
                            RecursoAsignado recursoAsignadoElim = new RecursoAsignado();
                            recursoAsignadoElim = recursosAsignadosElim[i];
                            RecursoAsignado recAsignadoElim = em.find(RecursoAsignado.class, recursoAsignadoElim.getCodRecurso());
                            em.remove(recAsignadoElim);
                         }
             }
            // FIN ELIMINAR LOS DETALLES RECURSOS ASIGNADOS BORRADOS DE LA GRILLA
            // ELIMINAR LOS DETALLES DE TAREAS ASIGNADAS DE LA GRILLA
            if (tareasAsignadasElim.length> 0) {
                        for (int i = 0; i < tareasAsignadasElim.length; i++) {
                            TareaAsignada tareaAsignadaElim = new TareaAsignada();
                            tareaAsignadaElim = tareasAsignadasElim[i];
                            TareaAsignada tarElim = em.find(TareaAsignada.class, tareaAsignadaElim.getCodTareaAsignada());
                            em.remove(tarElim);
                        }
             }

            // FIN ELIMINAR LOS DETALLES DE OT DE LA GRILLA
            if (detallesOrdenTrabajoElim.length> 0) {
                        for (int i = 0; i < detallesOrdenTrabajoElim.length; i++) {
                            OrdenTrabajoDetalle ordenTrabajoDetalleElim = new OrdenTrabajoDetalle();
                            ordenTrabajoDetalleElim = detallesOrdenTrabajoElim[i];
                            OrdenTrabajoDetalle ordTrabDetalleElim = em.find(OrdenTrabajoDetalle.class, ordenTrabajoDetalleElim.getCodOrdenTrabajoDet());
                            em.remove(ordTrabDetalleElim);
                        }
             }
            // FIN ELIMINAR LOS DETALLES DE OT DE LA GRILLA


            //// ACTUALIZAR DETALLES DE ORDEN DE TRABAJO

            ordenTrabajoCabecera = cab;

            for (int i = 0; i < detallesOrdenTrabajo.length; i++) {
                OrdenTrabajoDetalle ordenTrabajoDetalle = new OrdenTrabajoDetalle();
                ordenTrabajoDetalle = detallesOrdenTrabajo[i];

                
//                //////////PRUEBA ///////////////
//                    List<RecursoAsignado> recursos = new ArrayList();
//                    recursos = ordenTrabajoDetalle.getRecursoAsignadoListList();
//                    for (int j = 0; j < recursos.size(); j++) {
//                    RecursoAsignado rrr = recursos.get(j);
//                        System.out.println("********RECURSO***************");
//                        System.out.println(rrr.getCodRecurso());
//
//                    }
//                 ////////// FIN PRUEBA //////////
                 
                 List<RecursoAsignado> recursosActualizar = new ArrayList<RecursoAsignado>();
                 List<TareaAsignada> tareasActualizar = new ArrayList<TareaAsignada>();
                 recursosActualizar = ordenTrabajoDetalle.getRecursoAsignadoListList();
                 tareasActualizar = ordenTrabajoDetalle.getTareaAsignadaListList();

                 

                 
                if (ordenTrabajoDetalle.getCodOrdenTrabajoDet() != null) {
//

                            ordenTrabajoDetalle.setRecursoAsignadoCollection(new HashSet());
                            ordenTrabajoDetalle.setTareaAsignadaCollection(new HashSet());

                            em.merge(ordenTrabajoDetalle);
                            /// ACTUALIZAR LOS DETALLES DE RECURSOS ASIGNADOS
                            List<RecursoAsignado> detalleRecursoAsignadoList = ordenTrabajoDetalle.getRecursoAsignadoListList();
//                            for (int j = 0; j < detalleRecursoAsignadoList.size(); j++) {
                            for (int j = 0; j < recursosActualizar.size(); j++) {
//                                        RecursoAsignado recursoAsignado = detalleRecursoAsignadoList.get(j);
                                        RecursoAsignado recursoAsignado = recursosActualizar.get(j);
                                        if (recursoAsignado.getCodOrdenTrabDet() != null) {
                                                em.merge(recursoAsignado);
                                        } else {
//                                                recursoAsignado.setCodOrdenTrabDet(ordenTrabajoDetalle);
                                                recursoAsignado.setCodOrdenTrabDet(ordenTrabajoDetalle);
                                                em.persist(em.merge(recursoAsignado));
                                        }
                            }
                            /// FIN ACTUALIZAR LOS DETALLES DE RECURSOS ASIGNADOS

                            /// ACTUALIZAR LOS DETALLES DE TAREAS ASIGNADAS
                            List<TareaAsignada> detalleTareaAsignadaList = ordenTrabajoDetalle.getTareaAsignadaListList();
//                            for (int j = 0; j < detalleTareaAsignadaList.size(); j++) {
                            for (int j = 0; j < tareasActualizar.size(); j++) {
//                                    TareaAsignada tareaAsignada = detalleTareaAsignadaList.get(j);
                                    TareaAsignada tareaAsignada = tareasActualizar.get(j);
                                    if (tareaAsignada.getCodDetOrdenTrabaj() != null) {
                                            em.merge(tareaAsignada);
                                    } else {
//                                            tareaAsignada.setCodDetOrdenTrabaj(ordenTrabajoDetalle);
                                            tareaAsignada.setCodDetOrdenTrabaj(ordenTrabajoDetalle);
                                            em.persist(em.merge(tareaAsignada));
                                    }

                            }
                            /// FIN ACTUALIZAR LOS DETALLES DE TAREAS ASIGNADAS
                            
            }else{
                            /// INSERTAR LOS NUEVOS DETALLES

                            ordenTrabajoDetalle.setCodOrdenTrabajo(ordenTrabajoCabecera);
                            em.persist(ordenTrabajoDetalle);

                                /// INSERTAR LOS DETALLES DE RECURSOS ASIGNADOS Y TAREAS
                                List<RecursoAsignado> detalleRecursoAsignadoList = ordenTrabajoDetalle.getRecursoAsignadoListList();
                                ordenTrabajoDetalle.setRecursoAsignadoCollection(new HashSet());

                                 List<TareaAsignada> detalleTareaAsignadaList = ordenTrabajoDetalle.getTareaAsignadaListList();
                                ordenTrabajoDetalle.setTareaAsignadaCollection(new HashSet());

                                for (int j = 0; j < detalleRecursoAsignadoList.size(); j++) {
                                        RecursoAsignado recursoAsignado = detalleRecursoAsignadoList.get(j);
                                        recursoAsignado.setCodOrdenTrabDet(em.merge(ordenTrabajoDetalle));
                                        em.persist(em.merge(recursoAsignado));
                                }
                                /// FIN INSERTAR LOS DETALLES DE RECURSOS ASIGNADOS

                                /// ACTUALIZAR LOS DETALLES DE TAREAS ASIGNADAS
                               
                                for (int j = 0; j < detalleTareaAsignadaList.size(); j++) {
                                        TareaAsignada tareaAsignada = detalleTareaAsignadaList.get(j);
                                        tareaAsignada.setCodDetOrdenTrabaj(em.merge(ordenTrabajoDetalle));
                                        em.persist(em.merge(tareaAsignada));
                                }
                                /// FIN ACTUALIZAR LOS DETALLES DE TAREAS ASIGNADAS

            }
        }
           //// FIN ACTUALIZAR DETALLES RECURSOS

            ordenTrabajoCabecera = cab;
            em.merge(ordenTrabajoCabecera);
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro actualizado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al actualizar el registro");
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


 public ControllerResult updateCostosFinales(OrdenTrabajo cab, OrdenTrabajoDetalle[] det)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        OrdenTrabajo ordenTrabajoCabecera = cab;
        OrdenTrabajoDetalle[] detallesOrdenTrabajo = det;


        try {
            em.getTransaction().begin();

           //// ACTUALIZAR DETALLES DE ORDEN DE TRABAJO

            ordenTrabajoCabecera = cab;

            for (int i = 0; i < detallesOrdenTrabajo.length; i++) {
                OrdenTrabajoDetalle ordenTrabajoDetalle = new OrdenTrabajoDetalle();
                ordenTrabajoDetalle = detallesOrdenTrabajo[i];



                 List<CostosFijos> costosFijosActualizar = new ArrayList<CostosFijos>();
                 List<OrdenTrabajoDetCostoH> costosHActualizar = new ArrayList<OrdenTrabajoDetCostoH>();
                 List<OrdenTrabajoDetCostoMat> costosMatActualizar = new ArrayList<OrdenTrabajoDetCostoMat>();

                 costosFijosActualizar = ordenTrabajoDetalle.getCostosFijosListList();
                 costosMatActualizar = ordenTrabajoDetalle.getOrdenTrabajoDetMListList();
                 costosHActualizar = ordenTrabajoDetalle.getOrdenTrabajoDetCostoListList();

                 ordenTrabajoDetalle.setCostosFijosCollection(new HashSet());
                 ordenTrabajoDetalle.setOrdenTrabajoDetCostoCollection(new HashSet());
                 ordenTrabajoDetalle.setOrdenTrabajoDetMCollection(new HashSet());

                em.merge(ordenTrabajoDetalle);
               ///INSERTAR LOS COSTOS FIJOS
                for (int j = 0; j < costosFijosActualizar.size(); j++) {
                                        CostosFijos costoFijo = costosFijosActualizar.get(j);
                                        costoFijo.setCodOrdenTrabajoDet(ordenTrabajoDetalle);
//                                        costoFijo.setCostoUnitario(BigInteger.valueOf(Long.valueOf("3321")));
//                                        costoFijo.setCantidad(BigInteger.valueOf(Long.valueOf("121")));

                                        em.persist(em.merge(costoFijo));
               }
               /// FIN INSERTAR LOS COSTOS FIJOS

               ///INSERTAR LOS COSTOS DE HORAS HOMBRE
                for (int j = 0; j < costosHActualizar.size(); j++) {
                                        OrdenTrabajoDetCostoH costoH = costosHActualizar.get(j);
                                        costoH.setCodOrdenTrabajoDet(ordenTrabajoDetalle);
                                        em.persist(em.merge(costoH));
               }
               /// FIN INSERTAR LOS COSTOS DE HORAS HOMBRE

               ///INSERTAR LOS COSTOS DE HORAS HOMBRE
                for (int j = 0; j < costosMatActualizar.size(); j++) {
                                        OrdenTrabajoDetCostoMat costoMat = costosMatActualizar.get(j);
                                        costoMat.setCodOrdenTrabajoDet(ordenTrabajoDetalle);
                                        em.persist(em.merge(costoMat));
               }
               /// FIN INSERTAR LOS COSTOS DE HORAS HOMBRE


        }
            ordenTrabajoCabecera = cab;
            em.merge(ordenTrabajoCabecera);
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Se han calculado los costos Finales Correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al actualizar el registro");
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

public ControllerResult updateCierre(OrdenTrabajo cab, OrdenTrabajoDetalle[] det,BigInteger precio, BigInteger costo,boolean acCosto,boolean acPrecio)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        OrdenTrabajo ordenTrabajoCabecera = cab;
        OrdenTrabajoDetalle[] detallesOrdenTrabajo = det;


        try {
            em.getTransaction().begin();

            /// ACTUALIZAR LOS COSTOS Y PRECIOS DEL PRODUCTO
            Producto prod = new Producto();
            prod = new ProductoController().findById(cab.getCodProductoOt().getCodProducto());
            if (acCosto) {
                prod.setCostoActual(costo);



            }
            if (acPrecio) {
                prod.setPrecioActual(precio);
            }
            em.merge(prod);

            if (acPrecio) {

                HistoricoPrecio histPrec = new HistoricoPrecio();
                histPrec.setCodProducto(prod);
                histPrec.setFechaAlta(new Date());
                histPrec.setFecHistorico(new Date());
                histPrec.setPrecioHistorico(precio);
                em.persist(histPrec);

            }
            if (acCosto) {

                HistoricoCosto histCosto = new HistoricoCosto();
                histCosto.setCodProducto(prod);
                histCosto.setFechaAlta(new Date());
                histCosto.setFecHistoricoCosto(new Date());
                histCosto.setCostoHistorico(costo);
                em.persist(histCosto);

            }

            //// ACTUALIZAR DETALLES DE ORDEN DE TRABAJO

            ordenTrabajoCabecera = cab;

            for (int i = 0; i < detallesOrdenTrabajo.length; i++) {
                OrdenTrabajoDetalle ordenTrabajoDetalle = new OrdenTrabajoDetalle();
                ordenTrabajoDetalle = detallesOrdenTrabajo[i];
                ordenTrabajoDetalle.setEstado("C");
                ordenTrabajoDetalle.setFechaModif(new Date());
                em.merge(ordenTrabajoDetalle);
                //////////////////////////////////
               if (acCosto) {


                Producto productoActual =ordenTrabajoDetalle.getCodProducto();
                    long exist = 0;
                    exist = new ExistenciaController().getCantidadExistencia(Long.valueOf(productoActual.getCodProducto().toString())).longValue();
                    double costoRealOTVar = ordenTrabajoDetalle.getCostoReal().doubleValue();
                     double CantidadProducidaOtVar = ordenTrabajoDetalle.getCantidadReal().doubleValue();

                        Double costoUnit = Math.ceil(Double.valueOf(ordenTrabajoDetalle.getCostoReal().doubleValue() / ordenTrabajoDetalle.getCantidadReal().doubleValue()));
                        Double costoNuevo = Math.ceil(Double.valueOf((ordenTrabajoDetalle.getCostoReal().doubleValue() + (productoActual.getCostoActual().doubleValue()*exist))/(exist+ordenTrabajoDetalle.getCantidadReal().longValue())));
                productoActual.setCostoActual(BigInteger.valueOf(costoNuevo.longValue()));
                em.merge(productoActual);
                ///////////////////////////////////
                }
            }

            ordenTrabajoCabecera = cab;
            ordenTrabajoCabecera.setEstadoOt("C");
            ordenTrabajoCabecera.setFechaFinOt(new Date());

            em.merge(ordenTrabajoCabecera);
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Se ha cerrado la OT Correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al actualizar el registro");
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
