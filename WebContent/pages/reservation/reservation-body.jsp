<%@ taglib prefix="ctg" uri="customtags"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<%@ taglib uri="/tags/struts-bean" prefix="b"%>

<div class="content">
	<div class="page-header">
		<h1><b:message key="reserv.jsp.content.header"/></h1>
	</div>
	
	<ctg:reservationInfo var="reservation"/>
	
	<c:set var="resComp" scope="page" value="${reservation.resComponent}"/>
	
	<table class="table table-striped">
		<tr>
			<td><b:message key="reserv.jsp.prompt.code"/></td>
			<td><c:out value="${reservation.code}"/></td>
		</tr>
		<tr>
			<td><b:message key="reserv.jsp.prompt.descr"/></td>
			<td><c:out value="${reservation.description}"/></td>
		</tr>
		<tr>
			<td><b:message key="reserv.jsp.prompt.compCode"/></td>
			<td><c:out value="${resComp.componentTypeCode}"/></td>
		</tr>
		<tr>
			<td><b:message key="reserv.jsp.prompt.createDateTime"/></td>
			<td><c:out value="${resComp.createDateTime}"/></td>
		</tr>
		<tr>
			<td><b:message key="reserv.jsp.prompt.internalStatus"/></td>
			<td><c:out value="${resComp.internalStatus}"/></td>
		</tr>
		<tr>
			<td><b:message key="reserv.jsp.prompt.sequence"/></td>
			<td><c:out value="${resComp.sequence}"/></td>
		</tr>
	</table>
</div>