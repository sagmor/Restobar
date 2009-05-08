<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Indice"/>
</jsp:include>
<h1>Mesas:</h1>
<h:form id="tablesList">
<h:commandLink id="new" action="newTable" actionListener="#{ TableBean.newTable }">
	<h:outputText value="Agregar Mesa" />
</h:commandLink>
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
 			<h:outputText value="Acciones"/>
 		</f:facet>
 		<h:commandLink id="show" action="showTable" actionListener="#{TableBean.loadTable}">
			<h:outputText value="Ver" />
			<f:param id="showTableId" name="tableId" value="#{table.id}" />
		</h:commandLink> |
 		<h:commandLink id="edit" action="editTable" actionListener="#{TableBean.loadTable}">
			<h:outputText value="Editar" />
			<f:param id="editTableId" name="tableId" value="#{table.id}" />
		</h:commandLink> |
		<h:commandLink id="delete" action="deleteTable" actionListener="#{TableBean.loadTable}">
			<h:outputText value="Eliminar" />
			<f:param id="deleteTableId" name="tableId" value="#{table.id}" />
		</h:commandLink>
	</h:column>
</h:dataTable>
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
