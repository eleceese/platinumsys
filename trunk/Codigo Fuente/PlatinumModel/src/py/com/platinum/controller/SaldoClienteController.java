/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.SaldoCliente;

/**
 *
 * @author Martin
 */
public class SaldoClienteController extends AbstractJpaDao<SaldoCliente> {

    public SaldoClienteController() {
        super();
    }

    @Override
    public SaldoCliente findById(Long id) {
        return (SaldoCliente) this.findById(SaldoCliente.class, id);
    }

    @Override
    public List<SaldoCliente> getAll(String orderBy) {
        return this.getAll(SaldoCliente.class, orderBy);
    }

    public Long getSaldoCliente(Long tipoComprobante, Long nroComprobante) {
        //Armamos el sql String
        String SQL = "SELECT sum(o.montoCuota) FROM SaldoCliente o       " +
                     " WHERE o.tipoComprobante = :tipoComprobante " +
                     "   and o.nroComprobante  = :nroComprobante";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("tipoComprobante", tipoComprobante);
        q.setParameter("nroComprobante", nroComprobante);

        //Realizamos la busqueda
        Long entities;
        try {
            entities = (Long) q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            entities = null;
        }

        em.close();

        //retornamos la lista
        return entities;

    }

    public int anularComprobante(Long tipoComprobante, Long nroComprobante) {

        //Armamos el sql String
        String SQL = " update SaldoCliente                         " +
                     "    set montoCuota = :zero,                  " +
                     "        saldoCuota = :zero,                  " +
                     "        totalComprobante = :zero,            " +
                     "        saldoComprobante = :zero             " +
                     "  where tipoComprobante  = :tipoComprobante  " +
                     "    and nroComprobante   = :nroComprobante   ";

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("tipoComprobante", tipoComprobante);
        q.setParameter("nroComprobante", nroComprobante);
        q.setParameter("zero", Long.valueOf("0"));


        //Realizamos la busqueda
        int cant;
        try {
            cant = q.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            cant = 0;
            tx.rollback();
        }

        em.close();


        return cant;
    }

}   
