<%@ page import="amtcrowd.User" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title></title>
	</head>
	<body>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			
			</g:if>
		
		
</body>