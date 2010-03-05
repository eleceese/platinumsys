/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utilsenum;

/**
 * Enum de los estados posibles de la Factura compra
 * @author mjara
 */
public enum FacturaCompraEstado {

    RECIBIDO {
        @Override
        public String toString() {
            return "C";
        }
    },
    ANULADO {
        @Override
        public String toString() {
            return "A";
        }
    }
}
