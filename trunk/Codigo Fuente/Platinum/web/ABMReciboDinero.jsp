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
                        function listaComprobantes(){
                            if(document.getElementById('form1:uiTxtCodCliente_field').value == ''){
                                alert('Debe seleccionar un cliente...');
                                return false;
                            }else{
                                DynaFaces.Tx.fire("ajaxTransaction1", "uiTxtCodCliente");
                                doPopup('form1:uiTxtDescComprobante_field', 'form1:uiTxtNroComprobante_field', 'form1:uiTxtCodComprobante_field', 'form1:uiTxtNroCuota_field', 'form1:uiTxtFecVencimiento_field', 'form1:uiTxtMontoCuota_field','form1:uiTxtSaldoCuota_field')
                            }
                        }
                    </script>
                    <script>
                        function verificarCodCliente(){
                            if(document.getElementById('form1:uiTxtCodCliente_field').value == ''){
                                alert('Debe Ingresar un Cliente para poder seleccionar un Comprobante');
                                document.getElementById('form1:uiTxtCodCliente_field').focus();
                            }
                        }
                    </script>
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
                    <df:ajaxTransaction id="ajaxTransaction1"
                        inputs="page1:html1:body1:form1:mainContainer:addUpdatePanel:gridPanel2:gridPanelDetLin1:hyperlink2,page1:html1:body1:form1:mainContainer:addUpdatePanel:panelGridCabeceraCompra:gridPanelProveedor:uiTxtCodCliente" render="page1:html1:body1:form1:mainContainer:addUpdatePanel:panelGridCabeceraCompra:gridPanelProveedor:uiTxtCodCliente"/>
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
                            <h:panelGrid binding="#{ABMReciboDinero.mainContainer}" id="mainContainer"
                                style="height: 96px; left: 264px; top: 216px; position: absolute" width="912">
                                <h:panelGrid binding="#{ABMReciboDinero.gridPanelBuscar}" columns="3" id="gridPanelBuscar" width="863">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura">
                                        <webuijsf:label id="lblNroPedido" text="Nro. Recibo"/>
                                        <webuijsf:textField binding="#{ABMReciboDinero.uiFilTxtNroRecibo}" id="uiFilTxtNroRecibo"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelCliente">
                                        <webuijsf:label id="lblCliente" text="Cliente"/>
                                        <webuijsf:textField binding="#{ABMReciboDinero.uiFilTxtCliente}" columns="35" id="uiFilTxtCliente"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Fecha"/>
                                        <webuijsf:calendar binding="#{ABMReciboDinero.uiFilCalFecha}" columns="15" id="uiFilCalFecha"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMReciboDinero.gridPanelBtnBuscar}" columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                    <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnBuscar_action}" binding="#{ABMReciboDinero.uiBtnBuscar}"
                                        id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnTodos_action}" binding="#{ABMReciboDinero.uiBtnTodos}"
                                        id="uiBtnTodos" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMReciboDinero.pageAlert1}" rendered="false" style="height: 72px"/>
                                <webuijsf:table augmentTitle="false" binding="#{ABMReciboDinero.table1}" id="table1" title="Recibos" width="863">
                                    <webuijsf:tableRowGroup binding="#{ABMReciboDinero.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMReciboDinero.selectedState}" sourceData="#{ABMReciboDinero.lstCabecera}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMReciboDinero.tableColumn11}" id="tableColumn11"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMReciboDinero.radioButton1.id}" width="30">
                                            <webuijsf:radioButton binding="#{ABMReciboDinero.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMReciboDinero.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMReciboDinero.selected}" selectedValue="#{ABMReciboDinero.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Serie" id="tableColumnSerie" width="96">
                                            <webuijsf:staticText id="staticTextTipo" text="#{currentRow.value['serieRecibo']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Recibo" id="tableColumn2" width="130">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['numero']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cliente" id="tableColumn3">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codCliente'].apellidoCliente}, #{currentRow.value['codCliente'].nombreCliente}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="right" headerText="Emisión" id="tableColumn4" width="96">
                                            <webuijsf:staticText converter="#{ABMReciboDinero.calendarConverter1}" id="staticText4" text="#{currentRow.value['fecha']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="right" headerText="Total" id="tableColumn50" width="112">
                                            <webuijsf:staticText converter="#{ABMReciboDinero.numberConverter1}" id="staticTextTotal" text="#{currentRow.value['montoTotal']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn5" width="112">
                                            <webuijsf:staticText converter="#{ABMReciboDinero.characterConverter1}" id="staticText8" text="#{currentRow.value['estado']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMReciboDinero.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMReciboDinero.addButton_action}" binding="#{ABMReciboDinero.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMReciboDinero.updateButton_action}" binding="#{ABMReciboDinero.updateButton}"
                                        id="updateButton" text="Ver Detalle"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMReciboDinero.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid cellpadding="1" columns="3" id="panelGridCabeceraCompra" style="text-align: left" width="863">
                                        <webuijsf:label id="lblTipoFactura" text="SERIE"/>
                                        <h:panelGrid cellpadding="2" cellspacing="2" columns="3" id="panelGridCabCompra1" width="335">
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtSerie}" columns="10" id="uiTxtSerie" maxLength="15"/>
                                            <webuijsf:label id="lblNroFac" text="NRO. RECIBO"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtNroRecibo}" id="uiTxtNroRecibo" maxLength="20" onClick="document.getElementById('form1:uiTxtCodCliente_field').focus(); return false;"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra2" style="text-align: right" width="200">
                                            <webuijsf:label for="uiLstEstado" id="lblEstadoFactura" text="Estado"/>
                                            <webuijsf:dropDown binding="#{ABMReciboDinero.uiLstEstado}" id="uiLstEstado"
                                                items="#{ABMReciboDinero.uiLstEstadoDefaultOptions.options}"
                                                onClick="document.getElementById('form1:uiTxtCodCliente_field').focus(); return false;"
                                                selected="#{ABMReciboDinero.uiLstEstadoDefaultOptions.selectedValue}" width="120px"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:uiTxtCodCliente_field', 'form1:uiTxtNombreCliente_field')"
                                            target="popup" text="Cliente" url="/faces/popup/popupCliente.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtCodCliente}" columns="10"
                                                converter="#{ABMReciboDinero.numberConverter1}" id="uiTxtCodCliente" maxLength="15"
                                                onChange="DynaFaces.Tx.fire(&quot;ajaxTransaction1&quot;, &quot;uiTxtCodCliente&quot;);" valueChangeListenerExpression="#{ABMReciboDinero.uiTxtCodCliente_processValueChange}"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtNombreCliente}" columns="50" id="uiTxtNombreCliente" onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra3" style="height: 26px; text-align: right" width="200">
                                            <webuijsf:label id="lblFecha" text="Fecha"/>
                                            <webuijsf:calendar binding="#{ABMReciboDinero.uiCalFecha}" columns="15" dateFormatPattern="dd/MM/yyyy"
                                                id="uiCalFecha" style="margin-left: 28px"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="lblTotalIva" text="TOTAL"/>
                                        <webuijsf:textField binding="#{ABMReciboDinero.uiTxtTotal1}" columns="20" id="uiTxtTotal1"
                                            onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="3" id="gridPanel1"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 630px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button binding="#{ABMReciboDinero.uiBtnImprimir}" id="uiBtnImprimir" style="font-size: 14px" text="Imprimir"/>
                                        <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnGuardarNuevo_action}"
                                            binding="#{ABMReciboDinero.uiBtnGuardarNuevo}" id="uiBtnGuardarNuevo" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnGuardarEditar_action}"
                                            binding="#{ABMReciboDinero.uiBtnGuardarEditar}" id="uiBtnGuardarEditar" rendered="false" style="font-size: 14px" text="Anular"/>
                                        <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnCancelar_action}" binding="#{ABMReciboDinero.uiBtnCancelar}"
                                            id="uiBtnCancelar" style="font-size: 14px" text="Cancelar"/>
                                    </h:panelGrid>
                                    <webuijsf:messageGroup id="messageGroup1" showGlobalOnly="true" style="width: 719px"/>
                                    <!-- INICIO COMPROBANTES  DETALLE-->
                                    <h:panelGrid id="gridPanelComprobantes" style="width: 100%; height: 100%;">
                                        <webuijsf:label binding="#{ABMReciboDinero.uiLblTituloDetalle}" id="uiLblTituloDetalle" style="font-size: 16px" text="Detalle Recibo - Comprobantes"/>
                                        <h:panelGrid binding="#{ABMReciboDinero.gridPanelDetLin1}" columns="8" id="gridPanelDetLin1" style="height: 24px" width="839">
                                            <webuijsf:hyperlink actionExpression="#{ABMReciboDinero.hyperlink2_action}" id="hyperlink2"
                                                onClick="listaComprobantes();" onMouseMove="verificarCodCliente();" target="popup" text="Comprobante" url="/faces/popup/popupClientesSaldos.jsp"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtDescComprobante}" columns="18" id="uiTxtDescComprobante" onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;"/>
                                            <webuijsf:label id="lblnro" text="Nro.:"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtNroComprobante}" id="uiTxtNroComprobante" onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;"/>
                                            <webuijsf:label id="lblCodComprobante" text="Codigo"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtCodComprobante}" columns="10" id="uiTxtCodComprobante" onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;"/>
                                            <webuijsf:label id="lblFecVencimiento" text="Vencimiento"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtFecVencimiento}" columns="10" id="uiTxtFecVencimiento"
                                                onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;" style="margin-left: -20px; text-align: left"/>
                                        </h:panelGrid>
                                        <h:panelGrid binding="#{ABMReciboDinero.gridPanelDetLin2}" columns="10" id="gridPanelDetLin2" style="height: 24px" width="863">
                                            <webuijsf:label id="lblTipoComprobante1" text="Cuota"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtNroCuota}" columns="5"
                                                converter="#{ABMReciboDinero.numberConverter1}" id="uiTxtNroCuota" onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;"/>
                                            <webuijsf:label id="lblPrecio1" text="Monto Cuota"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtMontoCuota}" columns="15"
                                                converter="#{ABMReciboDinero.numberConverter1}" id="uiTxtMontoCuota"
                                                onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;" style="margin-left: -20px; text-align: left"/>
                                            <webuijsf:label id="lblPrecio" text="Saldo Cuota"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtSaldoCuota}" columns="15"
                                                converter="#{ABMReciboDinero.numberConverter1}" id="uiTxtSaldoCuota"
                                                onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;" style="margin-left: -20px; text-align: left"/>
                                            <webuijsf:label id="lblMontoTotal" text="Monto Cobro"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtMontoCobro}" columns="15"
                                                converter="#{ABMReciboDinero.numberConverter1}" id="uiTxtMontoCobro" style="text-align: right"/>
                                            <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnAgregarDet_action}" id="uiBtnAgregarDet" text="Agregar"/>
                                            <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnCancelarDetalle_action}" id="uiBtnCancelarDetalle" text="Cancelar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" binding="#{ABMReciboDinero.tableDetalle}" id="tableDetalle" title="Detalle" width="863">
                                            <webuijsf:tableRowGroup binding="#{ABMReciboDinero.tableRowGroup2}" id="tableRowGroup2" rows="5"
                                                sourceData="#{ABMReciboDinero.lstDetalle}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Tipo Comprobante" id="tableColumn1">
                                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['descTipoComprobante']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Nro. Comprobante" id="tableColumnDescProducto">
                                                    <webuijsf:staticText id="staticTextDescProducto" text="#{currentRow.value['comprobante']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Nro. Cuota" id="tableColumn6">
                                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['nroCuota']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Vencimiento" id="tableColumn7">
                                                    <webuijsf:staticText converter="#{ABMReciboDinero.calendarConverter1}" id="staticText6" text="#{currentRow.value['fechaVencimiento']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Monto Cuota" id="tableColumn71">
                                                    <webuijsf:staticText id="staticText6Porc" text="#{currentRow.value['montoCuota']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Saldo Cuota" id="tableColumn8">
                                                    <webuijsf:staticText id="staticText7" text="#{currentRow.value['saldoCuota']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Monto Pago" id="tableColumn9">
                                                    <webuijsf:staticText id="staticmontoPago" text="#{currentRow.value['montoPago']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" binding="#{ABMReciboDinero.tableColumnEditarDet}" id="tableColumnEditarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMReciboDinero.updateDetAction}" id="uilnkEditarDetalle"
                                                        imageURL="/resources/img/edit_16x16.gif" text="">
                                                        <f:setPropertyActionListener target="#{ABMReciboDinero.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" binding="#{ABMReciboDinero.tableColumnEliminarDet}"
                                                    id="tableColumnEliminarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMReciboDinero.deleteDetAction}" id="uilnkEliminarDetalle"
                                                        imageURL="/resources/img/delete.png" text="">
                                                        <f:setPropertyActionListener target="#{ABMReciboDinero.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <h:panelGrid columns="2" id="gridPanelTotalComprobantes" style="margin-left: 605px" width="191">
                                            <webuijsf:label id="lblTotalComprobantes" text="TOTAL"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtTotalComprobantes}" columns="20" id="uiTxtTotalComprobantes"
                                                onFocus="document.getElementById('form1:uiBtnCancelarDetalle').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <!-- FIN COMPROBANTES  DETALLE-->
                                    <!-- INICIO FORMA COBRO DETALLE-->
                                    <h:panelGrid id="gridPanelFormaCobro" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="uiLblTituloDetalle1" style="font-size: 16px" text="Detalle Recibo - Forma Cobro"/>
                                        <h:panelGrid columns="11" id="gridPanelDetLin1" style="height: 24px" width="887">
                                            <webuijsf:hyperlink id="linkFormaCobro" target="popup" text="Forma Cobro" url="/faces/popup/popupClientesSaldos.jsp"/>
                                            <webuijsf:textField columns="5" id="uiTxtCodFormaCobro"/>
                                            <webuijsf:textField id="uiTxtDescFormaCobro" onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;"/>
                                            <webuijsf:label id="lblMontoTotal" text="Serie"/>
                                            <webuijsf:textField columns="5" id="uiTxtSerieFormaCobro" style="text-align: right"/>
                                            <webuijsf:label id="lblMontoTotal" text="Nro. Documento"/>
                                            <webuijsf:textField columns="15" id="uiTxtNroFormaCobro" style="text-align: right"/>
                                            <webuijsf:label id="lblMontoTotal" text="Monto Cobro"/>
                                            <webuijsf:textField columns="15" converter="#{ABMReciboDinero.numberConverter1}" id="uiTxtMontoCobro" style="text-align: right"/>
                                            <webuijsf:button id="uiBtnAgregarDetFC" text="Agregar"/>
                                            <webuijsf:button id="uiBtnCancelarDetalleFC" text="Cancelar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="tableDetalleFC" title="Detalle Forma Cobro" width="863">
                                            <webuijsf:tableRowGroup id="tableRowGroup2FC" rows="5" sourceData="#{ABMReciboDinero.lstDetalleFC}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Forma Cobro" id="tableColumn1FC">
                                                    <webuijsf:staticText id="staticText1FC" text="#{currentRow.value['codFormaPago'].codFormaPago}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Forma Cobro" id="tableColumnDescProductoFC">
                                                    <webuijsf:staticText id="staticTextDescProductoFC" text="#{currentRow.value['codFormaPago'].nombreFormaPago}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Serie" id="tableColumn6FC">
                                                    <webuijsf:staticText id="staticText5FC" text="#{currentRow.value['serieCheque']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Nro" id="tableColumn7FC">
                                                    <webuijsf:staticText converter="#{ABMReciboDinero.calendarConverter1}" id="staticText6FC" text="#{currentRow.value['numeroCheque']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Monto" id="tableColumn71FC">
                                                    <webuijsf:staticText id="staticText6PorcFC" text="#{currentRow.value['monto']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumnEditarDetFC" width="40">
                                                    <webuijsf:imageHyperlink id="uilnkEditarDetalleFC" imageURL="/resources/img/edit_16x16.gif" text="">
                                                        <f:setPropertyActionListener target="#{ABMReciboDinero.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumnEliminarDetFC" width="40">
                                                    <webuijsf:imageHyperlink id="uilnkEliminarDetalleFC" imageURL="/resources/img/delete.png" text="">
                                                        <f:setPropertyActionListener target="#{ABMReciboDinero.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <h:panelGrid columns="2" id="gridPanelTotalFormaCobro" style="margin-left: 605px" width="191">
                                            <webuijsf:label id="lblTotalComprobantesFC" text="TOTAL"/>
                                            <webuijsf:textField columns="20" id="uiTxtTotalComprobantesFC"
                                                onFocus="document.getElementById('form1:uiBtnCancelarDetalleFC').focus(); return false;" style="text-align: right"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <!-- FIN COMPROBANTES  DETALLE-->
                                </h:panelGrid>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
