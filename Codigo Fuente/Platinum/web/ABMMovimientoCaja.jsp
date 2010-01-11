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
                            <h:panelGrid binding="#{ABMMovimientoCaja.mainContainer}" id="mainContainer"
                                style="height: 96px; left: 288px; top: 216px; position: absolute" width="792">
                                <h:panelGrid binding="#{ABMMovimientoCaja.gridPanelBuscar}" columns="2" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura" width="215">
                                        <webuijsf:label id="lblNroProveedor" text="Nro. Recibo"/>
                                        <webuijsf:textField id="txtNroFactura"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelProveedor1">
                                        <webuijsf:label id="lblProveedor" text="Cliente"/>
                                        <webuijsf:textField columns="50" id="txtCliente"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelButtonBuscar">
                                        <webuijsf:button binding="#{ABMMovimientoCaja.buscarButton}" id="buscarButton" text="Buscar"/>
                                        <webuijsf:button binding="#{ABMMovimientoCaja.todosButton}" id="todosButton" text="Todos"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMMovimientoCaja.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                    function ABMReciboCobranza() {
                                        var table = document.getElementById("form1:table1");
                                        table.ABMReciboCobranza();
                                    }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMMovimientoCaja.table1}" clearSortButton="true" id="table1"
                                    paginateButton="true" paginationControls="true" sortPanelToggleButton="true" title="Movimientos de caja" width="671">
                                    <webuijsf:tableRowGroup binding="#{ABMMovimientoCaja.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMMovimientoCaja.selectedState}"
                                        sourceData="#{ABMMovimientoCaja.defaultTableDataProvider}" sourceVar="currentRow">
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
                                <h:panelGrid binding="#{ABMMovimientoCaja.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMMovimientoCaja.addButton_action}" binding="#{ABMMovimientoCaja.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMMovimientoCaja.updateButton_action}" binding="#{ABMMovimientoCaja.updateButton}"
                                        id="updateButton" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMMovimientoCaja.deleteButton_action}" binding="#{ABMMovimientoCaja.deleteButton}"
                                        id="deleteButton" text="Eliminar"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMMovimientoCaja.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid columns="3" id="panelGridCabeceraCompra" style="height: 96px; text-align: left" width="767">
                                        <webuijsf:hyperlink id="lnkNroRecibo" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            text="Nro. Recibo" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="3" id="panelGridCabCompra1" width="335">
                                            <webuijsf:textField columns="10" id="txtNroFac"/>
                                            <webuijsf:label id="lblFecha" labelLevel="3" text="Fecha"/>
                                            <webuijsf:calendar columns="17" dateFormatPattern="dd/MM/yyyy" id="cal1"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra2" style="text-align: right" width="205">
                                            <webuijsf:label for="dropDown2" id="lblEstadoFactura" text="Estado"/>
                                            <webuijsf:dropDown id="dropDown2" items="#{ABMMovimientoCaja.dropDown2DefaultOptions.options}"
                                                selected="#{ABMMovimientoCaja.dropDown2DefaultOptions.selectedValue}"
                                                valueChangeListenerExpression="#{ABMMovimientoCaja.dropDown2_processValueChange}" width="126px"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            text="Cliente" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField columns="10" id="textField3" required="true"/>
                                            <webuijsf:textField binding="#{ABMMovimientoCaja.userNameField}" columns="50" id="userNameField" valueChangeListenerExpression="#{ABMMovimientoCaja.userNameField_processValueChange}"/>
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
                                        <h:panelGrid columns="2" id="panelGridCabCompra1" style="text-align: right" width="205">
                                            <webuijsf:hyperlink id="lnkNroCaja" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                                text="Nro. Caja" url="/faces/popupproductos.jsp"/>
                                            <webuijsf:textField id="txtNroCaja"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelMovCajObservacion">
                                        <webuijsf:textArea columns="57" id="txtObs" label="Observación" rows="5"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel1"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 587px; text-align: right; vertical-align: middle" width="182">
                                        <webuijsf:button actionExpression="#{ABMMovimientoCaja.cancelButton_action}" binding="#{ABMMovimientoCaja.cancelButton}"
                                            id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMMovimientoCaja.addRecordButton_action}"
                                            binding="#{ABMMovimientoCaja.addRecordButton}" id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMMovimientoCaja.updateRecordButton_action}"
                                            binding="#{ABMMovimientoCaja.updateRecordButton}" id="updateRecordButton" rendered="false" style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Forma de Cobro"/>
                                        <h:panelGrid columns="7" id="gridPanel3" style="height: 48px" width="767">
                                            <webuijsf:hyperlink id="hyperlink2" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                                target="popup" text="Forma Cobro" url="/faces/popupproductos.jsp"/>
                                            <webuijsf:textField id="textField1"/>
                                            <webuijsf:label id="lblComprobante" text="Comprobante"/>
                                            <h:panelGrid columns="4" id="panelComprobante" style="border: 1px solid black; text-align: center" title="Comprobante">
                                                <webuijsf:label id="lblSerieComprobante" text="Serie"/>
                                                <webuijsf:textField columns="5" id="txtSerCom"/>
                                                <webuijsf:label id="lblNroComp" text="Nro."/>
                                                <webuijsf:textField columns="15" id="txtNroComp"/>
                                            </h:panelGrid>
                                            <webuijsf:label id="label1" text="Monto"/>
                                            <webuijsf:textField columns="15" id="txtMonto"/>
                                            <webuijsf:button id="button1" text="Agregar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="table2" width="767">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{ABMMovimientoCaja.defaultTableDataProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Forma de Cobro" id="tableColumn1">
                                                    <webuijsf:staticText id="staticText1" text="Cheque Adelantado"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Serie Comprobante" id="tableColumn6" width="107">
                                                    <webuijsf:staticText id="staticText5" text="A"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Nro. Comprobante" id="tableColumn7">
                                                    <webuijsf:staticText id="staticText6" text="123245445332"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Monto" id="tableColumn8">
                                                    <webuijsf:staticText id="staticText7" text="54.000.000"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn10" width="40">
                                                    <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn9" width="40">
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
