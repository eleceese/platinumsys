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
import py.com.platinum.entity.FormulaSemiDetalle;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class FormulaSemiDetalleController extends AbstractJpaDao <FormulaSemiDetalle> {

    public boolean existe(String codFormulaSemiDetalle){

        String SQL = "SELECT o FROM FormulaSemiDetalle o WHERE o.codFormulaSemiDetalle = :codFormulaSemiDetalle";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codFormulaSemiDetalle", codFormulaSemiDetalle);

        List<FormulaSemiDetalle> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public FormulaSemiDetalleController() {
        super();
    }

    @Override
    public FormulaSemiDetalle findById(Long id) {
        return (FormulaSemiDetalle) this.findById(FormulaSemiDetalle.class, id);
    }

    @Override
    public List<FormulaSemiDetalle> getAll(String orderBy) {
        return this.getAll(FormulaSemiDetalle.class, orderBy);
    }

    public List<FormulaSemiDetalle> getAllFiltered(String codFormula, String codProducto) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM FormulaSemiDetalle o WHERE o.codFormulaSemiDetalle= o.codFormulaSemiDetalle";

        if (codFormula != null && !codFormula.equals("99999") && !codFormula.equals("")) {
            SQL = SQL + " and UPPER(o.codFormulaSemiDetalle) = upper(:codFormula)";
        }

        if (codProducto != null && !codProducto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto) like upper(:codProducto)";
        }

      

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codFormula != null && !codFormula.equals("99999") && !codFormula.equals("")) {
            q.setParameter("codFormula", codFormula);
        }

        if (codProducto != null && !codProducto.equals("99999") && !codProducto.equals("")) {
            q.setParameter("codProducto", "%"+codProducto+"%");
        }

        List<FormulaSemiDetalle> entities = q.getResultList();
        em.close();

        return entities;

      }

public static void main (String[] v) {
        FormulaSemiDetalleController FormulaSemiDetalleController = new FormulaSemiDetalleController();
        FormulaSemiDetalle FormulaSemiDetalle = new FormulaSemiDetalle();
        FormulaSemiDetalle = FormulaSemiDetalleController.findById(Long.valueOf("8"));
        System.out.println(FormulaSemiDetalle.getCodProducto());
        FormulaSemiDetalleController.delete(FormulaSemiDetalle);
        };




}
