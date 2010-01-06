/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Presentacion;

/**
 *
 * @author FerBoy
 */
public class PresentacionController extends AbstractJpaDao<Presentacion> {

    public PresentacionController() {
        super();
    }


    @Override
    public Presentacion findById(Long id) {
                return (Presentacion) this.findById(Presentacion.class, id);
    }

    @Override
    public List<Presentacion> getAll(String orderBy) {
        return this.getAll(Presentacion.class, orderBy);
     }

}
