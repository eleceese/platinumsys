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
                        <h:panelGrid id="mainContainer" style="height: 288px; left: 240px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{RegistroCierreCaja.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid columns="2" id="gridPanelDatos1" width="695">
                                <h:panelGrid columns="2" id="gridPanelDatos2" width="455">
                                    <webuijsf:hyperlink id="linkCaja" text="Caja"/>
                                    <webuijsf:textField columns="30" id="caja2"
                                        style="color: rgb(204, 0, 0); font-family: Arial,Helvetica,sans-serif; font-weight: bolder" text="Caja 1 Caja 1"/>
                                    <webuijsf:label id="cobrador" style="width: 100%" text="Cobrador"/>
                                    <h:panelGrid columns="3" id="gridPanelCobrador" style="height: 100%; text-align: left; width: 100%">
                                        <webuijsf:textField columns="5" id="textField2"/>
                                        <webuijsf:textField columns="43" id="textField3"/>
                                    </h:panelGrid>
                                    <webuijsf:label id="saldoInic3" style="width: 100%" text="Monto Inicial"/>
                                    <webuijsf:textField columns="40" id="textField6"/>
                                    <webuijsf:label id="saldoInic2" style="width: 100%" text="Total Rendido"/>
                                    <webuijsf:textField columns="40" id="textField5"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelDatos3" style="height: 130px" width="359">
                                    <webuijsf:label id="estado2" style="width: 100%" text="Estado"/>
                                    <webuijsf:dropDown id="estado" items="#{RegistroCierreCaja.estadoDefaultOptions.options}"/>
                                    <webuijsf:label id="fecha" text="Fecha"/>
                                    <webuijsf:calendar id="calendar1"/>
                                    <webuijsf:label id="saldoInic" style="width: 100%" text="Total Mov Caja"/>
                                    <webuijsf:textField columns="30" id="textField1"/>
                                    <webuijsf:label id="saldoInic1" style="width: 100%" text="Total Gasto"/>
                                    <webuijsf:textField columns="30" id="textField4"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanel1" width="455">
                                    <webuijsf:label id="observacion" style="height: 100%; width: 100%" text="Observacion"/>
                                    <webuijsf:textArea columns="50" id="textArea1" rows="5" style="height: 100%"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroCierreCaja.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate"
                                style="height: 24px; margin-left: 240px" width="191">
                                <webuijsf:button actionExpression="#{RegistroCierreCaja.cancelar_action}" id="cancelar" style="font-size: 14px; height: 24px" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{RegistroCierreCaja.button2_action}" binding="#{RegistroCierreCaja.button2}" id="button2"
                                    style="font-size: 14px; height: 24px" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
