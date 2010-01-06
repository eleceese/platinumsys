/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.UnidadMedida;

/**
 *
 * @author FerBoy
 */
public class UnidadMedidaController extends AbstractJpaDao<UnidadMedida> {

    public UnidadMedidaController() {
        super();
    }


    @Override
    public UnidadMedida findById(Long id) {
                return (UnidadMedida) this.findById(UnidadMedida.class, id);
    }

    @Override
    public List<UnidadMedida> getAll(String orderBy) {
        return this.getAll(UnidadMedida.class, orderBy);
     }

}
