/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin Jara
 */
public class DateUtils {

    public static Map<String, String> getMeses() {
        Map ret = new LinkedHashMap();
        ret.put("Enero", 1);
        ret.put("Febrero", 2);
        ret.put("Marzo", 3);
        ret.put("Abril", 4);
        ret.put("Mayo", 5);
        ret.put("Junio", 6);
        ret.put("Julio", 7);
        ret.put("Agosto", 8);
        ret.put("Setiembre", 9);
        ret.put("Octubre", 10);
        ret.put("Noviembre", 11);
        ret.put("Diciembre", 12);
        return ret;
    }

    /**
     * Validacion de String - Date, formato soportado:
     *  1. dd/MM/yyyy
     *  2. dd/MM/yyyy HH:mm:ss
     *     0123456789012345678
     *
     * @param s
     * @return "" si la validacion fue exitosa
     */
    public static String validarDate(String s) {
        String aux;
        int dia, mes, anio, hora, min;

        try {
            //Obtener Valores
            if (s.length() > 10) {
                dia = Integer.parseInt(s.substring(0, 2));
                mes = Integer.parseInt(s.substring(3, 5));
                anio = Integer.parseInt(s.substring(6, 10));
                hora = Integer.parseInt(s.substring(11, 13));
                min = Integer.parseInt(s.substring(14, 16));
            } else if (s.length() == 10) {
                dia = Integer.parseInt(s.substring(0, 2));
                mes = Integer.parseInt(s.substring(3, 5));
                anio = Integer.parseInt(s.substring(6, 10));
                hora = 0;
                min = 0;
            } else {
                return null;
            }

            //Validar datos
            aux = "";
            aux = validarFecha(dia, mes, anio, hora, min);
        } catch (Exception e) {
            aux = "";
            e.printStackTrace();
        }

        //Return
        return aux;
    }

    /**
     * Conversion de String a Date, formato soportado:
     *  1. dd/MM/yyyy
     *  2. dd/MM/yyyy HH:mm:ss
     *
     * @param s
     * @return null si hubo algun error al convertir a Date
     */
    public static Date getDate(String s) {
        Date fec = null;
        String formato, aux;
        DateFormat df;
        int dia, mes, anio, hora, min;

        try {

            //Obtener Valores
            if (s.length() > 10) {
                formato = "dd/MM/yyyy HH:mm";
                dia  = Integer.parseInt(s.substring(0, 2));
                mes  = Integer.parseInt(s.substring(3, 5));
                anio = Integer.parseInt(s.substring(6, 10));
                hora = Integer.parseInt(s.substring(11, 13));
                min  = Integer.parseInt(s.substring(14, 16));
            } else if (s.length() == 10) {
                formato = "dd/MM/yyyy";
                dia  = Integer.parseInt(s.substring(0, 2));
                mes  = Integer.parseInt(s.substring(3, 5));
                anio = Integer.parseInt(s.substring(6, 10));
                hora = 0;
                min = 0;
            } else {
                return null;
            }

            //Validar datos
            aux = "";
            aux = validarFecha(dia, mes, anio, hora, min);

            //convretir a objeto Date
            if (aux.equals("")) {
                df = new SimpleDateFormat(formato);
                fec = new Date(df.parse(s).getTime());
            }
        } catch (Exception e) {
            fec = null;
            e.printStackTrace();
        }

        //Return
        return fec;
    }

    /**  Validar si el dia esta dentro del rango de dias
     * segun los valores de mes y año.
     *
     * @param aux dia a ser validado
     * @return boolean, true si es un dia valido.
     */
    public static String validarFecha(int dia, int mes, int anio, int hs, int min) {
        //Variables
        String result;
        int lastDay;

        //Inicializar Variables
        result = "";
        lastDay = 0;

        //Validar Anio
        result = validarAnio(anio);

        if (!result.equals("")) {
            return result;
        }

        //Validar Mes
        result = validarMes(mes);
        if (!result.equals("")) {
            return result;
        }


        //Validar Dia
        if (result.equals("")) {
            lastDay = getDiasMes(anio, mes);
            if (lastDay != 0) {
                if (dia >= 1 && dia <= lastDay) {
                    //Validar Hora
                    result = validarHora(hs);

                    //Validar Minuto
                    if (result.equals("")) {
                        result = validarMinuto(min);
                    }

                } else {
                    result = "El dia(" + dia +
                            "), debe estar en el rango, " + "1 - " +
                            lastDay + ", Para el año " + anio + " y mes " + mes + "." ;
                }
            } else {
                result = "Error al Obtener el Ultimo Dia de Mes.";
            }
        }

        return result;
    }

