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
                        function ABMProvs() {
                            var table = document.getElementById("form1:uiProveedores");
                            table.ABMProvs();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar el Producto seleccionado?")) {
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
                            <webuijsf:pageAlert binding="#{ABMProvs.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMProvs.gridPanelBuscar}" columns="3" id="gridPanelBuscar" style="height: 72px" width="599">
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height:30px; width: 60%">
                                    <webuijsf:label binding="#{ABMProvs.labelNombreFil}" id="labelNombreFil" text="Nombre"/>
                                    <webuijsf:textField binding="#{ABMProvs.uiNombreFil}" id="uiNombreFil"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelRUC" style="height:30px; width: 60%">
                                    <webuijsf:label binding="#{ABMProvs.labelRucFil}" id="labelRucFil" text="RUC"/>
                                    <webuijsf:textField binding="#{ABMProvs.uiRucFil}" id="uiRucFil"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelCedula" style="height:30px; width: 60%">
                                    <webuijsf:label binding="#{ABMProvs.labelCiudadFil}" id="labelCiudadFil" text="Direccion"/>
                                    <webuijsf:textField binding="#{ABMProvs.uiDireccionFil}" id="uiDireccionFil"/>
                                </h:panelGrid>
                                <webuijsf:button id="buscar" text="Buscar"/>
                                <webuijsf:button id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMProvs.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMProvs.uiProveedores}" id="uiProveedores" paginateButton="true"
                                    paginationControls="true" sortPanelToggleButton="true" title="Proveedores" width="1012">
                                    <webuijsf:tableRowGroup binding="#{ABMProvs.proveedoresRW}" emptyDataMsg="No se encontraron registros..." id="proveedoresRW"
                                        rows="15" sourceData="#{SessionBean1.listaProveedores}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMProvs.columnaDelRadio}" id="columnaDelRadio">
                                            <webuijsf:radioButton binding="#{ABMProvs.radioSeleccionado}" id="radioSeleccionado" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="tableColumn1" sort="codProveedor" width="74">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProveedor']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nombre" id="tableColumn5" sort="nombreProveedor" width="244">
                                            <webuijsf:staticText id="staticText5" text="#{currentRow.value['nombreProveedor']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="RUC" id="tableColumn2" sort="rucProveedor" width="120">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['rucProveedor']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Direccion" id="tableColumn3" sort="direccionProveedor">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['direccionProveedor']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Contacto" id="tableColumn4" sort="contactoProveedor" width="213">
                                            <webuijsf:staticText id="staticText4" text="#{currentRow.value['contactoProveedor']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMProvs.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 50px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMProvs.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMProvs.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMProvs.eliminar_action}" id="eliminar" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMProvs.datosProveedores}" id="datosProveedores"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos del Proveedor"/>
                            <br/>
                            <h:panelGrid binding="#{ABMProvs.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelNombre" text="Nombre"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProvs.uiNombre1}" columns="50" id="uiNombre1"/>
                                    <webuijsf:message for="uiNombre1" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelRuc" text="RUC"/>
                                <h:panelGrid columns="2" id="gridPanel14" style="height: 100%" width="582">
                                    <webuijsf:textField binding="#{ABMProvs.uiRuc1}" columns="50" id="uiRuc1" valueChangeListenerExpression="#{ABMProvs.uiRuc1_processValueChange}"/>
                                    <webuijsf:message for="uiRuc1" id="message14" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label6" text="Direccion"/>
                                <h:panelGrid columns="2" id="gridPanel6" style="height: 100%" width="551">
                                    <webuijsf:textArea binding="#{ABMProvs.uiDireccion1}" columns="50" id="uiDireccion1" rows="3" valueChangeListenerExpression="#{ABMProvs.uiDireccion1_processValueChange}"/>
                                    <webuijsf:message id="message6" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label7" text="Telefono1"/>
                                <h:panelGrid columns="2" id="gridPanel10" style="height: 100%" width="481">
                                    <webuijsf:textField binding="#{ABMProvs.uiTelefono1}" columns="50" id="uiTelefono1"/>
                                    <webuijsf:message id="message10" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label1" text="Telefono2"/>
                                <h:panelGrid columns="2" id="gridPanel7" style="width: 100%; height: 100%;">
                                    <webuijsf:textField binding="#{ABMProvs.uiTelefono3}" columns="50" id="uiTelefono3"/>
                                    <webuijsf:message id="message7" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelContacto" text="Contacto"/>
                                <h:panelGrid columns="2" id="uiContacto1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProvs.uiContactoProv1}" columns="50" id="uiContactoProv1"/>
                                    <webuijsf:message id="message5" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label11" text="Mail"/>
                                <h:panelGrid columns="2" id="gridPanel13" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProvs.uiMail2}" columns="50" id="uiMail2"/>
                                    <webuijsf:message id="message13" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:hyperlink id="linkCiudad" text="Ciudad"/>
                                <h:panelGrid columns="2" id="uiMail1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProvs.uiCiudad}" columns="50" id="uiCiudad"/>
                                    <webuijsf:message id="message12" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelFecha" text="Fecha Registro"/>
                                <h:panelGrid columns="2" id="gridPanel9" style="height: 100%" width="100%">
                                    <webuijsf:calendar binding="#{ABMProvs.uiFechaAlta1}" id="uiFechaAlta1"/>
                                    <webuijsf:message id="message9" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMProvs.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMProvs.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMProvs.button2_action}" binding="#{ABMProvs.button2}" id="button2" text="Guardar"/>
                                <webuijsf:button binding="#{ABMProvs.button3}" id="button3" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
