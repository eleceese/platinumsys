/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.FacturaCompraCab;
import py.com.platinum.entity.FacturaCompraDet;

/**
 *
 * @author Martin
 */
public class FacturaCompraCabController extends AbstractJpaDao<FacturaCompraCab> {

    public FacturaCompraCabController() {
        super();
    }

    @Override
    public FacturaCompraCab findById(Long id) {
        return (FacturaCompraCab) this.findById(FacturaCompraCab.class, id);
    }

    @Override
    public List<FacturaCompraCab> getAll(String orderBy) {
        return this.getAll(FacturaCompraCab.class, orderBy);
    }

    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param nroFactura
     * @param proveedor
     *
     * @return lista de FacturaCompraCabs que cumplen con la condicion de busqueda
     */
    public List<FacturaCompraCab> getFacturaCompraCab(String nroFactura, String proveedor, Date fechaFactura) {
        //Armamos el sql String
        String SQL = "SELECT o FROM FacturaCompraCab o WHERE o.codFacComCab = o.codFacComCab ";

        if (nroFactura != null && !nroFactura.equals("")) {
            SQL = SQL + " and UPPER(o.nroFactura) like UPPER(:nroFactura) ";
        }

        if (proveedor != null && !proveedor.equals("")) {
            SQL = SQL + " and UPPER(o.codProveedor.nombreProveedor) like UPPER(:proveedor) ";
        }

        if (fechaFactura != null) {
            SQL = SQL + " and o.fecha = :fechaFactura ";
        }

        //Order By
        SQL = SQL + " ORDER BY o.nroFactura ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (nroFactura != null && !nroFactura.equals("")) {
            q.setParameter("nroFactura", "%" + nroFactura + "%");
        }

        if (proveedor != null && !proveedor.equals("")) {
            q.setParameter("proveedor", "%" + proveedor + "%");
        }

        if (fechaFactura != null) {
            q.setParameter("fechaFactura", fechaFactura);
        }

        //Realizamos la busqueda
        List<FacturaCompraCab> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

    }

    /**
     * Este metodo recibe como parametro un Entity para insertar o persistir
     * dicha entidad a la base de datos.
     * @param entity
     * @return ControllerResult
     */
    public ControllerResult crear(FacturaCompraCab cabecera, List<FacturaCompraDet> detalle) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            //Persistimos la Cabecera
            em.persist(cabecera);

            //Persistimos el detalle
            if (detalle != null) {
                for (int i = 0; i < detalle.size(); i++) {
                    //Obtenemos el detalle a insertar
                    FacturaCompraDet det = detalle.get(i);

                    //Asignamos la cabecera al detalle
                    det.setCodFacComCab(cabecera);

                    //Persistimos
                    em.merge(det);
                }
            }

            //Confirmamos la transaccion
            tx.commit();

            //Retornos
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al persistir Factura Compra Proveedor Cabecera y detalle" + ex);
            try {
                tx.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            //Cerramos el entity manager
            em.close();

            //Result
            return r;
        }
    }

    /**
     * Actualizar Cabecera detalle de Factura de Compra
     * @param cabecera
     * @param detalle
     * @return
     */
    public ControllerResult actualizar(FacturaCompraCab cabecera, List<FacturaCompraDet> detalle, List<FacturaCompraDet> detalleAeliminar) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            //Iniciamos la transaccion
            tx.begin();

            //Actualizamos la Cabecera
            em.merge(cabecera);

            //Actualizamos el detalle
            if (detalle != null) {
                for (int i = 0; i < detalle.size(); i++) {
                    //Obtenemos el detalle a insertar
                    FacturaCompraDet det = detalle.get(i);

                    //Actualizamos
                    if (det.getCodFacComCab() == null) {
                        //Asignamos la cabecera al detalle
                        det.setCodFacComCab(cabecera);

                        //Persistir
                        em.persist(det);
                    } else {
                        //Actualizamos
                        em.merge(det);
                    }

                }
            }

            //Eliminamos los detalle seleccionados
            if (detalleAeliminar != null) {
                for (int i = 0; i < detalleAeliminar.size(); i++) {
                    //Obtenemos el detalle
                    FacturaCompraDet det = detalleAeliminar.get(i);

                    //Eliminamos
                    em.remove(det);
                }
            }


            //Confirmamos la transaccion
            tx.commit();

            //Retornos
            r.setCodRetorno(0);
            r.setMsg("Se creo Actualizo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al Actualizar Factura Compra Proveedor Cabecera y detalle" + ex);
            try {
                tx.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            //Cerramos el enetity manager
            em.close();

            //result
            return r;
        }
    }

    /**
     * Eliminamos factura cabecera y detalle de Compra Proveedor
     * @param cabecera
     * @param detalle
     * @return
     */
    public ControllerResult eliminar(FacturaCompraCab cabecera, List<FacturaCompraDet> detalle) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            //Iniciamos la transaccion
            tx.begin();

            //Eliminamos el detalle
            if (detalle != null) {
                for (int i = 0; i < detalle.size(); i++) {
                    //Obtenemos el detalle
                    FacturaCompraDet det = detalle.get(i);

                    //Eliminamos
                    em.remove(em.merge(det));
                }
            }


            //Eliminamos la Cabecera
            em.persist(cabecera);

            //Confirmamos la transaccion
            tx.commit();

            //Retornos
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al persistir Factura Compra Proveedor Cabecera y detalle" + ex);
            try {
                tx.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            //Cerramos el entity manager
            em.close();

            //Result
            return r;
        }
    }
}   
