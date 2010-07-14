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
                                <webuijsf:label id="label2" text="Empleado"/>
                                <webuijsf:dropDown binding="#{LSTEstadisticaEfectividad.uiEmpleado}" id="uiEmpleado" items="#{LSTEstadisticaEfectividad.listaEmpleadosOp}"/>
                                <webuijsf:label id="label6" style="color: #000066" text="Rango de Fecha"/>
                                <h:panelGrid id="gridPanel4" style="height: 24px; width: 100%"/>
                                <h:panelGrid id="gridPanel2" style="height: 100%" width="191">
                                    <webuijsf:label id="label5" text="Desde"/>
                                    <webuijsf:calendar binding="#{LSTEstadisticaEfectividad.uiFechaDesde}" id="uiFechaDesde"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanel3" style="height: 100%" width="159">
                                    <webuijsf:label id="label4" text="Hasta"/>
                                    <webuijsf:calendar binding="#{LSTEstadisticaEfectividad.uiFechaHasta}" id="uiFechaHasta"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanel6" style="height: 29px" width="167">
                                    <webuijsf:label id="label1" text="Analisis Por"/>
                                </h:panelGrid>
                                <webuijsf:radioButtonGroup binding="#{LSTEstadisticaEfectividad.uiRadioAnalisis}" columns="3" id="uiRadioAnalisis"
                                    items="#{LSTEstadisticaEfectividad.uiRadioAnalisisDefaultOptions.options}"
                                    selected="#{LSTEstadisticaEfectividad.uiRadioAnalisisDefaultOptions.selectedValue}" style="width: 231px" valueChangeListenerExpression="#{LSTEstadisticaEfectividad.uiRadioAnalisis_processValueChange}"/>
                                <h:panelGrid id="gridPanel7" style="height: 29px; width: 100%">
                                    <webuijsf:checkbox binding="#{LSTEstadisticaEfectividad.uiCheckAnual}" id="uiCheckAnual" label="Checkbox"
                                        onChange="DynaFaces.Tx.fire(&quot;ajaxAnual&quot;,&quot;uiCheckAnual&quot;)"
                                        onClick="DynaFaces.Tx.fire(&quot;ajaxAnual&quot;,&quot;uiCheckAnual&quot;)"
                                        validatorExpression="#{LSTEstadisticaEfectividad.uiCheckAnual_validate}" valueChangeListenerExpression="#{LSTEstadisticaEfectividad.uiCheckAnual_processValueChange}"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanel8" style="height: 29px; width: 100%">
                                    <webuijsf:label id="label3" text="Año"/>
                                    <webuijsf:textField binding="#{LSTEstadisticaEfectividad.uiAnio}" id="uiAnio"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanel5" style="height: 35px" width="191">
                                    <webuijsf:button actionExpression="#{LSTEstadisticaEfectividad.uiButtonEjecutar_action}" id="uiButtonEjecutar" text="Ejecutar"/>
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
