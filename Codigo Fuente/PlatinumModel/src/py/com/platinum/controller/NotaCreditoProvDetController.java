/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.NotaCreditoProvDet;

/**
 *
 * @author Martin
 */
public class NotaCreditoProvDetController extends AbstractJpaDao<NotaCreditoProvDet> {

    public NotaCreditoProvDetController() {
        super();
    }


    @Override
    public NotaCreditoProvDet findById(Long id) {
                return (NotaCreditoProvDet) this.findById(NotaCreditoProvDet.class, id);
    }

       @Override
    public List<NotaCreditoProvDet> getAll(String orderBy) {
        return this.getAll(NotaCreditoProvDet.class, orderBy);
     }

}   
