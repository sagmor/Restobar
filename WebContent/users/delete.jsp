
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Indice"/>
</jsp:include>
<h1>Estas a punto de borrar un usuario!</h1>
<h2>Estas Seguro?</h2>
<h:form id="user">
	<h:inputHidden id="id" value="#{ Userbean.user.id }"/>
	<h:commandButton value="Borrar!"
	 	actionListener="#{ Userbean.deleteUser }" 
	 	action="delete" />
	<h:commandButton value="Cancelar"
	 	action="return" />
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
