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
                            <h:panelGrid binding="#{ABMPedidoCliente.mainContainer}" id="mainContainer" style="height: 96px; left: 288px; top: 216px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMPedidoCliente.gridPanelBuscar}" columns="3" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura">
                                        <webuijsf:label id="lblNroProveedor" text="Nro. Pedido"/>
                                        <webuijsf:textField id="txtNroFactura"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelProveedor1">
                                        <webuijsf:label id="lblProveedor" text="Cliente"/>
                                        <webuijsf:textField binding="#{ABMPedidoCliente.userNameFiltro}" columns="30" id="txtProveedor"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Producto"/>
                                        <webuijsf:textField binding="#{ABMPedidoCliente.emailAddressFiltro}" columns="30" id="emailAddressFiltro"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelButtonBuscar">
                                        <webuijsf:button binding="#{ABMPedidoCliente.buscarButton}" id="buscarButton" text="Buscar"/>
                                        <webuijsf:button binding="#{ABMPedidoCliente.todosButton}" id="todosButton" text="Todos"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMPedidoCliente.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                    function ABMReciboCobro() {
                                        var table = document.getElementById("form1:table1");
                                        table.ABMReciboCobro();
                                    }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMPedidoCliente.table1}" clearSortButton="true" id="table1"
                                    paginateButton="true" paginationControls="true" sortPanelToggleButton="true" title="Pedidos Cliente" width="671">
                                    <webuijsf:tableRowGroup binding="#{ABMPedidoCliente.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMPedidoCliente.selectedState}"
                                        sourceData="#{ABMPedidoCliente.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" id="tableColumn5" spacerColumn="true" width="30">
                                            <webuijsf:radioButton id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Pedido" id="tableColumn2" width="75">
                                            <webuijsf:staticText id="staticText2" text="001-001-12345678"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cliente" id="tableColumn3" width="425">
                                            <webuijsf:staticText id="staticText3" text="Serigrafix S.A."/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha" id="tableColumn11">
                                            <webuijsf:staticText id="staticText8" text="01/01/2010"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn4">
                                            <webuijsf:staticText id="staticText4" text="Entregado"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMPedidoCliente.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMPedidoCliente.addButton_action}" binding="#{ABMPedidoCliente.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMPedidoCliente.updateButton_action}" binding="#{ABMPedidoCliente.updateButton}"
                                        id="updateButton" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMPedidoCliente.deleteButton_action}" binding="#{ABMPedidoCliente.deleteButton}"
                                        id="deleteButton" text="Eliminar"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMPedidoCliente.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid columns="3" id="panelGridCabeceraCompra" style="height: 96px; text-align: left">
                                        <webuijsf:label id="lblNroFac" text="Nro. Pedido"/>
                                        <h:panelGrid columns="3" id="panelGridCabCompra1" width="335">
                                            <webuijsf:textField columns="10" id="txtNroFac"/>
                                            <webuijsf:label id="lblFecha" labelLevel="3" text="Fecha"/>
                                            <webuijsf:calendar columns="17" dateFormatPattern="dd/MM/yyyy" id="cal1"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra2" style="text-align: right" width="205">
                                            <webuijsf:label for="dropDown2" id="lblEstadoFactura" text="Estado"/>
                                            <webuijsf:dropDown id="dropDown2" items="#{ABMPedidoCliente.dropDown2DefaultOptions.options}"
                                                selected="#{ABMPedidoCliente.dropDown2DefaultOptions.selectedValue}" width="126px"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            text="Cliente" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField columns="10" id="textField3" required="true"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.userNameField}" columns="50" id="userNameField" valueChangeListenerExpression="#{ABMPedidoCliente.userNameField_processValueChange}"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra3" style="text-align: right" width="205">
                                            <webuijsf:label id="lblSubTotal" text="Total"/>
                                            <webuijsf:textField columns="20" id="txtTotal"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="lnkFacturaCliente"
                                            onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')" text="Vendedor" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelEmpleado" width="383">
                                            <webuijsf:textField columns="10" id="txtCodEmpleado" text="1233"/>
                                            <webuijsf:textField columns="50" id="txtNomEmpleado" text="Juan Perez"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel1"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 500px; text-align: right; vertical-align: middle" width="182">
                                        <webuijsf:button actionExpression="#{ABMPedidoCliente.cancelButton_action}" binding="#{ABMPedidoCliente.cancelButton}"
                                            id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMPedidoCliente.addRecordButton_action}"
                                            binding="#{ABMPedidoCliente.addRecordButton}" id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMPedidoCliente.updateRecordButton_action}"
                                            binding="#{ABMPedidoCliente.updateRecordButton}" id="updateRecordButton" rendered="false" style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Pedido"/>
                                        <h:panelGrid columns="7" id="gridPanel3" style="height: 48px" width="695">
                                            <webuijsf:hyperlink id="hyperlink2" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                                target="popup" text="Producto" url="/faces/popupproductos.jsp"/>
                                            <webuijsf:textField columns="35" id="textField1"/>
                                            <webuijsf:label id="lblPrecio" text="Precio"/>
                                            <webuijsf:textField disabled="true" id="txtPrecio"/>
                                            <webuijsf:label id="label1" text="Cantidad"/>
                                            <webuijsf:textField columns="13" id="txtCantidad"/>
                                            <webuijsf:button id="button1" text="Agregar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="table2" width="695">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{ABMPedidoCliente.defaultTableDataProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Producto" id="tableColumn1">
                                                    <webuijsf:staticText id="staticText1" text="123"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Producto" id="tableColumn6">
                                                    <webuijsf:staticText id="staticText5" text="Cuaderno 50 Hojas"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="U. Medida" id="tableColumn7">
                                                    <webuijsf:staticText id="staticText6" text="Unidad"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Cant. Pedido" id="tableColumn8" width="57">
                                                    <webuijsf:staticText id="staticText7" text="980"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Cant. Entregada" id="tableColumn9">
                                                    <webuijsf:staticText id="staticText9" text="980"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Precio Unitario" id="tableColumn10">
                                                    <webuijsf:staticText id="staticText10" text="10.000"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Total" id="tableColumn12">
                                                    <webuijsf:staticText id="staticText11" text="9.800.000"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn14" width="40">
                                                    <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn13" width="40">
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
