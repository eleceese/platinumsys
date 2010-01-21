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
                            var table = document.getElementById("form1:tableUnidadMedida");
                            table.ABMProveedores();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar la Unidad de Medida Seleccionada?")) {
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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 216px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMUnidadMedida.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMUnidadMedida.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField binding="#{ABMUnidadMedida.uiCodigoFil}" id="uiCodigoFil"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelUnidadMedida" style="height: 30px" width="263">
                                    <webuijsf:label id="unidadMedida1" text="Unidad de Medida"/>
                                    <webuijsf:textField binding="#{ABMUnidadMedida.uiUnidadMedidaFil}" id="uiUnidadMedidaFil"/>
                                </h:panelGrid>
                                <webuijsf:button id="buscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMUnidadMedida.todos_action}" id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMUnidadMedida.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMUnidadMedida.tableUnidadMedida}" id="tableUnidadMedida" paginateButton="true"
                                    paginationControls="true" title="Unidades de Medida" width="551">
                                    <webuijsf:tableRowGroup binding="#{ABMUnidadMedida.unidadMedida}" emptyDataMsg="No se encontraron registros..."
                                        id="unidadMedida" rows="10" selected="#{ABMUnidadMedida.selectedState}" sourceData="#{SessionBean1.listaUnidadMedidas}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMUnidadMedida.uiRadioColum}" id="uiRadioColum"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMUnidadMedida.radioButton1.id}" valign="top">
                                            <webuijsf:radioButton binding="#{ABMUnidadMedida.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMUnidadMedida.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMUnidadMedida.selected}" selectedValue="#{ABMUnidadMedida.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="tableColumn1" sort="codUnidadMedida">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codUnidadMedida']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Unidad de Medida" id="tableColumn2" sort="descripcion" width="328">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['descripcion']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMUnidadMedida.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMUnidadMedida.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMUnidadMedida.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMUnidadMedida.eliminar_action}" binding="#{ABMUnidadMedida.eliminar}" id="eliminar"
                                    onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{ABMUnidadMedida.datosUnidadMedida}" id="datosUnidadMedida"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos Unidad de Medida"/>
                            <br/>
                            <h:panelGrid binding="#{ABMUnidadMedida.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelUnidad" text="Unidad de Medida"/>
                                <h:panelGrid columns="2" id="gridPanelTipo1" style="height: 72px" width="577">
                                    <webuijsf:textField binding="#{ABMUnidadMedida.uiUnidadMedida}" columns="50" id="uiUnidadMedida"/>
                                    <webuijsf:message for="uiUnidadMedida" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMUnidadMedida.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMUnidadMedida.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMUnidadMedida.buttonGuardarNuevo_action}" binding="#{ABMUnidadMedida.buttonGuardarNuevo}"
                                    id="buttonGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMUnidadMedida.buttonGuardarEdicion1_action}" id="buttonGuardarEdicion1" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
