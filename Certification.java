import java.util.Date;

public class Certification {
    private String firstName;
    private String lastName;
    private String courseName;
    
    public Certification(String firstName, String lastName, String courseName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
    }

    public String toString(){
        return "Name: "+firstName+ " "+lastName+
                "\nCourse completed: "+courseName;
    }
}
