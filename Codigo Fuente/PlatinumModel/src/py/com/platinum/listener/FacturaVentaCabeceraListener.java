/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.listener;

import java.util.Date;
import javax.persistence.PostPersist;
import py.com.platinum.controller.PedidoCabeceraController;
import py.com.platinum.controller.SaldoClienteController;
import py.com.platinum.entity.FacturaCabecera;
import py.com.platinum.entity.PedidoCabecera;
import py.com.platinum.entity.SaldoCliente;
import py.com.platinum.utils.DateUtils;
import py.com.platinum.utilsenum.PedidoVentaEstado;

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
    

    /**
     * Metodo que se ejecuta luego del evento Persist
     * @param cab
     */
    @PostPersist
    public void postInsert(FacturaCabecera cab){
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

        //Persistimos el comprobante en el Entity SaldoCliente
        saldoCliente = new SaldoCliente();
        saldoCliente.setCodCliente(cab.getCodCliente());
        saldoCliente.setUsuarioAlta(cab.getUsuarioAlta());
        saldoCliente.setFechaAlta(new Date());
        saldoCliente.setNroComprobante(cab.getCodFactura());
        saldoCliente.setTipoComprobante(cab.getTipoFactura().getCodTipo());
        saldoCliente.setSaldo(cab.getTotalFactura());
        saldoCliente.setTotal(cab.getTotalFactura());
        saldoCliente.setFechaComprobante(cab.getFechaFactura());
        saldoCliente.setFechaVencimiento(DateUtils.fechaMas(cab.getFechaFactura(), cab.getTipoFactura().getCantDias()));
        //Persistimos
        saldoClienteController.create(saldoCliente);

    }
}
