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
import py.com.platinum.entity.NotaCreditoProvCab;
import py.com.platinum.entity.NotaCreditoProvDet;
import py.com.platinum.utilsenum.FacturaVentaEstado;
import py.com.platinum.utilsenum.NotaCreditoEstado;

/**
 *
 * @author Martin
 */
public class NotaCreditoProvCabController extends AbstractJpaDao<NotaCreditoProvCab> {

    public NotaCreditoProvCabController() {
        super();
    }

    @Override
    public NotaCreditoProvCab findById(Long id) {
        return (NotaCreditoProvCab) this.findById(NotaCreditoProvCab.class, id);
    }

    @Override
    public List<NotaCreditoProvCab> getAll(String orderBy) {
        return this.getAll(NotaCreditoProvCab.class, orderBy);
    }

    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param nroFactura
     * @param proveedor
     *
     * @return lista de NotaCreditoProvCabs que cumplen con la condicion de busqueda
     */
    public List<NotaCreditoProvCab> getNotaCreditoProvCab(String nroNotaCredito, String proveedor, Date fechaFactura) {
        //Armamos el sql String
        String SQL = "SELECT o FROM NotaCreditoProvCab o WHERE o.codNotCreCab = o.codNotCreCab ";

        if (nroNotaCredito != null && !nroNotaCredito.equals("")) {
            SQL = SQL + " and UPPER(o.nroNotaCredito) like UPPER(:nroNotaCredito) ";
        }

        if (proveedor != null && !proveedor.equals("")) {
            SQL = SQL + " and UPPER(o.codProveedor.nombreProveedor) like UPPER(:proveedor) ";
        }

        if (fechaFactura != null) {
            SQL = SQL + " and o.fecha = :fechaFactura ";
        }

        //Order By
        SQL = SQL + " ORDER BY o.nroNotaCredito ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (nroNotaCredito != null && !nroNotaCredito.equals("")) {
            q.setParameter("nroNotaCredito", "%" + nroNotaCredito + "%");
        }

        if (proveedor != null && !proveedor.equals("")) {
            q.setParameter("proveedor", "%" + proveedor + "%");
        }

        if (fechaFactura != null) {
            q.setParameter("fechaFactura", fechaFactura);
        }

        //Realizamos la busqueda
        List<NotaCreditoProvCab> entities = q.getResultList();
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
    public ControllerResult crear(NotaCreditoProvCab cabecera, List<NotaCreditoProvDet> detalle) {
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
                    NotaCreditoProvDet det = detalle.get(i);

                    //Asignamos la cabecera al detalle
                    det.setCodNotCreCab(cabecera);

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
     * Verifca que si el nro de facutra ya existe, el control se realiza por
     * codigo de proveedor
     * 
     * @param nroFactura
     * @param codProveedor
     * @return true si se encontro mas de un registro, false en caso de no encontrar
     */
    public boolean existeNumeroNotaCredito(String nroNota, Long codProveedor) {
        //Variables
        boolean r = false;

        //Armamos el sql String
        String SQL = " SELECT o "
                + "   FROM NotaCreditoProvCab o "
                + "  WHERE o.nroNotaCredito = :nroFactura "
                + "    AND o.codProveedor.codProveedor = :codProveedor "
                + "    AND o.estado != :estado ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("nroFactura", nroNota);
        q.setParameter("codProveedor", codProveedor);
        q.setParameter("estado", NotaCreditoEstado.ANULADO);

        //Realizamos la busqueda
        List<NotaCreditoProvCab> entities = q.getResultList();
        em.close();

        //Verificamos si ya existe
        if (entities.size() > 0) {
            r = !r;
        }

        //retornamos la lista
        return r;

    }

    public Long getTotalNotaPorFactura(Long codFactura) {
        //Variables
        BigInteger r;
        String SQL;

        //Inicializamos
        r = BigInteger.valueOf(Long.valueOf("0"));

        //Armamos el SQL
        SQL = " SELECT SUM(o.total)               "
                + "   FROM NotaCreditoProvCab o              "
                + "  WHERE o.FacturaCompraCab.codFacComCab = :codFactura "
                + "    and o.estado != :estado     ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("estado", NotaCreditoEstado.ANULADO);
        q.setParameter("codFactura", codFactura);


        //Realizamos la busqueda
        r = (BigInteger) q.getSingleResult();

        if (r == null) {
            r = BigInteger.valueOf(Long.valueOf("0"));
        }

        //Cerar campos el entity manager
        em.close();

        //result
        return r.longValue();
    }
}   
