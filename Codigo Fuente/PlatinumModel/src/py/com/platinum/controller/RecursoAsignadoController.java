/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.RecursoAsignado;

/**
 *
 * @author Martin
 */
public class RecursoAsignadoController extends AbstractJpaDao<RecursoAsignado> {

    public RecursoAsignadoController() {
        super();
    }


    @Override
    public RecursoAsignado findById(Long id) {
                return (RecursoAsignado) this.findById(RecursoAsignado.class, id);
    }

       @Override
    public List<RecursoAsignado> getAll(String orderBy) {
        return this.getAll(RecursoAsignado.class, orderBy);
     }


    public List<RecursoAsignado> getAllFiltered(Long codOrdenTrabajoDet, Long codRecurso, String nombreRecurso) {
        
         String SQL = "SELECT o FROM RecursoAsignado o WHERE o.codRecurso = o.codRecurso";

        if (codOrdenTrabajoDet != null) {
            SQL = SQL + " and o.codOrdenTrabDet.codOrdenTrabajoDet = :codOrdenTrabajoDet ";

        }

        if (codRecurso != null) {
            SQL = SQL + " and o.codProducto.codProducto = :codRecurso ";
        }

         if (nombreRecurso != null && !nombreRecurso.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.descripcion) like upper(:nombreRecurso)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);


        if (codOrdenTrabajoDet != null) {
            q.setParameter("codOrdenTrabajoDet", codOrdenTrabajoDet);
        }


        if (codRecurso != null) {
            q.setParameter("codRecurso", codRecurso);
        }

        if (nombreRecurso != null && !nombreRecurso.equals("")) {
            q.setParameter("nombreRecurso", "%"+nombreRecurso+"%");
        }
       
        List<RecursoAsignado> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

     }



     public RecursoAsignado getRecursoPorOt(Long codOrdenTrabajoDet, Long codRecurso) {

         String SQL = "SELECT o FROM RecursoAsignado o WHERE o.codRecurso = o.codRecurso";

        if (codOrdenTrabajoDet != null) {
            SQL = SQL + " and o.codOrdenTrabDet.codOrdenTrabajoDet = :codOrdenTrabajoDet ";
        }

        if (codRecurso != null) {
            SQL = SQL + " and o.codProducto.codProducto = :codRecurso ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);


        if (codOrdenTrabajoDet != null) {
            q.setParameter("codOrdenTrabajoDet", codOrdenTrabajoDet);
        }

        if (codRecurso != null) {
            q.setParameter("codRecurso", codRecurso);
        }


        RecursoAsignado r = new RecursoAsignado();
        r = (RecursoAsignado) q.getSingleResult();
        em.close();

        //retornamos la lista
        return r;

     }


     public RecursoAsignado getRecursoPorEquiv(Long codOrdenTrabajoDet, Long codRecurso) {

         String SQL = "SELECT o FROM RecursoAsignado o , " +
                 "Equivalencia e " +
                 "WHERE e.codProductoFin.codProducto = :codRecurso " +
                 "and o.codOrdenTrabDet.codOrdenTrabajoDet = :codOrdenTrabajoDet " +
                 "and o.codProducto.codProducto = e.codProductoGen.codProducto ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);


        if (codOrdenTrabajoDet != null) {
            q.setParameter("codOrdenTrabajoDet", codOrdenTrabajoDet);
        }

        if (codRecurso != null) {
            q.setParameter("codRecurso", codRecurso);
        }

        RecursoAsignado r = new RecursoAsignado();

         try {
             r = (RecursoAsignado) q.getSingleResult();
         } catch (NoResultException e) {
             r = null;
         }

        em.close();

        //retornamos la lista
        return r;

     }

public static void main(String []args){

//   RecursoAsignado recursoAsignado = new RecursoAsignadoController().getRecursoPorEquiv(Long.valueOf("161"), Long.valueOf("1096"));
   List<RecursoAsignado> recursosAsignados = new RecursoAsignadoController().getAll("codRecurso");
   System.out.println("***********************************************");
   System.out.println(recursosAsignados.size());


}



}   
