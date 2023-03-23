import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

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
        User user1 = new User(firstName, lastName, email, birthday, username, password, Type); 
        if(user1!= null)
        {
            this.user = user1;
            userList.addUser(firstName, lastName, email, birthday, username, password, Type);
        }
        return user1;
    }

    public User login(String username, String password){
        /*int i = 0;
        this.user = null;
        while (userList.getUser() != null) {
            if(userList.getUser().get(i).getUsername().equalsIgnoreCase(usernmame))
            {
                    if(userList.getUser().get(i).getPassword().equalsIgnoreCase(password)) 
                    {
                        this.user = userList.getUser().get(i);
                    }
            }
            i++;
        }
        return this.user;*/
        this.user = null;
        for(int i=0; i < userList.size(); i++) {
            if(userList.getUser().get(i).getUsername().equals(username)) {
                if(userList.getUser().get(i).getPassword().equals(password)) {
                    this.user = userList.getUser().get(i);
                }
            }
        }
        return this.user;
    }

    public ArrayList<Course> findCourse(String keyword){
        ArrayList<Course> resultList = courseList.getCourse(keyword);
        return resultList;
    }

    public ArrayList<Course> findCourse() { //What does this do again?
        ArrayList<Course> resultList = courseList.getAllCourses();
        return resultList;
    }

    public ArrayList<EnrolledCourse> getCurrentCourse() {
        return this.user.getEnrolledCourse;
    }

    public boolean addCourse(String name, String description, Difficulty difficulty, Language language) {
        boolean created = true;
        Course course = new Course(name, description, difficulty, language);
        //Use author
        return created;
    }

    public void courseReview(double rating, String comment, UUID user){
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