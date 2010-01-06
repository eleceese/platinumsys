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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 240px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMComisiones.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMComisiones.gridPanelBuscar}" columns="3" id="gridPanelBuscar" style="height: 72px" width="599">
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height:30px; width: 60%">
                                    <webuijsf:label id="producto" text="Producto"/>
                                    <webuijsf:textField id="producto1" text="Producto"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelRUC" style="height: 30px" width="239">
                                    <webuijsf:label id="fechaInic" text="Fecha Inicial"/>
                                    <webuijsf:calendar id="calendar1"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelCedula" style="height: 30px" width="239">
                                    <webuijsf:label id="fechaFin" text="Fecha Final"/>
                                    <webuijsf:calendar id="calendar2"/>
                                </h:panelGrid>
                                <webuijsf:button id="buscar" text="Buscar"/>
                                <webuijsf:button id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMComisiones.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" id="tableComisiones" paginateButton="true" paginationControls="true"
                                    sortPanelToggleButton="true" title="Comisiones" width="719">
                                    <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="proveedores" rows="15"
                                        sourceData="#{ABMComisiones.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn id="selec" width="20">
                                            <webuijsf:radioButton id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="codigo" noWrap="true">
                                            <webuijsf:staticText id="staticText1" text="1111122222-2"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Producto" id="producto2">
                                            <webuijsf:staticText id="staticText2" text="Producto Producto Producto"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="% Porcentaje" id="porcentaje">
                                            <webuijsf:staticText id="staticText3" text="14 % 14 % 14 %"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha Inicial" id="fechaInic1">
                                            <webuijsf:staticText id="staticText3" text="12/12/2009 12/12/2009"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha Final" id="fechaFin1">
                                            <webuijsf:staticText id="staticText4" text="12/12/2009 12/12/2009"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMComisiones.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 50px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMComisiones.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMComisiones.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMComisiones.eliminar_action}" id="eliminar" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMComisiones.datosComision}" id="datosComision"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos de la Comision"/>
                            <br/>
                            <h:panelGrid binding="#{ABMComisiones.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:hyperlink id="linkProducto" text="Producto"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMComisiones.producto3}" columns="50" id="producto3" text="Nombre Producto"/>
                                    <webuijsf:message for="producto3" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="porcentaje1" text="Porcentaje %"/>
                                <h:panelGrid columns="2" id="gridPanel14" style="height: 100%" width="582">
                                    <webuijsf:textField binding="#{ABMComisiones.porcentaje2}" columns="15" id="porcentaje2" text="15 % 15 % 15 %"/>
                                    <webuijsf:message for="porcentaje2" id="message14" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="fechaInicio" text="Fecha Inicial"/>
                                <h:panelGrid columns="2" id="gridPanel9" style="height: 100%" width="407">
                                    <webuijsf:calendar id="fechaInic2"/>
                                    <webuijsf:message id="message9" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="fechaFinal" text="Fecha Final"/>
                                <h:panelGrid columns="2" id="gridPanel2" style="height: 100%" width="431">
                                    <webuijsf:calendar id="fechaFin2"/>
                                    <webuijsf:message id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="activo" text="Activo"/>
                                <h:panelGrid columns="2" id="gridPanel10" style="height: 100%" width="481">
                                    <webuijsf:checkbox id="activo1"/>
                                    <webuijsf:message id="message10" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMComisiones.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMComisiones.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMComisiones.button2_action}" binding="#{ABMComisiones.button2}" id="button2" text="Guardar"/>
                                <webuijsf:button binding="#{ABMComisiones.button3}" id="button3" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
