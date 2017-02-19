<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
	<link rel="stylesheet"
		href="https://unpkg.com/purecss@0.6.2/build/pure-min.css"
		integrity="sha384-UQiGfs9ICog+LwheBSRCt1o5cbyKIHbwjWscjemyBMT9YCUMZffs6UqUTd0hObXD"
		crossorigin="anonymous">

	<link rel="stylesheet" href="course.css">
</head>

<body>
	<div class="header">
		<div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
			<a class="pure-menu-heading" href="#">Course Attendees</a>
			<ul class="pure-menu-list">
				<li class="pure-menu-item"><a href="docs/api.html" class="pure-menu-link" target="_blank">API</a></li>
	            <li class="pure-menu-item"><a href="logout" class="pure-menu-link">Logout</a></li>
	        </ul>
		</div>
	</div>

	<div class="content-wrapper">
		<div class="content">
			<h1 class="content-head is-center">Attendees list</h1>

			<c:if test="${not empty attendees}">
				<div class="pure-g">
					<div class="pure-u-1">
						<table class="pure-table pure-table-horizontal pure-table-striped">
							<thead>
								<tr>
									<th>#</th>
									<th>Name</th>
									<th>Last Name</th>
									<th>Company</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${attendees}" var="at">
									<tr>
										<td>${at.id}</td>
										<td>${at.name}</td>
										<td>${at.lastname}</td>
										<td>${at.company}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>

			<c:if test="${empty attendees}">
				<div class="pure-g">
					<div class="pure-u-1">
						<h3>No attendees found</h3>
					</div>
				</div>
			</c:if>
		</div>
		<div class="content">
			<h1 class="content-head is-center">Register new attendee</h1>

			<div class="pure-g">
				<div class="pure-u-1">
					<form:form method="post" modelAttribute="attendeeForm"
						cssClass="pure-form pure-form-aligned">
						<fieldset>
							<div class="pure-control-group">
								<form:errors />
							</div>
							<div class="pure-control-group">
								<label for="name">Name:</label>
								<form:input path="name" type="text" id="name"
									placeholder="Name" cssClass="pure-input-1-4" />
								<span class="pure-form-message-inline">Required field</span>
							</div>
							<div class="pure-control-group">
								<label for="lastname">Last Name:</label>
								<form:input path="lastname" type="text" id="lastname"
									placeholder="Last Name" cssClass="pure-input-1-4" />
							</div>
							<div class="pure-control-group">
								<label for="company">Company:</label>
								<form:input path="company" type="text" id="company"
									placeholder="Company" cssClass="pure-input-1-4" />
							</div>
							<div class="pure-controls">
								<button type="submit" class="pure-button pure-button-primary">Register</button>
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>
		</div>
		<div class="footer l-box is-center">
			Course attendee sample by David Asensio
		</div>
	</div>
</body>

</html>