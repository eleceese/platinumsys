/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.listener;

import java.math.BigInteger;
import javax.persistence.PostPersist;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.controller.SolicitudInternaController;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.FacturaCompraDet;
import py.com.platinum.entity.SolicitudInterna;

/**
 *
 * @author mjara
 */
public class FacturaCompraDetalleListener {

    //Atributos
    private SolicitudInterna solicitudInterna;
    private SolicitudInternaController solicitudInternaController;
    private Existencia existencia;
    private ExistenciaController existenciaController;

    /**
     * Metodo que se ejecuta luego del evento Persist
     * @param cab
     */
    @PostPersist
    public void postInsert(FacturaCompraDet det){

        //Inicializamos el controller
        existenciaController =  new ExistenciaController();
        solicitudInternaController = new SolicitudInternaController();

        /* Si el detalle esta relacionado a una solicitud, actualizamos
         * la cantidad entregada
         */
        if (det.getNroSolicitud() != null && det.getNroSolicitud().getCodSolicitud() != null) {
            //Obtenemos el codigo del detalle
            Long codDetalle = det.getNroSolicitud().getCodSolicitud();

            //Obtenemos el detalle
            solicitudInterna = solicitudInternaController.findById(codDetalle);

            //Actualizamos la cantidad comprada
            Long cantidad = solicitudInterna.getCantidadCompra();
            cantidad = cantidad + det.getCantidad();
            solicitudInterna.setCantidadCompra(cantidad);

            //Persistimos el cambio
            solicitudInternaController.update(solicitudInterna);

        }

        //Actualizamos la existencia
        existencia = existenciaController.getExistencia(null, det.getCodProducto().getCodProducto(), det.getCodFacComCab().getCodDeposito().getCodDeposito());

        //Obtenemos la cantidad en deposito
        BigInteger cantidad = existencia.getCantidadExistencia();

        //Ingresamos la cantidad comprada
        cantidad = BigInteger.valueOf(cantidad.longValue() + det.getCantidad());

        //Asignamos la cantidad nueva
        existencia.setCantidadExistencia(cantidad);

        //Actualizamos
        existenciaController.update(existencia);

    }
}
