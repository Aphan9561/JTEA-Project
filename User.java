import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class User {
    protected UUID id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected Date birthday;
    protected String username;
    //protected ArrayList<EnrolledCourse> enrolledCourse;
    protected String type;

    public User(UUID id, String firstName, String lastName, String email, Date birthday, String username, String type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.username = username;
        this.type = type;
    }

    public User(String firstName, String lastName, String email, Date birthday, String username, String type) {
        UUID id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.username = username;
        this.type = type;
    }

    public String toString() {
        return "id: " + id +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nEmail: " + email +
                "\nBirthday: " + birthday +
                "\nUsername: " + username +
                "\nAccount type: " + type;
    }

    public void registerCourse(Course course) {
        EnrolledCourse NewCourse = new EnrolledCourse(course, true, null);
    }

    public void unregisterCourse(Course course) {
        EnrolledCourse RemoveCourse = new EnrolledCourse(course, false, null);
    }

    /*
     * public ArrayList<EnrolledCourse> getCourse()
     * {
     * return enrolledCourse;
     * }
     */
}
