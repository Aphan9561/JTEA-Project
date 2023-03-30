import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * An Author User
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class Author extends User {
    private ArrayList<Course> myCourses;

    /**
     * Creates an Author
     * @param id An Author UUID
     * @param firstName Author's First Name
     * @param lastName  Author's Last Name
     * @param email Author's email
     * @param birthday Author's birthday
     * @param username Author's username
     * @param password Author's password
     * @param type Author's Account Type
     */
    public Author(UUID id, String firstName, String lastName, String email, Date birthday, String username,
            String password, AccountType type) {
        super(id, firstName, lastName, email, birthday, username, password, type);
    }

    /**
     * Returns details of the author
     * @return A string representation of a Author
     */
    public String toString() {
        return "id: " + id +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nEmail: " + email +
                "\nBirthday: " + birthday +
                "\nUsername: " + username +
                "\nAccount type: " + type;
    }

    /**
     * Allows Author to create a course
     * @param title course title
     * @param description course description
     * @param syllabus course syllabus
     * @param difficult course difficultly
     * @param language course language
     * @param modules course modules
     */
    public void addCourse(String title, String description, String syllabus, Difficulty difficult, Language language,
            ArrayList<Module> modules) {
        Course newCourse = new Course(id, title, description, syllabus, difficult, language, modules);
    }

}
