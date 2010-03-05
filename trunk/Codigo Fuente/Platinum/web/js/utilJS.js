/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Popup con 2 destinos.
 */

//Variables
var popup;

function doPopup(destination1) {
    popup = window.open("", "popup", "height=500,width=500,toolbar=no, menubar=no,scrollbars=yes");

    if( destination1 != null ){
        destinationElement1=document.getElementById(destination1);
    }else{
        destinationElement1=null;
    }

    popup.focus();
}

function setVal(val1){
    if (destinationElement1 != null){
        destinationElement1.value = val1;
    }
}

function doSave(val1) {
    window.opener.setVal(val1);
    window.close();
}

function doPopup(destination1, destination2 ) {
    popup = window.open("", "popup", "height=500,width=500,toolbar=no, menubar=no,scrollbars=yes");

    if( destination1 != null ){
        destinationElement1=document.getElementById(destination1);
    }else{
        destinationElement1=null;
    }

    if( destination2 != null ){
        destinationElement2=document.getElementById(destination2);
    }else{
        destinationElement2=null;
    }

    popup.focus();
}

function setVal(val1, val2){
    if (destinationElement1 != null){
        destinationElement1.value = val1;
    }
 
    if (destinationElement2 != null){
        destinationElement2.value = val2;
    }

}

function doSave(val1, val2) {
    window.opener.setVal(val1, val2);
    window.close();
}


function doPopup(destination1, destination2, destination3 ) {
    popup = window.open("", "popup", "height=500,width=500,toolbar=no, menubar=no,scrollbars=yes");

    if( destination1 != null ){
        destinationElement1=document.getElementById(destination1);
    }else{
        destinationElement1=null;
    }

    if( destination2 != null ){
        destinationElement2=document.getElementById(destination2);
    }else{
        destinationElement2=null;
    }

    if( destination3 != null ){
        destinationElement3=document.getElementById(destination3);
    }else{
        destinationElement3=null;
    }

    popup.focus();
}

function setVal(val1, val2, val3){
    if (destinationElement1 != null){
        destinationElement1.value = val1;
    }

    if (destinationElement2 != null){
        destinationElement2.value = val2;
    }

    if (destinationElement3 != null){
        destinationElement3.value = val3;
    }

}

function doSave(val1, val2, val3) {
    window.opener.setVal(val1, val2, val3);
    window.close();
}



function doPopup(destination1, destination2, destination3, destination4,destination5) {
    popup = window.open("", "popup", "height=500,width=600,toolbar=no, menubar=no,scrollbars=yes");

    if( destination1 != null ){
        destinationElement1=document.getElementById(destination1);
    }else{
        destinationElement1=null;
    }

    if( destination2 != null ){
        destinationElement2=document.getElementById(destination2);
    }else{
        destinationElement2=null;
    }

    if( destination3 != null ){
        destinationElement3=document.getElementById(destination3);
    }else{
        destinationElement3=null;
    }
    if( destination4 != null ){
        destinationElement4=document.getElementById(destination4);
    }else{
        destinationElement4=null;
    }
    if( destination5 != null ){
        destinationElement5=document.getElementById(destination5);
    }else{
        destinationElement5=null;
    }
}

function setVal(val1, val2, val3,val4,val5){
    if (destinationElement1 != null){
        destinationElement1.value = val1;
    }

    if (destinationElement2 != null){
        destinationElement2.value = val2;
    }

    if (destinationElement3 != null){
        destinationElement3.value = val3;
    }

    if (destinationElement4 != null){
        destinationElement4.value = val4;
    }

    if (destinationElement5 != null){
        destinationElement5.value = val5;
    }
}

function doSave(val1, val2,val3,val4,val5) {
    window.opener.setVal(val1, val2,val3,val4,val5);
    window.close();
}


