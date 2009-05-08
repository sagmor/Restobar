<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Indice"/>
</jsp:include>
<h1>Mesa ${ TableBean.table.id }</h1>
<dl>
	<dt>Ubicación:</dt>
	<dd>${ TableBean.table.location }</dd>
	
	<dt>Asientos:</dt>
	<dd>${ TableBean.table.spaces }</dd>
</dl>

<h:form id="table">
<strong>Acciones: </strong>
<h:commandLink id="back" action="listTables">
	<h:outputText value="Volver" />
</h:commandLink> |
<h:commandLink id="edit" action="editTable" actionListener="#{TableBean.loadTable}">
	<h:outputText value="Editar" />
	<f:param id="editTableId" name="tableId" value="#{TableBean.table.id}" />
</h:commandLink> |
<h:commandLink id="delete" action="deleteTable" actionListener="#{TableBean.loadTable}">
	<h:outputText value="Eliminar" />
	<f:param id="deleteTableId" name="tableId" value="#{TableBean.table.id}" />
</h:commandLink>
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
