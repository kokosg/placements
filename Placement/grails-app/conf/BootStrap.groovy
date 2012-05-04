import placement.*
class BootStrap {

    def init = { servletContext ->
       log.debug("Bootstrap");

       def student = new Student(name:'George Georgiou',courseCode:'1080',notes:'IT Student').save()
       def student2 = new Student(name:'Alex Kemars',courseCode:'1081',notes:'Finance Student').save()
       def student3 = new Student(name:'Evans Kitakis',courseCode:'1082',notes:'Mathematics Student').save()
       def student4 = new Student(name:'Manolios Mpixtis',courseCode:'1083',notes:'Finance Student').save()
       def student5 = new Student(name:'Afro Manimani',courseCode:'1084',notes:'IT Student').save()
       def student6 = new Student(name:'Maria Kourlampashi',courseCode:'1085',notes:'Survey Student').save()

       def status = new Status(code:'Not invited for interview',description:'Not invited for interview. Check Later').save()
       def status2 = new Status(code:'Applied',description:'Applied').save()
       def status3 = new Status(code:'Invited for Interview',description:'Check for details').save()
       def status4 = new Status(code:'Not Offered',description:'Not Offered yet').save()
       def status5 = new Status(code:'Offered',description:'Offered').save()
       def status6 = new Status(code:'Accepted',description:'Congratulation your apply accepted').save()
       def status7 = new Status(code:'Rejected',description:'Sorry, Your apply rejected').save()


       def jobTitle = new PlacementOpportunity(companyName:'IBM',jobTitle:'Network Administrator',status:'Open').save()
       def jobTitle2 = new PlacementOpportunity(companyName:'BT',jobTitle:'Database Administrator',status:'Open').save()

       def application = new Application(status:status,student: student, placement: jobTitle, timestamp: 'test' ).save()



    }
    def destroy = {
    }
}
