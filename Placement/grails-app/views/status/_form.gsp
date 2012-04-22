<%@ page import="placement.Status" %>





<div class="fieldcontain ${hasErrors(bean: statusInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="status.code.label" default="Code" />
		
	</label>
	<g:textField name="code" value="${statusInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statusInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="status.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${statusInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statusInstance, field: 'applications', 'error')} ">
	<label for="applications">
		<g:message code="status.applications.label" default="Applications" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${statusInstance?.applications?}" var="a">
    <li><g:link controller="application" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="application" action="create" params="['status.id': statusInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'application.label', default: 'Application')])}</g:link>
</li>
</ul>

</div>
