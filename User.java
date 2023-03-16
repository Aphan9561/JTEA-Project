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
    protected AccountType type;

    public User(UUID id, String firstName, String lastName, String email, Date birthday, String username, AccountType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.username = username;
        this.type = type;
    }

    public User(String firstName, String lastName, String email, Date birthday, String username, AccountType type) {
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

    public String getFirstName() {
		return firstName;
	}
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Date getBirthday(){
        return birthday;
    }

    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
    /*
     * public ArrayList<EnrolledCourse> getCourse()
     * {
     * return enrolledCourse;
     * }
     */
}
