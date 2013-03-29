<%@ page import="amtcrowd.Tasks" %>



<div class="fieldcontain ${hasErrors(bean: tasksInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="tasks.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${tasksInstance?.description}"/>
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

