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
                        function RegistroEstadosOT() {
                            var table = document.getElementById("form1:table1");
                            table.RegistroEstadosOT();}
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
                        <h:panelGrid id="mainContainer" style="left: 216px; top: 216px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{RegistroDeInventario.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{RegistroDeInventario.gridPanelbusqueda}" id="gridPanelbusqueda">
                                <h:panelGrid columns="8" id="gridPanelFiltro">
                                    <webuijsf:label id="label1" text="Deposito"/>
                                    <webuijsf:dropDown binding="#{RegistroDeInventario.uiDepositoFil}" id="uiDepositoFil"
                                        items="#{SessionBean1.listaDepositosOp}" width="130px"/>
                                    <webuijsf:label id="label3" text="Fecha Ini"/>
                                    <webuijsf:calendar binding="#{RegistroDeInventario.uiFecha1Fil}" id="uiFecha1Fil"/>
                                    <webuijsf:label id="label2" text="Fecha Fin"/>
                                    <webuijsf:calendar binding="#{RegistroDeInventario.uiFecha2Fil}" id="uiFecha2Fil"/>
                                    <webuijsf:label id="label6" text="Estado"/>
                                    <webuijsf:dropDown binding="#{RegistroDeInventario.uiEstadoFil}" id="uiEstadoFil" items="#{RegistroDeInventario.uiEstadoFilDefaultOptions.options}"/>
                                    <webuijsf:button actionExpression="#{RegistroDeInventario.button1_action}" id="button1" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{RegistroDeInventario.uiButtonTodosFil_action}" id="uiButtonTodosFil" text="Todos"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanelTabla1">
                                    <webuijsf:table augmentTitle="false" binding="#{RegistroDeInventario.table1}" id="table1" paginateButton="true"
                                        paginationControls="true" title="Lista de Inventarios" width="791">
                                        <webuijsf:tableRowGroup binding="#{RegistroDeInventario.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                            selected="#{RegistroDeInventario.selectedState}" sourceData="#{RegistroDeInventario.listaInventariosCab}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" binding="#{RegistroDeInventario.tableColumn5}" id="tableColumn5"
                                                onClick="setTimeout('initAllRows()', 0)" selectId="#{RegistroDeInventario.radioButton1.id}" width="45">
                                                <webuijsf:radioButton binding="#{RegistroDeInventario.radioButton1}" id="radioButton1" label=""
                                                    name="#{RegistroDeInventario.radioButton1.id}" onClick="delSelect='ok'"
                                                    selected="#{RegistroDeInventario.selected}" selectedValue="#{RegistroDeInventario.selectedValue}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" headerText="Nro Inv" id="tableColumn6" sort="codInventario" width="80">
                                                <webuijsf:staticText id="staticText6" text="#{currentRow.value['codInventario']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" headerText="Deposito" id="tableColumn7" sort="codDeposito" width="60">
                                                <webuijsf:staticText id="staticText7" text="#{currentRow.value['codDeposito']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Descripcion" id="tableColumn9" width="250">
                                                <webuijsf:staticText id="staticText8" text="#{currentRow.value['descripcion']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Estado" id="tableColumn10" width="84">
                                                <webuijsf:staticText id="staticText9" text="#{currentRow.value['estado']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" headerText="Fecha" id="tableColumn11" width="98">
                                                <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText10" text="#{currentRow.value['fecInventario']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                                <h:panelGrid columns="3" id="gridPanelFiltro1" width="143">
                                    <webuijsf:button actionExpression="#{RegistroDeInventario.button4_action}" id="button4" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{RegistroDeInventario.button5_action}" id="button5" text="Editar"/>
                                    <webuijsf:button actionExpression="#{RegistroDeInventario.uiButtonAnular_action}" id="uiButtonAnular" text="Anular"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroDeInventario.gridPanelCabecera1}" id="gridPanelCabecera1" style="height: 312px">
                                <h:panelGrid binding="#{RegistroDeInventario.gridPanelCabecera}" columns="2" id="gridPanelCabecera" style="height: 72px" width="623">
                                    <h:panelGrid columns="2" id="gridPanelDatos1" style="height: 30px" width="575">
                                        <webuijsf:label id="nroInventario" text="Numero Inventario"/>
                                        <h:panelGrid columns="1" id="nro" style="text-align: left; width: 450px">
                                            <webuijsf:textField binding="#{RegistroDeInventario.uiNroInventario}" id="uiNroInventario" style="background-position: 100% 50%; color: rgb(255, 0, 51); font-family: Arial,Helvetica,sans-serif; font-size: 18px; font-style: normal; font-weight: bold; text-align: left"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labelfecha" text="Fecha"/>
                                        <h:panelGrid columns="1" id="fecha" style="text-align: left; width: 450px">
                                            <webuijsf:calendar binding="#{RegistroDeInventario.uiFechaInv}" id="uiFechaInv"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="labeldeposito" text="Deposito"/>
                                        <h:panelGrid binding="#{RegistroDeInventario.deposito}" columns="1" id="deposito" style="text-align: left; width: 450px">
                                            <webuijsf:dropDown binding="#{RegistroDeInventario.uiDeposito}" id="uiDeposito" items="#{SessionBean1.listaDepositosOp}"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="empleados" onClick="doPopup('form1:uiEmpleadoCod_field', 'form1:uiEmpleadoNombre_field')"
                                            target="popup" text="Empleados" url="/faces/popup/popupEmpleados.jsp"/>
                                        <h:panelGrid columns="2" id="gridEmpleado" style="text-align: left; width: 450px" title="Responsables" width="311">
                                            <webuijsf:textField binding="#{RegistroDeInventario.uiEmpleadoCod}" columns="10" id="uiEmpleadoCod" text="123"/>
                                            <webuijsf:textField binding="#{RegistroDeInventario.uiEmpleadoNombre}" columns="43" disabled="true" id="uiEmpleadoNombre"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="observacion" text="Descripcion"/>
                                        <h:panelGrid columns="1" id="gridPanelObservacion" style="height: 30px; width: 450px" width="479">
                                            <webuijsf:textArea binding="#{RegistroDeInventario.uiObservacion}" columns="63" id="uiObservacion" rows="4" style=""/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:messageGroup id="messageGroup1" style="width: 479px"/>
                                <h:panelGrid binding="#{RegistroDeInventario.buttonsPanelAddUpdate}" columns="3" id="buttonsPanelAddUpdate" style="height: 24px" width="191">
                                    <h:panelGrid columns="2" id="gridPanel2" style="height: 32px" width="5">
                                        <webuijsf:button actionExpression="#{RegistroDeInventario.uiButtonIniciar_action}"
                                            binding="#{RegistroDeInventario.uiButtonIniciar}" id="uiButtonIniciar"
                                            style="font-size: 14px; height: 24px; width: 200px" text="Iniciar Inventario"/>
                                        <webuijsf:button actionExpression="#{RegistroDeInventario.uiButtonCerrar_action}"
                                            binding="#{RegistroDeInventario.uiButtonCerrar}" id="uiButtonCerrar"
                                            style="color: rgb(255, 0, 0); font-size: 12px; font-weight: bold; height: 24px; width: 200px" text="Guardar y Ajustar Inventario"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanel3" style="height: 24px" width="263"/>
                                    <h:panelGrid columns="3" id="gridPanel1" style="width: 100%; height: 100%;">
                                        <webuijsf:button actionExpression="#{RegistroDeInventario.uiGuardarNuevo_action}"
                                            binding="#{RegistroDeInventario.uiGuardarNuevo}" id="uiGuardarNuevo" style="font-size: 14px; height: 24px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{RegistroDeInventario.uiGuardarEdicion_action}"
                                            binding="#{RegistroDeInventario.uiGuardarEdicion}" id="uiGuardarEdicion" style="font-size: 14px; height: 24px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{RegistroDeInventario.cancelar_action}" binding="#{RegistroDeInventario.cancelar}"
                                            id="cancelar" style="font-size: 14px; height: 24px" text="Cancelar"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{RegistroDeInventario.gridPanelDetalle}" id="gridPanelDetalle">
                                <webuijsf:staticText binding="#{RegistroDeInventario.detalleInventario}" id="detalleInventario"
                                    style="color: rgb(0, 0, 153); font-family: 'Arial','Helvetica',sans-serif; font-size: 18px; font-weight: bold" text="Detalle Inventario"/>
                                <h:panelGrid columns="2" id="gridPanel4" style="height: 100%; width: 100%">
                                    <webuijsf:tabSet id="tabSet1" lite="true" mini="true" selected="tab1" style="height: 192px; width: 743px">
                                        <webuijsf:tab actionExpression="#{RegistroDeInventario.tab1_action}" id="tab1" text="Agregar">
                                            <webuijsf:panelLayout id="layoutPanel1" style="height: 134px; position: relative; width: 709px; -rave-layout: grid">
                                                <h:panelGrid binding="#{RegistroDeInventario.gridPanelAddUpdate}" columns="6" id="gridPanelAddUpdate"
                                                    style="height: 48px" width="719">
                                                    <webuijsf:label id="label4" text="Producto   :"/>
                                                    <webuijsf:textField binding="#{RegistroDeInventario.uiProductoDet}" columns="50" disabled="true" id="uiProductoDet"/>
                                                    <webuijsf:label id="cantidad3" text="Cantidad Sistema"/>
                                                    <webuijsf:textField binding="#{RegistroDeInventario.uiCantSistema}" columns="5" disabled="true" id="uiCantSistema"/>
                                                    <webuijsf:label id="cantidad2" style="color: red; font-weight: bold" text="Cantidad Contada"/>
                                                    <webuijsf:textField binding="#{RegistroDeInventario.uiCantContada}" columns="5" id="uiCantContada"/>
                                                </h:panelGrid>
                                                <h:panelGrid columns="2" id="gridPanelObservacion1" style="height: 48px" width="719">
                                                    <webuijsf:textArea binding="#{RegistroDeInventario.uiObservacionDet}" columns="67" id="uiObservacionDet"
                                                        label="Observacion" rows="3" valueChangeListenerExpression="#{RegistroDeInventario.uiObservacionDet_processValueChange}"/>
                                                    <h:panelGrid columns="2" id="gridPanel5"
                                                        style="border-width: 1px; border-style: solid; background-color: #cccccc; height: 53px" width="119">
                                                        <webuijsf:label id="label5" text="Cod Prod:"/>
                                                        <webuijsf:textField binding="#{RegistroDeInventario.uiBuscarProd}" columns="10" id="uiBuscarProd"/>
                                                        <webuijsf:button actionExpression="#{RegistroDeInventario.uiButtonBuscarProd_action}"
                                                            id="uiButtonBuscarProd" style="width: 71px" text="Buscar"/>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <webuijsf:button actionExpression="#{RegistroDeInventario.buttonActualizar_action}" id="buttonActualizar"
                                                    style="margin-left: 650px" text="Actualizar"/>
                                            </webuijsf:panelLayout>
                                        </webuijsf:tab>
                                    </webuijsf:tabSet>
                                </h:panelGrid>
                                <h:panelGrid binding="#{RegistroDeInventario.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" summary="Productos"
                                    title="Productos" width="935">
                                    <webuijsf:table augmentTitle="false" binding="#{RegistroDeInventario.tableDetalleInventarios}" id="tableDetalleInventarios"
                                        paginateButton="true" paginationControls="true" sortPanelToggleButton="true" title="Inventario" width="863">
                                        <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="productos" rows="50"
                                            sourceData="#{RegistroDeInventario.detallesInventario}" sourceVar="currentRow">
                                            <webuijsf:tableColumn headerText="Cod " id="tableColumn121" sort="codProducto" width="30">
                                                <webuijsf:staticText id="staticText122" text="#{currentRow.value['codProducto'].codProducto}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn1" width="200">
                                                <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProducto']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Marca" id="tableColumn311" width="200">
                                                <webuijsf:staticText id="staticText121" text="#{currentRow.value['codProducto'].codMarca.nombre}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cant Sistema" id="tableColumn2" width="97">
                                                <webuijsf:staticText id="staticText2" text="#{currentRow.value['cantidadsistema']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cant Contada" id="tableColumn3" width="89">
                                                <webuijsf:staticText id="staticText3" text="#{currentRow.value['cantidadcontada']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Observacion" id="tableColumn4" width="300">
                                                <webuijsf:staticText id="staticText4" text="#{currentRow.value['observacion']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" id="tableColumn8" width="10">
                                                <webuijsf:imageHyperlink actionExpression="#{RegistroDeInventario.editDetail}" id="imageHyperlink1"
                                                    imageURL="/resources/Images/edit_16x16.gif" text="">
                                                    <f:setPropertyActionListener target="#{RegistroDeInventario.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                </webuijsf:imageHyperlink>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanel7" style="width: 100%; height: 100%;"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <webuijsf:textField id="textField2"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
