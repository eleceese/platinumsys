/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.listener;

import java.math.BigInteger;
import javax.persistence.PostPersist;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.controller.SaldoClienteController;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.ReciboDetalle;
import py.com.platinum.entity.SaldoCliente;

/**
 *
 * @author mjara
 */
public class ReciboDetalleListener {

    //Atributos
    private SaldoCliente saldo;
    private SaldoClienteController dao;

    @PostPersist
    public void postInsert(ReciboDetalle det) {
        //Inicializamos
        dao = new SaldoClienteController();

        //Actualizamos la existencia
        saldo = dao.findById(det.getCodSaldoCliente());

        //Obtenemos la cantidad en deposito
        Long montoSaldo = saldo.getSaldoCuota();

        //Reponemos la cantidad
        montoSaldo = (montoSaldo.longValue() - det.getMontoPago().longValue());

        //Asignamos la cantidad nueva
        saldo.setSaldoCuota(montoSaldo);

        //Actualizamos
        dao.update(saldo);
    }
}
