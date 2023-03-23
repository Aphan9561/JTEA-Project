import java.util.ArrayList;

/*
 * This is a lesson
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

public class Lesson {
    private String content;
    private String title;
    private ArrayList<Quiz> quizzes = new ArrayList<Quiz>();

    public Lesson(String content, String title, ArrayList<Quiz> quizzes) {
        this.content = content;
        this.title = title;
        quizzes.addAll(quizzes);
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public ArrayList<Quiz> getQuiz(){
        return quizzes;
    }

    public String toString() {
        String result =  "Title: "+ this.title +
                        "\n***********\n" + this.content +
                        "\n***********\n";
        for(Quiz quiz : quizzes) {
            result += quiz;
        }
        result += "\n";
        return result;
    }
}