<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Svi clanovi</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	
	<jsp:include page="/WEB-INF/pages/index.jsp"></jsp:include>
	<div>
		<div class="container fill">
			<table class="table table-striped">
				<tbody>
					<tr>
						<th>Ime</th>
						<th>Prezime</th>
						<th>Grad</th>
						<th>Adresa</th>
						<th>Email</th>
						<th>Broj clanske karte</th>
						<th>Pocetak pretplate</th>
						<th>Kraj</th>
						<th>Details</th>
						<th>Edit</th>
						<th>Remove</th>
					</tr>
					<c:forEach items="${clanovi}" var="clan">
						<c:url value="/clan/details" var="clanDetails">
							<c:param name="id" value="${clan.id}"></c:param>
						</c:url>

						<c:url value="/clan/edit" var="clanEdit">
							<c:param name="id" value="${clan.id}"></c:param>
						</c:url>

						<c:url value="/clan/remove" var="clanRemove">
							<c:param name="id" value="${clan.id}"></c:param>
						</c:url>


						<tr>
							<td>${clan.ime}</td>
							<td>${clan.prezime}</td>
							<td>${clan.gradDto.naziv}</td>
							<td>${clan.adresa}</td>
							<td>${clan.email}</td>
							<td>${clan.brClanskeKarte}</td>
							<td>${clan.pocetakPretplate}</td>
							<td>${clan.krajPretplate}</td>
							<td><a href="${studentDetails}">Details</a></td>
							<td><a href="${studentEdit}">Edit</a></td>
							<td><a href="${studentRemove}"
								onclick="return confirm('Are you sure you wanna remove this subject?')">Remove</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${not empty errorMessage }">
				<div class="alert alert-danger" role="alert">${errorMessage}</div>
			</c:if>
		</div>
	</div>

</body>
</html>