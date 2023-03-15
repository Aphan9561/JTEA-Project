import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Author extends User{
    private ArrayList<Course> myCourses;

    public Author(UUID id,String firstName, String lastName, String email, Date birthday,String username, String type)
    {
        super(id, firstName, lastName, email, birthday, username, type);
    }

    public void addCourse(String title, String decription, String syllabus, Difficulty difficult, Language language){
        
    }
    
}
