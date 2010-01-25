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
import py.com.platinum.entity.Comision;

/**
 *
 * @author Martin
 */
public class ComisionController extends AbstractJpaDao<Comision> {

    public ComisionController() {
        super();
    }


    @Override
    public Comision findById(Long id) {
                return (Comision) this.findById(Comision.class, id);
    }

       @Override
    public List<Comision> getAll(String orderBy) {
        return this.getAll(Comision.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de Comisions que cumplen con la condicion de busqueda
     */
    public List<Comision> getComisions(String producto, Date fecDesde, Date fecHasta) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Comision o WHERE o.codComision = o.codComision";

        if (producto != null && !producto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.descripcion) like UPPER(:producto)";
        }

        if (fecDesde != null) {
            SQL = SQL + " and o.fecInicial >= :fecDesde ";
        }

        if (fecHasta != null) {
            SQL = SQL + " and o.fecFinal <= :fecHasta ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (producto != null && !producto.equals("")) {
            q.setParameter("producto", "%" + producto + "%");
        }

        if (fecDesde != null) {
            q.setParameter("fecDesde", fecDesde);
        }

        if (fecHasta != null) {
            q.setParameter("fecHasta", fecHasta);
        }

        //Realizamos la busqueda
        List<Comision> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

}   
