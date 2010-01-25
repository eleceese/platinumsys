<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ABMCliente
    Created on : Oct 18, 2009, 8:11:57 PM
    Author     : FerBoy
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="ABMSecciones">
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
                            <webuijsf:pageAlert binding="#{ABMSecciones.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMSecciones.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField binding="#{ABMSecciones.uiTxtFilCodigo}" columns="15" id="uiTxtFilCodigo"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelDescripcion" style="height:30px; width: 60%">
                                    <webuijsf:label id="labelNombreSeccion" text="Nombre Seccion"/>
                                    <webuijsf:textField binding="#{ABMSecciones.uiTxtFilDescripcion}" columns="45" id="uiTxtFilDescripcion"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMSecciones.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMSecciones.uiBtnBuscarTodos_action}" id="uiBtnBuscarTodos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMSecciones.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMSecciones.table1}" id="table1" paginateButton="true"
                                                paginationControls="true" sortPanelToggleButton="true" title="Seccion" width="695">
                                    <webuijsf:tableRowGroup binding="#{ABMSecciones.tableRowGroup1}" emptyDataMsg="No se encontraron registros..."
                                                            id="tableRowGroup1" rows="15" selected="#{ABMSecciones.selectedState}" sourceData="#{SessionBean1.listaSeccion}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMSecciones.tableColumn1}" id="tableColumn1"
                                                              onClick="setTimeout('initAllRows()',0)" selectId="#{ABMSecciones.radioButton7.id}" width="40">
                                            <webuijsf:radioButton binding="#{ABMSecciones.radioButton7}" id="radioButton7" label=""
                                                                  name="#{ABMSecciones.radioButton7.id}" onClick="delSelect='ok'" selected="#{ABMSecciones.selected}" selectedValue="#{ABMSecciones.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Seccion" id="tableColumn2" sort="nombreSeccion">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['nombreSeccion']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="tableColumn3" sort="codSeccion" width="184">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['codSeccion']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMSecciones.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMSecciones.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMSecciones.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMSecciones.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMSecciones.datosSeccion}" id="datosSeccion"
                                                 style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos de la Seccion"/>
                            <br/>
                            <h:panelGrid binding="#{ABMSecciones.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelSeccion" text="Seccion"/>
                                <h:panelGrid columns="2" id="gridPanelMarca" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMSecciones.uiTxtDescripcion}" columns="50" id="uiTxtDescripcion" text="Seccion"/>
                                    <webuijsf:message for="uiTxtDescripcion" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMSecciones.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMSecciones.uiBtnGuardarNuevo_action}" binding="#{ABMSecciones.uiBtnGuardarNuevo}"
                                                 id="uiBtnGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMSecciones.uiBtnGuardarEditar_action}" binding="#{ABMSecciones.uiBtnGuardarEditar}"
                                                 id="uiBtnGuardarEditar" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMSecciones.uiBtnCancelar_action}" id="uiBtnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
