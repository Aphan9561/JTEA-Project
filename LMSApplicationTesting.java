import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

class LMSApplicationTesting {
    private LMSApplication lmsApplication = LMSApplication.getInstance();
    private UserList userList = UserList.getInstance(); 
    private ArrayList<User> users = new ArrayList<User>();
    private CourseList courseList = CourseList.getInstance();
    

    @BeforeEach
    public void setUp()
    {
        Date birthday1 = new Date("2/10/2000");
        Date birthday2 = new Date("12/02/1990");
        userList.getUsers().clear();
        userList.addUser("Sue", "Simple", "SimplyPerfect@gmail.com", birthday1, "simplyperfect", "SueMe#23", AccountType.STUDENT);
        User student1 = userList.getUser("simplyperfect");
        ArrayList<Integer> grades = [100,50,60,30,100];
        Student Sue = new Student(student1.getId(),grades);
        userList.addUser("Bob", "Chance", "chance10000@gmail.com", birthday2, "Mr.Chance", "PineAppple#02", AccountType.AUTHOR);
        User author1 = userList.getUser("Mr.Chance");
        courseList.getAllCourses().clear();
        ArrayList<Module> mods = new ArrayList<Module>() ;
        lmsApplication.createCourse(author1.getId(), "Java I", "Learning Java from variables to classes!", "This class teachs variables, loops, and more", Difficulty.EASY, Language.PYTHON, mods);
    }

    @AfterEach
    public void tearDown()
    {
        userList.getUsers().clear();
        courseList.getAllCourses().clear();
    }

    @Test
    public void testCreateValidUser()
    {
        Date birthday3 = new Date("03/24/2003");
        lmsApplication.createAccount("Eve", "Blom", "emblom@email.sc.edu", birthday3, "Eve", "CatsAwe!08", AccountType.AUTHOR);
        lmsApplication.login("Eve", "CatsAwe!08");
        User user = lmsApplication.getCurrentUser();
        assertEquals("Eve", user.getUsername());
    }
    
    @Test
    public void testCreateUserNullUsername()
    {
        Date birthday3 = new Date("03/24/2003");
        boolean isCreated = lmsApplication.createAccount("Eve", "Blom", "emblom@email.sc.edu", birthday3, null, "CatsAwe!08", AccountType.AUTHOR);
        assertFalse(isCreated);
    }
   
    @Test
    public void testCreateUserNullPassword()
    {
        Date birthday3 = new Date("03/24/2003");
        boolean isCreated = lmsApplication.createAccount("Eve", "Blom", "emblom@email.sc.edu", birthday3, "Eve", null, AccountType.AUTHOR);
        assertFalse(isCreated);
    }
    
    @Test
    public void testCreateUserNullFirstName()
    {
        Date birthday3 = new Date("03/24/2003");
        boolean isCreated = lmsApplication.createAccount(null, "Blom", "emblom@email.sc.edu", birthday3, "Eve", null, AccountType.AUTHOR);
        assertFalse(isCreated);
    }

    @Test
    public void testCreateUserNullLastName()
    {
        Date birthday3 = new Date("03/24/2003");
        boolean isCreated = lmsApplication.createAccount("Eve", null, "emblom@email.sc.edu", birthday3, "Eve", null, AccountType.AUTHOR);
        assertFalse(isCreated);
    }

    @Test
    public void testCreateUserNullEmail()
    {
        Date birthday3 = new Date("03/24/2003");
        boolean isCreated = lmsApplication.createAccount("Eve", "Blom", null, birthday3, "Eve", null, AccountType.AUTHOR);
        assertFalse(isCreated);
    }
    
    @Test
    public void testCreateUserUserInvalidEmail()
    {
        Date birthday3 = new Date("03/24/2003");
        boolean isCreated = lmsApplication.createAccount("Eve", "Blom", "emblom", birthday3, "Eve", null, AccountType.AUTHOR);
        assertFalse(isCreated);
    }
   
    @Test
    public void testCreateUserAllNumberPassword()
    {
        Date birthday3 = new Date("03/24/2003");
        boolean isCreated = lmsApplication.createAccount("Eve", "Blom", "emblom@email.sc.edu", birthday3, "Eve", "12345", AccountType.AUTHOR);
        assertFalse(isCreated);
    }
    
    @Test
    public void testCreateUserAllLowercasePassword()
    {
        Date birthday3 = new Date("03/24/2003");
        boolean isCreated = lmsApplication.createAccount("Eve", "Blom", "emblom@email.sc.edu", birthday3, "Eve", "cats", AccountType.AUTHOR);
        assertFalse(isCreated);
    }

    @Test
    public void testCreateInvalidUser()
    {
        Date birthday3 = new Date("03/24/1003");
        boolean isCreated = lmsApplication.createAccount("12", "34", "cars", birthday3, "Mr. Chance", "5555", AccountType.AUTHOR);
        assertFalse(isCreated);
    }

    @Test
    public void testCreateUserFutureDate()
    {
        Date birthday3 = new Date("03/24/2024");
        boolean isCreated = lmsApplication.createAccount("Eve", "Blom", "emblom@email.sc.edu", birthday3, "Eve", "CatsAwe!08", AccountType.AUTHOR);
        assertFalse(isCreated);
    }
    
    @Test
    public void testCreateUserPastDate()
    {
        Date birthday3 = new Date("03/24/1024");
        boolean isCreated = lmsApplication.createAccount("Eve", "Blom", "emblom@email.sc.edu", birthday3, "Eve", "CatsAwe!08", AccountType.AUTHOR);
        assertFalse(isCreated);
    }
   
