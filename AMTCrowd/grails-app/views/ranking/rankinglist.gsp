<%@ page import="amtcrowd.User"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'ranking.label', default: 'Ranking')}" />
<title></title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<g:sortableColumn property="position" title="${message(code: 'ranking.position.label', default: 'Position')}" />
				<g:sortableColumn property="userName" title="${message(code: 'ranking.position.label', default: 'User')}" />
				<g:sortableColumn property="level" title="${message(code: 'ranking.level.label', default: 'Level')}" />
				<g:sortableColumn property="level" title="${message(code: 'ranking.Points.label', default: 'Points')}" />
			</tr>
		</thead>
		<tbody>
		<g:each in="${rankingInstanceList}" status="i" var="user">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">					
				<td>${user.rankingPosition}</td>
				<td>${user.username}</td>
				<td>${user.level}</td>
				<td>${user.totalPoints}</td>
			</tr>
		</g:each>
		</tbody>
	</table>

</body>