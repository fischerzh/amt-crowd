<%@ page import="amtcrowd.HIT" %>



<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'batchID', 'error')} ">
	<label for="batchID">
		<g:message code="HIT.batchID.label" default="Batch ID" />
		
	</label>
	<g:textField name="batchID" value="${HITInstance?.batchID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'hitID', 'error')} ">
	<label for="hitID">
		<g:message code="HIT.hitID.label" default="Hit ID" />
		
	</label>
	<g:textField name="hitID" value="${HITInstance?.hitID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'hitTypeID', 'error')} ">
	<label for="hitTypeID">
		<g:message code="HIT.hitTypeID.label" default="Hit Type ID" />
		
	</label>
	<g:textField name="hitTypeID" value="${HITInstance?.hitTypeID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'batchCompleted', 'error')} ">
	<label for="batchCompleted">
		<g:message code="HIT.batchCompleted.label" default="Batch Completed" />
		
	</label>
	<g:checkBox name="batchCompleted" value="${HITInstance?.batchCompleted}" />
</div>

<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'uniqueTokenGeneratedID', 'error')} ">
	<label for="uniqueTokenGeneratedID">
		<g:message code="HIT.uniqueTokenGeneratedID.label" default="Unique Token Generated ID" />
		
	</label>
	<g:textField name="uniqueTokenGeneratedID" value="${HITInstance?.uniqueTokenGeneratedID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'uniqueTokenEnteredID', 'error')} ">
	<label for="uniqueTokenEnteredID">
		<g:message code="HIT.uniqueTokenEnteredID.label" default="Unique Token Entered ID" />
		
	</label>
	<g:textField name="uniqueTokenEnteredID" value="${HITInstance?.uniqueTokenEnteredID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'startTime', 'error')} ">
	<label for="startTime">
		<g:message code="HIT.startTime.label" default="Start Time" />
		
	</label>
	<g:datePicker name="startTime" precision="day"  value="${HITInstance?.startTime}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'endTime', 'error')} ">
	<label for="endTime">
		<g:message code="HIT.endTime.label" default="End Time" />
		
	</label>
	<g:datePicker name="endTime" precision="day"  value="${HITInstance?.endTime}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="HIT.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${amtcrowd.User.list()}" optionKey="id" required="" value="${HITInstance?.user?.id}" class="many-to-one"/>
</div>

