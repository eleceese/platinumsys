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
                    <!-- \SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <script>
                        function initAllRows() {
                            var table = document.getElementById("form1:Perdidas");
                            table.initAllRows();}
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
                            <h:panelGrid binding="#{ABMPerdidasProduccion.mainContainer}" id="mainContainer"
                                style="height: 96px; left: 216px; top: 216px; position: absolute" width="888">
                                <h:panelGrid binding="#{ABMPerdidasProduccion.gridPanelBuscar}" columns="2" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelOt">
                                        <webuijsf:label id="lblNroProveedor" text="Nro. Orden Trabajo"/>
                                        <webuijsf:textField binding="#{ABMPerdidasProduccion.uiCodOtFil}" id="uiCodOtFil"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelResponsable">
                                        <webuijsf:label id="lblProveedor" text="Responsable"/>
                                        <webuijsf:dropDown binding="#{ABMPerdidasProduccion.uiResponsableFil}" id="uiResponsableFil" items="#{SessionBean1.listaEmpleadosOp}"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecha1">
                                        <webuijsf:label id="lblNroProveedor1" text="Fecha Ini :"/>
                                        <webuijsf:calendar binding="#{ABMPerdidasProduccion.uiFecha1Fil}" columns="29" id="uiFecha1Fil" valueChangeListenerExpression="#{ABMPerdidasProduccion.uiFecha1Fil_processValueChange}"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecha2">
                                        <webuijsf:label id="lblNroProveedor2" text="Fecha Fin"/>
                                        <webuijsf:calendar binding="#{ABMPerdidasProduccion.uiFecha2Fil}" columns="29" id="uiFecha2Fil"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelButtonBuscar">
                                        <webuijsf:button actionExpression="#{ABMPerdidasProduccion.uiBuscarButton_action}"
                                            binding="#{ABMPerdidasProduccion.uiBuscarButton}" id="uiBuscarButton" text="Buscar"/>
                                        <webuijsf:button actionExpression="#{ABMPerdidasProduccion.uiTodosButton_action}"
                                            binding="#{ABMPerdidasProduccion.uiTodosButton}" id="uiTodosButton" text="Todos"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMPerdidasProduccion.pageAlert1}" rendered="false" style="height: 72px"/>
                                <webuijsf:table augmentTitle="false" binding="#{ABMPerdidasProduccion.perdidas}" id="Perdidas" paginateButton="true"
                                    paginationControls="true" title="Pérdidas en Producción" width="863">
                                    <webuijsf:tableRowGroup binding="#{ABMPerdidasProduccion.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="15" selected="#{ABMPerdidasProduccion.selectedState}"
                                        sourceData="#{ABMPerdidasProduccion.listaPerdidas}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMPerdidasProduccion.tableColumn2}" id="tableColumn2"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMPerdidasProduccion.radioButton1.id}" width="10">
                                            <webuijsf:radioButton binding="#{ABMPerdidasProduccion.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMPerdidasProduccion.radioButton1.id}" onClick="delSelect='ok'"
                                                selected="#{ABMPerdidasProduccion.selected}" selectedValue="#{ABMPerdidasProduccion.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="tableColumn3" width="10">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codPerdida']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha" id="tableColumn5" sort="fechaPerdida" width="20">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText8" text="#{currentRow.value['fechaPerdida']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Empleado" id="tableColumn11" sort="codEmpleado">
                                            <webuijsf:staticText id="staticText9" text="#{currentRow.value['codEmpleado']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Producto" id="tableColumn12" sort="codProducto">
                                            <webuijsf:staticText id="staticText10" text="#{currentRow.value['codProducto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Observacion" id="tableColumn13" width="232">
                                            <webuijsf:staticText id="staticText11" text="#{currentRow.value['observacion']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMPerdidasProduccion.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMPerdidasProduccion.uiNuevoButton_action}"
                                        binding="#{ABMPerdidasProduccion.uiNuevoButton}" id="uiNuevoButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMPerdidasProduccion.uiEditarButton_action}"
                                        binding="#{ABMPerdidasProduccion.uiEditarButton}" id="uiEditarButton" text="Anular"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMPerdidasProduccion.addUpdatePanel}" columns="1" id="addUpdatePanel"
                                    style="height: 326px; margin-top: 10px" width="671">
                                    <h:panelGrid columns="4" id="panelGridCabeceraCompra" style="height: 20px; text-align: left" width="455">
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:uiResponsableCod_field', 'form1:uiResponsableNombre_field')"
                                            target="popup" text="Responsable" url="/faces/popup/popupEmpleados.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" style="margin-left: 5px" width="335">
                                            <webuijsf:textField binding="#{ABMPerdidasProduccion.uiResponsableCod}" id="uiResponsableCod"/>
                                            <webuijsf:textField binding="#{ABMPerdidasProduccion.uiResponsableNombre}" columns="50" disabled="true"
                                                id="uiResponsableNombre" valueChangeListenerExpression="#{ABMPerdidasProduccion.uiResponsableNombre_processValueChange}"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="lblFecha" labelLevel="3" text="Fecha"/>
                                        <webuijsf:calendar binding="#{ABMPerdidasProduccion.uiFecha}" columns="15" dateFormatPattern="dd/MM/yyyy" id="uiFecha"/>
                                    </h:panelGrid>
                                    <!-- Panel de Orden de Trabajo -->
                                    <h:panelGrid columns="3" id="panelDetOT" style="height: 43px; margin-top: 5px; text-align: left" width="551">
                                        <webuijsf:hyperlink id="uiNroOTLink" onClick="doPopup('form1:uiNroOT_field', 'form1:uiOtDesc_field')" target="popup"
                                            text="Numero OT" url="/faces/popup/popupOts.jsp"/>
                                        <webuijsf:textField binding="#{ABMPerdidasProduccion.uiNroOT}" id="uiNroOT"/>
                                        <webuijsf:textField binding="#{ABMPerdidasProduccion.uiOtDesc}" columns="50" disabled="true" id="uiOtDesc"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanel4" style="width: 100%; height: 100%;">
                                        <webuijsf:radioButtonGroup binding="#{ABMPerdidasProduccion.radioButtonGroup1}" columns="2" id="radioButtonGroup1"
                                            items="#{ABMPerdidasProduccion.radioButtonGroup1DefaultOptions.options}" selected="#{ABMPerdidasProduccion.radioButtonGroup1DefaultOptions.selectedValue}"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel2" style="width: 100%; height: 100%; margin-top: 10px">
                                        <webuijsf:hyperlink id="hyperlink2" onClick="doPopup('form1:uiProductoCod_field', 'form1:uiProductoDesc_field')"
                                            target="popup" text="Producto" url="/faces/popup/popupProductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanel3" style="height: 100%; margin-left: -3px" width="359">
                                            <webuijsf:textField binding="#{ABMPerdidasProduccion.uiProductoCod}" columns="13" id="uiProductoCod"/>
                                            <webuijsf:textField binding="#{ABMPerdidasProduccion.uiProductoDesc}" columns="50" disabled="true" id="uiProductoDesc"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="label1" text="Cantidad"/>
                                        <webuijsf:textField binding="#{ABMPerdidasProduccion.uiCantidad}" columns="13" id="uiCantidad"/>
                                        <webuijsf:label id="label2" text="Observacion"/>
                                        <webuijsf:textArea binding="#{ABMPerdidasProduccion.uiObservacion}" columns="90" id="uiObservacion" rows="6"/>
                                        <webuijsf:label id="label3" text="Deposito"/>
                                        <webuijsf:dropDown binding="#{ABMPerdidasProduccion.uiDeposito}" id="uiDeposito"
                                            items="#{SessionBean1.listaDepositosOp}" valueChangeListenerExpression="#{ABMPerdidasProduccion.uiDeposito_processValueChange}"/>
                                    </h:panelGrid>
                                    <h:panelGrid binding="#{ABMPerdidasProduccion.gridPanel1}" columns="2" id="gridPanel1"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 460px; margin-top: 10px; text-align: right; vertical-align: middle" width="182">
                                        <webuijsf:button actionExpression="#{ABMPerdidasProduccion.cancelButton_action}"
                                            binding="#{ABMPerdidasProduccion.cancelButton}" id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMPerdidasProduccion.addRecordButton_action}"
                                            binding="#{ABMPerdidasProduccion.addRecordButton}" id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMPerdidasProduccion.updateRecordButton_action}"
                                            binding="#{ABMPerdidasProduccion.updateRecordButton}" id="updateRecordButton" style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <webuijsf:messageGroup id="messageGroup1"/>
                                </h:panelGrid>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
