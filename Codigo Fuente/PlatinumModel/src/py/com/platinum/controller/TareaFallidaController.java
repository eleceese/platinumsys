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
import py.com.platinum.entity.Perdida;
import py.com.platinum.entity.TareaAsignada;
import py.com.platinum.entity.TareaFallida;

/**
 *
 * @author Martin
 */
public class TareaFallidaController extends AbstractJpaDao<TareaFallida> {

    public TareaFallidaController() {
        super();
    }


    @Override
    public TareaFallida findById(Long id) {
                return (TareaFallida) this.findById(TareaFallida.class, id);
    }

       @Override
    public List<TareaFallida> getAll(String orderBy) {
        return this.getAll(TareaFallida.class, orderBy);
     }


    public List<TareaFallida> getAllFiltered(Long codOrdenTrabajoDet, Long codTarea, String nombreTarea) {
        
         String SQL = "SELECT o FROM TareaFallida o WHERE o.codTareaFallida = o.codTareaFallida";

        if (codOrdenTrabajoDet != null) {
            SQL = SQL + " and o.codDetOrdenTrabaj.codOrdenTrabajoDet = :codOrdenTrabajoDet ";
        }

        if (codTarea != null) {
            SQL = SQL + " and o.codTarea.codTarea = :codTarea ";
        }

         if (nombreTarea != null && !nombreTarea.equals("")) {
            SQL = SQL + " and UPPER(o.codTarea.nombreTarea) like upper(:nombreTarea)";
        }

             
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);


        if (codOrdenTrabajoDet != null) {
            q.setParameter("codOrdenTrabajoDet", codOrdenTrabajoDet);
        }


        if (codTarea != null) {
            q.setParameter("codTarea", codTarea);
        }

        if (nombreTarea != null && !nombreTarea.equals("")) {
            q.setParameter("nombreTarea", "%"+nombreTarea+"%");
        }
       
        List<TareaFallida> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

     }
    public List<TareaFallida> getAllFilteredFil(Long codOrdenTrabajo, Long codTarea, String nombreTarea,Long codResponsable, Date fecha1, Date fecha2) {

         String SQL = "SELECT o FROM TareaFallida o WHERE o.codTareaFallida = o.codTareaFallida";

        if (codOrdenTrabajo != null) {
            SQL = SQL + " and o.codTareaAsignada.codDetOrdenTrabaj.codOrdenTrabajo.codOrdenTrabjo = :codOrdenTrabajo ";
        }
        if (codResponsable != null) {
            SQL = SQL + " and o.codEmpleado.codEmpleado = :codResponsable ";
        }
        if (fecha1 != null) {
            SQL = SQL + " and o.fecha >= :fecha1";
        }
        if (fecha2 != null) {
            SQL = SQL + " and o.fecha <= :fecha2";
        }
        if (codTarea != null) {
            SQL = SQL + " and o.codTarea.codTarea = :codTarea ";
        }
        if (nombreTarea != null && !nombreTarea.equals("")) {
            SQL = SQL + " and UPPER(o.codTarea.nombreTarea) like upper(:nombreTarea)";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);


        if (codOrdenTrabajo != null) {
            q.setParameter("codOrdenTrabajo", codOrdenTrabajo);
        }
        if (codResponsable != null) {
            q.setParameter("codResponsable", codResponsable);
        }

        if (codOrdenTrabajo != null) {
            q.setParameter("codResponsable", codResponsable);
        }
        if (codTarea != null) {
            q.setParameter("codTarea", codTarea);
        }
        if (fecha1 != null) {
            q.setParameter("fecha1", fecha1);
        }
        if (fecha2 != null) {
            q.setParameter("fecha2", fecha2);
        }

       

        List<TareaFallida> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

     }


    public static void main(String []args){

//   RecursoAsignado recursoAsignado = new RecursoAsignadoController().getRecursoPorEquiv(Long.valueOf("161"), Long.valueOf("1096"));
   List<TareaFallida> tareasAsignadas = new TareaFallidaController().getAll("codTarea");
   System.out.println("***********************************************");
   System.out.println(tareasAsignadas.size());


}


    public ControllerResult createCabDet(TareaFallida tareaFallida, Perdida[] per) throws RuntimeException {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(tareaFallida);

            // SE CREAN LOS REGISTROS DE PERDIDAS
            for (int i = 0; i < per.length; i++) {
                Perdida perdida = per[i];
                    TareaFallida ta = em.merge(tareaFallida);
                 perdida.setCodTareaFallida(ta.getCodTareaFallida().longValue());
                 perdida.setObservacion("Perdida Generada por fallo de tareas "+ta.getCodTareaAsignada().getCodTarea().getNombreTarea().toString());
                 perdida.setCodOrdenTrabjo(ta.getCodTareaAsignada().getCodDetOrdenTrabaj().getCodOrdenTrabajo());
                 em.persist(em.merge(perdida));
            }

            // SE ACTUALIZAN LAS CANTIDADES FALLIDAS EN LA OT
                TareaAsignada tas = tareaFallida.getCodTareaAsignada();
                    long tareasFallida = tareaFallida.getCantidad().longValue();
                    tas.setCantidadFallida(tas.getCantidadFallida().longValue() + tareasFallida);
//                    tas.setCantidadReal(tas.getCantidadReal().longValue() - tareasFallida);

                    em.merge(tas);
            tx.commit();
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error en la operacion");
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

   
  public List<Perdida> getAllPerdidasTarea(Long codTareaFallida) {
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

  public ControllerResult deleteTareaPerdida(TareaFallida tareFa,Perdida[]per) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            /// BORRAR LAS PERDIDAS DE LAS TAREAS
            if (per != null) {
                for (int i = 0; i < per.length; i++) {
                    Perdida perdida = per[i];
                    em.remove(em.merge(perdida));
                }
            }

            /// ACTUALIZAR LAS CANTIDADES DE TAREAS EFECTUADAS
            TareaAsignada tas = tareFa.getCodTareaAsignada();
                    long tareasFallida = tareFa.getCantidad().longValue();
                    tas.setCantidadFallida(tas.getCantidadFallida().longValue() - tareasFallida);
//                    tas.setCantidadReal(tas.getCantidadReal().longValue() + tareasFallida);
                    em.merge(tas);

            em.remove(em.merge(tareFa));
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro eliminado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error al eliminar el registro");
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
