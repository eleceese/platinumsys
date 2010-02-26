/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utilsenum;

/**
 * Enum de los estados posibles del pedido de venta
 * @author mjara
 */
public enum FacturaVentaEstado {

    PENDIENTE_COBRO {
        @Override
        public String toString() {
            return "PENDIENTE COBRO";
        }
    },
    COBRADO {
        @Override
        public String toString() {
            return "COBRADO";
        }
    },
    ANULADO {
        @Override
        public String toString() {
            return "ANULADO";
        }
    }
}
