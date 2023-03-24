import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Author extends User{
    private ArrayList<Course> myCourses;

    public Author(UUID id,String firstName, String lastName, String email, Date birthday,String username, String password, AccountType type)
    {
        super(id, firstName, lastName, email, birthday, username,password, type);
    }

    public String toString()
    {
        return "id: " +id+ 
                "\nFirst Name: "+firstName+
                "\nLast Name: "+lastName+
                "\nEmail: "+email+
                "\nBirthday: "+birthday+
                "\nUsername: "+username+
                "\nAccount type: "+type;
    }
    
    public void addCourse(String title, String decription, String syllabus, Difficulty difficult, Language language){
        Course newCourse = new Course(id, title, decription, syllabus, difficult, language);
    }
    
}
