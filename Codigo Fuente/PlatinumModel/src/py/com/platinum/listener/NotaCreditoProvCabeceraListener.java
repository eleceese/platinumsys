/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.listener;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.PostUpdate;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.NotaCreditoProvCab;
import py.com.platinum.entity.NotaCreditoProvDet;
import py.com.platinum.utilsenum.NotaCreditoEstado;

/**
 *
 * @author mjara
 */
public class NotaCreditoProvCabeceraListener {

    //Atributos
    private Existencia existencia;
    private ExistenciaController existenciaController;

    @PostUpdate
    public void postUpdate(NotaCreditoProvCab cab) {
        //Inicializamos
        existenciaController = new ExistenciaController();

        //Si la factura fue anulada
        if (cab.getEstado().equals(NotaCreditoEstado.ANULADO)) {

            //Actualizamos el detalle
            List<NotaCreditoProvDet> lstDet = cab.getNotaCreditoProvDet();

            //Recorremos la lista de los detalles
            for (int i = 0; i < lstDet.size(); i++) {
                //Obtenemos el detalle
                NotaCreditoProvDet det = lstDet.get(i);

                //Actualizamos la existencia
                existencia = existenciaController.getExistencia(null, det.getCodProducto().getCodProducto(), det.getCodNotCreCab().getCodDeposito().getCodDeposito());

                //Obtenemos la cantidad en deposito
                BigInteger cantidad = existencia.getCantidadExistencia();

                //Reponemos la cantidad vendida
                cantidad = BigInteger.valueOf(cantidad.longValue() + det.getCantidad());

                //Asignamos la cantidad nueva
                existencia.setCantidadExistencia(cantidad);

                //Actualizamos
                existenciaController.update(existencia);
            }
        }
    }
}
