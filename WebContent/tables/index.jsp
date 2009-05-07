<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="/tags/app" prefix="app" %>
<f:view>
<app:content title="Lista Mesas">

<h1>Mesas:</h1>

<h:form id="tablesList">
<h:dataTable id="tables" value="#{ TableListBean.tables }" var="table" border="1"> 
	<h:column>
		<f:facet name="header">
 			<h:outputText value="Asientos"/>
 		</f:facet>
 		<h:outputText value="#{ table.spaces }" />
	</h:column>
	<h:column>
		<f:facet name="header">
 			<h:outputText value="Ubicación"/>
 		</f:facet>
 		<h:outputText value="#{ table.location }" />
	</h:column>
	<h:column>
		<f:facet name="header">
 			<h:outputText value="Editar"/>
 		</f:facet>
 		<h:commandLink id="edit" action="editTable" actionListener="#{TableBean.loadTable}">
			<h:outputText value="Editar" />
			<f:param id="tableId" name="id" value="#{table.id}" />
		</h:commandLink>
	</h:column>
</h:dataTable>
</h:form>
</app:content>
</f:view>
