/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.utilsenum;

/**
 *
 * @author mjara
 */
public class ModelUtil {


    /**
     * Obtenemos el tipo de Estado
     * @param estado
     * @return
     */
    public static PedidoVentaEstado getPedidoEstado(String estado) {
        //Variables
        PedidoVentaEstado r = PedidoVentaEstado.PENDIENTE;

        //Verificamos el tipo de estado
        if (estado.equals(PedidoVentaEstado.ANULADO.toString())) {
            r = PedidoVentaEstado.ANULADO;
        }else if (estado.equals(PedidoVentaEstado.ENTREGADO.toString())) {
            r = PedidoVentaEstado.ENTREGADO;
        }else if (estado.equals(PedidoVentaEstado.FACTURADO.toString())) {
            r = PedidoVentaEstado.FACTURADO;
        }else if (estado.equals(PedidoVentaEstado.PENDIENTE.toString())) {
            r = PedidoVentaEstado.PENDIENTE;
        }else if (estado.equals(PedidoVentaEstado.RECHAZADO.toString())) {
            r = PedidoVentaEstado.RECHAZADO;
        }

        //result
        return r;
    }

    /**
     * Obtenemos el estado de la factura
     * @param estado
     * @return
     */
    public static FacturaVentaEstado getFacturaVentaEstado(String estado) {
        //Variables
        FacturaVentaEstado r = FacturaVentaEstado.PENDIENTE_COBRO;

        //Verificamos el tipo de estado
        if (estado.equals(FacturaVentaEstado.ANULADO.toString())) {
            r = FacturaVentaEstado.ANULADO;
        }else if (estado.equals(FacturaVentaEstado.COBRADO.toString())) {
            r = FacturaVentaEstado.COBRADO;
        }else if (estado.equals(FacturaVentaEstado.PENDIENTE_COBRO.toString())) {
            r = FacturaVentaEstado.PENDIENTE_COBRO;
        }

        //result
        return r;
    }

    /**
     * Obtenemos el tipo de Estado
     * @param estado
     * @return
     */
    public static NotaCreditoEstado getNotaCreditoEstado(String estado) {
        //Variables
        NotaCreditoEstado r = NotaCreditoEstado.APLICADO;

        //Verificamos el tipo de estado
        if (estado.equals(NotaCreditoEstado.ANULADO.toString())) {
            r = NotaCreditoEstado.ANULADO;
        }else if (estado.equals(NotaCreditoEstado.APLICADO.toString())) {
            r = NotaCreditoEstado.APLICADO;
        }

        //result
        return r;
    }
}
