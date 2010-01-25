/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Empleado;

/**
 *
 * @author Martin Jara,
 */
public class EmpleadoController extends AbstractJpaDao<Empleado> {

    public EmpleadoController() {
        super();
    }

    @Override
    public Empleado findById(Long id) {
        return (Empleado) this.findById(Empleado.class, id);
    }

    @Override
    public List<Empleado> getAll(String orderBy) {
        return this.getAll(Empleado.class, orderBy);
    }

    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param nombre del empleado
     * @param apellido del empleado
     * @param nro de Cedula del empleado
     *
     * @return lista de empleados que cumplen con la condicion de busqueda
     */
    public List<Empleado> getEmeplados(String nombre, String apellido, String nroCedula) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Empleado o WHERE o.codEmpleado = o.codEmpleado";

        if (nombre != null && !nombre.equals("")) {
            SQL = SQL + " and UPPER(o.nombreEmpleado) like UPPER(:nombre)";
        }

        if (apellido != null && !apellido.equals("")) {
            SQL = SQL + " and UPPER(o.apellidoEmpleado) like UPPER(:apellido)";
        }

        if (nroCedula != null && !nroCedula.equals("")) {
            SQL = SQL + " and UPPER(o.cinEmpleado) like UPPER(:nroCedula)";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (nombre != null && !nombre.equals("")) {
            q.setParameter("nombre", "%" + nombre + "%");
        }

        if (apellido != null && !apellido.equals("")) {
            q.setParameter("apellido", "%" + apellido + "%");
        }

        if (nroCedula != null && !nroCedula.equals("")) {
            q.setParameter("nroCedula", "%" + nroCedula + "%");
        }

        //Realizamos la busqueda
        List<Empleado> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

//      public static void main(String[] args){
//          EmpleadoController c = new EmpleadoController();
//          Empleado e = new Empleado();
//
//          e = c.findById(Long.valueOf("100"));
//
//          System.out.println(e.getNombreEmpleado());
////          e.setApellidoEmpleado("Jara - Calderoli");
////          e.setCinEmpleado("******");
//
//          ControllerResult r = c.delete(e);
//
//          System.out.println("***************");
//          System.out.println("Codigo retorno:"+r.getCodRetorno());
//          System.out.println("Mensaje:"+r.getMsg());
//      }

}
