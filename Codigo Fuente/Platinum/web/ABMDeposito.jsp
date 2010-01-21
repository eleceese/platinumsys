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
                            var table = document.getElementById("form1:tableDepositos");
                            table.ABMProveedores();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar el registro seleccionado?")) {
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
                            <webuijsf:pageAlert binding="#{ABMDeposito.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMDeposito.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField binding="#{ABMDeposito.uiCodigoFil}" id="uiCodigoFil"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelTipo" style="height:30px; width: 60%">
                                    <webuijsf:label id="deposito" text="Tipo"/>
                                    <webuijsf:textField binding="#{ABMDeposito.uiNombreFIl}" id="uiNombreFIl"/>
                                </h:panelGrid>
                                <webuijsf:button actionExpression="#{ABMDeposito.buscar_action}" id="buscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMDeposito.todos_action}" id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMDeposito.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMDeposito.tableDepositos}" id="tableDepositos" paginateButton="true"
                                    paginationControls="true" title="Lista de Depositos" width="743">
                                    <webuijsf:tableRowGroup binding="#{ABMDeposito.uiTablaDepositos}" emptyDataMsg="No se encontraron registros..."
                                        id="uiTablaDepositos" rows="10" selected="#{ABMDeposito.selectedState}" sourceData="#{SessionBean1.listaDepositos}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMDeposito.tableColumn3}" id="tableColumn3"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMDeposito.radioButton1.id}" width="65">
                                            <webuijsf:radioButton binding="#{ABMDeposito.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMDeposito.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMDeposito.selected}" selectedValue="#{ABMDeposito.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="tableColumn1" sort="codDeposito" width="89">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codDeposito']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nombre" id="tableColumn2" sort="nombre" width="290">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['nombre']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMDeposito.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMDeposito.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMDeposito.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMDeposito.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{ABMDeposito.datosDeposito}" id="datosDeposito"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos Deposito"/>
                            <br/>
                            <h:panelGrid binding="#{ABMDeposito.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelDEP" text="Deposito"/>
                                <h:panelGrid binding="#{ABMDeposito.gridPanelDeposito1}" columns="2" id="gridPanelDeposito1" style="height: 48px" width="575">
                                    <webuijsf:textField binding="#{ABMDeposito.uiNombreDeposito}" columns="50" id="uiNombreDeposito" valueChangeListenerExpression="#{ABMDeposito.uiNombreDeposito_processValueChange}"/>
                                    <webuijsf:message for="uiNombreDeposito" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelExistencia" text="Activo "/>
                                <h:panelGrid columns="2" id="gridPanelDeposito2" style="height: 100%" width="575">
                                    <webuijsf:checkbox binding="#{ABMDeposito.uiActivoChek}" id="uiActivoChek" label="Si"/>
                                    <webuijsf:message for="uiActivoChek" id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelFecha" text="Fecha Alta"/>
                                <h:panelGrid columns="2" id="gridPanelDeposito3" style="height: 100%" width="575">
                                    <webuijsf:calendar binding="#{ABMDeposito.uiFechaAltaCalendar}" id="uiFechaAltaCalendar"/>
                                    <webuijsf:message for="uiFechaAltaCalendar" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMDeposito.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMDeposito.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMDeposito.buttonGuardarNuevo_action}" binding="#{ABMDeposito.buttonGuardarNuevo}"
                                    id="buttonGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMDeposito.buttonGuardarEdicion_action}" binding="#{ABMDeposito.buttonGuardarEdicion}"
                                    id="buttonGuardarEdicion" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
