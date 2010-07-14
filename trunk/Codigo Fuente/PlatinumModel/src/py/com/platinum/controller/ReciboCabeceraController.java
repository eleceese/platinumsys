/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.MovimientoCajaDetalle;
import py.com.platinum.entity.ReciboCabecera;
import py.com.platinum.entity.ReciboDetalle;
import py.com.platinum.utilsenum.ReciboEstado;

/**
 *
 * @author Martin
 */
public class ReciboCabeceraController extends AbstractJpaDao<ReciboCabecera> {

    public ReciboCabeceraController() {
        super();
    }

    @Override
    public ReciboCabecera findById(Long id) {
        return (ReciboCabecera) this.findById(ReciboCabecera.class, id);
    }

    @Override
    public List<ReciboCabecera> getAll(String orderBy) {
        return this.getAll(ReciboCabecera.class, orderBy);
    }

    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de ReciboCabeceras que cumplen con la condicion de busqueda
     */
    public List<ReciboCabecera> getReciboCabeceras(String nroRecibo, String cliente, Date fecha) {
        //Armamos el sql String
        String SQL = "SELECT o FROM ReciboCabecera o WHERE o.codRecibo = o.codRecibo ";

        if (nroRecibo != null && !nroRecibo.equals("")) {
            SQL = SQL + " and cast(o.numeroRecibo as string) like :nroRecibo";
        }

        if (cliente != null && !cliente.equals("")) {
            SQL = SQL + " and UPPER( CONCAT(CONCAT(o.codCliente.apellidoCliente, '%'), o.codCliente.nombreCliente)) like UPPER(:cliente) ";
        }

        if (fecha != null) {
            SQL = SQL + " and o.fecha = :fecha ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (nroRecibo != null && !nroRecibo.equals("")) {
            q.setParameter("nroRecibo", "%" + nroRecibo + "%");
        }

        if (cliente != null && !cliente.equals("")) {
            q.setParameter("cliente", "%" + cliente + "%");
        }

        if (fecha != null) {
            q.setParameter("fecha", fecha);
        }

        //Realizamos la busqueda
        List<ReciboCabecera> entities = q.getResultList();
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
    public ControllerResult crear(ReciboCabecera cabecera, List<ReciboDetalle> detalle, List<MovimientoCajaDetalle> detalleMov) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            //Obtenemos el numero de la factura
            Long nro = getNroRecibo(cabecera.getSerieRecibo());
            cabecera.setNumeroRecibo(new BigInteger(nro.toString()));

            //Persistimos la Cabecera
            em.persist(cabecera);

            //Persistimos el detalle
            if (detalle != null) {
                for (int i = 0; i < detalle.size(); i++) {
                    //Obtenemos el detalle a insertar
                    ReciboDetalle det = detalle.get(i);

                    //Asignamos la cabecera al detalle
                    det.setCodRecibo(cabecera);

                    //Persistimos
                    em.persist(det);
                }
            }

            //Persistimos el detalle Forma Cobro
            if (detalleMov != null) {
                for (int i = 0; i < detalleMov.size(); i++) {
                    //Obtenemos el detalle a insertar
                    MovimientoCajaDetalle detMov = detalleMov.get(i);

                    //Asignamos la cabecera al detalle
                    detMov.setCodRecibo(cabecera);

                    //Persistimos
                    em.persist(detMov);
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
    public ControllerResult actualizar(ReciboCabecera cabecera, List<ReciboDetalle> detalle, List<ReciboDetalle> detalleAeliminar) {
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
                    ReciboDetalle det = detalle.get(i);

                    //Actualizamos
                    if (det.getCodRecibo() == null) {
                        //Asignamos la cabecera al detalle
                        det.setCodRecibo(cabecera);

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
                    ReciboDetalle det = detalleAeliminar.get(i);

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
    public ControllerResult eliminar(ReciboCabecera cabecera, List<ReciboDetalle> detalle) {
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
                    ReciboDetalle det = detalle.get(i);

                    //Eliminamos
                    em.remove(em.merge(det));
                }
            }


            //Eliminamos la Cabecera
            cabecera = findById(cabecera.getCodRecibo());
            em.remove(em.merge(cabecera));

            //Confirmamos la transaccion
            tx.commit();

            //Retornos
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al persistir recibo Cliente" + ex);
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
    public synchronized Long getNroRecibo(String serie) {
        //Variables
        BigInteger r;
        String SQL;

        //Inicializamos
        r = new BigInteger("0");

        //Armamos el SQL
        SQL = " SELECT MAX(o.numeroRecibo)      "
                + "   FROM ReciboCabecera o         "
                + "  WHERE o.serieRecibo = :serie   ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("serie", serie);

        //Realizamos la busqueda
        r = (BigInteger) q.getSingleResult();

        if (r == null) {
            r = new BigInteger("0");
        }

        //Cerar campos el entity manager
        em.close();

        //result
        return r.longValue() + 1;
    }

    /**
     * Obtener recibos por estado y por nombre de cliente, en el caso de nombre
     * se aplica una busqueda aproxima no sencible a mayuscula/minuscula
     * 
     * @param cliente
     * @param estado
     * @return lista de recibos que cumplan la condicion
     */
    public List<ReciboCabecera> getRecibo(String cliente, ReciboEstado estado) {
        //Armamos el sql String
        String SQL =
                " select r                      "
                + "   from ReciboCabecera r       "
                + "  where r.estado = :estado     ";

        if (cliente != null && !cliente.equals("")) {
            SQL = SQL + "    and UPPER( CONCAT(CONCAT(r.codCliente.apellidoCliente, '%'), r.codCliente.nombreCliente)) like UPPER(:cliente)  ";
        }

        //Order By
        SQL = SQL + " ORDER BY r.fecha desc ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("estado", estado);

        if (cliente != null && !cliente.equals("")) {
            q.setParameter("cliente", "%" + cliente + "%");
        }

        //Realizamos la busqueda
        List<ReciboCabecera> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

    }

    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de ReciboDetalles que cumplen con la condicion de busqueda
     */
    public boolean existeCheque(String serie, String numero, Long codBanco) {
        //Var
        boolean r = true;
        //Armamos el sql String
        String SQL = "SELECT o FROM MovimientoCajaDetalle o WHERE o.codFormaPago.codBanco is not null ";

        if (serie != null && !serie.equals("")) {
            SQL = SQL + " and UPPER(o.serieCheque) = UPPER(:serie)";
        }

        if (numero != null && !numero.equals("")) {
            SQL = SQL + " and UPPER(o.numeroCheque) = UPPER(:numero)";
        }

        if (codBanco != null) {
            SQL = SQL + " and o.codFormaPago.codBanco = :codBanco  ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (serie != null && !serie.equals("")) {
            q.setParameter("serie", "%" + serie + "%");
        }

        if (numero != null && !numero.equals("")) {
            q.setParameter("numero", "%" + numero + "%");
        }

        if (codBanco != null) {
            q.setParameter("codBanco", codBanco);
        }

        //Realizamos la busqueda
        List<ReciboDetalle> entities = q.getResultList();

        if (entities == null || entities.size() == 0) {
            r = !r;
        }

        em.close();

        //retornamos la lista
        return r;

    }
}   
