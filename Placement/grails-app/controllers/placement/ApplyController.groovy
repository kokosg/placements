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

   def application1 = new Application(status:status,student: student, placement: jobTitle, timestamp: 'test' )

   if (application1.save() ) {
     log.debug("OK");
   }
   else {
      log.debug("Error");
   }
 }

}
