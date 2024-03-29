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
                    <script>
                        function tieneSolicitud() {
                            if(!document.getElementById('form1:uiTxtNroSolicitud_field').value == '') {
                                document.getElementById('form1:uiBtnCancelar').focus(); return false;
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
                        <div style="height: 219px; width: 1032px">
                            <h:panelGrid binding="#{ABMComprasProveedor.mainContainer}" id="mainContainer"
                                style="height: 96px; left: 216px; top: 192px; position: absolute" width="1008">
                                <h:panelGrid binding="#{ABMComprasProveedor.gridPanelBuscar}" columns="5" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura">
                                        <webuijsf:label id="lblNroProveedor" text="Nro. Factura"/>
                                        <webuijsf:textField binding="#{ABMComprasProveedor.uiFilTxtNroFactura}" id="uiFilTxtNroFactura"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelProveedor1">
                                        <webuijsf:label id="lblProveedor" text="Proveedor"/>
                                        <webuijsf:textField binding="#{ABMComprasProveedor.uiFilTxtProveedor}" columns="35" id="uiFilTxtProveedor"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Fecha Factura"/>
                                        <webuijsf:calendar binding="#{ABMComprasProveedor.uiFilCalFechaFactura}" columns="15" id="uiFilCalFechaFactura"/>
                                    </h:panelGrid>
                                    <webuijsf:label id="label3FiltroEstado" text="Estado"/>
                                    <webuijsf:dropDown binding="#{ABMComprasProveedor.uiLstFilEstado}" id="uiLstFilEstado"
                                        items="#{ABMComprasProveedor.uiLstFilEstadoDefaultOptions.options}" selected="#{ABMComprasProveedor.uiLstFilEstadoDefaultOptions.selectedValue}"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMComprasProveedor.gridPanelBtnBuscar}" columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                    <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnBuscar_action}" binding="#{ABMComprasProveedor.uiBtnBuscar}"
                                        id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnTodos_action}" binding="#{ABMComprasProveedor.uiBtnTodos}"
                                        id="uiBtnTodos" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMComprasProveedor.pageAlert1}" rendered="false" style="height: 72px"/>
                                <webuijsf:table augmentTitle="false" binding="#{ABMComprasProveedor.table1}" id="table1" title="Compras Proveedor" width="935">
                                    <webuijsf:tableRowGroup binding="#{ABMComprasProveedor.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMComprasProveedor.selectedState}"
                                        sourceData="#{ABMComprasProveedor.lstCabecera}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMComprasProveedor.tableColumn11}" id="tableColumn11"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMComprasProveedor.radioButton1.id}" width="36">
                                            <webuijsf:radioButton binding="#{ABMComprasProveedor.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMComprasProveedor.radioButton1.id}" onClick="delSelect='ok'"
                                                selected="#{ABMComprasProveedor.selected}" selectedValue="#{ABMComprasProveedor.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Factura" id="tableColumn2" width="169">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['nroFactura']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Proveedor" id="tableColumn3">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProveedor'].nombreProveedor}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha" id="tableColumn4" width="96">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText4" text="#{currentRow.value['fecha']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn5" width="112">
                                            <webuijsf:staticText converter="#{ABMComprasProveedor.characterConverter1}" id="staticText8" text="#{currentRow.value['estado']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMComprasProveedor.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMComprasProveedor.addButton_action}" binding="#{ABMComprasProveedor.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMComprasProveedor.updateButton_action}" binding="#{ABMComprasProveedor.updateButton}"
                                        id="updateButton" text="Ver Detalle"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMComprasProveedor.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid cellpadding="1" columns="3" id="panelGridCabeceraCompra" style="text-align: left" width="1007">
                                        <webuijsf:label id="lblNroFac" text="Nro. Factura"/>
                                        <h:panelGrid cellpadding="2" cellspacing="2" columns="3" id="panelGridCabCompra1" width="335">
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtNroFac}" id="uiTxtNroFac" maxLength="20"/>
                                            <webuijsf:label for="uiLstTipoComprobante" id="lblTipoFactura" text="Tipo"/>
                                            <webuijsf:dropDown binding="#{ABMComprasProveedor.uiLstTipoComprobante}" id="uiLstTipoComprobante"
                                                items="#{SessionBean1.listaTipoComprobanteOption}" width="170px"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra2" style="text-align: right" width="200">
                                            <webuijsf:label for="uiLstEstado" id="lblEstadoFactura" text="Estado"/>
                                            <webuijsf:dropDown binding="#{ABMComprasProveedor.uiLstEstado}" id="uiLstEstado"
                                                items="#{ABMComprasProveedor.uiLstEstadoDefaultOptions.options}"
                                                selected="#{ABMComprasProveedor.uiLstEstadoDefaultOptions.selectedValue}"
                                                valueChangeListenerExpression="#{ABMComprasProveedor.uiLstEstado_processValueChange}" width="120px"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1"
                                            onClick="doPopup('form1:uiTxtCodProveedor_field', 'form1:uiTxtNombreProveedor_field')" target="popup"
                                            text="Proveedor" url="/faces/popup/popupProveedores.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtCodProveedor}" columns="10"
                                                converter="#{ABMComprasProveedor.numberConverter1}" id="uiTxtCodProveedor" maxLength="15"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtNombreProveedor}" columns="50" id="uiTxtNombreProveedor" valueChangeListenerExpression="#{ABMComprasProveedor.uiTxtNombreProveedor_processValueChange}"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra3" style="text-align: right" width="200">
                                            <webuijsf:label id="lblSubTotal" text="SUB-TOTAL"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtSubTotal}" columns="20"
                                                converter="#{ABMComprasProveedor.numberConverter1}" id="uiTxtSubTotal"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="lblFecha" text="Fecha"/>
                                        <webuijsf:calendar binding="#{ABMComprasProveedor.uiCalFecha}" columns="15" dateFormatPattern="dd/MM/yyyy"
                                            id="uiCalFecha" style="margin-left: -9px"/>
                                        <h:panelGrid columns="2" id="panelGridCabCompra4" style="text-align: right" width="200">
                                            <webuijsf:label id="lblTotalIva" text="TOTAL IVA"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtTotalIva}" columns="20"
                                                converter="#{ABMComprasProveedor.numberConverter1}" id="uiTxtTotalIva"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="gridPanelaux1" style="height: 24px; width: 96px"/>
                                        <h:panelGrid columns="2" id="gridPanelaux2" style="height: 24px" width="335"/>
                                        <h:panelGrid columns="2" id="panelGridCabCompra5" style="text-align: right" width="200">
                                            <webuijsf:label id="lblTotal" text="TOTAL"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtTotal}" columns="20"
                                                converter="#{ABMComprasProveedor.numberConverter1}" id="uiTxtTotal"
                                                onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="3" id="gridPanel1"
                                        style="direction: rtl; height: 72px; line-height: normal; margin-left: 670px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnGuardarNuevo_action}"
                                            binding="#{ABMComprasProveedor.uiBtnGuardarNuevo}" id="uiBtnGuardarNuevo" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnGuardarEditar_action}"
                                            binding="#{ABMComprasProveedor.uiBtnGuardarEditar}" id="uiBtnGuardarEditar" rendered="false" style="font-size: 14px" text="Anular"/>
                                        <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnCancelar_action}"
                                            binding="#{ABMComprasProveedor.uiBtnCancelar}" id="uiBtnCancelar" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMComprasProveedor.btnConfirmar_action}"
                                            binding="#{ABMComprasProveedor.btnConfirmar}" id="btnConfirmar" style="font-size: 14px" text="Confirmar"/>
                                    </h:panelGrid>
                                    <webuijsf:messageGroup id="messageGroup1" style="width: 719px"/>
                                    <h:panelGrid id="gridPanel2" style="height: 100%" width="815">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Factura"/>
                                        <h:panelGrid binding="#{ABMComprasProveedor.gridPanelDetLin1}" columns="7" id="gridPanelDetLin1" style="height: 24px" width="935">
                                            <webuijsf:hyperlink id="hyperlink2"
                                                onClick="doPopup('form1:uiTxtCodProducto_field', 'form1:uiTxtDescProducto_field', 'form1:uiTxtIva_field')"
                                                target="popup" text="Producto" url="/faces/popup/popupProductosCompra.jsp"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtCodProducto}" columns="10"
                                                converter="#{ABMComprasProveedor.numberConverter1}" id="uiTxtCodProducto"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtDescProducto}" columns="30" id="uiTxtDescProducto" onFocus="document.getElementById('form1:uiTxtNroSolicitud_field').focus(); return false;"/>
                                            <webuijsf:hyperlink id="hyperlink3"
                                                onClick="doPopup('form1:uiTxtCodProducto_field', 'form1:uiTxtDescProducto_field', 'form1:uiTxtCantidad_field', 'form1:uiTxtNroSolicitud_field','form1:uiLstUnidadMedida_list' )"
                                                target="popup" text="Nro. Solicitud" url="/faces/popup/popupSolicitudes.jsp"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtNroSolicitud}" columns="10"
                                                converter="#{ABMComprasProveedor.numberConverter1}" id="uiTxtNroSolicitud"/>
                                            <webuijsf:label id="lblPorcIVA" text="Impuesto %"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtIva}" columns="5" id="uiTxtIva" onFocus="document.getElementById('form1:uiTxtCantidad_field').focus(); return false;"/>
                                        </h:panelGrid>
                                        <h:panelGrid binding="#{ABMComprasProveedor.gridPanelDetLin2}" columns="10" id="gridPanelDetLin2" style="height: 24px" width="935">
                                            <webuijsf:label id="lblPrecio" text="Precio"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtPrecioUnitario}" columns="12"
                                                converter="#{ABMComprasProveedor.numberConverter1}" id="uiTxtPrecioUnitario" onChange="calcularMonto5('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiTxtIva_field', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field' )"/>
                                            <webuijsf:label id="lblCantida" text="Cantidad"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtCantidad}" columns="10"
                                                converter="#{ABMComprasProveedor.numberConverter1}" id="uiTxtCantidad"
                                                onChange="calcularMonto5('form1:uiTxtPrecioUnitario_field', 'form1:uiTxtCantidad_field', 'form1:uiLstIva_list', 'form1:uiTxtMontoIva_field', 'form1:uiTxtMontoTotal_field' )" style="text-align: right"/>
                                            <webuijsf:label id="lblMontoIva" text="Monto IVA"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtMontoIva}" columns="12"
                                                converter="#{ABMComprasProveedor.numberConverter1}" id="uiTxtMontoIva"
                                                onFocus="document.getElementById('form1:uiBtnAgregarDet').focus(); return false;" style="text-align: right"/>
                                            <webuijsf:label id="lblMontoTotal" text="Monto Total"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtMontoTotal}" columns="15"
                                                converter="#{ABMComprasProveedor.numberConverter1}" id="uiTxtMontoTotal"
                                                onFocus="document.getElementById('form1:uiBtnAgregarDet').focus(); return false;" style="text-align: right"/>
                                            <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnAgregarDet_action}" id="uiBtnAgregarDet" text="Agregar"/>
                                            <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnCancelarDetalle_action}" id="uiBtnCancelarDetalle" text="Cancelar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="tableDetalle" title="Detalle" width="911">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="5" sourceData="#{ABMComprasProveedor.lstDetalle}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Producto" id="tableColumn1" width="113">
                                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProducto'].codProducto}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Producto" id="tableColumnDescProducto" width="239">
                                                    <webuijsf:staticText id="staticTextDescProducto" text="#{currentRow.value['codProducto'].descripcion}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Precio Unit." id="tableColumn6">
                                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['precioUni']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cantidad" id="tableColumn7">
                                                    <webuijsf:staticText id="staticText6" text="#{currentRow.value['cantidad']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="IVA %" id="tableColumn71" width="42">
                                                    <webuijsf:staticText id="staticText6Porc" text="#{currentRow.value['porcIva']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Monto IVA" id="tableColumn8" width="82">
                                                    <webuijsf:staticText id="staticText7" text="#{currentRow.value['montoIva']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Total" id="tableColumn9" width="126">
                                                    <webuijsf:staticText id="staticText9" text="#{currentRow.value['total']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" binding="#{ABMComprasProveedor.tableColumnEditarDet}"
                                                    id="tableColumnEditarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMComprasProveedor.updateDetAction}" id="uilnkEditarDetalle"
                                                        imageURL="/resources/img/edit_16x16.gif" text="">
                                                        <f:setPropertyActionListener target="#{ABMComprasProveedor.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" binding="#{ABMComprasProveedor.tableColumnEliminarDet}"
                                                    id="tableColumnEliminarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMComprasProveedor.deleteDetAction}" id="uilnkEliminarDetalle"
                                                        imageURL="/resources/img/delete.png" text="">
                                                        <f:setPropertyActionListener target="#{ABMComprasProveedor.itemDet}" value="#{currentRow.tableRow.rowId}"/>
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
