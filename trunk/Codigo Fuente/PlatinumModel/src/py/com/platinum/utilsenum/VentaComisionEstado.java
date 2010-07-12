/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utilsenum;

/**
 * Enum de los estados posibles de Recibo
 * @author mjara
 */
public enum VentaComisionEstado {

    PENDIENTE {
        @Override
        public String toString() {
            return "PENDIENTE";
        }
    },
    GENERADO {
        @Override
        public String toString() {
            return "GENERADO";
        }
    },
    CERRADO {
        @Override
        public String toString() {
            return "CERRADO";
        }
    },
    ANULADO {
        @Override
        public String toString() {
            return "ANULADO";
        }
    }
}
