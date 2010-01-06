<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : pp
    Created on : Dec 7, 2009, 9:04:46 PM
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
                        <h:panelGrid id="gridPanel1" style="left: 144px; top: 72px; position: absolute">
                            <webuijsf:table augmentTitle="false" id="table1" title="Table" width="450">
                                <webuijsf:tableRowGroup id="tableRowGroup1" rows="10" sourceData="#{pp.defaultTableDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn headerText="column1" id="tableColumn1" sort="column1">
                                        <webuijsf:staticText id="staticText1" text="#{currentRow.value['column1']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="column2" id="tableColumn2" sort="column2">
                                        <webuijsf:staticText id="staticText2" text="#{currentRow.value['column2']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="column3" id="tableColumn3" sort="column3">
                                        <webuijsf:staticText id="staticText3" text="#{currentRow.value['column3']}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
