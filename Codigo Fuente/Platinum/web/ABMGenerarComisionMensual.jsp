<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ABMGenerarComisionMensual
    Created on : 29-nov-2009, 15:29:50
    Author     : MartinJara
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <div style="height: 358px; left: 336px; top: 240px; position: absolute; width: 478px">
                            <h:panelGrid columns="2" id="gridPanel1" style="height: 191px" width="419">
                                <webuijsf:label for="calendar1" id="label1" text="Fecha Desde"/>
                                <webuijsf:calendar id="calendar1" style="margin-left: -9px"/>
                                <webuijsf:label for="calendar2" id="label2" text="Fecha Hasta"/>
                                <webuijsf:calendar id="calendar2" style="margin-left: -9px"/>
                                <webuijsf:label id="lblFacCobro" text="% Factura Cobro"/>
                                <webuijsf:textField columns="10" id="txtFactCobro"/>
                                <webuijsf:hyperlink id="linkVenededor" text="Vendedor"/>
                                <h:panelGrid columns="2" id="panelVendedor" width="215">
                                    <webuijsf:textField columns="5" id="txtCodVendedor"/>
                                    <webuijsf:textField columns="37" id="txtNombVendedor"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="panelButton" style="height: 72px; margin-left: 55px; text-align: center" width="311">
                                <webuijsf:button id="button1" text="Calcular"/>
                                <webuijsf:button id="button2" text="Cancelar"/>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="panelBarraDeProgreso" style="height: 24px;" width="311">
                                <webuijsf:label id="lblProgreso" text="Progreso"/>
                                <webuijsf:progressBar id="progressBar1" status="100%" style="font-size: 16px; text-align: center" taskState="completed"/>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
