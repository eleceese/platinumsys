/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Cargo;

/**
 *
 * @author Martin
 */
public class CargoController extends AbstractJpaDao<Cargo> {

    public CargoController() {
        super();
    }


    @Override
    public Cargo findById(Long id) {
                return (Cargo) this.findById(Cargo.class, id);
    }

       @Override
    public List<Cargo> getAll(String orderBy) {
        return this.getAll(Cargo.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de Cargos que cumplen con la condicion de busqueda
     */
    public List<Cargo> getCargos(String codigo, String descripcion) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Cargo o WHERE o.codCargo = o.codCargo";

        if (codigo != null && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codCargo) like UPPER(:codigo)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.nombreCargo) like UPPER(:descripcion)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (codigo != null && !codigo.equals("")) {
            q.setParameter("codigo", "%" + codigo + "%");
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%" + descripcion + "%");
        }

        //Realizamos la busqueda
        List<Cargo> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

}   
