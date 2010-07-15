<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ABMParametros
    Created on : Jul 15, 2010, 5:50:43 PM
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
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <h:panelGrid id="mainContainer" style="height: 480px; left: 216px; top: 168px; position: absolute" width="888">
                            <h:panelGrid columns="2" id="gridPanel1" style="height: 368px" width="599">
                                <h:panelGrid binding="#{ABMParametros.gridPanel2}" columns="1" id="gridPanel2" style="width: 100%; height: 100%;">
                                    <h:panelGrid columns="1" id="gridPanel4" style="width: 100%; height: 100%;">
                                        <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true"
                                            style="height: 122px; width: 527px" title="Parametros" width="317">
                                            <webuijsf:tableRowGroup binding="#{ABMParametros.tableRowGroup1}" id="tableRowGroup1" rows="4"
                                                selected="#{ABMParametros.selectedState}" sourceData="#{SessionBean1.listaParametros}" sourceVar="currentRow">
                                                <webuijsf:tableColumn align="center" binding="#{ABMParametros.tableColumn6}" id="tableColumn6"
                                                    onClick="setTimeout('initAllRows()',0)" selectId="#{ABMParametros.radioButton1.id}">
                                                    <webuijsf:radioButton binding="#{ABMParametros.radioButton1}" id="radioButton1" label=""
                                                        name="#{ABMParametros.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMParametros.selected}" selectedValue="#{ABMParametros.selectedValue}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Codigo" id="tableColumn2">
                                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['codParametro']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" headerText="Descripcion" id="tableColumn3" sort="descripcion">
                                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['descripcion']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Valor Texto" id="tableColumn5">
                                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['valorTexto']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Valor Numero" id="tableColumn4">
                                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['valorNumero']}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <webuijsf:button actionExpression="#{ABMParametros.uiEditar_action}" id="uiEditar" text="Editar"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMParametros.gridPanel5}" id="gridPanel5" style="width: 100%; height: 100%;">
                                    <webuijsf:label id="label2" text="Numero"/>
                                    <webuijsf:textField binding="#{ABMParametros.uiNumero}" id="uiNumero"/>
                                    <webuijsf:label id="label1" text="Texto"/>
                                    <webuijsf:textField binding="#{ABMParametros.uiTexto}" id="uiTexto"/>
                                    <h:panelGrid columns="2" id="gridPanel3" style="height: 100%" width="143">
                                        <webuijsf:button actionExpression="#{ABMParametros.button1_action}" id="button1" text="Guardar"/>
                                        <webuijsf:button id="button2" text="Cancelar"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
