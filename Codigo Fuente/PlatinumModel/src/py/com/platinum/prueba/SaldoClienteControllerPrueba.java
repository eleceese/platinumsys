package py.com.platinum.prueba;


import java.util.List;
import py.com.platinum.controller.SaldoClienteController;
import py.com.platinum.entity.SaldoCliente;

/*
 * To change this template, choose Tools | Templatese
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
public class SaldoClienteControllerPrueba {

    public static void main(String[] args){
        
        getAll();
    }

    private static void getAll() {
        List<SaldoCliente> l = new SaldoClienteController().getAll(null);

        for (int i = 0; i < l.size(); i++) {
            SaldoCliente x = l.get(i);
            System.out.println(x.getCodCliente().getNombreCliente());

        }
    }
}
