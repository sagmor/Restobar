<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Indice"/>
</jsp:include>
<h1>Usuario ${ Userbean.user.id }</h1>
<dl>

	<dt>Nombre de Usuario:</dt>
	<dd>${ Userbean.user.nombre_usuario }</dd>
	
	<dt>Nombre:</dt>
	<dd>${ Userbean.user.nombre }</dd>
	
	<dt>Fecha de Creación:</dt>
	<dd>${ Userbean.user.fecha_creacion }</dd>
	
	<dt>Fecha de Expiración:</dt>
	<dd>${ Userbean.user.fecha_expiracion }</dd>
	
	<dt>Perfil:</dt>
	<dd>${ Userbean.user.perfil }</dd>
	
	<dt>Password:</dt>
	<dd>${ Userbean.user.password }</dd>
	
	
</dl>

<h:form id="table">
<strong>Acciones: </strong>
<h:commandLink id="back" action="listUsers">
	<h:outputText value="Volver" />
</h:commandLink> |
<h:commandLink id="edit" action="editUser" actionListener="#{Userbean.loadUser}">
	<h:outputText value="Editar" />
	<f:param id="editUserId" name="userId" value="#{Userbean.user.id}" />
</h:commandLink> |
<h:commandLink id="delete" action="deleteUser" actionListener="#{Userbean.loadUser}">
	<h:outputText value="Eliminar" />
	<f:param id="deleteUserId" name="userId" value="#{Userbean.user.id}" />
</h:commandLink>
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
