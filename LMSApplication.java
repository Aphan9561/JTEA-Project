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
    private Lesson lesson;
    private User author;
    private Student student;
    private CourseList courseList;
    private Quiz quiz;
    private static LMSApplication lmsApplication;
    private UserList userList;
    private FAQList faqList;
    
    private LMSApplication(){
        this.courseList = CourseList.getInstance();
        this.userList = UserList.getInstance();
        this.faqList = FAQList.getInstance();
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

    public Course findCourseTitle(String title)
    {
        return this.courseList.hasCourse(title);
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
    }

    public Course createCourse(UUID author, String name, String description, String syllabus, Difficulty difficulty, Language language, ArrayList<Module> modules){
        Course course1 = new Course(author, name, description, syllabus, difficulty, language, modules);
        if(course1 != null)
        {
            this.course = course1;
            courseList.addCourse(author, name, description, syllabus, difficulty, language, modules);
        }
        return course1;
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

    public ArrayList<FAQ> getFAQs() {
        return faqList.getFAQ();
    }

    public Quiz takeQuiz(){
        //IDK if this works but its something
        this.quiz = lesson.getQuiz();
        return this.quiz;
    }

    public boolean CreateCertificationFile(Certification certification, Course course)
    {
        return DataWriter.CreateCertificationFile(certification, course);
    }

    public boolean CreateCourseFile(Course course){
        return DataWriter.CreateCourseFile(course);
    }

    public String getFAQString() {
        return faqList.FAQstoString();
    }

    public String getFAQQuestionsString() {
        String result = "";
        for(int i=0; i < faqList.getFAQ().size(); i++) {
            result += i;
            result += ". ";
            result += faqList.getFAQ().get(i).getQuestion();
            result += "\n";
        }
        return result;
    }

    public String getFAQat(int index) {
        String result = "Question: ";
        result += getFAQs().get(index).getQuestion();
        return result;
    }

    public boolean addAnswertoFAQ(int index, String answer) {
        if(answer == null) {
            return false;
        }
        else {
            getFAQs().get(index).addAnswer(answer);
            return true;
        }
    }

    public void askQuestion(String question) {
        faqList.addFAQ(question);
    }
}