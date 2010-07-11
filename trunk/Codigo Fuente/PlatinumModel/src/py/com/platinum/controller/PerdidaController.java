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
import py.com.platinum.entity.EntradaSalidaCabecera;
import py.com.platinum.entity.EntradaSalidaDetalle;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.Perdida;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.TareaAsignada;

/**
 *
 * @author FerBoy
 */
public class PerdidaController extends AbstractJpaDao <Perdida> {



    public PerdidaController() {
        super();
    }

    @Override
    public Perdida findById(Long id) {
        return (Perdida) this.findById(Perdida.class, id);
    }

    @Override
    public List<Perdida> getAll(String orderBy) {
        return this.getAll(Perdida.class, orderBy);
    }

    public List<Perdida> getAllFiltered(String codEmpleado, String codProducto, String codOt, Date fecha1, Date fecha2) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Perdida o WHERE o.codPerdida = o.codPerdida";
        SQL = SQL + " and o.estado = null";

        if (codOt != null) {
            SQL = SQL + " and o.codOrdenTrabjo.codOrdenTrabjo = :codOt";
        }

        if (codEmpleado != null) {
            SQL = SQL + " and o.codEmpleado.codEmpleado = :codEmpleado";
        }

        if (fecha1 != null) {
            SQL = SQL + " and o.fechaPerdida >= :fecha1";
        }

        if (fecha1 != null) {
            SQL = SQL + " and o.fechaPerdida <= :fecha2";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

//        q.setParameter("anulado",  "A");

        if (codOt != null){
            Long codO = Long.valueOf(codOt);
            q.setParameter("codOt",  codO);
        }

        if (codEmpleado != null) {
            Long codEmp = Long.valueOf(codEmpleado);
            q.setParameter("codEmpleado",  codEmp);
        }

        if (fecha1 != null) {
            q.setParameter("fecha1", fecha1);
        }

        if (fecha2 != null) {
            q.setParameter("fecha2", fecha2);
        }

        List<Perdida> entities = q.getResultList();
        em.close();

        return entities;

      }


     public List<Perdida> getAllPorTarea(Long codTareaFallida) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Perdida o WHERE o.codPerdida = o.codPerdida";

        if (codTareaFallida != null) {
            SQL = SQL + " and o.codTareaFallida = (:codTareaFallida)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codTareaFallida != null) {
            q.setParameter("codTareaFallida",  codTareaFallida);
        }

        List<Perdida> entities = q.getResultList();
        em.close();

        return entities;

      }


   
