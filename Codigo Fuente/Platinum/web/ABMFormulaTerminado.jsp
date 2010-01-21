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
                            <h:panelGrid binding="#{ABMFormulaTerminado.mainContainer}" id="mainContainer" style="height: 96px; left: 288px; top: 216px; position: absolute; width: 96px">
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
                                    <webuijsf:button binding="#{ABMFormulaTerminado.buscarButton}" id="buscarButton" text="Buscar"/>
                                    <webuijsf:button binding="#{ABMFormulaTerminado.todosButton}" id="todosButton" text="Todos"/>
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
                                        id="formulasRW" onClick="javascript:return confirmar()" rows="20" selected="#{ABMFormulaTerminado.selectedState}"
                                        sourceData="#{SessionBean1.listaFormulaCabeceras}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMFormulaTerminado.tableColumn12}" id="tableColumn12"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMFormulaTerminado.radioButton1.id}">
                                            <webuijsf:radioButton binding="#{ABMFormulaTerminado.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMFormulaTerminado.radioButton1.id}" onClick="delSelect='ok'"
                                                selected="#{ABMFormulaTerminado.selected}" selectedValue="#{ABMFormulaTerminado.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="CodFormula" id="tableColumn2" sort="codFormula" width="98">
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
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            target="popup" text="Producto" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelUser">
                                            <webuijsf:textField binding="#{ABMFormulaTerminado.userNameField}" columns="50" id="userNameField"/>
                                            <webuijsf:message id="message1" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="label2" text="Descripcion"/>
                                        <h:panelGrid columns="2" id="gridPanelPassword">
                                            <webuijsf:textArea columns="50" id="textArea1" rows="5"/>
                                            <webuijsf:message id="message2" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label for="emailAddressField" id="label3" text="Cantidad"/>
                                        <h:panelGrid columns="2" id="gridPanelEmail">
                                            <webuijsf:textField binding="#{ABMFormulaTerminado.emailAddressField}" columns="30" id="emailAddressField"/>
                                            <webuijsf:message for="emailAddressField" id="message3" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelfec" text="Fecha Vigencia"/>
                                        <h:panelGrid columns="2" id="gridPanelfecvi">
                                            <webuijsf:calendar dateFormatPattern="dd/MM/yyyy" id="cal1"/>
                                            <webuijsf:message id="message3cal" showDetail="false" showSummary="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelesta" text="Estado"/>
                                        <h:panelGrid columns="2" id="gridPanelestado">
                                            <webuijsf:dropDown id="dropDown1" items="#{ABMFormulaTerminado.dropDown1DefaultOptions.options}" selected="#{ABMFormulaTerminado.dropDown1DefaultOptions.selectedValue}"/>
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
                                            binding="#{ABMFormulaTerminado.updateRecordButton}" id="updateRecordButton" rendered="false" style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Semiterminados"/>
                                        <h:panelGrid columns="5" id="gridPanel3" style="height: 48px" width="551">
                                            <webuijsf:hyperlink id="hyperlink2" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                                target="popup" text="Producto" url="/faces/popupproductos.jsp"/>
                                            <webuijsf:textField id="textField1"/>
                                            <webuijsf:label id="label1" text="Cantidad"/>
                                            <webuijsf:textField id="textField2"/>
                                            <webuijsf:button id="button1" text="Agregar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="table2" width="647">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{ABMFormulaTerminado.defaultTableDataProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Producto" id="tableColumn1" width="89">
                                                    <webuijsf:staticText id="staticText1" text="123"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Producto" id="tableColumn6" width="203">
                                                    <webuijsf:staticText id="staticText5" text="Tapa Dura"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="right" headerText="Cantidad" id="tableColumn7" width="90">
                                                    <webuijsf:staticText id="staticText6" text="220"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="U. Medida" id="tableColumn8" width="78">
                                                    <webuijsf:staticText id="staticText7" text="Litros"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn id="tableColumn9" width="78">
                                                    <webuijsf:hyperlink id="hyperlink3" text="Ver Detalle..."/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn11" width="40">
                                                    <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn10" width="40">
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
