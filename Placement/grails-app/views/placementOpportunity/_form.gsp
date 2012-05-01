<%@ page import="placement.PlacementOpportunity" %>



<div class="fieldcontain ${hasErrors(bean: placementOpportunityInstance, field: 'companyName', 'error')} ">
	<label for="companyName">
		<g:message code="placementOpportunity.companyName.label" default="Company Name" />
		
	</label>
	<g:textField name="companyName" value="${placementOpportunityInstance?.companyName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementOpportunityInstance, field: 'jobTitle', 'error')} ">
	<label for="jobTitle">
		<g:message code="placementOpportunity.jobTitle.label" default="Job Title" />
		
	</label>
	<g:textField name="jobTitle" value="${placementOpportunityInstance?.jobTitle}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementOpportunityInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="placementOpportunity.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${placementOpportunityInstance?.status}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementOpportunityInstance, field: 'applications', 'error')} ">
	<label for="applications">
		<g:message code="placementOpportunity.applications.label" default="Applications" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${placementOpportunityInstance?.applications?}" var="a">
    <li><g:link controller="application" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="application" action="create" params="['placementOpportunity.id': placementOpportunityInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'application.label', default: 'Application')])}</g:link>
</li>
</ul>

</div>

