/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Deposito;

/**
 *
 * @author FerBoy
 */
public class DepositoController extends AbstractJpaDao<Deposito> {

    public boolean existe(String nombre){

        String SQL = "SELECT o FROM Deposito o WHERE o.nombre = :nombre";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("nombre", nombre);

        List<Deposito> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}

    }


    public DepositoController() {
        super();
    }


    @Override
    public Deposito findById(Long id) {
                return (Deposito) this.findById(Deposito.class, id);
    }

    @Override
    public List<Deposito> getAll(String orderBy) {
        return this.getAll(Deposito.class, orderBy);
     }

    public List<Deposito> getAllFiltered(String codigo, String nombre) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Deposito o WHERE o.codDeposito = o.codDeposito";

        if (codigo != null && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codDeposito) = upper(:codigo)";
        }

        if (nombre != null && !nombre.equals("")) {
            SQL = SQL + " and UPPER(o.nombre) like upper(:nombre)";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codigo != null  && !codigo.equals("")) {
            q.setParameter("codigo", codigo);
        }

        if (nombre != null && !nombre.equals("")) {
            q.setParameter("nombre", "%"+nombre+"%");
        }

        List<Deposito> entities = q.getResultList();
        em.close();

        return entities;

      }


}
