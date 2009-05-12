<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Indice"/>
</jsp:include>
<h1>Reservas:</h1>
<h:form id="reservationsList">
<h:commandLink id="new" action="newReservation" actionListener="#{ ReservationBean.newReservation }">
	<h:outputText value="Agregar Reserva" />
</h:commandLink>
<h:dataTable id="reservations" value="#{ ReservationListBean.reservations }" var="reservation" border="1"> 
	<h:column>
		<f:facet name="header">
 			<h:outputText value="Nº"/>
 		</f:facet>
 		<h:outputText value="#{ reservation.id }" />
	</h:column>
	<h:column>
		<f:facet name="header">
 			<h:outputText value="Nombre"/>
 		</f:facet>
 		<h:outputText value="#{ reservation.name }" />
	</h:column>
	<h:column>
		<f:facet name="header">
 			<h:outputText value="Mesa"/>
 		</f:facet>
 		<h:commandLink id="tableShow" action="showTable" actionListener="#{ TableBean.loadTable }">
			<h:outputText value="#{ reservation.tableId }" />
			<f:param id="showTableId" name="tableId" value="#{ reservation.tableId }" />
		</h:commandLink>
	</h:column>
	<h:column>
		<f:facet name="header">
 			<h:outputText value="Fecha"/>
 		</f:facet>
 		<h:outputText value="#{ reservation.at }" />
	</h:column>
	<h:column>
		<f:facet name="header">
 			<h:outputText value="Acciones"/>
 		</f:facet>
		<h:commandLink id="delete" action="deleteReservation" actionListener="#{ReservationBean.loadReservation }">
			<h:outputText value="Eliminar" />
			<f:param id="deleteReservationId" name="reservationId" value="#{reservation.id}" />
		</h:commandLink>
	</h:column>
</h:dataTable>
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
