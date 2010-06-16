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
                        function ABMReciboDinero() {
                            var table = document.getElementById("form1:tableOrdenesTrabajo");
                            table.ABMReciboDinero();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar la Unidad de Medida Seleccionada?")) {
                                    return false;
                                }else{
                                    return true;
                                }
                            }
                        }
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
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
                            <webuijsf:pageAlert binding="#{RegistroEstadosOT.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{RegistroEstadosOT.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 72px" width="407">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height:30px; width: 60%">
                                    <webuijsf:label id="codigo" text="Codigo"/>
                                    <webuijsf:textField binding="#{RegistroEstadosOT.uiCodigoFil}" id="uiCodigoFil"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelUnidadMedida" style="height: 30px" width="263">
                                    <webuijsf:label id="unidadMedida1" text="Unidad de Medida"/>
                                    <webuijsf:textField binding="#{RegistroEstadosOT.uiUnidadMedidaFil}" id="uiUnidadMedidaFil"/>
                                </h:panelGrid>
                                <webuijsf:button id="buscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{RegistroEstadosOT.todos_action}" id="todos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroEstadosOT.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{RegistroEstadosOT.tableOrdenesTrabajo}" id="tableOrdenesTrabajo"
                                    paginateButton="true" paginationControls="true" title="Ordenes de Trabajo" width="791">
                                    <webuijsf:tableRowGroup binding="#{RegistroEstadosOT.ordenTrabajoRW}" emptyDataMsg="No se encontraron registros..."
                                        id="ordenTrabajoRW" rows="10" selected="#{RegistroEstadosOT.selectedState}"
                                        sourceData="#{RegistroEstadosOT.listaOrdenTrabajoCabeceras}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{RegistroEstadosOT.tableColumn3}" id="tableColumn3"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{RegistroEstadosOT.radioButton1.id}" width="48">
                                            <webuijsf:radioButton binding="#{RegistroEstadosOT.radioButton1}" id="radioButton1" label=""
                                                name="#{RegistroEstadosOT.radioButton1.id}" onClick="delSelect='ok' " selected="#{RegistroEstadosOT.selected}" selectedValue="#{RegistroEstadosOT.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cod OT" id="tableColumn4" width="61">
                                            <webuijsf:staticText id="staticText4" text="#{currentRow.value['codOrdenTrabjo']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Producto" id="tableColumn5" sort="codProductoOt" width="281">
                                            <webuijsf:staticText id="staticText5" text="#{currentRow.value['codProductoOt']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha AP" id="tableColumn6" sort="fechaOt" width="30">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText6" text="#{currentRow.value['fechaOt']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cant" id="tableColumn7" width="63">
                                            <webuijsf:staticText id="staticText7" text="#{currentRow.value['cantidadOt']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cant Prod" id="tableColumn8" width="74">
                                            <webuijsf:staticText id="staticText8" text="#{currentRow.value['cantidadProducidaOt']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn9" width="30">
                                            <webuijsf:staticText id="staticText9" text="#{currentRow.value['estadoOt']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroEstadosOT.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{RegistroEstadosOT.editar_action}" id="editar" text="Gestionar"/>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{RegistroEstadosOT.gridPanelAddUpdate}" columns="1" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <h:panelGrid columns="2" id="gridPanel1" style="width: 100%; height: 100%;">
                                    <h:panelGrid columns="2" id="gridPanelProduccion1" style="border-width: 1px; height: 187px" width="407">
                                        <webuijsf:label id="label2" text="Nro OT"/>
                                        <webuijsf:textField binding="#{RegistroEstadosOT.uiNroOt}" disabled="true" id="uiNroOt"/>
                                        <webuijsf:label id="label1" text="Producto"/>
                                        <h:panelGrid columns="2" id="gridPanelProducto1" style="text-align: left">
                                            <webuijsf:textField binding="#{RegistroEstadosOT.uiProductoCod}" columns="10" disabled="true" id="uiProductoCod"/>
                                            <webuijsf:textField binding="#{RegistroEstadosOT.uiProductoNombre}" columns="42" id="uiProductoNombre" readOnly="true"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelDescrip1" text="Descripcion"/>
                                        <webuijsf:textArea binding="#{RegistroEstadosOT.uiDescripcionOt1}" columns="52" disabled="true" id="uiDescripcionOt1" rows="5"/>
                                        <webuijsf:label id="labelEstado1" style="width: 15px" text="Estado"/>
                                        <h:panelGrid columns="2" id="gridPanel3" style="width: 100%; height: 100%;">
                                            <webuijsf:textField binding="#{RegistroEstadosOT.uiEstado}" columns="30" disabled="true" id="uiEstado" style="color: red; font-size: 14px"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanelPlanear1" style="height: 192px; width: 100%">
                                        <h:panelGrid columns="2" id="gridPlaneamieto1" title="Planeamiento" width="383">
                                            <webuijsf:label id="labelFechaIni1" style="width: 15px" text="Fecha Inicial"/>
                                            <webuijsf:calendar binding="#{RegistroEstadosOT.uiFechaIni1}" disabled="true" id="uiFechaIni1"/>
                                            <webuijsf:label id="labelFechaFin1" style="width: 15px" text="Fecha Final"/>
                                            <webuijsf:calendar binding="#{RegistroEstadosOT.uiFechaFin1}" disabled="true" id="uiFechaFin1"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelProgreso1" style="border-width: 1px; color: #0000ff; height: 58px; width: 401px" text="Progreso"/>
                                        <h:panelGrid columns="2" id="gridEstado1" style="border-width: 1px; " width="359">
                                            <webuijsf:label id="labelCant1" style="width: 15px" text="Cantidad Producida"/>
                                            <webuijsf:textField binding="#{RegistroEstadosOT.uiCantidadProducida1}" columns="30" disabled="true"
                                                id="uiCantidadProducida1" style="text-align: right"/>
                                            <webuijsf:label id="labelCantidad2" text="Cantidad"/>
                                            <h:panelGrid columns="2" id="gridPanel2" style="width: 100%; height: 100%;">
                                                <webuijsf:textField binding="#{RegistroEstadosOT.uiCantidad1}" disabled="true" id="uiCantidad1"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanel4" style="height: 100%; width: 100%">
                                    <webuijsf:staticText id="staticText1" style="color: rgb(0, 0, 102); font-size: 14px; font-weight: bold" text="Detalles de Ordenes de Trabajo"/>
                                    <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true"
                                        title="Detalles de Ordenes de Trabjo" width="743">
                                        <webuijsf:tableRowGroup emptyDataMsg="No posee detalles" id="tableRowGroup1" rows="10"
                                            sourceData="#{RegistroEstadosOT.detallesOrdenTrabajo}" sourceVar="currentRow">
                                            <webuijsf:tableColumn headerText="CodSubOT" id="tableColumn1" width="15">
                                                <webuijsf:staticText id="staticText2" text="#{currentRow.value['codOrdenTrabajoDet']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn2" sort="codProducto" width="213">
                                                <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProducto']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Fecha AP" id="tableColumn10" width="77">
                                                <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText10" text="#{currentRow.value['fechaAlta']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cant" id="tableColumn11" width="82">
                                                <webuijsf:staticText id="staticText11" text="#{currentRow.value['cantidad']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cant Prod" id="tableColumn12" width="74">
                                                <webuijsf:staticText id="staticText12" text="#{currentRow.value['cantidadReal']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Estado" id="tableColumn13" width="30">
                                                <webuijsf:staticText id="staticText13" text="#{currentRow.value['estado']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" id="tableColumn14" width="20">
                                                <webuijsf:hyperlink actionExpression="#{RegistroEstadosOT.uiActivarLynk_action}" id="uiActivarLynk" text="Activar">
                                                    <f:setPropertyActionListener target="#{RegistroEstadosOT.itemDetalleOt}" value="#{currentRow.tableRow.rowId}"/>
                                                </webuijsf:hyperlink>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" id="tableColumn15" width="20">
                                                <webuijsf:hyperlink actionExpression="#{RegistroEstadosOT.uiCerrarLynk_action}" id="uiCerrarLynk" text="Terminar">
                                                    <f:setPropertyActionListener target="#{RegistroEstadosOT.itemDetalleOt}" value="#{currentRow.tableRow.rowId}"/>
                                                </webuijsf:hyperlink>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                    <webuijsf:messageGroup id="messageGroup1"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{RegistroEstadosOT.gridPanelGenerarSolicitudes1}" id="gridPanelGenerarSolicitudes1" style="height: 100%; width: 100%">
                                    <webuijsf:label id="label3" style="color: red; font-size: 14px; font-weight: bold" text="Los siguientes productos faltan en deposito para la Activacion de la Ot. Puede Generar las Solicitudes de Compra."/>
                                    <webuijsf:table augmentTitle="false" id="uiTableSolicitudes1" paginateButton="true" paginationControls="true"
                                        title="Generacion de Solicitudes" width="815">
                                        <webuijsf:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{RegistroEstadosOT.solicitudesAGenerarse}" sourceVar="currentRow">
                                            <webuijsf:tableColumn headerText="Fecha" id="tableColumn16" sort="fecha">
                                                <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText14" text="#{currentRow.value['fecha']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn17" sort="codProducto">
                                                <webuijsf:staticText id="staticText15" text="#{currentRow.value['codProducto']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cantidad" id="tableColumn18" sort="cantidad">
                                                <webuijsf:staticText id="staticText16" text="#{currentRow.value['cantidad']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Obs" id="tableColumn19" sort="observacion">
                                                <webuijsf:staticText id="staticText17" text="#{currentRow.value['observacion']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" id="tableColumn20">
                                                <webuijsf:imageHyperlink actionExpression="#{RegistroEstadosOT.uiLinkGenerarSolicitud_action}"
                                                    id="uiLinkGenerarSolicitud" imageURL="/resources/Images/aprobado.gif">
                                                    <f:setPropertyActionListener target="#{RegistroEstadosOT.itemSolicitud}" value="#{currentRow.tableRow.rowId}"/>
                                                </webuijsf:imageHyperlink>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                    <webuijsf:button actionExpression="#{RegistroEstadosOT.uiButtonSolicitudVolver_action}" id="uiButtonSolicitudVolver1" text="Volver"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroEstadosOT.buttonsPanelAddUpdate}" columns="3" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{RegistroEstadosOT.cancelar_action}" id="cancelar" style="width: 65px" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{RegistroEstadosOT.uiButtonCerrar_action}" id="uiButtonCerrar" style="width: 65px" text="Terminar OT"/>
                                <webuijsf:button actionExpression="#{RegistroEstadosOT.buttonGuardarNuevo_action}"
                                    binding="#{RegistroEstadosOT.buttonGuardarNuevo}" id="buttonGuardarNuevo" style="width: 65px" text="Guardar"/>
                                <webuijsf:button actionExpression="#{RegistroEstadosOT.buttonGuardarEdicion1_action}" id="buttonGuardarEdicion1"
                                    style="width: 65px" text="Guardar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
