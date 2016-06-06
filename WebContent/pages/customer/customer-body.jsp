<%@ taglib prefix="ctg" uri="customtags"%>
<%@ taglib uri="/jstl/core" prefix="c"%>

<div class="content">
	<div class="page-header">
		<h1>CustomerPage</h1>
	</div>
	
	<ctg:customerInfo var="customer"/>
	
	<c:set var="payments" scope="page" value="${customer.payments}"/>
	
	<table class="table table-striped">
		<tr>
			<td>FirstName</td>
			<td><c:out value="${customer.firstName}"/></td>
		</tr>
		<tr>
			<td>LastName</td>
			<td><c:out value="${customer.lastName}"/></td>
		</tr>
		<tr>
			<td>EmailAddress</td>
			<td><c:out value="${customer.emailAddress}"/></td>
		</tr>
		<tr>
			<td>PhoneNumber</td>
			<td><c:out value="${customer.phoneNumber}"/></td>
		</tr>
		
		<c:forEach var="payment" items="${payments}">
			<tr>
				<td>AmountPaid</td>
				<td><c:out value="${payment.amountPaid}"/></td>
			</tr>
			<tr>
				<td>FormOfPaymentTypeCode</td>
				<td><c:out value="${payment.formOfPaymentTypeCode}"/></td>
			</tr>
			<tr>
				<td>CurrencyCode</td>
				<td><c:out value="${payment.currencyCode}"/></td>
			</tr>
		</c:forEach>
	</table>
</div>