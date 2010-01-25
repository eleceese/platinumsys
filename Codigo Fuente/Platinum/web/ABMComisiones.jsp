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
                    <webuijsf:script id="scriptPopUp" type="text/javascript" url="/js/utilJS.js"/>
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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 240px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMComisiones.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMComisiones.gridPanelBuscar}" columns="3" id="gridPanelBuscar" style="height: 72px" width="599">
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height: 30px" width="263">
                                    <webuijsf:label id="producto" text="Producto"/>
                                    <webuijsf:textField binding="#{ABMComisiones.uiTxtFilProducto}" columns="35" id="uiTxtFilProducto"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelRUC" style="height: 30px" width="167">
                                    <webuijsf:label id="fechaInic" text="Desde"/>
                                    <webuijsf:calendar binding="#{ABMComisiones.uiCalFilDesde}" columns="15" id="uiCalFilDesde"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelCedula" style="height: 30px" width="167">
                                    <webuijsf:label id="fechaFin" text="Hasta"/>
                                    <webuijsf:calendar binding="#{ABMComisiones.uiCalFilHasta}" columns="15" id="uiCalFilHasta"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMComisiones.gridPanelBtnBuscar}" columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMComisiones.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMComisiones.uiBtnTodos_action}" id="uiBtnTodos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMComisiones.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true" sortPanelToggleButton="true"
                                    title="Comisiones" width="671">
                                    <webuijsf:tableRowGroup binding="#{ABMComisiones.tableRowGroup1}" emptyDataMsg="No se encontraron registros..."
                                        id="tableRowGroup1" rows="15" selected="#{ABMComisiones.selectedState}" sourceData="#{SessionBean1.listaComision}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMComisiones.tableColumn6}" id="tableColumn6"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMComisiones.radioButton1.id}" width="40">
                                            <webuijsf:radioButton binding="#{ABMComisiones.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMComisiones.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMComisiones.selected}" selectedValue="#{ABMComisiones.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Producto" id="tableColumn1" sort="codProducto">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProducto'].descripcion}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Porcentaje" id="tableColumn2" sort="porcentaje">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['porcentaje']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fec. Inicial" id="tableColumn3" sort="fecInicial">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText3" text="#{currentRow.value['fecInicial']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fec. Final" id="tableColumn4" sort="fecFinal">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText4" text="#{currentRow.value['fecFinal']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn5" sort="estado">
                                            <webuijsf:staticText id="staticText5" text="#{currentRow.value['estado']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMComisiones.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 50px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMComisiones.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMComisiones.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMComisiones.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMComisiones.datosComision}" id="datosComision"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos de la Comision"/>
                            <br/>
                            <h:panelGrid binding="#{ABMComisiones.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:hyperlink id="linkProducto" onClick="doPopup('form1:uiTxtCodProducto_field', 'form1:uiTxtProductoDescripcion_field')"
                                    target="popup" text="Producto" url="/faces/popup/popupProductos.jsp"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <h:panelGrid columns="2" id="gridPanelProducto" style="height: 100%; margin-left: -9px" width="311">
                                        <webuijsf:textField binding="#{ABMComisiones.uiTxtCodProducto}" columns="10" id="uiTxtCodProducto"/>
                                        <webuijsf:textField binding="#{ABMComisiones.uiTxtProductoDescripcion}" columns="35" id="uiTxtProductoDescripcion"/>
                                    </h:panelGrid>
                                    <webuijsf:message for="uiTxtCodProducto" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="porcentaje1" text="Porcentaje %"/>
                                <h:panelGrid columns="2" id="gridPanel14" style="height: 100%" width="582">
                                    <webuijsf:textField binding="#{ABMComisiones.uiTxtPorcentaje}" columns="10" id="uiTxtPorcentaje"/>
                                    <webuijsf:message for="uiTxtPorcentaje" id="message14" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="fechaInicio" text="Fecha Inicial"/>
                                <h:panelGrid columns="2" id="gridPanel9" style="height: 100%" width="407">
                                    <webuijsf:calendar binding="#{ABMComisiones.uiCalFechaInicial}" columns="15" id="uiCalFechaInicial" style="margin-left: -9px"/>
                                    <webuijsf:message for="uiCalFechaInicial" id="message9" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="fechaFinal" text="Fecha Final"/>
                                <h:panelGrid columns="2" id="gridPanel2" style="height: 100%" width="431">
                                    <webuijsf:calendar binding="#{ABMComisiones.uiCalFechaFin}" columns="15" id="uiCalFechaFin" style="margin-left: -9px"/>
                                    <webuijsf:message for="uiCalFilHasta" id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="activo" text="Activo"/>
                                <h:panelGrid columns="2" id="gridPanel10" style="height: 100%" width="481">
                                    <webuijsf:checkbox binding="#{ABMComisiones.uiChkEstado}" id="uiChkEstado"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMComisiones.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMComisiones.uiBtnGuardarNuevo_action}" binding="#{ABMComisiones.uiBtnGuardarNuevo}"
                                    id="uiBtnGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMComisiones.uiBtnGuardarEditar_action}" binding="#{ABMComisiones.uiBtnGuardarEditar}"
                                    id="uiBtnGuardarEditar" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMComisiones.cancelar_action}" id="cancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
