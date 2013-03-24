
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
					
						<g:sortableColumn property="batchCompleted" title="${message(code: 'HIT.batchCompleted.label', default: 'Batch Completed')}" />
					
						<g:sortableColumn property="batchID" title="${message(code: 'HIT.batchID.label', default: 'Batch ID')}" />
					
						<g:sortableColumn property="hitID" title="${message(code: 'HIT.hitID.label', default: 'Hit ID')}" />
					
						<g:sortableColumn property="hitTypeID" title="${message(code: 'HIT.hitTypeID.label', default: 'Hit Type ID')}" />
					
						<g:sortableColumn property="hitsCompleted" title="${message(code: 'HIT.hitsCompleted.label', default: 'Hits Completed')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${HITInstanceList}" status="i" var="HITInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${HITInstance.id}">${fieldValue(bean: HITInstance, field: "batchCompleted")}</g:link></td>
					
						<td>${fieldValue(bean: HITInstance, field: "batchID")}</td>
					
						<td>${fieldValue(bean: HITInstance, field: "hitID")}</td>
					
						<td>${fieldValue(bean: HITInstance, field: "hitTypeID")}</td>
					
						<td>${fieldValue(bean: HITInstance, field: "hitsCompleted")}</td>
					
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
