import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static ArrayList<Course> courses;
    private static ArrayList<Module> module;
    private static ArrayList<Lesson> lesson;
    private static ArrayList<Question> quiz;
    private static CourseList courseList;

    private CourseList()
    {
        courses = DataLoader.getCourses();
    }

    public static CourseList getInstance()
    {
        if(courseList == null){
            courseList = new CourseList();
        }
        return courseList;
    }

    public void addCourse(UUID author, String name, String description, String syllabus, Difficulty difficulty, Language language){
        courses.add(new Course(author, name, description, syllabus, difficulty, language));
    }

    public void addModule(String title, ArrayList<Lesson> lessons){
        module.add(new Module(title, lessons));
    }
    public void addLesson(String content, String title, Quiz quiz){
        lesson.add(new Lesson(content, title, quiz));
    }

    public void addQuiz(String question, ArrayList<String> answers, int correctAnswer){
        quiz.add(new Question(question, answers, correctAnswer));
    }

    public ArrayList<Course> getCourse(String keyword){
        return courses;
    }
    
    public ArrayList<Course> getAllCourses(){
        return courses;
    }
}
