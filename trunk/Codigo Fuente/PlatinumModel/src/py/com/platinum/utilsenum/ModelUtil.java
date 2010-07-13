/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utilsenum;

import java.util.Date;
import py.com.platinum.controller.ParametroController;
import py.com.platinum.utils.DateUtils;

/**
 *
 * @author mjara
 */
public class ModelUtil {

    public static int MAX_DIGITO_COMPROBANTE = 8;

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
        } else if (estado.equals(PedidoVentaEstado.ENTREGADO.toString())) {
            r = PedidoVentaEstado.ENTREGADO;
        } else if (estado.equals(PedidoVentaEstado.FACTURADO.toString())) {
            r = PedidoVentaEstado.FACTURADO;
        } else if (estado.equals(PedidoVentaEstado.PENDIENTE.toString())) {
            r = PedidoVentaEstado.PENDIENTE;
        } else if (estado.equals(PedidoVentaEstado.RECHAZADO.toString())) {
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
        } else if (estado.equals(FacturaVentaEstado.COBRADO.toString())) {
            r = FacturaVentaEstado.COBRADO;
        } else if (estado.equals(FacturaVentaEstado.PENDIENTE_COBRO.toString())) {
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
        } else if (estado.equals(NotaCreditoEstado.APLICADO.toString())) {
            r = NotaCreditoEstado.APLICADO;
        }

        //result
        return r;
    }

    /**
     * Para verificar si el periodo esta abierto
     * 
     * @return
     */
    public static boolean periodoAbierto() {
        //Variables
        boolean r = false;
        String fDesde, fHasta;
        Date desde, hasta, fec;
        ParametroController dao = new ParametroController();

        //Obtenemos el periodo abierto
        try {
            fDesde = dao.getParametro(ParametroEnum.PERIODO_ABIERTO_DESDE.toString()).getValorTexto();
        } catch (Exception e) {
            fDesde = "01/01/2010";
        }

        //Obtenemos el periodo abierto
        try {
            fHasta = dao.getParametro(ParametroEnum.PERIODO_ABIERTO_HASTA.toString()).getValorTexto();
        } catch (Exception e) {
            fHasta = "31/12/2010";
        }

        fec   = new Date();                //Fecha Actual
        desde = DateUtils.getDate(fDesde); //Fecha inicio de periodo abierto
        hasta = DateUtils.getDate(fHasta); //Fecha inicio de periodo cerrado

        if ((fec.after(desde) || fec.equals(desde)) && (fec.before(hasta) || fec.equals(hasta))) {
            r = !r;
        } 

        //result
        return r;
    }
}
