/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.SaldoCliente;

/**
 *
 * @author Martin
 */
public class SaldoClienteController extends AbstractJpaDao<SaldoCliente> {

    public SaldoClienteController() {
        super();
    }

    @Override
    public SaldoCliente findById(Long id) {
        return (SaldoCliente) this.findById(SaldoCliente.class, id);
    }

    @Override
    public List<SaldoCliente> getAll(String orderBy) {
        return this.getAll(SaldoCliente.class, orderBy);
    }
}   
