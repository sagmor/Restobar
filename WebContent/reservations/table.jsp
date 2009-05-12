<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<f:view>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Nueva Reserva"/>
</jsp:include>
<h:form id="reservation">
	<h:selectOneRadio id="tableId" value="#{ ReservationBean.reservation.tableId }">
		<c:forEach items="#{ReservationBean.availableTables}" var="table">
			<f:selectItem itemValue="#{ table.id }" itemLabel="#{ table }"/>
		</c:forEach>
	</h:selectOneRadio>
	
	<h:commandButton value="Siguiente" 
	 	actionListener="#{ ReservationBean.getTableAndSave }" 
	 	action="save" />
	<h:commandLink id="back" action="listTables">
		<h:outputText value="Volver" />
	</h:commandLink>
</h:form>
<jsp:include page="/layout/footer.jsp"/>
</f:view>
