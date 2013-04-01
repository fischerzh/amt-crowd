<%@ page import="amtcrowd.Tasks" %>



<div class="fieldcontain ${hasErrors(bean: tasksInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="tasks.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${tasksInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tasksInstance, field: 'hits', 'error')} ">
	<label for="hits">
		<g:message code="tasks.hits.label" default="Hits" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${tasksInstance?.hits?}" var="h">
    <li><g:link controller="HIT" action="show" id="${h.id}">${h?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="HIT" action="create" params="['tasks.id': tasksInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'HIT.label', default: 'HIT')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: tasksInstance, field: 'assignment', 'error')} ">
	<label for="assignment">
		<g:message code="tasks.assignment.label" default="Assignment" />
		
	</label>
	<g:textField name="assignment" value="${tasksInstance?.assignment}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tasksInstance, field: 'level', 'error')} required">
	<label for="level">
		<g:message code="tasks.level.label" default="Level" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="level" type="number" value="${tasksInstance.level}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: tasksInstance, field: 'result', 'error')} ">
	<label for="result">
		<g:message code="tasks.result.label" default="Result" />
		
	</label>
	<g:textField name="result" value="${tasksInstance?.result}"/>
</div>

