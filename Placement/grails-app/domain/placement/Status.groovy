package placement

class Status {

    String Code
    String Description
    static hasMany = [applications: Application]

    static constraints = {
    }
}
