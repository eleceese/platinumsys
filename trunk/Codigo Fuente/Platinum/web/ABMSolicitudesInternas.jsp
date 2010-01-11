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
                            <h:panelGrid binding="#{ABMSolicitudesInternas.mainContainer}" id="mainContainer" style="height: 96px; left: 264px; top: 216px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMSolicitudesInternas.gridPanelBuscar}" columns="2" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelUserFiltro">
                                        <webuijsf:label id="label1Filtro" text="Responsable"/>
                                        <webuijsf:textField binding="#{ABMSolicitudesInternas.userNameFiltro}" columns="40" id="userNameFiltro"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Producto"/>
                                        <webuijsf:textField binding="#{ABMSolicitudesInternas.emailAddressFiltro}" columns="40" id="emailAddressFiltro"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecDesde">
                                        <webuijsf:label id="lblFecDesde" text="Fecha Desde"/>
                                        <webuijsf:calendar dateFormatPattern="dd/MM/yyyy" id="fechaDesde"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecHasta">
                                        <webuijsf:label id="lblFecHasta" text="Fecha Hasta"/>
                                        <webuijsf:calendar dateFormatPattern="dd/MM/yyyy" id="fechaHasta"/>
                                    </h:panelGrid>
                                    <webuijsf:button binding="#{ABMSolicitudesInternas.buscarButton}" id="buscarButton" text="Buscar"/>
                                    <webuijsf:button binding="#{ABMSolicitudesInternas.todosButton}" id="todosButton" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMSolicitudesInternas.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                    function ABMSolicitudesInternasAprobacion() {
                                        var table = document.getElementById("form1:table1");
                                        table.ABMSolicitudesInternasAprobacion();
                                    }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMSolicitudesInternas.table1}" clearSortButton="true" id="table1"
                                    paginateButton="true" paginationControls="true" sortPanelToggleButton="true" title="Solicitudes Internas" width="600">
                                    <webuijsf:tableRowGroup binding="#{ABMSolicitudesInternas.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMSolicitudesInternas.selectedState}"
                                        sourceData="#{ABMSolicitudesInternas.defaultTableDataProvider}" sourceVar="currentRow">
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
                                            <webuijsf:staticText id="staticText4" text="Activo"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMSolicitudesInternas.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMSolicitudesInternas.addButton_action}" binding="#{ABMSolicitudesInternas.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMSolicitudesInternas.updateButton_action}"
                                        binding="#{ABMSolicitudesInternas.updateButton}" id="updateButton" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMSolicitudesInternas.deleteButton_action}"
                                        binding="#{ABMSolicitudesInternas.deleteButton}" id="deleteButton" text="Eliminar"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMSolicitudesInternas.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid columns="2" id="detalle">
                                        <webuijsf:hyperlink id="hlkResponsable" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            target="popup" text="Solicitante" url="/faces/popupEmpleados.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelResponsable">
                                            <webuijsf:textField columns="50" id="txtResponsable"/>
                                            <webuijsf:message id="message1" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelfec" text="Fecha"/>
                                        <h:panelGrid columns="2" id="gridPanelfecvi">
                                            <webuijsf:calendar dateFormatPattern="dd/MM/yyyy" id="cal1"/>
                                            <webuijsf:message id="message3cal" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            target="popup" text="Producto" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelUser">
                                            <webuijsf:textField binding="#{ABMSolicitudesInternas.userNameField}" columns="50" id="userNameField"/>
                                            <webuijsf:message id="msgProducto" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label for="emailAddressField" id="label3" text="Cant. Solicitud"/>
                                        <h:panelGrid columns="2" id="gridPanelEmail">
                                            <webuijsf:textField binding="#{ABMSolicitudesInternas.emailAddressField}" columns="10" id="emailAddressField"/>
                                            <webuijsf:message for="emailAddressField" id="message3" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelesta" text="Estado"/>
                                        <h:panelGrid columns="2" id="gridPanelestado">
                                            <webuijsf:dropDown id="dropDown1" items="#{ABMSolicitudesInternas.dropDown1DefaultOptions.options}" selected="#{ABMSolicitudesInternas.dropDown1DefaultOptions.selectedValue}"/>
                                            <webuijsf:message id="message3esta" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="label2" text="Observación"/>
                                        <h:panelGrid columns="2" id="gridPanelPassword">
                                            <webuijsf:textArea columns="50" id="textArea1" rows="5"/>
                                            <webuijsf:message id="message2" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <webuijsf:tabSet binding="#{ABMSolicitudesInternas.tabSetDatosAprobacion}" id="tabSetDatosAprobacion" lite="true"
                                        mini="true" selected="tab1" style="height: 144px; width: 479px">
                                        <webuijsf:tab id="tab1" text="Datos de la Aprobación">
                                            <h:panelGrid columns="2" id="palGriApro4">
                                                <webuijsf:label id="lblResponsable" text="Responsable"/>
                                                <webuijsf:textField columns="40" disabled="true" id="txtNomRespApro"/>
                                                <webuijsf:label id="label1" text="Fecha"/>
                                                <webuijsf:textField columns="15" disabled="true" id="textField1"/>
                                                <webuijsf:label id="label4" text="Cantidad Aprobada"/>
                                                <webuijsf:textField columns="10" disabled="true" id="textField2"/>
                                            </h:panelGrid>
                                        </webuijsf:tab>
                                    </webuijsf:tabSet>
                                    <h:panelGrid binding="#{ABMSolicitudesInternas.gridPanelButtonDet}" columns="2" id="gridPanelButtonDet" style="direction: rtl; line-height: normal; text-align: right; vertical-align: bottom">
                                        <webuijsf:button actionExpression="#{ABMSolicitudesInternas.cancelButton_action}"
                                            binding="#{ABMSolicitudesInternas.cancelButton}" id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMSolicitudesInternas.addRecordButton_action}"
                                            binding="#{ABMSolicitudesInternas.addRecordButton}" id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMSolicitudesInternas.updateRecordButton_action}"
                                            binding="#{ABMSolicitudesInternas.updateRecordButton}" id="updateRecordButton" rendered="false"
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
