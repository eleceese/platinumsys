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
                            style="left: 0px; top: 0px; position: absolute" title="Seleccione un Cliente..." width="555">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="20" sourceData="#{SessionBean1.listaCliente}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Cliente" id="tableColumn1" width="377">
                                    <webuijsf:hyperlink id="hyperlink1"
                                        onClick="doSave('#{currentRow.value['codCliente']}', '#{currentRow.value['apellidoCliente']}, #{currentRow.value['nombreCliente']}')" text="#{currentRow.value['apellidoCliente']}, #{currentRow.value['nombreCliente'] }"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Codigo" id="tableColumn2" width="178">
                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['codCliente']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popup$popupCliente.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:textField binding="#{popup$popupCliente.uiTxtParam}" columns="35" id="uiTxtParam" label="Cliente" tabIndex="1"/>
                                    <webuijsf:button actionExpression="#{popup$popupCliente.uiBtnBuscar_action}" binding="#{popup$popupCliente.uiBtnBuscar}"
                                        id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{popup$popupCliente.uiBtnTodos_action}" binding="#{popup$popupCliente.uiBtnTodos}"
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
