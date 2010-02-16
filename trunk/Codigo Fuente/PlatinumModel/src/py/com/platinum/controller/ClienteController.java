/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Cliente;

/**
 *
 * @author Martin.
 */
public class ClienteController extends AbstractJpaDao<Cliente> {

    public ClienteController() {
        super();
    }

    @Override
    public Cliente findById(Long id) {
        return (Cliente) this.findById(Cliente.class, id);
    }

    @Override
    public List<Cliente> getAll(String orderBy) {
        return this.getAll(Cliente.class, orderBy);
    }

    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de Clientes que cumplen con la condicion de busqueda
     */
    public List<Cliente> getClientes(String apellido, String nombre, String ruc) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Cliente o WHERE o.codCliente = o.codCliente";

        if (apellido != null && !apellido.equals("")) {
            SQL = SQL + " and UPPER(o.apellidoCliente) like UPPER(:apellido)";
        }

        if (nombre != null && !nombre.equals("")) {
            SQL = SQL + " and UPPER(o.nombreCliente) like UPPER(:nombre)";
        }

        if (ruc != null && !ruc.equals("")) {
            SQL = SQL + " and UPPER(o.rucCliente) like UPPER(:ruc)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (apellido != null && !apellido.equals("")) {
            q.setParameter("apellido", "%" + apellido + "%");
        }

        if (nombre != null && !nombre.equals("")) {
            q.setParameter("nombre", "%" + nombre + "%");
        }

        if (ruc != null && !ruc.equals("")) {
            q.setParameter("ruc", "%" + ruc + "%");
        }

        //Realizamos la busqueda
        List<Cliente> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

    }

    /**
     * Valida si ya existe el nro de Documento y tipo de documento
     * @param tipoDoc
     * @param nroDoc
     * @param codCliente, se envia null cuando la operacion es insert y cuando
     * la operacion es update se envia el codigo del cliente que se esta modificando
     * @return
     */
    public boolean existeDocumento(String tipoDoc, String nroDoc, Long codCliente) {
        //Variables
        boolean r;
        String SQL;

        //Inicializamos
        r = false;

        //Armamos el SQL
        SQL = "SELECT o FROM Cliente o WHERE o.codCliente = o.codCliente " +
              " and o.tipoDodCliente   = :tipoDoc " +
              " and o.numeroDocCliente = :nroDoc  ";

        if (codCliente != null) {
            SQL = SQL + " and o.codCliente != :codCliente ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("tipoDoc", tipoDoc );
        q.setParameter("nroDoc", nroDoc );

        if (codCliente != null ) {
            q.setParameter("codCliente", codCliente );
        }

        //Realizamos la busqueda
        List<Cliente> l = q.getResultList();

        if (l != null && l.size() > 0) {
            r = !r;
        }

        //Cerrampos el entity manager
        em.close();

        //result
        return r;
    }


    /**
     * Valida si el RUC ya existe
     * @param ruc
     * @param codCliente, se envia null cuando la operacion es insert y cuando
     * la operacion es update se envia el codigo del cliente que se esta modificando
     * @return
     */
    public boolean existeRUC(String ruc, Long codCliente) {
        //Variables
        boolean r;
        String SQL;

        //Inicializamos
        r = false;

        //Armamos el SQL
        SQL = "SELECT o FROM Cliente o WHERE o.codCliente = o.codCliente " +
              " and o.rucCliente  = :ruc ";

        if (codCliente != null) {
            SQL = SQL + " and o.codCliente != :codCliente ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("ruc", ruc );

        if (codCliente != null ) {
            q.setParameter("codCliente", codCliente );
        }

        //Realizamos la busqueda
        List<Cliente> l = q.getResultList();

        if (l != null && l.size() > 0) {
            r = !r;
        }

        //Cerrampos el entity manager
        em.close();

        //result
        return r;
    }

}   
