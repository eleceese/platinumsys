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