    @Test
    public void testCreateUserUsedEmail()
    {
        Date birthday3 = new Date("03/24/1024");
        boolean isCreated = lmsApplication.createAccount("Eve", "Blom", "SimplyPerfect@gmail.com", birthday3, "Eve", "CatsAwe!08", AccountType.AUTHOR);
        assertFalse(isCreated);
    }
    
    @Test
    public void testCreateUserUsedUsername()
    {
        Date birthday3 = new Date("03/24/2003");
        boolean isCreated = lmsApplication.createAccount("Eve", "Blom", "emblom@email.sc.edu", birthday3, "Mr. Chance", "CatsAwe!08", AccountType.AUTHOR);
        assertFalse(isCreated);
    }

    @Test
    public void testCreateUserOldUser()
    {
        Date birthday2 = new Date("12/02/1990");
        boolean isCreated = lmsApplication.createAccount("Bob", "Chance", "chance10000@gmail.com", birthday2, "Mr.Chance", "PineAppple#02", AccountType.AUTHOR);
        assertFalse(isCreated);
    }

    @Test
    public void testLoginInNullUsername()
    {
        boolean isCreated = lmsApplication.login(null, "SueMe#23");
        assertFalse(isCreated);
    }

    @Test
    public void testLoginInNullPassword()
    {
        boolean isCreated = lmsApplication.login("simplyperfect", null);
        assertFalse(isCreated);
    }

    @Test
    public void testLoginInNullUsernameANDPassword()
    {
        boolean isCreated = lmsApplication.login(null, null);
        assertFalse(isCreated);
    }

    public void testLoginInCorrectUsername()
    {
        boolean isCreated = lmsApplication.login("simplyperfect", "SueNe#25");
        assertFalse(isCreated);
    }

    @Test
    public void testLoginInCorrectPassword()
    {
        boolean isCreated = lmsApplication.login("sinpluperfect", "SueMe#23");
        assertFalse(isCreated);
    }
    
    @Test
    public void testLoginInNonUser()
    {
        boolean isCreated = lmsApplication.login("emblom", "cats#23");
        assertFalse(isCreated);
    }

    @Test
    public void testLoginInCorrectUsernameWrongCase()
    {
        boolean isCreated = lmsApplication.login("SimplyPerfecT", "SueMe#23");
        assertFalse(isCreated);
    }

    @Test
    public void testLoginInCorrectPasswordWrongCase()
    {
        boolean isCreated = lmsApplication.login("simplyperfect", "sueme#23");
        assertFalse(isCreated);
    }

    @Test
    public void testLoginInCorrectUsernameANDPasswordWrongCase()
    {
        boolean isCreated = lmsApplication.login("SimplyPerfecT", "sueme#23");
        assertFalse(isCreated);
    }
    
    @Test
    public void testLoginInCorrectUsernameANDPassword()
    {
        boolean isCreated = lmsApplication.login("simplyperfect", "SueMe#23");
        assertTrue(isCreated);
    }

    @Test
    public void testFindAuthorForCourseValidStudent()
    {
        boolean isAuthor = lmsApplication.findAuthorForCourse("simplyperfect");
        assertFalse(isAuthor);
    }

    @Test
    public void testFindAuthorForCourseValidAuthor()
    {
        boolean isAuthor = lmsApplication.findAuthorForCourse("Mr.Chance");
        assertTrue(isAuthor);
    }

    @Test
    public void testFindAuthorForCourseInvalidUser()
    {
        boolean isAuthor = lmsApplication.findAuthorForCourse("emblom");
        assertFalse(isAuthor);
    }

    @Test
    public void testFindAuthorForCourseMisspelledUsername()
    {
        boolean isAuthor = lmsApplication.findAuthorForCourse("Mr.Chances");
        assertTrue(isAuthor);
    }

    @Test
    public void testFindAuthorForCourseNoCourse()
    {
        courseList.getAllCourses().clear();
        boolean isAuthor = lmsApplication.findAuthorForCourse("Mr.Chance");
        assertFalse(isAuthor);
    }

    @Test
    public void testFindAuthorForCourseOneCourse()
    {   
        boolean isAuthor = lmsApplication.findAuthorForCourse("Mr.Chance");
        assertTrue(isAuthor);
    }

    @Test
    public void testFindAuthorForCourseManyCourses()
    {
        User author1 = userList.getUser("Mr.Chance"); 
        ArrayList<Module> mods = new ArrayList<Module>();
        lmsApplication.createCourse(author1.getId(), "Java 2", "Learning Java from classes to design patterns!", "This class teachs variables, loops, and more", Difficulty.EASY, Language.PYTHON, mods);
        boolean isAuthor = lmsApplication.findAuthorForCourse("Mr.Chance");
        assertTrue(isAuthor);
    }

    @Test
    public void testFindCourseValidTitle()
    {
        Course isCourse = lmsApplication.findCourseTitle("Java I");
        assertEquals(isCourse.getTitle(),"Java I");
    }

    @Test
    public void testFindCourseMisspelledTitle()
    {
        Course isCourse = lmsApplication.findCourseTitle("Java 1");
        assertNotEquals(isCourse.getTitle(),"Java I");
    }

    @Test
    public void testFindCourseNonexistedTitle()
    {
        Course isCourse = lmsApplication.findCourseTitle("Python for Dummies 1");
        assertEquals(isCourse, null);
    }
    
    @Test
    public void testGetGrades()
    {
        Integer gradeAverage = 68;
        Integer testGradeAverage = lmsApplication.getGrades();
        assertEquals(gradeAverage, testGradeAverage);
    }

    
}