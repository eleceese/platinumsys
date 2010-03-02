/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.listener;

import javax.persistence.PostPersist;
import py.com.platinum.controller.PedidoDetalleController;
import py.com.platinum.entity.FacturaDetalle;
import py.com.platinum.entity.PedidoDetalle;

/**
 *
 * @author mjara
 */
public class FacturaVentaDetalleListener {

    //Atributos
    private PedidoDetalle pedidoDetalle;
    private PedidoDetalleController pedidoDetalleController;

    /**
     * Metodo que se ejecuta luego del evento Persist
     * @param cab
     */
    @PostPersist
    public void postInsert(FacturaDetalle det){

        /* Si el detalle esta relacionado a un detalle de pedido, actualizamos
         * la cantidad entregada
         */
        if (det.getCodPedidoDetalle() != null && det.getCodPedidoDetalle().getCodPedidoDetalle() != null) {
            //Obtenemos el codigo del detalle
            Long codDetalle = det.getCodPedidoDetalle().getCodPedidoDetalle();

            //Inicializamos el controller
            pedidoDetalleController = new PedidoDetalleController();

            //Obtenemos el detalle
            pedidoDetalle = pedidoDetalleController.findById(codDetalle);

            //Actualizamos la cantidad entregada
            Long cantidad = pedidoDetalle.getCantidadEntregada();
            cantidad = cantidad + det.getCantidad();
            pedidoDetalle.setCantidadEntregada(cantidad);

            //Persistimos el cambio
            pedidoDetalleController.update(pedidoDetalle);

        }
    }
}
