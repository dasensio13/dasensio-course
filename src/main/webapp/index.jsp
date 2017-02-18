<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<body>
	<h1>Attendees list</h1>
	<ul>
		<c:forEach items="${attendees}" var="at">
			<li>${at.name} ${at.lastname} (${at.company})</li>
		</c:forEach>
	</ul>
	<c:if test="${empty attendees}">
		<p>No attendees found<p>
	</c:if>
	<h1>Form</h1>
	<form:form method="post" modelAttribute="attendeeForm">
		<form:errors />
		<p>
		<label for="name">Name:</label>
		<form:input path="name" type="text" id="name" placeholder="Name" />
		</p>
		<p>
		<label for="lastname">Last Name:</label>
		<form:input path="lastname" type="text" id="lastname" placeholder="Last Name" />
		</p>
		<p>
		<label for="company">Company:</label>
		<form:input path="company" type="text" id="company" placeholder="company" />
		</p>
		<input type="submit" />
	</form:form>
</body>

</html>