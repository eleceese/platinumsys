/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.TareaAsignada;

/**
 *
 * @author Martin
 */
public class TareaAsignadaController extends AbstractJpaDao<TareaAsignada> {

    public TareaAsignadaController() {
        super();
    }


    @Override
    public TareaAsignada findById(Long id) {
                return (TareaAsignada) this.findById(TareaAsignada.class, id);
    }

       @Override
    public List<TareaAsignada> getAll(String orderBy) {
        return this.getAll(TareaAsignada.class, orderBy);
     }


    public List<TareaAsignada> getAllFiltered(Long codOrdenTrabajoDet, Long codTarea, String nombreTarea) {
        
         String SQL = "SELECT o FROM TareaAsignada o WHERE o.codTareaAsignada = o.codTareaAsignada";

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
       
        List<TareaAsignada> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

     }


    public static void main(String []args){

//   RecursoAsignado recursoAsignado = new RecursoAsignadoController().getRecursoPorEquiv(Long.valueOf("161"), Long.valueOf("1096"));
   List<TareaAsignada> tareasAsignadas = new TareaAsignadaController().getAll("codTarea");
   System.out.println("***********************************************");
   System.out.println(tareasAsignadas.size());


}


}   
