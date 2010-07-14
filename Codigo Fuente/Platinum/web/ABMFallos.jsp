<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ABMFallos
    Created on : Jul 7, 2010, 1:22:26 AM
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
                            var table = document.getElementById("form1:table1");
                            table.initAllRows();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de Anular el Registro seleccionado?")) {
                                    return false;
                                }else{
                                    return true;
                                }
                            }
                        }
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <webuijsf:script id="scriptPopUp" type="text/javascript" url="/js/utilJS.js"/>
                    <df:ajaxTransaction id="actualizarTareas" inputs="" render=""/>
                    <df:ajaxTransaction id="actualizaTareas" inputs="page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:panelDetOT1:uiNroOt" render="page1:html1:body1:form1:mainContainer:gridPanelAddUpdate:panelDetOT1:uiNroOt"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <div style="height: 574px; left: 216px; top: 216px; position: absolute; width: 718px">
                            <h:panelGrid id="mainContainer" width="695">
                                <h:panelGrid binding="#{ABMFallos.gridPanelFiltros}" columns="2" id="gridPanelFiltros">
                                    <h:panelGrid columns="2" id="gridPanelOt1">
                                        <webuijsf:label id="lblNroProveedor1" text="Nro. Orden Trabajo"/>
                                        <webuijsf:textField binding="#{ABMFallos.uiCodOtFil}" id="uiCodOtFil"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelResponsable1">
                                        <webuijsf:label id="lblProveedor1" text="Responsable"/>
                                        <webuijsf:dropDown binding="#{ABMFallos.uiResponsableFil}" id="uiResponsableFil" items="#{SessionBean1.listaEmpleadosOp}"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecha1">
                                        <webuijsf:label id="lblNroProveedor2" text="Fecha Ini :"/>
                                        <webuijsf:calendar binding="#{ABMFallos.uiFecha1Fil}" columns="29" id="uiFecha1Fil" valueChangeListenerExpression="#{ABMFallos.uiFecha1Fil_processValueChange}"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelFecha2">
                                        <webuijsf:label id="lblNroProveedor3" text="Fecha Fin"/>
                                        <webuijsf:calendar binding="#{ABMFallos.uiFecha2Fil}" columns="29" id="uiFecha2Fil"/>
                                    </h:panelGrid>
                                    <webuijsf:pageAlert binding="#{ABMFallos.pageAlert1}" id="pageAlert1" rendered="false"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMFallos.gridPanelTabla}" id="gridPanelTabla">
                                    <h:panelGrid columns="2" id="panelButtonBuscar1">
                                        <webuijsf:button actionExpression="#{ABMFallos.uiBuscarButton_action}" id="uiBuscarButton1" text="Buscar"/>
                                        <webuijsf:button actionExpression="#{ABMFallos.uiTodosButton_action}" id="uiTodosButton1" text="Todos"/>
                                    </h:panelGrid>
                                    <webuijsf:table augmentTitle="false" binding="#{ABMFallos.table1}" id="table1" title="Table" width="647">
                                        <webuijsf:tableRowGroup binding="#{ABMFallos.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                            selected="#{ABMFallos.selectedState}" sourceData="#{ABMFallos.listaTareasFallidas}" sourceVar="currentRow">
                                            <webuijsf:tableColumn binding="#{ABMFallos.tableColumn1}" id="tableColumn1" onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMFallos.radioButton1.id}">
                                                <webuijsf:radioButton binding="#{ABMFallos.radioButton1}" id="radioButton1" label=""
                                                    name="#{ABMFallos.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMFallos.selected}" selectedValue="#{ABMFallos.selectedValue}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cod" id="tableColumn2">
                                                <webuijsf:staticText id="staticText1" text="#{currentRow.value['codTareaFallida']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Fecha" id="tableColumn4" sort="fecha">
                                                <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText4" text="#{currentRow.value['fecha']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Empleado" id="tableColumn3" sort="codEmpleado">
                                                <webuijsf:staticText id="staticText2" text="#{currentRow.value['codEmpleado']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cod OT" id="tableColumn217">
                                                <webuijsf:staticText id="staticText213" text="#{currentRow.value['codTareaAsignada'].codDetOrdenTrabaj.codOrdenTrabajo.codOrdenTrabjo}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Tarea" id="tableColumn7" sort="codTareaAsignada">
                                                <webuijsf:staticText id="staticText3" text="#{currentRow.value['codTareaAsignada'].codTarea}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cantidad" id="tableColumn8">
                                                <webuijsf:staticText id="staticText7" text="#{currentRow.value['cantidad']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                    <h:panelGrid columns="3" id="gridPanel1">
                                        <webuijsf:button actionExpression="#{ABMFallos.uiBtnNuevo_action}" id="uiBtnNuevo" text="Nuevo"/>
                                        <webuijsf:button actionExpression="#{ABMFallos.uiBtnEditar_action}" id="uiBtnEditar" rendered="false" text="Editar"/>
                                        <webuijsf:button actionExpression="#{ABMFallos.uiBtnEliminar_action}" id="uiBtnEliminar"
                                            onClick="javascript:return confirmar()" text="Anular"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMFallos.gridPanelAddUpdate}" id="gridPanelAddUpdate">
                                    <h:panelGrid columns="2" id="panelDetOT1" style="height: 11px; margin-top: 5px; text-align: left" width="383">
                                        <webuijsf:label id="lblNroOT1" text="Nro Sub OT"/>
                                        <webuijsf:dropDown binding="#{ABMFallos.uiNroOt}" id="uiNroOt" items="#{ABMFallos.listaOtsOp}"
                                            onChange="DynaFaces.Tx.fire(&quot;actualizaTareas&quot;,&quot;uiNroOt&quot;)" validatorExpression="#{ABMFallos.uiNroOt_validator}"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="4" id="panelGridCabeceraCompra1" style="height: 20px; text-align: left" width="455">
                                        <webuijsf:hyperlink id="hyperlink2" onClick="doPopup('form1:uiResponsableCod_field', 'form1:uiResponsableNombre_field')"
                                            target="popup" text="Responsable" url="/faces/popup/popupEmpleados.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor1" style="margin-left: 5px" width="335">
                                            <webuijsf:textField binding="#{ABMFallos.uiResponsableCod}" id="uiResponsableCod"/>
                                            <webuijsf:textField binding="#{ABMFallos.uiResponsableNombre}" columns="50" disabled="true" id="uiResponsableNombre" valueChangeListenerExpression="#{ABMFallos.uiResponsableNombre_processValueChange}"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="lblFecha1" labelLevel="3" text="Fecha"/>
                                        <webuijsf:calendar binding="#{ABMFallos.uiFecha}" columns="15" dateFormatPattern="dd/MM/yyyy" id="uiFecha"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel7" style="height: 100%; margin-top: 10px; width: 100%">
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:uiTareaAsignada_field', 'form1:uiTareaDesc_field')"
                                            target="popup" text="Tarea" url="/faces/popup/popupTareaAsignadaFallos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanel8" style="height: 100%; margin-left: -3px" width="359">
                                            <webuijsf:textField binding="#{ABMFallos.uiTareaAsignada}" columns="13" id="uiTareaAsignada"/>
                                            <webuijsf:textField binding="#{ABMFallos.uiTareaDesc}" columns="50" disabled="true" id="uiTareaDesc"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="label1" text="Cantidad"/>
                                        <webuijsf:textField binding="#{ABMFallos.uiCantidad}" columns="13" id="uiCantidad"/>
                                        <webuijsf:label id="label2" text="Tiempo"/>
                                        <webuijsf:textField binding="#{ABMFallos.uiTiempo}" columns="13" id="uiTiempo"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel6"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 460px; margin-top: 10px; text-align: right; vertical-align: middle" width="182">
                                        <webuijsf:button actionExpression="#{ABMFallos.cancelButton_action}" binding="#{ABMFallos.cancelButton}"
                                            id="cancelButton" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMFallos.addRecordButton_action}" binding="#{ABMFallos.addRecordButton}"
                                            id="addRecordButton" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMFallos.updateRecordButton_action}" binding="#{ABMFallos.updateRecordButton}"
                                            id="updateRecordButton" style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <webuijsf:messageGroup id="messageGroup1"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMFallos.gridPanelPerdidas}" id="gridPanelPerdidas">
                                    <h:panelGrid columns="10" id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:hyperlink id="hyperlink3" onClick="doPopup('form1:uiPerdidaCodProd_field', 'form1:uiPerdidaDescProd_field')"
                                            target="popup" text="Producto" url="/faces/popup/popupProductos.jsp"/>
                                        <webuijsf:textField binding="#{ABMFallos.uiPerdidaCodProd}" columns="10" id="uiPerdidaCodProd"/>
                                        <webuijsf:textField binding="#{ABMFallos.uiPerdidaDescProd}" columns="45" disabled="true" id="uiPerdidaDescProd"/>
                                        <webuijsf:label id="label3" text="Cantidad"/>
                                        <webuijsf:textField binding="#{ABMFallos.uiPerdidaCantidad}" id="uiPerdidaCantidad"/>
                                        <webuijsf:button actionExpression="#{ABMFallos.uiBtnAgregarDetalle_action}" id="uiBtnAgregarDetalle" text="Agregar"/>
                                    </h:panelGrid>
                                    <webuijsf:table augmentTitle="false" id="table2" title="Perdidas Generadas" width="605">
                                        <webuijsf:tableRowGroup emptyDataMsg="no se ha registrado perdidas" id="tableRowGroup2" rows="5"
                                            sourceData="#{ABMFallos.detallesPerdida}" sourceVar="currentRow">
                                            <webuijsf:tableColumn headerText="Producto" id="tableColumn6" sort="codProducto" width="250">
                                                <webuijsf:staticText id="staticText6" text="#{currentRow.value['codProducto']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="right" headerText="Cantidad" id="tableColumn9" width="15">
                                                <webuijsf:staticText id="staticText8" text="#{currentRow.value['cantidadPerdida']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Observacion" id="tableColumn10" width="300">
                                                <webuijsf:staticText id="staticText9" text="#{currentRow.value['observacion']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn align="center" binding="#{ABMFallos.tableColumn11}" id="tableColumn11">
                                                <webuijsf:imageHyperlink actionExpression="#{ABMFallos.uiEditDetalle_action}"
                                                    binding="#{ABMFallos.uiEditDetalle}" id="uiEditDetalle" imageURL="/resources/img/delete.png" text="">
                                                    <f:setPropertyActionListener target="#{ABMFallos.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                </webuijsf:imageHyperlink>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
