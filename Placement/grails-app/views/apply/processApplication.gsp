<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'status.label', default: 'Status')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-status" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

<li class="controller"><g:link controller="Apply">Apply</g:link></li>

<li class="controller"><g:link controller="PlacementOpportunity">PlacementOpportunity</g:link></li>

<li class="controller"><g:link controller="Status">Status</g:link></li>

<li class="controller"><g:link controller="Student">Student</g:link></li>
			</ul>
		</div>
		<p></p>

			</div>
		</div>
	</body>
</html>
