package placement

import grails.converters.*

class ApplyController {

 def index() {
 }

 def processApplication() {
   log.debug("student id = \"${params.studentid}\"")
   log.debug("jobTitle = \"${params.jobTitle}\"")
   def student = Student.findByName(params.studentid)
   def jobTitle = PlacementOpportunity.findByJobTitle(params.jobTitle)
   log.debug("located student: ${student}")
   log.debug(jobTitle)
   def status = Status.findByCode('Applied')

   log.debug(status)

   def application1 = new Application(status:status,student: student, placement: jobTitle, timestamp: 'hello' )

   if (application1.save() ) {
     log.debug("OK");
   }
   else {
      log.debug("Error");
   }
 }

def listOpenPlacements() {
  log.debug("listOpenPlacements() - ${params.format}");
    def placements = PlacementOpportunity.findAllByStatus('Open')
  log.debug("Located placements: ${placements}");
    
        withFormat{
            xml { render placements as XML  }
            json { render placements as JSON }
        }
}

def listApplicants() {
       def jobTitle = PlacementOpportunity.findByJobTitle(params.jobTitle)
       log.debug("jobTitle..: ${jobTitle} ${jobTitle.applications}");
       def r = []
       jobTitle.applications.each { app ->
          log.debug("jobTitle...: ${app}");
          r.add([applicantid:app.student.id])
       }

        log.debug("returning ${r}");

        withFormat{
            xml { render r as XML  }
            json { render r as JSON }
        }
}

}
