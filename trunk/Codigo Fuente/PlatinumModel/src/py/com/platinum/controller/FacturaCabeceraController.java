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
import py.com.platinum.entity.FacturaCabecera;
import py.com.platinum.entity.FacturaDetalle;

/**
 *
 * @author Martin
 */
public class FacturaCabeceraController extends AbstractJpaDao<FacturaCabecera> {

    public FacturaCabeceraController() {
        super();
    }

    @Override
    public FacturaCabecera findById(Long id) {
        return (FacturaCabecera) this.findById(FacturaCabecera.class, id);
    }

    @Override
    public List<FacturaCabecera> getAll(String orderBy) {
        return this.getAll(FacturaCabecera.class, orderBy);
    }

    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param nroFactura
     * @param proveedor
     *
     * @return lista de FacturaCabeceras que cumplen con la condicion de busqueda
     */
    public List<FacturaCabecera> getFacturaCabecera(String nroFactura, String cliente, Date fecha) {
        //Armamos el sql String
        String SQL = "SELECT o FROM FacturaCabecera o WHERE o.codFactura = o.codFactura ";

        if (nroFactura != null && !nroFactura.equals("")) {
            SQL = SQL + " and UPPER(o.numeroFactura) like UPPER(:nroFactura) ";
        }

        if (cliente != null && !cliente.equals("")) {
            SQL = SQL + " and UPPER( CONCAT(CONCAT(o.codCliente.apellidoCliente, '%'), o.codCliente.nombreCliente)) like UPPER(:cliente) ";
        }

        if (fecha != null) {
            SQL = SQL + " and o.fechaFactura = :fecha ";
        }

        //Order By
        SQL = SQL + " ORDER BY o.fechaFactura desc ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (nroFactura != null && !nroFactura.equals("")) {
            q.setParameter("nroFactura", "%" + nroFactura + "%");
        }

        if (cliente != null && !cliente.equals("")) {
            q.setParameter("cliente", "%" + cliente + "%");
        }

        if (fecha != null) {
            q.setParameter("fecha", fecha );
        }
        //Realizamos la busqueda
        List<FacturaCabecera> entities = q.getResultList();
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
    public ControllerResult crear(FacturaCabecera cabecera, List<FacturaDetalle> detalle) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            //Obtenemos el numero de la factura
            Long nroFactura= getNroFactura(cabecera.getEstablecimiento(), cabecera.getBocaExpendio());
            cabecera.setNumeroFactura(nroFactura);

            //Persistimos la Cabecera
            em.persist(cabecera);

            //Persistimos el detalle
            if (detalle != null) {
                for (int i = 0; i < detalle.size(); i++) {
                    //Obtenemos el detalle a insertar
                    FacturaDetalle det = detalle.get(i);

                    //Asignamos la cabecera al detalle
                    det.setCodFactura(cabecera);

                    //Persistimos
                    em.persist(det);
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
            r.setMsg("Error al persistir Pedido Cliente" + ex);
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
     * Actualizar Cabecera detalle de Pedido cliente
     * @param cabecera
     * @param detalle
     * @return
     */
    public ControllerResult actualizar(FacturaCabecera cabecera, List<FacturaDetalle> detalle, List<FacturaDetalle> detalleAeliminar) {
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
                    FacturaDetalle det = detalle.get(i);

                    //Actualizamos
                    if (det.getCodFactura() == null) {
                        //Asignamos la cabecera al detalle
                        det.setCodFactura(cabecera);

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
                    FacturaDetalle det = detalleAeliminar.get(i);

                    //Eliminamos
                    em.remove(em.merge(det));
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
            r.setMsg("Error al Actualizar Pedido Cliente" + ex);
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
     * Eliminamos pedido cabecera y detalle de Compra Proveedor
     * @param cabecera
     * @param detalle
     * @return
     */
    public ControllerResult eliminar(FacturaCabecera cabecera, List<FacturaDetalle> detalle) {
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
                    FacturaDetalle det = detalle.get(i);

                    //Eliminamos
                    em.remove(em.merge(det));
                }
            }


            //Eliminamos la Cabecera
            cabecera = findById(cabecera.getCodFactura());
            em.remove(em.merge(cabecera));

            //Confirmamos la transaccion
            tx.commit();

            //Retornos
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al persistir Pedido Cliente" + ex);
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
     * Retorna Nro de facrura, a utilizar para el establecimiento y boca de
     * expendio que se recibe por parametro
     * @param establecimiento
     * @param bocaExpendio
     * @return Numero de Factura
     */
    public Long getNroFactura(String establecimiento, String bocaExpendio) {
        //Variables
        Long r;
        String SQL;

        //Inicializamos
        r = new Long("0");

        //Armamos el SQL
        SQL = " SELECT MAX(o.numeroFactura)                   " +
              "   FROM FacturaCabecera o                      " +
              "  WHERE o.establecimiento = :establecimiento   " +
              "    AND o.bocaExpendio    = :bocaExpendio      ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("establecimiento", establecimiento );
        q.setParameter("bocaExpendio", bocaExpendio );


        //Realizamos la busqueda
        r = (Long) q.getSingleResult();

        if (r == null) {
            r = new Long("0");
        }

        //Cerar campos el entity manager
        em.close();

        //result
        return r + 1;
    }

}   
