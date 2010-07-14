/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.listener;

import java.util.List;
import javax.persistence.PostUpdate;
import py.com.platinum.controller.SaldoClienteController;
import py.com.platinum.entity.ReciboCabecera;
import py.com.platinum.entity.ReciboDetalle;
import py.com.platinum.entity.SaldoCliente;
import py.com.platinum.utilsenum.ReciboEstado;

/**
 *
 * @author mjara
 */
public class ReciboCabeceraListener {

    //Atributos
    private SaldoCliente saldo;
    private SaldoClienteController dao;

    @PostUpdate
    public void postUpdate(ReciboCabecera cab) {
        //Inicializamos
        dao = new SaldoClienteController();

        //Si la factura fue anulada
        if (cab.getEstado().equals(ReciboEstado.ANULADO)) {

            //Actualizamos el detalle
            List<ReciboDetalle> lstDet = cab.getReciboDetalleList();


            //Recorremos la lista de los detalles
            for (int i = 0; i < lstDet.size(); i++) {
                //Obtenemos el detalle
                ReciboDetalle det = lstDet.get(i);

                //Actualizamos la existencia
                saldo = dao.findById(det.getCodReciboDet());

                //Actualizamos la existencia
                saldo = dao.findById(det.getCodSaldoCliente());

                //Obtenemos la cantidad en deposito
                Long montoSaldo = saldo.getSaldoCuota();

                //Reponemos la cantidad
                montoSaldo = (montoSaldo.longValue() + det.getMontoPago().longValue());

                //Asignamos la cantidad nueva
                saldo.setSaldoCuota(montoSaldo);

                //Actualizamos
                dao.update(saldo);
            }
        }
    }
}
