<%@ page import="amtcrowd.User"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'user.label', default: 'User')}" />
<title></title>
</head>
<body>
	<g:if test="${flash.message}">
		<div class="message" role="status">
			${flash.message}
		</div>

	</g:if>
	<div>
		<p>
			<label for="RandomChar"> <g:message
					code="user.username.label" default="Username:" /> ${ userInstance.username }
		</p>
		<p>
			<label for="UniqueID"> <g:message
					code="user.UniqueToken.label" default="Unique Token:" /> ${ userInstance.hits.uniqueTokenGeneratedID }
		</p>
		<%--		<p>--%>
		<%--			<label for="ScrabbleChars">	${randomString }	--%>
		<%--		--%>
		<%--		</p>--%>
		<p>
			<label for="TaskForUserDescription"> <g:message
					code="user.description.label" default="Task Description:" />
				${taskForUser.description }
		</p>
		<p>
			<label for="TaskForUser"> <g:message
					code="user.taskForUser.label" default="Task:" /> ${taskForUser.assignment }
		</p>

	</div>

</body>