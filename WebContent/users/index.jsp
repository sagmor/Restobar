<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 



<f:view>

<jsp:include page="/layout/header.jsp">

	<jsp:param name="title" value="Indice"/>

</jsp:include>

<h1>Users:</h1>

<h:form id="usersList">

<h:commandLink id="new" action="newUser" actionListener="#{ Userbean.newUser }">

	<h:outputText value="Agregar Usuario" />

</h:commandLink>

<h:dataTable id="users" value="#{ UserListBean.users}" var="user" border="1"> 

	<h:column>

		<f:facet name="header">

 			<h:outputText value="NÂº"/>

 		</f:facet>

 		<h:outputText value="#{ user.id }" />

	</h:column>

	<h:column>

		<f:facet name="header">

 			<h:outputText value="Nombre de Usuario"/>

 		</f:facet>

 		<h:outputText value="#{ user.nombre_usuario }" />

	</h:column>

	<h:column>

		<f:facet name="header">

 			<h:outputText value="Nombre"/>

 		</f:facet>

 		<h:outputText value="#{ user.nombre }" />

	</h:column>

	<h:column>

		<f:facet name="header">

 			<h:outputText value="Fecha Creacion"/>

 		</f:facet>

 		<h:outputText value="#{ user.fecha_creacion}" />

	</h:column>

	<h:column>

		<f:facet name="header">

 			<h:outputText value="Fecha Expiración"/>

 		</f:facet>

 		<h:outputText value="#{ user.fecha_expiracion }" />

	</h:column>
	
	<h:column>

		<f:facet name="header">

 			<h:outputText value="Perfil"/>

 		</f:facet>

 		<h:outputText value="#{ user.perfil}" />

	</h:column>
	
	<h:column>

		<f:facet name="header">

 			<h:outputText value="Password"/>

 		</f:facet>

 		<h:outputText value="#{ user.password }" />

	</h:column>


	<h:column>

		<f:facet name="header">
 			<h:outputText value="Acciones"/>
 		</f:facet>

 		<h:commandLink id="show" action="showUser" actionListener="#{Userbean.loadUser}">

			<h:outputText value="Ver" />

			<f:param id="showUserId" name="userId" value="#{user.id}" />

		</h:commandLink> |

 		<h:commandLink id="edit" action="editUser" actionListener="#{Userbean.loadUser}">

			<h:outputText value="Editar" />

			<f:param id="editUserId" name="userId" value="#{user.id}" />

		</h:commandLink> |

		<h:commandLink id="delete" action="deleteUser" actionListener="#{Userbean.loadUser}">

			<h:outputText value="Eliminar" />

			<f:param id="deleteUserId" name="userId" value="#{user.id}" />

		</h:commandLink>

	</h:column>

</h:dataTable>

</h:form>

<jsp:include page="/layout/footer.jsp"/>

</f:view>

