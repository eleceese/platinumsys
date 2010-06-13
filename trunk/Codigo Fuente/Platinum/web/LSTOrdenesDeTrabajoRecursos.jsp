<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : LSTOrdenesDeTrabajoRecursos
    Created on : Jun 13, 2010, 2:49:39 PM
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
                                <webuijsf:dropDown binding="#{LSTOrdenesDeTrabajoRecursos.uiNroOt}" id="uiNroOt" items="#{LSTOrdenesDeTrabajoRecursos.listaOtCabOp}"/>
                                <webuijsf:label id="label2" text="Producto"/>
                                <webuijsf:dropDown binding="#{LSTOrdenesDeTrabajoRecursos.uiProducto}" id="uiProducto" items="#{LSTOrdenesDeTrabajoRecursos.listaProductosOp}"/>
                                <webuijsf:label id="label3" text="Estado"/>
                                <webuijsf:dropDown binding="#{LSTOrdenesDeTrabajoRecursos.uiEstado}" id="uiEstado"
                                    items="#{LSTOrdenesDeTrabajoRecursos.uiEstadoDefaultOptions.options}" selected="#{LSTOrdenesDeTrabajoRecursos.uiEstadoDefaultOptions.selectedValue}"/>
                                <webuijsf:label id="label4" style="color: #000066" text="Rango de Fecha Apertura"/>
                                <h:panelGrid id="gridPanel2" style="height: 24px; width: 100%"/>
                                <h:panelGrid id="gridPanel3" style="height: 100%" width="191">
                                    <webuijsf:label id="label5" text="Desde"/>
                                    <webuijsf:calendar binding="#{LSTOrdenesDeTrabajoRecursos.uiFechaDesde}" id="uiFechaDesde"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanel4" style="height: 100%" width="159">
                                    <webuijsf:label id="label6" text="Hasta"/>
                                    <webuijsf:calendar binding="#{LSTOrdenesDeTrabajoRecursos.uiFechaHasta}" id="uiFechaHasta"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanel5" style="height: 35px" width="191">
                                    <webuijsf:button actionExpression="#{LSTOrdenesDeTrabajoRecursos.uiButtonEjecutar_action}" id="uiButtonEjecutar1" text="Ejecutar"/>
                                    <webuijsf:button id="uiButtonCancelar1" text="Cancelar"/>
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
