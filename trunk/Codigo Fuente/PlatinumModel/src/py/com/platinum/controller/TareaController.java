/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Tarea;

/**
 *
 * @author FerBoy
 */
public class TareaController extends AbstractJpaDao<Tarea> {

    public TareaController() {
        super();
    }



    @Override
    public Tarea findById(Long id) {
                return (Tarea) this.findById(Tarea.class, id);
    }

       @Override
    public List<Tarea> getAll(String orderBy) {
        return this.getAll(Tarea.class, orderBy);
     }

        public boolean existe(String nombre){

        String SQL = "SELECT o Tarea o WHERE o.nombreTarea = :nombre";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("nombre", nombre);

        List<Tarea> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}

    }

        public List<Tarea> getAllFiltered(String codigo, String nombre) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Tarea o WHERE o.codTarea = o.codTarea";

        if (codigo != null && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codTarea) = upper(:codigo)";
        }

        if (nombre != null && !nombre.equals("")) {
            SQL = SQL + " and UPPER(o.nombreTarea) like upper(:nombre)";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codigo != null  && !codigo.equals("")) {
            q.setParameter("codigo", codigo);
        }

        if (nombre != null && !nombre.equals("")) {
            q.setParameter("nombre", "%"+nombre+"%");
        }

        List<Tarea> entities = q.getResultList();
        em.close();

        return entities;

      }
}
