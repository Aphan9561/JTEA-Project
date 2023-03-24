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
<<<<<<< HEAD
    
    public void addCourse(String title, String decription, String syllabus, Difficulty difficult, Language language){
        Course newCourse = new Course(id, title, decription, syllabus, difficult, language);
=======
    public void addCourse(String title, String decription, String syllabus, Difficulty difficult, Language language, ArrayList<Module> modules){
        Course newCourse = new Course(id, title, decription, syllabus, difficult, language, modules);
>>>>>>> c8855e2e461a51f0f438b9b3a2b2ff1659cc4ce4
    }
    
}
