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
                    <webuijsf:script id="scriptPopUp" type="text/javascript" url="/js/utilJS.js"/>
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
                            <h:panelGrid columns="2" id="mainContainer" style="height: 173px; left: 288px; top: 240px; position: absolute" width="456">
                                <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:uiTxtCodCliente_field', 'form1:uiTxtNombreCliente_field')"
                                    target="popup" text="Cliente" url="/faces/popup/popupCliente.jsp"/>
                                <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                    <webuijsf:textField binding="#{LSTExtractoCtaCliente.uiTxtCodCliente}" columns="10" id="uiTxtCodCliente" maxLength="15"/>
                                    <webuijsf:textField binding="#{LSTExtractoCtaCliente.uiTxtNombreCliente}" columns="50" id="uiTxtNombreCliente"/>
                                </h:panelGrid>
                                <webuijsf:label id="label1" rendered="false" text="Fecha Desde"/>
                                <webuijsf:calendar binding="#{LSTExtractoCtaCliente.uiCalDesde}" columns="15" id="uiCalDesde" rendered="false"/>
                                <webuijsf:label id="label3" rendered="false" text="Fecha Hasta"/>
                                <webuijsf:calendar binding="#{LSTExtractoCtaCliente.uiCalHasta}" columns="15" id="uiCalHasta" rendered="false"/>
                                <webuijsf:button actionExpression="#{LSTExtractoCtaCliente.button1_action}" id="button1" style="height: 24px" text="Extracto Cuenta a Dia"/>
                                <webuijsf:button actionExpression="#{LSTExtractoCtaCliente.button3424324_action}" id="button3424324" rendered="false"
                                    style="height: 24px" text="Extracto Cuenta a la Fecha"/>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="mensaje" style="height: 125px; left: 288px; top: 408px; position: absolute" width="456">
                                <webuijsf:messageGroup id="messageGroup1"/>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
