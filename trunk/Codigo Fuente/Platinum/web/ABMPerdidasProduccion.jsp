<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Usuario
    Created on : 20-ago-2009, 19:25:55
    Author     : MartinJara
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <div>
                            <h:panelGrid binding="#{ABMPerdidasProduccion.mainContainer}" id="mainContainer" style="height: 96px; left: 288px; top: 216px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMPerdidasProduccion.gridPanelBuscar}" columns="2" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura">
                                        <webuijsf:label id="lblNroProveedor" text="Nro. Orden Trabajo"/>
                                        <webuijsf:textField id="txtNroFactura"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelProveedor1">
                                        <webuijsf:label id="lblProveedor" text="Responsable"/>
                                        <webuijsf:textField binding="#{ABMPerdidasProduccion.userNameFiltro}" columns="45" id="txtProveedor"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelButtonBuscar">
                                        <webuijsf:button binding="#{ABMPerdidasProduccion.buscarButton}" id="buscarButton" text="Buscar"/>
                                        <webuijsf:button binding="#{ABMPerdidasProduccion.todosButton}" id="todosButton" text="Todos"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMPerdidasProduccion.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                    function ABMCalculoDeCostosFinales() {
                                        var table = document.getElementById("form1:table1");
                                        table.ABMCalculoDeCostosFinales();
                                    }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMPerdidasProduccion.table1}" clearSortButton="true" id="table1"
                                    paginateButton="true" paginationControls="true" sortPanelToggleButton="true" title="Pérdidas en Producción" width="647">
                                    <webuijsf:tableRowGroup binding="#{ABMPerdidasProduccion.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMPerdidasProduccion.selectedState}"
                                        sourceData="#{ABMPerdidasProduccion.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" id="tableColumn5" spacerColumn="true" width="30">
                                            <webuijsf:radioButton id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Orden Trabajo" id="tableColumn2" width="117">
                                            <webuijsf:staticText id="staticText2" text="12345678"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Responsable" id="tableColumn3" width="425">
                                            <webuijsf:staticText id="staticText3" text="Juanitos Perez"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha" id="tableColumn11">
                                            <webuijsf:staticText id="staticText8" text="01/01/2010"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMPerdidasProduccion.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMPerdidasProduccion.addButton_action}" binding="#{ABMPerdidasProduccion.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMPerdidasProduccion.updateButton_action}"
                                        binding="#{ABMPerdidasProduccion.updateButton}" id="updateButton" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMPerdidasProduccion.deleteButton_action}"
                                        binding="#{ABMPerdidasProduccion.deleteButton}" id="deleteButton" text="Eliminar"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMPerdidasProduccion.addUpdatePanel}" columns="1" id="addUpdatePanel" style="height: 528px">
                                    <h:panelGrid columns="4" id="panelGridCabeceraCompra" style="height: 20px; text-align: left" width="455">
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            text="Responsable" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField columns="10" id="textField3" required="true"/>
                                            <webuijsf:textField binding="#{ABMPerdidasProduccion.userNameField}" columns="50" id="userNameField" valueChangeListenerExpression="#{ABMPerdidasProduccion.userNameField_processValueChange}"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="lblFecha" labelLevel="3" text="Fecha"/>
                                        <webuijsf:calendar columns="15" dateFormatPattern="dd/MM/yyyy" id="cal1"/>
                                    </h:panelGrid>
                                    <!-- Panel de Orden de Trabajo -->
                                    <h:panelGrid columns="2" id="panelDetOT" style="height: 70px; text-align: left" width="455">
                                        <webuijsf:label id="lblNroOT" text="Nro. Orden Trabajo"/>
                                        <webuijsf:textField id="txtNroOT"/>
                                        <webuijsf:label id="lblDescProducto" text="Descripción del Producto"/>
                                        <webuijsf:textArea columns="90" id="txtDescProducto" rows="6"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel1"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 500px; text-align: right; vertical-align: middle" width="182">
                                        <webuijsf:button actionExpression="#{ABMPerdidasProduccion.cancelButton_action}"
                                            binding="#{ABMPerdidasProduccion.cancelButton}" id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMPerdidasProduccion.addRecordButton_action}"
                                            binding="#{ABMPerdidasProduccion.addRecordButton}" id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMPerdidasProduccion.updateRecordButton_action}"
                                            binding="#{ABMPerdidasProduccion.updateRecordButton}" id="updateRecordButton" rendered="false"
                                            style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle"/>
                                        <h:panelGrid columns="7" id="gridPanel3" style="height: 48px" width="695">
                                            <webuijsf:hyperlink id="hyperlink2" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                                target="popup" text="Producto" url="/faces/popupproductos.jsp"/>
                                            <webuijsf:textField columns="45" id="textField1"/>
                                            <webuijsf:label id="label1" text="Cantidad"/>
                                            <webuijsf:textField columns="13" id="txtCantidad"/>
                                            <webuijsf:button id="button1" mini="true" text="Agregar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="table2" width="680">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{ABMPerdidasProduccion.defaultTableDataProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Producto" id="tableColumn1" width="89">
                                                    <webuijsf:staticText id="staticText1" text="12345"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Descripción" id="tableColumn4" width="190">
                                                    <webuijsf:staticText id="staticText4" text="Tinta AG 2134"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="U. Medida" id="tableColumn6" width="79">
                                                    <webuijsf:staticText id="staticText5" text="Unidad"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Cantidad" id="tableColumn7" width="90">
                                                    <webuijsf:staticText id="staticText6" text="355"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Observación" id="tableColumn8" width="192">
                                                    <webuijsf:staticText id="staticText7" text="Envase Roto"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn10" width="40">
                                                    <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn9">
                                                    <webuijsf:imageHyperlink id="imageHyperlink1" imageURL="/resources/img/delete.png" text=""/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
