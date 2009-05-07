<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="/tags/app" prefix="app" %>
<f:view>
<app:content title="Editando Mesa ${ TableBean.table.id }">
<h:form>
	<h:inputHidden id="tableId" value="#{ TableBean.table.id }"/>
	<h:panelGrid columns="2" border="1">
		<h:outputText value="Asientos:" />
 		<h:inputText id="tableSpaces" value="#{ TableBean.table.spaces }">
 		</h:inputText>
 		
 		<h:outputText value="Ubicación:" />
 		<h:inputText id="tableLocation" value="#{ TableBean.table.location }">
 		</h:inputText>
	</h:panelGrid>
</h:form>
</app:content>
</f:view>
