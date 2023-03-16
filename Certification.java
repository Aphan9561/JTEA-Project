import java.util.Date;

public class Certification {
    private String firstName;
    private String lastName;
    private String courseName;
    private Date dateCompleted;
    
    public Certification(String firstName, String lastName, String courseName, Date dateCompleted){
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
        this.dateCompleted = dateCompleted;
    }

    public String toString(){
        return "Name: "+firstName+ " "+lastName+
                "\nCourse taken: "+courseName+
                "\nDate Completed: "+dateCompleted;
    }
}
