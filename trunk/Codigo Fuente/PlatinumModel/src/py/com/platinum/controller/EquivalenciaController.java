/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Equivalencia;

/**
 *
 * @author FerBoy
 */
public class EquivalenciaController extends AbstractJpaDao<Equivalencia> {

 


    public EquivalenciaController() {
        super();
    }


    @Override
    public Equivalencia findById(Long id) {
                return (Equivalencia) this.findById(Equivalencia.class, id);
    }

    @Override
    public List<Equivalencia> getAll(String orderBy) {
        return this.getAll(Equivalencia.class, orderBy);
     }

    public List<Equivalencia> getAllFiltered(Long codEquivalencia, Long codProductoGen, Long codProductoFin) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Equivalencia o WHERE o.codEquivalencia = o.codEquivalencia";

        if (codEquivalencia != null) {
            SQL = SQL + " and o.codEquivalencia = codEquivalencia";
        }
        if (codProductoGen != null) {
            SQL = SQL + " and o.codEquivalencia = codEquivalencia";
        }
        if (codProductoFin != null) {
            SQL = SQL + " and o.codProductoFin = codProductoFin";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codEquivalencia != null) {
            q.setParameter("codEquivalencia", codEquivalencia);
        }
        if (codProductoFin != null) {
            q.setParameter("codProductoFin", codProductoFin);
        }
        if (codProductoGen != null) {
            q.setParameter("codProductoGen", codProductoGen);
        }


        List<Equivalencia> entities = q.getResultList();
        em.close();

        return entities;

      }
    public Equivalencia getEqPorProductos(Long codProductoGen, Long codProductoFin) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Equivalencia o WHERE o.codEquivalencia = o.codEquivalencia " +
                "and o.codProductoGen.codProducto = :codProductoGen " +
                "and o.codProductoFin.codProducto = :codProductoFin";


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);


            q.setParameter("codProductoFin", codProductoFin);
            q.setParameter("codProductoGen", codProductoGen);
        Equivalencia entity = null;
        try {
            entity = (Equivalencia) q.getSingleResult();

        } catch (NoResultException e) {
            e.printStackTrace();

        }


        em.close();

        return entity;

      }
    public Equivalencia getExisteEqPorProductoFin(Long codProductoFin) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Equivalencia o WHERE o.codEquivalencia = o.codEquivalencia " +
                "and o.codProductoFin.codProducto = :codProductoFin";


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);


            q.setParameter("codProductoFin", codProductoFin);

        Equivalencia entity = null;
        try {
            entity = (Equivalencia) q.getSingleResult();

        } catch (NoResultException e) {
            e.printStackTrace();

        }


        em.close();

        return entity;

      }


    public BigDecimal getCantExistPorProducto(Long codProductoGen, Long codDeposito) {
        //emf.createEntityManager Levanta el contexto del JPA

        String SQL = "SELECT sum(ex.cantidadExistencia * e.relacion) FROM Equivalencia e, " +
                "Existencia ex " +
                "where e.codProductoGen.codProducto = :codProductoGen " +
                "and  ex.codProducto.codProducto = e.codProductoFin.codProducto";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);


        q.setParameter("codProductoGen", codProductoGen);

       BigDecimal existencia = null;
        try {
            existencia = (BigDecimal) q.getSingleResult();

        } catch (NoResultException e) {
            e.printStackTrace();

        }
        em.close();

        return existencia;

      }


    public static void main (String[] v) {
        EquivalenciaController equivalenciaController = new EquivalenciaController();

        BigDecimal existencia = equivalenciaController.getCantExistPorProducto(Long.valueOf("1049"),null);
        System.out.println("*********************");
        System.out.println(existencia);

    }

}
