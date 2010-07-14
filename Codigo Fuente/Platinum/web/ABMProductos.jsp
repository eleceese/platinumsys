<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ABMCliente
    Created on : Oct 18, 2009, 8:11:57 PM
    Author     : FerBoy
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                    <!-- \SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <script>
                        function initAllRows() {
                            var table = document.getElementById("form1:tableProductos");
                            table.initAllRows();}
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
                    <df:ajaxTransaction id="ajaxGenerico" inputs="page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel10:uiLstTipoProducto" render="page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel10:uiLstTipoProducto,page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel2:uiLstMarca,page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel13:uiPrecioActual,page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel9:uiControlExistencia,page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel4:uiPorcentajeIVA,page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel7:uiContenido,page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel12:uiCostoActual,page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel8:uiStockMinimo,page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel14:uiUnidadMedida,page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel5:uiPresentacion,page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:gridPanel11:uiPorcentajeCom"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 239px; top: 213px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMProductos.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMProductos.gridPanelBuscar}" columns="4" id="gridPanelBuscar" style="height: 72px" width="743">
                                <webuijsf:label id="labelMarca" text="Marca"/>
                                <webuijsf:dropDown binding="#{ABMProductos.uiMarcaFil}" id="uiMarcaFil" items="#{ABMProductos.listaMarcasOp}" width="150"/>
                                <webuijsf:label id="tipoProducto" text="Tipo Prod"/>
                                <webuijsf:dropDown binding="#{ABMProductos.uiTipoProductoFil}" id="uiTipoProductoFil" items="#{ABMProductos.listaTipoProductosOp}"/>
                                <webuijsf:label id="descripcion" text="Descripcion"/>
                                <webuijsf:textArea binding="#{ABMProductos.uiDescripcionFil}" columns="40" id="uiDescripcionFil" rows="1"/>
                                <webuijsf:label id="labelPresentacion" text="Presentacion"/>
                                <webuijsf:dropDown binding="#{ABMProductos.uiPresentacionFil}" id="uiPresentacionFil"
                                    items="#{ABMProductos.listaPresentacionOp}" width="200"/>
                                <h:panelGrid columns="2" id="gridBotonesBuscar" style="height: 24px" width="143">
                                    <webuijsf:button actionExpression="#{ABMProductos.buscar_action}" id="buscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMProductos.todos_action}" id="todos" text="Todos"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMProductos.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" id="tableProductos" paginateButton="true" paginationControls="true" title="Productos" width="911">
                                    <webuijsf:tableRowGroup binding="#{ABMProductos.proveedores}" emptyDataMsg="No se encontraron registros..." id="proveedores"
                                        rows="15" selected="#{ABMProductos.selectedState}" sourceData="#{SessionBean1.listaProductos}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMProductos.tableColumn6}" id="tableColumn6"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMProductos.radioButton1.id}" valign="top">
                                            <webuijsf:radioButton binding="#{ABMProductos.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMProductos.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMProductos.selected}" selectedValue="#{ABMProductos.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="tableColumn1" sort="codProducto" width="103">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProducto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo Interno" id="tableColumn7" sort="codigoInterno" width="136">
                                            <webuijsf:staticText id="staticText6" text="#{currentRow.value['codigoInterno']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Marca" id="tableColumn2" sort="codMarca">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['codMarca']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Tipo" id="tableColumn3" sort="codTipoProducto" width="111">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codTipoProducto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Descripcion" id="tableColumn4" sort="descripcion" width="276">
                                            <webuijsf:staticText id="staticText4" text="#{currentRow.value['descripcion']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Presentacion" id="tableColumn5" sort="codPresentacion">
                                            <webuijsf:staticText id="staticText5" text="#{currentRow.value['codPresentacion']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMProductos.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 50px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMProductos.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMProductos.buttonEditar_action}" id="buttonEditar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMProductos.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMProductos.datosProducto}" id="datosProducto"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos del Producto"/>
                            <h:panelGrid binding="#{ABMProductos.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 336px" width="983">
                                <webuijsf:label id="codigo1" text="Codigo interno"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%">
                                    <webuijsf:textField binding="#{ABMProductos.uiCodInterno}" id="uiCodInterno" style="color: #ff0000; font-family: Geneva,Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold"/>
                                    <webuijsf:message for="uiCodInterno" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="tipo1" text="Tipo"/>
                                <h:panelGrid columns="2" id="gridPanel10" style="height: 100%" width="481">
                                    <webuijsf:dropDown binding="#{ABMProductos.uiLstTipoProducto}" id="uiLstTipoProducto"
                                        items="#{SessionBean1.listaTipoProductosOp}"
                                        onChange="DynaFaces.Tx.fire(&quot;ajaxGenerico&quot;,&quot;uiLstTipoProducto&quot;)"
                                        validatorExpression="#{ABMProductos.uiLstTipoProducto_validate}" width="200"/>
                                    <webuijsf:message id="message10" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelMarca1" text="Marca"/>
                                <h:panelGrid columns="2" id="gridPanel2" style="height: 100%" width="575">
                                    <webuijsf:dropDown binding="#{ABMProductos.uiLstMarca}" id="uiLstMarca" items="#{SessionBean1.listaMarcasOp}" width="250"/>
                                    <webuijsf:message for="uiLstMarca" id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="labelUnidadMedida" text="Descripcion"/>
                                <h:panelGrid columns="2" id="gridPanel6" style="height: 100%" width="551">
                                    <webuijsf:textArea binding="#{ABMProductos.uiDescripcion}" columns="50" id="uiDescripcion" rows="3" valueChangeListenerExpression="#{ABMProductos.uiDescripcion_processValueChange}"/>
                                    <webuijsf:message for="uiDescripcion" id="message6" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="unidadMedidaLB" text="Unidad de Medida"/>
                                <h:panelGrid columns="2" id="gridPanel14" style="height: 100%" width="582">
                                    <webuijsf:dropDown binding="#{ABMProductos.uiUnidadMedida}" id="uiUnidadMedida" items="#{SessionBean1.listaUnidadMedidasOp}" width="250"/>
                                    <webuijsf:message for="uiUnidadMedida" id="message14" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="presentacionLb" text="Presentacion"/>
                                <h:panelGrid columns="2" id="gridPanel5" style="height: 100%" width="575">
                                    <webuijsf:dropDown binding="#{ABMProductos.uiPresentacion}" id="uiPresentacion" items="#{SessionBean1.listaPresentacionsOp}" width="250"/>
                                    <webuijsf:message for="uiPresentacion" id="message5" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="costoActual3" text="Contenido"/>
                                <h:panelGrid columns="2" id="gridPanel7" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProductos.uiContenido}" columns="10" id="uiContenido"/>
                                    <webuijsf:message for="uiContenido" id="message7" showDetail="false" showSummary="true" style="width: 209px"/>
                                </h:panelGrid>
                                <webuijsf:label id="precioActual" text="Precio Actual"/>
                                <h:panelGrid columns="2" id="gridPanel13" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProductos.uiPrecioActual}" columns="50" id="uiPrecioActual"/>
                                    <webuijsf:message for="uiPrecioActual" id="message13" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="costoActual" text="Costo Actual"/>
                                <h:panelGrid columns="2" id="gridPanel12" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMProductos.uiCostoActual}" columns="50" id="uiCostoActual"/>
                                    <webuijsf:message for="uiCostoActual" id="message12" showDetail="false" showSummary="true" style="width: 209px"/>
                                </h:panelGrid>
                                <webuijsf:label id="costoActual2" text="Porcentaje IVA"/>
                                <h:panelGrid columns="3" id="gridPanel4" style="height: 100%" width="263">
                                    <webuijsf:textField binding="#{ABMProductos.uiPorcentajeIVA}" columns="4" id="uiPorcentajeIVA"/>
                                    <webuijsf:label id="costoActual4" text="%"/>
                                    <webuijsf:message for="uiPorcentajeIVA" id="message4" showDetail="false" showSummary="true" style="width: 209px"/>
                                </h:panelGrid>
                                <webuijsf:label id="costoActual5" text="Porcentaje Comision"/>
                                <h:panelGrid columns="3" id="gridPanel11" style="height: 100%" width="263">
                                    <webuijsf:textField binding="#{ABMProductos.uiPorcentajeCom}" columns="4" converter="#{ABMProductos.numberConverter1}" id="uiPorcentajeCom"/>
                                    <webuijsf:label id="costoActual6" text="%"/>
                                    <webuijsf:message for="uiPorcentajeCom" id="message11" showDetail="false" showSummary="true" style="width: 209px"/>
                                </h:panelGrid>
                                <webuijsf:label id="controlExistencia" text="Control Existencia"/>
                                <h:panelGrid columns="2" id="gridPanel9" style="height: 100%" width="100%">
                                    <webuijsf:checkbox binding="#{ABMProductos.uiControlExistencia}" id="uiControlExistencia" label="Si Controla"/>
                                    <webuijsf:message id="message9" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="costoActual1" text="Fecha Alta"/>
                                <h:panelGrid columns="2" id="gridPanel3" style="height: 100%" width="575">
                                    <webuijsf:calendar binding="#{ABMProductos.uiFechaAlta}" id="uiFechaAlta" readOnly="true"
                                        validatorExpression="#{ABMProductos.uiFechaAlta_validate}" valueChangeListenerExpression="#{ABMProductos.uiFechaAlta_processValueChange}"/>
                                    <webuijsf:message for="uiFechaAlta" id="message3" showDetail="false" showSummary="true" style="height: 24px"/>
                                </h:panelGrid>
                                <webuijsf:label id="stockminLabel" text="Stock Minimo"/>
                                <h:panelGrid columns="2" id="gridPanel8">
                                    <webuijsf:textField binding="#{ABMProductos.uiStockMinimo}" id="uiStockMinimo"/>
                                    <webuijsf:message for="uiStockMinimo" id="message8" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMProductos.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMProductos.cancelar_action}" id="cancelar" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{ABMProductos.buttonGuardarNuevo_action}" binding="#{ABMProductos.buttonGuardarNuevo}"
                                    id="buttonGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMProductos.buttonGuardarEdicion_action}" binding="#{ABMProductos.buttonGuardarEdicion}"
                                    id="buttonGuardarEdicion" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
