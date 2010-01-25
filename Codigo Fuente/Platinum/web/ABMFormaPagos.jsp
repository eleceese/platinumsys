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
                    <webuijsf:script id="scriptPopUp" type="text/javascript" url="/js/utilJS.js"/>
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
                                if(!confirm("¿Está seguro de eliminar el Registro seleccionado?")) {
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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 216px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMFormaPagos.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMFormaPagos.gridPanelBuscar}" columns="2" id="gridPanelBuscar" style="height: 48px" width="599">
                                <h:panelGrid columns="2" id="gridPanelCodigo" style="height: 30px" width="167">
                                    <webuijsf:label id="banco1" text="Banco"/>
                                    <webuijsf:textField binding="#{ABMFormaPagos.uiTxtFilBanco}" columns="30" id="uiTxtFilBanco"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height: 30px" width="383">
                                    <webuijsf:label id="forma" text="Forma de Pago"/>
                                    <webuijsf:textField binding="#{ABMFormaPagos.uiTxtFilDescripcion}" columns="45" id="uiTxtFilDescripcion"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMFormaPagos.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMFormaPagos.uiBtnTodos_action}" id="uiBtnTodos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMFormaPagos.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMFormaPagos.table1}" id="table1" title="Formas de pago" width="612">
                                    <webuijsf:tableRowGroup binding="#{ABMFormaPagos.tableRowGroup1}" emptyDataMsg="No se encontraron registros..."
                                        id="tableRowGroup1" rows="5" selected="#{ABMFormaPagos.selectedState}" sourceData="#{SessionBean1.listaFormaPago}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMFormaPagos.tableColumn3}" id="tableColumn3"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMFormaPagos.radioButton1.id}" width="40">
                                            <webuijsf:radioButton binding="#{ABMFormaPagos.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMFormaPagos.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMFormaPagos.selected}" selectedValue="#{ABMFormaPagos.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Forma Pago" id="tableColumn2" sort="nombreFormaPago" width="241">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['nombreFormaPago']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Banco" id="tableColumn1Banco" sort="codBanco" width="237">
                                            <webuijsf:staticText id="staticText1banco" text="#{currentRow.value['codBanco']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Codigo" id="tableColumn1" sort="codFormaPago" width="85">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['codFormaPago']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMFormaPagos.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMFormaPagos.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMFormaPagos.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMFormaPagos.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{ABMFormaPagos.datosFormaPago}" id="datosFormaPago"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos Forma de pago"/>
                            <br/>
                            <h:panelGrid binding="#{ABMFormaPagos.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="labelDescripcion" text="Descripcion"/>
                                <h:panelGrid columns="2" id="gridPanelMarca" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMFormaPagos.uiTxtDescripcion}" columns="50" id="uiTxtDescripcion"/>
                                    <webuijsf:message for="uiTxtDescripcion" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:hyperlink id="linkBanco" onClick="doPopup('form1:uiTxtCodigoBanco_field', 'form1:uiTxtDescripcionBanco_field')"
                                    target="popup" text="Banco" url="/faces/popup/popupBancos.jsp"/>
                                <h:panelGrid columns="3" id="gridPanelBanco" style="height: 100%" width="479">
                                    <webuijsf:textField binding="#{ABMFormaPagos.uiTxtCodigoBanco}" columns="10" id="uiTxtCodigoBanco"/>
                                    <webuijsf:textField binding="#{ABMFormaPagos.uiTxtDescripcionBanco}" columns="35" id="uiTxtDescripcionBanco"/>
                                    <webuijsf:message for="uiTxtDescripcionBanco" id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMFormaPagos.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMFormaPagos.uiBtnGuardarNuevo_action}" binding="#{ABMFormaPagos.uiBtnGuardarNuevo}"
                                    id="uiBtnGuardarNuevo" onClick="setTimeout('initAllRows()',0)" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMFormaPagos.uiBtnGuardarEditar_action}" binding="#{ABMFormaPagos.uiBtnGuardarEditar}"
                                    id="uiBtnGuardarEditar" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMFormaPagos.uiBtnCancelar_action}" id="uiBtnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
