import java.util.ArrayList;

/*
 * This is a lesson
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

public class Lesson {
    private String content;
    private String title;
    private ArrayList<Quiz> quiz = new ArrayList<Quiz>();

    public Lesson(String content, String title, ArrayList<Quiz> quizzes) {
        this.content = content;
        this.title = title;
        quiz.addAll(quizzes);
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public ArrayList<Quiz> getQuiz(){
        return quiz;
    }

    public String toString() {
        return this.title+"\n "+this.content;
    }
}