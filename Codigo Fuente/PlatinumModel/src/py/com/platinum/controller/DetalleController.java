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
import py.com.platinum.entity.Detalle;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class DetalleController extends AbstractJpaDao <Detalle> {

    public boolean existe(String codDetalle){

        String SQL = "SELECT o FROM Detalle o WHERE o.codDetalle = :codDetalle";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codDetalle", codDetalle);

        List<Detalle> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public DetalleController() {
        super();
    }

    @Override
    public Detalle findById(Long id) {
        return (Detalle) this.findById(Detalle.class, id);
    }

    @Override
    public List<Detalle> getAll(String orderBy) {
        return this.getAll(Detalle.class, orderBy);
    }

    public List<Detalle> getAllFiltered(String codFormula, String codProducto) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Detalle o WHERE o.codDetalle= o.codDetalle";

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

        List<Detalle> entities = q.getResultList();
        em.close();

        return entities;

      }

public static void main (String[] v) {
        DetalleController DetalleController = new DetalleController();
        Detalle Detalle = new Detalle();
        Detalle = DetalleController.findById(Long.valueOf("1"));
        System.out.println(Detalle.getNombreDet());
        DetalleController.eliminar(Detalle);
        };


public ControllerResult eliminar(Detalle entity) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Detalle Detalle = em.find(Detalle.class, entity.getIdDet());
            em.remove(Detalle);
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
