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
				<g:sortableColumn property="userName" title="${message(code: 'ranking.user.label', default: 'User')}" />
				<g:sortableColumn property="position" title="${message(code: 'ranking.position.label', default: 'Overall Rank')}" />
				<g:sortableColumn property="Points" title="${message(code: 'ranking.Points.label', default: 'Points')}" />
				<th></th>
			</tr>
		</thead>
		<tbody>
		<g:each in="${rankingInstanceList}" status="i" var="user">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">					
				<td>${user.username}</td>
				<td>${user.rankingPosition}</td>
				<td>${user.totalPoints}</td>
				<td>
				<g:if test="${user.level == 1}">
					<img src="${resource(dir: 'images', file: 'silver_medal.png')}" alt="Grails" height="50pt" width="50pt" />
					Silver ${user.level}
				</g:if>
				<g:else>
					<img src="${resource(dir: 'images', file: 'gold_medal.png')}" alt="Grails" height="50pt" width="50pt" />
					Gold ${user.level}
				</g:else>
				</td>
			</tr>
		</g:each>
		</tbody>
	</table>

</body>