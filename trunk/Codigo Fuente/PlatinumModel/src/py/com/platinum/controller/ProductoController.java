/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class ProductoController extends AbstractJpaDao <Producto> {

    public boolean existe(String codInterno){

        String SQL = "SELECT o FROM Producto o WHERE o.codigoInterno = :codInterno";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codInterno", codInterno);

        List<Producto> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public ProductoController() {
        super();
    }

    @Override
    public Producto findById(Long id) {
        return (Producto) this.findById(Producto.class, id);
    }

    @Override
    public List<Producto> getAll(String orderBy) {
        return this.getAll(Producto.class, orderBy);
    }

    public List<Producto> getAllFiltered(String marca, String descripcion, String tipoProducto, String presentacion) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Producto o WHERE o.codProducto = o.codProducto";

        if (marca != null && !marca.equals("99999") && !marca.equals("")) {
            SQL = SQL + " and UPPER(o.codMarca.codMarca) = upper(:marca)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.descripcion) like upper(:descripcion)";
        }

        if (tipoProducto != null && !tipoProducto.equals("Todos") && !tipoProducto.equals("")) {
            SQL = SQL + " and UPPER(o.codTipoProducto.descripcion) like upper(:tipoProducto)";
        }


        if (presentacion != null && !presentacion.equals("99999") && !presentacion.equals("")) {
            SQL = SQL + " and UPPER(o.codPresentacion.codPresentacion) = upper(:presentacion)";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (marca != null && !marca.equals("99999") && !marca.equals("")) {
            q.setParameter("marca", marca);
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%"+descripcion+"%");
        }

        if (tipoProducto != null && !tipoProducto.equals("Todos") && !tipoProducto.equals("")) {
            q.setParameter("tipoProducto", "%"+tipoProducto+"%");
        }

        if (presentacion != null && !presentacion.equals("99999") && !presentacion.equals("")) {
            q.setParameter("presentacion", presentacion);
        }

        List<Producto> entities = q.getResultList();
        em.close();

        return entities;

      }

public static void main (String[] v) {
        ProductoController productoController = new ProductoController();
        Producto producto = new Producto();
        producto = productoController.findById(Long.valueOf("1000"));
        System.out.println(producto.getDescripcion());
        productoController.delete(producto);
        };




}
