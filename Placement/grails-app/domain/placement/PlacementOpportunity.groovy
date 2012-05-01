package placement

class PlacementOpportunity {

    String jobTitle
    String companyName
    String status

    static hasMany = [applications: Application]
    static mappedBy = [applications: "placement"]

    static constraints = {
    }
}
