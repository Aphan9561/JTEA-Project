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
    private User currentUser;
    private Student student;
    private CourseList courseList;
    private Quiz quiz;
    private static LMSApplication lmsApplication;
    private UserList userList;
    private FAQList faqList;
    
    /**
     * This creates the application and all the lists that are needed
     */
    private LMSApplication(){
        this.courseList = CourseList.getInstance();
        this.userList = UserList.getInstance();
        this.faqList = FAQList.getInstance();
    }

    /**
     * This gets the only LMSApplication and creates one if one is not created
     */
    public static LMSApplication getInstance() {
    if(lmsApplication == null){
        lmsApplication = new LMSApplication();
    }
    return lmsApplication;
    }

    /**
     * This is how an account is created on this side
     * @param firstName
     * @param lastName
     * @param email
     * @param birthday
     * @param username
     * @param password
     * @param Type
     * @return Whether it worked
     */
    public boolean createAccount(String firstName, String lastName, String email, Date birthday, String username, String password, AccountType Type){
        return userList.addUser(firstName, lastName, email, birthday, username, password, Type);
    }

    /**
     * This is how an user logs in on this side. 
     * @param username
     * @param password
     * @return Whether it worked
     */
    public boolean login(String username, String password){
        if(!userList.haveUser(username, password)) 
            return false;

        currentUser = userList.getUser(username);
        return true;
    }

    /**
     * Gets the current user
     * @return current user
     */
    public User getCurrentUser(){
        return currentUser;
    }

    /**
     * This checks whether 
     * @param username
     * @return
     */
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
        return this.currentUser.enrolledCourse;
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
        //System.out.println(course.resumeModule()); //Return module. Maybe just do in UI.
        
    }
    public void nextLesson(EnrolledCourse course){
        //Only called after a lesson is finished
        course.moveCurrentLesson();
        //System.out.println(course.resumeLesson());
    }

    public Integer getGrades(){
        for(Integer grades: student.getGrades()){
            return grades; //Only returns first. Need to decide what to do here
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

    public void CreateCertificationFile(EnrolledCourse course)
    {
        //this.user.printCertification(course);
    }

    public boolean CreateCourseFile(Module module){
        return DataWriter.CreateCourseFile(module);
    }

    public String getFAQString() {
        return faqList.FAQstoString();
    }

    public String getFAQQuestionsString() {//Be in UI or put toString in GRQ
        String result = "";
        for(int i=0; i < faqList.getFAQ().size(); i++) {
            result += (i+1);
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

    public boolean askQuestion(String question) {
        boolean added = false;
        if(question != null) {
            faqList.addFAQ(question);
            added = true;
        }
        return added;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String courseCommnetsToString() {
        return course.commentsToString();
    }

    public boolean addComment(String comment, UUID user) {
        boolean added = false;;
        if(comment != null) {
            course.addComment(new Comment(comment, user));
            added = true;
        }
        return added;
    }

    public String getCourseCommentsString() {
        String result = "";
        for(int i=0; i < course.getComment().size(); i++) {
            result += (i+1);
            result += ". ";
            result += course.getComment().get(i).getComment();
            result += "\n";
        }
        return result;
    }

    public Comment getCommentAt(int index) {
        return course.getComment().get(index);
    }

    public String getCommentUsername(UUID id) {
        return userList.findUsername(id);
    }

    public boolean addReply(int index, String reply, UUID id) {
        boolean added = false;
        if(reply != null) {
            course.getComment().get(index).addReply(new Reply(reply, id));
            added = true;
        }
        return added;
    }

    public String getQuizQuestion(Quiz quiz, int index) {
        return quiz.getQuestion().get(index).getQuestion();
    }

    public String getQuizAnswers(Quiz quiz, int index) {
        return quiz.getQuestion().get(index).answersToString();
    }

    public int getQuestionGrade(Quiz quiz, int index, int answer, int grade) {
        int updatedGrade = grade;
        if(quiz.getQuestion().get(index).getCorrectAnswer() != (answer -1)) {
            updatedGrade -= (100/quiz.getQuestion().size());
        }
        return updatedGrade;
    }

    public ArrayList<Course> getEnrolledCourses(ArrayList<EnrolledCourse> enrolledCourses) {
        ArrayList<Course> tempCourses = new ArrayList<Course>();
        for(EnrolledCourse enrolledCourse : enrolledCourses) {
            for(Course course : courseList.getAllCourses()) {
                if(course.getId().equals(enrolledCourse.getCourse())) {
                    tempCourses.add(course);
                    break;
                }
            }
        }
        return tempCourses;
    }

    public Course findCourse(UUID courseID) {
        Course foundCourse = null;
        for(Course course : courseList.getAllCourses()) {
            if(course.getId().equals(courseID)) {
                foundCourse = course;
                break;
            }
        }
        return foundCourse;
    }

    public int calculateOverallQuizValue(Course course) {
        int numberOfQuestions = 0;
        for(Module module : course.getModule()) {
            for(Lesson lesson : module.getLesson()) {
                numberOfQuestions++;
            }
        }
        return numberOfQuestions;
    }

    public int calculateModuleQuizValue(Module module) {
        int numberOfQuestions = 0;
        for(Lesson lesson : module.getLesson()) {
            numberOfQuestions++;
        }
        return numberOfQuestions;
    }

    public String completedCoursesToString(ArrayList<EnrolledCourse> enrolledCourses) {
        ArrayList<UUID> completedCourses = new ArrayList<UUID>();
        for(EnrolledCourse enrolledCourse : enrolledCourses) {
            if(enrolledCourse.getProgress() == Progress.COMPLETED) {
                completedCourses.add(enrolledCourse.getCourse());
            }
        }
        String result = "";
        for(int i=0; i < completedCourses.size(); i++) {
            result += (i+1);
            result += ". ";
            result += findCourse(completedCourses.get(i));
            result += "\n";
        }
        return result;
    }
}