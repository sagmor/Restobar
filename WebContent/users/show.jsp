<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Indice"/>
</jsp:include>
<h1>Usuario ${ UserBean.user.id }</h1>
<dl>

	<dt>Nombre de Usuario:</dt>
	<dd>${ UserBean.user.nombre_usuario }</dd>
	
	<dt>Nombre:</dt>
	<dd>${ UserBean.user.nombre }</dd>
	
	<dt>Fecha de Creación:</dt>
	<dd>${ UserBean.user.fecha_creacion }</dd>
	
	<dt>Fecha de Expiración:</dt>
	<dd>${ UserBean.user.fecha_expiracion }</dd>
	
	<dt>Perfil:</dt>
	<dd>${ UserBean.user.perfil }</dd>
	
	<dt>Password:</dt>
	<dd>${ UserBean.user.password }</dd>
	
	
</dl>

<h:form id="table">
<strong>Acciones: </strong>
<h:commandLink id="back" action="listUsers">
	<h:outputText value="Volver" />
</h:commandLink> |
<h:commandLink id="edit" action="editUser" actionListener="#{UserBean.loadUser}">
	<h:outputText value="Editar" />
	<f:param id="editUserId" name="userId" value="#{UserBean.user.id}" />
</h:commandLink> |
<h:commandLink id="delete" action="deleteUser" actionListener="#{UserBean.loadUser}">
	<h:outputText value="Eliminar" />
	<f:param id="deleteUserId" name="userId" value="#{UserBean.user.id}" />
</h:commandLink>
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