    /** Retorna el ultimo dia segun mes y año q se pasan por
     * parametro. Tambien se evalua si el año es bisiesto en el caso de que el
     * mes q se envio en el parametro se Febrero = 02.
     *
     * @param pYear Valor del año.
     * @param pMonth Valor de mes.
     * @return int, si el año <= 0 or si mes no esta en rango 1 al 12, se
     * retorna 0 (cero)
     */
    public static int getDiasMes(int pYear, int pMonth) {
        //Variables
        int anio;
        int month;
        GregorianCalendar calendar;
        try {
            //Inicializar Variales
            anio = pYear;
            month = pMonth;
            calendar = new GregorianCalendar();

            if (anio <= 0 || !(month >= 1 && month <= 12)) {
                return 0;
            } else {
                //enero, marzo, mayo, julio, agosto, octubre, diciembre
                if (month == 1 || month == 3 || month == 5 || month == 7 ||
                        month == 8 || month == 10 || month == 12) {
                    return 31;
                //abril, junio, septiembre, noviembre
                } else if (month == 4 || month == 6 || month == 9 ||
                        month == 11) {
                    return 30;
                //febrero
                } else {
                    if (month == 2) {
                        //Año bisiesto
                        if (calendar.isLeapYear(anio)) {
                            return 29;
                        } else if (!calendar.isLeapYear(anio)) {
                            return 28;
                        }
                    }
                }
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Valida mes debe esta en rango 1 - 12
     *
     *@param aux valor a validar
     */
    public static String validarMes(int aux) {
        //Variables
        String result;

        //Inicializar Variables
        result = "";

        //validar
        if (aux >= 1 && aux <= 12) {
            result = "";
        } else {
            result = "Mes incorrecto, debe estar entre 01 y 12.";
        }

        //result
        return result;
    }

    /**
     * Valida anio debe esta en rango mayor a 0
     *
     *@param aux valor a validar
     */
    public static String validarAnio(int aux) {
        //Variables
        String result;

        //Inicializar Variables
        result = "";

        //validar
        if (aux >= 1) {
            result = "";
        } else {
            result = "año incorrecto, debe ser mayor a cero (0)";
        }

        //result
        return result;
    }

    /**
     * Se valida si la hora esta en el ranro 0 - 23
     *
     *@param pHora Nuevo valor para hora.
     */
    public static String validarHora(int pHora) {
        //Variables
        String result;

        //Inicializar Variables
        result = "";

        //validar
        if (pHora >= 0 && pHora <= 23) {
            result = "";
        } else {
            result = "Hora fuera de rango, debe estar entre 00 al 23.";
        }

        //result
        return result;
    }

    /**
     * Valida si minuto esta en rango 0 - 59
     *
     *@param aux valor a validar
     */
    public static String validarMinuto(int aux) {
        //Variables
        String result;

        //Inicializar Variables
        result = "";

        //validar
        if (aux >= 0 && aux <= 59) {
            result = "";
        } else {
            result = "Minuto fuera de rango, debe estar entre 00 al 59.";
        }

        //result
        return result;
    }

    /**
     * Valida si segundo esta en rango 0 - 59
     *
     *@param aux valor a validar
     */
    public static String validarSegundo(int aux) {
        //Variables
        String result;

        //Inicializar Variables
        result = "";

        //validar
        if (aux >= 0 && aux <= 59) {
            result = "";
        } else {
            result = "Segundo fuera de rango, debe estar entre 00 al 59.";
        }

        //result
        return result;
    }

    /**
     * Convertir a String date.
     *
     * @param fecha
     * @param formato
     * @return
     */
    public static String toString(Date fecha, String formato){
       SimpleDateFormat formatter= new SimpleDateFormat (formato);
       return formatter.format(fecha);
    }

    public static Date fechaMas(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new Date(cal.getTimeInMillis());
    }

    public static Date fechaMenos(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, -dias);
        return new Date(cal.getTimeInMillis());
    }


    public static Date getFechaActual(){
        //Obtenemos la fecha del sistema
        Date f = new Date();
        //Establecemos el formato para las fechas
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            //Obtenemos el objetos Date aplicando el formato
            f = df.parse(df.format(f));
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return f;
    }

//    public static void main(String [] args){
//        System.out.println(DateUtils.fechaMas(new Date(), 1));
//    }
}
