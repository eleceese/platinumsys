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
                            <h:panelGrid columns="2" id="mainContainer" style="height: 125px; left: 288px; top: 240px; position: absolute" width="456">
                                <webuijsf:label id="label2" text="Deposito"/>
                                <webuijsf:dropDown binding="#{LSTFichaProducto.uiDeposito}" id="uiDeposito" items="#{LSTFichaProducto.listaDepositosOp}"/>
                                <webuijsf:label id="label4" text="Producto"/>
                                <webuijsf:dropDown binding="#{LSTFichaProducto.uiProducto}" id="uiProducto" items="#{LSTFichaProducto.listaProductosOp}"/>
                                <webuijsf:label id="label1" text="Fecha Inicio"/>
                                <webuijsf:calendar binding="#{LSTFichaProducto.uiFechaIni}" columns="15" id="uiFechaIni"/>
                                <webuijsf:label id="label3" text="Fecha Fin"/>
                                <webuijsf:calendar binding="#{LSTFichaProducto.uiFechaFin}" columns="15" id="uiFechaFin"/>
                                <webuijsf:button actionExpression="#{LSTFichaProducto.uiEjecutar_action}" id="uiEjecutar" text="Ejecutar"/>
                                <webuijsf:button actionExpression="#{LSTFichaProducto.button2_action}" id="button2" text="Cancelar"/>
                            </h:panelGrid>
                        </div>
                        <h:panelGrid id="gridPanel1" style="height: 96px; left: 360px; top: 432px; position: absolute; width: 96px">
                            <webuijsf:messageGroup id="messageGroup1" style="width: 191px"/>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
