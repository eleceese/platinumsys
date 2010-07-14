<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : LSTResumenTareasEmpleado
    Created on : Jun 13, 2010, 10:26:29 AM
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
                        <div style="left: 288px; top: 216px; position: absolute">
                            <h:panelGrid columns="2" id="gridPanel1" style="height: 191px" width="407">
                                <webuijsf:label id="label1" text="Nro Ot"/>
                                <webuijsf:dropDown binding="#{resources$LSTResumenTareasEmpleado.uiNroOt}" id="uiNroOt" items="#{resources$LSTResumenTareasEmpleado.listaOtCabOp}"/>
                                <webuijsf:label id="label2" text="Empleado"/>
                                <webuijsf:dropDown binding="#{resources$LSTResumenTareasEmpleado.uiEmpleado}" id="uiEmpleado" items="#{resources$LSTResumenTareasEmpleado.listaEmpleadosOp}"/>
                                <webuijsf:label id="label3" text="Tarea"/>
                                <webuijsf:dropDown binding="#{resources$LSTResumenTareasEmpleado.uiTarea}" id="uiTarea" items="#{resources$LSTResumenTareasEmpleado.listaTareasOp}"/>
                                <webuijsf:label id="label6" style="color: #000066" text="Rango de Fecha"/>
                                <h:panelGrid id="gridPanel4" style="height: 24px; width: 100%"/>
                                <h:panelGrid id="gridPanel2" style="height: 100%" width="191">
                                    <webuijsf:label id="label5" text="Desde"/>
                                    <webuijsf:calendar binding="#{resources$LSTResumenTareasEmpleado.uiFechaDesde}" id="uiFechaDesde"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanel3" style="height: 100%" width="159">
                                    <webuijsf:label id="label4" text="Hasta"/>
                                    <webuijsf:calendar binding="#{resources$LSTResumenTareasEmpleado.uiFechaHasta}" id="uiFechaHasta"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanel5" style="height: 35px" width="191">
                                    <webuijsf:button actionExpression="#{resources$LSTResumenTareasEmpleado.uiButtonEjecutar_action}" id="uiButtonEjecutar" text="Ejecutar"/>
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
