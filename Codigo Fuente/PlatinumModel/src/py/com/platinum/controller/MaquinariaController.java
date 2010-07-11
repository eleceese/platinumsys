/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Maquinarias;

/**
 *
 * @author Martin
 */
public class MaquinariaController extends AbstractJpaDao<Maquinarias> {

    public MaquinariaController() {
        super();
    }


    @Override
    public Maquinarias findById(Long id) {
                return (Maquinarias) this.findById(Maquinarias.class, id);
    }

       @Override
    public List<Maquinarias> getAll(String orderBy) {
        return this.getAll(Maquinarias.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de Maquinariass que cumplen con la condicion de busqueda
     */
    public List<Maquinarias> getMaquinariass(String codigo, String descripcion) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Maquinarias o WHERE o.codMaquinaria = o.codMaquinaria";

        if (codigo != null && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codMaquinaria) like UPPER(:codigo)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.descripcion) like UPPER(:descripcion)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (codigo != null && !codigo.equals("")) {
            q.setParameter("codigo",codigo);
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%" + descripcion + "%");
        }

        //Realizamos la busqueda
        List<Maquinarias> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

    public static void main (String[] v) {

        Maquinarias maquinaria = new Maquinarias();
        maquinaria.setDescripcion("PLANCHA LAMINA OFFSET X332");
        maquinaria.setCostoMantenimiento(Long.valueOf("1200000"));
        MaquinariaController maqCon = new MaquinariaController();
        maqCon.create(maquinaria);
        
    };



}   
