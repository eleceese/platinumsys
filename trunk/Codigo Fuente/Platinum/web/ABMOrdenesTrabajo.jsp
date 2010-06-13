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
                            var table = document.getElementById("form1:tableOrdenesTrabajo1");
                            table.initAllRows();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar el Tipo de Producto seleccionado?")) {
                                    return false;
                                }else{
                                    return true;
                                }
                            }
                        }
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <webuijsf:script id="scriptPopUp" type="text/javascript" url="/js/utilJS.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 240px; top: 216px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMOrdenesTrabajo.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMOrdenesTrabajo.gridPanelBuscar}" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelFiltros1" style="height: 96px" width="647">
                                    <h:panelGrid columns="2" id="gridPanelNum1" style="height:30px; width: 100%">
                                        <webuijsf:label id="label1" text="Num OT"/>
                                        <h:panelGrid columns="2" id="gridPanelResponsable1" style="height: 30px; text-align: left" width="311">
                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiNumOtFil}" columns="40" id="uiNumOtFil"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="3" id="gridPanelProducto1" width="359">
                                        <webuijsf:label id="label2" text="Producto"/>
                                        <webuijsf:dropDown binding="#{ABMOrdenesTrabajo.uiProductoFil}" id="uiProductoFil"
                                            items="#{SessionBean1.listaProductosOp}" width="270"/>
                                        <webuijsf:checkbox binding="#{ABMOrdenesTrabajo.uiTodosFil}" id="uiTodosFil" label="Todos"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEstado1" style="height: 30px" width="239">
                                        <webuijsf:label id="labelEstado1" text="Estado OT"/>
                                        <webuijsf:dropDown binding="#{ABMOrdenesTrabajo.uiEstadoFil}" id="uiEstadoFil"
                                            items="#{ABMOrdenesTrabajo.dropDown1DefaultOptions.options}" width="100"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelVacio1" style="vertical-align: top" width="431">
                                        <webuijsf:label id="label3" style="background-position: top; vertical-align: top" text="Rango de Fecha Apertura"/>
                                        <h:panelGrid columns="1" id="gridPanelVacio2" style="height: 30px; width: 60%">
                                            <h:panelGrid columns="2" id="gridPanelFecha1" style="height: 30px; text-align: left; width: 100%">
                                                <webuijsf:label id="fechaApertura1" style="width: 10px" text="Desde"/>
                                                <webuijsf:calendar binding="#{ABMOrdenesTrabajo.uiFechaDesdeFil}" columns="40" id="uiFechaDesdeFil"/>
                                            </h:panelGrid>
                                            <h:panelGrid columns="2" id="gridPanelFecha2" style="height: 30px; text-align: left; width: 100%">
                                                <webuijsf:label id="inicio1" style="width: 10px" text="Hasta"/>
                                                <webuijsf:calendar binding="#{ABMOrdenesTrabajo.uiFechaHastaFil}" columns="40" id="uiFechaHastaFil"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridBotonesBuscar1" style="height: 24px" width="143">
                                    <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonBuscarFiltro_action}" id="uiButtonBuscarFiltro" text="Buscar"/>
                                    <webuijsf:button id="uiButtonTodosFiltro" text="Todos"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanelTablaBusqueda1" style="height: 154px" width="935">
                                    <webuijsf:table augmentTitle="false" binding="#{ABMOrdenesTrabajo.tableOrdenesTrabajo1}" id="tableOrdenesTrabajo1"
                                        paginateButton="true" paginationControls="true" title="Ordenes de Trabajo" width="863">
                                        <webuijsf:tableRowGroup binding="#{ABMOrdenesTrabajo.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                            selected="#{ABMOrdenesTrabajo.selectedState}" sourceData="#{ABMOrdenesTrabajo.listaOrdenTrabajoCabeceras}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" binding="#{ABMOrdenesTrabajo.tableColumn1}" id="tableColumn1"
                                                onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMOrdenesTrabajo.radioButton1.id}" valign="top">
                                                <webuijsf:radioButton binding="#{ABMOrdenesTrabajo.radioButton1}" id="radioButton1" label=""
                                                    selected="#{ABMOrdenesTrabajo.selected}" selectedValue="#{ABMOrdenesTrabajo.selectedValue}" valueChangeListenerExpression="#{ABMOrdenesTrabajo.radioButton1_processValueChange}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Nro Ot" id="tableColumn2" sort="numeroOrdenTrabajo" width="90">
                                                <webuijsf:staticText id="staticText2" text="#{currentRow.value['codOrdenTrabjo']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Fecha" id="tableColumn3" sort="fechaOt">
                                                <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText3" text="#{currentRow.value['fechaOt']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn4" sort="codProductoOt" width="295">
                                                <webuijsf:staticText id="staticText4" text="#{currentRow.value['codProductoOt']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cantidad" id="tableColumn5">
                                                <webuijsf:staticText id="staticText5" text="#{currentRow.value['cantidadOt']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Estado" id="tableColumn6" sort="estadoOt">
                                                <webuijsf:staticText id="staticText17" text="#{currentRow.value['estadoOt']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                                <h:panelGrid columns="3" id="gridBotonAccion1" style="height: 100%" width="143">
                                    <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonNuevoRegistro_action}" id="uiButtonNuevoRegistro"
                                        style="width: 50px" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonEditarRegistro_action}" id="uiButtonEditarRegistro"
                                        style="width: 65px" text="Ver Detalles"/>
                                    <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.calcularCosto_action}" id="calcularCosto" text="Costos Finales"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMOrdenesTrabajo.gridPanelDatosCabecera}" id="gridPanelDatosCabecera" style="height: 100%; width: 100%">
                                <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                    <webuijsf:tabSet binding="#{ABMOrdenesTrabajo.tabSet2}" id="tabSet2" lite="true" mini="true" selected="tab1" style="width: 839px">
                                        <webuijsf:tab actionExpression="#{ABMOrdenesTrabajo.tab1_action}" binding="#{ABMOrdenesTrabajo.tab1}" id="tab1" text="Orden de Trabajo">
                                            <webuijsf:panelLayout id="layoutPanel1" style="height: 350px; position: relative; width: 100%; -rave-layout: grid">
                                                <h:panelGrid columns="2" id="gridPanelCabecera3" style="height: 288px; left: 0px; top: 72px; position: absolute" width="575">
                                                    <h:panelGrid columns="2" id="gridPanelProduccion1" style="border-width: 1px; height: 260px" width="407">
                                                        <webuijsf:label id="label4" text="Producto"/>
                                                        <h:panelGrid columns="2" id="gridPanelProducto2" style="text-align: left">
                                                            <webuijsf:dropDown binding="#{ABMOrdenesTrabajo.uiProducto}" id="uiProducto"
                                                                items="#{SessionBean1.listaProductosOp}"
                                                                valueChangeListenerExpression="#{ABMOrdenesTrabajo.uiProducto_processValueChange}" width="200"/>
                                                        </h:panelGrid>
                                                        <webuijsf:hyperlink id="linkFormula1"
                                                            onClick="doPopup('form1:tabSet2:tab1:layoutPanel1:uiFormulaCodigo_field', 'form1:tabSet2:tab1:layoutPanel1:uiFormulaNombre_field')"
                                                            target="popup" text="Formula" url="/faces/popup/popupFormulasTerminados.jsp"/>
                                                        <h:panelGrid columns="2" id="gridPanel1" style="height: 100%; width: 100%">
                                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiFormulaCodigo}" columns="7" id="uiFormulaCodigo"/>
                                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiFormulaNombre}" columns="45" disabled="true" id="uiFormulaNombre"/>
                                                        </h:panelGrid>
                                                        <webuijsf:label id="labelDescrip1" text="Descripcion de la Produccion"/>
                                                        <webuijsf:textArea binding="#{ABMOrdenesTrabajo.uiDescripcionOt}" columns="52" id="uiDescripcionOt" rows="10"/>
                                                        <webuijsf:label id="labelCantidad1" text="Cantidad"/>
                                                        <h:panelGrid columns="2" id="gridPanel6" style="width: 100%; height: 100%;">
                                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiCantidad}" id="uiCantidad"/>
                                                            <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonCalcularFormula_action}"
                                                                id="uiButtonCalcularFormula" style="width: 96px" text="Calcular!!"/>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                    <h:panelGrid id="gridPanelPlanear" style="height: 270px; width: 100%">
                                                        <webuijsf:label id="labelPla1" style="color: rgb(0, 0, 153); font-size: 14px; font-weight: bold" text="Planeamiento"/>
                                                        <h:panelGrid columns="2" id="gridPlaneamieto1" title="Planeamiento" width="383">
                                                            <webuijsf:label id="labelFechaIni" style="width: 15px" text="Fecha Inicial"/>
                                                            <webuijsf:calendar binding="#{ABMOrdenesTrabajo.uiFechaIni}" id="uiFechaIni"/>
                                                            <webuijsf:label id="labelFechaFin" style="width: 15px" text="Fecha Final"/>
                                                            <webuijsf:calendar binding="#{ABMOrdenesTrabajo.uiFechaFin}" id="uiFechaFin"/>
                                                        </h:panelGrid>
                                                        <webuijsf:label id="labelProgreso" style="border-width: 1px; color: #0000ff; height: 58px; width: 401px" text="Progreso"/>
                                                        <h:panelGrid columns="2" id="gridEstado1" style="border-width: 1px; " width="359">
                                                            <webuijsf:label id="labelEstado" style="width: 15px" text="Estado"/>
                                                            <webuijsf:dropDown binding="#{ABMOrdenesTrabajo.uiEstado}" id="uiEstado" items="#{ABMOrdenesTrabajo.uiEstadoDefaultOptions.options}"/>
                                                            <webuijsf:label id="labelCant" style="width: 15px" text="Cantidad Producida"/>
                                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiCantidadProducida}" columns="30" disabled="true"
                                                                id="uiCantidadProducida" style="text-align: right"/>
                                                        </h:panelGrid>
                                                        <webuijsf:label id="labelCostos1" style="color: #0033cc" text="Costos"/>
                                                        <h:panelGrid columns="2" id="gridCosto1" style="border-width: 1px; height: 58px" width="383">
                                                            <webuijsf:label id="labelCostoInic" style="width: 15px" text="Costo Previsto"/>
                                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiCostoPrevisto}" columns="30" id="uiCostoPrevisto" style="text-align: right"/>
                                                            <webuijsf:label id="labelCostoReal" style="width: 15px" text="Costo Real"/>
                                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiCostoReal}" columns="30" disabled="true"
                                                                id="uiCostoReal" style="text-align: right"/>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <h:panelGrid columns="2" id="gridPanelCabecera2" style="height: 72px" width="623">
                                                    <h:panelGrid columns="2" id="gridPanelNroOT1" width="431">
                                                        <webuijsf:label id="labelNroOT1" style="font-size: 14px" text="Nro OT"/>
                                                        <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiNroOT}" id="uiNroOT" style="background-position: 100% 50%; font-size: 18px; font-weight: bold; text-align: center"/>
                                                    </h:panelGrid>
                                                    <h:panelGrid columns="3" id="gridPanelResponsable2" style="height: 100%; width: 100%">
                                                        <webuijsf:hyperlink id="responsable1"
                                                            onClick="doPopup('form1:tabSet2:tab1:layoutPanel1:uiResponsableCodigo_field', 'form1:tabSet2:tab1:layoutPanel1:uiResponsableNombre_field')&#xd;&#xa;&#xd;&#xa;"
                                                            target="popup" text="Responsable" url="faces/popup/popupEmpleados.jsp"/>
                                                        <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiResponsableCodigo}" columns="10" id="uiResponsableCodigo"/>
                                                        <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiResponsableNombre}" columns="35" disabled="true" id="uiResponsableNombre"/>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <webuijsf:label id="labelDetalleSemiTer1" style="color: rgb(0, 0, 153); font-size: 14px; font-weight: bold" text="Produccion"/>
                                            </webuijsf:panelLayout>
                                        </webuijsf:tab>
                                    </webuijsf:tabSet>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="buttonsPanelAddUpdate1" style="height: 24px; margin-left: 540px" width="191">
                                    <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiCancelButton_action}" id="uiButtonCancelRegistro"
                                        style="font-size: 14px; height: 24px" text="Cancelar"/>
                                    <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonGuardarRegistro_action}"
                                        binding="#{ABMOrdenesTrabajo.uiButtonGuardarRegistro}" id="uiButtonGuardarRegistro"
                                        style="font-size: 14px; height: 24px" text="Guardar"/>
                                    <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uibuttonGuardarEdicion_action}"
                                        binding="#{ABMOrdenesTrabajo.uibuttonGuardarEdicion}" id="uibuttonGuardarEdicion" style="font-size: 14px; height: 24px" text="Guardar"/>
                                    <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uibuttonGuardarCostos_action}"
                                        binding="#{ABMOrdenesTrabajo.uibuttonGuardarCostos}" id="uibuttonGuardarCostos" style="font-size: 14px; height: 24px" text="Guardar"/>
                                    <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uibuttonCalcularCostos_action}"
                                        binding="#{ABMOrdenesTrabajo.uibuttonCalcularCostos}" id="uibuttonCalcularCostos" style="font-size: 14px; height: 24px" text="Calcular Costos"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMOrdenesTrabajo.gridPanelDetalleOT}" id="gridPanelDetalleOT">
                                <webuijsf:label id="labelDetalleSemiTer2" style="color: rgb(0, 0, 153); font-size: 14px; font-weight: bold" text="Detalle Semi Terminados"/>
                                <webuijsf:tabSet id="tabSet3" lite="true" mini="true" selected="tab3" style="height: 120px; width: 839px">
                                    <webuijsf:tab id="tab3" text="Agregar">
                                        <webuijsf:panelLayout id="layoutPanel3" style="height: 62px; position: relative; width: 100%; -rave-layout: grid">
                                            <h:panelGrid columns="6" id="gridPanelAddUpdate1" style="height: 48px" width="816">
                                                <webuijsf:hyperlink id="producto1"
                                                    onClick="doPopup('form1:tabSet3:tab3:layoutPanel3:uiDetSemiTerCodProd_field', 'form1:tabSet3:tab3:layoutPanel3:uiDetSemiTerProdDesc_field')"
                                                    target="popup" text="Producto Semiterminado" url="/faces/popup/popupProductosSemiter.jsp"/>
                                                <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiDetSemiTerCodProd}" columns="10" id="uiDetSemiTerCodProd"/>
                                                <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiDetSemiTerProdDesc}" columns="55" disabled="true" id="uiDetSemiTerProdDesc"/>
                                                <webuijsf:label id="cantidad2" text="Cantidad"/>
                                                <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiDetSemiTerCant}" id="uiDetSemiTerCant" valueChangeListenerExpression="#{ABMOrdenesTrabajo.uiDetSemiTerCant_processValueChange}"/>
                                                <webuijsf:checkbox binding="#{ABMOrdenesTrabajo.uiDetSemiTerFin}" id="uiDetSemiTerFin" label="Fin"/>
                                            </h:panelGrid>
                                            <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.buttonAgregar_action}"
                                                binding="#{ABMOrdenesTrabajo.uiButtonAgregarDetalleOt}" id="uiButtonAgregarDetalleOt" text="Agregar"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <h:panelGrid id="gridPanelTabla1" style="height: 154px" summary="Productos" title="Productos" width="935">
                                    <webuijsf:table augmentTitle="false" binding="#{ABMOrdenesTrabajo.tableSemiterminados1}" id="tableSemiterminados1"
                                        paginateButton="true" paginationControls="true" title="Productos Semiterminados" width="839">
                                        <webuijsf:tableRowGroup binding="#{ABMOrdenesTrabajo.tablaSemiterminadosRW}"
                                            emptyDataMsg="No se encontraron registros..." id="tablaSemiterminadosRW" rows="10"
                                            sourceData="#{ABMOrdenesTrabajo.detallesOrdenTrabajo}" sourceVar="currentRow">
                                            <webuijsf:tableColumn headerText="Cod Prod" id="tableColumn7" sort="codProducto" width="113">
                                                <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProducto'].codProducto}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn127" width="242">
                                                <webuijsf:staticText id="staticText121" text="#{currentRow.value['codProducto']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" headerText="Fin" id="tableColumn30" width="30">
                                                <webuijsf:staticText id="staticText21" text="#{currentRow.value['semiFin']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cantidad" id="tableColumn8" width="60">
                                                <webuijsf:staticText id="staticText6" text="#{currentRow.value['cantidad']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cant Prod" id="tableColumn9" width="70">
                                                <webuijsf:staticText id="staticText7" text="#{currentRow.value['cantidadReal']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="right" binding="#{ABMOrdenesTrabajo.tableColumnCostoSemi}" headerText="Costo Final" id="tableColumnCostoSemi">
                                                <webuijsf:staticText id="staticText23" text="#{currentRow.value['costoReal']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Est" id="tableColumn10" sort="estado" width="87">
                                                <webuijsf:staticText id="staticText8" text="#{currentRow.value['estado']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" binding="#{ABMOrdenesTrabajo.tableColumnVerDetalles}"
                                                id="tableColumnVerDetalles" valign="top" width="94">
                                                <webuijsf:hyperlink actionExpression="#{ABMOrdenesTrabajo.uiSemiTerDetLynkRecusos_action}"
                                                    binding="#{ABMOrdenesTrabajo.uiSemiTerDetLynkRecusos}" id="uiSemiTerDetLynkRecusos" text="Ver Detalles ...">
                                                    <f:setPropertyActionListener target="#{ABMOrdenesTrabajo.itemDetalleOt}" value="#{currentRow.tableRow.rowId}"/>
                                                </webuijsf:hyperlink>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" binding="#{ABMOrdenesTrabajo.tableColumnEditSemiter}"
                                                id="tableColumnEditSemiter" valign="top" width="20">
                                                <webuijsf:imageHyperlink actionExpression="#{ABMOrdenesTrabajo.uiEditDetLynk_action}"
                                                    binding="#{ABMOrdenesTrabajo.uiEditDetLynk}" id="uiEditDetLynk" imageURL="/resources/Images/edit_16x16.gif" text="">
                                                    <f:setPropertyActionListener target="#{ABMOrdenesTrabajo.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                </webuijsf:imageHyperlink>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" binding="#{ABMOrdenesTrabajo.tableColumnDelSemiTer}" id="tableColumnDelSemiTer"
                                                valign="top" width="33">
                                                <webuijsf:imageHyperlink actionExpression="#{ABMOrdenesTrabajo.uiRemoDetLynk_action}"
                                                    binding="#{ABMOrdenesTrabajo.uiRemoDetLynk}" id="uiRemoDetLynk" imageURL="/resources/Images/delete.gif" text="">
                                                    <f:setPropertyActionListener target="#{ABMOrdenesTrabajo.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                </webuijsf:imageHyperlink>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMOrdenesTrabajo.gridPanelDetalleSemiter}" id="gridPanelDetalleSemiter" style="width: 100%; height: 100%;">
                                <webuijsf:label id="labelDetalleSemiTer3" style="color: rgb(0, 0, 153); font-size: 14px; font-weight: bold" text="SemiTerminados / Detalle de Recursos y Tareas"/>
                                <webuijsf:label id="labelProduccion1" style="color: rgb(0, 51, 204)" text="Descripcion de la Produccion"/>
                                <h:panelGrid columns="2" id="gridPanelCabeceraSemiTer1" style="border-width: 1px; border-style: double; vertical-align: top" width="700">
                                    <h:panelGrid columns="2" id="gridPanelProduccionSemitTer1" style="border-width: 1px; height: 264px" width="431">
                                        <webuijsf:label id="label9" text="Codigo Sub-OT"/>
                                        <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerCabcod}" columns="25" disabled="true" id="uiSemiTerCabcod"/>
                                        <webuijsf:hyperlink id="codigo_Semiterminado1"
                                            onClick="doPopup('form1:uiSemiTerCabProductoCod_field', 'form1:uiSemiTerCabProductoDesc_field')" target="popup"
                                            text="Codigo Semiterminado" url="/faces/popup/popupProductosSemiter.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanel7" style="width: 100%; height: 100%;">
                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerCabProductoCod}" columns="8" id="uiSemiTerCabProductoCod"/>
                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerCabProductoDesc}" columns="40" disabled="true" id="uiSemiTerCabProductoDesc"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="linkFormula2"
                                            onClick="doPopup('form1:uiSemiTerCabFormulaCodigo_field', 'form1:uiSemiTerCabFormulaDesc_field')" target="popup"
                                            text="Formula" url="/faces/popup/popupFormulasSemiter.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanel8" style="height: 100%; width: 100%">
                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerCabFormulaCodigo}" columns="8" id="uiSemiTerCabFormulaCodigo"/>
                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerCabFormulaDesc}" columns="40" disabled="true" id="uiSemiTerCabFormulaDesc"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelDescrip2" text="Descripcion"/>
                                        <webuijsf:textArea binding="#{ABMOrdenesTrabajo.uiSemiTerCabDesc}" columns="35" id="uiSemiTerCabDesc" rows="4"/>
                                        <webuijsf:label id="labelCantidad2" text="Cantidad"/>
                                        <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerCabCant}" id="uiSemiTerCabCant"/>
                                        <webuijsf:label id="labelCantidad3" text="Cantidad Prod"/>
                                        <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerCabCantProd}" disabled="true" id="uiSemiTerCabCantProd"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanelActivar1" style="height: 288px; text-align: center" width="216">
                                        <webuijsf:label binding="#{ABMOrdenesTrabajo.activarLabel}" id="activarLabel"
                                            style="font-size: 14px; bottom: 1px; vertical-align: top" text="Activado"/>
                                        <webuijsf:checkbox binding="#{ABMOrdenesTrabajo.uiSemiTerCabActivoCheck}" id="uiSemiTerCabActivoCheck" readOnly="true"/>
                                        <h:panelGrid id="gridPanel3" style="height: 115px" width="236">
                                            <webuijsf:label binding="#{ABMOrdenesTrabajo.uiLabelDetCabCosto}" id="uiLabelDetCabCosto"
                                                style="color: #cc0000; font-size: 12px; font-weight: bold" text="Costo Total"/>
                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerCabCostoTotal}" disabled="true"
                                                id="uiSemiTerCabCostoTotal" style="background-position: right; color: rgb(204, 0, 0); font-size: 14px; font-weight: bold; text-align: right"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="buttonsPanelAddUpdate2" style="height: 24px; margin-left: 540px" width="191">
                                    <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonSemiterVolver_action}"
                                        binding="#{ABMOrdenesTrabajo.uiButtonSemiterVolver}" id="uiButtonSemiterVolver" mini="true"
                                        style="font-size: 14px; height: 24px" text="Volver"/>
                                </h:panelGrid>
                                <h:panelGrid columns="1" id="gridPanelDetalleSemiTer1" style="width: 100%; height: 100%;">
                                    <h:panelGrid binding="#{ABMOrdenesTrabajo.gridPanelDetalleSemiTerRecursos1}" columns="1"
                                        id="gridPanelDetalleSemiTerRecursos1" style="width: 100%; height: 100%;">
                                        <webuijsf:tabSet id="tabSet5" lite="true" mini="true" selected="tab5" style="height: 96px; width: 695px">
                                            <webuijsf:tab actionExpression="#{ABMOrdenesTrabajo.tab5_action}" id="tab5" text="Recursos">
                                                <webuijsf:panelLayout id="layoutPanel5" style="height: 38px; position: relative; width: 100%; -rave-layout: grid">
                                                    <h:panelGrid columns="5" id="gridPanelAddUpdate2" style="height: 48px" width="624">
                                                        <webuijsf:hyperlink id="producto2"
                                                            onClick="doPopup('form1:tabSet5:tab5:layoutPanel5:uiSemiTerDetCodRecurso_field', 'form1:tabSet5:tab5:layoutPanel5:uiSemiTerDetDescRecurso_field')"
                                                            target="popup" text="Recursos" url="/faces/popup/popupMateriasInsumos.jsp"/>
                                                        <h:panelGrid columns="2" id="gridPanel4" style="width: 100%; height: 100%;">
                                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerDetCodRecurso}" columns="10" id="uiSemiTerDetCodRecurso"/>
                                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerDetDescRecurso}" columns="50"
                                                                disabled="true" id="uiSemiTerDetDescRecurso"/>
                                                        </h:panelGrid>
                                                        <webuijsf:label id="cantidad1" text="Cantidad"/>
                                                        <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerDetCantRecurso}" columns="10" id="uiSemiTerDetCantRecurso"/>
                                                        <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonSemiTerAddDetalleRecurso_action}"
                                                            binding="#{ABMOrdenesTrabajo.uiButtonSemiTerAddDetalleRecurso}"
                                                            id="uiButtonSemiTerAddDetalleRecurso" text="Agregar"/>
                                                    </h:panelGrid>
                                                </webuijsf:panelLayout>
                                            </webuijsf:tab>
                                        </webuijsf:tabSet>
                                        <h:panelGrid id="gridPanelRecursos1" style="background-position: top top; height: 154px; vertical-align: top" width="935">
                                            <webuijsf:table augmentTitle="false" id="tableRecursos1" paginateButton="true" paginationControls="true"
                                                title="Detalle de Recusos SemiTerminados" width="695">
                                                <webuijsf:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{ABMOrdenesTrabajo.recursosAsignadosOt}" sourceVar="currentRow">
                                                    <webuijsf:tableColumn headerText="Cod Prod" id="tableColumn114" sort="codProducto">
                                                        <webuijsf:staticText id="staticText119" text="#{currentRow.value['codProducto'].codProducto}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Descripcion" id="tableColumn14" sort="codProducto" width="231">
                                                        <webuijsf:staticText id="staticText9" text="#{currentRow.value['codProducto']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Unid Medid" id="tableColumn214">
                                                        <webuijsf:staticText id="staticText219" text="#{currentRow.value['codProducto'].codUnidadMedida}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Cantidad" id="tableColumn15" width="64">
                                                        <webuijsf:staticText id="staticText10" text="#{currentRow.value['cantidad']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Cant Usada" id="tableColumn28">
                                                        <webuijsf:staticText id="staticText19" text="#{currentRow.value['cantidadReal']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" binding="#{ABMOrdenesTrabajo.tableColumnRecursosEdit}"
                                                        id="tableColumnRecursosEdit" valign="top" width="47">
                                                        <webuijsf:imageHyperlink binding="#{ABMOrdenesTrabajo.uiSemiTerDetEditRecursoLink}"
                                                            id="uiSemiTerDetEditRecursoLink" imageURL="/resources/Images/edit_16x16.gif" text="">
                                                            <f:setPropertyActionListener target="#{ABMOrdenesTrabajo.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                        </webuijsf:imageHyperlink>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" binding="#{ABMOrdenesTrabajo.tableColumnRecursosDel}"
                                                        id="tableColumnRecursosDel" valign="top">
                                                        <webuijsf:imageHyperlink actionExpression="#{ABMOrdenesTrabajo.uiSemiTerRemoveRecursoLink_action}"
                                                            binding="#{ABMOrdenesTrabajo.uiSemiTerRemoveRecursoLink}" id="uiSemiTerRemoveRecursoLink"
                                                            imageURL="/resources/Images/delete.gif" text="">
                                                            <f:setPropertyActionListener target="#{ABMOrdenesTrabajo.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                        </webuijsf:imageHyperlink>
                                                    </webuijsf:tableColumn>
                                                </webuijsf:tableRowGroup>
                                            </webuijsf:table>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid binding="#{ABMOrdenesTrabajo.gridPanelDetalleSemiTerTareas1}" columns="1" id="gridPanelDetalleSemiTerTareas1" style="width: 100%; height: 100%;">
                                        <webuijsf:tabSet id="tabSet1" lite="true" mini="true" selected="tab2" style="height: 96px; width: 695px">
                                            <webuijsf:tab id="tab2" text="Tareas">
                                                <webuijsf:panelLayout id="layoutPanel2" style="height: 38px; position: relative; width: 685px; -rave-layout: grid">
                                                    <h:panelGrid columns="6" id="gridPanelAddUpdate3" style="height: 48px" width="624">
                                                        <webuijsf:hyperlink id="tareas1"
                                                            onClick="doPopup('form1:tabSet1:tab2:layoutPanel2:uiSemiTerDetCodTarea_field', 'form1:tabSet1:tab2:layoutPanel2:uiSemiTerDetDescTarea_field')"
                                                            target="popup" text="Tareas" url="/faces/popup/popupTareas.jsp"/>
                                                        <h:panelGrid columns="2" id="gridPanel5" style="width: 100%; height: 100%;">
                                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerDetCodTarea}" columns="10" id="uiSemiTerDetCodTarea"/>
                                                            <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerDetDescTarea}" columns="50"
                                                                disabled="true" id="uiSemiTerDetDescTarea"/>
                                                        </h:panelGrid>
                                                        <webuijsf:label id="cantidad4" text="Cantidad"/>
                                                        <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiSemiTerDetCantTarea}" columns="10" id="uiSemiTerDetCantTarea"/>
                                                        <webuijsf:checkbox binding="#{ABMOrdenesTrabajo.uiSemiTerDetFin}" id="uiSemiTerDetFin" label="Fin"/>
                                                        <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonSemiTerAddDetalleTarea_action}"
                                                            binding="#{ABMOrdenesTrabajo.uiButtonSemiTerAddDetalleTarea}" id="uiButtonSemiTerAddDetalleTarea" text="Agregar"/>
                                                    </h:panelGrid>
                                                </webuijsf:panelLayout>
                                            </webuijsf:tab>
                                        </webuijsf:tabSet>
                                        <h:panelGrid id="gridPanelTareas1" style="background-position: top top; height: 154px; vertical-align: top" width="935">
                                            <webuijsf:table augmentTitle="false" id="tableTareas1" paginateButton="true" paginationControls="true"
                                                title="Detalle de Tareas" width="695">
                                                <webuijsf:tableRowGroup id="tableRowGroup3" rows="10" sourceData="#{ABMOrdenesTrabajo.tareasAsignadasOt}" sourceVar="currentRow">
                                                    <webuijsf:tableColumn headerText="Codigo" id="tableColumn18" sort="codTarea" width="113">
                                                        <webuijsf:staticText id="staticText11" text="#{currentRow.value['codTarea'].codTarea}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Tarea" id="tableColumn19" width="286">
                                                        <webuijsf:staticText id="staticText12" text="#{currentRow.value['codTarea']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" headerText="Fin" id="tableColumn31">
                                                        <webuijsf:staticText id="staticText22" text="#{currentRow.value['tareaFin']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" headerText="Cantidad" id="tableColumn20" width="106">
                                                        <webuijsf:staticText id="staticText13" text="#{currentRow.value['cantidad']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn headerText="Cant Prod" id="tableColumn29">
                                                        <webuijsf:staticText id="staticText20" text="#{currentRow.value['cantidadReal']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" binding="#{ABMOrdenesTrabajo.tableColumTareasEdit}"
                                                        id="tableColumTareasEdit" valign="top" width="36">
                                                        <webuijsf:imageHyperlink actionExpression="#{ABMOrdenesTrabajo.uiSemiTerDetEditTareaLink_action}"
                                                            binding="#{ABMOrdenesTrabajo.uiSemiTerDetEditTareaLink}" id="uiSemiTerDetEditTareaLink"
                                                            imageURL="/resources/Images/edit_16x16.gif" text="">
                                                            <f:setPropertyActionListener target="#{ABMOrdenesTrabajo.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                        </webuijsf:imageHyperlink>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn align="center" binding="#{ABMOrdenesTrabajo.tableColumnTareasDel}"
                                                        id="tableColumnTareasDel" valign="top" width="40">
                                                        <webuijsf:imageHyperlink actionExpression="#{ABMOrdenesTrabajo.uiSemiTerDetRemoveTareaLink_action}"
                                                            binding="#{ABMOrdenesTrabajo.uiSemiTerDetRemoveTareaLink}" id="uiSemiTerDetRemoveTareaLink"
                                                            imageURL="/resources/Images/delete.gif" text="">
                                                            <f:setPropertyActionListener target="#{ABMOrdenesTrabajo.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                        </webuijsf:imageHyperlink>
                                                    </webuijsf:tableColumn>
                                                </webuijsf:tableRowGroup>
                                            </webuijsf:table>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid binding="#{ABMOrdenesTrabajo.gridPanelGenerarSolicitudes}" id="gridPanelGenerarSolicitudes" style="height: 100%; width: 100%">
                                        <webuijsf:label id="label5" style="color: red; font-size: 14px; font-weight: bold" text="Los siguientes productos faltan en deposito para la Activacion de la Ot. Puede Generar las Solicitudes de Compra."/>
                                        <webuijsf:table augmentTitle="false" id="uiTableSolicitudes" paginateButton="true" paginationControls="true"
                                            title="Generacion de Solicitudes" width="815">
                                            <webuijsf:tableRowGroup id="tableRowGroup4" rows="10" sourceData="#{ABMOrdenesTrabajo.solicitudesAGenerarse}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Fecha" id="tableColumn23" width="89">
                                                    <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText14" text="#{currentRow.value['fecha']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Producto" id="tableColumn24" sort="codProducto" width="359">
                                                    <webuijsf:staticText id="staticText15" text="#{currentRow.value['codProducto']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cantidad" id="tableColumn25" width="74">
                                                    <webuijsf:staticText id="staticText16" text="#{currentRow.value['cantidad']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Obs" id="tableColumn26">
                                                    <webuijsf:staticText id="staticText18" text="#{currentRow.value['observacion']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn27" valign="top" width="12">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMOrdenesTrabajo.uiLinkGenerarSolicitud_action}"
                                                        id="uiLinkGenerarSolicitud" imageURL="/resources/Images/aprobado.gif" text="">
                                                        <f:setPropertyActionListener target="#{ABMOrdenesTrabajo.itemSolicitud}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonSolicitudVolver_action}" id="uiButtonSolicitudVolver" text="Volver"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                            <webuijsf:messageGroup id="messageGroup1"/>
                            <h:panelGrid binding="#{ABMOrdenesTrabajo.gridPanelCostos}" id="gridPanelCostos" style="width: 100%; height: 100%;">
                                <webuijsf:label id="labelDetalleSemiTer4" style="color: rgb(0, 0, 153); font-size: 14px; font-weight: bold" text="SemiTerminados / Detalle de Costos Finales"/>
                                <webuijsf:label id="labelProduccion2" style="color: rgb(0, 51, 204)" text="Costos de Produccion"/>
                                <webuijsf:table augmentTitle="false" id="tableMatPrima" paginateButton="true" paginationControls="true"
                                    title="Detalle De Costos de Materias Primas" width="815">
                                    <webuijsf:tableRowGroup id="tableRowGroup5" rows="10" sourceData="#{ABMOrdenesTrabajo.costosMatOt}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" headerText="Producto" id="tableColumn12" sort="codProducto" width="200">
                                            <webuijsf:staticText id="staticText24" text="#{currentRow.value['codProducto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="right" headerText="Cantidad" id="tableColumn13" width="100">
                                            <webuijsf:staticText id="staticText25" text="#{currentRow.value['cantidad']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="right" headerText="Costo Unitario" id="tableColumn32" width="100">
                                            <webuijsf:staticText id="staticText26" text="#{currentRow.value['costoUnitario']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="right" headerText="Costo Total" id="tableColumn39" width="100">
                                            <webuijsf:staticText id="staticText33" text="#{currentRow.value['costoTotal']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <webuijsf:tabSet id="tabSetCostos" lite="true" mini="true" selected="tabCostos" style="height: 120px; width: 767px">
                                    <webuijsf:tab id="tabCostos" text="Costos Hora Hombre">
                                        <webuijsf:panelLayout id="layoutPanel4" style="height: 38px; position: relative; width: 757px; -rave-layout: grid">
                                            <h:panelGrid columns="6" id="gridPanelCostoHombre" style="height: 48px" width="744">
                                                <webuijsf:label id="empleado" text="Empleado"/>
                                                <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiDetCostoHombreEmpleado}" columns="60" disabled="true" id="uiDetCostoHombreEmpleado"/>
                                                <webuijsf:label id="label6" text="Costo x Hora"/>
                                                <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiDetCostoHombreCosto}" id="uiDetCostoHombreCosto"/>
                                                <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonActualizarCostoHombre_action}"
                                                    id="uiButtonActualizarCostoHombre" text="Actualizar"/>
                                            </h:panelGrid>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <webuijsf:table augmentTitle="false" id="tableHorasHombre" paginateButton="true" paginationControls="true"
                                    title="Detalle de Costos Horas Hombre" width="815">
                                    <webuijsf:tableRowGroup id="tableRowGroup6" rows="10" sourceData="#{ABMOrdenesTrabajo.costosHoraOt}" sourceVar="currentRow">
                                        <webuijsf:tableColumn headerText="Empleado" id="tableColumn33" sort="codEmpleado" width="200">
                                            <webuijsf:staticText id="staticText27" text="#{currentRow.value['codEmpleado']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="right" headerText="Cantidad Horas" id="tableColumn34" width="100">
                                            <webuijsf:staticText id="staticText28" text="#{currentRow.value['cantidadHoras']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="right" headerText="Costo Hora" id="tableColumn35" width="100">
                                            <webuijsf:staticText id="staticText29" text="#{currentRow.value['costoHora']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="right" headerText="CostoTotal" id="tableColumn40" width="100">
                                            <webuijsf:staticText id="staticText34" text="#{currentRow.value['costoTotal']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="center" binding="#{ABMOrdenesTrabajo.tableColumn42}" id="tableColumn42" width="40">
                                            <webuijsf:imageHyperlink actionExpression="#{ABMOrdenesTrabajo.uiDetCostoEditarCostoHombre}"
                                                binding="#{ABMOrdenesTrabajo.uiDetCostoEditarCostoHombre}" id="uiDetCostoEditarCostoHombre"
                                                imageURL="/resources/Images/edit_16x16.gif" text="">
                                                <f:setPropertyActionListener target="#{ABMOrdenesTrabajo.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                            </webuijsf:imageHyperlink>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <webuijsf:tabSet id="tabSetGastosFijos" lite="true" mini="true" selected="tabGastosFijos" style="height: 120px; width: 767px">
                                    <webuijsf:tab id="tabGastosFijos" text="Gastos Fijos">
                                        <webuijsf:panelLayout id="layoutPanel6" style="height: 62px; position: relative; width: 100%; -rave-layout: grid">
                                            <h:panelGrid columns="7" id="gridPanelGastoFijo" style="height: 48px" width="744">
                                                <webuijsf:label id="label7" text="Descripcion"/>
                                                <webuijsf:textArea binding="#{ABMOrdenesTrabajo.uiDetCostoFijoDescripcion}" columns="45"
                                                    id="uiDetCostoFijoDescripcion" rows="3"/>
                                                <h:panelGrid columns="2" id="gridPanel9" style="height: 100%" width="239">
                                                    <webuijsf:label id="label10" text="Costo Unit"/>
                                                    <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiDetCostoFijoCostoUnit}" id="uiDetCostoFijoCostoUnit"/>
                                                    <webuijsf:label id="label11" text="Cantidad"/>
                                                    <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiDetCostoFijoCantidad}" id="uiDetCostoFijoCantidad"/>
                                                    <webuijsf:label id="label8" text="Monto"/>
                                                    <webuijsf:textField binding="#{ABMOrdenesTrabajo.uiDetCostoFijoMonto}" disabled="true" id="uiDetCostoFijoMonto"/>
                                                </h:panelGrid>
                                                <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonInsertarGasto_action}" id="uiButtonInsertarGasto" text="Insertar"/>
                                            </h:panelGrid>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <webuijsf:table augmentTitle="false" id="tableGastosFijos" paginateButton="true" paginationControls="true"
                                    title="Detalle de gastos Fijos" width="767">
                                    <webuijsf:tableRowGroup id="tableRowGroup7" rows="10" sourceData="#{ABMOrdenesTrabajo.costosFijosOt}" sourceVar="currentRow">
                                        <webuijsf:tableColumn headerText="Descripcion del gasto" id="tableColumn36" sort="descripcionGasto" width="400">
                                            <webuijsf:staticText id="staticText30" text="#{currentRow.value['descripcionGasto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="CostoUnitario" id="tableColumn11" width="100">
                                            <webuijsf:staticText id="staticText32" text="#{currentRow.value['costoUnitario']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cant" id="tableColumn16" width="70">
                                            <webuijsf:staticText id="staticText35" text="#{currentRow.value['cantidad']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="right" headerText="Total" id="tableColumn37" width="100">
                                            <webuijsf:staticText id="staticText31" text="#{currentRow.value['monto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="center" binding="#{ABMOrdenesTrabajo.tableColumn38}" id="tableColumn38" width="23">
                                            <webuijsf:imageHyperlink actionExpression="#{ABMOrdenesTrabajo.uiDetCostoEditarGastoFijo}"
                                                binding="#{ABMOrdenesTrabajo.uiDetCostoEditarGastoFijo}" id="uiDetCostoEditarGastoFijo"
                                                imageURL="/resources/Images/edit_16x16.gif" text="">
                                                <f:setPropertyActionListener target="#{ABMOrdenesTrabajo.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                            </webuijsf:imageHyperlink>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="center" id="tableColumn41" width="23">
                                            <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/Images/delete.gif" text=""/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <webuijsf:button actionExpression="#{ABMOrdenesTrabajo.uiButtonVolverCostos_action}" id="uiButtonVolverCostos" text="Volver"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
