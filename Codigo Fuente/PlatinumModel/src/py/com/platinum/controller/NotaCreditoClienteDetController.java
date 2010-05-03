/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.NotaCreditoCliDetalle;

/**
 *
 * @author Martin
 */
public class NotaCreditoClienteDetController extends AbstractJpaDao<NotaCreditoCliDetalle> {

    public NotaCreditoClienteDetController() {
        super();
    }


    @Override
    public NotaCreditoCliDetalle findById(Long id) {
                return (NotaCreditoCliDetalle) this.findById(NotaCreditoCliDetalle.class, id);
    }

       @Override
    public List<NotaCreditoCliDetalle> getAll(String orderBy) {
        return this.getAll(NotaCreditoCliDetalle.class, orderBy);
     }

}   
