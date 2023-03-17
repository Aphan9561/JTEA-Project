import java.util.ArrayList;

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

    public void addCourse(String name, Author author, String description, Difficulty difficulty, Language language){
        courses.add(new Course(name, description, difficulty, language));
    }

    public ArrayList<Course> getCourse(String keyword){
        return courses;
    }
    
    public ArrayList<Course> getAllCourses(){
        return courses;
    }
}
