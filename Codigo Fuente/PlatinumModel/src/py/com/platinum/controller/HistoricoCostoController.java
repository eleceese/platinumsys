/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.HistoricoCosto;
import py.com.platinum.entity.Producto;

/**
 *
 * @author Martin
 */
public class HistoricoCostoController extends AbstractJpaDao<HistoricoCosto> {

    public HistoricoCostoController() {
        super();
    }

    @Override
    public HistoricoCosto findById(Long id) {
        return (HistoricoCosto) this.findById(HistoricoCosto.class, id);
    }

    @Override
    public List<HistoricoCosto> getAll(String orderBy) {
        return this.getAll(HistoricoCosto.class, orderBy);
    }

    public int calcularCostoPromedio(Long codProducto, BigInteger costoEntrada, BigDecimal existenciaEntrada){
        //Variables
        int r;
        Producto pro;
        HistoricoCosto h;
        ProductoController daoPro;
        double costo, existencia;

        //Inicializamos
        r = -1;
        h = new HistoricoCosto();
        daoPro = new ProductoController();

        //Constrolamos que valores null
        if(codProducto != null && costoEntrada != null && existenciaEntrada != null) {
            pro = daoPro.findById(codProducto);
            //Si el no se encontro retornamos 1
            if (pro == null) {
                r = 1;
            }else{
                try {
                    BigInteger cantidadActual = new ExistenciaController().getCantidadExistencia(codProducto);
                    existencia = existenciaEntrada.doubleValue() + cantidadActual.doubleValue();
                    
                    costo = costoEntrada.doubleValue() * existenciaEntrada.doubleValue();
                    costo = costo + (pro.getCostoActual().intValue() * cantidadActual.doubleValue());
                    costo = costo / existencia;

                    //Creamos el objeto historico a insertar
                    h.setCodProducto(pro);
                    h.setCostoActual(pro.getCostoActual());
                    h.setCostoCompra(costoEntrada);
                    h.setCostoHistorico(BigInteger.valueOf(Math.round(costo)));
                    h.setExistenciaActual(BigDecimal.valueOf(cantidadActual.longValue()));
                    h.setExistenciaCompra(existenciaEntrada);
                    h.setFecHistoricoCosto(new Date());
                    h.setFechaAlta(new Date());
                    h.setUsuarioAlta("Admin");

                    this.create(h);

                    //Actualizamos el costo del producto
                    pro.setCostoActual(BigInteger.valueOf(Math.round(costo)));
                    new ProductoController().update(pro);

                    r = 0;

                } catch (Exception e) {
                    e.printStackTrace();
                    r = -1;
                }
            }
        }

        return r;
    }

}   
