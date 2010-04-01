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
                        function confirmar() {
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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 216px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMEquivalencia.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMEquivalencia.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="695">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Producto Generico"/>
                                    <webuijsf:dropDown binding="#{ABMEquivalencia.uiProductoGenFil}" id="uiProductoGenFil"
                                        items="#{ABMEquivalencia.listaProductosGenOp}" width="300"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height: 30px" width="261">
                                    <webuijsf:label id="labelNombreTarea" text="Producto Fin"/>
                                    <webuijsf:dropDown binding="#{ABMEquivalencia.uiProductoFinFil}" id="uiProductoFinFil"
                                        items="#{ABMEquivalencia.listaProductosFinOp}" width="300"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="167">
                                    <webuijsf:button actionExpression="#{ABMEquivalencia.buscar_action}" id="buscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMEquivalencia.todos_action}" id="todos" text="Todos"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMEquivalencia.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMEquivalencia.tableTareas}" id="tableTareas" paginateButton="true"
                                    paginationControls="true" title="Equivalencias" width="743">
                                    <webuijsf:tableRowGroup binding="#{ABMEquivalencia.tareasRW}" emptyDataMsg="No se encontraron registros..." id="tareasRW"
                                        rows="20" selected="#{ABMEquivalencia.selectedState}" sourceData="#{ABMEquivalencia.listaEquivalencias}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMEquivalencia.tableColumn3}" id="tableColumn3"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMEquivalencia.radioButton1.id}">
                                            <webuijsf:radioButton binding="#{ABMEquivalencia.radioButton1}" id="radioButton1" label=""
                                                selected="#{ABMEquivalencia.selected}" selectedValue="#{ABMEquivalencia.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cod" id="tableColumn2">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['codEquivalencia']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Producto Generico" id="tableColumn5" sort="codProductoGen">
                                            <webuijsf:staticText id="staticText4" text="#{currentRow.value['codProductoGen']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Producto Fin" id="tableColumn4" sort="codProductoFin">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProductoFin']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Relacion" id="tableColumn6">
                                            <webuijsf:staticText id="staticText5" text="#{currentRow.value['relacion']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMEquivalencia.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMEquivalencia.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMEquivalencia.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMEquivalencia.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMEquivalencia.datosTareas}" id="datosTareas"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos de la Relacion"/>
                            <h:panelGrid binding="#{ABMEquivalencia.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <h:panelGrid id="gridPanel2" style="height: 120px; width: 100%">
                                    <webuijsf:label id="label1" text="Producto Generico"/>
                                    <h:panelGrid columns="2" id="gridPanel3" style="height: 100%; width: 100%">
                                        <webuijsf:dropDown binding="#{ABMEquivalencia.uiProductoGen}" id="uiProductoGen"
                                            items="#{ABMEquivalencias.listaProductosGenOp}" required="true" separators="false" width="250"/>
                                    </h:panelGrid>
                                    <webuijsf:label id="label2" text="Producto Final"/>
                                    <h:panelGrid columns="2" id="gridPanel4" style="height: 100%; width: 100%">
                                        <webuijsf:dropDown binding="#{ABMEquivalencia.uiProductoFin}" id="uiProductoFin"
                                            items="#{ABMEquivalencias.listaProductosFinOp}" required="true" separators="false" width="250"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel5">
                                        <webuijsf:label id="label3" text="Relacion"/>
                                        <webuijsf:textField binding="#{ABMEquivalencia.uiRelacion}" id="uiRelacion"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMEquivalencia.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMEquivalencia.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMEquivalencia.buttonGuardarNuevo_action}" binding="#{ABMEquivalencia.buttonGuardarNuevo}"
                                    id="buttonGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMEquivalencia.buttonGuardarEdicion_action}"
                                    binding="#{ABMEquivalencia.buttonGuardarEdicion}" id="buttonGuardarEdicion" text="Guardar"/>
                            </h:panelGrid>
                            <webuijsf:messageGroup id="messageGroup1"/>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
