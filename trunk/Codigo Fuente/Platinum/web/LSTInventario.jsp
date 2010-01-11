<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Reporte
    Created on : 07-sep-2009, 16:17:37
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
                        <div>
                            <h:panelGrid columns="2" id="mainContainer" style="height: 125px; left: 288px; top: 235px; position: absolute" width="456">
                                <webuijsf:hyperlink id="linkDeposito" text="Deposito"/>
                                <h:panelGrid columns="2" id="panelDep">
                                    <webuijsf:textField columns="7" id="txtNroDeposito"/>
                                    <webuijsf:textField columns="40" id="txtDescDeposito" text="TODOS"/>
                                </h:panelGrid>
                                <webuijsf:hyperlink id="linkInventario" text="Nro. Inventario"/>
                                <h:panelGrid columns="2" id="panelInventario">
                                    <webuijsf:textField columns="7" id="txtNroInventario"/>
                                    <webuijsf:textField columns="40" id="txtDescInventario" text="TODOS"/>
                                </h:panelGrid>
                                <webuijsf:button actionExpression="#{LSTInventario.button1_action}" id="button1" text="Ejecutar"/>
                                <webuijsf:button actionExpression="#{LSTInventario.button2_action}" id="button2" text="Cancelar"/>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
