
<%@ page import="amtcrowd.HIT" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'HIT.label', default: 'HIT')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-HIT" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-HIT" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list HIT">
			
				<g:if test="${HITInstance?.batchID}">
				<li class="fieldcontain">
					<span id="batchID-label" class="property-label"><g:message code="HIT.batchID.label" default="Batch ID" /></span>
					
						<span class="property-value" aria-labelledby="batchID-label"><g:fieldValue bean="${HITInstance}" field="batchID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${HITInstance?.hitID}">
				<li class="fieldcontain">
					<span id="hitID-label" class="property-label"><g:message code="HIT.hitID.label" default="Hit ID" /></span>
					
						<span class="property-value" aria-labelledby="hitID-label"><g:fieldValue bean="${HITInstance}" field="hitID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${HITInstance?.hitTypeID}">
				<li class="fieldcontain">
					<span id="hitTypeID-label" class="property-label"><g:message code="HIT.hitTypeID.label" default="Hit Type ID" /></span>
					
						<span class="property-value" aria-labelledby="hitTypeID-label"><g:fieldValue bean="${HITInstance}" field="hitTypeID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${HITInstance?.batchCompleted}">
				<li class="fieldcontain">
					<span id="batchCompleted-label" class="property-label"><g:message code="HIT.batchCompleted.label" default="Batch Completed" /></span>
					
						<span class="property-value" aria-labelledby="batchCompleted-label"><g:formatBoolean boolean="${HITInstance?.batchCompleted}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${HITInstance?.uniqueTokenGeneratedID}">
				<li class="fieldcontain">
					<span id="uniqueTokenGeneratedID-label" class="property-label"><g:message code="HIT.uniqueTokenGeneratedID.label" default="Unique Token Generated ID" /></span>
					
						<span class="property-value" aria-labelledby="uniqueTokenGeneratedID-label"><g:fieldValue bean="${HITInstance}" field="uniqueTokenGeneratedID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${HITInstance?.uniqueTokenEnteredID}">
				<li class="fieldcontain">
					<span id="uniqueTokenEnteredID-label" class="property-label"><g:message code="HIT.uniqueTokenEnteredID.label" default="Unique Token Entered ID" /></span>
					
						<span class="property-value" aria-labelledby="uniqueTokenEnteredID-label"><g:fieldValue bean="${HITInstance}" field="uniqueTokenEnteredID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${HITInstance?.startTime}">
				<li class="fieldcontain">
					<span id="startTime-label" class="property-label"><g:message code="HIT.startTime.label" default="Start Time" /></span>
					
						<span class="property-value" aria-labelledby="startTime-label"><g:formatDate date="${HITInstance?.startTime}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${HITInstance?.endTime}">
				<li class="fieldcontain">
					<span id="endTime-label" class="property-label"><g:message code="HIT.endTime.label" default="End Time" /></span>
					
						<span class="property-value" aria-labelledby="endTime-label"><g:formatDate date="${HITInstance?.endTime}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${HITInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="HIT.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${HITInstance?.user?.id}">${HITInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${HITInstance?.id}" />
					<g:link class="edit" action="edit" id="${HITInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
