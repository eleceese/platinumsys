/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.UnidadMedida;

/**
 *
 * @author FerBoy
 */
public class UnidadMedidaController extends AbstractJpaDao<UnidadMedida> {

    public boolean existe(String descripcion){

        String SQL = "SELECT o FROM UnidadMedida o WHERE o.descripcion = :descripcion";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("descripcion", descripcion);

        List<UnidadMedida> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}

    }


    public UnidadMedidaController() {
        super();
    }


    @Override
    public UnidadMedida findById(Long id) {
                return (UnidadMedida) this.findById(UnidadMedida.class, id);
    }

    @Override
    public List<UnidadMedida> getAll(String orderBy) {
        return this.getAll(UnidadMedida.class, orderBy);
     }

    public List<UnidadMedida> getAllFiltered(String codigo, String descripcion) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM UnidadMedida o WHERE o.codUnidadMedida = o.codUnidadMedida";

        if (codigo != null && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codUnidadMedida) = UPPER(:codigo)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.descripcion) like upper(:descripcion)";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codigo != null  && !codigo.equals("")) {
            q.setParameter("codigo", codigo);
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%"+descripcion+"%");
        }

        List<UnidadMedida> entities = q.getResultList();
        em.close();

        return entities;

      }




}
