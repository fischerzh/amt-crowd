<%@ page import="amtcrowd.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'batchesCompleted', 'error')} required">
	<label for="batchesCompleted">
		<g:message code="user.batchesCompleted.label" default="Batches Completed" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="batchesCompleted" type="number" value="${userInstance.batchesCompleted}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'hit', 'error')} required">
	<label for="hit">
		<g:message code="user.hit.label" default="Hit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="hit" name="hit.id" from="${amtcrowd.HIT.list()}" optionKey="id" required="" value="${userInstance?.hit?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastHitRegister', 'error')} required">
	<label for="lastHitRegister">
		<g:message code="user.lastHitRegister.label" default="Last Hit Register" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="lastHitRegister" precision="day"  value="${userInstance?.lastHitRegister}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'mail', 'error')} ">
	<label for="mail">
		<g:message code="user.mail.label" default="Mail" />
		
	</label>
	<g:textField name="mail" value="${userInstance?.mail}"/>
</div>

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

