/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.Perdida;

/**
 *
 * @author FerBoy
 */
public class PerdidaController extends AbstractJpaDao <Perdida> {



    public PerdidaController() {
        super();
    }

    @Override
    public Perdida findById(Long id) {
        return (Perdida) this.findById(Perdida.class, id);
    }

    @Override
    public List<Perdida> getAll(String orderBy) {
        return this.getAll(Perdida.class, orderBy);
    }

    public List<Perdida> getAllFiltered(String codPerdida, String codProducto, String codEmpleado, Date fecha1, Date fecha2) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Perdida o WHERE o.codPerdida = o.codPerdida";

        if (codPerdida != null) {
            SQL = SQL + " and UPPER(o.codPerdida) like UPPER(:codPerdida)";
        }

        if (codEmpleado != null) {
            SQL = SQL + " and UPPER(o.codEmpleado) like UPPER(:codEmpleado)";
        }

        if (fecha1 != null) {
            SQL = SQL + " and o.fechaPerdida >= :fecha1";
        }

        if (fecha1 != null) {
            SQL = SQL + " and o.fechaPerdida <= :fecha2";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codPerdida != null) {
            q.setParameter("codPerdida",  "%"+codPerdida+"%");
        }

        if (codEmpleado != null) {
            q.setParameter("codEmpleado",  "%"+codEmpleado+"%");
        }

        if (fecha1 != null) {
            q.setParameter("fecha1", fecha1);
        }

        if (fecha2 != null) {
            q.setParameter("fecha2", fecha2);
        }

        List<Perdida> entities = q.getResultList();
        em.close();

        return entities;

      }

   
//public static void main (String[] v) {
//        PerdidaController PerdidaController = new PerdidaController();
//        Perdida Perdida = new Perdida();
//        Perdida = PerdidaController.findById(Long.valueOf("1000"));
//        System.out.println(Perdida.getDescripcion());
//        PerdidaController.delete(Perdida);
//        };




}
