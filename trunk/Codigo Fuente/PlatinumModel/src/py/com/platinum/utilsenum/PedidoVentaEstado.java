/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utilsenum;

/**
 * Enum de los estados posibles del pedido de venta
 * @author mjara
 */
public enum PedidoVentaEstado {

    PENDIENTE {
        @Override
        public String toString() {
            return "PENDIENTE";
        }
    },
    FACTURADO {
        @Override
        public String toString() {
            return "FACTURADO";
        }
    },
    ENTREGADO {
        @Override
        public String toString() {
            return "ENTREGADO";
        }
    },
    RECHAZADO {
        @Override
        public String toString() {
            return "RECHAZADO";
        }
    },
    ANULADO {
        @Override
        public String toString() {
            return "ANULADO";
        }
    }
}
