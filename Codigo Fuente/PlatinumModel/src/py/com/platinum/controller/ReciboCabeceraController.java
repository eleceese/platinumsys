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
import py.com.platinum.entity.ReciboCabecera;

/**
 *
 * @author Martin
 */
public class ReciboCabeceraController extends AbstractJpaDao<ReciboCabecera> {

    public ReciboCabeceraController() {
        super();
    }


    @Override
    public ReciboCabecera findById(Long id) {
                return (ReciboCabecera) this.findById(ReciboCabecera.class, id);
    }

       @Override
    public List<ReciboCabecera> getAll(String orderBy) {
        return this.getAll(ReciboCabecera.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de ReciboCabeceras que cumplen con la condicion de busqueda
     */
    public List<ReciboCabecera> getReciboCabeceras(String nroRecibo, String cliente, Date fecha) {
        //Armamos el sql String
        String SQL = "SELECT o FROM ReciboCabecera o WHERE o.codRecibo = o.codRecibo ";

        if (nroRecibo != null && !nroRecibo.equals("")) {
            SQL = SQL + " and UPPER(o.numeroRecibo) like UPPER(:nroRecibo)";
        }

        if (cliente != null && !cliente.equals("")) {
            SQL = SQL + " and UPPER( CONCAT(CONCAT(o.codCliente.apellidoCliente, '%'), o.codCliente.nombreCliente)) like UPPER(:cliente) ";
        }

        if (fecha != null) {
            SQL = SQL + " and o.fecha = :fecha ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (nroRecibo != null && !nroRecibo.equals("")) {
            q.setParameter("nroRecibo", "%" + nroRecibo + "%");
        }

        if (cliente != null && !cliente.equals("")) {
            q.setParameter("cliente", "%" + cliente + "%");
        }

        if (fecha != null) {
            q.setParameter("fecha", fecha );
        }

        //Realizamos la busqueda
        List<ReciboCabecera> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

}   
