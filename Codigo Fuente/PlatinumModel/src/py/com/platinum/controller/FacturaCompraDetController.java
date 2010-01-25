/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.FacturaCompraDet;

/**
 *
 * @author Martin
 */
public class FacturaCompraDetController extends AbstractJpaDao<FacturaCompraDet> {

    public FacturaCompraDetController() {
        super();
    }


    @Override
    public FacturaCompraDet findById(Long id) {
                return (FacturaCompraDet) this.findById(FacturaCompraDet.class, id);
    }

       @Override
    public List<FacturaCompraDet> getAll(String orderBy) {
        return this.getAll(FacturaCompraDet.class, orderBy);
     }
    
}   
