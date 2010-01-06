/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.TipoProducto;

/**
 *
 * @author FerBoy
 */
public class TipoProductoController extends AbstractJpaDao<TipoProducto> {

    public TipoProductoController() {
        super();
    }


    @Override
    public TipoProducto findById(Long id) {
                return (TipoProducto) this.findById(TipoProducto.class, id);
    }

    @Override
    public List<TipoProducto> getAll(String orderBy) {
        return this.getAll(TipoProducto.class, orderBy);
     }

}
