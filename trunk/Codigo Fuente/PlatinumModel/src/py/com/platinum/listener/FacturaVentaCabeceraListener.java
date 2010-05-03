/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.listener;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.controller.PedidoCabeceraController;
import py.com.platinum.controller.SaldoClienteController;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.FacturaCabecera;
import py.com.platinum.entity.FacturaDetalle;
import py.com.platinum.entity.PedidoCabecera;
import py.com.platinum.entity.SaldoCliente;
import py.com.platinum.utils.DateUtils;
import py.com.platinum.utilsenum.PedidoVentaEstado;
import py.com.platinum.utilsenum.FacturaVentaEstado;

/**
 *
 * @author mjara
 */
public class FacturaVentaCabeceraListener {

    //Atributos
    private PedidoCabecera pedidoCabecera;
    private PedidoCabeceraController pedidoCabeceraController;
    private SaldoCliente saldoCliente;
    private SaldoClienteController saldoClienteController;
    private Existencia existencia;
    private ExistenciaController existenciaController;
    /**
     * Metodo que se ejecuta luego del evento Persist
     * @param cab
     */
    @PostPersist
    public void postInsert(FacturaCabecera cab) {
        //Inicializamos 
        saldoClienteController = new SaldoClienteController();

        /* Verificamos si la factura tiene un nro de Pedido asignado, en caso
         * de que se tenga un numero de pedido, actualizamos el estado del
         * Pedido a
         */
        if (cab.getCodPedido() != null && cab.getCodPedido().getCodPedido() != null) {
            //Obtenemos el Pedido
            pedidoCabecera = cab.getCodPedido();

            //Inicializamos el controller
            pedidoCabeceraController = new PedidoCabeceraController();

            //Cambiamos el estado
            pedidoCabecera.setEstadoPedido(PedidoVentaEstado.FACTURADO);

            //Actualizamos 
            pedidoCabeceraController.update(pedidoCabecera);

        }

        //Verificamos si es contado el comprobante no insertamos en la tabla de saldo
        if (cab.getTipoFactura().getCantDias() > 0) {
            //Persistimos el comprobante en el Entity SaldoCliente
            saldoCliente = new SaldoCliente();
            saldoCliente.setCodCliente(cab.getCodCliente());
            saldoCliente.setUsuarioAlta(cab.getUsuarioAlta());
            saldoCliente.setFechaAlta(new Date());
            saldoCliente.setNroComprobante(cab.getCodFactura());
 //**           saldoCliente.setTipoComprobante(cab.getTipoFactura());
            saldoCliente.setSaldo(cab.getTotalFactura());
            saldoCliente.setTotal(cab.getTotalFactura());
            saldoCliente.setFechaComprobante(cab.getFechaFactura());
            saldoCliente.setFechaVencimiento(DateUtils.fechaMas(cab.getFechaFactura(), cab.getTipoFactura().getCantDias()));
            //Persistimos
            saldoClienteController.create(saldoCliente);
        }
    }

    @PostUpdate
    public void postUpdate(FacturaCabecera cab) {
        //Inicializamos
        existenciaController =  new ExistenciaController();
        saldoClienteController = new SaldoClienteController();

        //Si la factura fue anulada
        if (cab.getEstadoFactura().toString().equals(FacturaVentaEstado.ANULADO.toString())) {
            //Si el comprobante es a Credito, actualizamos el saldo del cliente
            if (cab.getTipoFactura().getCantDias() > 0) {
                //Obtenemos el comprobante de la tabla factura
                saldoCliente = saldoClienteController.getSaldoCliente(cab.getTipoFactura().getCodTipo(), cab.getCodFactura());

                //Ceramos los totales
                saldoCliente.setTotal(Long.valueOf("0"));
                saldoCliente.setSaldo(Long.valueOf("0"));

                //Actualizamos
                saldoClienteController.update(saldoCliente);    
            }

            //Actualizamos el detalle
            List<FacturaDetalle> lstDet = cab.getFacturaDetalleList();

            //Recorremos la lista de los detalles
            for (int i = 0; i < lstDet.size(); i++) {
                //Obtenemos el detalle
                FacturaDetalle det = lstDet.get(i);
                //Actualizamos la existencia
                existencia = existenciaController.getExistencia(null, det.getCodProducto().getCodProducto(), det.getCodFactura().getCodDeposito().getCodDeposito());

                //Obtenemos la cantidad en deposito
                BigInteger cantidad = existencia.getCantidadExistencia();

                //Reponemos la cantidad vendida
                cantidad = BigInteger.valueOf(cantidad.longValue() + det.getCantidad().longValue());

                //Asignamos la cantidad nueva
                existencia.setCantidadExistencia(cantidad);

                //Actualizamos
                existenciaController.update(existencia);
            }

            /* Si la factura tiene un pedido de venta relacionado, actualizamos
               el estado del pedido
             */
            if (cab.getCodPedido() != null) {
                //Obtenemos el Pedido
                pedidoCabecera = cab.getCodPedido();

                //Actualizamos el estado
                pedidoCabecera.setEstadoPedido(PedidoVentaEstado.PENDIENTE);

                //Actualizamos
                pedidoCabeceraController.update(pedidoCabecera);
            }

        }
    }
}
