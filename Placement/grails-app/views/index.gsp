<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<div id="page-body" role="main">
			<h1>Welcome to placement application</h1>
			<p></p>
                        <p>This is a web placement application which allows students to check the available jobs, the status and the company name. Students have the chance to apply for the available jobs. In addition, student can check out the Student list and status list which shows further information for each status. Some new features for that application is the very nice a quick navigation between the controller and the availability which application provide between listApplicants and List of Open placements in JSON and XML format.</p>
			<div id="controller-list" role="navigation">
				<h2>Available Controllers</h2>
				<ul>
					<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
					</g:each>
				</ul>
<h2>Available Methods (JSON and XML format)</h2>
					<li class="controller"><g:link controller="PlacementOpportunity" action="listOpenPlacements.json">ListOpenPlacements in JSON</g:link></li>
					<li class="controller"><g:link controller="PlacementOpportunity" action="listOpenPlacements.xml">ListOpenPlacements in XML</g:link></li>
					<li class="controller"><g:link controller="PlacementOpportunity" action="listApplicants.json">listApplicants in JSON</g:link></li>
					<li class="controller"><g:link controller="PlacementOpportunity" action="listApplicants.xml">listApplicants in XML</g:link></li>


			</div>
		</div>
	</body>
</html>
