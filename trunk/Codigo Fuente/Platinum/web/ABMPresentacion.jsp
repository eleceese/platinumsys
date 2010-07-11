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
                        function initAllRows() {
                            var table = document.getElementById("form1:tableTareas");
                            table.initAllRows();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function ABMMaquinaria() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar el Registro?")) {
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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 216px; top: 216px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMPresentacion.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMPresentacion.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="455">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField binding="#{ABMPresentacion.uiCodigoFil}" id="uiCodigoFil"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height: 30px" width="261">
                                    <webuijsf:label id="labelNombreTarea" text="Nombre Presentacion"/>
                                    <webuijsf:textField binding="#{ABMPresentacion.uiNombreFil}" id="uiNombreFil"/>
                                </h:panelGrid>
                                <webuijsf:button actionExpression="#{ABMPresentacion.buscar_action}" id="buscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMPresentacion.todos_action}" id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMPresentacion.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMPresentacion.tableTareas}" id="tableTareas" paginateButton="true"
                                    paginationControls="true" title="Presentaciones" width="515">
                                    <webuijsf:tableRowGroup binding="#{ABMPresentacion.tareasRW}" emptyDataMsg="No se encontraron registros..." id="tareasRW"
                                        rows="10" selected="#{ABMPresentacion.selectedState}" sourceData="#{SessionBean1.listaPresentacions}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMPresentacion.tableColumn1}" id="tableColumn1"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMPresentacion.radioButton1.id}" width="10">
                                            <webuijsf:radioButton binding="#{ABMPresentacion.radioButton1}" id="radioButton1"
                                                name="#{ABMPresentacion.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMPresentacion.selected}" selectedValue="#{ABMPresentacion.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cod" id="tableColumn2" width="15">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codPresentacion']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="descripcion" id="tableColumn4" sort="descripcion" width="350">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['descripcion']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMPresentacion.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMPresentacion.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMPresentacion.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMPresentacion.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMPresentacion.datosTareas}" id="datosTareas"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos de la Presentacion"/>
                            <br/>
                            <h:panelGrid binding="#{ABMPresentacion.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labeTarea" text="Tarea"/>
                                <h:panelGrid columns="2" id="gridPanelMarca" style="height: 50px" width="575">
                                    <webuijsf:textField binding="#{ABMPresentacion.uiPresentacion}" columns="50" id="uiPresentacion"/>
                                    <webuijsf:message for="uiPresentacion" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMPresentacion.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMPresentacion.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMPresentacion.buttonGuardarNuevo_action}" binding="#{ABMPresentacion.buttonGuardarNuevo}"
                                    id="buttonGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMPresentacion.buttonGuardarEdicion_action}"
                                    binding="#{ABMPresentacion.buttonGuardarEdicion}" id="buttonGuardarEdicion" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
