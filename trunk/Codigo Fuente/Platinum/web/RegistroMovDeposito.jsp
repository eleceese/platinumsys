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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 240px; top: 240px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{RegistroMovDeposito.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid id="gridPanelBuscar" style="width: 100%; height: 100%;">
                                <h:panelGrid columns="6" id="gridPanelFiltro" style="height: 100%" width="743">
                                    <webuijsf:label id="labelFecha" text="Fecha"/>
                                    <webuijsf:calendar id="calendar2"/>
                                    <webuijsf:label id="labelDep" text="Deposito"/>
                                    <webuijsf:dropDown id="dropDown1" items="#{SessionBean1.listaDepositos}"/>
                                    <webuijsf:label id="labelTIpo" text="Tipo"/>
                                    <webuijsf:dropDown id="estado2" items="#{RegistroMovDeposito.estado2DefaultOptions.options}" width="150px"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanel2">
                                    <webuijsf:button id="buscar" text="Buscar"/>
                                    <webuijsf:button id="todos" text="Todos"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanelTabla1" style="width: 100%; height: 100%;">
                                    <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true"
                                        title="Momimientos en Deposito" width="767">
                                        <webuijsf:tableRowGroup id="tableRowGroup1" rows="10" sourceData="#{RegistroMovDeposito.defaultTableDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn headerText="Fecha Mov" id="tableColumn4">
                                                <webuijsf:staticText id="staticText3" text="01-01-2001"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Deposito" id="tableColumn5" width="148">
                                                <webuijsf:staticText id="staticText5" text="Deposito Central"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Tipo Mov" id="tableColumn6" sort="column3" width="147">
                                                <webuijsf:staticText id="staticText6" text="Entrada / Salida"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Observacion" id="tableColumn7" width="317">
                                                <webuijsf:staticText id="staticText7" text="Observacion"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                                <h:panelGrid columns="3" id="gridPanel3">
                                    <webuijsf:button id="nuevo" text="Nuevo"/>
                                    <webuijsf:button id="todos2" text="Anular"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid id="gridPanelCabeceera" style="width: 100%; height: 100%;">
                                <h:panelGrid binding="#{RegistroMovDeposito.gridPanelCabecera}" columns="2" id="gridPanelCabecera" style="height: 72px" width="599">
                                    <h:panelGrid columns="4" id="gridPanelDatos1" style="height: 30px" width="503">
                                        <webuijsf:label id="nroDeposito" text="NRO:"/>
                                        <webuijsf:textField id="nroDeposito1"
                                            style="color: rgb(204, 0, 0); font-family: 'Arial','Helvetica',sans-serif; font-weight: bolder" text="123123132-1"/>
                                        <webuijsf:label id="fecha" text="Fecha"/>
                                        <webuijsf:calendar id="calendar1"/>
                                        <webuijsf:label id="deposito" text="Deposito"/>
                                        <webuijsf:dropDown id="deposito2" items="#{RegistroMovDeposito.deposito2DefaultOptions.options}" width="150px"/>
                                        <webuijsf:label id="estado1" text="Estado"/>
                                        <webuijsf:dropDown id="estado" items="#{RegistroMovDeposito.estadoDefaultOptions.options}" width="150px"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="1" id="gridPanelDatos2"
                                        style="border-width: 1px; border-style: solid; background-position: 50%,50%; height: 90px; left: 1px; right: 1px; text-align: center; vertical-align: top; z-index: 1" width="240">
                                        <webuijsf:label id="tipo_de_Movimiento" style="font-size: 16px; height: 300px; width: 100px" text="Tipo de Movimiento"/>
                                        <webuijsf:radioButtonGroup columns="2" id="radioButtonGroup1"
                                            items="#{RegistroMovDeposito.radioButtonGroup1DefaultOptions1.options}" style="font-size: 12px; margin-left: 40px; text-align: center; vertical-align: bottom; width: 100%"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="3" id="gridResponsables" style="height: 72px; vertical-align: top" title="Responsables" width="503">
                                        <webuijsf:label id="responsable" text="Responsable:"/>
                                        <webuijsf:textField columns="5" id="codEmp1" text="123123"/>
                                        <webuijsf:textField columns="50" id="nombreEmp1" text="Nombre Empleado"/>
                                        <webuijsf:label id="responsable2" text="Retirado por:"/>
                                        <webuijsf:textField columns="5" id="codEmp2" text="123123"/>
                                        <webuijsf:textField columns="50" id="nombreEmp2" text="Nombre Empleado"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanelReferencia" style="height: 30px; width: 100%">
                                        <webuijsf:label id="referencia" text="Referencia:"/>
                                        <h:panelGrid columns="2" id="gridPanel1" style="height: 48px; width: 100%">
                                            <webuijsf:dropDown id="referencia1" items="#{RegistroMovDeposito.referencia1DefaultOptions.options}" width="150px"/>
                                            <webuijsf:textField columns="10" id="nro" text="123123"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="1" id="gridPanelObservacion" style="height: 30px" width="479">
                                        <br/>
                                        <webuijsf:label id="observacion" text="Observacion"/>
                                        <webuijsf:textArea columns="72" id="textArea2" rows="5"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{RegistroMovDeposito.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate"
                                    style="height: 24px; margin-left: 540px" width="191">
                                    <webuijsf:button actionExpression="#{RegistroMovDeposito.cancelar_action}" id="cancelar"
                                        style="font-size: 14px; height: 24px" text="Cancelar"/>
                                    <webuijsf:button actionExpression="#{RegistroMovDeposito.button2_action}" binding="#{RegistroMovDeposito.button2}"
                                        id="button2" style="font-size: 14px; height: 24px" text="Guardar"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid id="gridPanelDetalle" style="width: 100%; height: 100%;">
                                <webuijsf:staticText binding="#{RegistroMovDeposito.detalleMoviento}" id="detalleMoviento"
                                    style="color: rgb(0, 0, 153); font-family: 'Arial','Helvetica',sans-serif; font-size: 18px; font-weight: bold" text="Detalle Movimiento"/>
                                <webuijsf:tabSet id="tabSet1" lite="true" mini="true" selected="tab1" style="width: 743px">
                                    <webuijsf:tab id="tab1" text="Agregar">
                                        <webuijsf:panelLayout id="layoutPanel1" style="height: 38px; position: relative; width: 733px; -rave-layout: grid">
                                            <h:panelGrid binding="#{RegistroMovDeposito.gridPanelAddUpdate}" columns="5" id="gridPanelAddUpdate"
                                                style="height: 48px" width="719">
                                                <webuijsf:hyperlink id="producto" text="Producto"/>
                                                <webuijsf:textField columns="30" id="cantidad1" text="123123123"/>
                                                <webuijsf:label id="cantidad" text="Cantidad"/>
                                                <webuijsf:textField columns="50" id="producto1" text="Producto"/>
                                                <webuijsf:button id="buttonAgregar" text="Agregar"/>
                                            </h:panelGrid>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <h:panelGrid binding="#{RegistroMovDeposito.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" summary="Productos"
                                    title="Productos" width="935">
                                    <webuijsf:table augmentTitle="false" id="tableProductos" paginateButton="true" paginationControls="true"
                                        sortPanelToggleButton="true" title="Productos" width="746">
                                        <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="productos" rows="15"
                                            sourceData="#{RegistroMovDeposito.defaultTableDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" headerText="Codigo" id="tableColumn1" width="70">
                                                <webuijsf:staticText id="staticText4" text="12312313"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn2" width="430">
                                                <webuijsf:staticText id="staticText1" text="Descripcion del Producto"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cantidad" id="tableColumn3" width="206">
                                                <webuijsf:staticText id="staticText2" text="121212121212"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" id="selec" valign="middle" width="20">
                                                <webuijsf:imageHyperlink id="imageHyperlink1" imageURL="/resources/Images/delete.gif" text=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" id="ed" valign="middle" width="20">
                                                <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/Images/edit_16x16.gif" text=""/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
