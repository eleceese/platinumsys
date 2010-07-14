/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.HabilitacionCaja;

/**
 *
 * @author Martin
 */
public class HabilitacionCajaController extends AbstractJpaDao<HabilitacionCaja> {

    public HabilitacionCajaController() {
        super();
    }


    @Override
    public HabilitacionCaja findById(Long id) {
                return (HabilitacionCaja) this.findById(HabilitacionCaja.class, id);
    }

       @Override
    public List<HabilitacionCaja> getAll(String orderBy) {
        return this.getAll(HabilitacionCaja.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de HabilitacionCajas que cumplen con la condicion de busqueda
     */
    public List<HabilitacionCaja> getHabilitacionCajas(Long codCaja, String descCaja, String estado) {
        //Armamos el sql String
        String SQL = "SELECT o FROM HabilitacionCaja o WHERE o.codHabilitacionCaja = o.codHabilitacionCaja";

        if (codCaja != null) {
            SQL = SQL + " and o.codCaja.codCaja = :codigo ";
        }

        if (descCaja != null && !descCaja.equals("")) {
            SQL = SQL + " and UPPER(o.codCaja.nombreCaja) like UPPER(:descCaja)";
        }

        if (estado != null && !estado.equals("")) {
            SQL = SQL + " and o.estado = :estado ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (codCaja != null ) {
            q.setParameter("codigo", codCaja);
        }

        if (descCaja != null && !descCaja.equals("")) {
            q.setParameter("descCaja", "%" + descCaja + "%");
        }

        if (estado != null && !estado.equals("")) {
            q.setParameter("estado", estado);
        }

        //Realizamos la busqueda
        List<HabilitacionCaja> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

}   
