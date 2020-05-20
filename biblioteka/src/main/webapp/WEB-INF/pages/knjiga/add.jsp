<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj novu knjigu</title>
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
						<h2 class="card-title">dodaj knjigu</h2>

						<form:form class="form-horizontal"
							action="${pageContext.request.contextPath}/knjiga/save"
							method="post" modelAttribute="knjigaDto">
							<fieldset>
								<div class="form-group row">
									<form:label path="naziv" class="col-sm-3 col-form-label">Naziv</form:label>
									<div class="col-sm-8">
										<form:input type="text" class="form-control" path="naziv"
											id="nazivId" />
										<div>
											<form:errors path="naziv" cssClass="alert-danger" />
										</div>
									</div>
								</div>


								<div class="form-group row">
									<form:label path="zanrDto" class="col-sm-3 col-form-label">Zanr</form:label>
									<div class="col-sm-8">
										<form:select path="zanrDto" class="form-control">
											<form:option value="" label="Izaberi zanr"></form:option>
											<form:options items="${zanrovi}" itemValue="id"
												itemLabel="vrsta" />
										</form:select>
										<div>
											<form:errors path="zanrDto" cssClass="alert-danger" />
										</div>
									</div>
								</div>
								<div class="form-group row">
									<form:label path="autorDto" class="col-sm-3 col-form-label">Autor</form:label>
									<div class="col-sm-8">
										<form:select path="autorDto" class="form-control">
											<form:option value="" label="Izaberi autora"></form:option>
											<form:options items="${autors}" itemValue="id"
												itemLabel="imeIPrezime" />
										</form:select>
										<div>
											<form:errors path="autorDto" cssClass="alert-danger" />
										</div>
									</div>
								</div>
								<div class="form-group row">
									<form:label path="brojStrana" class="col-sm-3 col-form-label">Broj stranica</form:label>
									<div class="col-sm-8">
										<form:input type="text" class="form-control" path="brojStrana"
											id="brojStranaId" />
										<div>
											<form:errors path="brojStrana" cssClass="alert-danger" />
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