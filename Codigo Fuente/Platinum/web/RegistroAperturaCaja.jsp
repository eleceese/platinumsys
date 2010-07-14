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
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 240px; top: 240px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{RegistroAperturaCaja.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid columns="2" id="gridPanelDatos1" style="height: 30px" width="503">
                                <webuijsf:hyperlink id="linkCaja" style="width: 100%" text="Caja"/>
                                <h:panelGrid columns="1" id="caja" style="height: 100%; text-align: left; width: 100%" width="215">
                                    <webuijsf:textField id="caja2"
                                        style="color: rgb(204, 0, 0); font-family: 'Arial','Helvetica',sans-serif; font-weight: bolder" text="Caja 1 Caja 1"/>
                                </h:panelGrid>
                                <webuijsf:label id="fecha" style="width: 100%" text="Fecha"/>
                                <h:panelGrid columns="1" id="gridPanelFecha" style="height: 100%; text-align: left; width: 100%">
                                    <webuijsf:calendar id="calendar1"/>
                                </h:panelGrid>
                                <webuijsf:label id="saldoInic" style="width: 100%" text="Saldo Inicial"/>
                                <h:panelGrid id="gridPanel1" style="height: 38px; width: 100%">
                                    <webuijsf:textField id="textField1"/>
                                </h:panelGrid>
                                <webuijsf:label id="cobrador" style="width: 100%" text="Cobrador"/>
                                <h:panelGrid columns="2" id="gridPanel2" style="height: 24px; width: 100%">
                                    <webuijsf:textField columns="5" id="textField2"/>
                                    <webuijsf:textField columns="43" id="textField3"/>
                                </h:panelGrid>
                                <webuijsf:label id="observacion" style="width: 100%" text="Observacion"/>
                                <h:panelGrid id="gridPanel3" style="height: 38px; width: 100%">
                                    <webuijsf:textArea columns="50" id="textArea1" rows="5"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroAperturaCaja.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate"
                                style="height: 24px; margin-left: 240px" width="191">
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
