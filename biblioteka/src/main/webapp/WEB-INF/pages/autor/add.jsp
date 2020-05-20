<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj autora</title>
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

	<div class="container">
		<div class="row">
			<div class="col-md-7 offset-3">
				<br>
				<div class="card mb-4">
					<div class="card-body">
						<h2 class="card-title">dodaj autora</h2>

						<form:form class="form-horizontal"
							action="${pageContext.request.contextPath}/autor/save"
							method="post" modelAttribute="autorDto">
							<fieldset>
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
									<form:label class="col-sm-3 col-form-label" path="prezime">Prezime</form:label>
									<div class="col-sm-8">
										<form:input type="text" path="prezime" class="form-control"
											id="prezimeId" />
										<div>
											<form:errors path="prezime" cssClass="alert-danger" />
										</div>
									</div>
								</div>
								<div class="form-group row">
									<form:label path="knjizevnaVrsta"
										class="col-sm-3 col-form-label">Knjizevna Vrsta</form:label>
									<div class="col-sm-8">
										<form:select path="knjizevnaVrsta" class="form-control">
											<form:option value="" label="Izaberi knjizevnu vrstu"></form:option>
											<form:options items="${knjizevneVrste}" itemValue="vrsta"
												itemLabel="vrsta" />
										</form:select>
										<div>
											<form:errors path="knjizevnaVrsta" cssClass="alert-danger" />
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