function calcularMonto5(uiPrecio, uiCantidad, uiIva, uiMontoIva, uiMontoTotal ) {
    /*Inicializamos las variables*/
    ePrecio     = null;
    eCantidad   = null;
    eIva        = null;
    eMontoIva   = null;
    eMontoTotal = null;

    //Verificamos que los elementos no sean null
    if( uiPrecio != null && uiCantidad != null && uiIva != null && uiMontoIva != null && uiMontoTotal != null){

        ePrecio     = document.getElementById(uiPrecio);
        eCantidad   = document.getElementById(uiCantidad);
        eIva        = document.getElementById(uiIva);
        eMontoIva   = document.getElementById(uiMontoIva);
        eMontoTotal = document.getElementById(uiMontoTotal);

        //Variables para los calculos
        vPrecio     = 0;
        vCantidad   = 0;
        vIva        = 0;
        vMontoIva   = 0;
        vMontoTotal = 0;
        
        if( ePrecio != null && eCantidad != null && eIva != null && eMontoIva != null && eMontoTotal != null) {
            
            //Obtenemos el precio
            if (ePrecio.value != null) {
                vPrecio = ePrecio.value;
            }

            //Obtenemos la cantidad
            if (eCantidad.value != null) {
                vCantidad = eCantidad.value;
            }

            //Obtenemos el IVA
            if (eIva.value != null) {
                vIva = eIva.value;
            }

            //Calulamos monto total y monto IVA
            vMontoTotal = vPrecio * vCantidad;
            vMontoIva   = vIva / 100 * vMontoTotal;
            vMontoTotal = vMontoTotal + vMontoIva;

            //Actualizamos el value de los componentes
            eMontoIva.value   = vMontoIva;
            eMontoTotal.value = vMontoTotal;

        }
    }
}

function calcularMonto7(uiPrecio, uiCantidad, uiIva, uiMontoIva, uiMontoTotal, uiPorcDescuento, uiMontoDescuento ) {
    /*Inicializamos las variables*/
    ePrecio     = null;
    eCantidad   = null;
    eIva        = null;
    eMontoIva   = null;
    eMontoTotal = null;
    ePorcDescuento  = null;
    eMontoDescuento = null;

    //Verificamos que los elementos no sean null
    if( uiPrecio != null && uiCantidad != null && uiIva != null && uiMontoIva != null && uiMontoTotal != null){

        ePrecio     = document.getElementById(uiPrecio);
        eCantidad   = document.getElementById(uiCantidad);
        eIva        = document.getElementById(uiIva);
        eMontoIva   = document.getElementById(uiMontoIva);
        eMontoTotal = document.getElementById(uiMontoTotal);
        ePorcDescuento  = document.getElementById(uiPorcDescuento);
        eMontoDescuento = document.getElementById(uiMontoDescuento);

        //Variables para los calculos
        vPrecio     = 0;
        vCantidad   = 0;
        vIva        = 0;
        vMontoIva   = 0;
        vMontoTotal = 0;
        vPorcDescuento  = 0;
        vMontoDescuento = 0;

        if( ePrecio != null && eCantidad != null && eIva != null && eMontoIva != null && eMontoTotal != null && ePorcDescuento != null && eMontoDescuento != null) {

            //Obtenemos el precio
            if (ePrecio.value != null) {
                vPrecio = ePrecio.value;
            }

            //Obtenemos la cantidad
            if (eCantidad.value != null) {
                vCantidad = eCantidad.value;
            }

            //Obtenemos el IVA
            if (eIva.value != null) {
                vIva = eIva.value;
            }
            //Obtenemos el Porcentaje de descuento
            if (ePorcDescuento.value != null) {
                vPorcDescuento = ePorcDescuento.value;
            }

            //Calulamos monto total y monto IVA
            vMontoTotal = vPrecio * vCantidad;
            vMontoIva   = vIva / 100 * vMontoTotal;
            vMontoTotal = vMontoTotal + vMontoIva;

            //Actualizamos el value de los componentes
            eMontoIva.value   = vMontoIva;
            eMontoTotal.value = vMontoTotal;

            //Calculamos el descuento
            vMontoDescuento = vMontoTotal * vPorcDescuento / 100;

            //Aplicamos el descuento
            eMontoTotal.value = vMontoTotal - vMontoDescuento;
        }
    }
}

/**
 * script para validar fechas en una caja de texto.
 */
/**
 * definimos las varables globales que van a contener la fecha completa, cada una de sus partes
 * y los dias correspondientes al mes de febrero segun sea el año bisiesto o no
 */
var a, mes, dia, anyo, febrero;

/**
 * funcion para comprobar si una año es bisiesto
 * argumento anyo > año extraido de la fecha introducida por el usuario
 */
