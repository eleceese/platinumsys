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
                    <webuijsf:script binding="#{popuptareas.script1}" id="script1" type="text/javascript" url="/js/platinumJS.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <webuijsf:table augmentTitle="false" binding="#{popuptareas.table1}" id="table1" paginateButton="true" paginationControls="true"
                            style="height: 77px; left: 0px; top: 0px; position: absolute; width: 500px" title="Seleccione un Inventario..." width="0">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="20" sourceData="#{popuptareas.defaultTableDataProvider}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Nro. Invnetario" id="tableColumn1">
                                    <webuijsf:hyperlink id="hyperlink1" text="1101"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Fecha inicio" id="tableColumn2">
                                    <webuijsf:staticText id="staticText1" text="01/01/2010"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Fecha Cierre" id="tableColumn3">
                                    <webuijsf:staticText id="staticText2" text="31/01/2010"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popuptareas.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:textField binding="#{popuptareas.txtBuscar}" columns="30" id="txtBuscar" label="Nro. Inventario" tabIndex="1"/>
                                    <webuijsf:button actionExpression="#{popuptareas.btnBuscar_action}" binding="#{popuptareas.btnBuscar}" id="btnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{popuptareas.btnLimpiar_action}" binding="#{popuptareas.btnLimpiar}" id="btnLimpiar" text="Limpiar"/>
                                </webuijsf:panelGroup>
                            </f:facet>
                        </webuijsf:table>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
