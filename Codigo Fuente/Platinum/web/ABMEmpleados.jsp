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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 216px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMEmpleados.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMEmpleados.gridPanelBuscar}" columns="3" id="gridPanelBuscar" style="height: 72px" width="599">
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
                            <h:panelGrid binding="#{ABMEmpleados.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" id="tableEmpleados" paginateButton="true" paginationControls="true"
                                    sortPanelToggleButton="true" title="Empleados" width="530">
                                    <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="Empleados" rows="15"
                                        sourceData="#{ABMEmpleados.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn id="selec" width="20">
                                            <webuijsf:radioButton id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Id" id="Id" sort="column1">
                                            <webuijsf:staticText id="staticText1" text="12321"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Apellido" id="Apellido">
                                            <webuijsf:staticText id="staticText2" text="Apellido Apellido"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nombre" id="Nombre" sort="Nombre">
                                            <webuijsf:staticText id="staticText3" text="Nombre Nombre"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cedula" id="Cedula">
                                            <webuijsf:staticText id="staticText3" text="9.999.999"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMEmpleados.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 50px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMEmpleados.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMEmpleados.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMEmpleados.eliminar_action}" id="eliminar" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMEmpleados.datosEmpleado1}" id="datosEmpleado1"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos del Empleado"/>
                            <br/>
                            <h:panelGrid binding="#{ABMEmpleados.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="nombre2" text="Nombre"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMEmpleados.nombre3}" columns="50" id="nombre3"/>
                                    <webuijsf:message for="nombre3" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label2" text="Apellido"/>
                                <h:panelGrid columns="2" id="gridPanel3" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMEmpleados.apellido2}" columns="50" id="apellido2"/>
                                    <webuijsf:message for="apellido2" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label3" text="Documento N.:"/>
                                <h:panelGrid columns="2" id="gridPanel4" style="height: 100%" width="311">
                                    <webuijsf:textField columns="10" id="textField4"/>
                                    <webuijsf:message id="message4" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label4" text="Sexo"/>
                                <h:panelGrid columns="2" id="gridPanel2" style="width: 100%; height: 100%;">
                                    <webuijsf:dropDown id="dropDown1" items="#{ABMEmpleados.dropDown1DefaultOptions.options}" width="200px"/>
                                    <webuijsf:message for="dropDown1" id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label5" text="Nacionalidad"/>
                                <h:panelGrid columns="2" id="gridPanel5" style="width: 100%; height: 100%;">
                                    <webuijsf:textField columns="50" id="textField5"/>
                                    <webuijsf:message id="message5" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label6" text="Direccion"/>
                                <h:panelGrid columns="2" id="gridPanel6" style="height: 100%" width="551">
                                    <webuijsf:textArea columns="50" id="textArea1" rows="3"/>
                                    <webuijsf:message id="message6" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label7" text="Telefono1"/>
                                <h:panelGrid columns="2" id="gridPanel7" style="width: 100%; height: 100%;">
                                    <webuijsf:textField columns="50" id="textField7"/>
                                    <webuijsf:message id="message7" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label1" text="Telefono2"/>
                                <h:panelGrid columns="2" id="gridPanel8" style="width: 100%; height: 100%;">
                                    <webuijsf:textField columns="50" id="textField8"/>
                                    <webuijsf:message id="message8" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label8" text="Fecha Nacimiento"/>
                                <h:panelGrid columns="2" id="gridPanel9" style="height: 100%" width="100%">
                                    <webuijsf:calendar id="calendar1"/>
                                    <webuijsf:message id="message9" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label9" text="Cargo"/>
                                <h:panelGrid columns="2" id="gridPanel10" style="height: 100%" width="481">
                                    <webuijsf:dropDown id="dropDown2" items="#{ABMEmpleados.dropDown2DefaultOptions.options}" width="200px"/>
                                    <webuijsf:message id="message10" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label10" text="Seccion"/>
                                <h:panelGrid columns="2" id="gridPanel11" style="height: 100%" width="479">
                                    <webuijsf:dropDown id="dropDown3" items="#{ABMEmpleados.dropDown3DefaultOptions.options}" width="200"/>
                                    <webuijsf:message id="message11" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label11" text="Mail"/>
                                <h:panelGrid columns="2" id="gridPanel12" style="height: 100%" width="575">
                                    <webuijsf:textField columns="50" id="textField12"/>
                                    <webuijsf:message id="message12" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label13" text="IPS"/>
                                <h:panelGrid columns="2" id="gridPanel14" style="height: 100%" width="582">
                                    <webuijsf:textField columns="50" id="textField14"/>
                                    <webuijsf:message id="message14" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label14" text="Cant hijos"/>
                                <h:panelGrid columns="2" id="gridPanel15" style="width: 100%; height: 100%;">
                                    <webuijsf:textField columns="5" id="textField15"/>
                                    <webuijsf:message id="message15" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label15" text="Salario"/>
                                <h:panelGrid columns="2" id="gridPanel16" style="width: 100%; height: 100%;">
                                    <webuijsf:textField id="textField16"/>
                                    <webuijsf:message id="message16" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMEmpleados.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMEmpleados.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMEmpleados.button2_action}" binding="#{ABMEmpleados.button2}" id="button2" text="Guardar"/>
                                <webuijsf:button binding="#{ABMEmpleados.button3}" id="button3" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
