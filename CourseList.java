import java.util.ArrayList;

public class CourseList {
    private ArrayList<Course> courses;
    private CourseList courseList;

    private CourseList()
    {

    }

    public CourseList getInstance()
    {
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
