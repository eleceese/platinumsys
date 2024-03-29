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
                            <h:panelGrid binding="#{ABMPedidoCliente.mainContainer}" id="mainContainer"
                                style="height: 96px; left: 288px; top: 216px; position: absolute" width="768">
                                <h:panelGrid binding="#{ABMPedidoCliente.gridPanelBuscar}" columns="3" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura">
                                        <webuijsf:label id="lblNroPedido" text="Nro. Pedido"/>
                                        <webuijsf:textField binding="#{ABMPedidoCliente.uiFilTxtNroFactura}" id="uiFilTxtNroFactura"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelCliente">
                                        <webuijsf:label id="lblCliente" text="Cliente"/>
                                        <webuijsf:textField binding="#{ABMPedidoCliente.uiFilTxtCliente}" columns="35" id="uiFilTxtCliente"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Fecha Pedido"/>
                                        <webuijsf:calendar binding="#{ABMPedidoCliente.uiFilCalFechaPedido}" columns="15" id="uiFilCalFechaPedido"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMPedidoCliente.gridPanelBtnBuscar}" columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                    <webuijsf:button actionExpression="#{ABMPedidoCliente.uiBtnBuscar_action}" binding="#{ABMPedidoCliente.uiBtnBuscar}"
                                        id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMPedidoCliente.uiBtnTodos_action}" binding="#{ABMPedidoCliente.uiBtnTodos}"
                                        id="uiBtnTodos" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMPedidoCliente.pageAlert1}" rendered="false" style="height: 72px"/>
                                <webuijsf:table augmentTitle="false" binding="#{ABMPedidoCliente.table1}" id="table1" title="Pedidos Clientes" width="743">
                                    <webuijsf:tableRowGroup binding="#{ABMPedidoCliente.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMPedidoCliente.selectedState}" sourceData="#{ABMPedidoCliente.lstCabecera}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMPedidoCliente.tableColumn11}" id="tableColumn11"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMPedidoCliente.radioButton1.id}" width="30">
                                            <webuijsf:radioButton binding="#{ABMPedidoCliente.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMPedidoCliente.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMPedidoCliente.selected}" selectedValue="#{ABMPedidoCliente.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Pedido" id="tableColumn2" width="169">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['codPedido']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cliente" id="tableColumn3">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codCliente'].apellidoCliente}, #{currentRow.value['codCliente'].nombreCliente}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha" id="tableColumn4" width="96">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText4" text="#{currentRow.value['fechaPedido']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn5" width="112">
                                            <webuijsf:staticText converter="#{ABMPedidoCliente.characterConverter1}" id="staticText8" text="#{currentRow.value['estadoPedido']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMPedidoCliente.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMPedidoCliente.addButton_action}" binding="#{ABMPedidoCliente.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMPedidoCliente.updateButton_action}" binding="#{ABMPedidoCliente.updateButton}"
                                        id="updateButton" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMPedidoCliente.deleteButton_action}" binding="#{ABMPedidoCliente.deleteButton}"
                                        id="deleteButton" onClick="javascript:return confirmar()" text="Eliminar"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMPedidoCliente.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid cellpadding="1" columns="3" id="panelGridCabeceraCompra" style="text-align: left" width="743">
                                        <webuijsf:label id="lblNroFac" text="Nro. Pedido"/>
                                        <h:panelGrid cellpadding="2" cellspacing="2" columns="3" id="panelGridCabCompra1" width="335">
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtNroPedido}" id="uiTxtNroPedido" maxLength="20" onFocus="document.getElementById('form1:uiLstTipoComprobante_list').focus(); return false;"/>
                                            <webuijsf:label for="uiLstTipoComprobante" id="lblTipoFactura" text="Tipo"/>
                                            <webuijsf:dropDown binding="#{ABMPedidoCliente.uiLstTipoComprobante}" id="uiLstTipoComprobante"
                                                items="#{SessionBean1.listaTipoComprobanteOption}" width="170px"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra2" style="text-align: right" width="200">
                                            <webuijsf:label for="uiLstEstado" id="lblEstadoFactura" text="Estado"/>
                                            <webuijsf:dropDown binding="#{ABMPedidoCliente.uiLstEstado}" id="uiLstEstado"
                                                items="#{ABMPedidoCliente.uiLstEstadoDefaultOptions.options}"
                                                selected="#{ABMPedidoCliente.uiLstEstadoDefaultOptions.selectedValue}" width="120px"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:uiTxtCodCliente_field', 'form1:uiTxtNombreCliente_field')"
                                            target="popup" text="Cliente" url="/faces/popup/popupCliente.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtCodCliente}" columns="10" id="uiTxtCodCliente" maxLength="15"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtNombreCliente}" columns="50" id="uiTxtNombreCliente"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra3" style="text-align: right" width="200">
                                            <webuijsf:label id="lblSubTotal" text="SUB-TOTAL"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtSubTotal}" columns="20" id="uiTxtSubTotal"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="lblFecha" text="Fecha"/>
                                        <webuijsf:calendar binding="#{ABMPedidoCliente.uiCalFecha}" columns="15" dateFormatPattern="dd/MM/yyyy" id="uiCalFecha" style="margin-left: -9px"/>
                                        <h:panelGrid columns="2" id="panelGridCabCompra4" style="text-align: right" width="200">
                                            <webuijsf:label id="lblTotalIva" text="TOTAL IVA"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtTotalIva}" columns="20" id="uiTxtTotalIva"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="gridPanelDescuento1" style="height: 24px; width: 96px">
                                            <webuijsf:label id="label1" text="Porc. Descuento"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="3" id="gridPanelDescuento2" style="height: 24px" width="383">
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtPorcDescuento}" columns="7" id="uiTxtPorcDescuento" onChange="calcularMonto7('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field', 'form1:uiTxtPorcDescuento_field', 'form1:uiTxtMontoDescuento_field' )"/>
                                            <webuijsf:label id="label2" text="Monto Descuento"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtMontoDescuento}" id="uiTxtMontoDescuento"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra5" style="text-align: right" width="200">
                                            <webuijsf:label id="lblTotal" text="TOTAL"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtTotal}" columns="20" id="uiTxtTotal"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel1"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 540px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button actionExpression="#{ABMPedidoCliente.uiBtnGuardarNuevo_action}"
                                            binding="#{ABMPedidoCliente.uiBtnGuardarNuevo}" id="uiBtnGuardarNuevo" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMPedidoCliente.uiBtnGuardarEditar_action}"
                                            binding="#{ABMPedidoCliente.uiBtnGuardarEditar}" id="uiBtnGuardarEditar" rendered="false" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMPedidoCliente.uiBtnCancelar_action}" binding="#{ABMPedidoCliente.uiBtnCancelar}"
                                            id="uiBtnCancelar" style="font-size: 14px" text="Cancelar"/>
                                    </h:panelGrid>
                                    <webuijsf:messageGroup id="messageGroup1" style="width: 719px"/>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Pedido"/>
                                        <h:panelGrid columns="7" id="gridPanelDetLin1" style="height: 24px" width="743">
                                            <webuijsf:hyperlink id="hyperlink2"
                                                onClick="doPopup('form1:uiTxtCodProducto_field', 'form1:uiTxtDescProducto_field', 'form1:uiTxtPrecioUnitario_field')"
                                                target="popup" text="Producto" url="/faces/popup/popupProductoVenta.jsp"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtCodProducto}" columns="10" id="uiTxtCodProducto"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtDescProducto}" columns="30" id="uiTxtDescProducto" onFocus="document.getElementById('form1:uiLstUnidadMedida_list').focus(); return false;"/>
                                            <webuijsf:label id="lblPrecio" text="Precio Unitario: "/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtPrecioUnitario}" columns="15" id="uiTxtPrecioUnitario"
                                                onChange="calcularMonto7('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field', 'form1:uiTxtPorcDescuento_field', 'form1:uiTxtMontoDescuento_field' )"
                                                onFocus="document.getElementById('form1:uiLstUnidadMedida_list').focus(); return false;" style="margin-left: -20px; text-align: left"/>
                                            <webuijsf:label id="lblUnidadMedida" text="Unidad Medida"/>
                                            <webuijsf:dropDown binding="#{ABMPedidoCliente.uiLstUnidadMedida}" id="uiLstUnidadMedida"
                                                items="#{SessionBean1.listaUnidadMedidasOp}"
                                                onClick="document.getElementById('form1:uiTxtPrecioUnitario_field').focus(); return false;"
                                                onFocus="document.getElementById('form1:uiTxtPrecioUnitario_field').focus(); return false;" width="110"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="10" id="gridPanelDetLin2" style="height: 24px" width="719">
                                            <webuijsf:label id="lblCantida" text="Cantidad"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtCantidad}" columns="10" id="uiTxtCantidad"
                                                onChange="calcularMonto7('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field', 'form1:uiTxtPorcDescuento_field', 'form1:uiTxtMontoDescuento_field' )" style="text-align: right"/>
                                            <webuijsf:label id="lblPorcIVA" text="Tipo de Impuesto"/>
                                            <webuijsf:dropDown binding="#{ABMPedidoCliente.uiLstIva}" id="uiLstIva"
                                                items="#{ABMPedidoCliente.uiLstIvaDefaultOptions.options}"
                                                onChange="calcularMonto7('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field', 'form1:uiTxtPorcDescuento_field', 'form1:uiTxtMontoDescuento_field' )"
                                                onFocus="document.getElementById('form1:uiTxtMontoIva').focus(); return false;"
                                                selected="#{ABMPedidoCliente.uiLstIvaDefaultOptions.selectedValue}" width="70"/>
                                            <webuijsf:label id="lblMontoIva" text="Monto IVA"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtMontoIva}" columns="12" id="uiTxtMontoIva"
                                                onFocus="document.getElementById('form1:uiBtnAgregarDet').focus(); return false;" style="text-align: right"/>
                                            <webuijsf:label id="lblMontoTotal" text="Monto Total"/>
                                            <webuijsf:textField binding="#{ABMPedidoCliente.uiTxtMontoTotal}" columns="15" id="uiTxtMontoTotal"
                                                onFocus="document.getElementById('form1:uiBtnAgregarDet').focus(); return false;" style="text-align: right"/>
                                            <webuijsf:button actionExpression="#{ABMPedidoCliente.uiBtnAgregarDet_action}" id="uiBtnAgregarDet" text="Agregar"/>
                                            <webuijsf:button actionExpression="#{ABMPedidoCliente.uiBtnCancelarDetalle_action}" id="uiBtnCancelarDetalle" text="Cancelar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="tableDetalle" title="Detalle" width="720">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="5" sourceData="#{ABMPedidoCliente.lstDetalle}" sourceVar="currentRow">
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
                                                    <webuijsf:staticText id="staticText6" text="#{currentRow.value['cantidadPedida']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="IVA %" id="tableColumn71">
                                                    <webuijsf:staticText id="staticText6Porc" text="#{currentRow.value['porcIva']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Monto IVA" id="tableColumn8">
                                                    <webuijsf:staticText id="staticText7" text="#{currentRow.value['montoIva']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Total" id="tableColumn9">
                                                    <webuijsf:staticText id="staticText9" text="#{currentRow.value['total']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumnEditarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMPedidoCliente.updateDetAction}" id="uilnkEditarDetalle"
                                                        imageURL="/resources/img/edit_16x16.gif" text="">
                                                        <f:setPropertyActionListener target="#{ABMPedidoCliente.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumnEliminarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMPedidoCliente.deleteDetAction}" id="uilnkEliminarDetalle"
                                                        imageURL="/resources/img/delete.png" text="">
                                                        <f:setPropertyActionListener target="#{ABMPedidoCliente.itemDet}" value="#{currentRow.tableRow.rowId}"/>
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
