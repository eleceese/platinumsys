/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utilsenum;

/**
 * Enum de los parametros
 * @author mjara
 */
public enum ParametroEnum {

    SERIE_RECIBO { @Override public String toString() { return "SERIE_RECIBO";}},
    COD_ESTABLECIMIENTO { @Override public String toString() { return "COD_ESTABLECIMIENTO";}},
    COD_BOCA_EXPENDIO { @Override public String toString() { return "COD_BOCA_EXPENDIO";}},
    NRO_TIMBRADO { @Override public String toString() { return "NRO_TIMBRADO";}},
    VENCIMIENTO_TIMBRADO { @Override public String toString() { return "VENCIMIENTO_TIMBRADO";}}
    
}
