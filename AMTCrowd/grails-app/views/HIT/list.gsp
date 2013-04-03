
<%@ page import="amtcrowd.HIT" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'HIT.label', default: 'HIT')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-HIT" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-HIT" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
										
						<g:sortableColumn property="hitID" title="${message(code: 'HIT.hitID.label', default: 'Hit ID')}" />
					
						<g:sortableColumn property="hitTypeID" title="${message(code: 'HIT.hitTypeID.label', default: 'Hit Type ID')}" />
					
						<g:sortableColumn property="batchCompleted" title="${message(code: 'HIT.batchCompleted.label', default: 'Batch Completed')}" />
					
						<g:sortableColumn property="uniqueTokenGeneratedID" title="${message(code: 'HIT.uniqueTokenGeneratedID.label', default: 'Unique Token Generated ID')}" />
					
						<g:sortableColumn property="uniqueTokenEnteredID" title="${message(code: 'HIT.uniqueTokenEnteredID.label', default: 'Unique Token Entered ID')}" />
					
						<g:sortableColumn property="user" title="${message(code: 'HIT.user.label', default: 'User')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${HITInstanceList}" status="i" var="HITInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
										
						<td><g:link action="show" id="${HITInstance.id}">${fieldValue(bean: HITInstance, field: "id")}</g:link></td>
					
						<td>${fieldValue(bean: HITInstance, field: "hitTypeID")}</td>
					
						<td><g:formatBoolean boolean="${HITInstance.batchCompleted}" /></td>
					
						<td>${fieldValue(bean: HITInstance, field: "uniqueTokenGeneratedID")}</td>
					
						<td>${fieldValue(bean: HITInstance, field: "uniqueTokenEnteredID")}</td>
					
						<td>${fieldValue(bean: HITInstance.user, field: "username")}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${HITInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
