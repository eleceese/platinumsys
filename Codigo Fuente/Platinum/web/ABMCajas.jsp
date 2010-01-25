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
                            <webuijsf:pageAlert binding="#{ABMCajas.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMCajas.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 47px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField binding="#{ABMCajas.uiTxtFilCodigo}" columns="10" id="uiTxtFilCodigo"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height:30px; width: 60%">
                                    <webuijsf:label id="nombre" text="Caja"/>
                                    <webuijsf:textField binding="#{ABMCajas.uiTxtFilDescripcion}" columns="30" id="uiTxtFilDescripcion"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMCajas.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMCajas.uiBtnTodos_action}" id="uiBtnTodos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMCajas.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMCajas.table1}" id="table1" title="Cajas" width="383">
                                    <webuijsf:tableRowGroup binding="#{ABMCajas.tableRowGroup1}" emptyDataMsg="No se encontraron registros..."
                                        id="tableRowGroup1" rows="5" selected="#{ABMCajas.selectedState}" sourceData="#{SessionBean1.listaCaja}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMCajas.tableColumn3}" id="tableColumn3"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMCajas.radioButton1.id}" width="41">
                                            <webuijsf:radioButton binding="#{ABMCajas.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMCajas.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMCajas.selected}" selectedValue="#{ABMCajas.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Caja" id="tableColumn1" sort="nombreCaja" width="224">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['nombreCaja']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Caja" id="tableColumn2" sort="codCaja" width="136">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['codCaja']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMCajas.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMCajas.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMCajas.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMCajas.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{ABMCajas.datosCaja}" id="datosCaja"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos de la Caja"/>
                            <br/>
                            <h:panelGrid binding="#{ABMCajas.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelCaja" text="Caja"/>
                                <h:panelGrid columns="2" id="gridPanelMarca" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMCajas.uiTxtDescripcion}" columns="50" id="uiTxtDescripcion"/>
                                    <webuijsf:message for="uiTxtDescripcion" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMCajas.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMCajas.uiBtnGuardarNuevo_action}" binding="#{ABMCajas.uiBtnGuardarNuevo}"
                                    id="uiBtnGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMCajas.uiBtnGuardarEditar_action}" binding="#{ABMCajas.uiBtnGuardarEditar}"
                                    id="uiBtnGuardarEditar" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMCajas.uiBtnCancelar_action}" id="uiBtnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
