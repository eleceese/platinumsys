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
                            <h:panelGrid binding="#{ABMProveedores.gridPanelBuscar}" columns="3" id="gridPanelBuscar" style="height: 72px" width="599">
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height:30px; width: 60%">
                                    <webuijsf:label id="nombre" text="Nombre"/>
                                    <webuijsf:textField id="nombre1" text="Nombre"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelRUC" style="height:30px; width: 60%">
                                    <webuijsf:label id="ruc3" text="RUC"/>
                                    <webuijsf:textField id="ruc4" text="RUC"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelCedula" style="height:30px; width: 60%">
                                    <webuijsf:label id="ciudad2" text="Ciudad"/>
                                    <webuijsf:textField id="ciudad3" text="Ciudad"/>
                                </h:panelGrid>
                                <webuijsf:button id="buscar" text="Buscar"/>
                                <webuijsf:button id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMProveedores.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" id="tableProveedores" paginateButton="true" paginationControls="true"
                                    sortPanelToggleButton="true" title="Proveedores" width="719">
                                    <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="proveedores" rows="15"
                                        sourceData="#{ABMProveedores.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn id="selec" width="20">
                                            <webuijsf:radioButton id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="RUC" id="ruc" noWrap="true">
                                            <webuijsf:staticText id="staticText1" text="1111122222-2"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nombre" id="nombre4">
                                            <webuijsf:staticText id="staticText2" text="Nombre Nombre"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Direccion" id="direccion">
                                            <webuijsf:staticText id="staticText3" text="Direcion del Cliente Nro 221232212"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Ciudad" id="ciudad">
                                            <webuijsf:staticText id="staticText3" text="Asuncion Asuncion"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Telefono" id="telefono">
                                            <webuijsf:staticText id="staticText4" text="99999-99999-99999"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMProveedores.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 50px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMProveedores.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMProveedores.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMProveedores.eliminar_action}" id="eliminar" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMProveedores.datosProveedores}" id="datosProveedores"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos del Proveedor"/>
                            <br/>
                            <h:panelGrid binding="#{ABMProveedores.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="nombre2" text="Nombre"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProveedores.nombre3}" columns="50" id="nombre3"/>
                                    <webuijsf:message for="nombre3" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="ruc1" text="RUC"/>
                                <h:panelGrid columns="2" id="gridPanel14" style="height: 100%" width="582">
                                    <webuijsf:textField binding="#{ABMProveedores.ruc2}" columns="50" id="ruc2"/>
                                    <webuijsf:message for="ruc2" id="message14" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label6" text="Direccion"/>
                                <h:panelGrid columns="2" id="gridPanel6" style="height: 100%" width="551">
                                    <webuijsf:textArea columns="50" id="textArea1" rows="3" valueChangeListenerExpression="#{ABMProveedores.textArea1_processValueChange}"/>
                                    <webuijsf:message id="message6" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label7" text="Telefono1"/>
                                <h:panelGrid columns="2" id="gridPanel10" style="height: 100%" width="481">
                                    <webuijsf:textField columns="50" id="textField1"/>
                                    <webuijsf:message id="message10" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label1" text="Telefono2"/>
                                <h:panelGrid columns="2" id="gridPanel7" style="width: 100%; height: 100%;">
                                    <webuijsf:textField columns="50" id="textField7"/>
                                    <webuijsf:message id="message7" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="contacto1" text="Contacto 1"/>
                                <h:panelGrid columns="2" id="gridPanel8" style="width: 100%; height: 100%;">
                                    <webuijsf:textField columns="50" id="textField8"/>
                                    <webuijsf:message id="message8" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="contacto3" text="Contacto 2"/>
                                <h:panelGrid columns="2" id="gridPanel5" style="height: 100%" width="575">
                                    <webuijsf:textField columns="50" id="contacto2"/>
                                    <webuijsf:message id="message5" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label11" text="Mail"/>
                                <h:panelGrid columns="2" id="gridPanel13" style="height: 100%" width="575">
                                    <webuijsf:textField columns="50" id="contacto4"/>
                                    <webuijsf:message id="message13" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:hyperlink id="linkCiudad" text="Ciudad"/>
                                <h:panelGrid columns="2" id="gridPanel12" style="height: 100%" width="575">
                                    <webuijsf:textField columns="50" id="textField12"/>
                                    <webuijsf:message id="message12" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="fechaRegistroLab" text="Fecha Registro"/>
                                <h:panelGrid columns="2" id="gridPanel9" style="height: 100%" width="100%">
                                    <webuijsf:calendar id="fechaRegistro"/>
                                    <webuijsf:message id="message9" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMProveedores.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMProveedores.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMProveedores.button2_action}" binding="#{ABMProveedores.button2}" id="button2" text="Guardar"/>
                                <webuijsf:button binding="#{ABMProveedores.button3}" id="button3" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
