<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ABMCliente
    Created on : Oct 18, 2009, 8:11:57 PM
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
                    <df:ajaxTransaction id="actSemi" inputs="page1:html1:body1:form1:mainContainer:gridPanelCabecera:gridPanelOT:uiOTNro" render="page1:html1:body1:form1:mainContainer:gridPanelCabecera:gridPanelOT:uiOTNro"/>
                    <df:ajaxTransaction id="ajaxTransaction1"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 240px; top: 240px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMEquivalencias.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <br/>
                            <h:panelGrid binding="#{ABMEquivalencias.gridPanelBusqueda}" id="gridPanelBusqueda" style="width: 100%; height: 100%;">
                                <h:panelGrid columns="4" id="gridPanelFiltro" style="height: 120px" width="743">
                                    <webuijsf:label id="label1" text="Producto Generico"/>
                                    <h:panelGrid columns="2" id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:dropDown binding="#{ABMEquivalencias.uiProductoGenFil}" id="uiProductoGenFil"
                                            items="#{ABMEquivalencias.listaProductosGenOp}" required="true" separators="false" width="250"/>
                                    </h:panelGrid>
                                    <webuijsf:label id="label2" text="Producto Final"/>
                                    <h:panelGrid columns="2" id="gridPanel4" style="width: 100%; height: 100%;">
                                        <webuijsf:dropDown binding="#{ABMEquivalencias.uiProductoFinFil}" id="uiProductoFinFil"
                                            items="#{ABMEquivalencias.listaProductosFinOp}" required="true" separators="false" width="250"/>
                                    </h:panelGrid>
                                    <webuijsf:button id="uiButtonTodosFil" text="Todos"/>
                                    <webuijsf:button actionExpression="#{ABMEquivalencias.uiButtonBuscarFil_action}" id="uiButtonBuscarFil" text="Buscar"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanelTabla" style="width: 100%; height: 100%;">
                                    <webuijsf:table augmentTitle="false" id="tableTareas" paginateButton="true" paginationControls="true"
                                        title="Lista de Tareas" width="719">
                                        <webuijsf:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{ABMEquivalencias.listaEquivalencias}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" id="tableColumn7">
                                                <webuijsf:radioButton id="radioButton1" label=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cod" id="tableColumn1" sort="codEquivalencia" width="151">
                                                <webuijsf:staticText id="staticText1" text="#{currentRow.value['codEquivalencia']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto Gen" id="tableColumn2" sort="codProductoFin">
                                                <webuijsf:staticText id="staticText2" text="#{currentRow.value['codProductoFin']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto Fin" id="tableColumn3" sort="codProductoGen">
                                                <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProductoGen']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="right" headerText="Relacion" id="tableColumn4">
                                                <webuijsf:staticText id="staticText4" text="#{currentRow.value['relacion']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                                <h:panelGrid columns="3" id="gridPanelBotones">
                                    <webuijsf:button actionExpression="#{ABMEquivalencias.uiNuevo_action}" id="uiNuevo" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMEquivalencias.uiEditar_action}" id="uiEditar" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMEquivalencias.uiEliminar_action}" id="uiEliminar" text="Eliminar"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMEquivalencias.gridPanelAddUpdate}" columns="1" id="gridPanelAddUpdate" style="height: 72px" width="599">
                                <webuijsf:staticText binding="#{ABMEquivalencias.equivalencias}" id="equivalencias"
                                    style="color: rgb(0, 0, 153); font-family: 'Arial','Helvetica',sans-serif; font-size: 18px; font-weight: bold" text="Datos Equivalencia"/>
                                <br/>
                                <h:panelGrid id="gridPanel5" style="height: 120px; width: 100%">
                                    <webuijsf:label id="label3" text="Producto Generico"/>
                                    <h:panelGrid columns="2" id="gridPanel1" style="height: 100%; width: 100%">
                                        <webuijsf:dropDown binding="#{ABMEquivalencias.uiProductoGen}" id="uiProductoGen"
                                            items="#{ABMEquivalencias.listaProductosGenOp}" required="true" separators="false" width="250"/>
                                    </h:panelGrid>
                                    <webuijsf:label id="label4" text="Producto Final"/>
                                    <h:panelGrid columns="2" id="gridPanel3" style="height: 100%; width: 100%">
                                        <webuijsf:dropDown binding="#{ABMEquivalencias.uiProductoFin}" id="uiProductoFin"
                                            items="#{ABMEquivalencias.listaProductosFinOp}" required="true" separators="false" width="250"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel6">
                                        <webuijsf:label id="label5" text="Relacion"/>
                                        <webuijsf:textField binding="#{ABMEquivalencias.uiRelacion}" id="uiRelacion"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMEquivalencias.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate"
                                    style="background-position: right; height: 24px; text-align: right" width="167">
                                    <webuijsf:button actionExpression="#{ABMEquivalencias.uiButtonCancelarRegistro_action}" id="uiButtonCancelarRegistro"
                                        style="font-size: 14px; height: 24px" text="Cancelar"/>
                                    <webuijsf:button actionExpression="#{ABMEquivalencias.uiButtonGuardarRegistro_action}"
                                        binding="#{ABMEquivalencias.uiButtonGuardarRegistro}" id="uiButtonGuardarRegistro" style="font-size: 14px; height: 24px" text="Guardar"/>
                                    <webuijsf:button actionExpression="#{ABMEquivalencias.button2_action}" id="uiButtonEditarRegistro"
                                        style="font-size: 14px; height: 24px" text="Guardar"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid id="gridPanel7" style="height: 100%; width: 100%">
                                <webuijsf:button actionExpression="#{ABMEquivalencias.button1_action}" id="button1" text="Button"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
