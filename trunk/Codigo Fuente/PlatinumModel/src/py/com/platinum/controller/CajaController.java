/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Caja;

/**
 *
 * @author Martin
 */
public class CajaController extends AbstractJpaDao<Caja> {

    public CajaController() {
        super();
    }


    @Override
    public Caja findById(Long id) {
                return (Caja) this.findById(Caja.class, id);
    }

       @Override
    public List<Caja> getAll(String orderBy) {
        return this.getAll(Caja.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de Cajas que cumplen con la condicion de busqueda
     */
    public List<Caja> getCajas(String codigo, String descripcion) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Caja o WHERE o.codCaja = o.codCaja";

        if (codigo != null && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codCaja) like UPPER(:codigo)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.nombreCaja) like UPPER(:descripcion)";
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
        List<Caja> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

    public List<Caja> getCajasAbiertas() {
        //Armamos el sql String
        String SQL = " SELECT o         " +
                     "   FROM Caja o    " +
                     "  WHERE o.codCaja in (select DISTINCT h.codCaja.codCaja from HabilitacionCaja h where h.estado = 'A' )";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Realizamos la busqueda
        List<Caja> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;
    }

    public List<Caja> getCajasCerradas() {
        //Armamos el sql String
        String SQL = " SELECT o         " +
                     "   FROM Caja o    " +
                     "  WHERE o.codCaja not in (select DISTINCT h.codCaja.codCaja from HabilitacionCaja h where h.estado = 'A' )";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Realizamos la busqueda
        List<Caja> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;
    }

}   
