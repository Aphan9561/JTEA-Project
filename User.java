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

    public User(String firstName, String lastName, String email, Date birthday, String username, AccountType type) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.username = username;
        this.type = type;
    }

    public User(UUID id, String firstName, String lastName, String email, Date birthday, String username, AccountType type) {
        this.id = id;
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

    public UUID getId() {
		return id;
	}

    public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

    public String getEmail(){
        return email;
    }

    public Date getBirthday(){
        return birthday;
    }

    public String getUsername(){
        return username;
    }

    public AccountType getType(){
        return type;
    }

    /*
     * public ArrayList<EnrolledCourse> getCourse()
     * {
     * return enrolledCourse;
     * }
     */

     public void giveStars() {
        
     }

     // update grade method
     public void updateGrade(Course course, int moduleNum, double grade){
        //this.course = course;
     }

     public static void main(String[] args){
        User user = new User("Anne", "Smith", "ASmith@gmail.com", new Date(), "ASmith", AccountType.STUDENT);
        System.out.println(user.getId());
     }

     
}
