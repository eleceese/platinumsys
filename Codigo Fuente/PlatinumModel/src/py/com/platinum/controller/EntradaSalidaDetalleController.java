/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.EntradaSalidaDetalle;
import py.com.platinum.entity.EntradaSalidaDetalle;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class EntradaSalidaDetalleController extends AbstractJpaDao <EntradaSalidaDetalle> {

    
    public EntradaSalidaDetalleController() {
        super();
    }

    @Override
    public EntradaSalidaDetalle findById(Long id) {
        return (EntradaSalidaDetalle) this.findById(EntradaSalidaDetalle.class, id);
    }

    @Override
    public List<EntradaSalidaDetalle> getAll(String orderBy) {
        return this.getAll(EntradaSalidaDetalle.class, orderBy);
    }

    public List<EntradaSalidaDetalle> getAllFiltered(Long codEntSalDetalle, String producto, Long codProducto, Long codOrdenTrabajoDetalle, Long codSolicitud) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM EntradaSalidaDetalle o WHERE o.codEntSalDetalle = o.codEntSalDetalle";

        if (codEntSalDetalle != null) {
            SQL = SQL + " o.codEntSalDetalle = (:codEntSalDetalle)";
        }

        if (producto != null && !producto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.descripcion) like upper(:producto)";
        }

        if (codProducto != null) {
            SQL = SQL + " o.codProducto.codProducto = (:codProducto)";
        }

        if (codOrdenTrabajoDetalle != null) {
            SQL = SQL + " o.codOrdenTrabajoDetalle.codOrdenTrabajoDet = (:codOrdenTrabajoDetalle)";
        }

        if (codSolicitud != null) {
            SQL = SQL + " o.codSolicitud.codSolicitud = (:codSolicitud)";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codEntSalDetalle != null) {
            q.setParameter("codEntSalDetalle", codEntSalDetalle);
        }
         if (codProducto != null) {
            q.setParameter("codProducto", codProducto);
        }
      
        if (codProducto != null) {
            q.setParameter("codProducto", codProducto);
        }

        if (producto != null) {
            q.setParameter("producto", "%" + producto + "%");
        }

        if (codOrdenTrabajoDetalle != null) {
            q.setParameter("codOrdenTrabajoDetalle", codOrdenTrabajoDetalle);
        }

        if (codSolicitud != null) {
            q.setParameter("codSolicitud", codSolicitud);
        }

        List<EntradaSalidaDetalle> entities = q.getResultList();
        em.close();

        return entities;

      }

//public static void main (String[] v) {
//        ProductoController productoController = new ProductoController();
//        Producto producto = new Producto();
//        producto = productoController.findById(Long.valueOf("1000"));
//        System.out.println(producto.getDescripcion());
//        productoController.delete(producto);
//        };



}
