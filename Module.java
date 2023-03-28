import java.util.ArrayList;

/**
 * This is a module that holds lessons
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

 public class Module{
    private ArrayList<Lesson> lessons = new ArrayList<Lesson>();
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private String title;

    public Module(String title, ArrayList<Lesson> lessons) {
        this.title = title;
        setLesson(lessons);
    }

    public Module(String name, ArrayList<Lesson> lessons, ArrayList<Comment> comments) {
        title = name;
        this.lessons.addAll(lessons);
        this.comments.addAll(comments);
    }

    public String getTitle(){
        return title;
    }

    public ArrayList<Lesson> getLesson() {
        return lessons; 
    }

    public void setLesson(ArrayList<Lesson> lessons){
        //this.lessons = lessons;
        this.lessons.addAll(lessons);
    }

    public Lesson getLesson(int index) {
        return lessons.get(index); 
    }

    public int getNumberOfLessons(){
        return lessons.size();
    }

    public void addLesson(String content, String title, Quiz quiz){
        Lesson lesson = new Lesson(content, title, quiz);
        lessons.add(lesson);
    }

    public ArrayList<Comment> getComment(){
        return comments;
    }

    public String toString() {
        String result = "Title: " + title + "\n";
        result += "Lessons:\n";
        for(Lesson lesson : lessons) {
            result += lesson;
            System.out.println("Added lesson");
        }
        result += "Comments: \n";
        for(Comment comment : comments) {
            result += comment;
        }
        result += "\n";
        return result;
    }
 }