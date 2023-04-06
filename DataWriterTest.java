import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
    private UserList user = UserList.getInstance();
    private CourseList courseList = CourseList.getInstance();
    private FAQList faq = FAQList.getInstance();
    private ArrayList<User> users = user.getUsers();
    private ArrayList<Course> courses = courseList.getAllCourses();
    //private ArrayList<Module> modules = course.getModule();
    private ArrayList<FAQ> faqs = faq.getFAQ();

    @BeforeEach
    public void setup(){
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        CourseList.getInstance().getAllCourses().clear();
        DataWriter.saveCourses();
        FAQList.getInstance().getFAQ().clear();
        DataWriter.saveFAQs();
    }

    @AfterEach
    public void tearDown(){
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        CourseList.getInstance().getAllCourses().clear();
        DataWriter.saveCourses();
        FAQList.getInstance().getFAQ().clear();
        DataWriter.saveFAQs();
    }
    //Getting user json size
    @Test
    void testWritingZeroUsers() {
		users = DataLoader.getUsers();
		assertEquals(0, user.size());
	}
    //Adding one user, get username
    @Test
    void testWritingOneUser(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("adennis2", DataLoader.getUsers().get(0).getUsername());
    }
    //Adding one user, get password
    //Adding one user, get first name
    //Adding one user, get last name
    //Adding one user, get email
    //Adding one user, get account type
    //Adding one user, get birthday
    //Adding six users, get 3rd user's username
    //Adding six users, get 3rd user's password
    //Adding six users, get 3rd user's first name
    //Adding six users, get 3rd user's last name
    //Adding six users, get 3rd user's email
    //Adding six users, get 3rd user's birthday
    //Adding six users, get 3rd user's account type
    //Add empty user, get username
    //Add empty user, get password
    //Add empty user, get first name
    //Add empty user, get last name
    //Add empty user, get email
    //Add empty user, get birthday
    //Add empty user, get account type
    //add null user, get username
    //add null user, get password
    //add null user, get first name
    //add null user, get last name
    //add null user, get email
    //add null user, get birthday
    //add null user, get account type
    //Getting course json size
    @Test
    void testWritingZeroCourses(){
        courses = DataLoader.getCourses();
        assertEquals(0, course.size());
    }
    //Adding one course, get title
    @Test
    void testWritingOneCourse(){
        courses.add(new Course(users.get(0).getId(), "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, null));
        DataWriter.saveCourses();
        assertEquals("Classes for Beginners",DataLoader.getCourses().get(0).getTitle());
    }
    //Adding one course, get description
    //Adding one course, get syllabus
    //Adding one course, get difficulty
    //Adding one course, get language
    //Adding one course, get module
    //Adding six course, get 3rd course title
    //Adding six course, get 3rd course description
    //Adding six course, get 3rd course syllabus
    //Adding six course, get 3rd course difficulty
    //Adding six course, get 3rd course language
    //Adding six course, get 3rd course module
    //Add empty course, get title
    //Add empty course, get description
    //Add empty course, get syllabus
    //Add empty course, get difficulty
    //Add empty course, get language
    //Add empty course, get module
    //add null course, get title
    //add null course, get description
    //add null course, get syllabus
    //add null course, get difficulty
    //add null course, get language
    //add null course, get module
    //Getting FAQ json size
    @Test
    void testWritingZeroFAQs() {
		faqs = DataLoader.getFAQs();
		assertEquals(0, faq.size());
	}
    //Adding one faq, get question
    @Test
    void testWritingOneFAQ(){
        faqs.add(new FAQ("Would this course be helpful when interviewing with Google?", "Yes, Google likes to see that you understand object-oriented programming."));
        DataWriter.saveFAQs();
        assertEquals("Would this course be helpful when interviewing with Google?", DataLoader.getFAQs().get(0).getQuestion());
    }
    //Adding one faq, get answers
    //Adding six FAQ, get 3rd faq question
    //Adding six FAQ, get 3rd faq answer
    //Add empty faq, get question
    //Add empty faq, get answer
    //add null faq, get question
    //add null faq, get answer
}
