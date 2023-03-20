import java.util.ArrayList;

/*
 * This is a module that holds lessons
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

 public class Module{
    private ArrayList<Lesson> Lesson;
    private ArrayList<Quiz> quiz;
    private ArrayList<Comment> comment;
    private String title;

    public Module(String title, ArrayList<Lesson> Lesson) {
        this.title = title;
        this.Lesson = Lesson;
    }

    public String getTitle(){
        return title;
    }

    public Lesson getCurrentLesson(int position) {
        return Lesson.get(position); 
    }

    public Quiz getQuiz(int index){
        return quiz.get(index);
    }

    public Comment getComment(int index){
        return comment.get(index);
    }
 }