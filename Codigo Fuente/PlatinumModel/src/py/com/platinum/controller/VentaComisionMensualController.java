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
import py.com.platinum.entity.ComisionMensCab;
import py.com.platinum.entity.ComisionMensDet;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.VentaComisionMensual;
import py.com.platinum.utils.DateUtils;
import py.com.platinum.utils.StringUtils;
import py.com.platinum.utilsenum.VentaComisionEstado;
import py.com.platinum.view.VendedorComision;

/**
 *
 * @author Martin
 */
public class VentaComisionMensualController extends AbstractJpaDao<VentaComisionMensual> {

    public VentaComisionMensualController() {
        super();
    }


    @Override
    public VentaComisionMensual findById(Long id) {
                return (VentaComisionMensual) this.findById(VentaComisionMensual.class, id);
    }

       @Override
    public List<VentaComisionMensual> getAll(String orderBy) {
        return this.getAll(VentaComisionMensual.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de VentaComisionMensuals que cumplen con la condicion de busqueda
     */
    public List<VentaComisionMensual> getVentaComisionMensual(String mes, String anio, String estado) {
        //Armamos el sql String
        String SQL = "SELECT o FROM VentaComisionMensual o WHERE o.codComision = o.codComision";

        if (estado != null) {
            SQL = SQL + " and o.estado = :estado ";
        }

        if (mes != null && !mes.equals("")) {
            SQL = SQL + " and o.mes = :mes ";
        }

        if (anio != null && !anio.equals("")) {
            SQL = SQL + " and o.anio = :anio ";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (estado != null) {
            q.setParameter("estado", estado);
        }

        if (mes != null && !mes.equals("")) {
            q.setParameter("mes", mes);
        }

        if (anio != null && !anio.equals("")) {
            q.setParameter("anio",  anio);
        }

        //Realizamos la busqueda
        List<VentaComisionMensual> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }


    public ControllerResult generarComisiones(VentaComisionMensual p, String usuario){
        //Variables
        ControllerResult r;
        VentaComisionMensual vc;
        VentaComisionMensualController dao;

        //Inicializamos
        r = new ControllerResult();
        dao = new VentaComisionMensualController();

        //Verificamos q el peridoo exista
        vc = dao.findById(p.getCodComision());

        //Controlamos
        if (vc != null) {
            //Controlamos el estado
            if (vc.getEstado().equals(VentaComisionEstado.PENDIENTE.toString())) {
                int cant = generarComisionesVenta(vc, usuario);
                r.setCodRetorno(0);
                r.setMsg("Comisiones Generadas Correctamente..., " + cant + ", Vendedores Procedos.");
            } else {
                r.setCodRetorno(2);
                r.setMsg("Periodo debe estar en estado igual a Pendiente, para poder generar las comisiones." +
                        "Este perdio tiene estado igual a, " + vc.getEstado());
            }

        }else{
            r.setCodRetorno(1);
            r.setMsg("Periodo no encontrado");
        }


        return r;
    }

    private int generarComisionesVenta(VentaComisionMensual vc, String usuario) {
        //Variables
        int tot = 0;
        Date ini, fin;
        Empleado[] lstEmpleado;
        FacturaCabeceraController daoVTA = new FacturaCabeceraController();
        FacturaDetalleController daoVTAdet = new FacturaDetalleController();

        //Comisiones
        ComisionMensCab comiCab;
        ComisionMensDet comiDet;

        ini = DateUtils.getDate("01"+"/"+vc.getMes()+"/"+vc.getAnio());
        String diaFin = String.valueOf(DateUtils.getDiasMes(Integer.valueOf(vc.getAnio()), Integer.valueOf(vc.getMes())));
        diaFin = StringUtils.lpad(diaFin, 2, "0");
        fin = DateUtils.getDate(diaFin+"/"+vc.getMes()+"/"+vc.getAnio());


        //Obtener los Vendedores, con ventas en perido
        lstEmpleado = daoVTA.getListaEmpleadoComision(ini, fin);

        //Si encontramos ventas, recorremos la lista de empleado con venta
        if (lstEmpleado != null) {
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            try {
                //Iniciamos la transaccion
                tx.begin();

                tot = lstEmpleado.length;
                for (int i = 0; i < lstEmpleado.length; i++) {
                    //Obtenemos un empleado
                    Empleado emp = lstEmpleado[i];

                    //Creamos el objeto comision mensual cab
                    comiCab = new ComisionMensCab();
                    comiCab.setCodComision(vc);
                    comiCab.setCodEmpleado(emp);
                    comiCab.setFecha(new Date());
                    comiCab.setFechaAlta(new Date());
                    comiCab.setUsuarioAlta(usuario);

                    //Obtener las comisiones con por empleado
                    VendedorComision[] comisiones = getVendedorComisiones(emp, vc.getMes(), vc.getAnio());

                    if (comisiones != null) {
                        //Persistimos la cabecerad de la comision
                        em.persist(comiCab);
                        
                        for (int j = 0; j < comisiones.length; j++) {
                            VendedorComision comision = comisiones[j];

                            //Creamos el objeto comision mensual det
                            comiDet = new ComisionMensDet();
                            comiDet.setCodComMenCab(comiCab);
                            comiDet.setCodProducto(new ProductoController().findById(comision.getCodProducto()));
                            comiDet.setDetComMontoComision(comision.getTotalComision().longValue());
                            comiDet.setDetComMontoVenta(comision.getTotalVenta().longValue());
                            comiDet.setDetComPorc(comision.getPorcentajeComision());
                            comiDet.setFechaAlta(new Date());
                            comiDet.setUsuarioAlta(usuario);

                            //Persistimos el detalle
                            em.persist(comiDet);
                        }
                    }

                }
                //Confirmamos la transaccion
                tx.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                try {
                    tx.rollback();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return tot;
    }


    public VendedorComision[] getVendedorComisiones(Empleado e, String mes, String anio){
        //Variables
        VendedorComision[] entities  = new VendedorComision[0];

        if (e != null && mes !=null && anio != null ) {
             //Armamos el sql String
            String SQL =  "select rownum                      as numRow,              "
                        + "       v_inline.codProducto        as codProducto,         "
                        + "       v_inline.porcentajeComision as porcentajeComision,  "
                        + "       v_inline.totalVenta         as totalVenta,          "
                        + "       v_inline.totalComision      as totalComision        "
                        + "from (                                                     "
                        + "select p.cod_producto as codProducto,                      "
                        + "       nvl(fd.porc_comision, 0) as porcentajeComision,     "
                        + "       sum(((fd.precio_unitario*fd.cantidad) - (nvl(fd.monto_descuento, 0))) ) as totalVenta,  "
                        + "       sum(((fd.precio_unitario*fd.cantidad) - (nvl(fd.monto_descuento, 0))) * nvl(fd.porc_comision, 0) / 100) as totalComision  "
                        + "                                                                             "
                        + "  from factura_cabecera fc                                              "
                        + "       inner join factura_detalle fd on fd.cod_factura = fc.cod_factura "
                        + "       inner join producto  p on p.cod_producto = fd.cod_producto       "
                        + " where fc.estado_factura != 'ANULADO'                    "
                        + "   and to_char(fc.fecha_factura, 'MM') = :mes          "
                        + "   and to_char(fc.fecha_factura, 'YYYY') = :anio       "
                        + "   and fc.cod_empleado = :codEmpleado                  "
                        + "group by p.cod_producto,  nvl(fd.porc_comision, 0)     "
                        + "having sum(((fd.precio_unitario*fd.cantidad) - (nvl(fd.monto_descuento, 0))) * nvl(fd.porc_comision, 0) / 100) > 0 "
                        + ") v_inline                                   ";

            EntityManager em = emf.createEntityManager();
            Query q = em.createNativeQuery(SQL, VendedorComision.class);

            //Seteamos los parametros

            q.setParameter("codEmpleado", e.getCodEmpleado());
            q.setParameter("mes", mes);
            q.setParameter("anio",  anio);

            //Realizamos la busqueda
            try {
                entities = (VendedorComision[])q.getResultList().toArray(new VendedorComision[0]);
            } catch (Exception ex) {
                entities  = new VendedorComision[0];
            }
            

            em.close();
        }

        //retornamos la lista
        return entities;
    }
}   


