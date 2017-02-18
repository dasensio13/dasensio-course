<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<body>
	<h1>Atendees</h1>
	<ul>
		<c:forEach items="${atendees}" var="at">
			<li>${at.name} ${at.lastname} (${at.company})</li>
		</c:forEach>
	</ul>
	<c:if test="${empty atendees}">
		<p>No atendees found<p>
	</c:if>
	<h1>Form</h1>
	<form:form method="post" modelAttribute="atendeeForm">
		<p>
		<label for="name">Name:</label>
		<form:input path="name" type="text" id="name" placeholder="Name" />
		</p>
		<p>
		<label for="lastname">Last Name:</label>
		<form:input path="lastname" type="text" id="lastname" placeholder="Last Name" />
		</p>
		<p>
		<label for="company">company:</label>
		<form:input path="company" type="text" id="company" placeholder="company" />
		</p>
		<input type="submit" />
	</form:form>
</body>

</html>