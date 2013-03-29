
<%@ page import="amtcrowd.Tasks" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tasks.label', default: 'Tasks')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tasks" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tasks" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'tasks.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="assignment" title="${message(code: 'tasks.assignment.label', default: 'Assignment')}" />
					
						<g:sortableColumn property="level" title="${message(code: 'tasks.level.label', default: 'Level')}" />
					
						<g:sortableColumn property="result" title="${message(code: 'tasks.result.label', default: 'Result')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tasksInstanceList}" status="i" var="tasksInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tasksInstance.id}">${fieldValue(bean: tasksInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: tasksInstance, field: "assignment")}</td>
					
						<td>${fieldValue(bean: tasksInstance, field: "level")}</td>
					
						<td>${fieldValue(bean: tasksInstance, field: "result")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tasksInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
