<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Popup
    Created on : Jul 23, 2008, 12:49:06 PM
    Author     : admin
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:script id="scriptPopUp" type="text/javascript" url="/js/utilJS.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <webuijsf:table augmentTitle="false" binding="#{popup$popupFormulasSemiter.table1}" id="table1" paginateButton="true"
                            paginationControls="true" style="height: 77px; left: 0px; top: 0px; position: absolute" title="Seleccione una Formula..." width="900">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="10" sourceData="#{SessionBean1.listaFormulaCabecerasSemiTer}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Cod" id="tableColumn1" sort="codFormulaSemiCabecera" width="15">
                                    <webuijsf:hyperlink id="hyperlink1"
                                        onClick="doSave('#{currentRow.value['codProducto'].codProducto}','#{currentRow.value['codProducto'].descripcion}','#{currentRow.value['codFormulaSemiCabecera']}','#{currentRow.value['descripcion']}','#{currentRow.value['cantidad']}')" text="#{currentRow.value['codFormulaSemiCabecera']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Desc Formula" id="tableColumn2" sort="descripcion" width="263">
                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['descripcion']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Producto" id="tableColumn3" sort="codProducto" width="193">
                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProducto']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Cant" id="tableColumn4" width="80">
                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['cantidad']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popup$popupFormulasSemiter.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:textField binding="#{popup$popupFormulasSemiter.uiTxtParam}" columns="35" id="uiTxtParam" label="Producto" tabIndex="1"/>
                                    <webuijsf:button actionExpression="#{popup$popupFormulasSemiter.uiBtnBuscar_action}"
                                        binding="#{popup$popupFormulasSemiter.uiBtnBuscar}" id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{popup$popupFormulasSemiter.uiBtnTodos_action}"
                                        binding="#{popup$popupFormulasSemiter.uiBtnTodos}" id="uiBtnTodos" text="Todos"/>
                                </webuijsf:panelGroup>
                            </f:facet>
                        </webuijsf:table>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
