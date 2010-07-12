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
                            var table = document.getElementById("form1:tableProveedores");
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
                        <div>
                            <h:panelGrid id="mainContainer" style="height: 408px; left: 240px; top: 216px; position: absolute" width="888">
                                <webuijsf:pageAlert binding="#{ABMUsuarios.pageAlert1}" id="pageAlert1" rendered="false"/>
                                <h:panelGrid binding="#{ABMUsuarios.gridPanelBuscar}" columns="3" id="gridPanelBuscar" style="height: 72px" width="407">
                                    <h:panelGrid columns="2" id="gridPanelNombre" style="height:30px; width: 60%">
                                        <webuijsf:label id="labelNombre" text="Usuario"/>
                                        <webuijsf:textField binding="#{ABMUsuarios.uiUsuarioFil}" id="uiUsuarioFil"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelRuc" style="height:30px; width: 60%">
                                        <webuijsf:label id="labelRuc" text="ROL"/>
                                        <webuijsf:textField binding="#{ABMUsuarios.uiRolFil}" id="uiRolFil" valueChangeListenerExpression="#{ABMUsuarios.uiRolFil_processValueChange}"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelDireccion" style="height:30px; width: 60%">
                                        <webuijsf:label id="uiEmpleadoab" text="Empleado"/>
                                        <webuijsf:dropDown binding="#{ABMUsuarios.uiEmpleadoFil}" id="uiEmpleadoFil" items="#{SessionBean1.listaEmpleadosOp}"/>
                                    </h:panelGrid>
                                    <webuijsf:button actionExpression="#{ABMUsuarios.buscar_action}" id="buscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMUsuarios.todos_action}" id="todos" text="Todos"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMUsuarios.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                                    <webuijsf:table augmentTitle="false" binding="#{ABMUsuarios.tableProveedores}" id="tableProveedores" paginateButton="true"
                                        paginationControls="true" sortPanelToggleButton="true" title="Usuarios del Sistema" width="661">
                                        <webuijsf:tableRowGroup binding="#{ABMUsuarios.uiTablaProveedoresRW}" emptyDataMsg="No se encontraron registros..."
                                            id="uiTablaProveedoresRW" rows="10" selected="#{ABMUsuarios.selectedState}"
                                            sourceData="#{SessionBean1.listaUsuarios}" sourceVar="currentRow">
                                            <webuijsf:tableColumn align="center" binding="#{ABMUsuarios.tableColumn5}" id="tableColumn5"
                                                onClick="setTimeout('initAllRows()',0)" selectId="#{ABMUsuarios.radioButton1.id}">
                                                <webuijsf:radioButton binding="#{ABMUsuarios.radioButton1}" id="radioButton1" label=""
                                                    name="#{ABMUsuarios.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMUsuarios.selected}" selectedValue="#{ABMUsuarios.selectedValue}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Empleado" id="tableColumn1" sort="codEmpleado">
                                                <webuijsf:staticText id="staticText1" text="#{currentRow.value['codEmpleado']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Usuario" id="tableColumn2" sort="usuario">
                                                <webuijsf:staticText id="staticText2" text="#{currentRow.value['usuario']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Estado" id="tableColumn3" sort="estado">
                                                <webuijsf:staticText id="staticText3" text="#{currentRow.value['estado']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="Rol" id="tableColumn4" sort="rol">
                                                <webuijsf:staticText id="staticText4" text="#{currentRow.value['rol']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMUsuarios.gridPanelBotones}" columns="3" id="gridPanelBotones" style="height: 24px; width: 150px">
                                    <webuijsf:button actionExpression="#{ABMUsuarios.nuevo_action}" id="nuevo" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMUsuarios.editar_action}" id="editar" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMUsuarios.eliminar_action}" id="eliminar" onClick="javascript:return confirmar()" text="Eliminar"/>
                                </h:panelGrid>
                                <webuijsf:staticText binding="#{ABMUsuarios.datosUsu}" id="datosUsu"
                                    style="color: #000099; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold" text="Datos del Usuario"/>
                                <br/>
                                <h:panelGrid binding="#{ABMUsuarios.gridPanelAddUpdate}" columns="2" id="gridPanelAddUpdate" style="height: 100%" width="839">
                                    <webuijsf:label id="labelNombre1" text="Usuario"/>
                                    <h:panelGrid columns="2" id="gridPanel1" style="height: 100%" width="575">
                                        <webuijsf:textField binding="#{ABMUsuarios.uiUsuario}" columns="50" id="uiUsuario"/>
                                        <webuijsf:message for="uiUsuario" id="message1" showDetail="false" showSummary="true"/>
                                    </h:panelGrid>
                                    <webuijsf:label id="labelRuc1" text="Password"/>
                                    <h:panelGrid columns="2" id="gridPanel2" style="height: 100%" width="582">
                                        <webuijsf:passwordField binding="#{ABMUsuarios.uiPassword}" id="uiPassword"/>
                                        <webuijsf:message for="uiPassword" id="message4" showDetail="false" showSummary="true"/>
                                    </h:panelGrid>
                                    <webuijsf:label id="label1" text="ROL"/>
                                    <h:panelGrid columns="2" id="gridPanel3" style="height: 100%" width="551">
                                        <webuijsf:dropDown binding="#{ABMUsuarios.uiRol}" id="uiRol" items="#{ABMUsuarios.uiRolDefaultOptions.options}" selected="#{ABMUsuarios.uiRolDefaultOptions.selectedValue}"/>
                                        <webuijsf:message for="uiRol" id="message5" showDetail="false" showSummary="true"/>
                                    </h:panelGrid>
                                    <webuijsf:label id="label2" text="Empleado"/>
                                    <h:panelGrid columns="2" id="gridPanel4" style="height: 100%" width="481">
                                        <webuijsf:dropDown binding="#{ABMUsuarios.uiEmpleado}" id="uiEmpleado" items="#{SessionBean1.listaEmpleadosOp}"/>
                                        <webuijsf:message for="uiEmpleado" id="message6" showDetail="false" showSummary="true"/>
                                    </h:panelGrid>
                                    <webuijsf:label id="label4" text="Deposito"/>
                                    <h:panelGrid columns="2" id="gridPanel6" style="width: 100%; height: 100%;">
                                        <webuijsf:dropDown binding="#{ABMUsuarios.uiDeposito}" id="uiDeposito" items="#{SessionBean1.listaDepositosOp}"/>
                                        <webuijsf:message for="uiDeposito" id="message2" showDetail="false" showSummary="true"/>
                                    </h:panelGrid>
                                    <webuijsf:label id="label3" text="Activo"/>
                                    <h:panelGrid columns="2" id="gridPanel5" style="width: 100%; height: 100%;">
                                        <webuijsf:checkbox binding="#{ABMUsuarios.uiActivo}" id="uiActivo"/>
                                        <webuijsf:message for="uiActivo" id="message7" showDetail="false" showSummary="true"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMUsuarios.buttonsPanelAddUpdate}" columns="2" id="buttonsPanelAddUpdate" style="height: 100%" width="191">
                                    <webuijsf:button actionExpression="#{ABMUsuarios.cancelar_action}" id="cancelar" text="Cancelar"/>
                                    <webuijsf:button actionExpression="#{ABMUsuarios.buttonGuardarNuevo_action}" binding="#{ABMUsuarios.buttonGuardarNuevo}"
                                        id="buttonGuardarNuevo" text="Guardar"/>
                                    <webuijsf:button actionExpression="#{ABMUsuarios.buttonGuardarEdicion_action}" binding="#{ABMUsuarios.buttonGuardarEdicion}"
                                        id="buttonGuardarEdicion" text="Guardar"/>
                                </h:panelGrid>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
