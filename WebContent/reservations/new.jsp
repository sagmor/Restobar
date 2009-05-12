<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Nueva Reserva"/>
</jsp:include>
<h:form id="reservation">
	<h:panelGrid columns="2">
		<h:outputText value="Para:" />
 		<h:inputText id="name" 
 			value="#{ ReservationBean.reservation.name }" >
 		</h:inputText>

		<h:outputText value="A las: (dd/mm/yyy hh:mm)" />
 		<h:inputText id="at" 
 			value="#{ ReservationBean.reservation.at }" >
 		</h:inputText>
 		
 		<h:outputText value="Notas:" />
 		<h:inputText id="extras" 
 			value="#{ ReservationBean.reservation.extras }" >
 		</h:inputText>
	</h:panelGrid>
	<h:commandButton value="Siguiente" 
	 	actionListener="#{ ReservationBean.getData }" 
	 	action="next" />
	<h:commandLink id="back" action="listTables">
		<h:outputText value="Volver" />
	</h:commandLink>
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
