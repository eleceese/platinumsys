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
                            style="height: 77px; left: 0px; top: 0px; position: absolute" title="Seleccione una Tarea" width="600">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="15" sourceData="#{SessionBean1.tareasAsignadasArray}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Tarea" id="tableColumn1" sort="codTarea">
                                    <webuijsf:hyperlink id="hyperlink1"
                                        onClick="doSave('#{currentRow.value['codTarea'].codTarea}', '#{currentRow.value['codTarea']}','#{currentRow.value['codTareaAsignada']}')" text="#{currentRow.value['codTarea']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Cod Tarea" id="tableColumn2" sort="codTareaAsignada">
                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['codTareaAsignada']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Cod Sub OT" id="tableColumn3" sort="codDetOrdenTrabaj">
                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['codDetOrdenTrabaj'].codOrdenTrabajo}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Cant" id="tableColumn4" sort="cantidad">
                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['cantidad']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Cant Prod" id="tableColumn5" sort="cantidadReal">
                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['cantidadReal']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popup$popupTareaAsignadaOTProdDiaria.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:textField binding="#{popup$popupTareaAsignadaOTProdDiaria.uiTxtParam}" columns="35" id="uiTxtParam"
                                        label="Producto" tabIndex="1"/>
                                    <webuijsf:button actionExpression="#{popup$popupTareaAsignadaOTProdDiaria.uiBtnBuscar_action}"
                                        binding="#{popup$popupTareaAsignadaOTProdDiaria.uiBtnBuscar}" id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{popup$popupTareaAsignadaOTProdDiaria.uiBtnTodos_action}"
                                        binding="#{popup$popupTareaAsignadaOTProdDiaria.uiBtnTodos}" id="uiBtnTodos" text="Todos"/>
                                </webuijsf:panelGroup>
                            </f:facet>
                        </webuijsf:table>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
