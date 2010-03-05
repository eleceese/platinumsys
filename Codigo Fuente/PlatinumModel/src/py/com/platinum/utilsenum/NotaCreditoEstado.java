/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utilsenum;

/**
 * Enum de los estados posibles de la Nota de credito
 * @author mjara
 */
public enum NotaCreditoEstado {

    APLICADO {
        @Override
        public String toString() {
            return "APLICADO";
        }
    },
    ANULADO {
        @Override
        public String toString() {
            return "ANULADO";
        }
    }
}
