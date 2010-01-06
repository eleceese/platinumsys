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
                    <webuijsf:script binding="#{popupproductos.script1}" id="script1" type="text/javascript" url="/popup/petrobrasScript.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true"
                            style="height: 77px; left: 0px; top: 0px; position: absolute; width: 500px" title="Seleccione un Producto..." width="500">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="20" sourceData="#{SessionBean1.productos}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Codigo" id="tableColumn1" sort="codProducto" width="50">
                                    <webuijsf:hyperlink id="hyperlink1"
                                        onClick="doSave('#{currentRow.value['codProducto']}', '#{currentRow.value['descripcion']}')" text="#{currentRow.value['codProducto']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Producto" id="tableColumn2" sort="descripcion" width="450">
                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['descripcion']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popupproductos.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:textField binding="#{popupproductos.txtBuscar}" columns="50" id="txtBuscar" label="Producto" tabIndex="1"/>
                                    <webuijsf:button actionExpression="#{popupproductos.btnBuscar_action}" binding="#{popupproductos.btnBuscar}" id="btnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{popupproductos.btnLimpiar_action}" binding="#{popupproductos.btnLimpiar}"
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
