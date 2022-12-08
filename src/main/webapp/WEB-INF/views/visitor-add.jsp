<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visitor Registration Form</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<style type="text/css">
.container {
	margin-right: auto;
	margin-left: auto;
}
</style>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#clear").click(function() {
			$("#visitor-form input[type='text']").val("");
			$("#visitor-form textarea").val("");
			$("#visitor-form select").val("0");
			return false;

		});

		$('#mem').change(function() {
			// Call submit() method on <form id='myform'>
			$('#visitor-frm').submit();
		});

	});
</script>
</head>
<body style="background-color: #E9F7F6">
	<div align="center">
		<font color="Purple" size="15px"> <b>Register Visitor</b>
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

	<form:form action="save" cssClass="form-horizontal" method="post"
		modelAttribute="visitor" id="visitor-form">

		<form:hidden path="visitorId" />

		<table class="table table-striped container" id="memTable">
			<tr>

				<td><form:label path="resident">Are you a Resident ? </form:label></td>
				<td colspan="2"><form:radiobutton path="resident" value="Yes"
						label="Yes" id="radio" /> <form:radiobutton path="resident"
						value="No" label="No" /></td>
			</tr>
			<tr>
				<td align="left"><label for="name">Name </label></td>
				<td><form:input path="name" cssClass="form-control"
						required="required" /></td>
				<td><label for="purpose">Purpose to Visit</label></td>
				<td><form:textarea path="purpose" cssClass="form-control" /></td>
			</tr>
			<tr>
				<td><label for="inTime">In Time </label></td>
				<td><form:input path="inTime" cssClass="form-control"
						required="required" placeholder="hh:mm am/pm" /></td>
				<td><label for="outTime">Out Time </label></td>
				<td><form:input path="outTime" cssClass="form-control"
						placeholder="hh:mm am/pm" /></td>
				<td><label for="visitDate">Visit Date </label></td>
				<td><form:input path="visitDate" cssClass="form-control"
						required="required" placeholder="dd-mm-yyyy" /></td>
			</tr>
			<tr>
				<td><label for="roomNo">Room No </label></td>
				<td><form:input path="roomNo" cssClass="form-control" /></td>
				<td><label for="floor">Floor No </label></td>
				<td><form:input path="floor" cssClass="form-control" /></td>

				<td><label for="contatNumber">Contact Number </label></td>
				<td><form:input path="contatNumber" cssClass="form-control"
						required="required" /></td>

			</tr>
			<tr>
				<td><label for="wing">Wing</label></td>
				<td><form:input path="wing" cssClass="form-control" /></td>
				<td><label for="wing">Owner name</label></td>
				<td><form:select path="memberId" cssClass="form-control"
						class="member" id="mem">
						<form:option value="0">Select Owner Name</form:option>
						<c:forEach items="${visitor.memberList}" var="convention">
							<form:option value="${convention.memberId}" path="memberId">${convention.firstName} ${convention.lastName}</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><form:button class="btn btn-success">Visit</form:button></td>
				<td colspan="2"><input type="reset" value="Clear"
					class="btn btn-default btn-primary" id="clear"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>