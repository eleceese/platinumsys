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
                    <webuijsf:script binding="#{popupEmpleados.script1}" id="script1" type="text/javascript" url="/js/platinumJS.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <webuijsf:table augmentTitle="false" binding="#{popupEmpleados.table1}" id="table1" paginateButton="true" paginationControls="true"
                            style="height: 77px; left: 0px; top: 0px; position: absolute; width: 500px" title="Seleccione un Cobrador..." width="113">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="20" sourceData="#{popupEmpleados.defaultTableDataProvider}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Código" id="tableColumn1" width="113">
                                    <webuijsf:hyperlink id="hyperlink1" text="123456"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Nombre" id="tableColumn2">
                                    <webuijsf:staticText id="staticText1" text="Juan Perez"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popupEmpleados.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:textField binding="#{popupEmpleados.txtBuscar}" columns="35" id="txtBuscar" label="Cobrador" tabIndex="1"/>
                                    <webuijsf:button actionExpression="#{popupEmpleados.btnBuscar_action}" binding="#{popupEmpleados.btnBuscar}" id="btnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{popupEmpleados.btnLimpiar_action}" binding="#{popupEmpleados.btnLimpiar}"
                                        id="btnLimpiar" text="Limpiar"/>
                                </webuijsf:panelGroup>
                            </f:facet>
                        </webuijsf:table>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
