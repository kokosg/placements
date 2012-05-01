package placement

class Student {

    String name
    String courseCode
    String notes
    static hasMany = [applications: Application]

    static constraints = {
    }
}
