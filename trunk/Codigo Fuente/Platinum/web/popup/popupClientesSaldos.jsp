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
                            style="height: 77px; left: 0px; top: 0px; position: absolute; width: 870px" title="Seleccione un Comprobante..." width="870">
                            <f:facet name="actionsTop"/>
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="20" sourceData="#{ABMReciboDinero.lstSaldos}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="Tipo Comprobante" id="tableColumn1" width="185">
                                    <webuijsf:hyperlink id="hyperlink1"
                                        onClick="doSave(&#xd;&#xa;'#{currentRow.value['descTipoComprobante']}-#{currentRow.value['codSaldoCliente']}', &#xd;&#xa;'#{currentRow.value['nroComprobante']}',&#xd;&#xa;'#{currentRow.value['codComprobante']}',&#xd;&#xa;'#{currentRow.value['nroCuota']}',&#xd;&#xa;'#{currentRow.value['fecVencimiento']}',&#xd;&#xa;'#{currentRow.value['totalComprobante']}',&#xd;&#xa;'#{currentRow.value['saldoComprobante']}'&#xd;&#xa;)" text="#{currentRow.value['descTipoComprobante']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Nro. Comprobante" id="tableColumn2" width="137">
                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['nroComprobante']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Nro. Cuota" id="tableColumn3" width="79">
                                    <webuijsf:staticText converter="#{popup$popupClientesSaldos.numberConverter1}" id="staticText1" text="#{currentRow.value['nroCuota']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn align="right" headerText="Vencimiento" id="tableColumn4" width="98">
                                    <webuijsf:staticText converter="#{popup$popupClientesSaldos.calendarConverter1}" id="staticText1" text="#{currentRow.value['fecVencimiento']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn align="right" headerText="Monto Cuota" id="tableColumn5" width="137">
                                    <webuijsf:staticText converter="#{popup$popupClientesSaldos.numberConverter1}" id="staticText1" text="#{currentRow.value['totalComprobante']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn align="right" headerText="Saldo Cuota" id="tableColumn6" width="137">
                                    <webuijsf:staticText converter="#{popup$popupClientesSaldos.numberConverter1}" id="staticText1" text="#{currentRow.value['saldoComprobante']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                            <f:facet name="actionsTop">
                                <webuijsf:panelGroup binding="#{popup$popupClientesSaldos.groupPanel1}" id="groupPanel1" separator="&amp;nbsp;">
                                    <webuijsf:textField binding="#{popup$popupClientesSaldos.uiTxtParam}" columns="35" id="uiTxtParam" label="Nro. Comprobante" tabIndex="1"/>
                                    <webuijsf:button actionExpression="#{popup$popupClientesSaldos.uiBtnBuscar_action}"
                                        binding="#{popup$popupClientesSaldos.uiBtnBuscar}" id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{popup$popupClientesSaldos.uiBtnTodos_action}"
                                        binding="#{popup$popupClientesSaldos.uiBtnTodos}" id="uiBtnTodos" text="Todos"/>
                                </webuijsf:panelGroup>
                            </f:facet>
                        </webuijsf:table>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
