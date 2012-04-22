package placement

class PlacementOpportunity {

    String JobTitle
    String CompanyName
    String Status

    static hasMany = [applications: Application]

    static constraints = {
    }
}
