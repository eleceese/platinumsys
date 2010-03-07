/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.OrdenTrabajo;
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
        String SQL = "SELECT o FROM OrdenTrabajo o WHERE o.numeroOrdenTrabajo= o.numeroOrdenTrabajo";

        if (numeroOrdenTrabajo != null && !numeroOrdenTrabajo.equals("99999") && !numeroOrdenTrabajo.equals("")) {
            SQL = SQL + " and UPPER(o.numeroOrdenTrabajo) like upper(:numeroOrdenTrabajo)";
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

                if (ordenTrabajoDetalle.getCodOrdenTrabajo() != null) {

                            em.merge(ordenTrabajoDetalle);

                            /// ACTUALIZAR LOS DETALLES DE RECURSOS ASIGNADOS
                            List<RecursoAsignado> detalleRecursoAsignadoList = ordenTrabajoDetalle.getRecursoAsignadoListList();
                            for (int j = 0; j < detalleRecursoAsignadoList.size(); j++) {
                                        RecursoAsignado recursoAsignado = detalleRecursoAsignadoList.get(j);
                                        if (recursoAsignado.getCodOrdenTrabDet() != null) {
                                                em.merge(recursoAsignado);
                                        } else {
                                                recursoAsignado.setCodOrdenTrabDet(ordenTrabajoDetalle);
                                                em.persist(recursoAsignado);
                                        }
                            }
                            /// FIN ACTUALIZAR LOS DETALLES DE RECURSOS ASIGNADOS

                            /// ACTUALIZAR LOS DETALLES DE TAREAS ASIGNADAS
                            List<TareaAsignada> detalleTareaAsignadaList = ordenTrabajoDetalle.getTareaAsignadaListList();
                            for (int j = 0; j < detalleTareaAsignadaList.size(); j++) {
                                    TareaAsignada tareaAsignada = detalleTareaAsignadaList.get(j);
                                    if (tareaAsignada.getCodDetOrdenTrabaj() != null) {
                                            em.merge(tareaAsignada);
                                    } else {
                                            tareaAsignada.setCodDetOrdenTrabaj(ordenTrabajoDetalle);
                                            em.persist(tareaAsignada);
                                    }

                            }
                            /// FIN ACTUALIZAR LOS DETALLES DE TAREAS ASIGNADAS

            }else{
                            /// INSERTAR LOS NUEVOS DETALLES

                            ordenTrabajoDetalle.setCodOrdenTrabajo(ordenTrabajoCabecera);
                            em.persist(ordenTrabajoDetalle);

                                /// INSERTAR LOS DETALLES DE RECURSOS ASIGNADOS
                                List<RecursoAsignado> detalleRecursoAsignadoList = ordenTrabajoDetalle.getRecursoAsignadoListList();
                                for (int j = 0; j < detalleRecursoAsignadoList.size(); j++) {
                                        RecursoAsignado recursoAsignado = detalleRecursoAsignadoList.get(j);
                                        recursoAsignado.setCodOrdenTrabDet(ordenTrabajoDetalle);
                                        em.persist(recursoAsignado);
                                }
                                /// FIN INSERTAR LOS DETALLES DE RECURSOS ASIGNADOS

                                /// ACTUALIZAR LOS DETALLES DE TAREAS ASIGNADAS
                                List<TareaAsignada> detalleTareaAsignadaList = ordenTrabajoDetalle.getTareaAsignadaListList();
                                for (int j = 0; j < detalleTareaAsignadaList.size(); j++) {
                                        TareaAsignada tareaAsignada = detalleTareaAsignadaList.get(j);
                                        tareaAsignada.setCodDetOrdenTrabaj(ordenTrabajoDetalle);
                                        em.persist(tareaAsignada);
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



//
//    public ControllerResult deleteCabDet(OrdenTrabajo cab, OrdenTrabajoDetalle[] det) {
//        ControllerResult r = new ControllerResult();
//        EntityManager em = emf.createEntityManager();
//
//        OrdenTrabajoDetalle[] detallesFormula = det;
//        OrdenTrabajo OrdenTrabajo = cab;
//        try {
//            em.getTransaction().begin();
//
//            /// ELIMINACION DE LOS DETALLES
//            if (detallesFormula != null) {
//                for (int i = 0; i < detallesFormula.length; i++) {
//                    OrdenTrabajoDetalle fdet = new OrdenTrabajoDetalle();
//                    fdet = detallesFormula[i];
//                    em.remove(em.merge(fdet));
//               }
//            }
//             //// FIN DE ELIMINACION DE LOS DETALLES
//
//            //// ELIMINACION DE LA CABECERA
//                OrdenTrabajo = cab;
//                em.remove(em.merge(OrdenTrabajo));
//            ///FIN ELIMINACION DE LA CABECERA
//
//                em.getTransaction().commit();
//            r.setCodRetorno(0);
//            r.setMsg("Registro eliminado correctamente");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            r.setCodRetorno(-1);
//            r.setMsg("Ha ocurrid un error durante la Eliminacion del Registro ");
//            try {
//                em.getTransaction().rollback();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } finally {
//            em.close();
//            return r;
//        }
//    }
//

//    public ControllerResult updateCabDet(OrdenTrabajo cab, OrdenTrabajoDetalle[] det, OrdenTrabajoDetalle[] detEli)  {
//        ControllerResult r = new ControllerResult();
//        EntityManager em = emf.createEntityManager();
//
//        OrdenTrabajoDetalle[] detallesFormula = det;
//        OrdenTrabajoDetalle[] detallesFormulaEliminada = detEli;
//        OrdenTrabajo OrdenTrabajo = cab;
//
//        try {
//            em.getTransaction().begin();
//            // ELIMINAR LOS DETALLES BORRADOS DE LA GRILLA
//            if (detallesFormulaEliminada.length > 0) {
//
//                        for (int i = 0; i < detallesFormulaEliminada.length; i++) {
//                            OrdenTrabajoDetalle fdetElim = new OrdenTrabajoDetalle();
//                            fdetElim = detallesFormulaEliminada[i];
//                            OrdenTrabajoDetalle OrdenTrabajoDetalle = em.find(OrdenTrabajoDetalle.class, fdetElim.getCodOrdenTrabajoDetalle());
//                            em.remove(OrdenTrabajoDetalle);
//                         }
//             }
//             // fin de la eliminacion
//
//            //// ACTUALIZAR DETALLES
//            OrdenTrabajo = cab;
//            for (int i = 0; i < detallesFormula.length; i++) {
//                 OrdenTrabajoDetalle fdet = new OrdenTrabajoDetalle();
//                 fdet = detallesFormula[i];
//                 if (fdet.getCodOrdenTrabajoDetalle() != null) {
//                        em.merge(fdet);
//                 }else{
//                        fdet.setCodFormula(OrdenTrabajo);
//                        em.persist(fdet);
//                 }
//             }
//             //// FIN ACTUALIZAR DETALLES
//
//            ///// ACTUALIZAR CABECERA
//                    em.merge(cab);
//            ///// FIN ACTUALIZAR CABECERA
//            em.getTransaction().commit();
//            r.setCodRetorno(0);
//            r.setMsg("Registro actualizado correctamente");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            r.setCodRetorno(-1);
//            r.setMsg("Ha ocurrido un error al actualizar el registro ");
//            try {
//                em.getTransaction().rollback();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } finally {
//            em.close();
//            return r;
//        }
//    }
//


}
