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
                            <h:panelGrid binding="#{ABMFormulaSemiTerminado.mainContainer}" id="mainContainer" style="height: 96px; left: 288px; top: 216px; position: absolute; width: 96px">
                                <h:panelGrid binding="#{ABMFormulaSemiTerminado.gridPanelBuscar}" columns="2" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelUserFiltro">
                                        <webuijsf:label id="label1Filtro" text="Formula"/>
                                        <webuijsf:textField binding="#{ABMFormulaSemiTerminado.userNameFiltro}" columns="20" id="userNameFiltro"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Producto"/>
                                        <webuijsf:textField binding="#{ABMFormulaSemiTerminado.emailAddressFiltro}" columns="30" id="emailAddressFiltro"/>
                                    </h:panelGrid>
                                    <webuijsf:button binding="#{ABMFormulaSemiTerminado.buscarButton}" id="buscarButton" text="Buscar"/>
                                    <webuijsf:button binding="#{ABMFormulaSemiTerminado.todosButton}" id="todosButton" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMFormulaSemiTerminado.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                function ABMSolicitudesInternas() {
                                    var table = document.getElementById("form1:table1");
                                    table.ABMSolicitudesInternas();
                                }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMFormulaSemiTerminado.table1}" clearSortButton="true" id="table1"
                                    paginateButton="true" paginationControls="true" sortPanelToggleButton="true" title="Fórmulas de Producción" width="600">
                                    <webuijsf:tableRowGroup binding="#{ABMFormulaSemiTerminado.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMFormulaSemiTerminado.selectedState}"
                                        sourceData="#{ABMFormulaSemiTerminado.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" id="tableColumn5" spacerColumn="true" width="30">
                                            <webuijsf:radioButton id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Código" id="tableColumn2" width="75">
                                            <webuijsf:staticText id="staticText2" text="123"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fórmula" id="tableColumn3" width="425">
                                            <webuijsf:staticText id="staticText3" text="Formula Tapa 20 Hojas"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn4">
                                            <webuijsf:staticText id="staticText4" text="Activo"/>
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
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            target="popup" text="Producto" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelUser">
                                            <webuijsf:textField binding="#{ABMFormulaSemiTerminado.userNameField}" columns="50" id="userNameField"/>
                                            <webuijsf:message id="message1" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="label2" text="Descripcion"/>
                                        <h:panelGrid columns="2" id="gridPanelPassword">
                                            <webuijsf:textArea columns="50" id="textArea1" rows="5"/>
                                            <webuijsf:message id="message2" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label for="emailAddressField" id="label3" text="Cantidad"/>
                                        <h:panelGrid columns="2" id="gridPanelEmail">
                                            <webuijsf:textField binding="#{ABMFormulaSemiTerminado.emailAddressField}" columns="30" id="emailAddressField"/>
                                            <webuijsf:message for="emailAddressField" id="message3" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelfec" text="Fecha Vigencia"/>
                                        <h:panelGrid columns="2" id="gridPanelfecvi">
                                            <webuijsf:calendar dateFormatPattern="dd/MM/yyyy" id="cal1"/>
                                            <webuijsf:message id="message3cal" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelesta" text="Estado"/>
                                        <h:panelGrid columns="2" id="gridPanelestado">
                                            <webuijsf:dropDown id="dropDown1" items="#{ABMFormulaSemiTerminado.dropDown1DefaultOptions.options}" selected="#{ABMFormulaSemiTerminado.dropDown1DefaultOptions.selectedValue}"/>
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
                                            binding="#{ABMFormulaSemiTerminado.updateRecordButton}" id="updateRecordButton" rendered="false"
                                            style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <!-- DETALLE RECURSOS -->
                                    <h:panelGrid id="gridPanelRecursos" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Recursos"/>
                                        <h:panelGrid columns="5" id="gridPanel3" style="height: 48px" width="623">
                                            <webuijsf:hyperlink id="hyperlink2" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                                target="popup" text="Producto" url="/faces/popupproductos.jsp"/>
                                            <webuijsf:textField id="textField1"/>
                                            <webuijsf:label id="label1" text="Cantidad"/>
                                            <webuijsf:textField id="textField2"/>
                                            <webuijsf:button id="button1" text="Agregar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="table2" width="623">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="10"
                                                sourceData="#{ABMFormulaSemiTerminado.defaultTableDataProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Producto" id="tableColumn1" width="89">
                                                    <webuijsf:staticText id="staticText1" text="123"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Descripción Producto" id="tableColumn6">
                                                    <webuijsf:staticText id="staticText5" text="Cola"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Cantidad" id="tableColumn7" width="84">
                                                    <webuijsf:staticText id="staticText6" text="220"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="U. Medida" id="tableColumn8" width="67">
                                                    <webuijsf:staticText id="staticText7" text="Kilos"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn10" width="40">
                                                    <webuijsf:imageHyperlink id="imageHyperlink3" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn9" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMFormulaSemiTerminado.imageHyperlink2_action}"
                                                        id="imageHyperlink2" imageURL="/resources/img/delete.png" text=""/>
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
                                            <webuijsf:textField columns="40" id="txtTarea"/>
                                            <webuijsf:label id="lblCantTarea" text="Cantidad"/>
                                            <webuijsf:textField columns="10" id="txtCantidadTarea"/>
                                            <webuijsf:label id="lblOrden" text="Orden"/>
                                            <webuijsf:textField columns="5" id="txtOrden"/>
                                            <webuijsf:button id="btnAgregarTarea" text="Agregar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="tableTareas" width="623">
                                            <webuijsf:tableRowGroup id="tableTareasRowGroup" rows="10"
                                                sourceData="#{ABMFormulaSemiTerminado.defaultTableDataProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Tarea" id="tableTareasColumn1" width="89">
                                                    <webuijsf:staticText id="staticText8" text="123"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Descripción Tarea" id="tableTareasColumn6">
                                                    <webuijsf:staticText id="staticTextDescTarea" text="Pegado de tapas"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Cantidad" id="tableTareasColumn7" width="75">
                                                    <webuijsf:staticText id="staticTextCantidad" text="220"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Orden" id="tableTareasOrden" width="75">
                                                    <webuijsf:staticText id="staticTxtOrden" text="220"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn11" width="40">
                                                    <webuijsf:imageHyperlink id="imageHyperlink4" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableTareasColumn9" width="40">
                                                    <webuijsf:imageHyperlink id="imageHyperlink1" imageURL="/resources/img/delete.png" text=""/>
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
