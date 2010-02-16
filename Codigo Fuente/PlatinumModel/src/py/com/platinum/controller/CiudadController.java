/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Ciudad;

/**
 *
 * @author Martin
 */
public class CiudadController extends AbstractJpaDao<Ciudad> {

    public CiudadController() {
        super();
    }


    @Override
    public Ciudad findById(Long id) {
                return (Ciudad) this.findById(Ciudad.class, id);
    }

       @Override
    public List<Ciudad> getAll(String orderBy) {
        return this.getAll(Ciudad.class, orderBy);
     }

}   
