/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Proveedor;

/**
 *
 * @author FerBoy
 */
public class ProveedorController extends AbstractJpaDao <Proveedor> {

    public boolean existe(String codProveedor){

        String SQL = "SELECT o FROM Proveedor o WHERE o.codProveedor = :codProveedor";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codProveedor", codProveedor);

        List<Proveedor> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public ProveedorController() {
        super();
    }

    @Override
    public Proveedor findById(Long id) {
        return (Proveedor) this.findById(Proveedor.class, id);
    }

    @Override
    public List<Proveedor> getAll(String orderBy) {
        return this.getAll(Proveedor.class, orderBy);
    }

    public List<Proveedor> getAllFiltered(String nombreProveedor, String rucProveedor, String direccionProveedor) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Proveedor o WHERE o.codProveedor = o.codProveedor";

        if (nombreProveedor != null && !nombreProveedor.equals("")) {
            SQL = SQL + " and UPPER(o.nombreProveedor) like upper(:nombreProveedor)";
        }

        if (rucProveedor != null && !rucProveedor.equals("")) {
            SQL = SQL + " and UPPER(o.rucProveedor) like upper(:rucProveedor)";
        }

        if (direccionProveedor != null && !direccionProveedor.equals("")) {
            SQL = SQL + " and UPPER(o.direccionProveedor) like upper(:direccionProveedor)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (nombreProveedor != null && !nombreProveedor.equals("")) {
            q.setParameter("nombreProveedor", "%"+nombreProveedor+"%");
        }

        if (rucProveedor != null && !rucProveedor.equals("")) {
            q.setParameter("rucProveedor", "%"+rucProveedor+"%");
        }

        if (direccionProveedor != null && !direccionProveedor.equals("")) {
            q.setParameter("direccionProveedor", "%"+direccionProveedor+"%");
        }

        List<Proveedor> entities = q.getResultList();
        em.close();

        return entities;

      }

}
