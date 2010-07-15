<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Page1
    Created on : 17-oct-2009, 15:17:26
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
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <div style="left: 528px; top: 216px; position: absolute">
                            <h:panelGrid id="mainContainer" style="height: 100%; text-align: center; width: 100%" width="100%">
                                <webuijsf:image id="image1" url="/resources/Images/Logo.jpg"/>
                                <webuijsf:image id="image2" url="/resources/Images/logo_platinum.jpg"/>
                                <webuijsf:button actionExpression="#{Inicio.button1_action}" id="button1" text="Salir"/>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
