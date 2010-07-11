/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.HistoricoPrecio;
import py.com.platinum.entity.Producto;

/**
 *
 * @author Martin
 */
public class HistoricoPrecioController extends AbstractJpaDao<HistoricoPrecio> {

    public HistoricoPrecioController() {
        super();
    }

    @Override
    public HistoricoPrecio findById(Long id) {
        return (HistoricoPrecio) this.findById(HistoricoPrecio.class, id);
    }

    @Override
    public List<HistoricoPrecio> getAll(String orderBy) {
        return this.getAll(HistoricoPrecio.class, orderBy);
    }


    public List<HistoricoPrecio> getHistoricos(Long codProducto) {
        //Armamos el sql String
        String SQL = "SELECT o FROM HistoricoPrecio o WHERE o.codHistoricoPrecio = o.codHistoricoPrecio";

        if (codProducto != null) {
            SQL = SQL + " and o.codProducto.codProducto = :codProducto";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (codProducto != null ) {
            q.setParameter("codProducto", codProducto);
        }

        //Realizamos la busqueda
        List<HistoricoPrecio> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }
  

}   
