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
                        <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true"
                            style="height: 77px; left: 0px; top: 0px; position: absolute" title="Seleccione una Tarea..." width="0">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="20" sourceData="#{SessionBean1.listaTareas}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Tarea" id="tableColumn1" sort="nombreTarea">
                                    <webuijsf:hyperlink id="hyperlink1"
                                        onClick="doSave('#{currentRow.value['codTarea']}', '#{currentRow.value['nombreTarea']}')" text="#{currentRow.value['nombreTarea']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Cod Tarea" id="tableColumn2" sort="codTarea">
                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['codTarea']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popup$popupTareas_1.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:textField binding="#{popup$popupTareas_1.uiTxtParam}" columns="35" id="uiTxtParam" label="Tarea" tabIndex="1"/>
                                    <webuijsf:button actionExpression="#{popup$popupTareas_1.uiBtnBuscar_action}" binding="#{popup$popupTareas_1.uiBtnBuscar}"
                                        id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{popup$popupTareas_1.uiBtnTodos_action}" binding="#{popup$popupTareas_1.uiBtnTodos}"
                                        id="uiBtnTodos" text="Todos"/>
                                </webuijsf:panelGroup>
                            </f:facet>
                        </webuijsf:table>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
