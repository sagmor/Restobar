<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Borrar Reserva"/>
</jsp:include>
<h1>Estas a punto de borrar una reserva!</h1>
<h2>Estas Seguro?</h2>
<h:form id="reservation">
	<h:inputHidden id="id" value="#{ ReservationBean.reservation.id }"/>
	<h:commandButton value="Borrar!" 
	 	actionListener="#{ ReservationBean.deleteReservation }" 
	 	action="delete" />
	<h:commandButton value="Cancelar"
	 	action="return" />
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
