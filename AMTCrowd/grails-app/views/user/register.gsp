<%@ page import="amtcrowd.User"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'user.label', default: 'User')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<div id="edit-user" class="content scaffold-edit" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
	
		<g:form method="post">
			<g:hiddenField name="id" value="${userInstance?.id}" />
			<g:hiddenField name="version" value="${userInstance?.version}" />
			<fieldset class="form">

				<div
					class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} ">
					<label for="username"> <g:message
							code="user.username.label" default="Username" />

					</label>
					<g:textField name="username" value="${userInstance?.username}" />
				</div>
				<div
					class="fieldcontain ${hasErrors(bean: userInstance, field: 'hitID', 'error')} ">
					<label for="hitID"> 
					<g:message code="user.hit.label" default="HIT-ID" />

					</label>
					<g:textField name="hitID" value="${hitID}" />
				</div>
			</fieldset>
			<fieldset class="buttons">
				<g:actionSubmit class="save" action="register"
					value="${message(code: 'Register', default: 'Register')}" />
				
			</fieldset>
		</g:form>
	</div>
</body>