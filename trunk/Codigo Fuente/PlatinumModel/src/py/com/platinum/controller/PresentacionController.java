/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Presentacion;

/**
 *
 * @author FerBoy
 */
public class PresentacionController extends AbstractJpaDao<Presentacion> {

    public PresentacionController() {
        super();
    }


    @Override
    public Presentacion findById(Long id) {
                return (Presentacion) this.findById(Presentacion.class, id);
    }

    @Override
    public List<Presentacion> getAll(String orderBy) {
        return this.getAll(Presentacion.class, orderBy);
     }

    public List<Presentacion> getPresentaciones(String codPresentacion, String descripcion) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Presentacion o WHERE o.codPresentacion = o.codPresentacion ";

        if (codPresentacion  != null && !codPresentacion .equals("")) {
            SQL = SQL + " and UPPER(o.codPresentacion) like UPPER(:codPresentacion)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.descripcion) like UPPER(:descripcion)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (codPresentacion  != null && !codPresentacion .equals("")) {
            q.setParameter("codPresentacion", codPresentacion);
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%" + descripcion + "%");
        }

        //Realizamos la busqueda
        List<Presentacion> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

public boolean existe(String descripcion){

        String SQL = "SELECT o FROM Presentacion o WHERE UPPER(o.descripcion) = UPPER(:descripcion)";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("descripcion", descripcion);

        List<Presentacion> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


}
}
