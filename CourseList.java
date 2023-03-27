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

    public boolean addCourse(UUID author, String name, String description, String syllabus, Difficulty difficulty, Language language, ArrayList<Module> modules){
        courses.add(new Course(author, name, description, syllabus, difficulty, language, modules)); 
        saveCourses();
        return true;
    }

    public ArrayList<Course> getCourse(String keyword){
        return courses;
    }
    
    public Course hasCourse(String title)
    {
        for(int i = 0; i < courses.size(); i++) 
        {
            if(courses.get(i).getTitle() == title)
            {
                return courses.get(i);
            }
        }
        return null;
    }
    public ArrayList<Course> getAllCourses(){
        return courses;
    }
    public void saveCourses(){
        DataWriter.saveCourses();
    }
}
