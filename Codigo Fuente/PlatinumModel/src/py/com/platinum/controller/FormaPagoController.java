/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.FormaPago;

/**
 *
 * @author Martin
 */
public class FormaPagoController extends AbstractJpaDao<FormaPago> {

    public FormaPagoController() {
        super();
    }


    @Override
    public FormaPago findById(Long id) {
                return (FormaPago) this.findById(FormaPago.class, id);
    }

       @Override
    public List<FormaPago> getAll(String orderBy) {
        return this.getAll(FormaPago.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de FormaPagos que cumplen con la condicion de busqueda
     */
    public List<FormaPago> getFormaPagos(String banco, String descripcion) {
        //Armamos el sql String
        String SQL = "SELECT o FROM FormaPago o WHERE o.codFormaPago = o.codFormaPago";

        if (banco != null && !banco.equals("")) {
            SQL = SQL + " and UPPER(o.codBanco.nombreBanco) like UPPER(:banco)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.nombreFormaPago) like UPPER(:descripcion)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (banco != null && !banco.equals("")) {
            q.setParameter("banco", "%" + banco + "%");
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%" + descripcion + "%");
        }

        //Realizamos la busqueda
        List<FormaPago> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

}   
