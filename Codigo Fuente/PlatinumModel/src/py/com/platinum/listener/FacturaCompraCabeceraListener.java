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
import py.com.platinum.entity.FacturaCompraCab;
import py.com.platinum.entity.FacturaCompraDet;

/**
 *
 * @author mjara
 */
public class FacturaCompraCabeceraListener {

    //Atributos
    private Existencia existencia;
    private ExistenciaController existenciaController;


    @PostUpdate
    public void postUpdate(FacturaCompraCab cab) {
        //Inicializamos
        existenciaController =  new ExistenciaController();

        //Si la factura fue anulada
        if (cab.getEstado().toString().equals("A")) {


            //Actualizamos el detalle
            List<FacturaCompraDet> lstDet = cab.getFacturaCompraDetList();

            //Recorremos la lista de los detalles
            for (int i = 0; i < lstDet.size(); i++) {
                //Obtenemos el detalle
                FacturaCompraDet det = lstDet.get(i);

                //Actualizamos la existencia
                existencia = existenciaController.getExistencia(null, det.getCodProducto().getCodProducto(), det.getCodFacComCab().getCodDeposito().getCodDeposito());

                //Obtenemos la cantidad en deposito
                BigInteger cantidad = existencia.getCantidadExistencia();

                //Reponemos la cantidad vendida
                cantidad = BigInteger.valueOf(cantidad.longValue() - det.getCantidad());

                //Asignamos la cantidad nueva
                existencia.setCantidadExistencia(cantidad);

                //Actualizamos
                existenciaController.update(existencia);
            }

        }
    }
}
