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
    protected String password;
    protected ArrayList<EnrolledCourse> enrolledCourse;
    protected AccountType type;

    public User(String firstName, String lastName, String email, Date birthday, String username, String password, AccountType type) {
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

    public User(UUID id, String firstName, String lastName, String email, Date birthday, String username, String password, AccountType type/*, ArrayList<EnrolledCourse> enrolledCourse*/) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.type = type;
        //setEnrolledCourse(enrolledCourse);
    }

    // private void setEnrolledCourse(ArrayList<EnrolledCourse> enrolledCourse) {

    // }

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

    public String getPassword() {
        return password;
    }

    public AccountType getType(){
        return type;
    }

    public ArrayList<EnrolledCourse> getEnrolledCourse(){
        return enrolledCourse;
    }

    public void printCertification(EnrolledCourse course){
        Course course1 = course.getCourse();
        Certification certification = new Certification(firstName, lastName, course1.getTitle(), birthday);
        DataWriter.CreateCertificationFile(certification);
    }
    //  public void giveStars() {
        
    //  }

     // update grade method
     //public void updateGrade(EnrolledCourse course, int moduleNum, double grade){
        //this.course = course;

        //loop through enrolled courses
        // for(int i = 0; i< enrolledCourse.size(); i++){
        //     if (enrolledCourse.get(i) == course){
        //         //getModule(enrolledCourse.get(i).getCurrentModule());
        //     }
        // }
        //find the course
        // if course exists update it to include the grade for the given module
        //otherwise make a new course and update the grade in the module
     //}

     /*public static void main(String[] args){
        User user = new User("Anne", "Smith", "ASmith@gmail.com", new Date(), "ASmith", AccountType.STUDENT);
        System.out.println(user.getId());
     }*/

     
}
