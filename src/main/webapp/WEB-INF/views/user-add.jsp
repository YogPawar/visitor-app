<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function() {
		$("h1").html("Hello, World!");
		alert("Hello, world!");

		$("#clear").click(function() {
			$("#user-form input[type='text']").val("");
			$("#user-form textarea").val("");
			$("#user-form select").val("0");
			return false;

		});

	});
</script>
</head>
<body style="background-color: #E9F7F6">
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<div align="center">
				<font color="Red" size="15px"> <b>Register User </b>
				</font>
			</div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link" href="#">Menu
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/visitors/user/add">User</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/visitors/user/list">List</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/visitors/member/add">Member</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/visitors/member/list">List</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/visitors/visit/add">Visitor</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/visitors/visit/list">List</a></li>
						<li class="nav-item"><a class="nav-link" href="/visitors/"
							tabindex="-1" aria-disabled="true">Logout</a></li>
					</ul>
				</div>
			</nav>
			<div class="panel panel-info">
				<div class="form-group">
					<form:form action="save" cssClass="form-horizontal" method="post"
						modelAttribute="user" id="user-form">

						<!-- need to associate this data with customer id -->
						<form:hidden path="userId" />

						<div class="form-group">
							<label for="firstname" class="col-md-3 control-label">First
								Name</label>
							<div class="col-md-9">
								<form:input path="firstName" cssClass="form-control"
									required="required" />
							</div>
							<div class="col-md-9">
								<form:errors path="firstName" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">Last
								Name</label>
							<div class="col-md-9">
								<form:input path="lastName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="contatNumber" class="col-md-3 control-label">Contact
								Number </label>
							<div class="col-md-9">
								<form:input path="contatNumber" cssClass="form-control" />
							</div>
							<div class="col-md-9">
								<form:errors path="contatNumber" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<label for="userName" class="col-md-3 control-label">User
								Name</label>
							<div class="col-md-9">
								<form:input path="userName" cssClass="form-control"
									required="required" />
							</div>
							<div class="col-md-9">
								<form:errors path="userName" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password
							</label>
							<div class="col-md-9">
								<form:password path="password" cssClass="form-control"
									required="required" />
							</div>
						</div>
						<div class="col-md-9">
							<form:errors path="password" cssClass="text-danger" />
						</div>
				</div>

				<div class="form-group">
					<label for="email" class="col-md-3 control-label">Email</label>
					<div class="col-md-9">
						<form:input path="email" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group">
					<!-- Button -->
					<div class="col-md-offset-3 col-md-9">
						<form:button class="btn btn-success">Submit</form:button>
						<input type="reset" value="Clear"
							class="btn btn-default btn-primary" id="clear">
					</div>
				</form:form>
			</div>
		</div>
	</div>
	</div>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>