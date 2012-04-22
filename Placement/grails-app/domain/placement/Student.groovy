package placement

class Student {

    String Name
    String CourseCode
    String Notes
    static hasMany = [applications: Application]

    static constraints = {
    }
}
