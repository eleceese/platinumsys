/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Parametros;

/**
 *
 * @author Martin
 */
public class ParametroController extends AbstractJpaDao<Parametros> {

    public ParametroController() {
        super();
    }


    @Override
    public Parametros findById(Long id) {
                return (Parametros) this.findById(Parametros.class, id);
    }

       @Override
    public List<Parametros> getAll(String orderBy) {
        return this.getAll(Parametros.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de Parametross que cumplen con la condicion de busqueda
     */
    public List<Parametros> getParametross(String codigo, String descripcion) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Parametros o WHERE o.codParametros = o.codParametros";

        if (codigo != null && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codParametros) like UPPER(:codigo)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.nombreParametros) like UPPER(:descripcion)";
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
        List<Parametros> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

}   
