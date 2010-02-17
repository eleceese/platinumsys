/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Popup con 2 destinos.
 */

//Variables
var popup;

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


function calcularMonto(uiPrecio, uiCantidad, uiIva, uiMontoIva, uiMontoTotal ) {
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
