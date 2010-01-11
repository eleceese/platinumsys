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
                <webuijsf:body focus="form1:userNameFiltro" id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <div>
                            <h:panelGrid binding="#{ABMSolicitudesInternasAprobacion.mainContainer}" id="mainContainer" style=" left: 264px; top: 216px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMSolicitudesInternasAprobacion.gridPanelBuscar}" columns="2" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelUserFiltro">
                                        <webuijsf:label id="label1Filtro" text="Responsable"/>
                                        <webuijsf:textField binding="#{ABMSolicitudesInternasAprobacion.userNameFiltro}" columns="40" id="userNameFiltro"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Producto"/>
                                        <webuijsf:textField binding="#{ABMSolicitudesInternasAprobacion.emailAddressFiltro}" columns="40" id="emailAddressFiltro"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecDesde">
                                        <webuijsf:label id="lblFecDesde" text="Fec. Desde"/>
                                        <webuijsf:calendar dateFormatPattern="dd/MM/yyyy" id="fechaDesde"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecHasta">
                                        <webuijsf:label id="lblFecHasta" text="Fecha Hasta"/>
                                        <webuijsf:calendar dateFormatPattern="dd/MM/yyyy" id="fechaHasta"/>
                                    </h:panelGrid>
                                    <webuijsf:button binding="#{ABMSolicitudesInternasAprobacion.buscarButton}" id="buscarButton" text="Buscar"/>
                                    <webuijsf:button binding="#{ABMSolicitudesInternasAprobacion.todosButton}" id="todosButton" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMSolicitudesInternasAprobacion.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                    function ABMFormula() {
                                        var table = document.getElementById("form1:table1");
                                        table.ABMFormula();
                                    }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMSolicitudesInternasAprobacion.table1}" clearSortButton="true" id="table1"
                                    paginateButton="true" paginationControls="true" sortPanelToggleButton="true" title="Solicitudes Internas" width="600">
                                    <webuijsf:tableRowGroup binding="#{ABMSolicitudesInternasAprobacion.tableRowGroup1}"
                                        emptyDataMsg="No se recupero ningun registro..." id="tableRowGroup1" rows="10"
                                        selected="#{ABMSolicitudesInternasAprobacion.selectedState}"
                                        sourceData="#{ABMSolicitudesInternasAprobacion.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" id="tableColumn5" spacerColumn="true" width="30">
                                            <webuijsf:radioButton id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Solicitud" id="tableColumn2" width="75">
                                            <webuijsf:staticText id="staticText2" text="123"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Responsable" id="tableColumn3" width="425">
                                            <webuijsf:staticText id="staticText3" text="Formula Tapa 20 Hojas"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn4">
                                            <webuijsf:staticText id="staticText4" text="Pendiente"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMSolicitudesInternasAprobacion.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMSolicitudesInternasAprobacion.updateButton_action}"
                                        binding="#{ABMSolicitudesInternasAprobacion.updateButton}" id="updateButton" text="Ver Detalle"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMSolicitudesInternasAprobacion.addUpdatePanel}" columns="1" id="addUpdatePanel" style="height: 468px">
                                    <h:panelGrid columns="2" id="detalle">
                                        <webuijsf:label id="hlkResponsable" text="Solicitante"/>
                                        <webuijsf:textField columns="50" disabled="true" id="txtResponsable"/>
                                        <webuijsf:label id="labelfec" text="Fecha"/>
                                        <webuijsf:textField columns="15" disabled="true" id="txtFecha"/>
                                        <webuijsf:label id="lblProducto" text="Producto"/>
                                        <webuijsf:textField columns="50" disabled="true" id="txtProducto"/>
                                        <webuijsf:label id="lblCantSol" text="Cant. Solicitud"/>
                                        <webuijsf:textField columns="10" disabled="true" id="txtCantSolicitud"/>
                                        <webuijsf:label id="label2" text="Observación Solicitud"/>
                                        <webuijsf:textArea columns="50" id="textArea1" rows="5"/>
                                    </h:panelGrid>
                                    <webuijsf:tabSet binding="#{ABMSolicitudesInternasAprobacion.tabSetDatosAprobacion}" id="tabSetDatosAprobacion" lite="true"
                                        mini="true" selected="tab1" style="height: 262px; width: 599px">
                                        <webuijsf:tab id="tab1" text="Datos de la Aprobación">
                                            <h:panelGrid columns="2" id="palGriApro4" style="height: 200px" width="599px">
                                                <webuijsf:label id="lblResponsable" text="Responsable"/>
                                                <webuijsf:textField columns="40" disabled="true" id="txtNomRespApro"/>
                                                <webuijsf:label id="label1" text="Fecha"/>
                                                <webuijsf:textField columns="15" disabled="true" id="textField1"/>
                                                <webuijsf:label id="lblEstado" text="Estado"/>
                                                <webuijsf:radioButtonGroup columns="3" id="radioButtonGroup1"
                                                    items="#{ABMSolicitudesInternasAprobacion.radioButtonGroup1DefaultOptions.options}" selected="#{ABMSolicitudesInternasAprobacion.radioButtonGroup1DefaultOptions.selectedValue}"/>
                                                <webuijsf:label id="label4" text="Cantidad Aprobada"/>
                                                <webuijsf:textField columns="10" id="txtCantAprobada"/>
                                                <webuijsf:label id="label2" text="Observación"/>
                                                <h:panelGrid columns="2" id="gridPanelPassword">
                                                    <webuijsf:textArea columns="40" id="textArea1" rows="5"/>
                                                    <webuijsf:message id="message2" showDetail="false" showSummary="true"/>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </webuijsf:tab>
                                    </webuijsf:tabSet>
                                    <h:panelGrid binding="#{ABMSolicitudesInternasAprobacion.gridPanelButtonDet}" columns="2" id="gridPanelButtonDet" style="direction: rtl; line-height: normal; text-align: right; vertical-align: bottom">
                                        <webuijsf:button actionExpression="#{ABMSolicitudesInternasAprobacion.cancelButton_action}"
                                            binding="#{ABMSolicitudesInternasAprobacion.cancelButton}" id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMSolicitudesInternasAprobacion.addRecordButton_action}"
                                            binding="#{ABMSolicitudesInternasAprobacion.addRecordButton}" id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMSolicitudesInternasAprobacion.updateRecordButton_action}"
                                            binding="#{ABMSolicitudesInternasAprobacion.updateRecordButton}" id="updateRecordButton" rendered="false"
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
