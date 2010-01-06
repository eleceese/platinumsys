/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Marca;

/**
 *
 * @author FerBoy
 */
public class MarcaController extends AbstractJpaDao<Marca> {

    public MarcaController() {
        super();
    }


    @Override
    public Marca findById(Long id) {
                return (Marca) this.findById(Marca.class, id);
    }

       @Override
    public List<Marca> getAll(String orderBy) {
        return this.getAll(Marca.class, orderBy);
     }

}
