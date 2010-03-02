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
                                <h:panelGrid columns="2" id="gridPanelFiltros" style="height: 96px" width="647">
                                    <h:panelGrid columns="2" id="gridPanelNum" style="height:30px; width: 100%">
                                        <webuijsf:label id="label2" text="Num OT"/>
                                        <h:panelGrid columns="2" id="gridPanelResponsable" style="height: 30px; text-align: left" width="311">
                                            <webuijsf:textField binding="#{RegistroDeOrdenesDeTrabajo.uiNumOtFil}" columns="40" id="uiNumOtFil" valueChangeListenerExpression="#{RegistroDeOrdenesDeTrabajo.uiNumOtFil_processValueChange}"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelProducto" width="359">
                                        <webuijsf:label id="label3" text="Producto"/>
                                        <webuijsf:dropDown binding="#{RegistroDeOrdenesDeTrabajo.uiProductoFil}" id="uiProductoFil"
                                            items="#{SessionBean1.listaProductosOp}" width="270"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEstado" style="height: 30px" width="239">
                                        <webuijsf:label id="labelEstado" text="Estado OT"/>
                                        <webuijsf:dropDown binding="#{RegistroDeOrdenesDeTrabajo.uiEstadoFIl}" id="uiEstadoFIl"
                                            items="#{RegistroDeOrdenesDeTrabajo.uiEstadoFIlDefaultOptions.options}" width="150px"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelVacio" style="vertical-align: top" width="431">
                                        <webuijsf:label id="label1" style="background-position: top; vertical-align: top" text="Rango de Fecha Apertura"/>
                                        <h:panelGrid columns="1" id="gridPanelVacio1" style="height: 30px; width: 60%">
                                            <h:panelGrid columns="2" id="gridPanelFecha2" style="height: 30px; text-align: left; width: 100%">
                                                <webuijsf:label id="fechaApertura1" style="width: 10px" text="Desde"/>
                                                <webuijsf:calendar binding="#{RegistroDeOrdenesDeTrabajo.uiFechaDesdeFil}" columns="40" id="uiFechaDesdeFil"/>
                                            </h:panelGrid>
                                            <h:panelGrid columns="2" id="gridPanelFecha1" style="height: 30px; text-align: left; width: 100%">
                                                <webuijsf:label id="inicio" style="width: 10px" text="Hasta"/>
                                                <webuijsf:calendar binding="#{RegistroDeOrdenesDeTrabajo.uiFechaHastaFil}" columns="40" id="uiFechaHastaFil"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridBotonesBuscar1" style="height: 24px" width="143">
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.buscar1_action}" id="buscar1" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.todos1_action}" id="todos1" text="Todos"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanelTablaBusqueda" style="height: 154px" width="935">
                                    <webuijsf:table augmentTitle="false" id="tableOrdenesTrabajo" paginateButton="true" paginationControls="true"
                                        title="Ordenes de Trabajo" width="576">
                                        <webuijsf:tableRowGroup id="tableRowGroup1" rows="10"
                                            sourceData="#{RegistroDeOrdenesDeTrabajo.listaOrdenTrabajoCabeceras}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" id="tableColumn5" valign="top">
                                                <webuijsf:radioButton id="radioButton1" label=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Num OT" id="tableColumn6" sort="numeroOrdenTrabajo">
                                                <webuijsf:staticText id="staticText6" text="#{currentRow.value['numeroOrdenTrabajo']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="FechaApertura" id="tableColumn7" sort="fechaOt">
                                                <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText7" text="#{currentRow.value['fechaOt']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn8" sort="codProductoOt">
                                                <webuijsf:staticText id="staticText8" text="#{currentRow.value['codProductoOt']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cantidad" id="tableColumn9" sort="cantidadOt">
                                                <webuijsf:staticText id="staticText14" text="#{currentRow.value['cantidadOt']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Estado" id="tableColumn24" sort="estadoOt">
                                                <webuijsf:staticText id="staticText5" text="#{currentRow.value['estadoOt']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                                <h:panelGrid columns="3" id="gridBotonAccion" style="height: 100%" width="143">
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.buttonNuevo_action}" id="buttonNuevo" style="width: 50px" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.buttonEditar_action}" id="buttonEditar" style="width: 65px" text="Ver Detalles"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.gridPanelCabecera}" id="gridPanelCabecera" style="height: 100%" width="815">
                                <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.gridPanelCabecera1}" columns="2" id="gridPanelCabecera1" style="height: 72px" width="623">
                                    <h:panelGrid columns="2" id="gridPanelNroOT" width="311">
                                        <webuijsf:label id="labelNroOT" text="Nro OT"/>
                                        <webuijsf:textField binding="#{RegistroDeOrdenesDeTrabajo.uiNroOT}" id="uiNroOT"
                                            style="background-position: 100% 50%; font-size: 18px; font-weight: bold; text-align: center" text="123123132"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="3" id="gridPanelResponsable2" style="height: 100%; width: 100%">
                                        <webuijsf:hyperlink id="responsable" text="Responsable"/>
                                        <webuijsf:textField binding="#{RegistroDeOrdenesDeTrabajo.uiResponsableCodigo}" columns="10" id="uiResponsableCodigo"/>
                                        <webuijsf:textField binding="#{RegistroDeOrdenesDeTrabajo.uiResponsableNombre}" columns="43" id="uiResponsableNombre"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:label id="labelDetalleSemiTer2" style="color: rgb(0, 0, 153); font-size: 14px; font-weight: bold" text="Produccion"/>
                                <webuijsf:tabSet id="tabSet3" lite="true" mini="true" selected="tab3" style="width: 839px">
                                    <webuijsf:tab id="tab3" text="Datos de la Produccion">
                                        <webuijsf:panelLayout id="layoutPanel3" style="height: 276px; position: relative; width: 100%; -rave-layout: grid">
                                            <h:panelGrid columns="2" id="gridPanelCabecera2" style="height: 30px" width="575">
                                                <h:panelGrid columns="2" id="gridPanelProduccion" style="border-width: 1px; height: 253px" width="407">
                                                    <webuijsf:label id="label4" text="Producto"/>
                                                    <h:panelGrid columns="2" id="gridPanelProducto1" style="text-align: left">
                                                        <webuijsf:dropDown binding="#{RegistroDeOrdenesDeTrabajo.uiProducto}" id="uiProducto"
                                                            items="#{SessionBean1.listaProductosOp}" width="200"/>
                                                        <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.botonDeFormula_action}"
                                                            binding="#{RegistroDeOrdenesDeTrabajo.botonDeFormula}" id="botonDeFormula" style="width: 96px" text="Calcular!!"/>
                                                    </h:panelGrid>
                                                    <webuijsf:hyperlink id="linkFormula" text="Formula"/>
                                                    <h:panelGrid columns="2" id="gridPanel2" style="height: 100%; width: 100%">
                                                        <webuijsf:textField binding="#{RegistroDeOrdenesDeTrabajo.uiFormulaCodigo}" columns="7" id="uiFormulaCodigo"/>
                                                        <webuijsf:textField binding="#{RegistroDeOrdenesDeTrabajo.uiFormulaNombre}" columns="45" id="uiFormulaNombre"/>
                                                    </h:panelGrid>
                                                    <webuijsf:label id="labelDescrip" text="Descripcion de la Produccion"/>
                                                    <webuijsf:textArea binding="#{RegistroDeOrdenesDeTrabajo.uiDescripcionOt}" columns="35" id="uiDescripcionOt" rows="10"/>
                                                    <webuijsf:label id="labelCantidad" text="Cantidad"/>
                                                    <webuijsf:textField binding="#{RegistroDeOrdenesDeTrabajo.uiCantidad}" id="uiCantidad"/>
                                                </h:panelGrid>
                                                <h:panelGrid id="gridPanelPlanear" style="width: 100%; height: 100%;">
                                                    <webuijsf:label id="labelPla" style="color: #0033cc" text="Planeamiento"/>
                                                    <h:panelGrid columns="2" id="gridPlaneamieto" style="width: 401px" title="Planeamiento" width="383">
                                                        <webuijsf:label id="labelFechaIni" style="width: 15px" text="Fecha Inicial"/>
                                                        <webuijsf:calendar binding="#{RegistroDeOrdenesDeTrabajo.uiFechaIni}" id="uiFechaIni"/>
                                                        <webuijsf:label id="labelFechaFin" style="width: 15px" text="Fecha Final"/>
                                                        <webuijsf:calendar binding="#{RegistroDeOrdenesDeTrabajo.uiFechaFin}" id="uiFechaFin"/>
                                                    </h:panelGrid>
                                                    <webuijsf:label id="labelProgreso" style="border-width: 1px; color: #0000ff; height: 58px; width: 401px" text="Progreso"/>
                                                    <h:panelGrid columns="2" id="gridEstado" style="border-width: 1px; width: 401px">
                                                        <webuijsf:label id="labelEstado1" style="width: 15px" text="Estado"/>
                                                        <webuijsf:dropDown binding="#{RegistroDeOrdenesDeTrabajo.uiEstado}" id="uiEstado"
                                                            items="#{RegistroDeOrdenesDeTrabajo.uiEstadoDefaultOptions.options}" width="150px"/>
                                                        <webuijsf:label id="labelCant" style="width: 15px" text="Cantidad Producida"/>
                                                        <webuijsf:textField binding="#{RegistroDeOrdenesDeTrabajo.uiCantidadProducida}" columns="30"
                                                            id="uiCantidadProducida" style="text-align: right"/>
                                                    </h:panelGrid>
                                                    <webuijsf:label id="labelCostos" style="color: #0033cc" text="Costos"/>
                                                    <h:panelGrid columns="2" id="gridCosto" style="border-width: 1px; height: 58px; width: 401px">
                                                        <webuijsf:label id="labelCostoInic" style="width: 15px" text="Costo Previsto"/>
                                                        <webuijsf:textField binding="#{RegistroDeOrdenesDeTrabajo.uiCostoPrevisto}" columns="30"
                                                            id="uiCostoPrevisto" style="text-align: right" text="123123"/>
                                                        <webuijsf:label id="labelCostoReal" style="width: 15px" text="Costo Real"/>
                                                        <webuijsf:textField binding="#{RegistroDeOrdenesDeTrabajo.uiCostoReal}" columns="30" id="uiCostoReal"
                                                            style="text-align: right" text="123123"/>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <h:panelGrid binding="#{RegistroDeOrdenesDeTrabajo.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate"
                                    style="height: 24px; margin-left: 540px" width="191">
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.uiCancelButton_action}" id="uiCancelButton"
                                        style="font-size: 14px; height: 24px" text="Cancelar"/>
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.addRecordButton_action}"
                                        binding="#{RegistroDeOrdenesDeTrabajo.addRecordButton}" id="addRecordButton" style="font-size: 14px; height: 24px" text="Guardar"/>
                                    <webuijsf:button actionExpression="#{RegistroDeOrdenesDeTrabajo.button2_action}" id="button2" text="Button"/>
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
