/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utilsenum;

/**
 * Enum de los estados posibles de Recibo
 * @author mjara
 */
public enum ReciboEstado {

    PENDIENTE {
        @Override
        public String toString() {
            return "PENDIENTE";
        }
    },
    PAGADO {
        @Override
        public String toString() {
            return "PAGADO";
        }
    },
    ANULADO {
        @Override
        public String toString() {
            return "ANULADO";
        }
    }
}
