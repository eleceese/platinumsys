/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.listener;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.controller.SaldoClienteController;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.NotaCreditoCliCabecera;
import py.com.platinum.entity.NotaCreditoCliDetalle;
import py.com.platinum.entity.SaldoCliente;
import py.com.platinum.utils.DateUtils;
import py.com.platinum.utilsenum.NotaCreditoEstado;

/**
 *
 * @author mjara
 */
public class NotaCreditoClienteCabeceraListener {

    //Atributos
    private SaldoCliente saldoCliente;
    private SaldoClienteController saldoClienteController;
    private Existencia existencia;
    private ExistenciaController existenciaController;

    /**
     * Metodo que se ejecuta luego del evento Persist
     * @param cab
     */
    @PostPersist
    public void postInsert(NotaCreditoCliCabecera cab) {
        //Inicializamos 
        saldoClienteController = new SaldoClienteController();
        saldoCliente = new SaldoCliente();
        long total = cab.getTotalNotaCredito().longValue();
        total = total * -1;

        //Asignamos los valores para el objeto SaldoCliente
        saldoCliente.setCodCliente(cab.getCodCliente());
        saldoCliente.setUsuarioAlta(cab.getUsuarioAlta());
        saldoCliente.setFechaAlta(new Date());
        saldoCliente.setNroComprobante(cab.getCodNotaCreditoCliente());
        saldoCliente.setTipoComprobante(cab.getTipoFactura().getCodTipo());
        saldoCliente.setSaldoComprobante(total);
        saldoCliente.setTotalComprobante(total);
        saldoCliente.setFechaComprobante(cab.getFechaNotaCredito());
        saldoCliente.setNroCuota(Long.valueOf("1"));
        saldoCliente.setMontoCuota(total);
        saldoCliente.setSaldoCuota(total);

        //Fecha Vencimiento
        Date fecVencimiento = DateUtils.fechaMas(cab.getFechaNotaCredito(), cab.getTipoFactura().getCantDias());
        saldoCliente.setFechaVencimiento(fecVencimiento);

        //Persistimos
        saldoClienteController.create(saldoCliente);
    }

    @PostUpdate
    public void postUpdate(NotaCreditoCliCabecera cab) {
        //Inicializamos
        existenciaController = new ExistenciaController();
        saldoClienteController = new SaldoClienteController();

        //Si la factura fue anulada
        if (cab.getEstado().toString().equals(NotaCreditoEstado.ANULADO.toString())) {

            saldoClienteController.anularComprobante(cab.getTipoFactura().getCodTipo(), cab.getCodNotaCreditoCliente());

            //Actualizamos el detalle
            List<NotaCreditoCliDetalle> lstDet = cab.getNotaCreditoCliDetalleList();

            //Recorremos la lista de los detalles
            for (int i = 0; i < lstDet.size(); i++) {
                //Obtenemos el detalle
                NotaCreditoCliDetalle det = lstDet.get(i);
                //Actualizamos la existencia
                existencia = existenciaController.getExistencia(null, det.getCodProducto().getCodProducto(), cab.getCodFactura().getCodDeposito().getCodDeposito());

                //Obtenemos la cantidad en deposito
                BigInteger cantidad = existencia.getCantidadExistencia();

                //Reponemos la cantidad vendida
                cantidad = BigInteger.valueOf(cantidad.longValue() - det.getCantidad().longValue());

                //Asignamos la cantidad nueva
                existencia.setCantidadExistencia(cantidad);

                //Actualizamos
                existenciaController.update(existencia);
            }
        }
    }
}
