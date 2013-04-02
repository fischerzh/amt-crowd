
<%@ page import="amtcrowd.Ranking" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ranking.label', default: 'Ranking')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-ranking" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-ranking" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="level" title="${message(code: 'ranking.level.label', default: 'Level')}" />
						<g:sortableColumn property="position" title="${message(code: 'ranking.position.label', default: 'Position')}" />
						<g:sortableColumn property="users" title="${message(code: 'ranking.position.label', default: 'User')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${rankingInstanceList}" status="i" var="rankingInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${rankingInstance.id}">${fieldValue(bean: rankingInstance, field: "level")}</g:link></td>
						<td>${fieldValue(bean: rankingInstanceList, field: "position")}</td>
						<td>${fieldValue(bean: rankingInstanceList, field: "users")}</td>
						
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${rankingInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
