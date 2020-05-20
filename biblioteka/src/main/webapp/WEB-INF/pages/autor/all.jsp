<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista svih autora</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
.error {
	color: red;
}

body {
	padding-top: 56px;
	display: flex;
	position: relative;
	flex-direction: column;
	height: 100vh;
}

.fill {
	flex: 1;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/index.jsp"></jsp:include>
	<div class="container fill">
		<table class="table table-striped">
			<tbody>

				<tr>
					<th>Ime</th>
					<th>Prezime</th>
					<th>Knjizevna Vrsta</th>
					<th>Details</th>
					<th>Edit</th>
					<th>Remove</th>
				</tr>
				<c:forEach items="${autors}" var="autor">

					<c:url value="/autor/details" var="autorDetails">
						<c:param name="id" value="${autor.id}"></c:param>
					</c:url>
					<c:url value="/autor/edit" var="autorEdit">
						<c:param name="id" value="${autor.id}"></c:param>
					</c:url>
					<c:url value="/autor/remove" var="autorRemove">
						<c:param name="id" value="${autor.id}"></c:param>
					</c:url>


					<tr>
						<td>${autor.ime}</td>
						<td>${autor.prezime}</td>
						<td>${autor.knjizevnaVrsta}</td>

						<td><a href="${autorDetails}">Details</a></td>
						<td><a href="${autorEdit}">Edit</a></td>
						<td><a href="${autorRemove}"
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

</body>
</html>