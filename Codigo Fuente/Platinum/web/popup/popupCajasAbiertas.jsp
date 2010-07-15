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
                        <webuijsf:table augmentTitle="false" binding="#{popup$popupCajasAbiertas.table1}" id="table1" paginationControls="true"
                            style="height: 77px; left: 0px; top: 0px; position: absolute" title="Seleccione un Caja..." width="442">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="20" sourceData="#{SessionBean1.listaCajaAbierta}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Caja" id="tableColumn1" sort="nombreCaja" width="305">
                                    <webuijsf:hyperlink id="hyperlink1"
                                        onClick="doSave('#{currentRow.value['codCaja']}', '#{currentRow.value['nombreCaja']}')" text="#{currentRow.value['nombreCaja']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Codigo" id="tableColumn2" sort="codCaja" width="137">
                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['codCaja']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popup$popupCajasAbiertas.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:button actionExpression="#{popup$popupCajasAbiertas.uiBtnTodos_action}" binding="#{popup$popupCajasAbiertas.uiBtnTodos}"
                                        id="uiBtnTodos" style="height: 24px; width: 143px" text="BUSCAR"/>
                                </webuijsf:panelGroup>
                            </f:facet>
                        </webuijsf:table>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
