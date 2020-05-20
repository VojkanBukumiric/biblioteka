<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista svih knjiga</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/index.jsp"></jsp:include>
	<div class="container fill">
		<table class="table table-striped">
			<tbody>

				<tr>
					<th>Naziv</th>
					<th>Zanr</th>
					<th>Autor</th>
					<th>Broj stranica</th>
					<th>Details</th>
					<th>Edit</th>
					<th>Remove</th>
				</tr>
				<c:forEach items="${knjige}" var="knjiga">

					<c:url value="/knjiga/details" var="knjigaDetails">
						<c:param name="id" value="${knjiga.id}"></c:param>
					</c:url>
					<c:url value="/knjiga/edit" var="knjigaEdit">
						<c:param name="id" value="${knjiga.id}"></c:param>
					</c:url>
					<c:url value="/knjiga/remove" var="knjigaRemove">
						<c:param name="id" value="${knjiga.id}"></c:param>
					</c:url>


					<tr>
						<td>${knjiga.naziv}</td>
						<td>${knjiga.zanrDto.vrsta}</td>
						<td>${knjiga.autorDto.imeIPrezime}</td>
						<td>${knjiga.brojStrana}</td>

						<td><a href="${knjigaDetails}">Details</a></td>
						<td><a href="${knjigaEdit}">Edit</a></td>
						<td><a href="${knjigaRemove}"
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