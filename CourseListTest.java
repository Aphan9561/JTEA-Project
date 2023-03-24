import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseListTest {
    private Course course = Course.getInstance();
    private static ArrayList<Module> module;
    private static ArrayList<Lesson> lesson;
    private static ArrayList<Question> quiz;
    //private static CourseList courseList;
    private ArrayList<Course> courseList = courses.getCourses();

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
        ArrayList<Question> questions;
        ArrayList<Question> questions2;
        questions.add(question);
        questions2.add(question2);
        Quiz quiz = new Quiz(questions);
        Quiz quiz2 = new Quiz(questions2);
        Lesson lesson = new Lesson("First Content", "First Lesson", quiz);
        Lesson lesson2 = new Lesson("Second Content", "First Lesson", quiz);
        ArrayList<Lesson> lessons;
        lessons.add(lesson);
        Module module = new Module("First Module title", lessons);
        ArrayList<Module> modules;
        modules.add(module);
		courseList.add(new Course(1,"Test1", "The first test", "First syllabus", "easy", "python", modules));
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		Course.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testHaveUserValidFirstItem() {
		boolean hasAmy = course.hasCourse("asmith");
		assertTrue(hasAmy);
	}
	
	@Test
	void testHaveUserValidLastItem() {
		boolean hasBob = course.hasCourse("bwhite");
		assertTrue(hasBob);
	}
	
	@Test
	void testHaveUserInValid() {
		boolean hasJoe = course.hasCourse("jsmith");
		assertFalse(hasJoe);
	}
	
	@Test
	void testHaveUserEmpty() {
		boolean hasEmpty = course.hasCourse("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveUserNull() {
		boolean hasNull = course.hasCourse(null);
		assertFalse(hasNull);
	}


}
