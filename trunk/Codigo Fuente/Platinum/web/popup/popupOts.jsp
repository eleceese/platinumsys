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
                            style="height: 77px; left: 0px; top: 0px; position: absolute" title="Seleccione La OT" width="452">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="15" sourceData="#{SessionBean1.listaOtCab}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Cod OT" id="tableColumn1" sort="codOrdenTrabjo" width="89">
                                    <webuijsf:hyperlink id="hyperlink1" text="#{currentRow.value['codOrdenTrabjo']}" onClick="doSave('#{currentRow.value['codOrdenTrabjo']}','#{currentRow.value['descripcion']}')"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Descripcion" id="tableColumn2" width="142">
                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['descripcion']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Producto" id="tableColumn3" sort="codProductoOt" width="119">
                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProductoOt']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Cantidad" id="tableColumn4" width="54">
                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['cantidadOt']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popup$popupOts.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:textField binding="#{popup$popupOts.uiTxtParam}" columns="35" id="uiTxtParam" label="Producto" tabIndex="1" valueChangeListenerExpression="#{popup$popupOts.uiTxtParam_processValueChange}"/>
                                    <webuijsf:button actionExpression="#{popup$popupOts.uiBtnBuscar_action}" binding="#{popup$popupOts.uiBtnBuscar}"
                                        id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{popup$popupOts.uiBtnTodos_action}" binding="#{popup$popupOts.uiBtnTodos}"
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
