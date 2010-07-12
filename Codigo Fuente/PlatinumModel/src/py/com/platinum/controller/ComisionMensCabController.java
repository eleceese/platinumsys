/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.ComisionMensCab;

/**
 *
 * @author Martin
 */
public class ComisionMensCabController extends AbstractJpaDao<ComisionMensCab> {

    public ComisionMensCabController() {
        super();
    }


    @Override
    public ComisionMensCab findById(Long id) {
                return (ComisionMensCab) this.findById(ComisionMensCab.class, id);
    }

       @Override
    public List<ComisionMensCab> getAll(String orderBy) {
        return this.getAll(ComisionMensCab.class, orderBy);
     }

}   
