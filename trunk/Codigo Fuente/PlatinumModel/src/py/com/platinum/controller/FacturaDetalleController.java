/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.FacturaDetalle;

/**
 *
 * @author Martin
 */
public class FacturaDetalleController extends AbstractJpaDao<FacturaDetalle> {

    public FacturaDetalleController() {
        super();
    }


    @Override
    public FacturaDetalle findById(Long id) {
                return (FacturaDetalle) this.findById(FacturaDetalle.class, id);
    }

       @Override
    public List<FacturaDetalle> getAll(String orderBy) {
        return this.getAll(FacturaDetalle.class, orderBy);
     }

}   
