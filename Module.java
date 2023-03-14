import java.util.ArrayList;

/*
 * This is a module that holds lessons
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

 public class Module{
    private ArrayList<Lesson> Lesson;
    private String title;

    public Module(String title, ArrayList<Lesson> Lesson) {
        this.title = title;
        this.Lesson = Lesson;
    }

    public Lesson getCurrentLesson(int position) {
        return Lesson.get(position); 
    }
 }