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
			<a class="pure-menu-heading" href="attendee">Course Attendees</a>
			<ul class="pure-menu-list">
				<li class="pure-menu-item"><a href="docs/api.html" class="pure-menu-link" target="_blank">API</a></li>
	        </ul>
		</div>
	</div>

	<div class="content-wrapper">
		<div class="content">
			<h1 class="content-head is-center">Login form</h1>

			<div class="pure-g">
				<div class="pure-u-1">
					<form method="post" action="login" class="pure-form pure-form-aligned">
						<fieldset>
							<c:if test="${message ne null}">
								<div class="pure-control-group">
									<p class="alert ${messageClass}">    
				                    	${message}
				                    </p>
				               	</div>
			                </c:if>
							<div class="pure-control-group">
								<label for="username">Username:</label>
								<input type="text" id="username" name="username" placeholder="Username" class="pure-input-1-4" />
							</div>
							<div class="pure-control-group">
								<label for="password">Password:</label>
								<input type="password" id="password" name="password" placeholder="Password" class="pure-input-1-4" />
							</div>
							<div class="pure-controls">
								<button type="submit" class="pure-button pure-button-primary">Login</button>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>

		<div class="footer l-box is-center">
			Course attendee sample by David Asensio
		</div>
	</div>
</body>

</html>