/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Ciudad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author Martin
 */
public class CiudadController extends AbstractJpaDao<Ciudad> {

    public CiudadController() {
        super();
    }


    @Override
    public Ciudad findById(Long id) {
                return (Ciudad) this.findById(Ciudad.class, id);
    }

       @Override
    public List<Ciudad> getAll(String orderBy) {
        return this.getAll(Ciudad.class, orderBy);
     }
 public List<Ciudad> getCiudades(String nombre) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Ciudad o WHERE o.codciudad = o.codciudad";

        if (nombre != null && !nombre.equals("")) {
            SQL = SQL + " and UPPER(o.nombreciudad) like UPPER(:nombre)";
        }
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (nombre != null && !nombre.equals("")) {
            q.setParameter("nombre", "%" + nombre + "%");
        }

        //Realizamos la busqueda
        List<Ciudad> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }


}   
