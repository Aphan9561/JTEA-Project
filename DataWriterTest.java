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
    //Adding six users, get 4th user's username
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
    //Adding six users, get 4th user's password
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
    //Adding six users, get 4th user's first name
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
    //Adding six users, get 4th user's last name
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
    //Adding six users, get 4th user's email
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
    //Adding six users, get 4th user's birthday
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
    //Adding six users, get 4th user's account type
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
        assertEquals("", DataLoader.getUsers().get(0).getBirthday());
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
    @Test
    public void testWritingNullUserAndGetPassword(){
        users.add(new User(null, null, null, new Date(), null, null, AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getPassword());
    }
    //add null user, get first name
    @Test
    public void testWritingNullUserAndGetFirstName(){
        users.add(new User(null, null, null, new Date(), null, null, AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getFirstName());
    }
    //add null user, get last name
    @Test
    public void testWritingNullUserAndGetLastName(){
        users.add(new User(null, null, null, new Date(), null, null, AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getLastName());
    }
    //add null user, get email
    @Test
    public void testWritingNullUserAndGetEmail(){
        users.add(new User(null, null, null, new Date(), null, null, AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getEmail());
    }
    //add null user, get birthday
    @Test
    public void testWritingNullUserAndGetBirthday(){
        users.add(new User(null, null, null, new Date(), null, null, AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getBirthday());
    }
    //add null user, get account type
    @Test
    public void testWritingNullUserAndGetAccountType(){
        users.add(new User(null, null, null, new Date(), null, null, AccountType.AUTHOR));
        DataWriter.saveUsers();
        assertEquals(AccountType.AUTHOR, DataLoader.getUsers().get(0).getType());
    }
    //Getting course json size
    @Test
    public void testWritingZeroCourses(){
        courses = DataLoader.getCourses();
        assertEquals(0, courseList.size());
    }
    //Adding one course, get title
    @Test
    public void testWritingOneCourseAndGetTitle(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
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
    @Test
    public void testWritingOneCourseAndGetDescription(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("Variables", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        UUID author = UUID.randomUUID();
        courses.add(new Course(author, "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("Teaches how to create a class with variables and methods, then describes when to use a class.",DataLoader.getCourses().get(0).getDesciption());
    }
    //Adding one course, get syllabus
    @Test
    public void testWritingOneCourseAndGetSyllabus(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("Variables", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        UUID author = UUID.randomUUID();
        courses.add(new Course(author, "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("Module 1: Variables, Module 2: Methods, Module: When to Use Classes",DataLoader.getCourses().get(0).getSyllabus());
    }
    //Adding one course, get difficulty
    @Test
    public void testWritingOneCourseAndGetDifficulty(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("Variables", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        UUID author = UUID.randomUUID();
        courses.add(new Course(author, "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(Difficulty.MEDIUM,DataLoader.getCourses().get(0).getDifficulty());
    }
    //Adding one course, get language
    @Test
    public void testWritingOneCourseAndGetLanguage(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("Variables", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        UUID author = UUID.randomUUID();
        courses.add(new Course(author, "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(Language.PYTHON,DataLoader.getCourses().get(0).getLanguage());
    }
    //Adding one course, get module title
    @Test
    public void testWritingOneCourseAndGetModuleTitle(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("Variables", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        UUID author = UUID.randomUUID();
        courses.add(new Course(author, "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("Variables",DataLoader.getCourses().get(0).getModule().get(0).getTitle());
    }
    //Adding one course, get lesson title
    @Test
    public void testWritingOneCourseAndGetLessonTitle(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("Variables", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        UUID author = UUID.randomUUID();
        courses.add(new Course(author, "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("When to Use Classes: Variables",DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getTitle());
    }
    //Adding one course, get lesson content
    @Test
    public void testWritingOneCourseAndGetLessonContent(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("Variables", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        UUID author = UUID.randomUUID();
        courses.add(new Course(author, "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("A class is used when you have an object that has several traits.",DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getContent());
    }
    //Adding one course, get quiz question
    @Test
    public void testWritingOneCourseAndGetQuizQuestion(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("Variables", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        UUID author = UUID.randomUUID();
        courses.add(new Course(author, "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("What would be a variable for a Cat class?",DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getQuiz().getQuestion().get(0).getQuestion());
    }
    //Adding one course, get quiz correct answer
    @Test
    public void testWritingOneCourseAndGetQuizCorrectAnswer(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("name");
        answers.add("street");
        answers.add("price");
        answers.add("build time");
        Question question = new Question("What would be a variable for a Cat class?",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("A class is used when you have an object that has several traits.","When to Use Classes: Variables", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("Variables", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        UUID author = UUID.randomUUID();
        courses.add(new Course(author, "Classes for Beginners", "Teaches how to create a class with variables and methods, then describes when to use a class.", "Module 1: Variables, Module 2: Methods, Module: When to Use Classes", Difficulty.MEDIUM, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(0,DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getQuiz().getQuestion().get(0).getCorrectAnswer());
    }
    //Adding two course, get 2nd course title
    @Test
    public void testWritingTwoCourseAndGetTitle(){
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
        Question question2 = new Question("How do you print “Hello World”in python? ",answers2,0);
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
        courses.add(new Course(UUID.randomUUID(), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        DataWriter.saveCourses();
        assertEquals("Zero to Hero: Python Bootcamp",DataLoader.getCourses().get(1).getTitle());
    }
    //Adding two course, get 2nd course description
    @Test
    public void testWritingTwoCourseAndGetDescription(){
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
        Question question2 = new Question("How do you print “Hello World”in python? ",answers2,0);
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
        courses.add(new Course(UUID.randomUUID(), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        DataWriter.saveCourses();
        assertEquals("Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!",DataLoader.getCourses().get(1).getDesciption());
    }
    //Adding two course, get 2nd course syllabus
    @Test
    public void testWritingTwoCourseAndGetSyllabus(){
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
        Question question2 = new Question("How do you print “Hello World”in python? ",answers2,0);
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
        courses.add(new Course(UUID.randomUUID(), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        DataWriter.saveCourses();
        assertEquals("Module 1: Python Basic.",DataLoader.getCourses().get(1).getSyllabus());
    }
    //Adding two course, get 2nd course difficulty
    @Test
    public void testWritingTwoCourseAndGetDifficulty(){
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
        Question question2 = new Question("How do you print “Hello World”in python? ",answers2,0);
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
        courses.add(new Course(UUID.randomUUID(), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        DataWriter.saveCourses();
        assertEquals(Difficulty.EASY,DataLoader.getCourses().get(1).getDifficulty());
    }
    //Adding two course, get 2nd course language
    @Test
    public void testWritingTwoCourseAndGetLanguage(){
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
        Question question2 = new Question("How do you print “Hello World”in python? ",answers2,0);
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
        courses.add(new Course(UUID.randomUUID(), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        DataWriter.saveCourses();
        assertEquals(Language.PYTHON,DataLoader.getCourses().get(1).getLanguage());
    }
    //Adding two course, get 2nd module title
    @Test
    public void testWritingTwoCourseAndGetModuleTitle(){
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
        Question question2 = new Question("How do you print “Hello World”in python? ",answers2,0);
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
        courses.add(new Course(UUID.randomUUID(), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        DataWriter.saveCourses();
        assertEquals("Python Basic",DataLoader.getCourses().get(1).getModule().get(0).getTitle());
    }
    //Adding two course, get 2nd lesson title
    @Test
    public void testWritingTwoCourseAndGetLessonTitle(){
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
        Question question2 = new Question("How do you print “Hello World”in python? ",answers2,0);
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
        courses.add(new Course(UUID.randomUUID(), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        DataWriter.saveCourses();
        assertEquals("Printing",DataLoader.getCourses().get(1).getModule().get(0).getLesson().get(0).getTitle());
    }
    //Adding two course, get 2nd lesson content
    @Test
    public void testWritingTwoCourseAndGetLessonContent(){
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
        Question question2 = new Question("How do you print “Hello World”in python? ",answers2,0);
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
        courses.add(new Course(UUID.randomUUID(), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        DataWriter.saveCourses();
        assertEquals("Printing in python is when you print to the terminal or console so the user can see. You would use the command print().",DataLoader.getCourses().get(1).getModule().get(0).getLesson().get(0).getContent());
    }
    //Adding two course, get 2nd quiz question
    @Test
    public void testWritingTwoCourseAndGetQuizQuestion(){
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
        courses.add(new Course(UUID.randomUUID(), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        DataWriter.saveCourses();
        assertEquals("How do you print “Hello World”in python?",DataLoader.getCourses().get(1).getModule().get(0).getLesson().get(0).getQuiz().getQuestion().get(0).getQuestion());
    }
    //Adding two course, get 2nd quiz correct answer
    @Test
    public void testWritingTwoCourseAndGetQuizCorrectAnswer(){
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
        courses.add(new Course(UUID.randomUUID(), "Zero to Hero: Python Bootcamp", "Learning Python like a Professional Start from the basics and go all the way to creating your own applications and games!", "Module 1: Python Basic.", Difficulty.EASY, Language.PYTHON, modules2));
        DataWriter.saveCourses();
        assertEquals(0,DataLoader.getCourses().get(1).getModule().get(0).getLesson().get(0).getQuiz().getQuestion().get(0).getCorrectAnswer());
    }
    //Add empty course, get title
    @Test
    public void testWritingEmptyCourseAndGetTitle(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("");
        Question question = new Question("",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("","", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), "", "", "", Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("",DataLoader.getCourses().get(0).getTitle());
    }
    //Add empty course, get description
    @Test
    public void testWritingEmptyCourseAndGetDescription(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("");
        Question question = new Question("",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("","", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), "", "", "", Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("",DataLoader.getCourses().get(0).getDesciption());
    }
    //Add empty course, get syllabus
    @Test
    public void testWritingEmptyCourseAndGetSyllabus(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("");
        Question question = new Question("",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("","", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), "", "", "", Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("",DataLoader.getCourses().get(0).getSyllabus());
    }
    //Add empty course, get module title
    @Test
    public void testWritingEmptyCourseAndGetModuleTitle(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("");
        Question question = new Question("",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("","", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), "", "", "", Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("",DataLoader.getCourses().get(0).getModule().get(0).getTitle());
    }
    //Add empty course, get lesson title
    @Test
    public void testWritingEmptyCourseAndGetLessonTitle(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("");
        Question question = new Question("",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("","", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), "", "", "", Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("",DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getTitle());
    }
    //Add empty course, get lesson content
    @Test
    public void testWritingEmptyCourseAndGetLessonContent(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("");
        Question question = new Question("",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("","", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), "", "", "", Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("",DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getContent());
    }
    //Add empty course, get quiz question
    @Test
    public void testWritingEmptyCourseAndGetQuizQuesiton(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("");
        Question question = new Question("",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("","", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), "", "", "", Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals("",DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getQuiz().getQuestion().get(0).getQuestion());
    }
    //Add empty course, get quiz correct answer
    @Test
    public void testWritingEmptyCourseAndGetQuizCorrectAnswer(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("");
        Question question = new Question("",answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson("","", quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), "", "", "", Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(0,DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getQuiz().getQuestion().get(0).getCorrectAnswer());
    }
    //add null course, get title
    @Test
    public void testWritingNullCourseAndGetTitle(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(null);
        Question question = new Question(null,answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson(null,null, quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), null, null, null, Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(null, DataLoader.getCourses().get(0).getTitle());
    }
    //add null course, get description
    @Test
    public void testWritingNullCourseAndGetDescription(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(null);
        Question question = new Question(null,answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson(null,null, quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), null, null, null, Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(null, DataLoader.getCourses().get(0).getDesciption());
    }
    //add null course, get syllabus
    @Test
    public void testWritingNullCourseAndGetSyllabus(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(null);
        Question question = new Question(null,answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson(null,null, quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), null, null, null, Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(null, DataLoader.getCourses().get(0).getSyllabus());
    }
    //add null course, get module title
    @Test
    public void testWritingNullCourseAndGetModuleTitle(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(null);
        Question question = new Question(null,answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson(null,null, quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module(null, lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), null, null, null, Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(null, DataLoader.getCourses().get(0).getModule().get(0).getTitle());
    }
    //add null course, get lesson title
    @Test
    public void testWritingNullCourseAndGetLessonTitle(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(null);
        Question question = new Question(null,answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson(null,null, quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), null, null, null, Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(null, DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getTitle());
    }
    //add null course, get lesson content
    @Test
    public void testWritingNullCourseAndGetLessonContent(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(null);
        Question question = new Question(null,answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson(null,null, quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), null, null, null, Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(null, DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getContent());
    }
    //add null course, get quiz question
    @Test
    public void testWritingNullCourseAndGetQuizQuestion(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(null);
        Question question = new Question(null,answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson(null,null, quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), null, null, null, Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(null, DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getQuiz().getQuestion().get(0).getQuestion());
    }
    //add null course, get quiz correct answer
    @Test
    public void testWritingNullCourseAndGetQuizCorrectAnswer(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(null);
        Question question = new Question(null,answers,0);
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson(null,null, quiz);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module module = new Module("", lessons);
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module);
        courses.add(new Course(UUID.randomUUID(), null, null, null, Difficulty.EASY, Language.PYTHON, modules));
        DataWriter.saveCourses();
        assertEquals(0, DataLoader.getCourses().get(0).getModule().get(0).getLesson().get(0).getQuiz().getQuestion().get(0).getCorrectAnswer());
    }
    //Getting FAQ json size
    @Test
    public void testWritingZeroFAQs() {
		faqs = DataLoader.getFAQs();
		assertEquals(0, faqList.size());
	}
    //Adding one faq, get question
    @Test
    public void testWritingOneFAQAndGetQuestion(){
        faqs.add(new FAQ("Would this course be helpful when interviewing with Google?", "Yes, Google likes to see that you understand object-oriented programming."));
        DataWriter.saveFAQs();
        assertEquals("Would this course be helpful when interviewing with Google?", DataLoader.getFAQs().get(0).getQuestion());
    }
    //Adding one faq, get answers
    @Test
    public void testWritingOneFAQAndGetAnswer(){
        faqs.add(new FAQ("Would this course be helpful when interviewing with Google?", "Yes, Google likes to see that you understand object-oriented programming."));
        DataWriter.saveFAQs();
        assertEquals("Yes, Google likes to see that you understand object-oriented programming.", DataLoader.getFAQs().get(0).getAnswers().get(0));
    }
    //Adding three FAQ, get 3rd faq question
    @Test
    public void testWritingThreeFAQAndGetQuestion(){
        faqs.add(new FAQ("Would this course be helpful when interviewing with Google?", "Yes, Google likes to see that you understand object-oriented programming."));
        faqs.add(new FAQ("How do I create a course on this platform?", "You would need to make an account as a author in order to create courses."));
        faqs.add(new FAQ("What languages does this system offer for courses", "We offer python, javaScript, and git."));
        DataWriter.saveFAQs();
        assertEquals("What languages does this system offer for courses",DataLoader.getFAQs().get(2).getQuestion());
    }
    //Adding three FAQ, get 3rd faq answer
    @Test
    public void testWritingThreeFAQAndGetAnswer(){
        faqs.add(new FAQ("Would this course be helpful when interviewing with Google?", "Yes, Google likes to see that you understand object-oriented programming."));
        faqs.add(new FAQ("How do I create a course on this platform?", "You would need to make an account as a author in order to create courses."));
        faqs.add(new FAQ("What languages does this system offer for courses", "We offer python, javaScript, and git."));
        DataWriter.saveFAQs();
        assertEquals("We offer python, javaScript, and git.",DataLoader.getFAQs().get(2).getAnswers().get(0));
    }
    //Add empty faq, get question
    @Test
    public void testWritingEmptyFAQAndGetQuestion(){
        faqs.add(new FAQ("",""));
        DataWriter.saveFAQs();
        assertEquals("",DataLoader.getFAQs().get(0).getQuestion());
    }
    //Add empty faq, get answer
    @Test
    public void testWritingEmptyFAQAndGetAnswer(){
        faqs.add(new FAQ("",""));
        DataWriter.saveFAQs();
        assertEquals("",DataLoader.getFAQs().get(0).getAnswers());
    }
    //add null faq, get question
    @Test
    public void testWritingNullFAQAndGetQuestion(){
        faqs.add(new FAQ(null,""));
        DataWriter.saveFAQs();
        assertEquals(null,DataLoader.getFAQs().get(0).getQuestion());
    }
    //add null faq, get answer
    @Test
    public void testWritingNullFAQAndGetAnswer(){
        String answer = null;
        faqs.add(new FAQ("", answer));
        DataWriter.saveFAQs();
        assertEquals(null,DataLoader.getFAQs().get(0).getAnswers().get(0));
    }
}
