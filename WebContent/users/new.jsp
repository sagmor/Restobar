<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Indice"/>
</jsp:include>
<h:form id="user">
	<h:panelGrid columns="2">
		<h:outputText value="Nombre de Usuario:" />
 		<h:inputText id="nombre_usuario" 
 			value="#{ UserBean.user.nombre_usuario }" >
 		</h:inputText>
 		
 		<h:outputText value="Nombre:" />
 		<h:inputText id="nombre" 
 			value="#{ UserBean.user.nombre }" >
 		</h:inputText>
 		
 		<h:outputText value="Password:" />
 		<h:inputSecret id="password" 
 			value="#{ UserBean.user.password }" >
 		</h:inputSecret>
 		
 		<h:outputText value="Fecha Expiración:" />
 		<h:inputText id="fecha_expiracion" 
 			value="#{ UserBean.user.fecha_expiracion }" >
 		</h:inputText>
 		
 		<h:outputText value="Perfil:" />
 		<h:inputText id="perfil" 
 			value="#{ UserBean.user.perfil }" >
 		</h:inputText>
 		
	</h:panelGrid>
	<h:commandButton value="Guardar" 
	 	actionListener="#{ UserBean.saveUser }" 
	 	action="#{ UserBean.validateUser }" />
	<h:commandLink id="back" action="listUsers">
		<h:outputText value="Volver" />
	</h:commandLink>
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
