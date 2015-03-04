/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase que se encarga de cargar dar formatos
 * a numeros a partir de un patron dado
 * Pueden utilizarse todos los patrones que soporta el DecimalFormat
 *
 * @author Gustavo Cabello
 * @version 1.0
 * @creationdate 2006-02-10
 */
public class Formated {
    private DecimalFormat dfn= null;
    NumberFormat f = NumberFormat.getInstance();
    private SimpleDateFormat dateFormat=null;

    public Formated(){
        dfn=(DecimalFormat)f;
        dateFormat = new SimpleDateFormat();
    }
    /**
     * Metodo que recibe el patron a aplicar al numero
     * @param String recibe el patron para formatear un numero, los
     *               patrones son los que se utilizan en la clase DecimalFormat
     *
     */
    public void setNumberPattern(String sPattern){
        dfn.applyPattern(sPattern);
    }

    /**
     * Metodo que recibe un String de numero y devuelve un String formateado del numero
     * @param String recibe el numero a formatear Ej. '230564'
     * @retun String retorna el numero formateado Ej. '230.564'
     * */
    public String getNumberFormat(String sNumber) throws Exception{
        String sNumberFormat="";
        double dNumber=0;
        if (sNumber == null || sNumber.equals(""))
            sNumberFormat="0";
        else{
            dNumber= Double.parseDouble(sNumber);
            sNumberFormat= dfn.format(dNumber);
        }
        return sNumberFormat;
    }

    /**
     * Metodo que recibe un String de numero y devuelve un String del numero sin formato
     * @param String recibe el numero formateado Ej. '230.564'
     * @retun String retorna el numero sin formato Ej. '230564'
     * */
    public String getNumberParse(String sNumber)throws Exception{
        String sNumberFormat=null;
        if (sNumber == null || sNumber.equals(""))
            sNumberFormat="0";
        else
            sNumberFormat= String.valueOf(dfn.parse(sNumber));
        return sNumberFormat;
    }

    /**
     * Metodo que recibe un String de numero y devuelve un String formateado del numero
     * @param String recibe la fecha a formateada Ej. '24/05/2006'
     * @retun Date retorna el objeto de tipo Date
     * */
    public Date getDateParse(String sDate)throws Exception{
        Date dDateFormat=null;
        dDateFormat= dateFormat.parse(sDate);
        return dDateFormat;
    }

    /**
     * Metodo que recibe el patron a aplicar a la fecha
     * @param String recibe el patron para formatear fechas, los
     *               patrones son los que se utilizan en la clase SimpleDateFormat
     *
     */
    public void setDatePattern(String sPattern){
        dateFormat.applyPattern(sPattern);
    }

    /**
     * Metodo que recibe un Objeto de tipo Date y devuelve un String formateado segun el string cargado en setDatePattern
     * @param Date recibe un objeto de tipo Date
     * @retun String retorna la fecha formateada Ej. '24/05/2006'
     * */
    public String getDateFormat(Date dDate)throws Exception{
        String sFormat= null;
        sFormat= dateFormat.format(dDate);
        return sFormat;
    }

    /**
     * Metodo que recibe un Calendar y devuelve un String formateado segun el string cargado en setDatePattern
     * @param Calendar recibe un objeto de tipo Calendar
     * @retun String retorna la fecha formateada Ej. '24/05/2006'
     * */
    public String getDateFormat(Calendar dDate)throws Exception{
        String sFormat= null;
        sFormat= dateFormat.format(dDate);
        return sFormat;
    }
}
