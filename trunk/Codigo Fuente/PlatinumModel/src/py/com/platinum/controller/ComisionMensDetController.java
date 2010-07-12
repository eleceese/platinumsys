/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.ComisionMensDet;

/**
 *
 * @author Martin
 */
public class ComisionMensDetController extends AbstractJpaDao<ComisionMensDet> {

    public ComisionMensDetController() {
        super();
    }

    @Override
    public ComisionMensDet findById(Long id) {
                return (ComisionMensDet) this.findById(ComisionMensDet.class, id);
    }

       @Override
    public List<ComisionMensDet> getAll(String orderBy) {
        return this.getAll(ComisionMensDet.class, orderBy);
     }
   
}   
