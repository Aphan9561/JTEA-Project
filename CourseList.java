import java.util.ArrayList;

public class CourseList {
    private static ArrayList<Course> courses;
    private static CourseList courseList;

    private CourseList()
    {

    }

    public static CourseList getInstance()
    {
        if(courseList == null){
            courseList = new CourseList();
        }
        return courseList;

    }

    public void addCourse(String name, Author author, String description, Difficulty difficulty, Language language){

    }

    public Course getCourse(String keyword){
        return null;

    }
    public void editCourse(String title, String description){

    }

    public void getAllCourses(){
        
    }
}
