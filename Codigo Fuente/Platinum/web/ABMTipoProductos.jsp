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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 216px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMTipoProductos.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMTipoProductos.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField id="codigo1" text="codigo"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelTipo" style="height:30px; width: 60%">
                                    <webuijsf:label id="tipo" text="Tipo"/>
                                    <webuijsf:textField id="tipo1" text="Tipo de Producto"/>
                                </h:panelGrid>
                                <webuijsf:button id="buscar" text="Buscar"/>
                                <webuijsf:button id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMTipoProductos.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" id="tableTipo" paginateButton="true" paginationControls="true" sortPanelToggleButton="true"
                                    title="Tipos de Productos" width="695">
                                    <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="marcas" rows="5"
                                        sourceData="#{ABMTipoProductos.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" id="select" width="17">
                                            <webuijsf:radioButton id="radioButton2" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="codigo3" width="100">
                                            <webuijsf:staticText id="staticText4" text="12312313"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Tipo" id="tipoProducto" width="400">
                                            <webuijsf:staticText id="staticText5" text="Tipo Tipo Tipo"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMTipoProductos.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMTipoProductos.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMTipoProductos.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMTipoProductos.eliminar_action}" id="eliminar" text="Eliminar"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{ABMTipoProductos.datosTipo}" id="datosTipo"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos Tipo de Producto"/>
                            <br/>
                            <h:panelGrid binding="#{ABMTipoProductos.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelcodigo" text="Codigo"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMTipoProductos.codigo2}" columns="50" id="codigo2" text="Codigo"/>
                                    <webuijsf:message for="codigo2" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelTipo" text="Tipo"/>
                                <h:panelGrid columns="2" id="gridPanelTipo1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMTipoProductos.tipo2}" columns="50" id="tipo2" text="Tipo de Producto"/>
                                    <webuijsf:message for="tipo2" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMTipoProductos.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMTipoProductos.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMTipoProductos.button2_action}" binding="#{ABMTipoProductos.button2}" id="button2" text="Guardar"/>
                                <webuijsf:button binding="#{ABMTipoProductos.button3}" id="button3" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
