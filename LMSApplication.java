import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.Date;

/*
 *  This is the facade that is used by the main menu
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class LMSApplication {
    private User user; 
    private CourseList courseList;
    private static LMSApplication lmsApplication;
    private UserList userList;
    
    private LMSApplication(){
    this.courseList = CourseList.getInstance();
    this.userList = UserList.getInstance();
    }

    public static LMSApplication getInstance() {
    if(lmsApplication == null){
        lmsApplication = new LMSApplication();
    }
    return lmsApplication;
    }

    public User createAccount(String firstName, String lastName, String email, Date birthday, String username, String password, AccountType Type){
        this.user = new User(firstName, lastName, email, birthday, username, Type);
        return this.user;
    }

    public User login(String usernmame, String password){
        int i = 0;
        while (userList.getUser() != null) {
            if(userList.getUser().get(i).getUsername().equalsIgnoreCase(usernmame))
            {
                //Figure out password sitution
                {
                    //if password is true
                    this.user = userList.getUser().get(i);
                }
            }
            i++;
        }
        return this.user;
    }

    public ArrayList<Course> findCourse(String keyword){
        ArrayList<Course> searched = new ArrayList<>() this.courseList.getAllCourses(keyword);
    }

    public ArrayList<Course> findCourse() {
        return this.courseList.getAllCourses();
    }

    public ArrayList<EnrolledCourse> getCurrentCourse() {
        return this.user.enrolledCourse;
    }

    public boolean addCourse(String name, String description, Difficulty difficulty, Language language) {
        return true;
    }

    public void courseReview(double rating, String comment, User user){
        Review review = new Review(rating, comment, user);
        //Put review onto course
    }

    public void enterCourse(String name){
        
    } 

    public void nextLesson(){

    }

    public void answerQuestion(){

    }

    public void getQuiz(Quiz quiz){
        
    }

    public void addModule(Module Module){

    }

    public void addLesson(Lesson lesson){
        
    }
}