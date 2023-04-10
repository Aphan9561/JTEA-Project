import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();
    private CourseList courseList = CourseList.getInstance();
    private ArrayList<Course> courses = courseList.getAllCourses();

    @BeforeEach
    public void setup() {
        users.clear();
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.AUTHOR));
        UUID randomID = UUID.fromString("3e8a2a51-4dad-482f-9ca4-0fe615e979b0");
        users.add(new User(randomID, "Kim","Nguyen","kNguyen@email.com",new Date(10/03/1960), "kNguyen", "foodieForLife",AccountType.AUTHOR));
        users.add(new User(null, null, null, new Date(), null, null, AccountType.AUTHOR));
        DataWriter.saveUsers();
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        ArrayList<String> answers2 = new ArrayList<String>();
        answers2.add("print(“Hello World”)");
        answers2.add("System.out.println(“Hello World”);");
        answers2.add("cout << “Hello World”");
        answers2.add("print(“Hello World);");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        Question question2 = new Question("How do you print “Hello World”in python?",answers2,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        ArrayList<Question> questions2 = new ArrayList<Question>();
        questions2.add(question2);
        Quiz quiz = new Quiz(questions);
        Quiz quiz2 = new Quiz(questions2);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
        Lesson lesson2 = new Lesson("Printing in python is when you print to the terminal or console so the user can see. You would use the command print().","Printing", quiz2);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        ArrayList<Lesson> lessons2 = new ArrayList<Lesson>();
        lessons2.add(lesson2);
        Module module = new Module("Variables", lessons);
        Module module2 = new Module("Python Basic", lessons2);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        ArrayList<Module> modules2 = new ArrayList<Module>();
        modules2.add(module2);
        courses.add(new Course(UUID.randomUUID(), "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
        courses.add(new Course(UUID.fromString("5a118dcd-901e-43c3-b153-c67b2a2448d9"), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        courses.add(new Course(UUID.randomUUID(), null, null, null, Difficulty.EASY, Language.GITHUB, new ArrayList<Module>()));
        ArrayList<String> answersNull = new ArrayList<String>();
        answersNull.add("");
        Question questionNull = new Question("",answersNull,0);
        ArrayList<Question> questionsNull = new ArrayList<Question>();
        questionsNull.add(questionNull);
        Quiz quizNull = new Quiz(questionsNull);
        Lesson lessonNull = new Lesson("","", quizNull);
        ArrayList<Lesson> lessonsNull = new ArrayList<Lesson>();
        lessonsNull.add(lessonNull);
        Module moduleNull = new Module("", lessonsNull);
        ArrayList<Module> modulesNull = new ArrayList<Module>();
        modulesNull.add(moduleNull);
        courses.add(new Course(UUID.randomUUID(), "", "", "", Difficulty.EASY, Language.PYTHON, modulesNull));
        DataWriter.saveCourses();

    }

    @AfterEach
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        CourseList.getInstance().getAllCourses().clear();
        DataWriter.saveCourses();
        FAQList.getInstance().getFAQ().clear();
        DataWriter.saveFAQs();
    }

    //test get users size
    @Test
    void testGetUsersSize() {
        users = DataLoader.getUsers();
        assertEquals(3, userList.size());
    }

    //test get users size 0
    @Test
    void testGetUsersSizeZero() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0, userList.size());
    }

    //test get user id
    @Test
    void testGetUserID() {
        users = DataLoader.getUsers();
        UUID randomIDUser2 = UUID.fromString("3e8a2a51-4dad-482f-9ca4-0fe615e979b0");
        assertEquals(randomIDUser2, users.get(1).getId());
    }

    //test get user null id
    @Test
    void testGetUserIDNull() {
        users = DataLoader.getUsers();
        assertEquals(null, users.get(2).getId());
    }

    //test get user valid firstName
    @Test
    void testGetUserFirstName() {
        users = DataLoader.getUsers();
        assertEquals("Anne", users.get(0).getFirstName());
    }

    //test get user null firstName
    @Test
    void testGetUserFirstNameNull() {
        users = DataLoader.getUsers();
        assertEquals(null, users.get(2).getFirstName());
    }

    //test get user valid lastName
    @Test
    void testGetUserLastName() {
        users = DataLoader.getUsers();
        assertEquals("Dennis", users.get(0).getLastName());
    }

    //test get user null lastName
    @Test
    void testGetUserLastNameNull() {
        users = DataLoader.getUsers();
        assertEquals(null, users.get(2).getLastName());
    }

    //test get user valid email
    @Test
    void testGetUserEmail() {
        users = DataLoader.getUsers();
        assertEquals("ADen@email.com", users.get(0).getEmail());
    }

    //test get user null email
    @Test
    void testGetUserEmailNull() {
        users = DataLoader.getUsers();
        assertEquals(null, users.get(2).getEmail());
    }

    //test get user valid birthday
    @Test
    void testGetUserBirthday() {
        users = DataLoader.getUsers();
        assertEquals(new Date(10/02/2023), users.get(0).getBirthday());
    }

    //test get user null birthday
    @Test
    void testGetUserBirthdayNull() {
        users = DataLoader.getUsers();
        assertEquals(null, users.get(2).getBirthday());
    }

    //test get user wrong format birthday
    /*
    @Test
    void testGetUserBirthdayWrongFormat() {
        users = DataLoader.getUsers();
        users.add(new User(UUID.fromString("c0bef27c-9eb4-4d16-bd3e-10cf8d9c1e57"), "Bill", "Dennis", "bdennis@gmail.com", new Date(01/12/2000), "bdennis", "DogLover3498", AccountType.AUTHOR));
        assertEquals(new Date(10/02/2023), users.get(2).getEmail());
    }*/

    //test get user valid username
    @Test
    void testGetUserUsername() {
        users = DataLoader.getUsers();
        assertEquals("adennis2", users.get(0).getUsername());
    }

    //test get user null username
    @Test
    void testGetUserUsernameNull() {
        users = DataLoader.getUsers();
        assertEquals(null, users.get(2).getUsername());
    }

    //test get user valid password
    @Test
    void testGetUserPassword() {
        users = DataLoader.getUsers();
        assertEquals("catsForLife", users.get(0).getPassword());
    }

    //test get user null password
    @Test
    void testGetUserPasswordNull() {
        users = DataLoader.getUsers();
        assertEquals(null, users.get(2).getPassword());
    }

    //test get user valid type
    @Test
    void testGetUserType() {
        users = DataLoader.getUsers();
        assertEquals(AccountType.AUTHOR, users.get(0).getType());
    }

    //test get user null type

    //test get user unknown type
    @Test
    void testGetUserTypeUnknown() {
        users = DataLoader.getUsers();
        users.add(new User(null, null, null, new Date(), null, null, AccountType.valueOf("")));
        assertEquals(AccountType.STUDENT, users.get(3).getType());
    }

    //test get courses size
    @Test
    void testGetCoursesSize() {
        courses = DataLoader.getCourses();
        assertEquals(2, courseList.size());
    }

    //test get courses size 0
    @Test
    void testGetCoursesSizeZero() {
        CourseList.getInstance().getAllCourses().clear();
        DataWriter.saveCourses();
        assertEquals(0, courseList.size());
    }

    @Test
    void testGetCourseID() {
        courses = DataLoader.getCourses();
        assertEquals(UUID.fromString("5a118dcd-901e-43c3-b153-c67b2a2448d9"), courses.get(1).getId());
    }

    /*
    @Test
    void testGetCourseIDNull() {
        users = DataLoader.getUsers();
        assertEquals(null, users.get(2).getId());
    }*/

    @Test
    void testGetCourseDifficulty() {
        courses = DataLoader.getCourses();
        assertEquals(Difficulty.MEDIUM, courses.get(0).getDifficulty());
    }

    @Test
    void testGetCourseDifficultyUnknown() {
        courses = DataLoader.getCourses();
        courses.add(new Course(null, null, null, null, Difficulty.valueOf("unknown"), Language.valueOf("unknown"), null));
        assertEquals(Difficulty.EASY, courses.get(3).getDifficulty());
    }

    @Test
    void testGetCourseLanguage() {
        courses = DataLoader.getCourses();
        assertEquals(Language.PYTHON, courses.get(0).getLanguage());
    }

    @Test
    void testGetCourseLanguageUnknown() {
        courses = DataLoader.getCourses();
        courses.add(new Course(null, null, null, null, Difficulty.valueOf("unknown"), Language.valueOf("unknown"), null));
        assertEquals(Language.GITHUB, courses.get(3).getDifficulty());
    }

    @Test
    void testGetCourseName() {
        courses = DataLoader.getCourses();
        assertEquals("Classes for Beginners", courses.get(0).getTitle());
    }

    @Test
    void testGetCourseNameNull() {
        courses = DataLoader.getCourses();
        assertEquals(null, courses.get(2).getTitle());
    }

    @Test
    void testGetCourseDescription() {
        courses = DataLoader.getCourses();
        assertEquals("Teaches how to create a class with variables and methods, then describes when to use a class.", courses.get(0).getDesciption());
    }

    @Test
    void testGetCourseDescriptionNull() {
        courses = DataLoader.getCourses();
        assertEquals(null, courses.get(2).getDesciption());
    }

    @Test
    void testGetCourseSyllabus() {
        courses = DataLoader.getCourses();
        assertEquals("Module 1: Variables, Module 2: Methods, Module: When to Use Classes", courses.get(0).getSyllabus());
    }

    @Test
    void testGetCourseSyllabusNull() {
        courses = DataLoader.getCourses();
        assertEquals(null, courses.get(2).getSyllabus());
    }

    

    //test get FAQs size


    //test get FAQs size 0


    
}
