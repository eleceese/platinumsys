/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.TipoComprobante;
import py.com.platinum.utilsenum.ModuloEnum;

/**
 *
 * @author Martin
 */
public class TipoComprobanteController extends AbstractJpaDao<TipoComprobante> {

    public TipoComprobanteController() {
        super();
    }


    @Override
    public TipoComprobante findById(Long id) {
                return (TipoComprobante) this.findById(TipoComprobante.class, id);
    }

    @Override
    public List<TipoComprobante> getAll(String orderBy) {
        return this.getAll(TipoComprobante.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de TipoComprobantes que cumplen con la condicion de busqueda
     */
    public List<TipoComprobante> getTipoComprobantes(String descripcion) {
        //Armamos el sql String
        String SQL = "SELECT o FROM TipoComprobante o WHERE o.codTipo = o.codTipo ";

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.descTipo) like UPPER(:descripcion)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%" + descripcion + "%");
        }

        //Realizamos la busqueda
        List<TipoComprobante> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

    /**
     * Obtiene una lista de tipos de comprobantes por Modulo
     * 
     * @param modulo
     * @return lista de tipo de comprobantes que cumplen la condiciosn
     */
    public List<TipoComprobante> getTipoComprobantesPorModulo(ModuloEnum modulo) {
        //Armamos el sql String
        String SQL = "SELECT o FROM TipoComprobante o WHERE UPPER(o.modulo) = UPPER(:modulo) ";
        
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("modulo", modulo.toString());

        //Realizamos la busqueda
        List<TipoComprobante> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }
}
