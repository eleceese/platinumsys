/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.TipoProducto;

/**
 *
 * @author FerBoy
 */
public class TipoProductoController extends AbstractJpaDao<TipoProducto> {

    public boolean existe(String descripcion){

        String SQL = "SELECT o FROM TipoProducto o WHERE o.descripcion = :descripcion";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("descripcion", descripcion);

        List<TipoProducto> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}

    }


    public TipoProductoController() {
        super();
    }


    @Override
    public TipoProducto findById(Long id) {
                return (TipoProducto) this.findById(TipoProducto.class, id);
    }

    @Override
    public List<TipoProducto> getAll(String orderBy) {
        return this.getAll(TipoProducto.class, orderBy);
     }

    public List<TipoProducto> getAllFiltered(String codigo, String descripcion) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM TipoProducto o WHERE o.codTipoProducto = o.codTipoProducto";

        if (codigo != null && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codTipoProducto) = upper(:codigo)";
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

        List<TipoProducto> entities = q.getResultList();
        em.close();

        return entities;

      }


}
