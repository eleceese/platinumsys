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
                            <webuijsf:pageAlert binding="#{ABMCajas.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMCajas.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField id="codigo1" text="codigo"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height:30px; width: 60%">
                                    <webuijsf:label id="nombre" text="Nombre"/>
                                    <webuijsf:textField id="nombreCaja" text="Nombre Caja"/>
                                </h:panelGrid>
                                <webuijsf:button id="buscar" text="Buscar"/>
                                <webuijsf:button id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMCajas.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" id="cajas" paginateButton="true" paginationControls="true" sortPanelToggleButton="true"
                                    title="Cajas" width="695">
                                    <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="marcas" rows="15"
                                        sourceData="#{ABMCajas.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn id="select" width="10">
                                            <webuijsf:radioButton id="radioButton2" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="id" width="100">
                                            <webuijsf:staticText id="staticText4" text="12312313"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nombre de Caja" id="nombreCaja1" width="400">
                                            <webuijsf:staticText id="staticText5" text="Caja 1 Caja 1 Caja 1"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMCajas.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMCajas.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMCajas.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMCajas.eliminar_action}" id="eliminar" text="Eliminar"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{ABMCajas.datosCaja}" id="datosCaja"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos de la Caja"/>
                            <br/>
                            <h:panelGrid binding="#{ABMCajas.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelcodigo" text="Codigo"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMCajas.codigo2}" columns="50" id="codigo2" text="123123123"/>
                                    <webuijsf:message for="codigo2" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelCaja" text="Caja"/>
                                <h:panelGrid columns="2" id="gridPanelMarca" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMCajas.caja}" columns="50" id="caja" text="Nombre Caja"/>
                                    <webuijsf:message for="caja" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMCajas.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMCajas.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMCajas.button2_action}" binding="#{ABMCajas.button2}" id="button2" text="Guardar"/>
                                <webuijsf:button binding="#{ABMCajas.button3}" id="button3" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
