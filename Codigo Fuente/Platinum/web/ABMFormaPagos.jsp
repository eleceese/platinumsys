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
                            <webuijsf:pageAlert binding="#{ABMFormaPagos.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMFormaPagos.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="banco1" text="Banco"/>
                                    <webuijsf:textField id="banco2" text="Banco"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height: 30px" width="239">
                                    <webuijsf:label id="forma" text="Forma de pago"/>
                                    <webuijsf:textField id="formaPago" text="Forma de Pago"/>
                                </h:panelGrid>
                                <webuijsf:button id="buscar" text="Buscar"/>
                                <webuijsf:button id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMFormaPagos.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" id="tableFormaPago" paginateButton="true" paginationControls="true"
                                    sortPanelToggleButton="true" title="Formas de pago" width="575">
                                    <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="formasPago" rows="15"
                                        sourceData="#{ABMFormaPagos.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" id="select" width="10">
                                            <webuijsf:radioButton id="radioButton2" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="codigo" width="92">
                                            <webuijsf:staticText id="staticText1" text="123123"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Forma de pago" id="formaPago1" width="193">
                                            <webuijsf:staticText id="staticText2" text="Efectivo Efectivo"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Banco" id="banco3" width="193">
                                            <webuijsf:staticText id="staticText3" text="Banco Banco"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMFormaPagos.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMFormaPagos.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMFormaPagos.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMFormaPagos.eliminar_action}" id="eliminar" text="Eliminar"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{ABMFormaPagos.datosFormaPago}" id="datosFormaPago"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos Forma de pago"/>
                            <br/>
                            <h:panelGrid binding="#{ABMFormaPagos.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelcodigo" text="Codigo"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMFormaPagos.codigo2}" columns="50" id="codigo2" text="123123123"/>
                                    <webuijsf:message for="codigo2" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelDescripcion" text="Descripcion"/>
                                <h:panelGrid columns="2" id="gridPanelMarca" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMFormaPagos.descripcion}" columns="50" id="descripcion" text="Descripcion"/>
                                    <webuijsf:message for="descripcion" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:hyperlink id="linkBanco" text="Banco"/>
                                <h:panelGrid columns="2" id="gridPanelMarca1" style="height: 100%" width="575">
                                    <webuijsf:textField columns="50" id="banco4" text="Banco"/>
                                    <webuijsf:message id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMFormaPagos.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMFormaPagos.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMFormaPagos.button2_action}" binding="#{ABMFormaPagos.button2}" id="button2" text="Guardar"/>
                                <webuijsf:button binding="#{ABMFormaPagos.button3}" id="button3" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
