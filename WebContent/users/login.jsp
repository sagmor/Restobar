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
 		
 		<h:outputText value="Password:" />
 		<h:inputSecret id="password" 
 			value="#{ UserBean.user.password }" >
 		</h:inputSecret>
 		
	</h:panelGrid>
	<h:commandButton value="Entrar" ></h:commandButton>
	
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>



