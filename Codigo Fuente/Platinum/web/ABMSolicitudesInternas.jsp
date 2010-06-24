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
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <div style="height: 99px">
                            <h:panelGrid binding="#{ABMSolicitudesInternas.mainContainer}" id="mainContainer" style="height: 96px; left: 264px; top: 216px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMSolicitudesInternas.gridPanelBuscar}" columns="2" id="gridPanelBuscar" width="695">
                                    <h:panelGrid columns="2" id="gridPanelUserFiltro" width="359">
                                        <webuijsf:label id="label1Filtro" text="Solicitante"/>
                                        <webuijsf:dropDown binding="#{ABMSolicitudesInternas.uiEmpleadoFil}" id="uiEmpleadoFil"
                                            items="#{ABMSolicitudesInternas.listaEmpleadosOp}" width="250"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro" width="383">
                                        <webuijsf:label id="label3Filtro" text="Producto"/>
                                        <webuijsf:dropDown binding="#{ABMSolicitudesInternas.uiProductoFil}" id="uiProductoFil"
                                            items="#{ABMSolicitudesInternas.listaProductosOp}" width="300"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecDesde">
                                        <webuijsf:label id="lblFecDesde" text="Fecha Desde"/>
                                        <webuijsf:calendar binding="#{ABMSolicitudesInternas.uiCalFechaDesde}" dateFormatPattern="dd/MM/yyyy"
                                            dateFormatPatternHelp="dd/MM/yyyy" id="uiCalFechaDesde"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecHasta">
                                        <webuijsf:label id="lblFecHasta" text="Fecha Hasta"/>
                                        <webuijsf:calendar binding="#{ABMSolicitudesInternas.uiCalFechaHasta}" dateFormatPattern="dd/MM/yyyy"
                                            dateFormatPatternHelp="dd/MM/yyyy" id="uiCalFechaHasta"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                    <webuijsf:button actionExpression="#{ABMSolicitudesInternas.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMSolicitudesInternas.uiBtnTodos_action}" id="uiBtnTodos" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMSolicitudesInternas.pageAlert1}" rendered="false" style="height: 72px"/>
                                <webuijsf:table augmentTitle="false" binding="#{ABMSolicitudesInternas.table1}" id="table1" paginateButton="true"
                                    paginationControls="true" title="Solicitudes Internas" width="1007">
                                    <webuijsf:tableRowGroup binding="#{ABMSolicitudesInternas.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMSolicitudesInternas.selectedState}"
                                        sourceData="#{SessionBean1.listaSolicitud}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" alignKey="" id="tableColumn5" onClick="setTimeout('initAllRows()',0)"
                                            selectId="#{ABMSolicitudesInternas.radioButton1.id}" valign="middle" width="40">
                                            <webuijsf:radioButton binding="#{ABMSolicitudesInternas.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMSolicitudesInternas.radioButton1.id}" onClick="delSelect='ok'"
                                                selected="#{ABMSolicitudesInternas.selected}" selectedValue="#{ABMSolicitudesInternas.selectedValue}" style="height: 18px"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha" id="tableColumn3" width="108">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText3" text="#{currentRow.value['fecha']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Solicitud" id="tableColumn1">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codSolicitud']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Empleado" id="tableColumn2" width="271">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['codEmpleado']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Observacion" id="tableColumn6" width="200">
                                            <webuijsf:staticText id="staticText5" text="#{currentRow.value['observacion']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Producto" id="tableColumn7" sort="codProducto">
                                            <webuijsf:staticText id="staticText6" text="#{currentRow.value['codProducto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn4">
                                            <webuijsf:staticText id="staticText4" text="#{currentRow.value['estado']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMSolicitudesInternas.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMSolicitudesInternas.addButton_action}" binding="#{ABMSolicitudesInternas.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMSolicitudesInternas.updateButton_action}"
                                        binding="#{ABMSolicitudesInternas.updateButton}" id="updateButton" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMSolicitudesInternas.deleteButton_action}"
                                        binding="#{ABMSolicitudesInternas.deleteButton}" id="deleteButton" onClick="javascript:return confirm" text="Eliminar"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMSolicitudesInternas.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid columns="2" id="detalle">
                                        <webuijsf:hyperlink id="hlkResponsable" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            target="popup" text="Solicitante" url="/faces/popupEmpleados.jsp"/>
                                        <h:panelGrid columns="3" id="gridPanelResponsable">
                                            <webuijsf:textField binding="#{ABMSolicitudesInternas.uiTxtCodEmpleado}" columns="10" id="uiTxtCodEmpleado"/>
                                            <webuijsf:textField binding="#{ABMSolicitudesInternas.uiTxtNombreEmpleado}" columns="50" id="uiTxtNombreEmpleado"/>
                                            <webuijsf:message for="uiTxtResponsable" id="message1" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelfec" text="Fecha"/>
                                        <h:panelGrid columns="2" id="gridPanelfecvi">
                                            <webuijsf:calendar binding="#{ABMSolicitudesInternas.uiCalFecha}" columns="10" dateFormatPattern="dd/MM/yyyy"
                                                dateFormatPatternHelp="dd/MM/yyyy" id="uiCalFecha"/>
                                            <webuijsf:message for="uiCalFecha" id="message3cal" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            target="popup" text="Producto" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="3" id="gridPanelProducto">
                                            <webuijsf:textField binding="#{ABMSolicitudesInternas.uiTxtCodProducto}" columns="10" id="uiTxtCodProducto"/>
                                            <webuijsf:textField binding="#{ABMSolicitudesInternas.uiTxtDescProducto}" columns="50" id="uiTxtDescProducto"/>
                                            <webuijsf:message id="msgProducto" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label for="uiTxtCantidad" id="label3" text="Cant. Solicitud"/>
                                        <h:panelGrid columns="2" id="gridPanelEmail">
                                            <webuijsf:textField binding="#{ABMSolicitudesInternas.uiTxtCantidad}" columns="10" id="uiTxtCantidad"/>
                                            <webuijsf:message for="uiTxtCantidad" id="message3" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label binding="#{ABMSolicitudesInternas.lblEstado}" id="lblEstado" text="Estado"/>
                                        <h:panelGrid binding="#{ABMSolicitudesInternas.gridPanelEstado}" columns="2" id="gridPanelEstado">
                                            <webuijsf:dropDown binding="#{ABMSolicitudesInternas.uiLstEstado}" id="uiLstEstado"
                                                items="#{ABMSolicitudesInternas.uiLstEstadoDefaultOptions.options}"
                                                selected="#{ABMSolicitudesInternas.uiLstEstadoDefaultOptions.selectedValue}" width="100"/>
                                            <webuijsf:message for="uiLstEstado" id="message3esta" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="label2" text="Observación"/>
                                        <h:panelGrid columns="2" id="gridPanelPassword">
                                            <webuijsf:textArea binding="#{ABMSolicitudesInternas.uiTxtObservacion}" columns="50" id="uiTxtObservacion" rows="5"/>
                                            <webuijsf:message for="uiTxtObservacion" id="message2" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <webuijsf:tabSet binding="#{ABMSolicitudesInternas.tabSetDatosAprobacion}" id="tabSetDatosAprobacion" lite="true"
                                        mini="true" selected="tab1" style="height: 144px; width: 479px">
                                        <webuijsf:tab id="tab1" text="Datos de la Aprobación">
                                            <h:panelGrid columns="2" id="palGriApro4">
                                                <webuijsf:label id="lblResponsable" text="Responsable"/>
                                                <webuijsf:textField binding="#{ABMSolicitudesInternas.uiTxtUsuarioAprobacion}" columns="50" disabled="true" id="uiTxtUsuarioAprobacion"/>
                                                <webuijsf:label id="label1" text="Fecha"/>
                                                <webuijsf:textField binding="#{ABMSolicitudesInternas.uiTxtFechaAprobacion}" columns="15" disabled="true" id="uiTxtFechaAprobacion"/>
                                                <webuijsf:label id="label4" text="Cantidad Aprobada"/>
                                                <webuijsf:textField binding="#{ABMSolicitudesInternas.uiTxtCantidadAprobada}" columns="10" disabled="true" id="uiTxtCantidadAprobada"/>
                                            </h:panelGrid>
                                        </webuijsf:tab>
                                    </webuijsf:tabSet>
                                    <h:panelGrid binding="#{ABMSolicitudesInternas.gridPanelButtonDet}" columns="2" id="gridPanelButtonDet" style="direction: rtl; line-height: normal; text-align: right; vertical-align: bottom">
                                        <webuijsf:button actionExpression="#{ABMSolicitudesInternas.uiBtnCancelar_action}"
                                            binding="#{ABMSolicitudesInternas.uiBtnCancelar}" id="uiBtnCancelar" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMSolicitudesInternas.uiBtnGuardarNuevo_action}"
                                            binding="#{ABMSolicitudesInternas.uiBtnGuardarNuevo}" id="uiBtnGuardarNuevo" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMSolicitudesInternas.uiBtnGuardarEditar_action}"
                                            binding="#{ABMSolicitudesInternas.uiBtnGuardarEditar}" id="uiBtnGuardarEditar" rendered="false"
                                            style="font-size: 14px" text="Guardar"/>
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
