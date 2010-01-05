/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utils;

/**
 *
 * @author Martin Jara 
 * mrjara 08-08-2008
 */
public class StringUtils {

    public StringUtils() {
    }

    /**   Concatena String pasado como parametro "tmp" a la izquierda de la cadena 
     * que se envia como parametro. 
     * Ejemplo: cadena("Ana"), cant(5), tmp("*"). En este caso retorna "**Ana".
     * 
     * @param cadena Cadena a ser rellenada.
     * @param cant Longitud de la cadena de retorno.
     * @param tmp String con la q se va a rellenar la cadena original.
     * @return String, cadena modificada
     * 
     * mrjara 08-08-2008
     */
    public static String lpad(String cadena, int cant, String tmp) {
        //Variables
        String result;

        //Inicializar Variables
        result = cadena;

        if (cant > result.length()) {
            result = generarString(cadena, cant, tmp) + result;
        }

        return result;
    }

    /**   Concatena String pasado como parametro "tmp" a la derecha de la cadena
     * que se envia como parametro. 
     * Ejemplo: cadena("Ana"), cant(5), tmp("*"). En este caso retorna "Ana**".
     * 
     * @param cadena Cadena a ser rellenada.
     * @param cant Longitud de la cadena de retorno.
     * @param tmp String con la q se va a rellenar la cadena original.
     * @return String, cadena modificada
     * 
     * mrjara 08-08-2008
     */
    public static String rpad(String cadena, int cant, String tmp) {
        //Variables
        String result;

        //Inicializar Variables
        result = cadena;

        if (cant > result.length()) {
            result = result + generarString(cadena, cant, tmp);
        }

        return result;
    }

    /**   Genera la cadena a conatenar a la cadena original
     * Ejemplo: cadena("Ana"), cant(5), tmp("*"). En este caso retorna "**".
     * 
     * @param cadena Cadena a ser rellenada.
     * @param cant Longitud de la cadena de retorno.
     * @param tmp String con la q se va a rellenar la cadena original.
     * @return String, cadena complemento "tmp"
     * 
     * mrjara 08-08-2008
     */
    private static String generarString(String cadena, int cant, String tmp) {
        //Variables
        int dif;
        String aux;

        //Inicializar Variables
        aux = new String("");

        if (cant > cadena.length()) {
            dif = cant - cadena.length();
            for (int i = 1; i <= dif; i++) {
                aux = aux + tmp;
            }
        }
        return aux;
    }

    /**
     * Validar si un String es numero.
     * 
     * @param s
     * @return true si es un numero.
     * @autor Martin Jara
     */
    public static boolean esNumero(String s) {
        //Variables
        long aux = 0;
        boolean result = true;

        //Convertir string a long.
        try {
            aux = new Long(s);
        } catch (NumberFormatException e) {
            result = !result;
        }

        //Result
        return result;
    }

    /**
     * Validar si una cadena contiene algun valor numerico
     * @param codigo
     * @return
     */
    public static boolean tieneNumero(String val) {
        //Variables
        String n = "0123456789";
        boolean r = false;

        //Recorremos la cadena
        if (val != null) {
            for (int i = 0; i < val.length(); i++) {
                String s = val.substring(i, i + 1);

                if (n.indexOf(s) > 0) {
                    r = !r;
                    break;
                }
            }

        }

        //result
        return r;
    }
}
