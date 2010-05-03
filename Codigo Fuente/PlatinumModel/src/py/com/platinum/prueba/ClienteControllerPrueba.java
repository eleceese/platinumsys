package py.com.platinum.prueba;


import java.util.List;
import py.com.platinum.controller.ClienteController;
import py.com.platinum.entity.Cliente;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
public class ClienteControllerPrueba {

    public static void main(String[] args){
        getAll();
    }

    private static void getAll() {
        List<Cliente> l = new ClienteController().getAll(null);

        for (int i = 0; i < l.size(); i++) {
            Cliente x = l.get(i);
            System.out.println(x.getNombreCliente());

        }
    }
}
