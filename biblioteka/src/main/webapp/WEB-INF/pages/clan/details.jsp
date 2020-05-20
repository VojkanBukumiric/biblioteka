<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalji o clanu</title>
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
					<th>Ime</th>
					<th>Prezime</th>
					<th>Grad</th>
					<th>Adresa</th>
					<th>Email</th>
					<th>Broj clanske karte</th>
					<th>Pocetak pretplate</th>
					<th>Kraj pretplate</th>
				</tr>
				<tr>
					<td>${clanDto.ime}</td>
					<td>${clanDto.prezime}</td>
					<td>${clanDto.gradDto.naziv}</td>
					<td>${clanDto.adresa}</td>
					<td>${clanDto.email}</td>
					<td>${clanDto.brClanskeKarte}</td>
					<td>${clanDto.pocetakPretplate}</td>
					<td>${clanDto.krajPretplate}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>