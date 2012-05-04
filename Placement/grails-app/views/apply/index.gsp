<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to placment application</title>
		
	</head>
	<body>
<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

<li class="controller"><g:link controller="PlacementOpportunity">PlacementOpportunity</g:link></li>


<li class="controller"><g:link controller="Status">Status</g:link></li>


<li class="controller"><g:link controller="Student">Student</g:link></li>

<br>
<br>
Apply.index
</br>
<g:form name="Apply" action="processApplication" method="get">
StudentID <input type = "text" name = "studentid"/> example: George Georgiou<br/>
JobID <input type = "text" name = "jobTitle"/> example: Network Administrator<br/>
<input type = "submit"/>
</br>
</g:form>
<br>*Input data must be with out spaces</br>





	</body>
</html>
