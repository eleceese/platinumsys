/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.listener;

import java.math.BigInteger;
import javax.persistence.PostPersist;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.NotaCreditoProvDet;

/**
 *
 * @author mjara
 */
public class NotaCreditoProvDetalleListener {

    //Atributos
    private Existencia existencia;
    private ExistenciaController existenciaController;

    @PostPersist
    public void postInsert(NotaCreditoProvDet det) {
        //Inicializamos
        existenciaController = new ExistenciaController();

        //Actualizamos la existencia
        existencia = existenciaController.getExistencia(null, det.getCodProducto().getCodProducto(), det.getCodNotCreCab().getCodDeposito().getCodDeposito());

        //Obtenemos la cantidad en deposito
        BigInteger cantidad = existencia.getCantidadExistencia();

        //Reponemos la cantidad
        cantidad = BigInteger.valueOf(cantidad.longValue() - det.getCantidad());

        //Asignamos la cantidad nueva
        existencia.setCantidadExistencia(cantidad);

        //Actualizamos
        existenciaController.update(existencia);
    }
}
