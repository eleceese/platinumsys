/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.OrdenTrabajoDetalle;

/**
 *
 * @author Martin
 */
public class OrdenTrabajoDetalleController extends AbstractJpaDao<OrdenTrabajoDetalle> {

    public OrdenTrabajoDetalleController() {
        super();
    }


    @Override
    public OrdenTrabajoDetalle findById(Long id) {
                return (OrdenTrabajoDetalle) this.findById(OrdenTrabajoDetalle.class, id);
    }

       @Override
    public List<OrdenTrabajoDetalle> getAll(String orderBy) {
        return this.getAll(OrdenTrabajoDetalle.class, orderBy);
     }


    public List<OrdenTrabajoDetalle> getAllFiltered(Long codOrdenTrabajo, Long codProducto, String descProducto) {
        
         String SQL = "SELECT o FROM OrdenTrabajoDetalle o WHERE o.codOrdenTrabajoDet = o.codOrdenTrabajoDet";

        if (codOrdenTrabajo != null) {
            SQL = SQL + " and o.codOrdenTrabajo.codOrdenTrabjo = :codOrdenTrabajo ";
        }

         if (descProducto != null && !descProducto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.descripcion) like upper(:descProducto)";
        }


        if (codProducto != null) {
            SQL = SQL + " and o.codProducto.codProducto = :codProducto ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);


        if (codOrdenTrabajo != null) {
            q.setParameter("codOrdenTrabajo", codOrdenTrabajo);
        }

        if (descProducto != null && !descProducto.equals("")) {
            q.setParameter("descProducto", "%"+descProducto+"%");
        }
        if (codProducto != null) {
            q.setParameter("codProducto", codProducto);
        }

        List<OrdenTrabajoDetalle> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

     }

    public static void main(String [] args){
    System.out.println(
        new OrdenTrabajoDetalleController().getAllFiltered(Long.valueOf("67"), null,null).size());
        
        
        
    
    
    }


}   
