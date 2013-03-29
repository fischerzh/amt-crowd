
<%@ page import="amtcrowd.User" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-user" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="workerID" title="${message(code: 'user.workerID.label', default: 'Worker ID')}" />
					
						<g:sortableColumn property="batchesCompleted" title="${message(code: 'user.batchesCompleted.label', default: 'Batches Completed')}" />
					
						<g:sortableColumn property="lastHitRegister" title="${message(code: 'user.lastHitRegister.label', default: 'Last Hit Register')}" />
					
						<g:sortableColumn property="username" title="${message(code: 'user.username.label', default: 'Username')}" />
					
						<g:sortableColumn property="hitsCompleted" title="${message(code: 'user.hitsCompleted.label', default: 'Hits Completed')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'user.password.label', default: 'Password')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "workerID")}</g:link></td>
					
						<td>${fieldValue(bean: userInstance, field: "batchesCompleted")}</td>
					
						<td><g:formatDate date="${userInstance.lastHitRegister}" /></td>
					
						<td>${fieldValue(bean: userInstance, field: "username")}</td>
					
						<td>${fieldValue(bean: userInstance, field: "hitsCompleted")}</td>
					
						<td>${fieldValue(bean: userInstance, field: "password")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userInstanceTotal}" />
			</div>
		</div>
	</body>
</html>