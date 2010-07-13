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
                            var table = document.getElementById("form1:table1");
                            table.initAllRows();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar el Registro?")) {
                                    return false;
                                }else{
                                    return true;
                                }
                            }
                        }
                    </script>
                    <script>
                        var insertSelect;
                        function confirmarInsertar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro insertar el Registro?")) {
                                    return false;
                                }else{
                                    return true;
                                }
                            }
                        }
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \ SCRIPT PARA MANEJAR EL DETALLE-->
                    <script>
                        function ABMPresentacion() {
                            var table = document.getElementById("form1:tableDetalleFormula");
                            table.ABMPresentacion();}
                    </script>
                    <!-- \ SCRIPT PARA MANEJAR EL DETALLE-->
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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 240px; top: 240px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{RegistroProDiaria.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <br/>
                            <h:panelGrid binding="#{RegistroProDiaria.gridPanelBusqueda}" id="gridPanelBusqueda" style="height: 288px; width: 100%">
                                <h:panelGrid columns="2" id="gridPanel3">
                                    <webuijsf:label id="label1" text="Nro de OT"/>
                                    <webuijsf:textField binding="#{RegistroProDiaria.uiNroOTFil}" id="uiNroOTFil"/>
                                    <webuijsf:button actionExpression="#{RegistroProDiaria.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                </h:panelGrid>
                                <webuijsf:table augmentTitle="false" binding="#{RegistroProDiaria.table1}" id="table1" paginateButton="true"
                                    paginationControls="true" title="Ordenes de Trabajo" width="767">
                                    <webuijsf:tableRowGroup binding="#{RegistroProDiaria.tableRowGroup2}" emptyDataMsg="No se encontraron registros"
                                        id="tableRowGroup2" rows="10" selected="#{RegistroProDiaria.selectedState}" sourceData="#{RegistroProDiaria.listaOtCab}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{RegistroProDiaria.tableColumn1}" id="tableColumn1"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{RegistroProDiaria.radioButton1.id}" width="10">
                                            <webuijsf:radioButton binding="#{RegistroProDiaria.radioButton1}" id="radioButton1" label=""
                                                name="#{RegistroProDiaria.radioButton1.id}" onClick="delSelect='ok'" selected="#{RegistroProDiaria.selected}" selectedValue="#{RegistroProDiaria.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro Ot" id="tableColumn9" width="40">
                                            <webuijsf:staticText id="staticText7" text="#{currentRow.value['codOrdenTrabjo']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Descripcion" id="tableColumn10" width="150">
                                            <webuijsf:staticText id="staticText8" text="#{currentRow.value['descripcion']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Producto" id="tableColumn11" sort="codProductoOt" width="150">
                                            <webuijsf:staticText id="staticText9" text="#{currentRow.value['codProductoOt']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cantidad" id="tableColumn12" width="20">
                                            <webuijsf:staticText id="staticText10" text="#{currentRow.value['cantidadOt']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn13" sort="estadoOt" width="30">
                                            <webuijsf:staticText id="staticText11" text="#{currentRow.value['estadoOt']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid columns="2" id="gridPanel4" style="width: 100%; height: 100%;">
                                    <webuijsf:button actionExpression="#{RegistroProDiaria.uiBtnSeleccionar_action}" id="uiBtnSeleccionar" text="Seleccionar"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroProDiaria.gridPanelCabecera}" columns="1" id="gridPanelCabecera" style="height: 72px" width="599">
                                <h:panelGrid columns="3" id="gridResponsables" style="height: 48px; vertical-align: top" title="Responsables" width="503">
                                    <webuijsf:label id="responsable" text="Responsable:"/>
                                    <webuijsf:dropDown binding="#{RegistroProDiaria.uiEmpleado}" id="uiEmpleado" items="#{SessionBean1.listaEmpleadosOp}"
                                        style="text-align: left" width="350"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelDatos1" style="height: 30px" width="287">
                                    <webuijsf:label id="fecha" text="Fecha"/>
                                    <webuijsf:calendar binding="#{RegistroProDiaria.uiFechaAct}" id="uiFechaAct" style="margin-left: 41px"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelOT" style="border-width: 2px; border-style: outset; height: 100%; width: 100%">
                                    <webuijsf:label id="cod_Ot" text="Cod Ot"/>
                                    <webuijsf:textField binding="#{RegistroProDiaria.uiCabNroOT}" disabled="true" id="uiCabNroOT"
                                        onBlur="DynaFaces.Tx.fire(&quot;grillaSemis&quot;,&quot;uiCabNroOT&quot;)" validatorExpression="#{RegistroProDiaria.uiCabNroOT_validate}"/>
                                    <webuijsf:label id="labelDesc" text="Descripcion"/>
                                    <webuijsf:textArea binding="#{RegistroProDiaria.uiOTDescripcion}" columns="60" disabled="true" id="uiOTDescripcion" rows="5"/>
                                </h:panelGrid>
                                <br/>
                                <h:panelGrid binding="#{RegistroProDiaria.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 24px" width="191">
                                    <webuijsf:button actionExpression="#{RegistroProDiaria.cancelar_action}" id="cancelar" style="font-size: 14px; height: 24px" text="Cancelar"/>
                                </h:panelGrid>
                                <webuijsf:messageGroup id="messageGroup1"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{RegistroProDiaria.gridPannelDetalle}" id="gridPannelDetalle" style="width: 100%; height: 100%;">
                                <webuijsf:staticText binding="#{RegistroProDiaria.detalleProduccion}" id="detalleProduccion"
                                    style="color: rgb(0, 0, 153); font-family: 'Arial','Helvetica',sans-serif; font-size: 18px; font-weight: bold" text="Detalle de Produccion"/>
                                <webuijsf:tabSet id="tabSet1" lite="true" mini="true" selected="tab1" style="width: 743px">
                                    <webuijsf:tab id="tab1" text="Agregar">
                                        <webuijsf:panelLayout id="layoutPanel1" style="height: 38px; position: relative; width: 733px; -rave-layout: grid">
                                            <h:panelGrid binding="#{RegistroProDiaria.gridPanelAddUpdate}" columns="7" id="gridPanelAddUpdate"
                                                style="height: 48px" width="719">
                                                <webuijsf:hyperlink id="tarea"
                                                    onClick="doPopup('form1:tabSet1:tab1:layoutPanel1:uiDetCodTarea_field', 'form1:tabSet1:tab1:layoutPanel1:uiDetDescTarea_field','form1:tabSet1:tab1:layoutPanel1:uiDetCodTareaAsig_field')"
                                                    target="popup" text="Tarea" url="/faces/popup/popupTareaAsignadaOTProdDiaria.jsp"/>
                                                <h:panelGrid columns="3" id="gridPanel2" style="width: 100%; height: 100%;">
                                                    <webuijsf:textField binding="#{RegistroProDiaria.uiDetCodTarea}" columns="8" id="uiDetCodTarea"/>
                                                    <webuijsf:textField binding="#{RegistroProDiaria.uiDetDescTarea}" columns="30" disabled="true" id="uiDetDescTarea"/>
                                                    <webuijsf:textField binding="#{RegistroProDiaria.uiDetCodTareaAsig}" columns="8" id="uiDetCodTareaAsig" visible="false"/>
                                                </h:panelGrid>
                                                <webuijsf:label id="cantidad" text="Cantidad"/>
                                                <webuijsf:textField binding="#{RegistroProDiaria.uiDetCantidad}" columns="10" id="uiDetCantidad"/>
                                                <webuijsf:label id="tiempoInv" text="Tiempo(min)"/>
                                                <webuijsf:textField binding="#{RegistroProDiaria.uiDetTiempo}" columns="5" id="uiDetTiempo"/>
                                                <webuijsf:button actionExpression="#{RegistroProDiaria.uiButtonAgregarTarea_action}" id="uiButtonAgregarTarea"
                                                    onClick="javascript:return confirmar()" text="Agregar"/>
                                            </h:panelGrid>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <h:panelGrid id="gridPanel1" style="height: 100%; width: 100%">
                                    <webuijsf:table augmentTitle="false" binding="#{RegistroProDiaria.tablaTareas}" id="tablaTareas" paginateButton="true"
                                        paginationControls="true" style="height: 77px" title="Lista de Tareas Ejecutadas" width="815">
                                        <webuijsf:tableRowGroup binding="#{RegistroProDiaria.tableRowGroup1}" id="tableRowGroup1" rows="15"
                                            sourceData="#{RegistroProDiaria.produccionesDiariasArray}" sourceVar="currentRow">
                                            <webuijsf:tableColumn headerText="Fecha" id="tableColumn5" sort="fecha" width="30">
                                                <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText5" text="#{currentRow.value['fecha']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Empleado" id="tableColumn2" sort="codEmpleado" width="198">
                                                <webuijsf:staticText id="staticText2" text="#{currentRow.value['codEmpleado']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Tarea" id="tableColumn3" width="198">
                                                <webuijsf:staticText id="staticText3" text="#{currentRow.value['codTareaAsignada'].codTarea}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Cantidad" id="tableColumn4" width="15">
                                                <webuijsf:staticText id="staticText4" text="#{currentRow.value['cantidad']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Tiempo Min" id="tableColumn6" width="15">
                                                <webuijsf:staticText id="staticText6" text="#{currentRow.value['tiempoInvertido']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn id="tableColumn7" width="10">
                                                <webuijsf:imageHyperlink id="uiDetEdit" imageURL="/resources/Images/edit_16x16.gif" text=""/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn id="tableColumn8" width="10">
                                                <webuijsf:imageHyperlink id="imageHyperlink2" imageURL="/resources/Images/delete.gif" text=""/>
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
