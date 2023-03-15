import java.util.ArrayList;
import java.util.Date;

/*
 *  This is the facade that is used by the main menu
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class LMSApplication {
    private User user = ; //Figure this out.
    private CourseList courseList;
    private static LMSApplication lmsApplication;
    
    private LMSApplication(){
    this.courseList = new CourseList();
    }

    public LMSApplication getInstance() {
    if(lmsApplication == null){
        lmsApplication = new LMSApplication();
    }
    return lmsApplication;
    }

    public User createAccount(String firstName, String lastName, String email, Date birthday, String username, String password){
        User user = new User(firstName, lastName, email, password, username);
        return user;
    }
    
    public User login(String usernmame, String password){
        return this.user;
    }

    public ArrayList<Course> findCourse(String keyword){
        return this.courseList.getCourse(keyword);
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