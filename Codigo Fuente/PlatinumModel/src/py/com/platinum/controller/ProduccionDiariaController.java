/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.ProduccionDiaria;
import py.com.platinum.entity.TareaAsignada;

/**
 *
 * @author FerBoy
 */
public class ProduccionDiariaController extends AbstractJpaDao <ProduccionDiaria> {

    public boolean existe(String codProduccionDiaria){

        String SQL = "SELECT o FROM ProduccionDiaria o WHERE o.codProduccionDiaria = :codProduccionDiaria";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codProduccionDiaria", codProduccionDiaria);

        List<ProduccionDiaria> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public ProduccionDiariaController() {
        super();
    }

    @Override
    public ProduccionDiaria findById(Long id) {
        return (ProduccionDiaria) this.findById(ProduccionDiaria.class, id);
    }

    @Override
    public List<ProduccionDiaria> getAll(String orderBy) {
        return this.getAll(ProduccionDiaria.class, orderBy);
    }

    public List<ProduccionDiaria> getAllFiltered(Long codProduccionDiaria, Long codTareaAsignada,Long codDetOrdenTrabaj, String descTarea) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM ProduccionDiaria o WHERE o.codProduccionDiaria = o.codProduccionDiaria";

        if (codProduccionDiaria != null) {
            SQL = SQL + " and o.codProduccionDiaria = :codProduccionDiaria";
        }

        if (codTareaAsignada != null) {
            SQL = SQL + " and o.codTareaAsignada.codTareaAsignada = :codTareaAsignada";
        }
        if (codDetOrdenTrabaj != null) {
            SQL = SQL + " and o.codTareaAsignada.codDetOrdenTrabaj.codOrdenTrabajoDet = :codDetOrdenTrabaj";
        }

        
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codProduccionDiaria != null) {
            q.setParameter("codProduccionDiaria", codProduccionDiaria);
        }

        if (codTareaAsignada != null) {
            q.setParameter("codTareaAsignada", codTareaAsignada);
        }

        if (codDetOrdenTrabaj != null) {
            q.setParameter("codDetOrdenTrabaj", codDetOrdenTrabaj);
        }

        List<ProduccionDiaria> entities = q.getResultList();
        em.close();

        return entities;

      }

    public static void main (String[] v) {
        ProduccionDiariaController controller = new ProduccionDiariaController();
        List<ProduccionDiaria> producciones = new ArrayList();
        producciones = controller.getAllFiltered(null, null, Long.valueOf("92"), null);
        
        System.out.println("**************");
        System.out.println(producciones.size());
        
        };



    @Override
        public ControllerResult create(ProduccionDiaria produccionDiaria) throws RuntimeException {
        TareaAsignada tareaAsignada = new TareaAsignada();
        TareaAsignadaController tareaAsignadaController = new TareaAsignadaController();
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            /// Guardamos la produccion
            em.persist(produccionDiaria);

            ProduccionDiaria produccion = produccionDiaria;
            tareaAsignada = tareaAsignadaController.findById(produccionDiaria.getCodTareaAsignada().getCodTareaAsignada());
            tareaAsignada.setCantidadReal(tareaAsignada.getCantidadReal()+produccion.getCantidad());

            /// actualizamos la cantidad producida de la tarea
            em.merge(tareaAsignada);

            /// si es una tarea de finalizacion, debemos sumar a la cantidad producida del semiterminado.
            if (tareaAsignada.getTareaFin()!= null && tareaAsignada.getTareaFin().equals("S")) {
                OrdenTrabajoDetalle otDet = new OrdenTrabajoDetalle();
                OrdenTrabajoDetalleController ordenTrabajoDetalleController = new OrdenTrabajoDetalleController();
                otDet = ordenTrabajoDetalleController.findById(tareaAsignada.getCodDetOrdenTrabaj().getCodOrdenTrabajoDet());
                otDet.setCantidadReal(otDet.getCantidadReal()+produccion.getCantidad());

                /// actualizamos la cantidad producida del semiterminado
                em.merge(otDet);

                /// si es un semiterminado de finalizacion, debemos sumar a la cantidad producida del producto final.
                if (otDet.getSemiFin() != null && otDet.getSemiFin().equals("S")) {
                    OrdenTrabajo ot = new OrdenTrabajo();
                    OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();
                    ot = ordenTrabajoCabeceraController.findById(otDet.getCodOrdenTrabajo().getCodOrdenTrabjo());

                    long bCant;
                    bCant = Long.valueOf(ot.getCantidadProducidaOt().toString()) + produccion.getCantidad();
                    ot.setCantidadProducidaOt(BigInteger.valueOf(bCant));

                    /// actualizamos la cantidad producida del producto final
                    em.merge(ot);

                }
            }


            tx.commit();
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al insertar el registro");
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



}
