/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.listener;

import java.math.BigInteger;
import javax.persistence.PostPersist;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.controller.PedidoDetalleController;
import py.com.platinum.entity.Existencia;
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
    private Existencia existencia;
    private ExistenciaController existenciaController;

    /**
     * Metodo que se ejecuta luego del evento Persist
     * @param cab
     */
    @PostPersist
    public void postInsert(FacturaDetalle det) {

        //Inicializamos el controller
        existenciaController = new ExistenciaController();
        pedidoDetalleController = new PedidoDetalleController();

        //Controlamos que le producto maneje existencia
        if (det.getCodProducto().getControlaExistencia() != null && det.getCodProducto().getControlaExistencia().equals("S")) {

            /* Si el detalle esta relacionado a un detalle de pedido, actualizamos
             * la cantidad entregada
             */
            if (det.getCodPedidoDetalle() != null && det.getCodPedidoDetalle().getCodPedidoDetalle() != null) {
                //Obtenemos el codigo del detalle
                Long codDetalle = det.getCodPedidoDetalle().getCodPedidoDetalle();

                //Obtenemos el detalle
                pedidoDetalle = pedidoDetalleController.findById(codDetalle);

                //Actualizamos la cantidad entregada
                Long cantidad = pedidoDetalle.getCantidadEntregada();
                cantidad = cantidad + det.getCantidad();
                pedidoDetalle.setCantidadEntregada(cantidad);

                //Persistimos el cambio
                pedidoDetalleController.update(pedidoDetalle);

            }

            //Actualizamos la existencia
            existencia = existenciaController.getExistencia(null, det.getCodProducto().getCodProducto(), det.getCodFactura().getCodDeposito().getCodDeposito());

            //Obtenemos la cantidad en deposito
            BigInteger cantidad = existencia.getCantidadExistencia();

            //descontamos la cantidad vendida
            cantidad = BigInteger.valueOf(cantidad.longValue() - det.getCantidad().longValue());

            //Asignamos la cantidad nueva
            existencia.setCantidadExistencia(cantidad);

            //Actualizamos
            existenciaController.update(existencia);

        }
    }
}
