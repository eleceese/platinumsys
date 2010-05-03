/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utilsenum;

/**
 * Enum de los modulos
 * @author mjara
 */
public enum ModuloEnum {

    COMPRA {
        @Override
        public String toString() {
            return "COMPRA";
        }
    },
    VENTA {
        @Override
        public String toString() {
            return "VENTA";
        }
    },
    COBRANZA {
        @Override
        public String toString() {
            return "COBRANZA";
        }
    },
    PEDIDO_CLIENTE {
        @Override
        public String toString() {
            return "PEDIDO CLIENTE";
        }
    },
    PAGO_PROVEEDOR {
        @Override
        public String toString() {
            return "PAGO PROVEEDOR";
        }
    },
    PAGO_CLIENTE {
        @Override
        public String toString() {
            return "PAGO CLIENTE";
        }
    }
}
