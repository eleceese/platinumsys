<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Reporte
    Created on : 07-sep-2009, 16:17:37
    Author     : MartinJara
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
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <div>
                            <h:panelGrid columns="2" id="mainContainer" style="height: 221px; left: 288px; top: 235px; position: absolute; vertical-align: top" width="456">
                                <webuijsf:label id="label1" text="Fecha Inicio"/>
                                <webuijsf:calendar binding="#{LSTRanking.uiCalDesde}" columns="15" id="uiCalDesde"/>
                                <webuijsf:label id="label3" text="Fecha Fin"/>
                                <webuijsf:calendar binding="#{LSTRanking.uiCalHasta}" columns="15" id="uiCalHasta"/>
                                <webuijsf:label id="labelTipoListado" text="Tipo Listado"/>
                                <webuijsf:radioButtonGroup binding="#{LSTRanking.uiTipoReporte}" columns="2" id="uiTipoReporte"
                                    items="#{LSTRanking.uiTipoReporteDefaultOptions.options}" selected="#{LSTRanking.uiTipoReporteDefaultOptions.selectedValue}"/>
                                <webuijsf:button actionExpression="#{LSTRanking.button1_action}" id="button1" text="Ejecutar"/>
                                <webuijsf:button actionExpression="#{LSTRanking.button2_action}" id="button2" text="Cancelar"/>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
