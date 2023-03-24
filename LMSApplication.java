import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *  This is the facade that is used by the main menu
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class LMSApplication {
    private User user; 
    private Course course;
    private Module module;
    private Lesson lesson;
    private Question question;
    private User author;
    private Student student;
    private CourseList courseList;
    private Quiz quiz;
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

    public boolean findAuthorForCourse(String username){
        if(!userList.haveUser(username)) return false;
        author = userList.getUser(username);
        return true;
    }

    public UUID getAuthor() {
		return author.getId();
	}

    public Course findCourse(String keyword){
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
        ArrayList<Course> resultList = courseList.getAllCourses();
        return resultList;
    }

    public ArrayList<EnrolledCourse> getCurrentCourse() {
        return this.user.enrolledCourse;
    }
    
    public void courseReview(double rating, String comment, User userName){
        course.addReview(userName, rating, comment);
        //Put review onto course
    }

    public Course createCourse(UUID author, String name, String description, String syllabus, Difficulty difficulty, Language language, ArrayList<Module> modules){
        Course course1 = new Course(author, name, description, syllabus, difficulty, language, modules);
        if(course1!= null)
        {
            this.course = course1;
            courseList.addCourse(author, name, description, syllabus, difficulty, language, modules);
        }
        return course1;
    } 

    public Module addModule(String title, ArrayList<Lesson> lessons){
        Module module1 = new Module(title, lessons);
        if(module1 != null){
            this.module = module1;
            course.addModule(title, lessons);
        }
        return module1;
    }

    public Lesson addLesson(String content, String title, Quiz quiz){
        Lesson lesson1 = new Lesson(content, title, quiz);
        if(lesson1 != null){
            this.lesson = lesson1;
            module.addLesson(content, title, quiz);
        }
        return lesson1;
    }

    public Quiz addQuiz(ArrayList<Question> questions){
        Quiz quiz1 = new Quiz(questions);
        if(quiz1 != null){
            this.quiz = quiz1;
            lesson.addQuiz(questions);
        }
        return quiz1;
    }

    public Question addQuestion(String question, ArrayList<String> answers, int correctAnswer){
        Question question1 = new Question(question, answers, correctAnswer);
        if(question1 != null){
            this.question = question1;
            quiz.addQuestion(question, answers, correctAnswer);
        }
        return question1;
    }

    public void nextModule(EnrolledCourse course)
    {
        //Only called after a module is finished
        course.moveCurrentModule();
        System.out.println(course.resumeModule());
        
    }
    public void nextLesson(EnrolledCourse course){
        //Only called after a module is finished
        course.moveCurrentLesson();
        System.out.println(course.resumeLesson());
    }

    public Integer getGrades(){
        for(Integer grades: student.getGrades()){
            return grades;
        }
        return null;
    }

    public void getAllLanguages(){
        for(Language language: Language.values()){
            System.out.println(language);
        }
    }

    public Quiz takeQuiz(){
        //IDK if this works but its something
        this.quiz = lesson.getQuiz();
        return this.quiz;
    }
}