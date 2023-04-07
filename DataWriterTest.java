import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
    private UserList userList = UserList.getInstance();
    private CourseList courseList = CourseList.getInstance();
    private FAQList faqList = FAQList.getInstance();
    private ArrayList<User> users = userList.getUsers();
    private ArrayList<Course> courses = courseList.getAllCourses();
    //private ArrayList<Module> modules = course.getModule();
    private ArrayList<FAQ> faqs = faqList.getFAQ();

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
    public void testWritingZeroUsers() {
		users = DataLoader.getUsers();
		assertEquals(0, userList.size());
	}
    //Adding one user, get username
    @Test
    public void testWritingOneUserAndGetUsername(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("adennis2", DataLoader.getUsers().get(0).getUsername());
    }
    //Adding one user, get password
    @Test
    public void testWritingOneUserAndGetPassword(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("catsForLife", DataLoader.getUsers().get(0).getPassword());
    }
    //Adding one user, get first name
    @Test
    public void testWritingOneUserAndGetFirstName(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("Anne", DataLoader.getUsers().get(0).getFirstName());
    }
    //Adding one user, get last name
    @Test
    public void testWritingOneUserAndGetLastName(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("Dennis", DataLoader.getUsers().get(0).getLastName());
    }
    //Adding one user, get email
    @Test
    public void testWritingOneUserAndGetEmail(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("ADen@email.com", DataLoader.getUsers().get(0).getEmail());
    }
    //Adding one user, get account type
    @Test
    public void testWritingOneUserAndGetAccountType(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals(AccountType.AUTHOR, DataLoader.getUsers().get(0).getType());
    }
    //Adding one user, get birthday
    @Test
    public void testWritingOneUserAndGetBirthday(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("10/02/2023", DataLoader.getUsers().get(0).getBirthday());
    }
    //Adding six users, get 3rd user's username
    @Test
    public void testWritingSixUsersAndGetUsername(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.STUDENT));
        users.add(new User("Kim","Nguyen","kNguyen@email.com",new Date(10/03/1960), "kNguyen", "foodieForLife",AccountType.AUTHOR));
        users.add(new User("Bill", "Dennis", "bdennis@gmail.com", new Date(01/12/2000), "bdennis", "DogLover3498", AccountType.AUTHOR));
        users.add(new User("Kyle","Smith","kSmith@email.com",new Date(02/03/2000), "kSmith", "KyleSmith28304",AccountType.STUDENT));
        users.add(new User("Megan","Brook","mbrook@email.com",new Date(11/07/2002), "Mbrook", "simbaRules981734",AccountType.AUTHOR));
        users.add(new User("Quynh","Phan","Qphan@email.com",new Date(03/03/2002), "QPhan", "passwordsRweird",AccountType.STUDENT));
        DataWriter.saveUsers();
        assertEquals("kSmith", DataLoader.getUsers().get(3).getUsername());
    }
    //Adding six users, get 3rd user's password
    @Test
    public void testWritingSixUsersAndGetPassword(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.STUDENT));
        users.add(new User("Kim","Nguyen","kNguyen@email.com",new Date(10/03/1960), "kNguyen", "foodieForLife",AccountType.AUTHOR));
        users.add(new User("Bill", "Dennis", "bdennis@gmail.com", new Date(01/12/2000), "bdennis", "DogLover3498", AccountType.AUTHOR));
        users.add(new User("Kyle","Smith","kSmith@email.com",new Date(02/03/2000), "kSmith", "KyleSmith28304",AccountType.STUDENT));
        users.add(new User("Megan","Brook","mbrook@email.com",new Date(11/07/2002), "Mbrook", "simbaRules981734",AccountType.AUTHOR));
        users.add(new User("Quynh","Phan","Qphan@email.com",new Date(03/03/2002), "QPhan", "passwordsRweird",AccountType.STUDENT));
        DataWriter.saveUsers();
        assertEquals("KyleSmith28304", DataLoader.getUsers().get(3).getPassword());
    }
    //Adding six users, get 3rd user's first name
    @Test
    public void testWritingSixUsersAndGetFirstName(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.STUDENT));
        users.add(new User("Kim","Nguyen","kNguyen@email.com",new Date(10/03/1960), "kNguyen", "foodieForLife",AccountType.AUTHOR));
        users.add(new User("Bill", "Dennis", "bdennis@gmail.com", new Date(01/12/2000), "bdennis", "DogLover3498", AccountType.AUTHOR));
        users.add(new User("Kyle","Smith","kSmith@email.com",new Date(02/03/2000), "kSmith", "KyleSmith28304",AccountType.STUDENT));
        users.add(new User("Megan","Brook","mbrook@email.com",new Date(11/07/2002), "Mbrook", "simbaRules981734",AccountType.AUTHOR));
        users.add(new User("Quynh","Phan","Qphan@email.com",new Date(03/03/2002), "QPhan", "passwordsRweird",AccountType.STUDENT));
        DataWriter.saveUsers();
        assertEquals("Kyle", DataLoader.getUsers().get(3).getFirstName());
    }
    //Adding six users, get 3rd user's last name
    @Test
    public void testWritingSixUsersAndGetLastName(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.STUDENT));
        users.add(new User("Kim","Nguyen","kNguyen@email.com",new Date(10/03/1960), "kNguyen", "foodieForLife",AccountType.AUTHOR));
        users.add(new User("Bill", "Dennis", "bdennis@gmail.com", new Date(01/12/2000), "bdennis", "DogLover3498", AccountType.AUTHOR));
        users.add(new User("Kyle","Smith","kSmith@email.com",new Date(02/03/2000), "kSmith", "KyleSmith28304",AccountType.STUDENT));
        users.add(new User("Megan","Brook","mbrook@email.com",new Date(11/07/2002), "Mbrook", "simbaRules981734",AccountType.AUTHOR));
        users.add(new User("Quynh","Phan","Qphan@email.com",new Date(03/03/2002), "QPhan", "passwordsRweird",AccountType.STUDENT));
        DataWriter.saveUsers();
        assertEquals("Smith", DataLoader.getUsers().get(3).getLastName());
    }
    //Adding six users, get 3rd user's email
    @Test
    public void testWritingSixUsersAndGetEmail(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.STUDENT));
        users.add(new User("Kim","Nguyen","kNguyen@email.com",new Date(10/03/1960), "kNguyen", "foodieForLife",AccountType.AUTHOR));
        users.add(new User("Bill", "Dennis", "bdennis@gmail.com", new Date(01/12/2000), "bdennis", "DogLover3498", AccountType.AUTHOR));
        users.add(new User("Kyle","Smith","kSmith@email.com",new Date(02/03/2000), "kSmith", "KyleSmith28304",AccountType.STUDENT));
        users.add(new User("Megan","Brook","mbrook@email.com",new Date(11/07/2002), "Mbrook", "simbaRules981734",AccountType.AUTHOR));
        users.add(new User("Quynh","Phan","Qphan@email.com",new Date(03/03/2002), "QPhan", "passwordsRweird",AccountType.STUDENT));
        DataWriter.saveUsers();
        assertEquals("kSmith@email.com", DataLoader.getUsers().get(3).getEmail());
    }
    //Adding six users, get 3rd user's birthday
    @Test
    public void testWritingSixUsersAndGetBirthday(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.STUDENT));
        users.add(new User("Kim","Nguyen","kNguyen@email.com",new Date(10/03/1960), "kNguyen", "foodieForLife",AccountType.AUTHOR));
        users.add(new User("Bill", "Dennis", "bdennis@gmail.com", new Date(01/12/2000), "bdennis", "DogLover3498", AccountType.AUTHOR));
        users.add(new User("Kyle","Smith","kSmith@email.com",new Date(02/03/2000), "kSmith", "KyleSmith28304",AccountType.STUDENT));
        users.add(new User("Megan","Brook","mbrook@email.com",new Date(11/07/2002), "Mbrook", "simbaRules981734",AccountType.AUTHOR));
        users.add(new User("Quynh","Phan","Qphan@email.com",new Date(03/03/2002), "QPhan", "passwordsRweird",AccountType.STUDENT));
        DataWriter.saveUsers();
        assertEquals("02/03/2000", DataLoader.getUsers().get(3).getBirthday());
    }
    //Adding six users, get 3rd user's account type
    @Test
    public void testWritingSixUsersAndGetAccountType(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.STUDENT));
        users.add(new User("Kim","Nguyen","kNguyen@email.com",new Date(10/03/1960), "kNguyen", "foodieForLife",AccountType.AUTHOR));
        users.add(new User("Bill", "Dennis", "bdennis@gmail.com", new Date(01/12/2000), "bdennis", "DogLover3498", AccountType.AUTHOR));
        users.add(new User("Kyle","Smith","kSmith@email.com",new Date(02/03/2000), "kSmith", "KyleSmith28304",AccountType.STUDENT));
        users.add(new User("Megan","Brook","mbrook@email.com",new Date(11/07/2002), "Mbrook", "simbaRules981734",AccountType.AUTHOR));
        users.add(new User("Quynh","Phan","Qphan@email.com",new Date(03/03/2002), "QPhan", "passwordsRweird",AccountType.STUDENT));
        DataWriter.saveUsers();
        assertEquals(AccountType.STUDENT, DataLoader.getUsers().get(3).getType());
    }
    //Add empty user, get username
    @Test
    public void testWritingEmptyUserAndGetUsername(){
        users.add(new User("", "", "", new Date(), "", "", AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.getUsers().get(0).getUsername());
    }
    //Add empty user, get password
    @Test
    public void testWritingEmptyUserAndGetPassword(){
        users.add(new User("", "", "", new Date(), "", "", AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.getUsers().get(0).getPassword());
    }
    //Add empty user, get first name
    @Test
    public void testWritingEmptyUserAndGetFirstName(){
        users.add(new User("", "", "", new Date(), "", "", AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.getUsers().get(0).getFirstName());
    }
    //Add empty user, get last name
    @Test
    public void testWritingEmptyUserAndGetLastName(){
        users.add(new User("", "", "", new Date(), "", "", AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.getUsers().get(0).getLastName());
    }
    //Add empty user, get email
    @Test
    public void testWritingEmptyUserAndGetEmail(){
        users.add(new User("", "", "", new Date(), "", "", AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.getUsers().get(0).getEmail());
    }
    //Add empty user, get birthday
    @Test
    public void testWritingEmptyUserAndGetBirthday(){
        users.add(new User("", "", "", new Date(), "", "", AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getBirthday());
    }
    //Add empty user, get account type
    @Test
    public void testWritingEmptyUserAndGetAccountType(){
        users.add(new User("", "", "", new Date(), "", "", AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals(AccountType.AUTHOR, DataLoader.getUsers().get(0).getType());
    }
    //add null user, get username
    @Test
    public void testWritingNullUserAndGetUsername(){
        users.add(new User(null, null, null, new Date(), null, null, AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getUsername());
    }
    //add null user, get password
    //add null user, get first name
    //add null user, get last name
    //add null user, get email
    //add null user, get birthday
    //add null user, get account type
    //Getting course json size
    @Test
    public void testWritingZeroCourses(){
        courses = DataLoader.getCourses();
        assertEquals(0, courseList.size());
    }
    //Adding one course, get title
    @Test
    public void testWritingOneCourse(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("When to Use Classes: Variables", "A class is used when you have an object that has several traits.", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("Variables", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        UUID author = UUID.randomUUID();
        courses.add(new Course(author, "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
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
    public void testWritingZeroFAQs() {
		faqs = DataLoader.getFAQs();
		assertEquals(0, faqList.size());
	}
    //Adding one faq, get question
    @Test
    public void testWritingOneFAQ(){
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
