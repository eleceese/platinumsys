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
                        <h:panelGrid id="mainContainer" style="height: 1347px; left: 216px; top: 144px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{RegistroDeInventarioCierre.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{RegistroDeInventarioCierre.gridPanelbusqueda}" id="gridPanelbusqueda" style="width: 100%; height: 100%;">
                                <h:panelGrid columns="4" id="gridPanelFiltro">
                                    <webuijsf:label id="label1" text="Deposito"/>
                                    <webuijsf:dropDown id="dropDown1" items="#{RegistroDeInventarioCierre.dropDown1DefaultOptions.options}" width="130px"/>
                                    <webuijsf:label id="label3" text="Fecha"/>
                                    <webuijsf:calendar id="calendar2"/>
                                    <webuijsf:button actionExpression="#{RegistroDeInventarioCierre.button1_action}" id="button1" text="Buscar"/>
                                    <webuijsf:button id="button3" text="Todos"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanelTabla1" style="width: 100%; height: 100%;">
                                    <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true"
                                        title="Inventarios Abiertos" width="647">
                                        <webuijsf:tableRowGroup id="tableRowGroup1" rows="10"
                                            sourceData="#{RegistroDeInventarioCierre.defaultTableDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" id="tableColumn9" width="41">
                                                <webuijsf:radioButton id="radioButton1" label=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Deposito" id="tableColumn5">
                                                <webuijsf:staticText id="staticText5" text="Deposito Principal"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Fecha" id="tableColumn6" sort="column2" width="117">
                                                <webuijsf:staticText id="staticText6" text="01/01/2001"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Observacion" id="tableColumn7" sort="column3">
                                                <webuijsf:staticText id="staticText7" text="Observacion Observacion"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelFiltro1">
                                    <webuijsf:button id="button4" text="Ajustar"/>
                                    <webuijsf:button id="button5" text="Anular"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroDeInventarioCierre.gridPanelCabecera1}" id="gridPanelCabecera1" style="width: 100%; height: 100%;">
                                <h:panelGrid binding="#{RegistroDeInventarioCierre.gridPanelCabecera}" columns="2" id="gridPanelCabecera" style="height: 72px" width="623">
                                    <h:panelGrid columns="2" id="gridPanelDatos1" style="height: 30px" width="575">
                                        <webuijsf:label id="nroInventario" text="Numero Inventario"/>
                                        <h:panelGrid columns="1" id="nro" style="text-align: left; width: 450px">
                                            <webuijsf:textField id="nroDeposito1" text="123123132"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelfecha" text="Fecha"/>
                                        <h:panelGrid columns="1" id="fecha" style="text-align: left; width: 450px">
                                            <webuijsf:calendar id="calendar1"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labeldeposito" text="Deposito"/>
                                        <h:panelGrid columns="1" id="deposito" style="text-align: left; width: 450px">
                                            <webuijsf:dropDown id="deposito1" items="#{RegistroDeInventarioCierre.deposito1DefaultOptions.options}"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="empleados" text="Empleados"/>
                                        <h:panelGrid columns="2" id="gridEmpleado" style="text-align: left; width: 450px" title="Responsables" width="311">
                                            <webuijsf:textField columns="10" id="codigo" text="123"/>
                                            <webuijsf:textField columns="43" id="nombreEmp1" text="Nombre Empleado"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="observacion" text="Observacion"/>
                                        <h:panelGrid columns="1" id="gridPanelObservacion" style="height: 30px; width: 450px" width="479">
                                            <webuijsf:textArea columns="63" id="textArea2" rows="4" style=""/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{RegistroDeInventarioCierre.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate"
                                    style="height: 24px; margin-left: 540px" width="191">
                                    <webuijsf:button actionExpression="#{RegistroDeInventarioCierre.cancelar_action}" id="cancelar"
                                        style="font-size: 14px; height: 24px" text="Cancelar"/>
                                    <webuijsf:button actionExpression="#{RegistroDeInventarioCierre.button2_action}"
                                        binding="#{RegistroDeInventarioCierre.button2}" id="button2" style="font-size: 14px; height: 24px" text="Ajustar"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{RegistroDeInventarioCierre.gridPanelDetalle}" id="gridPanelDetalle">
                                <h:panelGrid binding="#{RegistroDeInventarioCierre.gridPanelTabla}" id="gridPanelTabla" style="height: 154px"
                                    summary="Productos" title="Productos" width="935">
                                    <webuijsf:table augmentTitle="false" id="tableProductos" paginateButton="true" paginationControls="true"
                                        sortPanelToggleButton="true" title="Inventario" width="743">
                                        <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="productos" rows="15"
                                            sourceData="#{RegistroDeInventarioCierre.defaultTableDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" headerText="Codigo" id="tableColumn1" width="70">
                                                <webuijsf:staticText id="staticText4" text="12312313"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn2" width="355">
                                                <webuijsf:staticText id="staticText1" text="Descripcion del Producto"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" headerText="Cantidad Sist" id="tableColumn3" width="88">
                                                <webuijsf:staticText id="staticText2" text="123123"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" headerText="Cantidad Cont" id="tableColumn4" width="104">
                                                <webuijsf:staticText id="staticText3" text="123123"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" binding="#{RegistroDeInventarioCierre.selec}" headerText="X" id="selec"
                                                valign="middle" width="20">
                                                <webuijsf:imageHyperlink id="imageHyperlink1" imageURL="/resources/Images/delete.gif" text=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" id="tableColumn8" width="28">
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
