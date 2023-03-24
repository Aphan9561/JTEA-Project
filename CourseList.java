import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static ArrayList<Course> courses;
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

    }
    public void addLesson(String content, String title, Quiz quiz){

    }

    public ArrayList<Course> getCourse(String keyword){
        return courses;
    }
    
    public ArrayList<Course> getAllCourses(){
        return courses;
    }
}
