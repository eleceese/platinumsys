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
                                if(!confirm("¿Está seguro de eliminar el Registro seleccionado?")) {
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
                            <webuijsf:pageAlert binding="#{ABMMaquinaria.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMMaquinaria.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 22px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField binding="#{ABMMaquinaria.uiTxtFilCodigo}" id="uiTxtFilCodigo"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height: 30px" width="359">
                                    <webuijsf:label id="nombre" text="Nombre"/>
                                    <webuijsf:textField binding="#{ABMMaquinaria.uiTxtFilDescripcion}" columns="45" id="uiTxtFilDescripcion"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMMaquinaria.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMMaquinaria.uiBtnTodos_action}" id="uiBtnTodos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMMaquinaria.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMMaquinaria.table1}" id="table1" paginateButton="true" paginationControls="true"
                                    title="Maquinarias" width="575">
                                    <webuijsf:tableRowGroup binding="#{ABMMaquinaria.tableRowGroup1}" emptyDataMsg="No se encontraron registros..."
                                        id="tableRowGroup1" rows="5" selected="#{ABMMaquinaria.selectedState}" sourceData="#{SessionBean1.listaMaquinarias}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMMaquinaria.tableColumn1}" id="tableColumn1" width="10" onClick="setTimeout('initAllRows()',0)" selectId="#{ABMMaquinaria.radioButton1.id}">
                                            <webuijsf:radioButton binding="#{ABMMaquinaria.radioButton1}" id="radioButton1" label="" name="#{ABMMaquinaria.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMMaquinaria.selected}" selectedValue="#{ABMMaquinaria.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cod" id="tableColumn2" width="15">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['codMaquinaria']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Descripcion" id="tableColumn6" sort="descripcion" width="250">
                                            <webuijsf:staticText id="staticText5" text="#{currentRow.value['descripcion']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cons Kwh" id="tableColumn4" width="40">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['consumoKwh']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Costo Mantenimiento" id="tableColumn5" width="80">
                                            <webuijsf:staticText id="staticText4" text="#{currentRow.value['costoMantenimiento']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Hs Mantenimento" id="tableColumn7" width="80">
                                            <webuijsf:staticText id="staticText6" text="#{currentRow.value['horasMantenimento']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMMaquinaria.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMMaquinaria.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMMaquinaria.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMMaquinaria.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{ABMMaquinaria.datosBanco}" id="datosBanco"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos del Banco"/>
                            <br/>
                            <h:panelGrid binding="#{ABMMaquinaria.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelBanco" text="Descripcion"/>
                                <h:panelGrid columns="2" id="gridPanelMarca" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMMaquinaria.uiTxtDescripcion}" columns="50" id="uiTxtDescripcion"/>
                                    <webuijsf:message for="uiTxtDescripcion" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label1" text="KW/H"/>
                                <h:panelGrid columns="2" id="gridPanel1">
                                    <webuijsf:textField binding="#{ABMMaquinaria.uiKWH}" id="uiKWH"/>
                                    <webuijsf:message for="uiKWH" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label2" text="Cost Mant"/>
                                <h:panelGrid columns="2" id="gridPanel2">
                                    <webuijsf:textField binding="#{ABMMaquinaria.uiCostMan}" id="uiCostMan"/>
                                    <webuijsf:message for="uiCostMan" id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label3" text="Hs Mant"/>
                                <h:panelGrid columns="2" id="gridPanel3">
                                    <webuijsf:textField binding="#{ABMMaquinaria.uiHsMant}" id="uiHsMant"/>
                                    <webuijsf:message for="uiHsMant" id="message4" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMMaquinaria.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMMaquinaria.uiBtnGuardarNuevo_action}" binding="#{ABMMaquinaria.uiBtnGuardarNuevo}"
                                    id="uiBtnGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMMaquinaria.uiBtnGuardarEditar_action}" binding="#{ABMMaquinaria.uiBtnGuardarEditar}"
                                    id="uiBtnGuardarEditar" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMMaquinaria.uiBtnCancelar_action}" id="uiBtnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
