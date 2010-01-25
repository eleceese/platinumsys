/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.FormulaCabecera;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class FormulaCabeceraController extends AbstractJpaDao <FormulaCabecera> {

    public boolean existe(String codFormula){

        String SQL = "SELECT o FROM FormulaCabecera o WHERE o.codFormula = :codFormula";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codFormula", codFormula);

        List<FormulaCabecera> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public FormulaCabeceraController() {
        super();
    }

    @Override
    public FormulaCabecera findById(Long id) {
        return (FormulaCabecera) this.findById(FormulaCabecera.class, id);
    }

    @Override
    public List<FormulaCabecera> getAll(String orderBy) {
        return this.getAll(FormulaCabecera.class, orderBy);
    }

    public List<FormulaCabecera> getAllFiltered(String codigo, String descripcion, String codProducto) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM FormulaCabecera o WHERE o.codFormula= o.codFormula";

        if (codigo != null && !codigo.equals("99999") && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codigo) = upper(:codigo)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.descripcion) like upper(:descripcion)";
        }

        if (codProducto != null && !codProducto.equals("99999") && !codProducto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.codProducto) like upper(:codProducto)";
        }


      

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codigo != null && !codigo.equals("99999") && !codigo.equals("")) {
            q.setParameter("codigo", codigo);
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%"+descripcion+"%");
        }

        if (codProducto != null && !codProducto.equals("99999") && !codigo.equals("")) {
            q.setParameter("codProducto", "%"+codProducto+"%");
        }

        List<FormulaCabecera> entities = q.getResultList();
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
