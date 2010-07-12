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
                        <div align="center" style="left: 120px; top: 144px; position: absolute">
                            <h:panelGrid id="mainContainer" style="height: 100%; text-align: center; width: 100%" width="100%">
                                <webuijsf:image id="image1" url="/resources/Images/Logo.jpg"/>
                                <webuijsf:image id="image2" url="/resources/Images/logo_platinum.jpg"/>
                            </h:panelGrid>
                        </div>
                        <webuijsf:staticText id="staticText1"
                            style="color: rgb(0, 0, 102); font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-weight: bold; left: 408px; top: 192px; position: absolute; text-align: center; width: 278px" text="No tiene permisos para acceder a esta pagina"/>
                        <webuijsf:staticText id="staticText2"
                            style="background-color: rgb(204, 204, 204); font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bolder; left: 408px; top: 264px; position: absolute; text-align: center; width: 286px" text="Haga click aqui para volver a la pagina principal"/>
                        <h:panelGrid columns="2" id="gridPanel1"
                            style="height: 96px; left: 408px; top: 288px; position: absolute; text-align: center; vertical-align: top" width="288">
                            <webuijsf:hyperlink actionExpression="#{PermisoDenegado.hyperlink2_action}" id="hyperlink2" text="Volver" url="/faces/Inicio.jsp"/>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
