<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ABMCliente
    Created on : Oct 18, 2009, 8:11:57 PM
    Author     : FerBoy
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                    <!-- \SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <script>
                        function initAllRows() {
                            var table = document.getElementById("form1:tableProveedores");
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
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 240px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMProveedores.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMProveedores.gridPanelBuscar}" columns="3" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height:30px; width: 60%">
                                    <webuijsf:label id="labelNombre" text="Nombre"/>
                                    <webuijsf:textField binding="#{ABMProveedores.uiNombreFil}" id="uiNombreFil"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelRuc" style="height:30px; width: 60%">
                                    <webuijsf:label id="labelRuc" text="Ruc"/>
                                    <webuijsf:textField binding="#{ABMProveedores.uiRucFil}" id="uiRucFil"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelDireccion" style="height:30px; width: 60%">
                                    <webuijsf:label id="labelDireccion" text="Direccion"/>
                                    <webuijsf:textField binding="#{ABMProveedores.uiDireccionFil}" id="uiDireccionFil"/>
                                </h:panelGrid>
                                <webuijsf:button actionExpression="#{ABMProveedores.buscar_action}" id="buscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMProveedores.todos_action}" id="todos" style="height: 24px" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMProveedores.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMProveedores.tableProveedores}" id="tableProveedores" paginateButton="true"
                                    paginationControls="true" sortPanelToggleButton="true" title="Proveedores" width="863">
                                    <webuijsf:tableRowGroup binding="#{ABMProveedores.uiTablaProveedoresRW}" emptyDataMsg="No se encontraron registros..."
                                        id="uiTablaProveedoresRW" rows="10" selected="#{ABMProveedores.selectedState}"
                                        sourceData="#{SessionBean1.listaProveedores}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMProveedores.tableColumn6}" id="tableColumn6"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMProveedores.radioButton1.id}">
                                            <webuijsf:radioButton binding="#{ABMProveedores.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMProveedores.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMProveedores.selected}" selectedValue="#{ABMProveedores.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="tableColumn1" sort="codProveedor" width="112">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProveedor']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nombre" id="tableColumn2" sort="nombreProveedor" width="214">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['nombreProveedor']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="RUC" id="tableColumn3" sort="rucProveedor" width="97">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['rucProveedor']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Direccion" id="tableColumn4" sort="direccionProveedor" width="238">
                                            <webuijsf:staticText id="staticText4" text="#{currentRow.value['direccionProveedor']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Contacto" id="tableColumn5" sort="contactoProveedor">
                                            <webuijsf:staticText id="staticText5" text="#{currentRow.value['contactoProveedor']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMProveedores.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMProveedores.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMProveedores.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMProveedores.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{ABMProveedores.datosProveedor}" id="datosProveedor"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos del Proveedor"/>
                            <br/>
                            <h:panelGrid binding="#{ABMProveedores.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelNombre1" text="Nombre"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProveedores.uiNombre}" columns="50" id="uiNombre"/>
                                    <webuijsf:message for="uiNombre" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelRuc1" text="RUC"/>
                                <h:panelGrid columns="2" id="gridPanel2" style="height: 100%" width="582">
                                    <webuijsf:textField binding="#{ABMProveedores.uiRuc}" columns="50" id="uiRuc" valueChangeListenerExpression="#{ABMProveedores.uiRuc_processValueChange}"/>
                                    <webuijsf:message for="uiRuc" id="message4" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label1" text="Direccion"/>
                                <h:panelGrid columns="2" id="gridPanel3" style="height: 100%" width="551">
                                    <webuijsf:textArea binding="#{ABMProveedores.uiDireccion}" columns="50" id="uiDireccion" rows="3" valueChangeListenerExpression="#{ABMProveedores.uiDireccion_processValueChange}"/>
                                    <webuijsf:message for="uiDireccion" id="message5" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label2" text="Telefono1"/>
                                <h:panelGrid columns="2" id="gridPanel4" style="height: 100%" width="481">
                                    <webuijsf:textField binding="#{ABMProveedores.uiTelefono}" columns="50" id="uiTelefono"/>
                                    <webuijsf:message for="uiTelefono" id="message6" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label3" text="Telefono2"/>
                                <h:panelGrid columns="2" id="gridPanel5" style="width: 100%; height: 100%;">
                                    <webuijsf:textField binding="#{ABMProveedores.uiTelefono2}" columns="50" id="uiTelefono2"/>
                                    <webuijsf:message id="message7" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelContacto1" text="Contacto"/>
                                <h:panelGrid columns="2" id="uiContacto1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProveedores.uiContacto}" columns="50" id="uiContacto"/>
                                    <webuijsf:message for="uiContacto" id="message8" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label4" text="Mail"/>
                                <h:panelGrid columns="2" id="gridPanel6" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProveedores.uiMail}" columns="50" id="uiMail"/>
                                    <webuijsf:message id="message9" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:hyperlink id="linkCiudad1" text="Ciudad"/>
                                <h:panelGrid columns="2" id="uiMail2" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProveedores.uiCiudad1}" columns="50" id="uiCiudad1"/>
                                    <webuijsf:message id="message10" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelFecha1" text="Fecha Registro"/>
                                <h:panelGrid columns="2" id="gridPanel7" style="height: 100%" width="100%">
                                    <webuijsf:calendar binding="#{ABMProveedores.uiFechaAlta}" id="uiFechaAlta"/>
                                    <webuijsf:message for="uiFechaAlta" id="message11" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMProveedores.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMProveedores.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMProveedores.buttonGuardarNuevo_action}" binding="#{ABMProveedores.buttonGuardarNuevo}"
                                    id="buttonGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMProveedores.buttonGuardarEdicion_action}"
                                    binding="#{ABMProveedores.buttonGuardarEdicion}" id="buttonGuardarEdicion" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
