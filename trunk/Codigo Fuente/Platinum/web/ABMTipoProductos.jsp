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
                    <!-- \SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <script>
                        function ABMProveedores() {
                            var table = document.getElementById("form1:tableTipo");
                            table.ABMProveedores();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar el Tipo de Producto seleccionado?")) {
                                    return false;
                                }else{
                                    return true;
                                }
                            }
                        }
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
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
                            <webuijsf:pageAlert binding="#{ABMTipoProductos.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMTipoProductos.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField binding="#{ABMTipoProductos.uiCodigoFil}" id="uiCodigoFil"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelTipo" style="height:30px; width: 60%">
                                    <webuijsf:label id="tipo" text="Tipo"/>
                                    <webuijsf:textField binding="#{ABMTipoProductos.uiTipoFIl}" id="uiTipoFIl"/>
                                </h:panelGrid>
                                <webuijsf:button actionExpression="#{ABMTipoProductos.buscar_action}" id="buscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMTipoProductos.todos_action}" id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMTipoProductos.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMTipoProductos.tableTipo}" id="tableTipo" title="Tipos de Productos" width="695">
                                    <webuijsf:tableRowGroup binding="#{ABMTipoProductos.uiTablaTipos}" emptyDataMsg="No se encontraron registros..."
                                        id="uiTablaTipos" rows="5" selected="#{ABMTipoProductos.selectedState}" sourceData="#{SessionBean1.listaTipoProductos}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMTipoProductos.tableColumnRadio}" id="tableColumnRadio"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMTipoProductos.radioButton1.id}" valign="top">
                                            <webuijsf:radioButton binding="#{ABMTipoProductos.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMTipoProductos.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMTipoProductos.selected}" selectedValue="#{ABMTipoProductos.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="right" headerText="Codigo" id="tableColumn1" sort="codTipoProducto" width="179">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codTipoProducto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Descripcion" id="tableColumn2" sort="descripcion">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['descripcion']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMTipoProductos.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMTipoProductos.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMTipoProductos.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMTipoProductos.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{ABMTipoProductos.datosTipo}" id="datosTipo"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos Tipo de Producto"/>
                            <br/>
                            <h:panelGrid binding="#{ABMTipoProductos.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelTipo" text="Tipo"/>
                                <h:panelGrid columns="2" id="gridPanelTipo1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMTipoProductos.uiTipo}" columns="50" id="uiTipo" valueChangeListenerExpression="#{ABMTipoProductos.uiTipo_processValueChange}"/>
                                    <webuijsf:message for="uiTipo" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelExistencia" text="Controla Existencia"/>
                                <h:panelGrid columns="2" id="gridPanelTipo2" style="height: 100%" width="575">
                                    <webuijsf:checkbox binding="#{ABMTipoProductos.uiExistChek}" id="uiExistChek" label="Checkbox"/>
                                    <webuijsf:message for="uiExistChek" id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMTipoProductos.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMTipoProductos.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMTipoProductos.buttonGuardarNuevo_action}"
                                    binding="#{ABMTipoProductos.buttonGuardarNuevo}" id="buttonGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMTipoProductos.buttonGuardarEdicion_action}"
                                    binding="#{ABMTipoProductos.buttonGuardarEdicion}" id="buttonGuardarEdicion" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
