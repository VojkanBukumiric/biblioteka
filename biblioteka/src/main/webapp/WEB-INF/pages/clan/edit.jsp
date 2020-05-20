<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Izmeni clana</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<body data-gr-c-s-loaded="true">
	<jsp:include page="/WEB-INF/pages/index.jsp"></jsp:include>

	<div class="container fill">
		<div class="row">
			<div class="col-md-7 offset-3">
				<br>
				<div class="card mb-4">
					<div class="card-body">
						<h2 class="card-title">dodaj clana</h2>

						<form:form class="horizontal"
							action="${pageContext.request.contextPath}/clan/save"
							method="post" modelAttribute="clanDto">
							<fieldset>
								<form:hidden path="id" id="idId" />
								<div class="form-group row">
									<form:label path="ime" class="col-sm-3 col-form-label">Ime</form:label>
									<div class="col-sm-8">
										<form:input type="text" class="form-control" path="ime"
											id="imeId" />
										<div>
											<form:errors path="ime" cssClass="alert-danger" />
										</div>
									</div>
								</div>
								<div class="form-group row">
									<form:label path="prezime" class="col-sm-3 col-form-label">Prezime</form:label>
									<div class="col-sm-8">
										<form:input type="text" class="form-control" path="prezime"
											id="prezime" />
										<div>
											<form:errors path="prezime" cssClass="alert-danger" />
										</div>
									</div>
								</div>
								<div class="form-group row">
									<form:label path="gradDto" class="col-sm-3 col-form-label">Grad</form:label>
									<div class="col-sm-8">
										<form:select path="gradDto" class="form-control">
											<form:option value="" label="Izaberi grad"></form:option>
											<form:options items="${gradovi}" itemValue="id"
												itemLabel="naziv" />
										</form:select>
										<div>
											<form:errors path="gradDto" cssClass="alert-danger" />
										</div>
									</div>
								</div>

								<div class="form-group row">
									<form:label class="col-sm-3 col-form-label" path="adresa">Adresa</form:label>
									<div class="col-sm-8">
										<form:input type="text" path="adresa" class="form-control"
											id="adresaId" />
										<div>
											<form:errors path="adresa" cssClass="alert-danger" />
										</div>
									</div>
								</div>
								<div class="form-group row">
									<form:label class="col-sm-3 col-form-label" path="email">Email</form:label>
									<div class="col-sm-8">
										<form:input type="text" path="email" id="emailId"
											class="form-control" />
										<div>
											<form:errors path="email" cssClass="alert-danger" />
										</div>
									</div>
								</div>
								<div class="form-group row">
									<form:label class="col-sm-3 col-form-label"
										path="brClanskeKarte">Clanski broj</form:label>
									<div class="col-sm-8">
										<form:input type="text" path="brClanskeKarte"
											id="brClanskeKarteId" class="form-control" />
										<div>
											<form:errors path="brClanskeKarte" cssClass="alert-danger" />
										</div>
									</div>
								</div>

								<div class="form-group row">
									<form:label class="col-sm-3 col-form-label"
										path="pocetakPretplate">Pocetak pretplate</form:label>
									<div class="col-sm-8">
										<form:input type="date" path="pocetakPretplate"
											id="pocetakPretplateId" class="form-control" />
										<div>
											<form:errors path="pocetakPretplate" cssClass="alert-danger" />
										</div>
									</div>
								</div>
								<div class="form-group row">
									<form:label class="col-sm-3 col-form-label"
										path="krajPretplate">Kraj pretplate</form:label>
									<div class="col-sm-8">
										<form:input type="date" path="krajPretplate"
											id="krajPretplateId" class="form-control" />
										<div>
											<form:errors path="krajPretplate" cssClass="alert-danger" />
										</div>
									</div>
								</div>
								<button id="save" class="btn btn-primary">Sacuvaj</button>
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>