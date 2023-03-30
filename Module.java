import java.util.ArrayList;

/**
 * This is a module that holds lessons
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

public class Module {
    private ArrayList<Lesson> lessons = new ArrayList<Lesson>();
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private String title;

    /**
     * Creates a new module
     * @param title module title
     * @param lessons lessons in module
     */
    public Module(String title, ArrayList<Lesson> lessons) {
        this.title = title;
        setLesson(lessons);
    }

    /**
     * Creats a new module
     * @param name module title
     * @param lessons
     * @param comments
     */
    public Module(String name, ArrayList<Lesson> lessons, ArrayList<Comment> comments) {
        title = name;
        this.lessons.addAll(lessons);
        this.comments.addAll(comments);
    }
    /**
     * gets the title of th e module
     * @return module title
     */
    public String getTitle() {
        return title;
    }
    /**
     * gets the lessons in the module
     * @return module lessons
     */
    public ArrayList<Lesson> getLesson() {
        return lessons;
    }
    /**
     * set the lessons to the module
     * @param lessons lessons
     */
    public void setLesson(ArrayList<Lesson> lessons) {
        this.lessons.addAll(lessons);
    }
    /**
     * get lesson accordinf to it's place in the arraylist
     * @param index lesson position
     * @return lesson in that position
     */
    public Lesson getLesson(int index) {
        return lessons.get(index); 
    }
    /**
     * get number of lessons in module
     * @return number of lessons
     */
    public int getNumberOfLessons() {
        return lessons.size();
    }
    /**
     * adds a lesson to the module
     * @param content lesson content
     * @param title lesson title
     * @param quiz lesson quiz
     */
    public void addLesson(String content, String title, Quiz quiz) {
        Lesson lesson = new Lesson(content, title, quiz);
        lessons.add(lesson);
    }
    /**
     * get the comments in module
     * @return comments
     */
    public ArrayList<Comment> getComment() {
        return comments;
    }
    /**
     * Creates a string representation of the lesson
     */
    public String toString() {
        String result = "Title: " + title + "\n";
        result += "Lessons:\n";
        for (Lesson lesson : lessons) {
            result += lesson;
            System.out.println("Added lesson");
        }
        result += "Comments: \n";
        for (Comment comment : comments) {
            result += comment;
        }
        result += "\n";
        return result;
    }
    /**
     * Lesson infomation
     * @return lesson
     */
    public String fileInfo() {
        String result = "Title: " + title + "\n";
        result += "Lessons:\n";
        for (int i = 0; i < lessons.size(); i++) {
            result += lessons.get(i).miniToString();
        }
        return result;
    }
}