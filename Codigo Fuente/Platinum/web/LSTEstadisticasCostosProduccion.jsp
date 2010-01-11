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
                            <h:panelGrid columns="2" id="mainContainer" style="height: 269px; left: 288px; top: 235px; position: absolute" width="456">
                                <webuijsf:label id="lblFecInicio" text="Fecha Desde"/>
                                <webuijsf:calendar columns="15" id="txtFecApertura"/>
                                <webuijsf:label id="lblFecFin" text="Fecha Hasta"/>
                                <webuijsf:calendar columns="15" id="txtFecAprobacion"/>
                                <webuijsf:label id="lblProductoGenerico" text="Producto Genérico"/>
                                <webuijsf:textField columns="30" id="textProductoGenerico" style="margin-left: 11px"/>
                                <webuijsf:label id="lblTipoProducto" text="Tipo Producto"/>
                                <webuijsf:dropDown id="dropDown1" items="#{LSTEstadisticasCostosProduccion.dropDown1DefaultOptions.options}"
                                    selected="#{LSTEstadisticasCostosProduccion.dropDown1DefaultOptions.selectedValue}" style="margin-left: 11px" width="120px"/>
                                <webuijsf:hyperlink id="linkProducto" text="Producto"/>
                                <h:panelGrid columns="2" id="panelProducto">
                                    <webuijsf:textField columns="10" id="txtCodProducto" style="margin-left: 7px"/>
                                    <webuijsf:textField columns="35" id="txtDescProducto"/>
                                </h:panelGrid>
                                <webuijsf:label id="label2" text="Nro. Orden Trabajo"/>
                                <webuijsf:textField columns="19" id="txtNroOrdenTrabajo" style="text-align: right;margin-left: 11px"/>
                                <webuijsf:button actionExpression="#{LSTEstadisticasCostosProduccion.button1_action}" id="button1" text="Ejecutar"/>
                                <webuijsf:button actionExpression="#{LSTEstadisticasCostosProduccion.button2_action}" id="button2" text="Cancelar"/>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
