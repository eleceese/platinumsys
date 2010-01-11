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
                            <h:panelGrid binding="#{ABMReciboCobro.mainContainer}" id="mainContainer" style="height: 96px; left: 288px; top: 240px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMReciboCobro.gridPanelBuscar}" columns="2" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura" width="215">
                                        <webuijsf:label id="lblNroProveedor" text="Nro. Recibo"/>
                                        <webuijsf:textField id="txtNroFactura"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelProveedor1">
                                        <webuijsf:label id="lblProveedor" text="Cliente"/>
                                        <webuijsf:textField columns="50" id="txtCliente"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelButtonBuscar">
                                        <webuijsf:button binding="#{ABMReciboCobro.buscarButton}" id="buscarButton" text="Buscar"/>
                                        <webuijsf:button binding="#{ABMReciboCobro.todosButton}" id="todosButton" text="Todos"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMReciboCobro.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                    function ABMMovimientoCaja() {
                                        var table = document.getElementById("form1:table1");
                                        table.ABMMovimientoCaja();
                                    }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMReciboCobro.table1}" clearSortButton="true" id="table1" paginateButton="true"
                                    paginationControls="true" sortPanelToggleButton="true" title="Recibo de Dinero" width="671">
                                    <webuijsf:tableRowGroup binding="#{ABMReciboCobro.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMReciboCobro.selectedState}"
                                        sourceData="#{ABMReciboCobro.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" id="tableColumn5" spacerColumn="true" width="30">
                                            <webuijsf:radioButton id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Recibo" id="tableColumn2" width="75">
                                            <webuijsf:staticText id="staticText2" text="001-001-12345678"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cliente" id="tableColumn3" width="425">
                                            <webuijsf:staticText id="staticText3" text="Serigrafix S.A."/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha" id="tableColumn11">
                                            <webuijsf:staticText id="staticText8" text="01/01/2010"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn4">
                                            <webuijsf:staticText id="staticText4" text="Cobrado"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMReciboCobro.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMReciboCobro.addButton_action}" binding="#{ABMReciboCobro.addButton}" id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMReciboCobro.updateButton_action}" binding="#{ABMReciboCobro.updateButton}"
                                        id="updateButton" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMReciboCobro.deleteButton_action}" binding="#{ABMReciboCobro.deleteButton}"
                                        id="deleteButton" text="Eliminar"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMReciboCobro.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid columns="3" id="panelGridCabeceraCompra" style="height: 96px; text-align: left">
                                        <webuijsf:label id="lblNroFac" text="Nro. Recibo"/>
                                        <h:panelGrid columns="3" id="panelGridCabCompra1" width="335">
                                            <webuijsf:textField columns="10" id="txtNroFac"/>
                                            <webuijsf:label id="lblFecha" labelLevel="3" text="Fecha"/>
                                            <webuijsf:calendar columns="17" dateFormatPattern="dd/MM/yyyy" id="cal1"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra2" style="text-align: right" width="205">
                                            <webuijsf:label for="dropDown2" id="lblEstadoFactura" text="Estado"/>
                                            <webuijsf:dropDown id="dropDown2" items="#{ABMReciboCobro.dropDown2DefaultOptions.options}"
                                                selected="#{ABMReciboCobro.dropDown2DefaultOptions.selectedValue}"
                                                valueChangeListenerExpression="#{ABMReciboCobro.dropDown2_processValueChange}" width="126px"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            text="Cliente" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField columns="10" id="textField3" required="true"/>
                                            <webuijsf:textField binding="#{ABMReciboCobro.userNameField}" columns="50" id="userNameField" valueChangeListenerExpression="#{ABMReciboCobro.userNameField_processValueChange}"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra3" style="text-align: right" width="205">
                                            <webuijsf:label id="lblSubTotal" text="Total"/>
                                            <webuijsf:textField columns="20" id="txtTotal"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="lnkFacturaCliente"
                                            onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')" text="Cobrador" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelEmpleado" width="383">
                                            <webuijsf:textField columns="10" id="txtCodEmpleado" text="1233"/>
                                            <webuijsf:textField columns="50" id="txtNomEmpleado" text="Juan Perez"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel1"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 500px; text-align: right; vertical-align: middle" width="182">
                                        <webuijsf:button actionExpression="#{ABMReciboCobro.cancelButton_action}" binding="#{ABMReciboCobro.cancelButton}"
                                            id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMReciboCobro.addRecordButton_action}" binding="#{ABMReciboCobro.addRecordButton}"
                                            id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMReciboCobro.updateRecordButton_action}"
                                            binding="#{ABMReciboCobro.updateRecordButton}" id="updateRecordButton" rendered="false" style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Recibo"/>
                                        <h:panelGrid columns="7" id="gridPanel3" style="height: 48px" width="695">
                                            <webuijsf:hyperlink id="hyperlink2" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                                target="popup" text="Factura" url="/faces/popupproductos.jsp"/>
                                            <webuijsf:textField id="textField1"/>
                                            <webuijsf:label id="lblPrecio" text="Saldo"/>
                                            <webuijsf:textField columns="15" disabled="true" id="txtPrecio"/>
                                            <webuijsf:label id="label1" text="Monto a Pagar"/>
                                            <webuijsf:textField columns="15" id="txtCantidad"/>
                                            <webuijsf:button id="button1" text="Agregar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="table2" width="671">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{ABMReciboCobro.defaultTableDataProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Comprobante" id="tableColumn1">
                                                    <webuijsf:staticText id="staticText1" text="Fac. Credito"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Nro. Comprobante" id="tableColumn6">
                                                    <webuijsf:staticText id="staticText5" text="001-001-12323"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Vencimiento" id="tableColumn7">
                                                    <webuijsf:staticText id="staticText6" text="01/01/2010"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Saldo" id="tableColumn8">
                                                    <webuijsf:staticText id="staticText7" text="1.000.000"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Monto" id="tableColumn9">
                                                    <webuijsf:staticText id="staticText9" text="1.000.000"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn12" width="40">
                                                    <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn10" width="40">
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
