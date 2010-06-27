/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.SolicitudInterna;

/**
 *
 * @author FerBoy
 */
public class SolicitudInternaController extends AbstractJpaDao <SolicitudInterna> {

    public boolean existe(Long codSolicitud){

        String SQL = "SELECT o FROM SolicitudInterna o WHERE o.codSolicitud = :codSolicitud";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codSolicitud", codSolicitud);

        List<SolicitudInterna> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public SolicitudInternaController() {
        super();
    }

    @Override
    public SolicitudInterna findById(Long id) {
        return (SolicitudInterna) this.findById(SolicitudInterna.class, id);
    }

    @Override
    public List<SolicitudInterna> getAll(String orderBy) {
        return this.getAll(SolicitudInterna.class, orderBy);
    }

    public List<SolicitudInterna> getAllFiltered(Long codSolicitud) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM SolicitudInterna o WHERE o.codSolicitud = o.codSolicitud";

        if (codSolicitud != null && !codSolicitud.equals("99999") && !codSolicitud.equals("")) {
            SQL = SQL + " and UPPER(o.codSolicitud) like upper(:codSolicitud)";
        }
//
//        if (descripcion != null && !descripcion.equals("")) {
//            SQL = SQL + " and UPPER(o.descripcion) like upper(:descripcion)";
//        }
//
//        if (tipoSolicitudInterna != null && !tipoSolicitudInterna.equals("Todos") && !tipoSolicitudInterna.equals("")) {
//            SQL = SQL + " and UPPER(o.codTipoSolicitudInterna.descripcion) like upper(:tipoSolicitudInterna)";
//        }
//
//
//        if (presentacion != null && !presentacion.equals("99999") && !presentacion.equals("")) {
//            SQL = SQL + " and UPPER(o.codPresentacion.codPresentacion) = upper(:presentacion)";
//        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codSolicitud != null && !codSolicitud.equals("99999") && !codSolicitud.equals("")) {
            q.setParameter("codSolicitud", codSolicitud);
        }
//
//        if (descripcion != null && !descripcion.equals("")) {
//            q.setParameter("descripcion", "%"+descripcion+"%");
//        }
//
//        if (tipoSolicitudInterna != null && !tipoSolicitudInterna.equals("Todos") && !tipoSolicitudInterna.equals("")) {
//            q.setParameter("tipoSolicitudInterna", "%"+tipoSolicitudInterna+"%");
//        }
//
//        if (presentacion != null && !presentacion.equals("99999") && !presentacion.equals("")) {
//            q.setParameter("presentacion", presentacion);
//        }

        List<SolicitudInterna> entities = q.getResultList();
        em.close();

        return entities;

      }

    
//public static void main (String[] v) {
//        SolicitudInternaController SolicitudInternaController = new SolicitudInternaController();
//        SolicitudInterna SolicitudInterna = new SolicitudInterna();
//        SolicitudInterna = SolicitudInternaController.findById(Long.valueOf("1000"));
//        System.out.println(SolicitudInterna.getDescripcion());
//        SolicitudInternaController.delete(SolicitudInterna);
//        };

public List<SolicitudInterna> getSolicitudInternas(String producto, Date fechaDesde, Date fechaHasta, String estado) {
        //Armamos el sql String
        String SQL = "SELECT o FROM SolicitudInterna o WHERE o.codSolicitud = o.codSolicitud";

        if (producto != null && !producto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.descripcion) like UPPER(:producto)";
        }

        if (fechaDesde != null) {
            SQL = SQL + " and o.fecha >=:fechaDesde  ";
        }

        if (fechaHasta != null) {
            SQL = SQL + " and o.fecha <= :fechaHasta ";
        }

        if (estado != null && !estado.trim().equals("")) {
            SQL = SQL + " and upper(o.estado) = upper(:estado) ";
        }

        //Order by
        SQL = SQL + " order by o.fecha desc ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (producto != null && !producto.equals("")) {
            q.setParameter("producto", "%" + producto + "%");
        }

        if (fechaDesde != null ) {
            q.setParameter("fechaDesde", fechaDesde );
        }

        if (fechaHasta != null ) {
            q.setParameter("fechaHasta", fechaHasta );
        }

        if (estado != null && !estado.trim().equals("")) {
            q.setParameter("estado", estado );
        }

        //Realizamos la busqueda
        List<SolicitudInterna> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

public List<SolicitudInterna> getSolicitudInternas(String responsable, String producto, Date fechaDesde, Date fechaHasta, String estado) {
        //Armamos el sql String
        String SQL = "SELECT o FROM SolicitudInterna o WHERE o.codSolicitud = o.codSolicitud";

           if (responsable != null && !responsable.equals("")) {
            SQL = SQL + " and UPPER(o.codEmpleado.codEmpleado) like UPPER(:responsable)";
        }


        if (producto != null && !producto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.codProducto) like UPPER(:producto)";
        }

        if (fechaDesde != null) {
            SQL = SQL + " and o.fecha >= :fechaDesde  ";
        }

        if (fechaHasta != null) {
            SQL = SQL + " and o.fecha <= :fechaHasta ";
        }

        if (estado != null && !estado.trim().equals("")) {
            SQL = SQL + " and upper(o.estado) = upper(:estado) ";
        }

        //Order by
        SQL = SQL + " order by o.fecha desc ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros

        if (responsable != null && !responsable.equals("")) {
            q.setParameter("responsable", responsable);
        }

        if (producto != null && !producto.equals("")) {
            q.setParameter("producto", "%" + producto + "%");
        }

        if (fechaDesde != null ) {
            q.setParameter("fechaDesde", fechaDesde );
        }

        if (fechaHasta != null ) {
            q.setParameter("fechaHasta", fechaHasta );
        }

        if (estado != null && !estado.trim().equals("")) {
            q.setParameter("estado", estado );
        }

        //Realizamos la busqueda
        List<SolicitudInterna> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }


 public SolicitudInterna getSolicitudPorEquiv(Long codSolicitud, Long codRecurso) {

         String SQL = "SELECT o FROM SolicitudInterna o , " +
                 "Equivalencia e " +
                 "WHERE e.codProductoFin.codProducto = :codRecurso " +
                 "and o.codSolicitud = :codSolicitud " +
                 "and o.codProducto.codProducto = e.codProductoGen.codProducto ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);


        if (codSolicitud != null) {
            q.setParameter("codSolicitud", codSolicitud);
        }

        if (codRecurso != null) {
            q.setParameter("codRecurso", codRecurso);
        }

        SolicitudInterna r = new SolicitudInterna();

         try {
             r = (SolicitudInterna) q.getSingleResult();
         } catch (NoResultException e) {
             r = null;
         }

        em.close();

        //retornamos la lista
        return r;

     }

}
