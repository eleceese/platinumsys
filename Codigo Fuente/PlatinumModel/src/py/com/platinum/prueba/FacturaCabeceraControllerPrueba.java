package py.com.platinum.prueba;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.com.platinum.controller.FacturaCabeceraController;
import py.com.platinum.entity.FacturaCabecera;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
public class FacturaCabeceraControllerPrueba {

    public static void main(String[] args){
        getAll();
        //Long.valueOf("");
        //getFacturaConSaldo();
    }

    private static void getAll() {
        List<FacturaCabecera> l = new FacturaCabeceraController().getAll(null);

        for (int i = 0; i < l.size(); i++) {
            FacturaCabecera f = l.get(i);

            System.out.println(f.getCodFactura());
        }
    }

    private static void getFacturaConSaldo() {
        List<FacturaCabecera> l = new FacturaCabeceraController().getFacturaConSaldo();

        for (int i = 0; i < l.size(); i++) {
            FacturaCabecera f = l.get(i);

            System.out.println(f.getCodCliente().getApellidoCliente());
        }
    }
}
