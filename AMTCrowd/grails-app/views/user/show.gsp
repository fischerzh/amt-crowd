
<%@ page import="amtcrowd.User" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list user">
			
				<g:if test="${userInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="user.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${userInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.workerID}">
				<li class="fieldcontain">
					<span id="workerID-label" class="property-label"><g:message code="user.workerID.label" default="Worker ID" /></span>
					
						<span class="property-value" aria-labelledby="workerID-label"><g:fieldValue bean="${userInstance}" field="workerID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.batchesCompleted}">
				<li class="fieldcontain">
					<span id="batchesCompleted-label" class="property-label"><g:message code="user.batchesCompleted.label" default="Batches Completed" /></span>
					
						<span class="property-value" aria-labelledby="batchesCompleted-label"><g:fieldValue bean="${userInstance}" field="batchesCompleted"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.lastHitRegister}">
				<li class="fieldcontain">
					<span id="lastHitRegister-label" class="property-label"><g:message code="user.lastHitRegister.label" default="Last Hit Register" /></span>
					
						<span class="property-value" aria-labelledby="lastHitRegister-label"><g:formatDate date="${userInstance?.lastHitRegister}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.hits}">
				<li class="fieldcontain">
					<span id="hits-label" class="property-label"><g:message code="user.hits.label" default="Hits" /></span>
					
						<g:each in="${userInstance.hits}" var="h">
						<span class="property-value" aria-labelledby="hits-label"><g:link controller="HIT" action="show" id="${h.id}">${h?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.hitsCompleted}">
				<li class="fieldcontain">
					<span id="hitsCompleted-label" class="property-label"><g:message code="user.hitsCompleted.label" default="Hits Completed" /></span>
					
						<span class="property-value" aria-labelledby="hitsCompleted-label"><g:fieldValue bean="${userInstance}" field="hitsCompleted"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.level}">
				<li class="fieldcontain">
					<span id="level-label" class="property-label"><g:message code="user.level.label" default="Level" /></span>
					
						<span class="property-value" aria-labelledby="level-label"><g:fieldValue bean="${userInstance}" field="level"/></span>
					
				</li>
				</g:if>
			
			
				<g:if test="${userInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="user.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${userInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${userInstance?.id}" />
					<g:link class="edit" action="edit" id="${userInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