function anyoBisiesto(anyo)
{
    var fin;
    /**
     * si el año introducido es de dos cifras lo pasamos al periodo de 1900. Ejemplo: 25 > 1925
     */
    if (anyo < 100)
        fin = anyo + 1900;
    else
        fin = anyo ;

    /*
     * primera condicion: si el resto de dividir el año entre 4 no es cero > el año no es bisiesto
     * es decir, obtenemos año modulo 4, teniendo que cumplirse anyo mod(4)=0 para bisiesto
     */
    if (fin % 4 != 0)
        return false;
    else
    {
        if (fin % 100 == 0)
        {
            /**
             * si el año es divisible por 4 y por 100 y divisible por 400 > es bisiesto
             */
            if (fin % 400 == 0)
            {
                return true;
            }
            /**
             * si es divisible por 4 y por 100 pero no lo es por 400 > no es bisiesto
             */
            else
            {
                return false;
            }
        }
        /**
         * si es divisible por 4 y no es divisible por 100 > el año es bisiesto
         */
        else
        {
            return true;
        }
    }
}

/**
 * funcion principal de validacion de la fecha
 * argumento fecha > cadena de texto de la fecha introducida por el usuario
 */
function validarFecha(fec)
{

    alert("Validar fecha");

    /**
     * obtenemos la fecha introducida y la separamos en dia, mes y año
     */
    a = document.getElementById(fec).value;

    alert("Val" + a);
    dia=a.split("/")[0];
    mes=a.split("/")[1];
    anyo=a.split("/")[2];
    
    if( (isNaN(dia)==true) || (isNaN(mes)==true) || (isNaN(anyo)==true) )
    {
        alert("La fecha introducida debe estar formada sólo por números");
        return;
    }
    
    if(anyoBisiesto(anyo)){
        febrero=29;
    }else{
        febrero=28;
    }
    /**
     * si el mes introducido es negativo, 0 o mayor que 12 > alertamos y detenemos ejecucion
     */
    if ((mes<1) || (mes>12))
    {
        alert("El mes introducido no es valido. Por favor, introduzca un mes correcto");
        document.forms[0].fecha.focus();
        document.forms[0].fecha.select();
        return;
    }

    /**
     * si el mes introducido es febrero y el dia es mayor que el correspondiente
     * al año introducido > alertamos y detenemos ejecucion
     */
    if ((mes==2) && ((dia<1) || (dia>febrero)))
    {
        alert("El dia introducido no es valido. Por favor, introduzca un dia correcto");
        document.forms[0].fecha.focus();
        document.forms[0].fecha.select();
        return;
    }

    /**
     * si el mes introducido es de 31 dias y el dia introducido es mayor de 31 > alertamos y detenemos ejecucion
     */
    if (((mes==1) || (mes==3) || (mes==5) || (mes==7) || (mes==8) || (mes==10) || (mes==12)) && ((dia<1) || (dia>31)))
    {
        alert("El dia introducido no es valido. Por favor, introduzca un dia correcto");
        document.forms[0].fecha.focus();
        document.forms[0].fecha.select();
        return;
    }

    /**
     * si el mes introducido es de 30 dias y el dia introducido es mayor de 301 > alertamos y detenemos ejecucion
     */
    if (((mes==4) || (mes==6) || (mes==9) || (mes==11)) && ((dia<1) || (dia>30)))
    {
        alert("El dia introducido no es valido. Por favor, introduzca un dia correcto");
        document.forms[0].fecha.focus();
        document.forms[0].fecha.select();
        return;
    }

    /**
     * si el mes año introducido es menor que 1900 o mayor que 2010 > alertamos y detenemos ejecucion
     * NOTA: estos valores son a eleccion vuestra, y no constituyen por si solos fecha erronea
     */
    if ((anyo<1900) || (anyo>2010))
    {
        alert("El año introducido no es valido. Por favor, introduzca un año entre 1900 y 2010");
        document.forms[0].fecha.focus();
        document.forms[0].fecha.select();
    }

    /**
     * en caso de que todo sea correcto > enviamos los datos del formulario
     * para ello debeis descomentar la ultima sentencia
     */
    else
        alert("La fecha introducida es correcta. Gracias por su colaboración");
    //document.forms[0].submit();
}
