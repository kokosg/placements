package placement

class Status {

    String code
    String description
    static hasMany = [applications: Application]

    static constraints = {
    }
}
