/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Seccion;

/**
 *
 * @author Martin Jara
 */
public class SeccionController extends AbstractJpaDao<Seccion> {

    public SeccionController() {
        super();
    }

    @Override
    public Seccion findById(Long id) {
        return (Seccion) this.findById(Seccion.class, id);
    }

    @Override
    public List<Seccion> getAll(String orderBy) {
        return this.getAll(Seccion.class, orderBy);
    }

    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de Seccions que cumplen con la condicion de busqueda
     */
    public List<Seccion> getSeccions(String codigo, String descripcion) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Seccion o WHERE o.codSeccion = o.codSeccion";

        if (codigo != null && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codSeccion) like UPPER(:codigo)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.nombreSeccion) like UPPER(:descripcion)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (codigo != null && !codigo.equals("")) {
            q.setParameter("codigo", "%" + codigo + "%");
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%" + descripcion + "%");
        }

        //Realizamos la busqueda
        List<Seccion> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }
}
