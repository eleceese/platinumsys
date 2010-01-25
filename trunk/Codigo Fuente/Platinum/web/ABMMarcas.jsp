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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 216px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMMarcas.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMMarcas.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField binding="#{ABMMarcas.uiTxtFilCodigo}" columns="10" id="uiTxtFilCodigo"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelDescripcion" style="height:30px; width: 60%">
                                    <webuijsf:label id="descripcion" text="Descripcion"/>
                                    <webuijsf:textField binding="#{ABMMarcas.uiTxtFilDescripcion}" columns="45" id="uiTxtFilDescripcion"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMMarcas.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMMarcas.uiBtnBuscarTodos_action}" id="uiBtnBuscarTodos" text="Todos"/>
                            </h:panelGrid>

                            <h:panelGrid binding="#{ABMMarcas.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" id="table1" title="Marcas" width="551">
                                    <webuijsf:tableRowGroup binding="#{ABMMarcas.tableRowGroup1}" emptyDataMsg="No se encontraron registros..."
                                                            id="tableRowGroup1" rows="10" selected="#{ABMMarcas.selectedState}" sourceData="#{SessionBean1.listaMarcas}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMMarcas.tableColumn3}" id="tableColumn3" width="40">
                                            <webuijsf:radioButton binding="#{ABMMarcas.radioButton1}" id="radioButton1" label=""
                                                                  name="#{ABMMarcas.radioButton1.id}" onClick="delSelect='ok' " selected="#{ABMMarcas.selected}" selectedValue="#{ABMMarcas.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Descripcion" id="tableColumn1" sort="nombre">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['nombre']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="tableColumn2" sort="codMarca" width="136">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['codMarca']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMMarcas.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMMarcas.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMMarcas.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMMarcas.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMMarcas.datosMarca}" id="datosMarca"
                                                 style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos de la Marca"/>
                            <br/>
                            <h:panelGrid binding="#{ABMMarcas.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelMarca" text="Marca"/>
                                <h:panelGrid columns="2" id="gridPanelMarca" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMMarcas.uiTxtDescripcion}" columns="50" id="uiTxtDescripcion"/>
                                    <webuijsf:message for="uiTxtDescripcion" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMMarcas.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMMarcas.uiBtnGuardarNuevo_action}" binding="#{ABMMarcas.uiBtnGuardarNuevo}"
                                                 id="uiBtnGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMMarcas.uiBtnGuardarEditar_action}" binding="#{ABMMarcas.uiBtnGuardarEditar}"
                                                 id="uiBtnGuardarEditar" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMMarcas.uiBtnCancelar_action}" id="uiBtnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
