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
                            var table = document.getElementById("form1:tableFormulas");
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
                            <h:panelGrid binding="#{ABMFormulaSemiTerminado.mainContainer}" id="mainContainer" style="height: 96px; left: 240px; top: 192px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMFormulaSemiTerminado.gridPanelBuscar}" columns="3" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelCodigoFil1">
                                        <webuijsf:label id="label1Filtro1" text="Codigo"/>
                                        <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiCodigoFil1}" id="uiCodigoFil1"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelProdFiltro">
                                        <webuijsf:label id="label3Filtro1" text="Producto"/>
                                        <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiProductoFil1}" columns="30" id="uiProductoFil1"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelDescFiltro">
                                        <webuijsf:label id="label3Filtro2" text="Descripcion"/>
                                        <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiDescripcionFil1}" columns="30" id="uiDescripcionFil1"/>
                                    </h:panelGrid>
                                    <webuijsf:button actionExpression="#{ABMFormulaSemiTerminado.buscarButton_action}" id="buscarButton1" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMFormulaSemiTerminado.todosButton_action}" id="todosButton1" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMFormulaSemiTerminado.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                function ABMSolicitudesInternas() {
                                    var table = document.getElementById("form1:table1");
                                    table.ABMSolicitudesInternas();
                                }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMFormulaSemiTerminado.tableFormulas}" id="tableFormulas" paginateButton="true"
                                    paginationControls="true" title="Fórmulas de Producción" width="600">
                                    <webuijsf:tableRowGroup aboveColumnFooter="true" binding="#{ABMFormulaSemiTerminado.tableFormulasRW}"
                                        emptyDataMsg="No se recupero ningun registro..." id="tableFormulasRW" rows="10"
                                        selected="#{ABMFormulaSemiTerminado.selectedState}" sourceData="#{ABMFormulaSemiTerminado.listaFormulaSemiCabeceras}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMFormulaSemiTerminado.tableColumn12}" id="tableColumn12"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMFormulaSemiTerminado.radioButton1.id}" valign="top">
                                            <webuijsf:radioButton binding="#{ABMFormulaSemiTerminado.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMFormulaSemiTerminado.radioButton1.id}" onClick="delSelect='ok'"
                                                selected="#{ABMFormulaSemiTerminado.selected}" selectedValue="#{ABMFormulaSemiTerminado.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cod Formula" id="tableColumn2" sort="codFormulaSemiCabecera">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['codFormulaSemiCabecera']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Producto" id="tableColumn3" sort="codProducto">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProducto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cantidad" id="tableColumn4" sort="cantidad">
                                            <webuijsf:staticText id="staticText4" text="#{currentRow.value['cantidad']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Descripcion" id="tableColumn5" sort="descripcion">
                                            <webuijsf:staticText id="staticText9" text="#{currentRow.value['descripcion']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMFormulaSemiTerminado.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMFormulaSemiTerminado.addButton_action}"
                                        binding="#{ABMFormulaSemiTerminado.addButton}" id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMFormulaSemiTerminado.updateButton_action}"
                                        binding="#{ABMFormulaSemiTerminado.updateButton}" id="updateButton" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMFormulaSemiTerminado.deleteButton_action}"
                                        binding="#{ABMFormulaSemiTerminado.deleteButton}" id="deleteButton" text="Eliminar"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMFormulaSemiTerminado.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid columns="2" id="detalle">
                                        <webuijsf:hyperlink id="uiHyperlinkProducto"
                                            onClick="doPopup('form1:uiProductoCodigo_field', 'form1:uiProductoNombre_field')" target="popup" text="Producto" url="/faces/popup/popupProductosSemiter.jsp"/>
                                        <h:panelGrid columns="3" id="gridPanelProd">
                                            <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiProductoCodigo}" columns="15" id="uiProductoCodigo"/>
                                            <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiProductoNombre}" columns="50" id="uiProductoNombre"/>
                                            <webuijsf:message id="message1" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="label2" text="Descripcion"/>
                                        <h:panelGrid columns="2" id="gridPanelPassword">
                                            <webuijsf:textArea binding="#{ABMFormulaSemiTerminado.uiDescripcion}" columns="50" id="uiDescripcion" rows="5"/>
                                            <webuijsf:message id="message2" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label for="uiCantidad" id="label3" text="Cantidad"/>
                                        <h:panelGrid columns="2" id="gridPanelEmail">
                                            <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiCantidad}" columns="30" id="uiCantidad"/>
                                            <webuijsf:message for="uiCantidad" id="message3" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelfec" text="Fecha Vigencia"/>
                                        <h:panelGrid columns="2" id="gridPanelfecvi">
                                            <webuijsf:calendar binding="#{ABMFormulaSemiTerminado.uiFecha}" dateFormatPattern="dd/MM/yyyy" id="uiFecha"/>
                                            <webuijsf:message id="message3cal" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelesta" text="Estado"/>
                                        <h:panelGrid columns="2" id="gridPanelestado">
                                            <webuijsf:dropDown binding="#{ABMFormulaSemiTerminado.uiEstado}" id="uiEstado"
                                                items="#{ABMFormulaSemiTerminado.uiEstadoDefaultOptions.options}" selected="#{ABMFormulaSemiTerminado.uiEstadoDefaultOptions.selectedValue}"/>
                                            <webuijsf:message id="message3esta" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelBottonDet"
                                        style="direction: rtl; line-height: normal; margin-left: 500px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button actionExpression="#{ABMFormulaSemiTerminado.cancelButton_action}"
                                            binding="#{ABMFormulaSemiTerminado.cancelButton}" id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMFormulaSemiTerminado.addRecordButton_action}"
                                            binding="#{ABMFormulaSemiTerminado.addRecordButton}" id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMFormulaSemiTerminado.updateRecordButton_action}"
                                            binding="#{ABMFormulaSemiTerminado.updateRecordButton}" id="updateRecordButton" style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <!-- DETALLE RECURSOS -->
                                    <h:panelGrid id="gridPanelRecursos" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Recursos"/>
                                        <h:panelGrid columns="5" id="gridPanel3" style="height: 48px" width="623">
                                            <webuijsf:hyperlink id="hyperlink2" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                                target="popup" text="Producto" url="/faces/popupproductos.jsp"/>
                                            <h:panelGrid columns="2" id="gridPanel1" style="width: 100%; height: 100%;">
                                                <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiDetProductoCodigo}" columns="10" id="uiDetProductoCodigo"/>
                                                <webuijsf:textField columns="30" id="uiDetProductoNombre"/>
                                            </h:panelGrid>
                                            <webuijsf:label id="label1" text="Cantidad"/>
                                            <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiDetProductoCantidad}" id="uiDetProductoCantidad"/>
                                            <webuijsf:button actionExpression="#{ABMFormulaSemiTerminado.buttonAddDetProd_action}" id="buttonAddDetProd" text="Agregar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="table2" width="623">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{ABMFormulaSemiTerminado.detallesFormulaSemi}" sourceVar="currentRow">
                                                <webuijsf:tableColumn id="tableColumn8" width="26">
                                                    <webuijsf:radioButton id="radioButton2" label=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Codigo" id="tableColumn1" sort="codFormulaSemiDetalle" width="97">
                                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['codFormulaSemiDetalle']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Producto" id="tableColumn6" sort="codProducto" width="249">
                                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['codProducto']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cantidad" id="tableColumn7" sort="cantidad">
                                                    <webuijsf:staticText id="staticText6" text="#{currentRow.value['cantidad']}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                    </h:panelGrid>
                                    <!-- DETALLE TAREAS -->
                                    <h:panelGrid binding="#{ABMFormulaSemiTerminado.gridPanelTareas}" id="gridPanelTareas" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="lblDetTareas" style="font-size: 16px" text="Detalle Tareas"/>
                                        <h:panelGrid columns="7" id="gridPanelAddDetTarea" style="height: 48px" width="623">
                                            <webuijsf:hyperlink id="hlTarea" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                                target="popup" text="Tarea" url="/faces/popuptareas.jsp"/>
                                            <h:panelGrid columns="2" id="gridPanel2" style="width: 100%; height: 100%;">
                                                <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiDetTareaCodigo}" columns="10" id="uiDetTareaCodigo"/>
                                                <webuijsf:textField columns="30" id="uiDetTareaNombre"/>
                                            </h:panelGrid>
                                            <webuijsf:label id="lblCantTarea" text="Cantidad"/>
                                            <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiDetTareaCantidad}" columns="10" id="uiDetTareaCantidad"/>
                                            <webuijsf:label id="lblOrden" text="Orden"/>
                                            <webuijsf:textField binding="#{ABMFormulaSemiTerminado.uiDetTareaOrden}" columns="5" id="uiDetTareaOrden"/>
                                            <webuijsf:button actionExpression="#{ABMFormulaSemiTerminado.buttonAddDetTar_action}" id="buttonAddDetTar" text="Agregar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="tableTareas" width="623">
                                            <webuijsf:tableRowGroup id="tableTareasRowGroup" rows="10" sourceData="#{ABMFormulaSemiTerminado.tareasFormula}" sourceVar="currentRow">
                                                <webuijsf:tableColumn align="center" id="tableColumn13">
                                                    <webuijsf:radioButton id="radioButton3" label=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Tarea" id="tableColumn9" sort="codTarea">
                                                    <webuijsf:staticText id="staticText7" text="#{currentRow.value['codTarea']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cantidad" id="tableColumn10" sort="cantidadTarea">
                                                    <webuijsf:staticText id="staticText8" text="#{currentRow.value['cantidadTarea']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Orden" id="tableColumn11" sort="ordenTarea">
                                                    <webuijsf:staticText id="staticText10" text="#{currentRow.value['ordenTarea']}"/>
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
