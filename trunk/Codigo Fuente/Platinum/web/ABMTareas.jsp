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
                            <webuijsf:pageAlert binding="#{ABMTareas.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMTareas.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="455">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField binding="#{ABMTareas.uiCodigoFil}" id="uiCodigoFil"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height: 30px" width="261">
                                    <webuijsf:label id="labelNombreTarea" text="Nombre Tarea"/>
                                    <webuijsf:textField binding="#{ABMTareas.uiNombreFil}" id="uiNombreFil"/>
                                </h:panelGrid>
                                <webuijsf:button actionExpression="#{ABMTareas.buscar_action}" id="buscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMTareas.todos_action}" id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMTareas.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMTareas.tableTareas}" id="tableTareas" title="Tareas" width="695">
                                    <webuijsf:tableRowGroup binding="#{ABMTareas.tareasRW}" emptyDataMsg="No se encontraron registros..." id="tareasRW" rows="5"
                                        selected="#{ABMTareas.selectedState}" sourceData="#{SessionBean1.listaTareas}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMTareas.tableColumn3}" id="tableColumn3"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMTareas.radioButton1.id}" width="65">
                                            <webuijsf:radioButton binding="#{ABMTareas.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMTareas.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMTareas.selected}" selectedValue="#{ABMTareas.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="tableColumn1" sort="codTarea">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codTarea']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Descripcion" id="tableColumn2" sort="nombreTarea">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['nombreTarea']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMTareas.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMTareas.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMTareas.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMTareas.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMTareas.datosTareas}" id="datosTareas"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos de la Tarea"/>
                            <br/>
                            <h:panelGrid binding="#{ABMTareas.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labeTarea" text="Tarea"/>
                                <h:panelGrid columns="2" id="gridPanelMarca" style="height: 50px" width="575">
                                    <webuijsf:textField binding="#{ABMTareas.uiTarea}" columns="50" id="uiTarea"/>
                                    <webuijsf:message for="uiTarea" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMTareas.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMTareas.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMTareas.buttonGuardarNuevo_action}" binding="#{ABMTareas.buttonGuardarNuevo}"
                                    id="buttonGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMTareas.buttonGuardarEdicion_action}" binding="#{ABMTareas.buttonGuardarEdicion}"
                                    id="buttonGuardarEdicion" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
