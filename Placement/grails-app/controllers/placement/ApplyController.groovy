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

       def application1 = new Application(status:status,student: student, placement: jobTitle ).save()
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
}
