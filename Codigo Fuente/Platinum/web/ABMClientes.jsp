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
                            <webuijsf:pageAlert binding="#{ABMClientes.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMClientes.gridPanelBuscar}" columns="3" id="gridPanelBuscar" style="height: 72px" width="599">
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height:30px; width: 60%">
                                    <webuijsf:label id="nombre" text="Nombre"/>
                                    <webuijsf:textField id="nombre1" text="Nombre"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelApellido" style="height:30px; width: 60%">
                                    <webuijsf:label id="apellido" text="Apellido"/>
                                    <webuijsf:textField id="apellido1" text="Apellido"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelCedula" style="height:30px; width: 60%">
                                    <webuijsf:label id="cedula" text="C.I.N.:"/>
                                    <webuijsf:textField id="cedula1" text="Cedula"/>
                                </h:panelGrid>
                                <webuijsf:button id="buscar" text="Buscar"/>
                                <webuijsf:button id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMClientes.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" id="tableClientes" paginateButton="true" paginationControls="true"
                                    sortPanelToggleButton="true" title="Clientes" width="530">
                                    <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="Empleados" rows="15"
                                        sourceData="#{ABMClientes.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn id="selec" width="20">
                                            <webuijsf:radioButton id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="RUC" id="ruc" noWrap="true">
                                            <webuijsf:staticText id="staticText1" text="12321"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nombre" id="nombre4">
                                            <webuijsf:staticText id="staticText2" text="Apellido Apellido"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Direccion" id="direccion">
                                            <webuijsf:staticText id="staticText3" text="Direcion del Cliente Nro 221232212"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Ciudad" id="ciudad">
                                            <webuijsf:staticText id="staticText3" text="Asuncion Asuncion"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMClientes.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 50px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMClientes.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMClientes.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMClientes.eliminar_action}" id="eliminar" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMClientes.datosClientes}" id="datosClientes"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos del Cliente"/>
                            <br/>
                            <h:panelGrid binding="#{ABMClientes.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="nombre2" text="Nombre"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMClientes.nombre3}" columns="50" id="nombre3"/>
                                    <webuijsf:message for="nombre3" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label2" text="Apellido"/>
                                <h:panelGrid columns="2" id="gridPanel3" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMClientes.apellido2}" columns="50" id="apellido2"/>
                                    <webuijsf:message for="apellido2" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="tipoDoc" text="Tipo y Nro Doc:"/>
                                <h:panelGrid columns="3" id="gridPanel4" style="height: 100%" width="335">
                                    <webuijsf:dropDown binding="#{ABMClientes.tipoDoc1}" id="tipoDoc1" items="#{ABMClientes.tipoDoc1DefaultOptions.options}" width="150px"/>
                                    <webuijsf:textField binding="#{ABMClientes.documento}" id="documento"/>
                                    <webuijsf:message id="message4" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label4" text="Sexo"/>
                                <h:panelGrid columns="2" id="gridPanel2" style="width: 100%; height: 100%;">
                                    <webuijsf:dropDown id="dropDown1" items="#{ABMClientes.dropDown1DefaultOptions.options}" width="200px"/>
                                    <webuijsf:message for="dropDown1" id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="ruc1" text="RUC"/>
                                <h:panelGrid columns="2" id="gridPanel14" style="height: 100%" width="582">
                                    <webuijsf:textField columns="50" id="ruc2"/>
                                    <webuijsf:message id="message14" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label6" text="Direccion"/>
                                <h:panelGrid columns="2" id="gridPanel6" style="height: 100%" width="551">
                                    <webuijsf:textArea columns="50" id="textArea1" rows="3"/>
                                    <webuijsf:message id="message6" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label7" text="Telefono1"/>
                                <h:panelGrid columns="2" id="gridPanel10" style="height: 100%" width="481">
                                    <webuijsf:textField columns="50" id="ciudad1"/>
                                    <webuijsf:message id="message10" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label1" text="Telefono2"/>
                                <h:panelGrid columns="2" id="gridPanel7" style="width: 100%; height: 100%;">
                                    <webuijsf:textField columns="50" id="textField7"/>
                                    <webuijsf:message id="message7" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label11" text="Mail"/>
                                <h:panelGrid columns="2" id="gridPanel8" style="width: 100%; height: 100%;">
                                    <webuijsf:textField columns="50" id="textField8"/>
                                    <webuijsf:message id="message8" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="contacto1" text="Contacto 1"/>
                                <h:panelGrid columns="2" id="gridPanel12" style="height: 100%" width="575">
                                    <webuijsf:textField columns="50" id="textField12"/>
                                    <webuijsf:message id="message12" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="contacto3" text="Contacto 2"/>
                                <h:panelGrid columns="2" id="gridPanel5" style="height: 100%" width="575">
                                    <webuijsf:textField columns="50" id="contacto2"/>
                                    <webuijsf:message for="nombre3" id="message5" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="fechaRegistroLab" text="Fecha Registro"/>
                                <h:panelGrid columns="2" id="gridPanel13" style="height: 100%" width="575">
                                    <webuijsf:textField columns="50" id="contacto4"/>
                                    <webuijsf:message for="nombre3" id="message13" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:hyperlink id="linkCiudad" text="Ciudad"/>
                                <h:panelGrid columns="2" id="gridPanel9" style="height: 100%" width="100%">
                                    <webuijsf:calendar id="fechaRegistro"/>
                                    <webuijsf:message id="message9" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMClientes.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMClientes.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMClientes.button2_action}" binding="#{ABMClientes.button2}" id="button2" text="Guardar"/>
                                <webuijsf:button binding="#{ABMClientes.button3}" id="button3" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
