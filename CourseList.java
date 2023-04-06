import java.util.ArrayList;
import java.util.UUID;

/**
 * A CourseList
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class CourseList {
    private static ArrayList<Course> courses;
    private static ArrayList<Module> module;
    private static ArrayList<Lesson> lesson;
    private static ArrayList<Question> quiz;
    private static CourseList courseList;

    /**
     * Creates a new ArrayList of Course
     */
    private CourseList()
    {
        courses = DataLoader.getCourses();
    }

    /**
     * Checks if there is a courseList and if it isn't, it makes a new one.
     * If there is, it returns it. 
     * @return an instance of courseList
     */
    public static CourseList getInstance()
    {
        if(courseList == null){
            courseList = new CourseList();
        }
        return courseList;
    }

    /**
     * Adds Course
     * @param author course author
     * @param name course title
     * @param description course description
     * @param syllabus course syllabus
     * @param difficulty course difficulty
     * @param language course language
     * @param modules course modules
     * @return If the course was successfully added or not (boolean)
     */
    public boolean addCourse(UUID author, String name, String description, String syllabus, Difficulty difficulty, Language language, ArrayList<Module> modules){
        courses.add(new Course(author, name, description, syllabus, difficulty, language, modules)); 
        saveCourses();
        return true;
    }
    
    /**
     * Checks if the Course exists by the title
     * @param title title of course
     * @return the course, if found
     */
    public Course hasCourse(String title){
        for(int i = 0; i < courses.size(); i++) 
        {
            if(courses.get(i).getTitle() == title)
            {
                return courses.get(i);
            }
        }
        return null;
    }

    public boolean haveCourse(String title){
        for(Course course: courses) 
        {
            if(course.getTitle().equals(title))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a ArrayList of courses
     * @return a ArrayList of courses
     */
    public ArrayList<Course> getAllCourses(){
        return courses;
    }

    /**
     * Saves the the Course, writes it the JSON
     */
    public void saveCourses(){
        DataWriter.saveCourses();
    }
}
