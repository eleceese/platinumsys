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
import py.com.platinum.entity.NotaCreditoCliCabecera;
import py.com.platinum.entity.NotaCreditoCliDetalle;

/**
 *
 * @author Martin
 */
public class NotaCreditoClienteCabController extends AbstractJpaDao<NotaCreditoCliCabecera> {

    public NotaCreditoClienteCabController() {
        super();
    }

    @Override
    public NotaCreditoCliCabecera findById(Long id) {
        return (NotaCreditoCliCabecera) this.findById(NotaCreditoCliCabecera.class, id);
    }

    @Override
    public List<NotaCreditoCliCabecera> getAll(String orderBy) {
        return this.getAll(NotaCreditoCliCabecera.class, orderBy);
    }

    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param nroNotaCredito
     * @param proveedor
     *
     * @return lista de NotaCreditoCliCabeceras que cumplen con la condicion de busqueda
     */
    public List<NotaCreditoCliCabecera> getNotaCreditoCliCabecera(String nroNotaCredito, String cliente, Date fecha) {
        //Armamos el sql String
        String SQL = "SELECT o FROM NotaCreditoCliCabecera o WHERE o.codNotaCreditoCliente = o.codNotaCreditoCliente ";

        if (nroNotaCredito != null && !nroNotaCredito.equals("")) {
            SQL = SQL + " and UPPER(o.numNotaCredtoCliente) like UPPER(:nroNotaCredito) ";
        }

        if (cliente != null && !cliente.equals("")) {
            SQL = SQL + " and UPPER( CONCAT(CONCAT(o.codCliente.nombreCliente, '%'), o.codCliente.apellidoCliente) ) like UPPER(:cliente) ";
        }

        if (fecha != null) {
            SQL = SQL + " and o.fecha = :fecha ";
        }

        //Order By
        SQL = SQL + " ORDER BY o.numNotaCredtoCliente ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (nroNotaCredito != null && !nroNotaCredito.equals("")) {
            q.setParameter("nroNotaCredito", "%" + nroNotaCredito + "%");
        }

        if (cliente != null && !cliente.equals("")) {
            q.setParameter("cliente", "%" + cliente + "%");
        }

        if (fecha != null) {
            q.setParameter("fecha", fecha);
        }

        //Realizamos la busqueda
        List<NotaCreditoCliCabecera> entities = q.getResultList();
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
    public ControllerResult crear(NotaCreditoCliCabecera cabecera, List<NotaCreditoCliDetalle> detalle) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            //Obtenemos el nro. de nota de credito
            BigInteger nroNota = new BigInteger(getNroNotaCredito(cabecera.getEstablecimiento(), cabecera.getBocaExpendio()).toString());
            cabecera.setNumNotaCredtoCliente(nroNota);

            //Persistimos la Cabecera
            em.persist(cabecera);

            //Persistimos el detalle
            if (detalle != null) {
                for (int i = 0; i < detalle.size(); i++) {
                    //Obtenemos el detalle a insertar
                    NotaCreditoCliDetalle det = detalle.get(i);

                    //Asignamos la cabecera al detalle
                    det.setCodNotaCreditoCliente(cabecera);

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
            r.setMsg("Error al persistir Nota Credito Proveedor Cabecera y detalle" + ex);
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
    public synchronized  Long getNroNotaCredito(String establecimiento, String bocaExpendio) {
        //Variables
        BigInteger  r;
        String SQL;

        //Inicializamos
        r = BigInteger.valueOf(Long.valueOf("0"));

        //Armamos el SQL
        SQL = " SELECT MAX(o.numNotaCredtoCliente)            " +
              "   FROM NotaCreditoCliCabecera o               " +
              "  WHERE o.establecimiento = :establecimiento   " +
              "    AND o.bocaExpendio    = :bocaExpendio      ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("establecimiento", establecimiento );
        q.setParameter("bocaExpendio", bocaExpendio );


        //Realizamos la busqueda
        r = (BigInteger) q.getSingleResult();

        if (r == null) {
            r = BigInteger.valueOf(Long.valueOf("0"));
        }

        //Cerar campos el entity manager
        em.close();

        //result
        return r.longValue() + 1;
    }
}   
