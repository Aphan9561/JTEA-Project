import java.util.ArrayList;

public class Author extends User{
    private ArrayList<Course> myCourses;

    public Author(String firstName, String lastName, String email, String birthday,String username)
    {
        super(firstName, lastName,email,birthday,username);
    }

    public void addCourse(String title, String decription, String syllabus, Difficulty difficult, Language language){
        
    }
    
}
