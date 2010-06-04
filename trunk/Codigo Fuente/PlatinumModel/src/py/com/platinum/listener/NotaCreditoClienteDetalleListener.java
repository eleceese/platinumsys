/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.listener;

import java.math.BigInteger;
import javax.persistence.PostPersist;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.NotaCreditoCliDetalle;

/**
 *
 * @author mjara
 */
public class NotaCreditoClienteDetalleListener {

    //Atributos
    private Existencia existencia;
    private ExistenciaController existenciaController;

    /**
     * Metodo que se ejecuta luego del evento Persist
     * @param cab
     */
    @PostPersist
    public void postInsert(NotaCreditoCliDetalle det){

        //Inicializamos el controller
        existenciaController =  new ExistenciaController();

        //Actualizamos la existencia
        existencia = existenciaController.getExistencia(null, det.getCodProducto().getCodProducto(), det.getCodNotaCreditoCliente().getCodFactura().getCodDeposito().getCodDeposito());

        //Obtenemos la cantidad en deposito
        BigInteger cantidad = existencia.getCantidadExistencia();

        //descontamos la cantidad vendida
        cantidad = BigInteger.valueOf(cantidad.longValue() + det.getCantidad().longValue());

        //Asignamos la cantidad nueva
        existencia.setCantidadExistencia(cantidad);

        //Actualizamos
        existenciaController.update(existencia);

    }
}
