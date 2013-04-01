<%@ page import="amtcrowd.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} ">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		
	</label>
	<g:textField name="username" value="${userInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'workerID', 'error')} ">
	<label for="workerID">
		<g:message code="user.workerID.label" default="Worker ID" />
		
	</label>
	<g:textField name="workerID" value="${userInstance?.workerID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'batchesCompleted', 'error')} ">
	<label for="batchesCompleted">
		<g:message code="user.batchesCompleted.label" default="Batches Completed" />
		
	</label>
	<g:field name="batchesCompleted" type="number" value="${userInstance.batchesCompleted}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastHitRegister', 'error')} ">
	<label for="lastHitRegister">
		<g:message code="user.lastHitRegister.label" default="Last Hit Register" />
		
	</label>
	<g:datePicker name="lastHitRegister" precision="day"  value="${userInstance?.lastHitRegister}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'hits', 'error')} ">
	<label for="hits">
		<g:message code="user.hits.label" default="Hits" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.hits?}" var="h">
    <li><g:link controller="HIT" action="show" id="${h.id}">${h?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="HIT" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'HIT.label', default: 'HIT')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'hitsCompleted', 'error')} ">
	<label for="hitsCompleted">
		<g:message code="user.hitsCompleted.label" default="Hits Completed" />
		
	</label>
	<g:field name="hitsCompleted" type="number" value="${userInstance.hitsCompleted}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'level', 'error')} ">
	<label for="level">
		<g:message code="user.level.label" default="Level" />
		
	</label>
	<g:field name="level" type="number" value="${userInstance.level}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'ranking', 'error')} ">
	<label for="ranking">
		<g:message code="user.ranking.label" default="Ranking" />
		
	</label>
	<g:select id="ranking" name="ranking.id" from="${amtcrowd.Ranking.list()}" optionKey="id" value="${userInstance?.ranking?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		
	</label>
	<g:textField name="password" value="${userInstance?.password}"/>
</div>

