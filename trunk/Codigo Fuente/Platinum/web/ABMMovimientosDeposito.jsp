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
                        function ABMMovimientosDeposito() {
                            var table = document.getElementById("form1:tablaFormulas");
                            table.ABMMovimientosDeposito();}
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
                            <h:panelGrid binding="#{ABMMovimientosDeposito.mainContainer}" id="mainContainer" style="height: 96px; left: 240px; top: 288px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMMovimientosDeposito.gridPanelBuscar}" columns="1" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelFiltros" style="height: 72px" width="503">
                                        <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                            <webuijsf:label id="depositoLabel" text="Deposito"/>
                                            <webuijsf:dropDown binding="#{ABMMovimientosDeposito.uiDepositoFil}" id="uiDepositoFil"
                                                items="#{SessionBean1.listaDepositosOp}" width="150"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="gridPanelCodigoFil">
                                            <webuijsf:label id="fecha" text="Codigo"/>
                                            <webuijsf:textField binding="#{ABMMovimientosDeposito.uiCodigoFil}" columns="20" id="uiCodigoFil"/>
                                        </h:panelGrid>
                                        <webuijsf:button actionExpression="#{ABMMovimientosDeposito.todosButton_action}"
                                            binding="#{ABMMovimientosDeposito.todosButton}" id="todosButton" text="Todos"/>
                                        <webuijsf:button actionExpression="#{ABMMovimientosDeposito.buscarButton_action}"
                                            binding="#{ABMMovimientosDeposito.buscarButton}" id="buscarButton" text="Buscar"/>
                                    </h:panelGrid>
                                    <webuijsf:table augmentTitle="false" id="uiTableMovimientos" paginateButton="true" paginationControls="true"
                                        title="Movimientos en Deposito" width="911">
                                        <webuijsf:tableRowGroup id="tableRowGroup1" rows="20" sourceData="#{ABMMovimientosDeposito.listaMovimientosCab}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" id="tableColumn1" width="41">
                                                <webuijsf:radioButton id="radioButton2" label=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Fecha" id="tableColumn2" sort="fechaEntradaSalida" width="142">
                                                <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText2" text="#{currentRow.value['fechaEntradaSalida']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Deposito" id="tableColumn3" sort="codDeposito" width="193">
                                                <webuijsf:staticText id="staticText3" text="#{currentRow.value['codDeposito']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Empleado" id="tableColumn4" sort="codEmpleado" width="216">
                                                <webuijsf:staticText id="staticText4" text="#{currentRow.value['codEmpleado']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Obs" id="tableColumn7">
                                                <webuijsf:staticText id="staticText7" text="#{currentRow.value['observacion']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                    <h:panelGrid columns="3" id="buttonPanel1">
                                        <webuijsf:button actionExpression="#{ABMMovimientosDeposito.addButton1_action}" id="addButton1" text="Nuevo"/>
                                        <webuijsf:button actionExpression="#{ABMMovimientosDeposito.updateButton1_action}" id="updateButton1" text="Editar"/>
                                        <webuijsf:button actionExpression="#{ABMMovimientosDeposito.deleteButton1_action}" id="deleteButton1"
                                            onClick="javascript:return confirmar()" text="Eliminar"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMMovimientosDeposito.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                function ABMComprasProveedor() {
                                    var table = document.getElementById("form1:table1");
                                    table.ABMComprasProveedor();
                                }
                                </script>
                                <h:panelGrid binding="#{ABMMovimientosDeposito.addUpdatePanel}" columns="1" id="addUpdatePanel" style="height: 524px">
                                    <h:panelGrid columns="2" id="gridPanelDatosCabecera">
                                        <webuijsf:label id="labelfec" text="Fecha:"/>
                                        <h:panelGrid columns="2" id="gridPanelfecvi">
                                            <webuijsf:calendar binding="#{ABMMovimientosDeposito.uiFecha}" dateFormatPattern="dd/MM/yyyy" id="uiFecha"/>
                                            <webuijsf:message for="uiFecha" id="message3cal" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink binding="#{ABMMovimientosDeposito.uiHyperEmpleado1}" id="uiHyperEmpleado1"
                                            onClick="doPopup('form1:uiResponsableCodigo_field', 'form1:uiResponsableNombre_field')" target="popup"
                                            text="Responsable" url="/faces/popup/popupEmpleados.jsp"/>
                                        <h:panelGrid binding="#{ABMMovimientosDeposito.gridPanelUser}" columns="3" id="gridPanelUser">
                                            <webuijsf:textField binding="#{ABMMovimientosDeposito.uiResponsableCodigo}" columns="15" id="uiResponsableCodigo"/>
                                            <webuijsf:textField binding="#{ABMMovimientosDeposito.uiResponsableNombre}" columns="50" disabled="true"
                                                id="uiResponsableNombre" valueChangeListenerExpression="#{ABMMovimientosDeposito.uiResponsableNombre_processValueChange}"/>
                                            <webuijsf:message for="uiResponsableCodigo" id="message1" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="uiHyperEmpleado2"
                                            onClick="doPopup('form1:uiResponsable2Codigo_field', 'form1:uiResponsableNombre1_field')" target="popup"
                                            text="Retirado Por" url="/faces/popup/popupEmpleados.jsp"/>
                                        <h:panelGrid columns="3" id="gridPanelUser1">
                                            <webuijsf:textField binding="#{ABMMovimientosDeposito.uiResponsable2Codigo}" columns="15" id="uiResponsable2Codigo"/>
                                            <webuijsf:textField binding="#{ABMMovimientosDeposito.uiResponsableNombre1}" columns="50" disabled="true"
                                                id="uiResponsableNombre1" valueChangeListenerExpression="#{ABMMovimientosDeposito.uiResponsableNombre_processValueChange}"/>
                                            <webuijsf:message for="uiResponsableNombre1" id="message5" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="label2" text="Observacion"/>
                                        <h:panelGrid columns="2" id="gridPanelPassword">
                                            <webuijsf:textArea binding="#{ABMMovimientosDeposito.uiObservacion}" columns="50" id="uiObservacion" rows="5"/>
                                            <webuijsf:message for="uiObservacion" id="message2" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="label3" text="Deposito"/>
                                        <h:panelGrid columns="2" id="gridPanelEmail">
                                            <webuijsf:dropDown binding="#{ABMMovimientosDeposito.uiDeposito}" id="uiDeposito"
                                                items="#{SessionBean1.listaDepositosOp}" width="150"/>
                                            <webuijsf:message id="message3" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelBotones"
                                        style="direction: rtl; line-height: normal; margin-left: 500px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button actionExpression="#{ABMMovimientosDeposito.cancelButton_action}"
                                            binding="#{ABMMovimientosDeposito.cancelButton}" id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMMovimientosDeposito.addRecordButton_action}"
                                            binding="#{ABMMovimientosDeposito.addRecordButton}" id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMMovimientosDeposito.updateRecordButton_action}"
                                            binding="#{ABMMovimientosDeposito.updateRecordButton}" id="updateRecordButton" style="width: 71px; font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanelAgregarDetalle" style="height: 100%; width: 100%">
                                        <h:panelGrid id="gridPanel4" style="height: 48px">
                                            <webuijsf:label id="label5" style="font-size: 16px" text="Detalle de Movimientos en Deposito"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="3" id="gridPanel3" style="height: 48px" width="623">
                                            <webuijsf:hyperlink id="uiHiperLynkProductos"
                                                onClick="doPopup('form1:uiDetalleProdCod_field', 'form1:uiDetalleProdDesc_field')" target="popup"
                                                text="Producto" url="/faces/popup/popupProductos.jsp"/>
                                            <h:panelGrid columns="2" id="gridPanel2" style="height: 26px; width: 96px">
                                                <webuijsf:textField binding="#{ABMMovimientosDeposito.uiDetalleProdCod}" columns="10" id="uiDetalleProdCod"/>
                                                <webuijsf:textField binding="#{ABMMovimientosDeposito.uiDetalleProdDesc}" columns="55" disabled="true" id="uiDetalleProdDesc"/>
                                            </h:panelGrid>
                                            <h:panelGrid columns="2" id="gridPanel5" style="height: 26px; width: 96px">
                                                <webuijsf:label id="label1" text="Cantidad"/>
                                                <webuijsf:textField binding="#{ABMMovimientosDeposito.uiDetalleCant}" id="uiDetalleCant" valueChangeListenerExpression="#{ABMMovimientosDeposito.uiDetalleCant_processValueChange}"/>
                                            </h:panelGrid>
                                            <webuijsf:hyperlink id="uiHiperLynkOT"
                                                onClick="doPopup('form1:uiDetalleOTCod_field', 'form1:uiDetalleOTProducto_field')&#xd;" target="popup"
                                                text="Nro Sub OT" url="/faces/popup/popupOrdenTrabajoDetalles.jsp"/>
                                            <h:panelGrid columns="2" id="gridPanel9" style="height: 26px; width: 96px">
                                                <webuijsf:textField binding="#{ABMMovimientosDeposito.uiDetalleOTCod}" columns="10" id="uiDetalleOTCod"/>
                                                <webuijsf:textField binding="#{ABMMovimientosDeposito.uiDetalleOTProducto}" columns="50" disabled="true" id="uiDetalleOTProducto"/>
                                            </h:panelGrid>
                                            <h:panelGrid id="gridPanel1" style="height: 26px; width: 96px"/>
                                            <webuijsf:hyperlink id="uiHiperLynkProductos2"
                                                onClick="doPopup('form1:uiDetalleCodSolic_field', 'form1:uiDetalleSolicProduct_field')&#xd;" target="popup"
                                                text="Nro Solicitud" url="/faces/popup/popupSolicitudesMovDep.jsp"/>
                                            <h:panelGrid columns="2" id="gridPanel8" style="height: 26px; width: 96px">
                                                <webuijsf:textField binding="#{ABMMovimientosDeposito.uiDetalleCodSolic}" columns="10" id="uiDetalleCodSolic"/>
                                                <webuijsf:textField binding="#{ABMMovimientosDeposito.uiDetalleSolicProduct}" columns="50" disabled="true" id="uiDetalleSolicProduct"/>
                                            </h:panelGrid>
                                            <h:panelGrid id="gridPanel6" style="height: 26px; width: 96px"/>
                                            <webuijsf:label id="label4" text="Movimiento"/>
                                            <webuijsf:dropDown binding="#{ABMMovimientosDeposito.uiDetalleTipo}" id="uiDetalleTipo"
                                                items="#{ABMMovimientosDeposito.uiDetalleTipoDefaultOptions.options}" width="120"/>
                                            <h:panelGrid id="gridPanel7" style="height: 26px; width: 96px"/>
                                            <webuijsf:button actionExpression="#{ABMMovimientosDeposito.uiButtonAgregarDetalle_action}"
                                                id="uiButtonAgregarDetalle" text="Agregar"/>
                                            <webuijsf:message for="uiDetalleProdDesc" id="message4" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanelDetalle1" style="width: 100%; height: 100%;">
                                        <h:panelGrid id="gridPanelTabla1" style="height: 154px" summary="Productos" title="Productos" width="935">
                                            <webuijsf:table augmentTitle="false" id="tableProductos1" paginateButton="true" paginationControls="true"
                                                title="Movimientos" width="719">
                                                <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="productos1" rows="15"
                                                    sourceData="#{ABMMovimientosDeposito.detallesEntradaSalida}" sourceVar="currentRow">
                                                    <webuijsf:tableColumn headerText="Movimiento" id="tableColumn8" sort="tipoEntradaSalida" width="139">
                                                        <webuijsf:staticText id="staticText1" text="#{currentRow.value['tipoEntradaSalida']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Producto" id="tableColumn9" sort="codProducto" width="335">
                                                        <webuijsf:staticText id="staticText8" text="#{currentRow.value['codProducto']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Cantidad" id="tableColumn10" width="50">
                                                        <webuijsf:staticText id="staticText9" text="#{currentRow.value['cantidadEntSal']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Sub OT" id="tableColumn5" sort="codOrdenTrabajoDetalle">
                                                        <webuijsf:staticText id="staticText5" text="#{currentRow.value['codOrdenTrabajoDetalle']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Solicitud" id="tableColumn6" sort="codSolicitud">
                                                        <webuijsf:staticText id="staticText6" text="#{currentRow.value['codSolicitud']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" id="tableColumn11" width="20">
                                                        <webuijsf:imageHyperlink id="imageHyperlink1" imageURL="/resources/Images/edit_16x16.gif" text=""/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" id="tableColumn13" width="20">
                                                        <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/Images/delete.gif" text=""/>
                                                    </webuijsf:tableColumn>
                                                </webuijsf:tableRowGroup>
                                            </webuijsf:table>
                                        </h:panelGrid>
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
