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
                            style="height: 77px; left: 0px; top: 0px; position: absolute" title="Seleccione una Factura" width="504">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="20" sourceData="#{SessionBean1.listaFacturaCompra}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Nro. Factura" id="tableColumn1" width="113">
                                    <webuijsf:hyperlink id="hyperlink1" onClick="doSave('#{currentRow.value['codFacComCab']}')" text="#{currentRow.value['nroFactura']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Proveedor" id="tableColumncliente" width="192">
                                    <webuijsf:staticText id="staticTextcli" text="#{currentRow.value['codProveedor'].nombreProveedor}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Fecha" id="tableColumnfecha" width="111">
                                    <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticTextfec" text="#{currentRow.value['fecha']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Total" id="tableColumntotal" width="176">
                                    <webuijsf:staticText id="staticTexttotal" text="#{currentRow.value['total']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popup$popupFacturaCompra.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:textField binding="#{popup$popupFacturaCompra.uiTxtParam}" columns="35" id="uiTxtParam" label="Proveedor" tabIndex="1"/>
                                    <webuijsf:button actionExpression="#{popup$popupFacturaCompra.uiBtnBuscar_action}"
                                        binding="#{popup$popupFacturaCompra.uiBtnBuscar}" id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{popup$popupFacturaCompra.uiBtnTodos_action}"
                                        binding="#{popup$popupFacturaCompra.uiBtnTodos}" id="uiBtnTodos" text="Todos"/>
                                </webuijsf:panelGroup>
                            </f:facet>
                        </webuijsf:table>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
