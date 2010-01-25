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
import py.com.platinum.entity.FacturaCompraCab;

/**
 *
 * @author Martin
 */
public class FacturaCompraCabController extends AbstractJpaDao<FacturaCompraCab> {

    public FacturaCompraCabController() {
        super();
    }


    @Override
    public FacturaCompraCab findById(Long id) {
                return (FacturaCompraCab) this.findById(FacturaCompraCab.class, id);
    }

       @Override
    public List<FacturaCompraCab> getAll(String orderBy) {
        return this.getAll(FacturaCompraCab.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param nroFactura
     * @param proveedor
     *
     * @return lista de FacturaCompraCabs que cumplen con la condicion de busqueda
     */
    public List<FacturaCompraCab> getFacturaCompraCab(String nroFactura, String proveedor, Date fechaFactura) {
        //Armamos el sql String
        String SQL = "SELECT o FROM FacturaCompraCab o WHERE o.codFacComCab = o.codFacComCab ";

        if (nroFactura != null && !nroFactura.equals("")) {
            SQL = SQL + " and UPPER(o.nroFactura) like UPPER(:nroFactura) ";
        }

        if (proveedor != null && !proveedor.equals("")) {
            SQL = SQL + " and UPPER(o.codProveedor.nombreProveedor) like UPPER(:proveedor) ";
        }

        if (fechaFactura != null ) {
            SQL = SQL + " and o.fecha = :fechaFactura ";
        }

        //Order By
        SQL = SQL + " ORDER BY o.nroFactura ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (nroFactura != null && !nroFactura.equals("")) {
            q.setParameter("nroFactura", "%" + nroFactura + "%");
        }

        if (proveedor != null && !proveedor.equals("")) {
            q.setParameter("proveedor", "%" + proveedor + "%");
        }

        if (fechaFactura != null) {
            q.setParameter("fechaFactura", fechaFactura);
        }

        //Realizamos la busqueda
        List<FacturaCompraCab> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

}   
