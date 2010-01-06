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
                            <webuijsf:pageAlert binding="#{RegistroProDiaria.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{RegistroProDiaria.gridPanelBusqueda}" id="gridPanelBusqueda" style="width: 100%; height: 100%;">
                                <h:panelGrid columns="4" id="gridPanelFiltro" style="height: 100%" width="695">
                                    <webuijsf:hyperlink id="hyperlinkResponsable" text="Responsable"/>
                                    <webuijsf:textField columns="35" id="textField1"/>
                                    <webuijsf:hyperlink id="OT" text="OT"/>
                                    <webuijsf:textField id="textField2"/>
                                    <webuijsf:label id="labelFechaIni" text="Fecha Ini"/>
                                    <webuijsf:calendar id="calendar2"/>
                                    <webuijsf:label id="labelFechaFin" text="Fecha Fin"/>
                                    <webuijsf:calendar id="calendar3"/>
                                    <webuijsf:button id="buttonTodos" text="Todos"/>
                                    <webuijsf:button actionExpression="#{RegistroProDiaria.button1_action}" id="button1" text="Buscar"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanelTabla" style="width: 100%; height: 100%;">
                                    <webuijsf:table augmentTitle="false" id="tableTareas" title="Lista de Tareas" width="647">
                                        <webuijsf:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{RegistroProDiaria.defaultTableDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="right" headerText="Fecha" id="tableColumn4">
                                                <webuijsf:staticText id="staticText4" text="01/01/2009"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Responsable" id="tableColumn7" width="203">
                                                <webuijsf:staticText id="staticText7" text="Responsable Responsable"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Tareas" id="tableColumn5" width="276">
                                                <webuijsf:staticText id="staticText5" text="Descripcion de Tareas"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="right" headerText="OT" id="tableColumn6">
                                                <webuijsf:staticText id="staticText6" text="200300400"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                                <h:panelGrid columns="3" id="gridPanelBotones">
                                    <webuijsf:button actionExpression="#{RegistroProDiaria.buttonNuevo_action}" id="buttonNuevo" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{RegistroProDiaria.buttonEditar_action}" id="buttonEditar" text="Editar"/>
                                    <webuijsf:button id="buttonEliminar" text="Eliminar"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{RegistroProDiaria.gridPanelCabecera}" columns="1" id="gridPanelCabecera" style="height: 72px" width="599">
                                <h:panelGrid columns="3" id="gridResponsables" style="height: 48px; vertical-align: top" title="Responsables" width="503">
                                    <webuijsf:label id="responsable" text="Responsable:"/>
                                    <webuijsf:textField columns="5" id="codEmp1" text="123123"/>
                                    <webuijsf:textField columns="50" id="nombreEmp1" text="Nombre Empleado"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelDatos1" style="height: 30px" width="287">
                                    <webuijsf:label id="fecha" text="Fecha"/>
                                    <webuijsf:calendar id="calendar1" style="margin-left: 41px"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelOT" style="border-width: 2px; border-style: outset; height: 100%; width: 100%">
                                    <webuijsf:label id="ot" text="OT Nro:"/>
                                    <webuijsf:textField id="textField3"/>
                                    <webuijsf:label id="labelDesc" text="Descripcion"/>
                                    <webuijsf:textArea columns="60" id="textArea1" rows="5"/>
                                    <webuijsf:label id="labelSemi" text="SemiTerminado"/>
                                    <h:panelGrid columns="2" id="gridPanelSemi" style="margin-left: -3px">
                                        <webuijsf:textField columns="10" id="textField4"/>
                                        <webuijsf:textField columns="50" id="textField5"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <br/>
                                <h:panelGrid binding="#{RegistroProDiaria.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 24px" width="191">
                                    <webuijsf:button actionExpression="#{RegistroProDiaria.cancelar_action}" id="cancelar" style="font-size: 14px; height: 24px" text="Cancelar"/>
                                    <webuijsf:button actionExpression="#{RegistroProDiaria.button2_action}" binding="#{RegistroProDiaria.button2}" id="button2"
                                        style="font-size: 14px; height: 24px" text="Guardar"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroProDiaria.gridPannelDetalle}" id="gridPannelDetalle" style="width: 100%; height: 100%;">
                                <webuijsf:staticText binding="#{RegistroProDiaria.detalleProduccion}" id="detalleProduccion"
                                    style="color: rgb(0, 0, 153); font-family: 'Arial','Helvetica',sans-serif; font-size: 18px; font-weight: bold" text="Detalle de Produccion"/>
                                <webuijsf:tabSet id="tabSet1" lite="true" mini="true" selected="tab1" style="width: 743px">
                                    <webuijsf:tab id="tab1" text="Agregar">
                                        <webuijsf:panelLayout id="layoutPanel1" style="height: 38px; position: relative; width: 733px; -rave-layout: grid">
                                            <h:panelGrid binding="#{RegistroProDiaria.gridPanelAddUpdate}" columns="7" id="gridPanelAddUpdate"
                                                style="height: 48px" width="719">
                                                <webuijsf:hyperlink id="tarea" text="Tarea"/>
                                                <webuijsf:textField columns="50" id="tarea1" text="Tareas"/>
                                                <webuijsf:label id="cantidad" text="Cantidad"/>
                                                <webuijsf:textField columns="10" id="cantidad1" text="123123123"/>
                                                <webuijsf:label id="tiempoInv" text="Tiempo(min)"/>
                                                <webuijsf:textField columns="5" id="tiempo" text="120"/>
                                                <webuijsf:button id="buttonAgregar" text="Agregar"/>
                                            </h:panelGrid>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <h:panelGrid id="gridPanel1" style="height: 100%; width: 100%">
                                    <webuijsf:table augmentTitle="false" id="tablaTareas" paginateButton="true" paginationControls="true"
                                        sortPanelToggleButton="true" style="height: 77px" title="Tareas" width="743">
                                        <webuijsf:tableRowGroup id="tableRowGroup1" rows="10" sourceData="#{RegistroProDiaria.defaultTableDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn headerText="Codigo" id="tableColumn1">
                                                <webuijsf:staticText id="staticText1" text="123123123"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Descripcion" id="tableColumn2" sort="column2" width="416">
                                                <webuijsf:staticText id="staticText2" text="Descripcion de la Tarea"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cantidad" id="tableColumn3">
                                                <webuijsf:staticText id="staticText3" text="999.999.999"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="right" headerText="Tiempo Min" id="tableColumn9">
                                                <webuijsf:staticText id="staticText8" text="120"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" id="tableColumn8">
                                                <webuijsf:imageHyperlink id="imageHyperlink1" imageURL="/resources/Images/delete.gif" text=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn id="tableColumn10">
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
