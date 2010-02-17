/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.FormulaSemiCabecera;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class FormulaSemiCabeceraController extends AbstractJpaDao <FormulaSemiCabecera> {

    public boolean existe(String codFormulaSemiCabecera){

        String SQL = "SELECT o FROM FormulaSemiCabecera o WHERE o.codFormulaSemiCabecera = :codFormulaSemiCabecera";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codFormulaSemiCabecera", codFormulaSemiCabecera);

        List<FormulaSemiCabecera> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public FormulaSemiCabeceraController() {
        super();
    }

    @Override
    public FormulaSemiCabecera findById(Long id) {
        return (FormulaSemiCabecera) this.findById(FormulaSemiCabecera.class, id);
    }

    @Override
    public List<FormulaSemiCabecera> getAll(String orderBy) {
        return this.getAll(FormulaSemiCabecera.class, orderBy);
    }

    public List<FormulaSemiCabecera> getAllFiltered(String codigo, String descripcion, String codProducto) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM FormulaSemiCabecera o WHERE o.codFormulaSemiCabecera= o.codFormulaSemiCabecera";

        if (codigo != null && !codigo.equals("99999") && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codFormula) like upper(:codigo)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.descripcion) like upper(:descripcion)";
        }

        if (codProducto != null && !codProducto.equals("99999") && !codProducto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.descripcion) like upper(:codProducto)";
        }


      

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codigo != null && !codigo.equals("99999") && !codigo.equals("")) {
            q.setParameter("codigo", codigo);
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%"+descripcion+"%");
        }

        if (codProducto != null && !codProducto.equals("99999") && !codProducto.equals("")) {
            q.setParameter("codProducto", "%"+codProducto+"%");
        }

        List<FormulaSemiCabecera> entities = q.getResultList();
        em.close();

        return entities;

      }

//public static void main (String[] v) {
//        FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
//        FormulaSemiCabecera formulaSemiCabecera = new FormulaSemiCabecera();
//        formulaSemiCabecera = formulaSemiCabeceraController.findById(Long.valueOf("1001"));
//        System.out.println(formulaSemiCabecera.getDescripcion());
//
//        };




}
