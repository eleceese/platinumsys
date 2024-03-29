/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.EntradaSalidaCabecera;
import py.com.platinum.entity.EntradaSalidaDetalle;
import py.com.platinum.entity.Equivalencia;
import py.com.platinum.entity.FacturaCompraCab;
import py.com.platinum.entity.FacturaCompraDet;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.SolicitudInterna;
import py.com.platinum.entity.Usuarios;
import py.com.platinum.utilsenum.FacturaCompraEstado;

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
    public List<FacturaCompraCab> getFacturaCompraCab(String nroFactura, String proveedor, Date fechaFactura, String estado) {
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

        if (estado != null && !estado.equals("T")) {
            SQL = SQL + " and o.estado = :estado ";
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

        if (estado != null && !estado.equals("T")) {
            q.setParameter("estado", estado);
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
                    em.persist(det);

                    ///// Actualizacion de la utilizacion a traves de la equivalencia
                                Producto p = null;
                                SolicitudInterna solIn = null;
                                p = det.getCodProducto();

                                Long cantidad = null;
                                cantidad = det.getCantidad();
                                if (det.getNroSolicitud() !=null && det.getNroSolicitud().getCodSolicitud() != null) {
                                    solIn  = det.getNroSolicitud();
                                }

                                if (solIn != null && p != null && cantidad != null) {

                                        SolicitudInterna sol = new SolicitudInterna();
                                        SolicitudInternaController sController = new SolicitudInternaController();
                                        sol = sController.getSolicitudPorEquiv(det.getNroSolicitud().getCodSolicitud(),p.getCodProducto());

                                            Equivalencia eq = new EquivalenciaController().getEqPorProductos(sol.getCodProducto().getCodProducto(), p.getCodProducto());
                                            double relacion = eq.getRelacion().doubleValue();
                                            double retirado = relacion * cantidad;
                                            sol.setCantidadCompra(sol.getCantidadCompra() + Math.round(retirado));
                                            em.merge(sol);
                                     }
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
        EntradaSalidaCabecera entSalCab = new EntradaSalidaCabecera();
        
        try {
            //Iniciamos la transaccion
            tx.begin();

            //Actualizamos la Cabecera
            em.merge(cabecera);
            Deposito d = new DepositoController().findById(cabecera.getCodDeposito().getCodDeposito());
            
            /* Controlamos que existan productos que mejen existencia en el detalle
             * y que tambien el estado de la factura sea igual a confirmad(C)
             */
            if (hayProductoControlaExistencia(detalle) && cabecera.getEstado().equals("C")) {
                /*  Creacion de la Cabecera Movimiento en Deposito
                 * Obtenemos el empleado por medio del usuario que realizada la confirmacion */
                Usuarios usuModif = new UsuarioController().getUsuario(cabecera.getUsuarioModif());
                Empleado emp = new Empleado();

                //Obtenemos el empleado
                if (usuModif != null) {
                    emp = usuModif.getCodEmpleado();
                }

                //Texto para la entrada salida, cabecera
                String textoCabecera;
                textoCabecera = "Movimiento en Deposito generado por la Factura Proveedor Nro: "+cabecera.getNroFactura().toString();

                //Creamos el Objeto Entrada Salida Cabecera
                entSalCab.setCodDeposito(d);
                entSalCab.setCodEmpleado(emp);
                entSalCab.setCodEncargado(emp);
                entSalCab.setFechaEntradaSalida(cabecera.getFecha());
                entSalCab.setNroComprobante(cabecera.getCodFacComCab());
                entSalCab.setTipoComprobante(cabecera.getTipo().getCodTipo());
                entSalCab.setObservacion(textoCabecera);
                entSalCab.setFechaAlta(new Date());

                //Persistimos la cabecera de la entrada salida
                em.persist(entSalCab);
            }

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

                        //Verificamos si el producto maneja existencia
                        if (det.getCodProducto().getControlaExistencia() != null && det.getCodProducto().getControlaExistencia().equals("S")){
                            // Creacion de los detalles Movimiento en Deposito
                            EntradaSalidaDetalle entSalDet = new EntradaSalidaDetalle();
                            Producto p = new ProductoController().findById(det.getCodProducto().getCodProducto().longValue());
                            Existencia ex = new ExistenciaController().getExistencia(null, p.getCodProducto(), d.getCodDeposito());
                            Double cantidadExistencia = ex.getCantidadExistencia().doubleValue();
                            if (cabecera.getEstado().equals("C")) {
                                //Creamos el objeto detalle de la entrada-salida
                                        entSalDet.setCodEntradaSalida(entSalCab);
                                        entSalDet.setCodProducto(p);
                                        entSalDet.setTipoEntradaSalida("E");
                                        entSalDet.setCantidadEntSal(BigInteger.valueOf(det.getCantidad()));
                                        cantidadExistencia = cantidadExistencia + det.getCantidad();
                                        entSalDet.setExistencia(BigDecimal.valueOf(cantidadExistencia));
                                        entSalDet.setFechaAlta(cabecera.getFecha());

                                        //Persistimos el objeto detalle de la entrada-salida
                                        em.persist(entSalDet);
                            }
                        }
                    }

                }
            }

            //Eliminamos los detalle seleccionados
            if (detalleAeliminar != null) {
                for (int i = 0; i < detalleAeliminar.size(); i++) {
                    //Obtenemos el detalle
                    FacturaCompraDet det = detalleAeliminar.get(i);

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
            cabecera = findById(cabecera.getCodFacComCab());
            em.remove(em.merge(cabecera));

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
     * Verifca que si el nro de facutra ya existe, el control se realiza por
     * codigo de proveedor
     * 
     * @param nroFactura
     * @param codProveedor
     * @return true si se encontro mas de un registro, false en caso de no encontrar
     */
    public boolean existeNumeroFactura(String nroFactura, Long codProveedor) {
        //Variables
        boolean r = false;

        //Armamos el sql String
        String SQL = " SELECT o " +
                "   FROM FacturaCompraCab o " +
                "  WHERE o.nroFactura = :nroFactura " +
                "    AND o.codProveedor.codProveedor = :codProveedor " +
                "    AND o.estado != :estado ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("nroFactura", nroFactura);
        q.setParameter("codProveedor", codProveedor);
        q.setParameter("estado", "A");

        //Realizamos la busqueda
        List<FacturaCompraCab> entities = q.getResultList();
        em.close();

        //Verificamos si ya existe
        if (entities.size() > 0) {
            r = !r;
        }

        //retornamos la lista
        return r;

    }

    public List<FacturaCompraCab> getFacturaCompraCab(String proveedor, FacturaCompraEstado estado) {
        //Armamos el sql String
        String SQL = "SELECT o FROM FacturaCompraCab o WHERE o.estado = :estado ";


        if (proveedor != null && !proveedor.equals("")) {
            SQL = SQL + " and UPPER( o.codProveedor.nombreProveedor ) like UPPER(:proveedor) ";
        }

        //Order By
        SQL = SQL + " ORDER BY o.fecha desc ";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        q.setParameter("estado", estado.toString());

        if (proveedor != null && !proveedor.equals("")) {
            q.setParameter("proveedor", "%" + proveedor + "%");
        }

        //Realizamos la busqueda
        List<FacturaCompraCab> entities = q.getResultList();

        em.close();

        //retornamos la lista
        return entities;

    }

    /*
     * Controla si hay almenos un detalle con producto que maneje existencia
     */
    private boolean hayProductoControlaExistencia(List<FacturaCompraDet> detalle) {
        //Variables
        boolean r;

        //Inicializamos
        r = false;

        //Recorremos el detalle
        if (detalle != null) {
            for (int i = 0; i < detalle.size(); i++) {
                FacturaCompraDet det = detalle.get(i);

                //Verificamos si el producto maneja existencia
                if (det.getCodProducto().getControlaExistencia() != null && det.getCodProducto().getControlaExistencia().equals("S")){
                    r = !r;
                    break;
                }

            }
        }

        //Resutlt
        return r;
    }
}   
