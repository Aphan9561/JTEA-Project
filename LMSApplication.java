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
    private Course course;
    private User currentUser;
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
        User user1 = new User(firstName, lastName, email, birthday, username, password, Type); //Add password
        if(user1!= null)
        {
            this.user = user1;
            userList.addUser(firstName, lastName, email, birthday, username, password, Type);
        }
        return user1;
    }

    public boolean login(String username, String password){
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
        return this.user;
        
        this.user = null;
        for(int i=0; i < userList.size(); i++) {
            if(userList.getUser().get(i).getUsername().equals(username)) {
                if(userList.getUser().get(i).getPassword().equals(password)) {
                    this.user = userList.getUser().get(i);
                }
            }
        }
        return this.user;*/

        if(!userList.haveUser(username)){
            return false;
        }

        currentUser = userList.getUser(username, password);
        return true;
    }

    public User getCurrentUser() {
		return currentUser;
	}

    public ArrayList<Course> findCourse(String keyword){
        ArrayList<Course> resultList = new ArrayList<>();
        for(int i = 0; i < resultList.size(); i++)
        {
            if(resultList.get(i).getTitle() == keyword){
                return resultList.get(i);
            } else if (resultList.get(i).getDesciption() == keyword){
                return resultList.get(i);
            } else if (resultList.get(i).getSyllabus() == keyword){
                return resultList.get(i);
            } 
           // this.courseList.getCourse(keyword);
        }
        System.out.println("Sorry, we could not find what you were looking for.");
        return null;
    }

    public ArrayList<Course> findCourse() {
        ArrayList<Course> resultList = new ArrayList<>();
        for(courseList.)
        {
            this.courseList.getCourse(keyword);
        }
        return resultList;
    }

    public ArrayList<EnrolledCourse> getCurrentCourse() {
        return this.user.enrolledCourse;
    }

    public boolean addCourse(String name, String description, String syllabus, Difficulty difficulty, Language language) {
        boolean created = true;
        Course course = new Course(name, description, syllabus, difficulty, language);
        return created;
    }

    public void courseReview(double rating, String comment, User userName){
        course.addReview(userName, rating, comment);
        //Put review onto course
    }

    public void enterCourse(String name, String description, String syllabus, Difficulty difficulty, Language language){
        Course course = new Course(name, description, syllabus, difficulty, language);
    } 

    public void nextLesson(){
        

    }

    public void answerQuestion(){

    }

    public Quiz getQuiz(Quiz quiz){
        return quiz;
    }

    public void addModule(String title, ArrayList<Lesson> lessons){
        Module module = new Module(title, lessons);
        
    }

    public void addLesson(String content, String title, Quiz quiz){
        Lesson lesson2 = new Lesson(content, title, quiz);
    }
}