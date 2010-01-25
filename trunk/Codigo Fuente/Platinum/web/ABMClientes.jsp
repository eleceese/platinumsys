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
                        <h:panelGrid id="mainContainer" style="height: 408px; left: 240px; top: 192px; position: absolute" width="888">
                            <webuijsf:pageAlert binding="#{ABMClientes.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMClientes.gridPanelBuscar}" columns="3" id="gridPanelBuscar" style="height: 24px" width="599">
                                <h:panelGrid columns="2" id="gridPanelNombre" style="height:30px; width: 60%">
                                    <webuijsf:label id="nombre" text="Nombre"/>
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtFilNombre}" columns="30" id="uiTxtFilNombre"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelApellido" style="height:30px; width: 60%">
                                    <webuijsf:label id="apellido" text="Apellido"/>
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtFilApellido}" columns="30" id="uiTxtFilApellido"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelCedula" style="height:30px; width: 60%">
                                    <webuijsf:label id="uiTxtRuc" text="R.U.C.:"/>
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtFilRUC}" columns="13" id="uiTxtFilRUC"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMClientes.gridPanelBtnBuscar}" columns="2" id="gridPanelBtnBuscar" style="height: 48px" width="191">
                                <webuijsf:button actionExpression="#{ABMClientes.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                <webuijsf:button actionExpression="#{ABMClientes.uiBtnTodos_action}" id="uiBtnTodos" text="Todos"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMClientes.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMClientes.table1}" id="table1" paginateButton="true" paginationControls="true"
                                    sortPanelToggleButton="true" title="Clientes" width="647">
                                    <webuijsf:tableRowGroup binding="#{ABMClientes.tableRowGroup1}" emptyDataMsg="No se encontraron registros..."
                                        id="tableRowGroup1" rows="15" selected="#{ABMClientes.selectedState}" sourceData="#{SessionBean1.listaCliente}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMClientes.tableColumn5}" id="tableColumn5"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMClientes.radioButton1.id}" width="40">
                                            <webuijsf:radioButton binding="#{ABMClientes.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMClientes.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMClientes.selected}" selectedValue="#{ABMClientes.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Apellido" id="tableColumn1" sort="apellidoCliente">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['apellidoCliente']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nombre" id="tableColumn2" sort="nombreCliente">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['nombreCliente']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="RUC" id="tableColumn3" sort="rucCliente">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['rucCliente']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Telefono" id="tableColumn4" sort="telefono1Cliente">
                                            <webuijsf:staticText id="staticText4" text="#{currentRow.value['telefono1Cliente']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMClientes.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 50px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMClientes.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMClientes.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMClientes.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMClientes.datosClientes}" id="datosClientes"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos del Cliente"/>
                            <br/>
                            <h:panelGrid binding="#{ABMClientes.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="nombre2" text="Nombre"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtNombre}" columns="50" id="uiTxtNombre"/>
                                    <webuijsf:message for="uiTxtNombre" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label2" text="Apellido"/>
                                <h:panelGrid columns="2" id="gridPanel3" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtApellido}" columns="50" id="uiTxtApellido"/>
                                    <webuijsf:message for="uiTxtApellido" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="tipoDoc" text="Tipo y Nro Doc:"/>
                                <h:panelGrid columns="2" id="gridPanelDocumento" style="height: 100%" width="479">
                                    <h:panelGrid columns="2" id="gridPanelNroDocumento" style="height: 100%" width="239">
                                        <webuijsf:dropDown binding="#{ABMClientes.uiLstTipoDoc}" id="uiLstTipoDoc"
                                            items="#{ABMClientes.uiLstTipoDocDefaultOptions.options}" width="120px"/>
                                        <webuijsf:textField binding="#{ABMClientes.uiTxtDocumento}" id="uiTxtDocumento"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="1" id="gridPanelMsgDocumento" style="height: 100%" width="359">
                                        <webuijsf:message for="uiTxtDocumento" id="message4" showDetail="false" showSummary="true" style="width: 311px"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <webuijsf:label id="label4" text="Sexo"/>
                                <h:panelGrid columns="3" id="gridPanel2" style="height: 100%" width="455">
                                    <webuijsf:dropDown binding="#{ABMClientes.uiLstSexo}" id="uiLstSexo" items="#{ABMClientes.uiLstSexoDefaultOptions.options}" width="120px"/>
                                    <webuijsf:label id="lblEstado" text="Estado"/>
                                    <webuijsf:radioButtonGroup binding="#{ABMClientes.uiLstEstado}" columns="2" id="uiLstEstado"
                                        items="#{ABMClientes.uiLstEstadoDefaultOptions.options}"
                                        selected="#{ABMClientes.uiLstEstadoDefaultOptions.selectedValue}" style="height: 24px; vertical-align: middle; width: 191px"/>
                                </h:panelGrid>
                                <webuijsf:label id="ruc1" text="RUC"/>
                                <h:panelGrid columns="2" id="gridPanel14" style="height: 100%" width="582">
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtNroRuc}" columns="24" id="uiTxtNroRuc"/>
                                    <webuijsf:message for="uiTxtNroRuc" id="message14" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label6" text="Direccion"/>
                                <h:panelGrid columns="2" id="gridPanel6" style="height: 100%" width="551">
                                    <webuijsf:textArea binding="#{ABMClientes.uiTxtDireccion}" columns="50" id="uiTxtDireccion" rows="3"/>
                                    <webuijsf:message for="uiTxtDireccion" id="message6" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label7" text="Telefono1"/>
                                <h:panelGrid columns="2" id="gridPanel10" style="height: 100%" width="481">
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtTelefono1}" columns="24" id="uiTxtTelefono1"/>
                                    <webuijsf:message for="uiTxtTelefono1" id="message10" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label1" text="Telefono2"/>
                                <h:panelGrid columns="2" id="gridPanel7" style="width: 100%; height: 100%;">
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtTelefono2}" columns="24" id="uiTxtTelefono2"/>
                                    <webuijsf:message for="uiTxtTelefono2" id="message7" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label11" text="Mail"/>
                                <h:panelGrid columns="2" id="gridPanel8" style="width: 100%; height: 100%;">
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtMail}" columns="50" id="uiTxtMail"/>
                                    <webuijsf:message for="uiTxtMail" id="message8" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="contacto1" text="Contacto 1"/>
                                <h:panelGrid columns="2" id="gridPanel12" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtContacto1}" columns="50" id="uiTxtContacto1"/>
                                    <webuijsf:message for="uiTxtContacto1" id="message12" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="contacto3" text="Contacto 2"/>
                                <h:panelGrid columns="2" id="gridPanel5" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtContacto2}" columns="50" id="uiTxtContacto2"/>
                                    <webuijsf:message for="uiTxtContacto2" id="message5" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="uiLblCiudad" text="Ciudad"/>
                                <h:panelGrid columns="2" id="gridPanel13" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMClientes.uiTxtCiudad}" columns="50" id="uiTxtCiudad"/>
                                    <webuijsf:message for="uiTxtCiudad" id="message13" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMClientes.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMClientes.uiBtnGuardarNuevo_action}" binding="#{ABMClientes.uiBtnGuardarNuevo}"
                                    id="uiBtnGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMClientes.uiBtnGuardarEditar_action}" binding="#{ABMClientes.uiBtnGuardarEditar}"
                                    id="uiBtnGuardarEditar" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMClientes.uiBtnCancelar_action}" id="uiBtnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
