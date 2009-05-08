<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Indice"/>
</jsp:include>
<h:form id="table">
	<h:panelGrid columns="2">
		<h:outputText value="Asientos:" />
 		<h:inputText id="spaces" 
 			value="#{ TableBean.table.spaces }" >
 		</h:inputText>
 		
 		<h:outputText value="Ubicación:" />
 		<h:inputText id="location" value="#{ TableBean.table.location }">
 		
 		</h:inputText>
	</h:panelGrid>
	<h:commandButton value="Guardar" 
	 	actionListener="#{ TableBean.saveTable }" 
	 	action="#{ TableBean.validateTable }" />
	<h:commandLink id="back" action="listTables">
		<h:outputText value="Volver" />
	</h:commandLink>
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
