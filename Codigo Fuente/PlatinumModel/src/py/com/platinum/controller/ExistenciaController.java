/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class ExistenciaController extends AbstractJpaDao<Existencia> {

    public boolean existe(Long codExistencia){

        String SQL = "SELECT o FROM Existencia o WHERE o.codExistencia= :codExistencia";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codExistencia", codExistencia);

        List<Existencia> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}

    }


    public ExistenciaController() {
        super();
    }


    @Override
    public Existencia findById(Long id) {
                return (Existencia) this.findById(Existencia.class, id);
    }

    @Override
    public List<Existencia> getAll(String orderBy) {
        return this.getAll(Existencia.class, orderBy);
     }

    public List<Existencia> getAllFiltered(Long codExistencia, Long codProducto, Long codDeposito) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Existencia o WHERE o.codExistencia = o.codExistencia";

        if (codExistencia != null) {
            SQL = SQL + " and o.codExistencia = :codExistencia";
        }

        if (codProducto != null) {
            SQL = SQL + " and o.codExistencia.codProducto.codProducto = :codProducto";
        }

        if (codDeposito != null) {
            SQL = SQL + " and o.codExistencia.codDeposito.codDeposito = :codDeposito";
        }
         EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codExistencia != null) {
            q.setParameter("codExistencia", codExistencia);
        }

        if (codProducto != null) {
            q.setParameter("codProducto", codProducto);
        }

        if (codDeposito != null) {
            q.setParameter("codDeposito", codDeposito);
        }

        
        List<Existencia> entities = q.getResultList();
        em.close();

        return entities;

      }
    public Existencia getExistencia(Long codExistencia, Long codProducto, Long codDeposito) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Existencia o WHERE o.codExistencia = o.codExistencia";

        if (codExistencia != null) {
            SQL = SQL + " and o.codExistencia = :codExistencia";
        }

        if (codProducto != null) {
            SQL = SQL + " and o.codExistencia.codProducto.codProducto = :codProducto";
        }

        if (codDeposito != null) {
            SQL = SQL + " and o.codExistencia.codDeposito.codDeposito = :codDeposito";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codExistencia != null) {
            q.setParameter("codExistencia", codExistencia);
        }

        if (codProducto != null) {
            q.setParameter("codProducto", codProducto);
        }

        if (codDeposito != null) {
            q.setParameter("codDeposito", codDeposito);
        }

        Existencia entities = null;
        try {
            entities = (Existencia) q.getSingleResult();
            em.close();

        } catch (NoResultException e) {
            e.printStackTrace();
        }

        return entities;

      }

    public BigInteger getCantidadExistencia(Long codProducto) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT sum(o.cantidadExistencia) FROM Existencia o WHERE o.codExistencia.codProducto.codProducto = :codProducto";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codProducto != null) {
            q.setParameter("codProducto", codProducto);
        }

        BigInteger cant = null;
        try {
            cant = (BigInteger) q.getSingleResult();
            em.close();
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        if (cant == null) {
            cant = BigInteger.valueOf(Long.valueOf("0"));
        }

        return cant;

      }

public static void main (String[] v) {
        ExistenciaController existenciaController = new ExistenciaController();
        DepositoController depositoController = new DepositoController();
        Deposito deposito = depositoController.findById(Long.valueOf("3"));
        Existencia existencia = existenciaController.getExistencia(null, Long.valueOf("1022"),Long.valueOf("3"));
        System.out.println(deposito.getCodDeposito().toString());
        System.out.println(existencia.getCantidadExistencia().toString());

}

}
