import java.util.Date;

public class Certification {
    private String firstName;
    private String lastName;
    private String courseName;
    private Date dateCompleted;
    private Integer grade;
    
    public Certification(String firstName, String lastName, String courseName, Date dateCompleted, Integer grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
        this.grade = grade;
    }

    public String toString(){
        return "Name: "+firstName+ " "+lastName+
                "\nCourse taken: "+courseName+
                "\nGrades: "+grade;
    }
}
