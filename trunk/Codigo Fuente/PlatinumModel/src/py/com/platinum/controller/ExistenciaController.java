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
            SQL = SQL + " and UPPER(o.codExistencia.codProducto.codProducto = :codProducto";
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
            SQL = SQL + " and o.codExistencia.codProducto.CodProducto = :codProducto";
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

public static void main (String[] v) {
        ExistenciaController existenciaController = new ExistenciaController();
        
        ProductoController productoController = new ProductoController();
        DepositoController depositoController = new DepositoController();

        List<Producto> productoList = productoController.getAll("descripcion");
        for (int i = 0; i < productoList.size(); i++) {

                List<Deposito> listaDepositos = depositoController.getAll("nombre");
                for (int j = 0; j < listaDepositos.size(); j++) {
                    Existencia existencia = new Existencia();
                    Producto producto = productoList.get(i);
                    existencia.setCodProducto(producto);
                    existencia.setCantidadExistencia(BigInteger.valueOf(Long.valueOf("0")));
                    Deposito deposito = listaDepositos.get(j);
                    existencia.setCodDeposito(deposito);

                    existenciaController.create(existencia);
                }

        }
 }

}
