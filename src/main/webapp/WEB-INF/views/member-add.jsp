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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#clear").click(function() {
			$("#user-form input[type='text']").val("");
			$("#user-form textarea").val("");
			$("#user-form select").val("0");
			return false;

		});

		$("#fileToUpload").change(function() {
			display(this);
		});

	});
	function display(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(event) {
				$('#myid').attr('src', event.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
</head>
<body style="background-color: #E9F7F6">
	<div class="container">
		<div align="center">
			<font color="Green" size="15px"> <b>Register Member</b>
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
					<li class="nav-item active"><a class="nav-link"
						href="/visitors/menu">Menu <span class="sr-only">(current)</span>
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
					modelAttribute="member" id="member-form"
					enctype="multipart/form-data">

					<!-- need to associate this data with customer id -->
					<form:hidden path="memberId" />

					<div class="form-group">
						<label for="firstName" class="col-md-3 control-label">First
							Name</label>
						<div class="col-md-9">
							<form:input path="firstName" cssClass="form-control"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-md-3 control-label">Last
							Name</label>
						<div class="col-md-9">
							<form:input path="lastName" cssClass="form-control"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="roomNo" class="col-md-3 control-label">Room
							Number </label>
						<div class="col-md-9">
							<form:input path="roomNo" cssClass="form-control"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="wing" class="col-md-3 control-label">Wing </label>
						<div class="col-md-9">
							<form:input path="wing" cssClass="form-control"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="floor" class="col-md-3 control-label">Floor </label>
						<div class="col-md-9">
							<form:input path="floor" cssClass="form-control"
								required="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="isOwner" class="col-md-3 control-label">Is
							Owner</label>
						<div class="col-md-9">
							<form:checkbox path="owner" cssClass="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label for="isOwner" class="col-md-3 control-label">Upload
							Photo</label>
						<div class="col-md-9">
							<input name="file" id="fileToUpload" type="file"
								title="select photo" /> <img id="myid" src="#"
								alt="preview photo" width="125" height="125" />
						</div>
					</div>




					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<form:button class="btn btn-success">Register</form:button>
							<input type="reset" value="Clear"
								class="btn btn-default btn-primary" id="clear">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<script src="<c:url value="/resources/js/jquery-min.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>