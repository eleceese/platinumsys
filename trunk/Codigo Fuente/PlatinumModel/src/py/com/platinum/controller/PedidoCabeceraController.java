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
import py.com.platinum.entity.PedidoCabecera;
import py.com.platinum.entity.PedidoDetalle;
import py.com.platinum.utilsenum.PedidoVentaEstado;

/**
 *
 * @author Martin
 */
public class PedidoCabeceraController extends AbstractJpaDao<PedidoCabecera> {

    public PedidoCabeceraController() {
        super();
    }

    @Override
    public PedidoCabecera findById(Long id) {
        return (PedidoCabecera) this.findById(PedidoCabecera.class, id);
    }

    @Override
    public List<PedidoCabecera> getAll(String orderBy) {
        return this.getAll(PedidoCabecera.class, orderBy);
    }

    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param nroFactura
     * @param proveedor
     *
     * @return lista de PedidoCabeceras que cumplen con la condicion de busqueda
     */
    public List<PedidoCabecera> getPedidoCabecera(String nroPedido, String cliente, Date fecha) {
        //Armamos el sql String
        String SQL = "SELECT o FROM PedidoCabecera o WHERE o.codPedido = o.codPedido ";

        if (nroPedido != null && !nroPedido.equals("")) {
            SQL = SQL + " and UPPER(o.codPedido) like UPPER(:nroPedido) ";
        }

        if (cliente != null && !cliente.equals("")) {
            SQL = SQL + " and UPPER( CONCAT(CONCAT(o.codCliente.apellidoCliente, '%'), o.codCliente.nombreCliente)) like UPPER(:cliente) ";
        }

        if (fecha != null) {
            SQL = SQL + " and o.fechaPedido = :fecha ";
        }

        //Order By
        SQL = SQL + " ORDER BY o.fechaPedido desc ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (nroPedido != null && !nroPedido.equals("")) {
            q.setParameter("nroPedido", "%" + nroPedido + "%");
        }

        if (cliente != null && !cliente.equals("")) {
            q.setParameter("cliente", "%" + cliente + "%");
        }

        if (fecha != null) {
            q.setParameter("fecha", fecha );
        }
        //Realizamos la busqueda
        List<PedidoCabecera> entities = q.getResultList();
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
    public ControllerResult crear(PedidoCabecera cabecera, List<PedidoDetalle> detalle) {
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
                    PedidoDetalle det = detalle.get(i);

                    //Asignamos la cabecera al detalle
                    det.setCodPedidoCab(cabecera);

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
    public ControllerResult actualizar(PedidoCabecera cabecera, List<PedidoDetalle> detalle, List<PedidoDetalle> detalleAeliminar) {
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
                    PedidoDetalle det = detalle.get(i);

                    //Actualizamos
                    if (det.getCodPedidoCab() == null) {
                        //Asignamos la cabecera al detalle
                        det.setCodPedidoCab(cabecera);

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
                    PedidoDetalle det = detalleAeliminar.get(i);

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
    public ControllerResult eliminar(PedidoCabecera cabecera, List<PedidoDetalle> detalle) {
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
                    PedidoDetalle det = detalle.get(i);

                    //Eliminamos
                    em.remove(em.merge(det));
                }
            }


            //Eliminamos la Cabecera
            cabecera = findById(cabecera.getCodPedido());
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
     * Verfica si existe nro de pedido
     * @param nroFactura
     * @param codFactura
     * @return
     */
    public boolean existeNroPedido(String nroPedido, Long codPedido) {
        //Variables
        boolean r;
        String SQL;

        //Inicializamos
        r = false;

        //Armamos el SQL
        SQL = "SELECT o FROM PedidoCabecera o WHERE o.codPedido = o.codPedido " +
              " and o.numeroPedido  = :nroPedido ";

        if (codPedido != null) {
            SQL = SQL + " and o.codPedido != :codPedido ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("nroPedido", nroPedido );

        if (codPedido != null ) {
            q.setParameter("codPedido", codPedido );
        }

        //Realizamos la busqueda
        List<PedidoCabecera> l = q.getResultList();

        if (l != null && l.size() > 0) {
            r = !r;
        }

        //Cerar campos el entity manager
        em.close();

        //result
        return r;
    }


    /**
     * Consulta de pedidos por estado y cliente
     * @param estado
     * @return
     */
    public List<PedidoCabecera> getPedidoCabecera(String cliente, PedidoVentaEstado estado) {
        //Armamos el sql String
        String SQL = "SELECT o FROM PedidoCabecera o WHERE o.estadoPedido = :estado ";


        if (cliente != null && !cliente.equals("")) {
            SQL = SQL + " and UPPER( CONCAT(CONCAT(o.codCliente.apellidoCliente, '%'), o.codCliente.nombreCliente)) like UPPER(:cliente) ";
        }

        //Order By
        SQL = SQL + " ORDER BY o.fechaPedido desc ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("estado", estado);

        if (cliente != null && !cliente.equals("")) {
            q.setParameter("cliente", "%" + cliente + "%");
        }

        //Realizamos la busqueda
        List<PedidoCabecera> entities = q.getResultList();
        
        em.close();

        //retornamos la lista
        return entities;

    }
}   
