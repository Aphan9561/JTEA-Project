import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * this is the user class
 * @author: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class User {
    protected UUID id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected Date birthday;
    protected String username;
    protected String password;
    protected ArrayList<EnrolledCourse> enrolledCourse;
    protected AccountType type;

    /**
     * Creates a new user
     * @param firstName user's first name
     * @param lastName  user's last name
     * @param email     users' email
     * @param birthday  user's birthday
     * @param username  user's username
     * @param password  user's password
     * @param type      type of account the user has
     */
    public User(String firstName, String lastName, String email, Date birthday, String username, String password,
            AccountType type) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.username = username;
        this.type = type;
        enrolledCourse = new ArrayList();
    }

    /**
     * Logining as an existing user
     * @param id        user's id
     * @param firstName user's first name
     * @param lastName  user's last name
     * @param email     users' email
     * @param birthday  user's birthday
     * @param username  user's username
     * @param password  user's password
     * @param type      type of account the user has
     */
    public User(UUID id, String firstName, String lastName, String email, Date birthday, String username,
            String password, AccountType type/* , ArrayList<EnrolledCourse> enrolledCourse */) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.type = type;
        // setEnrolledCourse(enrolledCourse);
    }

    /**
     * Creates a String representation of the user
     * @return user information
     */
    public String toString() {
        return "id: " + id +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nEmail: " + email +
                "\nBirthday: " + birthday +
                "\nUsername: " + username +
                "\nPassword: " + password +
                "\nAccount type: " + type;
    }

    /**
     * Register user in course
     * @param course finding course
     */
    public void registerCourse(Course course) {
        EnrolledCourse NewCourse = new EnrolledCourse(course, true, null);
    }

    /**
     * Unregister user in course
     * @param course finding course
     */
    public void unregisterCourse(Course course) {
        EnrolledCourse RemoveCourse = new EnrolledCourse(course, false, null);
    }

    /**
     * get user's id
     * @return user's id
     */
    public UUID getId() {
        return id;
    }

    /**
     * gets user's first name
     * @return user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * gets user's last name
     * @return user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * gets user's email
     * @return user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * gets user's birthday
     * @return user's birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * get user's username
     * @return user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * gets user's password
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    /**
     * get user's account type
     * @return user's account type
     */
    public AccountType getType() {
        return type;
    }

    /**
     * get user's enrolled courses
     * @return user's enrolled courses
     */
    public ArrayList<EnrolledCourse> getEnrolledCourse() {
        return enrolledCourse;
    }

    /**
     * prints completed course certification
     * @param course the course the user wants printed out
     */
    public void printCertification(EnrolledCourse course) {
        Course course1 = course.getCourse();
        Certification certification = new Certification(firstName, lastName, course1.getTitle());
        DataWriter.CreateCertificationFile(certification);
    }
    // public void giveStars() {

    // }

    // update grade method
    // public void updateGrade(EnrolledCourse course, int moduleNum, double grade){
    // this.course = course;

    // loop through enrolled courses
    // for(int i = 0; i< enrolledCourse.size(); i++){
    // if (enrolledCourse.get(i) == course){
    // //getModule(enrolledCourse.get(i).getCurrentModule());
    // }
    // }
    // find the course
    // if course exists update it to include the grade for the given module
    // otherwise make a new course and update the grade in the module
    // }

    /*
     * public static void main(String[] args){
     * User user = new User("Anne", "Smith", "ASmith@gmail.com", new Date(),
     * "ASmith", AccountType.STUDENT);
     * System.out.println(user.getId());
     * }
     */

}
