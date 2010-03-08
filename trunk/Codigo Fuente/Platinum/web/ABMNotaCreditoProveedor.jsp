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
                            <h:panelGrid binding="#{ABMNotaCreditoProveedor.mainContainer}" id="mainContainer"
                                style="height: 96px; left: 288px; top: 216px; position: absolute" width="768">
                                <h:panelGrid binding="#{ABMNotaCreditoProveedor.gridPanelBuscar}" columns="3" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura">
                                        <webuijsf:label id="lblNroProveedor" text="Nro. Nota Credito"/>
                                        <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiFilTxtNroFactura}" id="uiFilTxtNroFactura"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelProveedor1">
                                        <webuijsf:label id="lblProveedor" text="Proveedor"/>
                                        <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiFilTxtProveedor}" columns="35" id="uiFilTxtProveedor"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Fecha "/>
                                        <webuijsf:calendar binding="#{ABMNotaCreditoProveedor.uiFilCalFechaFactura}" columns="15" id="uiFilCalFechaFactura"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMNotaCreditoProveedor.gridPanelBtnBuscar}" columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                    <webuijsf:button actionExpression="#{ABMNotaCreditoProveedor.uiBtnBuscar_action}"
                                        binding="#{ABMNotaCreditoProveedor.uiBtnBuscar}" id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMNotaCreditoProveedor.uiBtnTodos_action}"
                                        binding="#{ABMNotaCreditoProveedor.uiBtnTodos}" id="uiBtnTodos" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMNotaCreditoProveedor.pageAlert1}" rendered="false" style="height: 72px"/>
                                <webuijsf:table augmentTitle="false" binding="#{ABMNotaCreditoProveedor.table1}" id="table1" title="Nota Credito Proveedor" width="743">
                                    <webuijsf:tableRowGroup binding="#{ABMNotaCreditoProveedor.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMNotaCreditoProveedor.selectedState}"
                                        sourceData="#{ABMNotaCreditoProveedor.lstCabecera}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMNotaCreditoProveedor.tableColumn11}" id="tableColumn11"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMNotaCreditoProveedor.radioButton1.id}" width="36">
                                            <webuijsf:radioButton binding="#{ABMNotaCreditoProveedor.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMNotaCreditoProveedor.radioButton1.id}" onClick="delSelect='ok'"
                                                selected="#{ABMNotaCreditoProveedor.selected}" selectedValue="#{ABMNotaCreditoProveedor.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Nota Credito" id="tableColumn2" width="169">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['nroNotaCredito']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Proveedor" id="tableColumn3">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProveedor'].nombreProveedor}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha" id="tableColumn4" width="96">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText4" text="#{currentRow.value['fecha']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn5" width="112">
                                            <webuijsf:staticText converter="#{ABMNotaCreditoProveedor.characterConverter1}" id="staticText8" text="#{currentRow.value['estado']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMNotaCreditoProveedor.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMNotaCreditoProveedor.addButton_action}"
                                        binding="#{ABMNotaCreditoProveedor.addButton}" id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMNotaCreditoProveedor.updateButton_action}"
                                        binding="#{ABMNotaCreditoProveedor.updateButton}" id="updateButton" text="Ver Detalle"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMNotaCreditoProveedor.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid cellpadding="1" columns="3" id="panelGridCabeceraCompra" style="text-align: left" width="743">
                                        <webuijsf:label id="lblNroFac" text="Nro. Nota Credito"/>
                                        <h:panelGrid cellpadding="2" cellspacing="2" columns="3" id="panelGridCabCompra1" width="335">
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtNroFac}" id="uiTxtNroFac" maxLength="20"/>
                                            <webuijsf:label for="uiLstTipoComprobante" id="lblTipoFactura" text="Tipo"/>
                                            <webuijsf:dropDown binding="#{ABMNotaCreditoProveedor.uiLstTipoComprobante}" id="uiLstTipoComprobante"
                                                items="#{SessionBean1.listaTipoComprobanteOption}" width="170px"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra2" style="text-align: right" width="200">
                                            <webuijsf:label for="uiLstEstado" id="lblEstadoFactura" text="Estado"/>
                                            <webuijsf:dropDown binding="#{ABMNotaCreditoProveedor.uiLstEstado}" id="uiLstEstado"
                                                items="#{ABMNotaCreditoProveedor.uiLstEstadoDefaultOptions.options}"
                                                selected="#{ABMNotaCreditoProveedor.uiLstEstadoDefaultOptions.selectedValue}" width="120px"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1"
                                            onClick="doPopup('form1:uiTxtCodProveedor_field', 'form1:uiTxtNombreProveedor_field');" target="popup"
                                            text="Proveedor" url="/faces/popup/popupProveedores.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtCodProveedor}" columns="10" id="uiTxtCodProveedor" maxLength="15"/>
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtNombreProveedor}" columns="50" id="uiTxtNombreProveedor" valueChangeListenerExpression="#{ABMNotaCreditoProveedor.uiTxtNombreProveedor_processValueChange}"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra3" style="text-align: right" width="200">
                                            <webuijsf:label id="lblSubTotal" text="SUB-TOTAL"/>
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtSubTotal}" columns="20" id="uiTxtSubTotal"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="lblFecha" text="Fecha"/>
                                        <webuijsf:calendar binding="#{ABMNotaCreditoProveedor.uiCalFecha}" columns="15" dateFormatPattern="dd/MM/yyyy"
                                            id="uiCalFecha" style="margin-left: -9px"/>
                                        <h:panelGrid columns="2" id="panelGridCabCompra4" style="text-align: right" width="200">
                                            <webuijsf:label id="lblTotalIva" text="TOTAL IVA"/>
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtTotalIva}" columns="20" id="uiTxtTotalIva"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="lnkPedido" onClick="doPopup('form1:uiTxtNroFactura_field')" target="popup" text="Factura Compra" url="/faces/popup/popupFacturaCompra.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelFacCompra" width="191">
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtNroFactura}" columns="15" id="uiTxtNroFactura"
                                                maxLength="15" onFocus="document.getElementById('form1:uiBtnCargarFactura').focus(); return false;"/>
                                            <webuijsf:button actionExpression="#{ABMNotaCreditoProveedor.uiBtnCargarFactura_action}" id="uiBtnCargarFactura" text="Cargar Factura"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra5" style="text-align: right" width="200">
                                            <webuijsf:label id="lblTotal" text="TOTAL"/>
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtTotal}" columns="20" id="uiTxtTotal"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel1"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 540px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button actionExpression="#{ABMNotaCreditoProveedor.uiBtnGuardarNuevo_action}"
                                            binding="#{ABMNotaCreditoProveedor.uiBtnGuardarNuevo}" id="uiBtnGuardarNuevo" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMNotaCreditoProveedor.uiBtnGuardarEditar_action}"
                                            binding="#{ABMNotaCreditoProveedor.uiBtnGuardarEditar}" id="uiBtnGuardarEditar" rendered="false"
                                            style="font-size: 14px" text="Anular"/>
                                        <webuijsf:button actionExpression="#{ABMNotaCreditoProveedor.uiBtnCancelar_action}"
                                            binding="#{ABMNotaCreditoProveedor.uiBtnCancelar}" id="uiBtnCancelar" style="font-size: 14px" text="Cancelar"/>
                                    </h:panelGrid>
                                    <webuijsf:messageGroup id="messageGroup1" style="width: 719px"/>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Factura"/>
                                        <h:panelGrid binding="#{ABMNotaCreditoProveedor.gridPanelDetLin1}" columns="7" id="gridPanelDetLin1"
                                            style="height: 24px" width="743">
                                            <webuijsf:hyperlink id="hyperlink2"
                                                onClick="doPopup('form1:uiTxtCodProducto_field', 'form1:uiTxtDescProducto_field')" target="popup"
                                                text="Producto" url="/faces/popup/popupProductos.jsp"/>
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtCodProducto}" columns="10" id="uiTxtCodProducto"/>
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtDescProducto}" columns="30" id="uiTxtDescProducto" onFocus="document.getElementById('form1:uiTxtNroSolicitud_field').focus(); return false;"/>
                                            <webuijsf:label id="lblUnidadMedida" text="Unidad Medida"/>
                                            <webuijsf:dropDown binding="#{ABMNotaCreditoProveedor.uiLstUnidadMedida}" id="uiLstUnidadMedida"
                                                items="#{SessionBean1.listaUnidadMedidasOp}"
                                                onClick="document.getElementById('form1:uiTxtPrecioUnitario_field').focus(); return false;"
                                                onFocus="document.getElementById('form1:uiTxtPrecioUnitario_field').focus(); return false;" width="110"/>
                                        </h:panelGrid>
                                        <h:panelGrid binding="#{ABMNotaCreditoProveedor.gridPanelDetLin2}" columns="10" id="gridPanelDetLin2"
                                            style="height: 24px" width="719">
                                            <webuijsf:label id="lblPrecio" text="Precio"/>
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtPrecioUnitario}" columns="12" id="uiTxtPrecioUnitario"
                                                onChange="calcularMonto5('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field' )" style="margin-left: -20px; text-align: left"/>
                                            <webuijsf:label id="lblCantida" text="Cantidad"/>
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtCantidad}" columns="10" id="uiTxtCantidad"
                                                onChange="calcularMonto5('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field' )" style="text-align: right"/>
                                            <webuijsf:label id="lblPorcIVA" text="Tipo de Impuesto"/>
                                            <webuijsf:dropDown binding="#{ABMNotaCreditoProveedor.uiLstIva}" id="uiLstIva"
                                                items="#{ABMNotaCreditoProveedor.uiLstIvaDefaultOptions.options}"
                                                onChange="calcularMonto5('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field' )"
                                                selected="#{ABMNotaCreditoProveedor.uiLstIvaDefaultOptions.selectedValue}" width="60"/>
                                            <webuijsf:label id="lblMontoIva" text="Monto IVA"/>
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtMontoIva}" columns="12" id="uiTxtMontoIva"
                                                onFocus="document.getElementById('form1:uiBtnAgregarDet').focus(); return false;" style="text-align: right"/>
                                            <webuijsf:label id="lblMontoTotal" text="Monto Total"/>
                                            <webuijsf:textField binding="#{ABMNotaCreditoProveedor.uiTxtMontoTotal}" columns="15" id="uiTxtMontoTotal"
                                                onFocus="document.getElementById('form1:uiBtnAgregarDet').focus(); return false;" style="text-align: right"/>
                                            <webuijsf:button actionExpression="#{ABMNotaCreditoProveedor.uiBtnAgregarDet_action}" id="uiBtnAgregarDet" text="Agregar"/>
                                            <webuijsf:button actionExpression="#{ABMNotaCreditoProveedor.uiBtnCancelarDetalle_action}" id="uiBtnCancelarDetalle" text="Cancelar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="tableDetalle" title="Detalle" width="720">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="5" sourceData="#{ABMNotaCreditoProveedor.lstDetalle}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Producto" id="tableColumn1">
                                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProducto'].codProducto}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Producto" id="tableColumnDescProducto">
                                                    <webuijsf:staticText id="staticTextDescProducto" text="#{currentRow.value['codProducto'].descripcion}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Precio Unit." id="tableColumn6">
                                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['precioUni']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cantidad" id="tableColumn7">
                                                    <webuijsf:staticText id="staticText6" text="#{currentRow.value['cantidad']}"/>
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
                                                <webuijsf:tableColumn align="center" binding="#{ABMNotaCreditoProveedor.tableColumnEditarDet}"
                                                    id="tableColumnEditarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMNotaCreditoProveedor.updateDetAction}"
                                                        id="uilnkEditarDetalle" imageURL="/resources/img/edit_16x16.gif" text="">
                                                        <f:setPropertyActionListener target="#{ABMNotaCreditoProveedor.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" binding="#{ABMNotaCreditoProveedor.tableColumnEliminarDet}"
                                                    id="tableColumnEliminarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMNotaCreditoProveedor.deleteDetAction}"
                                                        id="uilnkEliminarDetalle" imageURL="/resources/img/delete.png" text="">
                                                        <f:setPropertyActionListener target="#{ABMNotaCreditoProveedor.itemDet}" value="#{currentRow.tableRow.rowId}"/>
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
