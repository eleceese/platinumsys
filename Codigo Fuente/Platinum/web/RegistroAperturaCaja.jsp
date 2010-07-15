<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ABMCliente
    Created on : Oct 18, 2009, 8:11:57 PM
    Author     : FerBoy
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:script id="scriptPopUp" type="text/javascript" url="/js/utilJS.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <h:panelGrid id="mainContainer" style="height: 288px; left: 240px; top: 312px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{RegistroAperturaCaja.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid columns="2" id="gridPanelDatos1" style="height: 30px" width="503">
                                <webuijsf:hyperlink id="linkCaja" onClick="doPopup('form1:codCaja_field', 'form1:caja_field')" style="width: 100%"
                                    target="popup" text="Seleccion Una Caja" url="/faces/popup/popupCajasCerradas.jsp"/>
                                <h:panelGrid columns="2" id="cajadrip" style="height: 100%; text-align: left; width: 100%" width="215">
                                    <webuijsf:textField binding="#{RegistroAperturaCaja.codCaja}" columns="10" id="codCaja"/>
                                    <webuijsf:textField columns="50" id="caja"/>
                                </h:panelGrid>
                                <webuijsf:label id="saldoInic" style="width: 100%" text="Saldo Inicial"/>
                                <h:panelGrid id="gridPanel1" style="height: 38px; width: 100%">
                                    <webuijsf:textField binding="#{RegistroAperturaCaja.saldo}" id="saldo"/>
                                </h:panelGrid>
                                <webuijsf:hyperlink id="linkempleado" onClick="doPopup('form1:codEmpleado_field', 'form1:empleado_field')" style="width: 100%"
                                    target="popup" text="Responsable" url="/faces/popup/popupEmpleados.jsp"/>
                                <h:panelGrid columns="2" id="gridPanel2" style="height: 24px; width: 100%">
                                    <webuijsf:textField binding="#{RegistroAperturaCaja.codEmpleado}" columns="5" id="codEmpleado"/>
                                    <webuijsf:textField columns="43" id="empleado"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroAperturaCaja.buttonsPanelAddUpdate}" columns="1" id="buttonsPanelAddUpdate"
                                style="height: 85px; margin-left: 240px" width="336">
                                <webuijsf:messageGroup id="messageGroup1"/>
                                <webuijsf:button actionExpression="#{RegistroAperturaCaja.button2_action}" binding="#{RegistroAperturaCaja.button2}"
                                    id="button2" style="font-size: 14px; height: 24px; width: 119px" text="Apertura Caja"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
