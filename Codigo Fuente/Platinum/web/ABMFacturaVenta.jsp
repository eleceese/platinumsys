<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Usuario
    Created on : 20-ago-2009, 19:25:55
    Author     : MartinJara
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
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
                        <div>
                            <h:panelGrid binding="#{ABMFacturaVenta.mainContainer}" id="mainContainer"
                                style="height: 96px; left: 288px; top: 216px; position: absolute" width="768">
                                <h:panelGrid binding="#{ABMFacturaVenta.gridPanelBuscar}" columns="3" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura">
                                        <webuijsf:label id="lblNroPedido" text="Nro. Factura"/>
                                        <webuijsf:textField binding="#{ABMFacturaVenta.uiFilTxtNroFactura}" id="uiFilTxtNroFactura"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelCliente">
                                        <webuijsf:label id="lblCliente" text="Cliente"/>
                                        <webuijsf:textField binding="#{ABMFacturaVenta.uiFilTxtCliente}" columns="35" id="uiFilTxtCliente"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Fecha Factura"/>
                                        <webuijsf:calendar binding="#{ABMFacturaVenta.uiFilCalFechaPedido}" columns="15" id="uiFilCalFechaPedido" validatorExpression="#{ABMFacturaVenta.uiFilCalFechaPedido_validate}"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMFacturaVenta.gridPanelBtnBuscar}" columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                    <webuijsf:button actionExpression="#{ABMFacturaVenta.uiBtnBuscar_action}" binding="#{ABMFacturaVenta.uiBtnBuscar}"
                                        id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMFacturaVenta.uiBtnTodos_action}" binding="#{ABMFacturaVenta.uiBtnTodos}"
                                        id="uiBtnTodos" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMFacturaVenta.pageAlert1}" rendered="false" style="height: 72px"/>
                                <webuijsf:table augmentTitle="false" binding="#{ABMFacturaVenta.table1}" id="table1" title="Facturas Clientes" width="743">
                                    <webuijsf:tableRowGroup binding="#{ABMFacturaVenta.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMFacturaVenta.selectedState}" sourceData="#{ABMFacturaVenta.lstCabecera}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMFacturaVenta.tableColumn11}" id="tableColumn11"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMFacturaVenta.radioButton1.id}" width="30">
                                            <webuijsf:radioButton binding="#{ABMFacturaVenta.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMFacturaVenta.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMFacturaVenta.selected}" selectedValue="#{ABMFacturaVenta.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Tipo" id="tableColumnTipoComprobante" width="96">
                                            <webuijsf:staticText id="staticTextTipo" text="#{currentRow.value['tipoFactura'].descTipo}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Factura" id="tableColumn2" width="130">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['establecimiento']} - #{currentRow.value['bocaExpendio']} - #{currentRow.value['numeroFactura']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cliente" id="tableColumn3">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codCliente'].apellidoCliente}, #{currentRow.value['codCliente'].nombreCliente}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Emisión" id="tableColumn4" width="96">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText4" text="#{currentRow.value['fechaFactura']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Vencimiento" id="tableColumnVencimiento" width="96">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText4" text="#{currentRow.value['fechaVencimiento']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn5" width="112">
                                            <webuijsf:staticText converter="#{ABMFacturaVenta.characterConverter1}" id="staticText8" text="#{currentRow.value['estadoFactura']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMFacturaVenta.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMFacturaVenta.addButton_action}" binding="#{ABMFacturaVenta.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMFacturaVenta.updateButton_action}" binding="#{ABMFacturaVenta.updateButton}"
                                        id="updateButton" text="Ver Detalle"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMFacturaVenta.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid cellpadding="1" columns="3" id="panelGridCabeceraCompra" style="text-align: left" width="743">
                                        <webuijsf:label id="lblNroFac" text="Nro. Factura"/>
                                        <h:panelGrid cellpadding="2" cellspacing="2" columns="3" id="panelGridCabCompra1" width="335">
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtNroFactura}" id="uiTxtNroFactura" maxLength="20" onClick="document.getElementById('form1:uiLstTipoComprobante_list').focus(); return false;"/>
                                            <webuijsf:label for="uiLstTipoComprobante" id="lblTipoFactura" text="Tipo"/>
                                            <webuijsf:dropDown binding="#{ABMFacturaVenta.uiLstTipoComprobante}" id="uiLstTipoComprobante"
                                                items="#{SessionBean1.listaTipoComprobanteOption}" width="170px"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra2" style="text-align: right" width="200">
                                            <webuijsf:label for="uiLstEstado" id="lblEstadoFactura" text="Estado"/>
                                            <webuijsf:dropDown binding="#{ABMFacturaVenta.uiLstEstado}" id="uiLstEstado"
                                                items="#{ABMFacturaVenta.uiLstEstadoDefaultOptions.options}"
                                                selected="#{ABMFacturaVenta.uiLstEstadoDefaultOptions.selectedValue}" width="120px"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:uiTxtCodCliente_field', 'form1:uiTxtNombreCliente_field')"
                                            target="popup" text="Cliente" url="/faces/popup/popupCliente.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtCodCliente}" columns="10" id="uiTxtCodCliente" maxLength="15"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtNombreCliente}" columns="50" id="uiTxtNombreCliente"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra3" style="text-align: right" width="200">
                                            <webuijsf:label id="lblSubTotal" text="SUB-TOTAL"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtSubTotal}" columns="20" id="uiTxtSubTotal"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="lblFecha" text="Fecha"/>
                                        <webuijsf:calendar binding="#{ABMFacturaVenta.uiCalFecha}" columns="15" dateFormatPattern="dd/MM/yyyy" id="uiCalFecha" style="margin-left: -9px"/>
                                        <h:panelGrid columns="2" id="panelGridCabCompra4" style="text-align: right" width="200">
                                            <webuijsf:label id="lblTotalIva" text="TOTAL IVA"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtTotalIva}" columns="20" id="uiTxtTotalIva"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="gridPanelDescuento1" style="height: 24px; width: 96px">
                                            <webuijsf:label id="label1" text="Porc. Descuento"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="3" id="gridPanelDescuento2" style="height: 24px" width="383">
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtPorcDescuento}" columns="7" id="uiTxtPorcDescuento" onBlur="calcularMonto('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field', 'form1:uiTxtPorcDescuento_field', 'form1:uiTxtMontoDescuento_field' )"/>
                                            <webuijsf:label id="label2" text="Monto Descuento"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtMontoDescuento}" id="uiTxtMontoDescuento"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra5" style="text-align: right" width="200">
                                            <webuijsf:label id="lblTotal" text="TOTAL"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtTotal}" columns="20" id="uiTxtTotal"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="lnkPedido" onClick="doPopup('form1:uiTxtNroPedido_field')" target="popup" text="Numero Pedido" url="/faces/popup/popupPedidoVenta.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelPedido" width="191">
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtNroPedido}" columns="15" id="uiTxtNroPedido" maxLength="15" onFocus="document.getElementById('form1:uiBtnCargarPedido').focus(); return false;"/>
                                            <webuijsf:button actionExpression="#{ABMFacturaVenta.uiBtnCargarPedido_action}"
                                                binding="#{ABMFacturaVenta.uiBtnCargarPedido}" id="uiBtnCargarPedido" text="Cargar Pedido"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel1"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 540px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button actionExpression="#{ABMFacturaVenta.uiBtnGuardarNuevo_action}"
                                            binding="#{ABMFacturaVenta.uiBtnGuardarNuevo}" id="uiBtnGuardarNuevo" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMFacturaVenta.uiBtnGuardarEditar_action}"
                                            binding="#{ABMFacturaVenta.uiBtnGuardarEditar}" id="uiBtnGuardarEditar" rendered="false" style="font-size: 14px" text="Anular"/>
                                        <webuijsf:button actionExpression="#{ABMFacturaVenta.uiBtnCancelar_action}" binding="#{ABMFacturaVenta.uiBtnCancelar}"
                                            id="uiBtnCancelar" style="font-size: 14px" text="Cancelar"/>
                                    </h:panelGrid>
                                    <webuijsf:messageGroup id="messageGroup1" showGlobalOnly="true" style="width: 719px"/>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Factura"/>
                                        <h:panelGrid binding="#{ABMFacturaVenta.gridPanelDetLin1}" columns="7" id="gridPanelDetLin1" style="height: 24px" width="743">
                                            <webuijsf:hyperlink id="hyperlink2"
                                                onClick="doPopup('form1:uiTxtCodProducto_field', 'form1:uiTxtDescProducto_field', 'form1:uiTxtPrecioUnitario_field')"
                                                target="popup" text="Producto" url="/faces/popup/popupProductoVenta.jsp"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtCodProducto}" columns="10" id="uiTxtCodProducto"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtDescProducto}" columns="30" id="uiTxtDescProducto" onFocus="document.getElementById('form1:uiLstUnidadMedida_list').focus(); return false;"/>
                                            <webuijsf:label id="lblPrecio" text="Precio"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtPrecioUnitario}" columns="15" id="uiTxtPrecioUnitario"
                                                onFocus="document.getElementById('form1:uiLstUnidadMedida_list').focus(); return false;" style="margin-left: -20px; text-align: left"/>
                                            <webuijsf:label id="lblUnidadMedida" text="Unidad Medida"/>
                                            <webuijsf:dropDown binding="#{ABMFacturaVenta.uiLstUnidadMedida}" id="uiLstUnidadMedida"
                                                items="#{SessionBean1.listaUnidadMedidasOp}"
                                                onClick="document.getElementById('form1:uiTxtCantidad_field').focus(); return false;"
                                                onFocus="document.getElementById('form1:uiTxtCantidad_field').focus(); return false;" width="110"/>
                                        </h:panelGrid>
                                        <h:panelGrid binding="#{ABMFacturaVenta.gridPanelDetLin2}" columns="10" id="gridPanelDetLin2" style="height: 24px" width="719">
                                            <webuijsf:label id="lblCantida" text="Cantidad"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtCantidad}" columns="10" id="uiTxtCantidad"
                                                onBlur="calcularMonto('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field', 'form1:uiTxtPorcDescuento_field', 'form1:uiTxtMontoDescuento_field' )" style="text-align: right"/>
                                            <webuijsf:label id="lblPorcIVA" text="Tipo de Impuesto"/>
                                            <webuijsf:dropDown binding="#{ABMFacturaVenta.uiLstIva}" id="uiLstIva"
                                                items="#{ABMFacturaVenta.uiLstIvaDefaultOptions.options}"
                                                onChange="calcularMonto('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field', 'form1:uiTxtPorcDescuento_field', 'form1:uiTxtMontoDescuento_field' )"
                                                selected="#{ABMFacturaVenta.uiLstIvaDefaultOptions.selectedValue}" width="70"/>
                                            <webuijsf:label id="lblMontoIva" text="Monto IVA"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtMontoIva}" columns="12" id="uiTxtMontoIva"
                                                onFocus="document.getElementById('form1:uiBtnAgregarDet').focus(); return false;" style="text-align: right"/>
                                            <webuijsf:label id="lblMontoTotal" text="Monto Total"/>
                                            <webuijsf:textField binding="#{ABMFacturaVenta.uiTxtMontoTotal}" columns="15" id="uiTxtMontoTotal"
                                                onFocus="document.getElementById('form1:uiBtnAgregarDet').focus(); return false;" style="text-align: right"/>
                                            <webuijsf:button actionExpression="#{ABMFacturaVenta.uiBtnAgregarDet_action}" id="uiBtnAgregarDet" text="Agregar"/>
                                            <webuijsf:button actionExpression="#{ABMFacturaVenta.uiBtnCancelarDetalle_action}" id="uiBtnCancelarDetalle" text="Cancelar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" binding="#{ABMFacturaVenta.tableDetalle}" id="tableDetalle" title="Detalle" width="720">
                                            <webuijsf:tableRowGroup binding="#{ABMFacturaVenta.tableRowGroup2}" id="tableRowGroup2" rows="5"
                                                sourceData="#{ABMFacturaVenta.lstDetalle}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Producto" id="tableColumn1">
                                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProducto'].codProducto}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Producto" id="tableColumnDescProducto">
                                                    <webuijsf:staticText id="staticTextDescProducto" text="#{currentRow.value['codProducto'].descripcion}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Precio Unit." id="tableColumn6">
                                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['precioUnitario']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cantidad" id="tableColumn7">
                                                    <webuijsf:staticText id="staticText6" text="#{currentRow.value['cantidad']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="IVA %" id="tableColumn71">
                                                    <webuijsf:staticText id="staticText6Porc" text="#{currentRow.value['porcentajeIva']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Monto IVA" id="tableColumn8">
                                                    <webuijsf:staticText id="staticText7" text="#{currentRow.value['totalIva']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Total" id="tableColumn9">
                                                    <webuijsf:staticText id="staticText9" text="#{currentRow.value['subTotal']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" binding="#{ABMFacturaVenta.tableColumnEditarDet}" id="tableColumnEditarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMFacturaVenta.updateDetAction}" id="uilnkEditarDetalle"
                                                        imageURL="/resources/img/edit_16x16.gif" text="">
                                                        <f:setPropertyActionListener target="#{ABMFacturaVenta.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" binding="#{ABMFacturaVenta.tableColumnEliminarDet}"
                                                    id="tableColumnEliminarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMFacturaVenta.deleteDetAction}" id="uilnkEliminarDetalle"
                                                        imageURL="/resources/img/delete.png" text="">
                                                        <f:setPropertyActionListener target="#{ABMFacturaVenta.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
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
