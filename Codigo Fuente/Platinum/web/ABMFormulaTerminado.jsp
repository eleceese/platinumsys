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
                    <!-- \SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <script>
                        function ABMProveedores() {
                            var table = document.getElementById("form1:tablaFormulas");
                            table.ABMProveedores();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar el Registro?")) {
                                    return false;
                                }else{
                                    return true;
                                }
                            }
                        }
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \ SCRIPT PARA MANEJAR EL DETALLE-->
                    <script>
                        function DetalleFormula() {
                            var table = document.getElementById("form1:tableDetalleFormula");
                            table.DetalleFormula();}
                    </script>
                    <!-- \ SCRIPT PARA MANEJAR EL DETALLE-->
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:script id="scriptPopUp" type="text/javascript" url="/js/utilJS.js"/>
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
                            <h:panelGrid binding="#{ABMFormulaTerminado.mainContainer}" id="mainContainer" style="height: 96px; left: 240px; top: 192px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMFormulaTerminado.gridPanelBuscar}" columns="3" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelCodigoFil">
                                        <webuijsf:label id="label1Filtro" text="Codigo"/>
                                        <webuijsf:textField binding="#{ABMFormulaTerminado.uiCodigoFil}" columns="20" id="uiCodigoFil"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Producto"/>
                                        <webuijsf:textField binding="#{ABMFormulaTerminado.uiProductoFil}" columns="30" id="uiProductoFil"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro1">
                                        <webuijsf:label id="label3Filtro1" text="Descripcion"/>
                                        <webuijsf:textField binding="#{ABMFormulaTerminado.uiDescripcionFil}" columns="30" id="uiDescripcionFil"/>
                                    </h:panelGrid>
                                    <webuijsf:button actionExpression="#{ABMFormulaTerminado.buscarButton_action}" binding="#{ABMFormulaTerminado.buscarButton}"
                                        id="buscarButton" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMFormulaTerminado.todosButton_action}" binding="#{ABMFormulaTerminado.todosButton}"
                                        id="todosButton" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMFormulaTerminado.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                function ABMComprasProveedor() {
                                    var table = document.getElementById("form1:table1");
                                    table.ABMComprasProveedor();
                                }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMFormulaTerminado.tablaFormulas}" id="tablaFormulas" paginateButton="true"
                                    paginationControls="true" title="Fórmulas de Producción" width="887">
                                    <webuijsf:tableRowGroup binding="#{ABMFormulaTerminado.formulasRW}" emptyDataMsg="No se recupero ningun registro..."
                                        id="formulasRW" rows="20" selected="#{ABMFormulaTerminado.selectedState}"
                                        sourceData="#{ABMFormulaTerminado.listaFormulaCabeceras}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMFormulaTerminado.tableColumn12}" id="tableColumn12"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMFormulaTerminado.radioButton1.id}">
                                            <webuijsf:radioButton binding="#{ABMFormulaTerminado.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMFormulaTerminado.radioButton1.id}" onClick="delSelect='ok'"
                                                selected="#{ABMFormulaTerminado.selected}" selectedValue="#{ABMFormulaTerminado.selectedValue}" valueChangeListenerExpression="#{ABMFormulaTerminado.radioButton1_processValueChange}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cod Formula" id="tableColumn2" sort="codFormula" width="112">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['codFormula']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Producto" id="tableColumn3" sort="codProducto">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProducto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cantidad" id="tableColumn4" sort="cantidad" width="97">
                                            <webuijsf:staticText id="staticText4" text="#{currentRow.value['cantidad']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Descripcion" id="tableColumn5" sort="descripcion" width="336">
                                            <webuijsf:staticText id="staticText8" text="#{currentRow.value['descripcion']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMFormulaTerminado.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMFormulaTerminado.addButton_action}" binding="#{ABMFormulaTerminado.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMFormulaTerminado.updateButton_action}" binding="#{ABMFormulaTerminado.updateButton}"
                                        id="updateButton" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMFormulaTerminado.deleteButton_action}" binding="#{ABMFormulaTerminado.deleteButton}"
                                        id="deleteButton" onClick="javascript:return confirmar()" text="Eliminar"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMFormulaTerminado.addUpdatePanel}" columns="1" id="addUpdatePanel" style="height: 524px">
                                    <h:panelGrid columns="2" id="sdsf">
                                        <webuijsf:hyperlink binding="#{ABMFormulaTerminado.uiHyperProducto}" id="uiHyperProducto"
                                            onClick="doPopup('form1:uiProductoCodigo_field', 'form1:uiProductoNombre_field')&#xd;&#xa;" target="popup"
                                            text="Producto" url="/faces/popup/popupProductos.jsp"/>
                                        <h:panelGrid binding="#{ABMFormulaTerminado.gridPanelUser}" columns="3" id="gridPanelUser">
                                            <webuijsf:textField binding="#{ABMFormulaTerminado.uiProductoCodigo}" columns="15" id="uiProductoCodigo"/>
                                            <webuijsf:textField binding="#{ABMFormulaTerminado.uiProductoNombre}" columns="50" id="uiProductoNombre" valueChangeListenerExpression="#{ABMFormulaTerminado.uiProductoNombre_processValueChange}"/>
                                            <webuijsf:message for="uiProductoNombre" id="message1" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="label2" text="Descripcion"/>
                                        <h:panelGrid columns="2" id="gridPanelPassword">
                                            <webuijsf:textArea binding="#{ABMFormulaTerminado.uiDescripcion}" columns="50" id="uiDescripcion" rows="5"/>
                                            <webuijsf:message for="uiDescripcion" id="message2" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label for="uiCantidad" id="label3" text="Cantidad"/>
                                        <h:panelGrid columns="2" id="gridPanelEmail">
                                            <webuijsf:textField binding="#{ABMFormulaTerminado.uiCantidad}" columns="30" id="uiCantidad"/>
                                            <webuijsf:message for="uiCantidad" id="message3" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelfec" text="Fecha Vigencia"/>
                                        <h:panelGrid columns="2" id="gridPanelfecvi">
                                            <webuijsf:calendar binding="#{ABMFormulaTerminado.uiFecha}" dateFormatPattern="dd/MM/yyyy" id="uiFecha"/>
                                            <webuijsf:message id="message3cal" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelesta" text="Estado"/>
                                        <h:panelGrid columns="2" id="gridPanelestado">
                                            <webuijsf:dropDown binding="#{ABMFormulaTerminado.uiEstado}" id="uiEstado"
                                                items="#{ABMFormulaTerminado.uiEstadoDefaultOptions.options}" selected="#{ABMFormulaTerminado.uiEstadoDefaultOptions.selectedValue}"/>
                                            <webuijsf:message id="message3esta" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel1"
                                        style="direction: rtl; line-height: normal; margin-left: 500px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button actionExpression="#{ABMFormulaTerminado.cancelButton_action}"
                                            binding="#{ABMFormulaTerminado.cancelButton}" id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMFormulaTerminado.addRecordButton_action}"
                                            binding="#{ABMFormulaTerminado.addRecordButton}" id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMFormulaTerminado.updateRecordButton_action}"
                                            binding="#{ABMFormulaTerminado.updateRecordButton}" id="updateRecordButton" style="width: 71px; font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Semiterminados"/>
                                        <h:panelGrid columns="6" id="gridPanel3" style="height: 48px" width="839">
                                            <webuijsf:hyperlink id="uiHiperLynkProductos"
                                                onClick="doPopup('form1:uiDetalleProdCod_field', 'form1:uiDetalleProdDesc_field','form1:uiDetalleCodFormula_field','form1:uiDetalleFormula_field','form1:uiDetalleCant_field')&#xd;&#xa;"
                                                target="popup" text="Producto" url="/faces/popup/popupFormulasSemiter.jsp"/>
                                            <webuijsf:textField binding="#{ABMFormulaTerminado.uiDetalleProdCod}" columns="10" id="uiDetalleProdCod"/>
                                            <webuijsf:textField binding="#{ABMFormulaTerminado.uiDetalleProdDesc}" columns="35" id="uiDetalleProdDesc"/>
                                            <webuijsf:label id="label4" text="Formula"/>
                                            <webuijsf:textField binding="#{ABMFormulaTerminado.uiDetalleCodFormula}" columns="10" id="uiDetalleCodFormula"/>
                                            <webuijsf:textField binding="#{ABMFormulaTerminado.uiDetalleFormula}" columns="35" id="uiDetalleFormula"/>
                                            <webuijsf:label id="label1" text="Cantidad"/>
                                            <webuijsf:textField binding="#{ABMFormulaTerminado.uiDetalleCant}" id="uiDetalleCant"/>
                                            <webuijsf:button actionExpression="#{ABMFormulaTerminado.uiButtonAgregarDetalle_action}" id="uiButtonAgregarDetalle" text="Agregar"/>
                                            <webuijsf:message for="uiDetalleProdDesc" id="message4" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" binding="#{ABMFormulaTerminado.tableDetalleFormula}" id="tableDetalleFormula" width="647">
                                            <webuijsf:tableRowGroup binding="#{ABMFormulaTerminado.tableRowGroupDetalleFormula}"
                                                id="tableRowGroupDetalleFormula" rows="5" sourceData="#{ABMFormulaTerminado.detallesFormula}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Codigo" id="tableColumn1" sort="codProducto">
                                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProducto'].codProducto}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Descripcion" id="tableColumn2" sort="codProducto">
                                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['codProducto'].descripcion}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Unidad Medida" id="tableColumn3" sort="codProducto">
                                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProducto'].codUnidadMedida.descripcion}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Formula" id="tableColumn9" sort="codFormula">
                                                    <webuijsf:staticText id="staticText6" text="#{currentRow.value['codFormulaSemiCabecera'].descripcion}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cantidad" id="tableColumn19" sort="codFormula">
                                                    <webuijsf:staticText id="staticText16" text="#{currentRow.value['codFormulaSemiCabecera'].cantidad}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn7">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMFormulaTerminado.detail}"
                                                        binding="#{ABMFormulaTerminado.uiImageHyperlinkEdit}" id="uiImageHyperlinkEdit"
                                                        imageURL="/resources/Images/edit_16x16.gif" text=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn8">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMFormulaTerminado.detail}"
                                                        binding="#{ABMFormulaTerminado.uiImageHyperlinkDel}" id="uiImageHyperlinkDel"
                                                        imageURL="/resources/img/delete.png" text="">
                                                        <f:setPropertyActionListener target="#{ABMFormulaTerminado.itemDet}" value="#{currentRow.tableRow.rowId}"/>
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
