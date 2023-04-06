import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseListTest {
    private CourseList course = CourseList.getInstance();
    private static ArrayList<Module> module;
    private static ArrayList<Lesson> lesson;
    private static ArrayList<Question> quiz;
    //private static CourseList courseList;
    private ArrayList<Course> courseList = course.getAllCourses();

    @BeforeEach
	public void setup() {
		courseList.clear();
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("A");
        answers.add("B");
        answers.add("C");
        answers.add("D");
        Question question = new Question("First question", answers, 1);
        Question question2 = new Question("Second question", answers, 2);
        ArrayList<Question> questions = new ArrayList<Question>();
        ArrayList<Question> questions2 = new ArrayList<Question>();
        questions.add(question);
        questions2.add(question2);
        Quiz quiz = new Quiz(questions);
        Quiz quiz2 = new Quiz(questions2);
        Lesson lesson = new Lesson("First Content", "First Lesson", quiz);
        Lesson lesson2 = new Lesson("Second Content", "First Lesson", quiz2);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        ArrayList<Lesson> lessons2 = new ArrayList<Lesson>();
        lessons.add(lesson);
        lessons2.add(lesson2);
        Module module = new Module("First Module title", lessons);
        Module module2 = new Module("Second Module title", lessons2);
        ArrayList<Module> modules = new ArrayList<Module>();
        ArrayList<Module> modules2 = new ArrayList<Module>();
        modules.add(module);
        modules2.add(module2);
        UUID author = UUID.randomUUID();
		courseList.add(new Course(author,"Test1", "The first test", "First syllabus", Difficulty.EASY, Language.PYTHON, modules));
        courseList.add(new Course(author,"Test2", "The second test", "Second syllabus", Difficulty.EASY, Language.PYTHON, modules2));
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		CourseList.getInstance().getAllCourses().clear();
		DataWriter.saveUsers();
	}
	
	@Test
	void testHaveCourseValidFirstItem() {
		boolean hasTest = course.haveCourse("Test1");
		assertTrue(hasTest);
	}
	
	@Test
	void testHaveCourseValidLastItem() {
		boolean hasTest = course.haveCourse("Test2");
		assertTrue(hasTest);
	}
	
	@Test
	void testHaveCourseInValid() {
		boolean hasTest = course.haveCourse("Test4");
		assertFalse(hasTest);
	}
	
	@Test
	void testHaveCourseEmpty() {
		boolean hasEmpty = course.haveCourse("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveCourse() {
		boolean hasNull = course.haveCourse(null);
		assertFalse(hasNull);
	}


}
