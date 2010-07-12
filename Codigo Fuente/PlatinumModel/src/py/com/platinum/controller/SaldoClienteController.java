/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.SaldoCliente;
import py.com.platinum.view.VClientesSaldos;

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

    public List<VClientesSaldos> getComprobantesConSaldos(String nroComprobante, Long codCliente, String notIN) {

        //Armamos el sql String
        String SQL =
                      "SELECT                                    "
                    + "       s.ORDEN  AS orden,                              "
                    + "       s.DESC_TIPO_COMPROBANTE AS descTipoComprobante, "
                    + "       s.NRO_COMPROBANTE AS nroComprobante,            "
                    + "       s.COD_COMPROBANTE AS codComprobante,            "
                    + "       s.NRO_CUOTA       AS nroCuota,                  "
                    + "       s.FEC_VENCIMIENTO AS fecVencimiento,            "
                    + "       s.TOTAL_COMPROBANTE AS totalComprobante,        "
                    + "       s.SALDO_COMPROBANTE AS saldoComprobante,        "
                    + "       s.COD_SALDO_CLIENTE AS codSaldoCliente          "
                    + "  FROM v_clientes_saldos   s                           "
                    + " WHERE s.COD_CLIENTE = :codCliente                     ";

         if (nroComprobante != null) {
            SQL = SQL + "   AND s.NRO_COMPROBANTE like  (:nro)    ";
        }

        if (notIN != null) {
            SQL = SQL + "   AND s.COD_SALDO_CLIENTE not in  " + notIN;
        }


        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q = em.createNativeQuery(SQL, VClientesSaldos.class);

        //Seteamos los parametros
        if (nroComprobante != null) {
            q.setParameter("nro", "%"+nroComprobante+"%");
        }
//
//        if (notIN != null) {
//            q.setParameter("notIN", notIN);
//        }

        q.setParameter("codCliente", codCliente);

        //Realizamos la busqueda
        List<VClientesSaldos> l;
        try {
            l = q.getResultList();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            l = new ArrayList<VClientesSaldos>();
            tx.rollback();
        }

        em.close();

        return l;
    }


}   
