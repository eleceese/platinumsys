/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.FormulaCabecera;
import py.com.platinum.entity.FormulaDetalle;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class FormulaDetalleController extends AbstractJpaDao <FormulaDetalle> {

    public boolean existe(String codFormulaDetalle){

        String SQL = "SELECT o FROM FormulaDetalle o WHERE o.codFormulaDetalle = :codFormulaDetalle";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codFormulaDetalle", codFormulaDetalle);

        List<FormulaDetalle> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public FormulaDetalleController() {
        super();
    }

    @Override
    public FormulaDetalle findById(Long id) {
        return (FormulaDetalle) this.findById(FormulaDetalle.class, id);
    }

    @Override
    public List<FormulaDetalle> getAll(String orderBy) {
        return this.getAll(FormulaDetalle.class, orderBy);
    }

    public List<FormulaDetalle> getAllFiltered(String codFormula, String codProducto) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM FormulaDetalle o WHERE o.codFormulaDetalle= o.codFormulaDetalle";

        if (codFormula != null && !codFormula.equals("99999") && !codFormula.equals("")) {
            SQL = SQL + " and UPPER(o.codFormula) = upper(:codFormula)";
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

        List<FormulaDetalle> entities = q.getResultList();
        em.close();

        return entities;

      }

    public List<FormulaDetalle> getAllFilteredByCabecera(Long codFormula) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM FormulaDetalle o WHERE o.codFormula.codFormula = :codFormula";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codFormula", codFormula);
        List<FormulaDetalle> entities = q.getResultList();
        em.close();

        return entities;

      }


public static void main (String[] v) {
        FormulaDetalleController formulaDetalleController = new FormulaDetalleController();
        FormulaDetalle formulaDetalle = new FormulaDetalle();
        List<FormulaDetalle> formulaDetalleList = formulaDetalleController.getAllFilteredByCabecera(Long.valueOf("1029"));

        System.out.println(formulaDetalleList.size());
        for (int i = 0; i < formulaDetalleList.size(); i++) {
            FormulaDetalle formulaDetalle1 = formulaDetalleList.get(i);
        
            System.out.println(formulaDetalle1.getCodFormulaDetalle());
        }
        

  };


public ControllerResult eliminar(FormulaDetalle entity) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            FormulaDetalle formulaDetalle = em.find(FormulaDetalle.class, entity.getCodFormulaDetalle());
            em.remove(formulaDetalle);
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro eliminado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al persistir " + entity.getClass());
            try {
                em.getTransaction().rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            em.close();
            return r;
        }
    }

}
