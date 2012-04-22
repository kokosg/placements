package placement

class Application {

    static belongsTo = [student: Student, 
                        placement: PlacementOpportunity]

    Status status
    String timestamp

    static constraints = {
    }
}
