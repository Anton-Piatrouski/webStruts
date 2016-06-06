<%@ taglib prefix="ctg" uri="customtags"%>
<%@ taglib uri="/jstl/core" prefix="c"%>

<div class="content">
	<div class="page-header">
		<h1>FareFamilyPage</h1>
	</div>
	
	<ctg:fareFamilyInfo var="fareFamily"/>
	
	<c:set var="components" scope="page" value="${fareFamily.ancillaryAirComponents}"/>
	
	<table class="table table-striped">
		<tr>
			<td>FareFamilyCode</td>
			<td><c:out value="${fareFamily.fareFamilyCode}"/></td>
		</tr>
		
		<c:forEach var="component" items="${components}">
			<tr>
				<td>AncillaryAirComponentCode</td>
				<td><c:out value="${component.ancillaryAirComponentCode}"/></td>
			</tr>
		</c:forEach>
	</table>
</div>