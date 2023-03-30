import java.util.Date;

/**
 * A Certification
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class Certification {
    private String firstName;
    private String lastName;
    private String courseName;

    /**
     * Creates a Certification
     * @param firstName first name of user
     * @param lastName last name of user
     * @param courseName course name
     */
    public Certification(String firstName, String lastName, String courseName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
    }

    /**
     * Returns details of the Certification
     * @return A string representation of a Certification
     */
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nCourse completed: " + courseName;
    }
}
