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
                            var table = document.getElementById("form1:table1");
                            table.initAllRows();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de Generar comisiones?")) {
                                    return false;
                                }else{
                                    return true;
                                }
                            }
                        }

                        function confirmarCerrar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de Cerrar el Periodo?")) {
                                    return false;
                                }else{
                                    return true;
                                }
                            }
                        }

                        function confirmarAnular() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de Anular el Periodo?")) {
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
                            <webuijsf:pageAlert binding="#{ABMComisionMensual.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMComisionMensual.gridPanelBuscar}" columns="4" id="gridPanelBuscar" style="height: 22px" width="527">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Mes"/>
                                    <webuijsf:textField binding="#{ABMComisionMensual.uiTxtFilMes}" columns="10" id="uiTxtFilMes"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height: 30px" width="143">
                                    <webuijsf:label id="nombre" text="Anio"/>
                                    <webuijsf:textField binding="#{ABMComisionMensual.uiTxtFilAnio}" columns="10" id="uiTxtFilAnio"/>
                                </h:panelGrid>
                                <webuijsf:label id="label1" text="Estado"/>
                                <webuijsf:dropDown binding="#{ABMComisionMensual.uiLstFilEstadoComision}" id="uiLstFilEstadoComision"
                                    items="#{ABMComisionMensual.uiLstFilEstadoComisionDefaultOptions.options}"
                                    selected="#{ABMComisionMensual.uiLstFilEstadoComisionDefaultOptions.selectedValue}" width="100"/>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMComisionMensual.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMComisionMensual.uiBtnTodos_action}" id="uiBtnTodos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMComisionMensual.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMComisionMensual.table1}" id="table1" title="Comisiones Mensuales Venta" width="527">
                                    <webuijsf:tableRowGroup binding="#{ABMComisionMensual.tableRowGroup1}" emptyDataMsg="No se encontraron registros..."
                                        id="tableRowGroup1" rows="5" selected="#{ABMComisionMensual.selectedState}"
                                        sourceData="#{SessionBean1.listaVentaComisionMensual}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMComisionMensual.tableColumn3}" id="tableColumn3"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMComisionMensual.radioButton1.id}" width="40">
                                            <webuijsf:radioButton binding="#{ABMComisionMensual.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMComisionMensual.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMComisionMensual.selected}" selectedValue="#{ABMComisionMensual.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Anio" id="tableColumn1" sort="anio" width="358">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['anio']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Mes" id="tableColumn2" sort="mes" width="113">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['mesLetra']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumnEstado" sort="estado" width="110">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['estado']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMComisionMensual.gridPanelBotones}" columns="5" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMComisionMensual.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMComisionMensual.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMComisionMensual.generar_Comisiones_action}" id="generar_Comisiones"
                                    onClick="javascript:return confirmar()" text="Generar Comisiones"/>
                                <webuijsf:button actionExpression="#{ABMComisionMensual.CerrarPeriodo_action}" id="CerrarPeriodo"
                                    onClick="javascript:return confirmarCerrar()" text="Cerrar Periodo"/>
                                <webuijsf:button actionExpression="#{ABMComisionMensual.AnularPeriodo_action}" id="AnularPeriodo"
                                    onClick="javascript:return confirmarAnular()" text="Anular Periodo"/>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMComisionMensual.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelBanco1" text="Mes"/>
                                <webuijsf:dropDown binding="#{ABMComisionMensual.uiLstMes}" id="uiLstMes"
                                    items="#{ABMComisionMensual.uiLstMesDefaultOptions.options}" width="100"/>
                                <webuijsf:label id="labelBanco" text="Anio"/>
                                <h:panelGrid columns="2" id="gridPanelMarca" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMComisionMensual.uiTxtAnio}" columns="10"
                                        converter="#{ABMComisionMensual.numberConverter1}" id="uiTxtAnio"/>
                                    <webuijsf:message for="uiTxtAnio" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMComisionMensual.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMComisionMensual.uiBtnGuardarNuevo_action}"
                                    binding="#{ABMComisionMensual.uiBtnGuardarNuevo}" id="uiBtnGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMComisionMensual.uiBtnGuardarEditar_action}"
                                    binding="#{ABMComisionMensual.uiBtnGuardarEditar}" id="uiBtnGuardarEditar" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMComisionMensual.uiBtnCancelar_action}" id="uiBtnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
