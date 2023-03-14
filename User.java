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
    protected ArrayList<EnrolledCourse> enrolledCourse;

    public User(String firstName, String lastName, String email, String birthday, String username) {

    }

    public void registerCourse(Course course){

    }

    public void unregisterCourse(Course course){

    }

    public void addReview(Course course, double rating, String comment) {

    }

    public ArrayList<EnrolledCourse> getCourse()
    {
        return enrolledCourse;
    }
}
