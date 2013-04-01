<%@ page import="amtcrowd.Ranking" %>



<div class="fieldcontain ${hasErrors(bean: rankingInstance, field: 'level', 'error')} required">
	<label for="level">
		<g:message code="ranking.level.label" default="Level" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="level" type="number" value="${rankingInstance.level}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: rankingInstance, field: 'users', 'error')} ">
	<label for="users">
		<g:message code="ranking.users.label" default="Users" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${rankingInstance?.users?}" var="u">
    <li><g:link controller="user" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="user" action="create" params="['ranking.id': rankingInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'user.label', default: 'User')])}</g:link>
</li>
</ul>

</div>

