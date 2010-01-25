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
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar el Empleado seleccionado?")) {
                                    return false;
                                }else {
                                    return true;
                                }
                            }
                        }
                    </script>
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
                            <webuijsf:pageAlert binding="#{ABMEmpleados.pageAlert1}" id="pageAlert1" rendered="false"/>
                            <h:panelGrid binding="#{ABMEmpleados.gridPanelBuscar}" columns="3" id="gridPanelBuscar" style="height: 72px" width="599">
                                <h:panelGrid columns="2" id="gridPanelApellido" width="263">
                                    <webuijsf:label id="apellido" text="Apellido"/>
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtFilApellido}" columns="25" id="uiTxtFilApellido"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelNombre" width="239">
                                    <webuijsf:label id="nombre" text="Nombre"/>
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtFilNombre}" columns="25" id="uiTxtFilNombre"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelCedula">
                                    <webuijsf:label id="cedula" text="Cedula:"/>
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtFilCedula}" columns="22" id="uiTxtFilCedula"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="panelButtonBusqueda" width="143">
                                    <webuijsf:button actionExpression="#{ABMEmpleados.uiBtnBuscar_action}" id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMEmpleados.uiBtnBuscarTodos_action}" id="uiBtnBuscarTodos" text="Todos"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMEmpleados.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                <webuijsf:table augmentTitle="false" binding="#{ABMEmpleados.table1}" id="table1" paginateButton="true"
                                    paginationControls="true" sortPanelToggleButton="true" title="Empleados" width="727">
                                    <webuijsf:tableRowGroup binding="#{ABMEmpleados.tableRowGroup1}" emptyDataMsg="No se encontraron registros..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMEmpleados.selectedState}" sourceData="#{SessionBean1.listaEmpleados}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMEmpleados.tableColumn4}" id="tableColumn4"
                                            onClick="setTimeout('initAllRows()', 0)" selectId="#{ABMEmpleados.radioButton1.id}" width="560">
                                            <webuijsf:radioButton binding="#{ABMEmpleados.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMEmpleados.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMEmpleados.selected}" selectedValue="#{ABMEmpleados.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Apellido" id="tableColumn1" sort="apellidoEmpleado">
                                            <webuijsf:staticText id="staticText1" text="#{currentRow.value['apellidoEmpleado']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nombre" id="tableColumn2" sort="nombreEmpleado">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['nombreEmpleado']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Cedula" id="tableColumn3" sort="cinEmpleado" width="167">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['cinEmpleado']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <br/>
                            <h:panelGrid binding="#{ABMEmpleados.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 50px; width: 150px">
                                <webuijsf:button actionExpression="#{ABMEmpleados.nuevo_action}" id="nuevo" text="Nuevo"/>
                                <webuijsf:button actionExpression="#{ABMEmpleados.editar_action}" id="editar" text="Editar"/>
                                <webuijsf:button actionExpression="#{ABMEmpleados.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                            </h:panelGrid>
                            <br/>
                            <br/>
                            <webuijsf:staticText binding="#{ABMEmpleados.datosEmpleado1}" id="datosEmpleado1"
                                style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos del Empleado"/>
                            <br/>
                            <h:panelGrid binding="#{ABMEmpleados.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                <webuijsf:label id="nombre2" text="Nombre"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtNombre}" columns="40" id="uiTxtNombre"/>
                                    <webuijsf:message for="uiTxtNombre" id="message1" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label2" text="Apellido"/>
                                <h:panelGrid columns="2" id="gridPanel3" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtApellido}" columns="40" id="uiTxtApellido"/>
                                    <webuijsf:message for="uiTxtApellido" id="message3" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label3" text="Documento Nro.:"/>
                                <h:panelGrid columns="2" id="gridPanel4" style="height: 100%" width="311">
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtNroCedula}" columns="16" id="uiTxtNroCedula"/>
                                    <webuijsf:message for="uiTxtNroCedula" id="message4" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="lblTipoEmpleado" text="Tipo Empleado"/>
                                <h:panelGrid columns="1" id="gridPanelEstadoCivil" style="width: 100%; height: 100%;">
                                    <webuijsf:radioButtonGroup binding="#{ABMEmpleados.uiRadTipoEmpleado}" columns="3" id="uiRadTipoEmpleado"
                                        items="#{ABMEmpleados.uiRadTipoEmpleadoDefaultOptions.options}" selected="#{ABMEmpleados.uiRadTipoEmpleadoDefaultOptions.selectedValue}"/>
                                </h:panelGrid>
                                <webuijsf:label id="label4" text="Sexo"/>
                                <h:panelGrid columns="2" id="gridPanel2" style="width: 100%; height: 100%;">
                                    <webuijsf:dropDown binding="#{ABMEmpleados.uiLstSexo}" id="uiLstSexo"
                                        items="#{ABMEmpleados.uiLstSexoDefaultOptions.options}" selected="#{ABMEmpleados.uiLstSexoDefaultOptions.selectedValue}" width="100px"/>
                                    <webuijsf:message for="uiLstSexo" id="message2" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="lblEstado" text="Estado"/>
                                <h:panelGrid columns="1" id="gridPanelEstado" style="width: 100%; height: 100%;">
                                    <webuijsf:dropDown binding="#{ABMEmpleados.uiLstEstado}" id="uiLstEstado"
                                        items="#{ABMEmpleados.uiLstEstadoDefaultOptions.options}"
                                        selected="#{ABMEmpleados.uiLstEstadoDefaultOptions.selectedValue}" width="100"/>
                                </h:panelGrid>
                                <webuijsf:label id="label5" text="Nacionalidad"/>
                                <h:panelGrid columns="2" id="gridPanel5" style="width: 100%; height: 100%;">
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtNacionalidad}" columns="30" id="uiTxtNacionalidad"/>
                                    <webuijsf:message for="uiTxtNacionalidad" id="message5" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="lblEstadoCivil" text="Estado Civil"/>
                                <h:panelGrid columns="1" id="gridPanelTipoEmpleado" style="width: 100%; height: 100%;">
                                    <webuijsf:radioButtonGroup binding="#{ABMEmpleados.uiRadEstadoCivil}" columns="4" id="uiRadEstadoCivil"
                                        items="#{ABMEmpleados.uiRadEstadoCivilDefaultOptions.options}" selected="#{ABMEmpleados.uiRadEstadoCivilDefaultOptions.selectedValue}"/>
                                </h:panelGrid>
                                <webuijsf:label id="label6" text="Direccion"/>
                                <h:panelGrid columns="2" id="gridPanel6" style="height: 100%" width="551">
                                    <webuijsf:textArea binding="#{ABMEmpleados.uiTxtDireccion}" columns="50" id="uiTxtDireccion" rows="3"/>
                                    <webuijsf:message for="uiTxtDireccion" id="message6" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label7" text="Telefono1"/>
                                <h:panelGrid columns="2" id="gridPanel7" style="width: 100%; height: 100%;">
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtTelefono1}" columns="30" id="uiTxtTelefono1"/>
                                    <webuijsf:message for="uiTxtTelefono1" id="message7" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label1" text="Telefono2"/>
                                <h:panelGrid columns="2" id="gridPanel8" style="width: 100%; height: 100%;">
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtTelefono2}" columns="30" id="uiTxtTelefono2"/>
                                    <webuijsf:message for="uiTxtTelefono2" id="message8" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label8" text="Fecha Nacimiento"/>
                                <h:panelGrid columns="2" id="gridPanel9" style="height: 100%" width="100%">
                                    <webuijsf:calendar autoValidate="true" binding="#{ABMEmpleados.uiCalFechaNacimiento}" id="uiCalFechaNacimiento" style="margin-left: -9px"/>
                                    <webuijsf:message for="uiCalFechaNacimiento" id="message9" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label9" text="Cargo"/>
                                <h:panelGrid columns="2" id="gridPanel10" style="height: 100%" width="481">
                                    <webuijsf:dropDown binding="#{ABMEmpleados.uiLstCargo}" id="uiLstCargo" items="#{SessionBean1.listaCargoOption}" width="200px"/>
                                    <webuijsf:message for="uiLstCargo" id="message10" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label10" text="Seccion"/>
                                <h:panelGrid columns="2" id="gridPanel11" style="height: 100%" width="479">
                                    <webuijsf:dropDown binding="#{ABMEmpleados.uiLstSeccion}" id="uiLstSeccion" items="#{SessionBean1.listaSeccionOption}" width="200"/>
                                    <webuijsf:message for="uiLstSeccion" id="message11" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label11" text="Mail"/>
                                <h:panelGrid columns="2" id="gridPanel12" style="height: 100%" width="575">
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtMail}" columns="50" id="uiTxtMail"/>
                                    <webuijsf:message for="uiTxtMail" id="message12" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label13" text="IPS"/>
                                <h:panelGrid columns="2" id="gridPanel14" style="height: 100%" width="582">
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtNroIPS}" columns="30" id="uiTxtNroIPS"/>
                                    <webuijsf:message for="uiTxtNroIPS" id="message14" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label14" text="Cantidad Hijos"/>
                                <h:panelGrid columns="2" id="gridPanel15" style="width: 100%; height: 100%;">
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtCantHijos}" columns="5" id="uiTxtCantHijos" style="text-align: right"/>
                                    <webuijsf:message for="uiTxtCantHijos" id="message15" showDetail="false" showSummary="true"/>
                                </h:panelGrid>
                                <webuijsf:label id="label15" text="Salario"/>
                                <h:panelGrid columns="2" id="gridPanel16" style="width: 100%; height: 100%;">
                                    <webuijsf:textField binding="#{ABMEmpleados.uiTxtSalario}" id="uiTxtSalario" style="text-align: right"/>
                                    <webuijsf:message for="uiTxtSalario" id="message16" showDetail="false" showSummary="true" style="uiTxtSalario"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ABMEmpleados.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                <webuijsf:button actionExpression="#{ABMEmpleados.uiBtnGuardarNuevo_action}" binding="#{ABMEmpleados.uiBtnGuardarNuevo}"
                                    id="uiBtnGuardarNuevo" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMEmpleados.uiBtnGuardarEditar_action}" binding="#{ABMEmpleados.uiBtnGuardarEditar}"
                                    id="uiBtnGuardarEditar" text="Guardar"/>
                                <webuijsf:button actionExpression="#{ABMEmpleados.uiBtnCancelar_action}" id="uiBtnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
