<%@ page import="amtcrowd.HIT" %>



<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'batchCompleted', 'error')} ">
	<label for="batchCompleted">
		<g:message code="HIT.batchCompleted.label" default="Batch Completed" />
		
	</label>
	<g:checkBox name="batchCompleted" value="${HITInstance?.batchCompleted}" />
</div>

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

<div class="fieldcontain ${hasErrors(bean: HITInstance, field: 'hitsCompleted', 'error')} required">
	<label for="hitsCompleted">
		<g:message code="HIT.hitsCompleted.label" default="Hits Completed" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="hitsCompleted" type="number" value="${HITInstance.hitsCompleted}" required=""/>
</div>

