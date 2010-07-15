<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : LSTResumenTareasEmpleado
    Created on : Jun 13, 2010, 10:26:29 AM
    Author     : FerBoy
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
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
                        <div style="left: 288px; top: 216px; position: absolute">
                            <h:panelGrid columns="2" id="gridPanel1" style="height: 191px" width="407">
                                <h:panelGrid columns="2" id="gridPanel7" style="height: 29px; width: 100%">
                                    <webuijsf:label id="label7" text="Analisis por Año"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanel8" style="height: 29px; width: 100%">
                                    <webuijsf:textField binding="#{LSTEstadisticaProduccionCompras.uiAnio}" id="uiAnio"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanel6" style="height: 29px" width="167">
                                    <webuijsf:label id="label1" text="Analisis Por"/>
                                </h:panelGrid>
                                <webuijsf:radioButtonGroup binding="#{LSTEstadisticaProduccionCompras.uiRadioAnalisis}" columns="2" id="uiRadioAnalisis"
                                    items="#{LSTEstadisticaProduccionCompras.uiRadioAnalisisDefaultOptions.options}"
                                    selected="#{LSTEstadisticaProduccionCompras.uiRadioAnalisisDefaultOptions.selectedValue}" style="width: 278px" valueChangeListenerExpression="#{LSTEstadisticaProduccionCompras.uiRadioAnalisis_processValueChange}"/>
                                <h:panelGrid columns="2" id="gridPanel5" style="height: 35px" width="191">
                                    <webuijsf:button actionExpression="#{LSTEstadisticaProduccionCompras.uiButtonEjecutar_action}" id="uiButtonEjecutar" text="Ejecutar"/>
                                    <webuijsf:button id="uiButtonCancelar" text="Cancelar"/>
                                </h:panelGrid>
                                <webuijsf:messageGroup id="messageGroup1"/>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
