import placement.*
class BootStrap {

    def init = { servletContext ->
       log.debug("Bootstrap");
       def student1 = new Student(name:'George',courseCode:'1080',notes:'IT Student').save()
       def student2 = new Student(name:'Alex',courseCode:'1081',notes:'Finance Student').save()
       def status1 = new Status(code:'Not invited for interview',description:'Check Later').save()
       def status2 = new Status(code:'Applied',description:'Check Later').save()
       def placement1 = new PlacementOpportunity(companyName:'IBM',jobTitle:'Network Administrator',status:'Available').save()
       def placement2 = new PlacementOpportunity(companyName:'BT',jobTitle:'Database Administrator',status:'Available').save()
       



    }
    def destroy = {
    }
}
