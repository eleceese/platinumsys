/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.SolicitudInterna;

/**
 *
 * @author Martin
 */
public class SolicitudInternaController extends AbstractJpaDao<SolicitudInterna> {

    public SolicitudInternaController() {
        super();
    }


    @Override
    public SolicitudInterna findById(Long id) {
                return (SolicitudInterna) this.findById(SolicitudInterna.class, id);
    }

       @Override
    public List<SolicitudInterna> getAll(String orderBy) {
        return this.getAll(SolicitudInterna.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de SolicitudInternas que cumplen con la condicion de busqueda
     */
    public List<SolicitudInterna> getSolicitudInternas(String producto, Date fechaDesde, Date fechaHasta, String estado) {
        //Armamos el sql String
        String SQL = "SELECT o FROM SolicitudInterna o WHERE o.codSolicitud = o.codSolicitud";

        if (producto != null && !producto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.descripcion) like UPPER(:producto)";
        }

        if (fechaDesde != null) {
            SQL = SQL + " and o.fecha >=:fechaDesde  ";
        }

        if (fechaHasta != null) {
            SQL = SQL + " and o.fecha <= :fechaHasta ";
        }

        if (estado != null && !estado.trim().equals("")) {
            SQL = SQL + " and upper(o.estado) = upper(:estado) ";
        }

        //Order by
        SQL = SQL + " order by o.fecha desc ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (producto != null && !producto.equals("")) {
            q.setParameter("producto", "%" + producto + "%");
        }

        if (fechaDesde != null ) {
            q.setParameter("fechaDesde", fechaDesde );
        }

        if (fechaHasta != null ) {
            q.setParameter("fechaHasta", fechaHasta );
        }

        if (estado != null && !estado.trim().equals("")) {
            q.setParameter("estado", estado );
        }

        //Realizamos la busqueda
        List<SolicitudInterna> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

}   
