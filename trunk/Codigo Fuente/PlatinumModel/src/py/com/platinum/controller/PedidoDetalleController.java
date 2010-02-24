/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.PedidoDetalle;

/**
 *
 * @author Martin
 */
public class PedidoDetalleController extends AbstractJpaDao<PedidoDetalle> {

    public PedidoDetalleController() {
        super();
    }


    @Override
    public PedidoDetalle findById(Long id) {
                return (PedidoDetalle) this.findById(PedidoDetalle.class, id);
    }

       @Override
    public List<PedidoDetalle> getAll(String orderBy) {
        return this.getAll(PedidoDetalle.class, orderBy);
     }

}   
