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
import py.com.platinum.entity.TareaFormula;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class TareaFormulaController extends AbstractJpaDao <TareaFormula> {

    public boolean existe(String codTareaFormula){

        String SQL = "SELECT o FROM TareaFormula o WHERE o.codTareaFormula = :codTareaFormula";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codTareaFormula", codTareaFormula);

        List<TareaFormula> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public TareaFormulaController() {
        super();
    }

    @Override
    public TareaFormula findById(Long id) {
        return (TareaFormula) this.findById(TareaFormula.class, id);
    }

    @Override
    public List<TareaFormula> getAll(String orderBy) {
        return this.getAll(TareaFormula.class, orderBy);
    }

    public List<TareaFormula> getAllFiltered(String codTareaFormula, String tarea) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM TareaFormula o WHERE o.codTareaFormula= o.codTareaFormula";

        if (codTareaFormula != null && !codTareaFormula.equals("99999") && !codTareaFormula.equals("")) {
            SQL = SQL + " and UPPER(o.codTareaFormula) like upper(:codTareaFormula)";
        }

        if (tarea != null && !tarea.equals("")) {
            SQL = SQL + " and UPPER(o.codTarea.nombreTarea) like upper(:tarea)";
        }

      
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codTareaFormula != null && !codTareaFormula.equals("99999") && !codTareaFormula.equals("")) {
            q.setParameter("codTareaFormula", codTareaFormula);
        }

        if (tarea != null && !tarea.equals("99999") && !tarea.equals("")) {
            q.setParameter("tarea", "%"+tarea+"%");
        }

        List<TareaFormula> entities = q.getResultList();
        em.close();

        return entities;

      }





}