//public static void main (String[] v) {
//        PerdidaController PerdidaController = new PerdidaController();
//        Perdida Perdida = new Perdida();
//        Perdida = PerdidaController.findById(Long.valueOf("1000"));
//        System.out.println(Perdida.getDescripcion());
//        PerdidaController.delete(Perdida);
//        };


 public ControllerResult createPerdida(Perdida perdida) throws RuntimeException {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

                // insertamos la perdida
                em.persist(perdida);

                /// actualizamos existencia en deposito
                if (perdida.getTaller().toString().equals("D")) {
                        ExistenciaController exCon = new ExistenciaController();
                        Deposito dep = perdida.getCodDeposito();
                        Existencia ex = exCon.getExistencia(null, perdida.getCodProducto().getCodProducto(), dep.getCodDeposito());
                        ex.setCantidadExistencia(BigInteger.valueOf(ex.getCantidadExistencia().longValue() - perdida.getCantidadPerdida()));
                        em.merge(ex);
                           /// insertamos el registro de perdida en deposito
                            String textoCabecera;
                            textoCabecera = "Movimiento en Deposito generado por Perdida en Produccion Cod: "+perdida.getCodPerdida().toString();

                            EntradaSalidaCabecera entSalCab = new EntradaSalidaCabecera();

                            entSalCab.setCodDeposito(dep);
                            entSalCab.setCodEmpleado(perdida.getCodEmpleado());
                            entSalCab.setCodEncargado(perdida.getCodEmpleado());
                            entSalCab.setFechaEntradaSalida(perdida.getFechaPerdida());
                            entSalCab.setCodPerdida(perdida.getCodPerdida().longValue());
                            entSalCab.setObservacion(textoCabecera);
                            entSalCab.setFechaAlta(new Date());
                            em.persist(entSalCab);

                             // Creacion del detalle Movimiento en Deposito
                            EntradaSalidaDetalle entSalDet = new EntradaSalidaDetalle();
                            Producto p = perdida.getCodProducto();
                            entSalDet.setCodEntradaSalida(em.merge(entSalCab));
                            entSalDet.setCodProducto(p);
                            entSalDet.setTipoEntradaSalida("S");
                            entSalDet.setCantidadEntSal(BigInteger.valueOf(perdida.getCantidadPerdida()));
                            entSalDet.setFechaAlta(perdida.getFechaPerdida());
                            em.persist(entSalDet);
                        //




                }
            
                /// actualizamos cantidades producidas
                if (perdida.getCodOrdenTrabjo() != null) {

                    OrdenTrabajo ot = perdida.getCodOrdenTrabjo();
                    if (perdida.getCodProducto().getCodTipoProducto().getDescripcion().equals("Terminado")) {
                            ot.setCantidadProducidaOt(BigInteger.valueOf(ot.getCantidadProducidaOt().longValue() - perdida.getCantidadPerdida()));
                            em.merge(ot);
                            /// ACTUALIZAMOS LAS CANTIDADES PRODUCIDAS DE LOS SEMITERMINADOS
                            List<OrdenTrabajoDetalle> detallesOT = new ArrayList();
                            detallesOT = ot.getOrdenTrabajoDetalleListList();
                            for (int i = 0; i < detallesOT.size(); i++) {
                                OrdenTrabajoDetalle ordenTrabajoDetalle = detallesOT.get(i);
                                ordenTrabajoDetalle.setCantidadReal(ordenTrabajoDetalle.getCantidadReal().longValue() - perdida.getCantidadPerdida());
                                ordenTrabajoDetalle.setFechaModif(new Date());
                                em.merge(ordenTrabajoDetalle);
                            
                                        /// ACTUALIZAMOS LAS CANTIDADES EFECTUADAS DE LAS TAREAS
                                        List<TareaAsignada> tareas = new ArrayList();
                                        tareas = ordenTrabajoDetalle.getTareaAsignadaListList();
                                        for (int j = 0; j < tareas.size(); j++) {
                                            TareaAsignada tareaAsignada = tareas.get(j);
                                            tareaAsignada.setCantidad(tareaAsignada.getCantidad() - perdida.getCantidadPerdida());
                                            tareaAsignada.setFechaModif(new Date());   
                                            em.merge(tareaAsignada);
                                        }
                               }
                               //// fin de ACTUALIZACIONES DE SEMIS Y TAREAS


                    }else if(perdida.getCodProducto().getCodTipoProducto().getDescripcion().equals("SemiTerminado")){

                                        List<OrdenTrabajoDetalle>  detalleOrdenTrabajoList = new ArrayList();
                                        detalleOrdenTrabajoList = ot.getOrdenTrabajoDetalleListList();
                                        OrdenTrabajoDetalle ordenTrabajoDetalle = null;
                                        for (int i = 0; i < detalleOrdenTrabajoList.size(); i++) {
                                        ordenTrabajoDetalle = detalleOrdenTrabajoList.get(i);
                                            if (ordenTrabajoDetalle.getCodProducto().getCodProducto().longValue()
                                                == perdida.getCodProducto().getCodProducto().longValue()) {
                                                    ordenTrabajoDetalle.setCantidadReal(ordenTrabajoDetalle.getCantidadReal() - perdida.getCantidadPerdida());
                                                    em.merge(ordenTrabajoDetalle);
                                                    List<TareaAsignada> tareasAs = new ArrayList();
                                                    tareasAs = ordenTrabajoDetalle.getTareaAsignadaListList();
                                                    for (int j = 0; j < tareasAs.size(); j++) {
                                                            TareaAsignada tareaAsignada = tareasAs.get(j);
                                                            /// ACTUALIZAMOS LAS CANTIDADES EFECTUADAS DE LAS TAREAS
                                                                tareaAsignada.setCantidad(tareaAsignada.getCantidad() - perdida.getCantidadPerdida());
                                                                tareaAsignada.setFechaModif(new Date());   
                                                                em.merge(tareaAsignada);
                                                    }
                                            break;// CORTAMOS EL BUCLEO DE RECORRIDO DE LOS DETALLES DE LA OT
                                            }
                                        }
                    }
                }
        
            tx.commit();
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error al cargar el nuevo Registro");
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

 
 public ControllerResult anular(Perdida perdida)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            perdida.setEstado("A");
            em.merge(perdida);

            /// actualizamos existencia en deposito
                if (perdida.getTaller().toString().equals("D")) {
                        ExistenciaController exCon = new ExistenciaController();
                        Deposito dep = perdida.getCodDeposito();
                        Existencia ex = exCon.getExistencia(null, perdida.getCodProducto().getCodProducto(), dep.getCodDeposito());
                        ex.setCantidadExistencia(BigInteger.valueOf(ex.getCantidadExistencia().longValue() + perdida.getCantidadPerdida()));
                        em.merge(ex);
                           /// anular el movimiento en deposito
                           EntradaSalidaCabeceraController entCabCont = new EntradaSalidaCabeceraController();
                           EntradaSalidaDetalleController entDetCont = new EntradaSalidaDetalleController();
                           List<EntradaSalidaDetalle> entSalDet = new ArrayList();

                           EntradaSalidaCabecera  entCab = entCabCont.getMovimientoPorPerdida(perdida.getCodPerdida().longValue());
                           entSalDet = entDetCont.getAllFiltered(entCab.getCodEntradaSalida().longValue(), null, null, null, null, null);
                         // Anulacion del detalle Movimiento en Deposito
                                for (int i = 0; i < entSalDet.size(); i++) {
                                    EntradaSalidaDetalle entradaSalidaDetalle = entSalDet.get(i);
                                    entradaSalidaDetalle.setEstado("A");
                                    entradaSalidaDetalle.setFechaModif(new Date());
                                    em.merge(entradaSalidaDetalle);
                                }
                        //

                        entCab.setEstado("A");
                        entCab.setFechaModif(new Date());
                        em.merge(entCab);
       
                }

                /// actualizamos cantidades producidas
                if (perdida.getCodOrdenTrabjo() != null) {

                    OrdenTrabajo ot = perdida.getCodOrdenTrabjo();
                    if (perdida.getCodProducto().getCodTipoProducto().getDescripcion().equals("Terminado")) {
                            ot.setCantidadProducidaOt(BigInteger.valueOf(ot.getCantidadProducidaOt().longValue() + perdida.getCantidadPerdida()));
                            em.merge(ot);

                            /// ACTUALIZAMOS LAS CANTIDADES PRODUCIDAS DE LOS SEMITERMINADOS
                            List<OrdenTrabajoDetalle> detallesOT = new ArrayList();
                            detallesOT = ot.getOrdenTrabajoDetalleListList();
                            for (int i = 0; i < detallesOT.size(); i++) {
                                OrdenTrabajoDetalle ordenTrabajoDetalle = detallesOT.get(i);
                                ordenTrabajoDetalle.setCantidadReal(ordenTrabajoDetalle.getCantidadReal().longValue() + perdida.getCantidadPerdida());
                                ordenTrabajoDetalle.setFechaModif(new Date());
                                em.merge(ordenTrabajoDetalle);

//                                        /// ACTUALIZAMOS LAS CANTIDADES EFECTUADAS DE LAS TAREAS
//                                        List<TareaAsignada> tareas = new ArrayList();
//                                        tareas = ordenTrabajoDetalle.getTareaAsignadaListList();
//                                        for (int j = 0; j < tareas.size(); j++) {
//                                            TareaAsignada tareaAsignada = tareas.get(j);
//                                            tareaAsignada.setCantidad(tareaAsignada.getCantidad() + perdida.getCantidadPerdida());
//                                            tareaAsignada.setFechaModif(new Date());
//                                            em.merge(tareaAsignada);
//                                        }
                               }
                               //// fin de ACTUALIZACIONES DE SEMIS

                    }else if(perdida.getCodProducto().getCodTipoProducto().getDescripcion().equals("SemiTerminado")){

                                        List<OrdenTrabajoDetalle>  detalleOrdenTrabajoList = new ArrayList();
                                        detalleOrdenTrabajoList = ot.getOrdenTrabajoDetalleListList();
                                        OrdenTrabajoDetalle ordenTrabajoDetalle = null;
                                        for (int i = 0; i < detalleOrdenTrabajoList.size(); i++) {
                                        ordenTrabajoDetalle = detalleOrdenTrabajoList.get(i);
                                            if (ordenTrabajoDetalle.getCodProducto().getCodProducto().longValue()
                                                == perdida.getCodProducto().getCodProducto().longValue()) {
                                                    ordenTrabajoDetalle.setCantidadReal(ordenTrabajoDetalle.getCantidadReal() + perdida.getCantidadPerdida());
                                                    em.merge(ordenTrabajoDetalle);
                                                
//                                                    List<TareaAsignada> tareasAs = new ArrayList();
//                                                    tareasAs = ordenTrabajoDetalle.getTareaAsignadaListList();
//                                                    for (int j = 0; j < tareasAs.size(); j++) {
//                                                            TareaAsignada tareaAsignada = tareasAs.get(j);
//                                                            /// ACTUALIZAMOS LAS CANTIDADES EFECTUADAS DE LAS TAREAS
//                                                                tareaAsignada.setCantidad(tareaAsignada.getCantidad() + perdida.getCantidadPerdida());
//                                                                tareaAsignada.setFechaModif(new Date());
//                                                                em.merge(tareaAsignada);
//                                                    }
                                                    
                                                break;
                                            }
                                        }
                    }
                }
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro actualizado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al anular la Perdida");
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
