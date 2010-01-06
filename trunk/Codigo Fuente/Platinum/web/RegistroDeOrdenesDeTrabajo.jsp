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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 264px; top: 264px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{RegistroDeOrdenesDeTrabajo.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.gridPanelBuscar}" id="gridPanelBuscar" style="height: 100%; width: 100%">
                                <h:panelGrid columns="2" id="gridPanelBuscar1" style="height: 96px" width="647">
                                    <h:panelGrid columns="2" id="gridPanelProducto">
                                        <webuijsf:hyperlink id="linkProducto" style="width: 85px" text="Producto"/>
                                        <webuijsf:textField columns="50" id="producto1" text="Producto Producto"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEstado" style="height: 30px" width="239">
                                        <webuijsf:label id="labelEstado" text="Estado OT"/>
                                        <webuijsf:dropDown id="dropDownEstado" items="#{RegistroDeOrdenesDeTrabajo.dropDownEstadoDefaultOptions.options}" width="150px"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecha1" style="height: 30px; text-align: left; width: 100%">
                                        <webuijsf:label id="fechaApertura" style="width: 10px" text="Fecha Apertura"/>
                                        <webuijsf:calendar columns="40" id="calendar2"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelVacio" style="height: 30px; width: 60%"/>
                                    <h:panelGrid columns="2" id="gridPanelResponsable1" style="height:30px; width: 100%">
                                        <webuijsf:hyperlink id="linkResponsable" style="width: 85px" text="Responsable"/>
                                        <h:panelGrid columns="2" id="gridPanelResponsable" style="height: 30px; text-align: left" width="311">
                                            <webuijsf:textField columns="7" id="textField2" valueChangeListenerExpression="#{RegistroDeOrdenesDeTrabajo.textField1_processValueChange}"/>
                                            <webuijsf:textField columns="40" id="textField1" valueChangeListenerExpression="#{RegistroDeOrdenesDeTrabajo.textField1_processValueChange}"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridBotonesBuscar1" style="height: 24px" width="143">
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.buscar1_action}" id="buscar1" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.todos1_action}" id="todos1" text="Todos"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanelTablaBusqueda" style="height: 154px" width="935">
                                    <webuijsf:table augmentTitle="false" id="tableOrdenesTrabajo" paginateButton="true" paginationControls="true"
                                        title="Ordenes de Trabajo" width="719">
                                        <webuijsf:tableRowGroup id="tableRowGroup1" rows="20"
                                            sourceData="#{RegistroDeOrdenesDeTrabajo.defaultTableDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" headerText="select" id="tableColumn5" width="55">
                                                <webuijsf:radioButton id="radioButton1" label=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" headerText="Codigo" id="tableColumn6" width="30">
                                                <webuijsf:staticText id="staticText6" text="123123123123"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn7" width="285">
                                                <webuijsf:staticText id="staticText7" text="Producto"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Estado" id="tableColumn8" width="77">
                                                <webuijsf:staticText id="staticText5" text="Estado"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Fecha Apertura" id="tableColumn9" width="88">
                                                <webuijsf:staticText id="staticText8" text="99/99/9999"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                                <h:panelGrid columns="3" id="gridBotonAccion" style="height: 100%" width="143">
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.buttonNuevo_action}" id="buttonNuevo" style="width: 50px" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.buttonEditar_action}" id="buttonEditar" style="width: 65px" text="Ver Detalles"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.gridPanelCabecera}" id="gridPanelCabecera" style="height: 100%; width: 100%">
                                <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.gridPanelCabecera1}" columns="2" id="gridPanelCabecera1" style="height: 72px" width="623">
                                    <h:panelGrid columns="2" id="gridPanelNroOT" width="311">
                                        <webuijsf:label id="labelNroOT" text="Nro OT"/>
                                        <webuijsf:textField id="nroOT"
                                            style="background-position: 100% 50%; font-size: 18px; font-weight: bold; text-align: center" text="123123132"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="3" id="gridPanelResponsable2" style="height: 100%; width: 100%">
                                        <webuijsf:hyperlink id="responsable" text="Responsable"/>
                                        <webuijsf:textField columns="10" id="codigo" text="123"/>
                                        <webuijsf:textField columns="43" id="nombreEmp1" text="Nombre Empleado"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:label id="labelDetalleSemiTer2" style="color: rgb(0, 0, 153); font-size: 14px; font-weight: bold" text="Produccion"/>
                                <webuijsf:tabSet id="tabSet3" lite="true" mini="true" selected="tab3" style="width: 791px">
                                    <webuijsf:tab id="tab3" text="Datos de la Produccion">
                                        <webuijsf:panelLayout id="layoutPanel3" style="height: 276px; position: relative; width: 100%; -rave-layout: grid">
                                            <h:panelGrid columns="2" id="gridPanelCabecera2" style="height: 30px" width="575">
                                                <h:panelGrid columns="2" id="gridPanelProduccion" style="border-width: 1px; height: 253px" width="407">
                                                    <webuijsf:hyperlink id="linkCodProducto" text="Codigo Producto"/>
                                                    <h:panelGrid columns="2" id="gridPanelFormular" style="text-align: left">
                                                        <webuijsf:textField id="formula"/>
                                                        <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.botonDeFormula_action}"
                                                            binding="#{RegistroDeOrdenesDeTrabajo.botonDeFormula}" id="botonDeFormula" style="width: 96px" text="Calcular!!"/>
                                                    </h:panelGrid>
                                                    <webuijsf:hyperlink id="linkFormula" text="Formula"/>
                                                    <webuijsf:textField id="codigoProducto"/>
                                                    <webuijsf:label id="labelDescrip" text="Descripcion de la Produccion"/>
                                                    <webuijsf:textArea columns="35" id="descripcionProducto" rows="10"/>
                                                    <webuijsf:label id="labelCantidad" text="Cantidad"/>
                                                    <webuijsf:textField id="cantidad" text="123123123"/>
                                                </h:panelGrid>
                                                <h:panelGrid id="gridPanelPlanear" style="width: 100%; height: 100%;">
                                                    <webuijsf:label id="labelPla" style="color: #0033cc" text="Planeamiento"/>
                                                    <h:panelGrid columns="2" id="gridPlaneamieto" style="width: 401px" title="Planeamiento" width="383">
                                                        <webuijsf:label id="labelFechaIni" style="width: 15px" text="Fecha Inicial"/>
                                                        <webuijsf:calendar id="calendar3"/>
                                                        <webuijsf:label id="labelFechaFin" style="width: 15px" text="Fecha Final"/>
                                                        <webuijsf:calendar id="calendar4"/>
                                                    </h:panelGrid>
                                                    <webuijsf:label id="labelProgreso" style="border-width: 1px; color: #0000ff; height: 58px; width: 401px" text="Progreso"/>
                                                    <h:panelGrid columns="2" id="gridEstado" style="border-width: 1px; width: 401px">
                                                        <webuijsf:label id="labelEstado1" style="width: 15px" text="Estado"/>
                                                        <webuijsf:dropDown id="estado" items="#{RegistroDeOrdenesDeTrabajo.estadoDefaultOptions.options}" width="150px"/>
                                                        <webuijsf:label id="labelCant" style="width: 15px" text="Cantidad Producida"/>
                                                        <webuijsf:textField columns="30" id="textField4" style="text-align: right"/>
                                                    </h:panelGrid>
                                                    <webuijsf:label id="labelCostos" style="color: #0033cc" text="Costos"/>
                                                    <h:panelGrid columns="2" id="gridCosto" style="border-width: 1px; height: 58px; width: 401px">
                                                        <webuijsf:label id="labelCostoInic" style="width: 15px" text="Costo Previsto"/>
                                                        <webuijsf:textField columns="30" id="costoPrevisto" style="text-align: right" text="123123"/>
                                                        <webuijsf:label id="labelCostoReal" style="width: 15px" text="Costo Real"/>
                                                        <webuijsf:textField columns="30" id="costoReal" style="text-align: right" text="123123"/>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate"
                                    style="height: 24px; margin-left: 540px" width="191">
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.cancelar_action}" id="cancelar"
                                        style="font-size: 14px; height: 24px" text="Cancelar"/>
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.button2_action}"
                                        binding="#{RegistroDeOrdenesDeTrabajo.button2}" id="button2" style="font-size: 14px; height: 24px" text="Guardar"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.gridPanelDetalleOT}" id="gridPanelDetalleOT">
                                <webuijsf:label id="labelDetalleSemiTer" style="color: rgb(0, 0, 153); font-size: 14px; font-weight: bold" text="Detalle Semi Terminados"/>
                                <webuijsf:tabSet id="tabSet1" lite="true" mini="true" selected="tab1" style="height: 120px; width: 690px">
                                    <webuijsf:tab id="tab1" text="Agregar">
                                        <webuijsf:panelLayout id="layoutPanel1" style="height: 62px; position: relative; width: 685px; -rave-layout: grid">
                                            <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.gridPanelAddUpdate}" columns="5" id="gridPanelAddUpdate"
                                                style="height: 48px" width="696">
                                                <webuijsf:hyperlink id="producto" text="Producto Semiterminado"/>
                                                <webuijsf:textField columns="10" id="codigo1" text="12345"/>
                                                <webuijsf:textField columns="35" id="cantidad1" text="Descripcion de Producto"/>
                                                <webuijsf:label id="cantidad2" text="Cantidad"/>
                                                <webuijsf:textField id="cantidad4" text="12345"/>
                                            </h:panelGrid>
                                            <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.buttonAgregar_action}" id="buttonAgregar" text="Agregar"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.gridPanelTabla}" id="gridPanelTabla" style="height: 154px"
                                    summary="Productos" title="Productos" width="935">
                                    <webuijsf:table augmentTitle="false" id="tableSemiterminados" paginateButton="true" paginationControls="true"
                                        sortPanelToggleButton="true" title="Productos Semiterminados" width="691">
                                        <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="tablaSemiterminados" rows="15"
                                            sourceData="#{RegistroDeOrdenesDeTrabajo.defaultTableDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" headerText="Codigo" id="tableColumn1" width="65">
                                                <webuijsf:staticText id="staticText4" text="12312313"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn2" width="259">
                                                <webuijsf:staticText id="staticText1" text="Producto SemiTerminado"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" headerText="Cantidad" id="tableColumn3" width="64">
                                                <webuijsf:staticText id="staticText2" text="123123"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" headerText="Cantidad Producida" id="tableColumn4" width="72">
                                                <webuijsf:staticText id="staticText3" text="123123"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" headerText="Activo" id="tableColumn10" width="72">
                                                <webuijsf:checkbox id="checkbox1" selected=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" binding="#{RegistroDeOrdenesDeTrabajo.selec}" id="selec" noWrap="true"
                                                valign="middle" width="86">
                                                <webuijsf:hyperlink actionExpression="#{RegistroDeOrdenesDeTrabajo.hyperlink1_action}" id="hyperlink1" text="Ver detalles..."/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" id="tableColumn11" width="35">
                                                <webuijsf:imageHyperlink id="imageHyperlink1" imageURL="/resources/Images/delete.gif" text=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn id="tableColumn17">
                                                <webuijsf:imageHyperlink id="imageHyperlink4" imageURL="/resources/Images/edit_16x16.gif" text=""/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.gridPanelDetalleSemiTerminados}" id="gridPanelDetalleSemiTerminados" style="width: 100%; height: 100%;">
                                <webuijsf:label id="labelDetalleSemiTer1" style="color: rgb(0, 0, 153); font-size: 14px; font-weight: bold" text="SemiTerminados / Detalle de Recursos y Tareas"/>
                                <webuijsf:label id="labelProduccion1" style="color: rgb(0, 51, 204)" text="Descripcion de la Produccion"/>
                                <h:panelGrid columns="2" id="gridPanelCabeceraSemiTer" style="border-width: 1px; border-style: double; " width="700">
                                    <h:panelGrid columns="2" id="gridPanelProduccionSemitTer" style="border-width: 1px; height: 192px" width="359">
                                        <webuijsf:hyperlink id="codigo_Semiterminado" text="Codigo Semiterminado"/>
                                        <webuijsf:textField id="codigoProducto1"/>
                                        <webuijsf:hyperlink id="linkFormula1" text="Formula"/>
                                        <webuijsf:textField id="formula1"/>
                                        <webuijsf:label id="labelDescrip1" text="Descripcion"/>
                                        <webuijsf:textArea columns="35" id="descripcionProducto1" rows="4"/>
                                        <webuijsf:label id="labelCantidad1" text="Cantidad"/>
                                        <webuijsf:textField id="cantidad7" text="123123123"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanelActivar" style="height: 59px; text-align: center" width="339">
                                        <webuijsf:label id="activar" style="font-size: 14px; bottom: 1px; vertical-align: top" text="Activar"/>
                                        <webuijsf:checkbox id="checkbox2"/>
                                        <h:panelGrid id="gridPanel1" style="width: 100%; height: 100%;"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="buttonsPanelAddUpdate1" style="height: 24px; margin-left: 540px" width="191">
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.button2_action}" id="button1"
                                        style="font-size: 14px; height: 24px" text="Volver"/>
                                </h:panelGrid>
                                <h:panelGrid columns="1" id="gridPanelDetalleSemiTer" style="width: 100%; height: 100%;">
                                    <h:panelGrid columns="1" id="gridPanelDetalleSemiTerRecursos" style="width: 100%; height: 100%;">
                                        <webuijsf:tabSet id="tabSet2" lite="true" mini="true" selected="tab1" style="height: 120px; width: 695px">
                                            <webuijsf:tab id="tab2" text="Recursos">
                                                <webuijsf:panelLayout id="layoutPanel2" style="height: 62px; position: relative; width: 685px; -rave-layout: grid">
                                                    <h:panelGrid columns="4" id="gridPanelAddUpdate1" style="height: 48px" width="624">
                                                        <webuijsf:hyperlink id="producto2" text="Recursos"/>
                                                        <webuijsf:textField columns="50" id="recurso" text="Descripcion de Recursos"/>
                                                        <webuijsf:label id="cantidad5" text="Cantidad"/>
                                                        <webuijsf:textField id="cantidad6" text="12345"/>
                                                    </h:panelGrid>
                                                    <webuijsf:button id="buttonAgregar1" text="Agregar"/>
                                                </webuijsf:panelLayout>
                                            </webuijsf:tab>
                                        </webuijsf:tabSet>
                                        <h:panelGrid id="gridPanelRecursos" style="height: 154px" width="935">
                                            <webuijsf:table augmentTitle="false" id="tableRecursos" paginateButton="true" paginationControls="true"
                                                title="Detalle de Recusos SemiTerminados" width="691">
                                                <webuijsf:tableRowGroup id="tableRowGroup2" rows="10"
                                                    sourceData="#{RegistroDeOrdenesDeTrabajo.defaultTableDataProvider}" sourceVar="currentRow">
                                                    <webuijsf:tableColumn align="right" headerText="Codigo" id="tableColumn12" width="65">
                                                        <webuijsf:staticText id="staticText9" text="123123"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Descripcion" id="tableColumn13" sort="column2" width="309">
                                                        <webuijsf:staticText id="staticText10" text="Descripcion Recurso"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="UnidadMedida" id="tableColumn18">
                                                        <webuijsf:staticText id="staticText15" text="KgMtsUnidadesLitros"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="right" headerText="Cantidad" id="tableColumn14">
                                                        <webuijsf:staticText id="staticText11" text="123123"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" id="tableColumn19">
                                                        <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/Images/delete.gif" text=""/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" id="tableColumn22">
                                                        <webuijsf:imageHyperlink id="imageHyperlink5" imageURL="/resources/Images/edit_16x16.gif" text=""/>
                                                    </webuijsf:tableColumn>
                                                </webuijsf:tableRowGroup>
                                            </webuijsf:table>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="1" id="gridPanelDetalleSemiTerTareas" style="width: 100%; height: 100%;">
                                        <webuijsf:tabSet id="tabSet4" lite="true" mini="true" selected="tab2" style="height: 120px; width: 695px">
                                            <webuijsf:tab id="tab4" text="Tareas">
                                                <webuijsf:panelLayout id="layoutPanel4" style="height: 62px; position: relative; width: 685px; -rave-layout: grid">
                                                    <h:panelGrid columns="4" id="gridPanelAddUpdate3" style="height: 48px" width="624">
                                                        <webuijsf:hyperlink id="tareas" text="Tareas"/>
                                                        <webuijsf:textField columns="50" id="tareas1" text="Descripcion de Tareas"/>
                                                        <webuijsf:label id="cantidad3" text="Cantidad"/>
                                                        <webuijsf:textField id="cantidad8" text="12345"/>
                                                    </h:panelGrid>
                                                    <webuijsf:button id="buttonAgregar3" text="Agregar"/>
                                                </webuijsf:panelLayout>
                                            </webuijsf:tab>
                                        </webuijsf:tabSet>
                                        <h:panelGrid id="gridPanelTareas" style="height: 154px" width="935">
                                            <webuijsf:table augmentTitle="false" id="tableTareas" paginateButton="true" paginationControls="true"
                                                title="Detalle de Tareas" width="695">
                                                <webuijsf:tableRowGroup id="tableRowGroup3" rows="10"
                                                    sourceData="#{RegistroDeOrdenesDeTrabajo.defaultTableDataProvider}" sourceVar="currentRow">
                                                    <webuijsf:tableColumn align="right" headerText="Codigo" id="tableColumn15" width="65">
                                                        <webuijsf:staticText id="staticText12" text="123123"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Descripcion Tarea" id="tableColumn16" width="399">
                                                        <webuijsf:staticText id="staticText13" text="Descripcion Recurso"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="right" headerText="Cantidad" id="tableColumn20">
                                                        <webuijsf:staticText id="staticText16" text="123123"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" id="tableColumn21">
                                                        <webuijsf:imageHyperlink id="imageHyperlink3" imageURL="/resources/Images/delete.gif" text=""/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" id="tableColumn23">
                                                        <webuijsf:imageHyperlink id="imageHyperlink6" imageURL="/resources/Images/edit_16x16.gif" text=""/>
                                                    </webuijsf:tableColumn>
                                                </webuijsf:tableRowGroup>
                                            </webuijsf:table>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
