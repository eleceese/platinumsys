<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ABMCliente
    Created on : Oct 18, 2009, 8:11:57 PM
    Author     : FerBoy
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <webuijsf:pageAlert binding="#{PopupBancos.pageAlert1}" id="pageAlert1" rendered="false"/>
                        <h:panelGrid binding="#{PopupBancos.gridPanelTabla}" id="gridPanelTabla" style="height: 154px" width="935">
                            <webuijsf:table augmentTitle="false" id="tableBanco" paginateButton="true" paginationControls="true" sortPanelToggleButton="true"
                                title="Bancos" width="706">
                                <webuijsf:tableRowGroup emptyDataMsg="No se encontraron registros..." id="marcas" rows="10"
                                    sourceData="#{PopupBancos.defaultTableDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn headerText="Codigo" id="id" width="100">
                                        <webuijsf:hyperlink id="hyperlink1" text="12312313"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Nombre Banco" id="tableColumn3" width="606">
                                        <webuijsf:staticText id="staticText5" text="Banco Banco Banco"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:panelGroup id="groupPanel1"/>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
