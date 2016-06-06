<%@ taglib prefix="ctg" uri="customtags"%>
<%@ taglib uri="/jstl/core" prefix="c"%>

<div class="content">
	<div class="page-header">
		<h1>ReservationPage</h1>
	</div>
	
	<ctg:reservationInfo var="reservation"/>
	
	<c:set var="resComp" scope="page" value="${reservation.resComponent}"/>
	
	<table class="table table-striped">
		<tr>
			<td>Code</td>
			<td><c:out value="${reservation.code}"/></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><c:out value="${reservation.description}"/></td>
		</tr>
		<tr>
			<td>ComponentTypeCode</td>
			<td><c:out value="${resComp.componentTypeCode}"/></td>
		</tr>
		<tr>
			<td>CreateDateTime</td>
			<td><c:out value="${resComp.createDateTime}"/></td>
		</tr>
		<tr>
			<td>InternalStatus</td>
			<td><c:out value="${resComp.internalStatus}"/></td>
		</tr>
		<tr>
			<td>Sequence</td>
			<td><c:out value="${resComp.sequence}"/></td>
		</tr>
	</table>
</div>