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
                            <h:panelGrid binding="#{ABMCalculoDeCostosFinales.mainContainer}" id="mainContainer" style="height: 96px; left: 360px; top: 240px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMCalculoDeCostosFinales.gridPanelBuscar}" columns="2" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura">
                                        <webuijsf:label id="lblNroProveedor" text="Nro. Orden Trabajo"/>
                                        <webuijsf:textField id="txtNroFactura"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelProveedor1">
                                        <webuijsf:label id="lblProveedor" text="Responsable"/>
                                        <webuijsf:textField binding="#{ABMCalculoDeCostosFinales.userNameFiltro}" columns="45" id="txtProveedor"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelButtonBuscar">
                                        <webuijsf:button binding="#{ABMCalculoDeCostosFinales.buscarButton}" id="buscarButton" text="Buscar"/>
                                        <webuijsf:button binding="#{ABMCalculoDeCostosFinales.todosButton}" id="todosButton" text="Todos"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMCalculoDeCostosFinales.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                    function ABMPedidoCliente() {
                                        var table = document.getElementById("form1:table1");
                                        table.ABMPedidoCliente();
                                    }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMCalculoDeCostosFinales.table1}" clearSortButton="true" id="table1"
                                    paginateButton="true" paginationControls="true" sortPanelToggleButton="true" title="Ordenes de Trabajo" width="647">
                                    <webuijsf:tableRowGroup binding="#{ABMCalculoDeCostosFinales.tableRowGroup1}"
                                        emptyDataMsg="No se recupero ningun registro..." id="tableRowGroup1" rows="10"
                                        selected="#{ABMCalculoDeCostosFinales.selectedState}" sourceData="#{ABMCalculoDeCostosFinales.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" id="tableColumn5" spacerColumn="true" width="30">
                                            <webuijsf:radioButton id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Orden Trabajo" id="tableColumn2" width="117">
                                            <webuijsf:staticText id="staticText2" text="12345678"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Responsable" id="tableColumn3" width="425">
                                            <webuijsf:staticText id="staticText3" text="Juan Benitez"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn11">
                                            <webuijsf:staticText id="staticText8" text="Activo"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMCalculoDeCostosFinales.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMCalculoDeCostosFinales.addButton_action}"
                                        binding="#{ABMCalculoDeCostosFinales.addButton}" id="addButton" text="Calcular Costos Finales"/>
                                </h:panelGrid>
                                <!-- Detalle -->
                                <h:panelGrid binding="#{ABMCalculoDeCostosFinales.addUpdatePanel}" columns="1" id="addUpdatePanel" style="height: 528px" width="904">
                                    <h:panelGrid columns="2" id="panelGridDetalle1" style="text-align: justify" width="820">
                                        <!-- Orden de Trabajo -->
                                        <webuijsf:tabSet id="tabSetOrdenTrabajo" lite="true" mini="true" selected="tabOrdenTrabajo" style="height: 370px; width: 311px">
                                            <webuijsf:tab id="tabOrdenTrabajo" text="Datos Orden De Trabajo">
                                                <h:panelGrid columns="2" id="panelOrdenTrabajo" style="height: 276px" width="220">
                                                    <webuijsf:label id="lblNroOT" text="Nro. Orden Trabajo"/>
                                                    <webuijsf:textField id="txtNroOT"/>
                                                    <webuijsf:label id="lblDesc" text="Descripción"/>
                                                    <webuijsf:textArea columns="30" id="txtDescripcion" rows="7"/>
                                                    <webuijsf:label id="lblFecApertura" text="Fecha Apertura"/>
                                                    <webuijsf:textField id="txtFecApertura"/>
                                                    <webuijsf:label id="lblFecCierre" text="Fecha Cierre"/>
                                                    <webuijsf:textField id="txtFecCierre"/>
                                                </h:panelGrid>
                                            </webuijsf:tab>
                                        </webuijsf:tabSet>
                                        <!-- Costos Hora Hombre -->
                                        <webuijsf:tabSet id="tabSetCostosHoraHombre" lite="true" mini="true" selected="tabCostosHoraHombre" style="height: 370px; width: 551px">
                                            <webuijsf:tab actionExpression="#{ABMCalculoDeCostosFinales.tabCostosHoraHombre_action}" id="tabCostosHoraHombre" text="Costos Hora Hombre">
                                                <h:panelGrid columns="1" id="panelCostosHorasHombre" style="height: 265px" width="420">
                                                    <h:panelGrid columns="5" id="panelCostosHorasHombreAgregar1">
                                                        <webuijsf:hyperlink id="lnkEmpleado" text="Empleado"/>
                                                        <webuijsf:textField columns="8" id="txtCodEmpleado"/>
                                                        <webuijsf:textField columns="30" id="txtNomEmpleado"/>
                                                        <webuijsf:label id="lblPrecioUnitario" text="Salario x Hs."/>
                                                        <webuijsf:textField columns="10" id="txtPrecioUnitario"/>
                                                    </h:panelGrid>
                                                    <h:panelGrid columns="5" id="panelCostosHorasHombreAgregar2">
                                                        <webuijsf:label id="lblCantidad" text="Cantidad"/>
                                                        <webuijsf:textField columns="10" id="txtCantidad"/>
                                                        <webuijsf:label id="lblTotal" text="Total"/>
                                                        <webuijsf:textField columns="10" id="txtTotal"/>
                                                        <webuijsf:button id="btnAgregarCosto" text="Agregar"/>
                                                    </h:panelGrid>
                                                    <h:panelGrid columns="1" id="panelCostosHorasHombreTable" style="height: 215px">
                                                        <webuijsf:table augmentTitle="false" id="table2" title="Costos Horas Hombre" width="503">
                                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="10"
                                                                sourceData="#{ABMCalculoDeCostosFinales.defaultTableDataProvider}" sourceVar="currentRow">
                                                                <webuijsf:tableColumn headerText="Cod. Empleado" id="tableColumn1" width="89">
                                                                    <webuijsf:staticText id="staticText18" text="123"/>
                                                                </webuijsf:tableColumn>
                                                                <webuijsf:tableColumn headerText="Empleado" id="tableColumn4">
                                                                    <webuijsf:staticText id="staticText4" text="Jose Almada"/>
                                                                </webuijsf:tableColumn>
                                                                <webuijsf:tableColumn align="right" headerText="Salario Hs" id="tableColumn6">
                                                                    <webuijsf:staticText id="staticText5" text="15.000"/>
                                                                </webuijsf:tableColumn>
                                                                <webuijsf:tableColumn align="right" headerText="Cantidad Hs." id="tableColumn7">
                                                                    <webuijsf:staticText id="staticText6" text="200"/>
                                                                </webuijsf:tableColumn>
                                                                <webuijsf:tableColumn align="right" headerText="Total" id="tableColumn8">
                                                                    <webuijsf:staticText id="staticText7" text="300.000"/>
                                                                </webuijsf:tableColumn>
                                                                <webuijsf:tableColumn align="center" id="tableColumn23" width="40">
                                                                    <webuijsf:imageHyperlink id="imageHyperlink4" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                                </webuijsf:tableColumn>
                                                                <webuijsf:tableColumn align="center" id="tableColumn9" width="35">
                                                                    <webuijsf:imageHyperlink id="imageHyperlink1" imageURL="/resources/img/delete.png" text=""/>
                                                                </webuijsf:tableColumn>
                                                            </webuijsf:tableRowGroup>
                                                        </webuijsf:table>
                                                        <h:panelGrid columns="2" id="panelTotalCostosHH"
                                                            style="border-top: solid #000000 2px; margin-left: 230px; text-align: right" width="150">
                                                            <webuijsf:label id="lblTotalCostosHH" text="Total"/>
                                                            <webuijsf:textField columns="20" id="txtTotalCostosHH"/>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </webuijsf:tab>
                                        </webuijsf:tabSet>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelBottonDet"
                                        style="direction: rtl; line-height: normal; margin-left: 640px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button actionExpression="#{ABMCalculoDeCostosFinales.cancelButton_action}" id="cancelButton"
                                            style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMCalculoDeCostosFinales.addRecordButton_action}" id="addRecordButton"
                                            style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMCalculoDeCostosFinales.updateRecordButton_action}" id="updateRecordButton"
                                            rendered="false" style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <!-- Detalle gastos fijos -->
                                    <webuijsf:tabSet id="tabSetDetGastoFijo" lite="true" mini="true" selected="tabDetGastoFijo" style="height: 320px; width: 870px">
                                        <webuijsf:tab id="tabDetGastoFijo" text="Detalle Gastos Fijos">
                                            <h:panelGrid columns="1" id="panelGastoFijo">
                                                <h:panelGrid columns="8" id="panelGastoFijoAgregar" width="791">
                                                    <webuijsf:hyperlink id="linkGastoFijo" text="Gasto Fijo"/>
                                                    <webuijsf:textField columns="10" id="txtCodGastoFijo"/>
                                                    <webuijsf:textField id="txtDescGastoFijo"/>
                                                    <webuijsf:label id="lblObs" text="Observación"/>
                                                    <webuijsf:textField columns="40" id="txtObs" style="text-align: right" text="123456"/>
                                                    <webuijsf:label id="lblMontoGastoFijo" text="Monto"/>
                                                    <webuijsf:textField columns="15" id="txtMontoGastoFijo"/>
                                                    <webuijsf:button id="btnAgregarGastoFijo" text="Agregar"/>
                                                </h:panelGrid>
                                                <h:panelGrid columns="1" id="panelGastoFijoTable">
                                                    <webuijsf:table augmentTitle="false" id="table3" title="Gastos Fijos" width="779">
                                                        <webuijsf:tableRowGroup id="tableRowGroup3" rows="10"
                                                            sourceData="#{ABMCalculoDeCostosFinales.defaultTableDataProvider}" sourceVar="currentRow">
                                                            <webuijsf:tableColumn headerText="Cod. Gasto" id="tableColumn10" width="89">
                                                                <webuijsf:staticText id="staticText17" text="123"/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn headerText="Gasto Fijo" id="tableColumn12" width="286">
                                                                <webuijsf:staticText id="staticText9" text="1400 Energía Electrica"/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn headerText="Observación" id="tableColumn13">
                                                                <webuijsf:staticText id="staticText10" text=".--"/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn align="right" headerText="Monto" id="tableColumn14">
                                                                <webuijsf:staticText id="staticText1" text="12.000.000"/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn align="center" id="tableColumn24" width="40">
                                                                <webuijsf:imageHyperlink id="imageHyperlink5" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn align="center" id="tableColumn15" width="40">
                                                                <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/img/delete.png" text=""/>
                                                            </webuijsf:tableColumn>
                                                        </webuijsf:tableRowGroup>
                                                    </webuijsf:table>
                                                    <h:panelGrid columns="2" id="panelTotalGastosFijos"
                                                        style="border-top: solid #000000 2px; margin-left: 510px; text-align: right" width="167">
                                                        <webuijsf:label id="lblTotalGF" text="Total"/>
                                                        <webuijsf:textField columns="20" id="txtTotalGF"/>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </webuijsf:tab>
                                    </webuijsf:tabSet>
                                    <!-- Detalle Materias Primas - Insumos -->
                                    <webuijsf:tabSet id="tabSetDetInsumo" lite="true" mini="true" selected="tabDetInsumo" style="height: 320px; width: 870px">
                                        <webuijsf:tab id="tabDetInsumo" text="Detalle Materias Primas - Insumos">
                                            <h:panelGrid columns="1" id="panelDetInsumos">
                                                <h:panelGrid columns="12" id="panelDetInsumosAgregar" width="791">
                                                    <webuijsf:hyperlink id="linkGastoFijo" text="Producto"/>
                                                    <webuijsf:textField columns="5" id="txtCodProduto"/>
                                                    <webuijsf:textField id="txtDescProducto"/>
                                                    <webuijsf:label id="lblUnidadMedida" text="U. Medida"/>
                                                    <webuijsf:textField columns="10" disabled="true" id="txtUnidadMedida"/>
                                                    <webuijsf:label id="lblCosto" text="Costo"/>
                                                    <webuijsf:textField columns="10" disabled="true" id="txtCosto"/>
                                                    <webuijsf:label id="lblCantidad" text="Cantidad"/>
                                                    <webuijsf:textField columns="7" id="txtCantidad"/>
                                                    <webuijsf:label id="lblMonto" text="Monto"/>
                                                    <webuijsf:textField columns="12" disabled="true" id="txtMonto"/>
                                                    <webuijsf:button id="btnAgregarInsumo" text="Agregar"/>
                                                </h:panelGrid>
                                                <h:panelGrid columns="1" id="panelInsumoTable">
                                                    <webuijsf:table augmentTitle="false" id="table4" title="Materias Primas - Insumos" width="779">
                                                        <webuijsf:tableRowGroup id="tableRowGroup4" rows="10"
                                                            sourceData="#{ABMCalculoDeCostosFinales.defaultTableDataProvider}" sourceVar="currentRow">
                                                            <webuijsf:tableColumn headerText="Cod. Producto" id="tableColumn16" width="113">
                                                                <webuijsf:staticText id="staticText16" text="123"/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn17">
                                                                <webuijsf:staticText id="staticText12" text="Colas Barriles 20 kilos"/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn align="right" headerText="Costo" id="tableColumn18">
                                                                <webuijsf:staticText id="staticText13" text="100.000"/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn headerText="U. Medida" id="tableColumn19">
                                                                <webuijsf:staticText id="staticText11" text="Kilos"/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn align="right" headerText="Cantidad" id="tableColumn20">
                                                                <webuijsf:staticText id="staticText14" text="10"/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn align="right" headerText="Total" id="tableColumn21">
                                                                <webuijsf:staticText id="staticText15" text="100.000"/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn align="center" id="tableColumn25" width="40">
                                                                <webuijsf:imageHyperlink id="imageHyperlink6" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                            </webuijsf:tableColumn>
                                                            <webuijsf:tableColumn align="center" id="tableColumn22" width="40">
                                                                <webuijsf:imageHyperlink id="imageHyperlink3" imageURL="/resources/img/delete.png" text=""/>
                                                            </webuijsf:tableColumn>
                                                        </webuijsf:tableRowGroup>
                                                    </webuijsf:table>
                                                    <h:panelGrid columns="2" id="panelTotalGastosInsumos"
                                                        style="border-top: solid #000000 2px; height: 24px; margin-left: 510px; text-align: right" width="167">
                                                        <webuijsf:label id="lblTotalGV" text="Total"/>
                                                        <webuijsf:textField columns="20" id="txtTotalGV"/>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </webuijsf:tab>
                                    </webuijsf:tabSet>
                                    <h:panelGrid columns="2" id="panelTotalGral"
                                        style="border-top: solid #000000 4px; height: 48px; margin-left: 500px; text-align: right" width="363">
                                        <webuijsf:label id="lblTotalGral" style="font-size: 25px; font-weight: bold" text="Total"/>
                                        <webuijsf:textField columns="20" id="txtTotalGral" style="font-size: 20px; font-weight: bold; text-align: right"/>
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
