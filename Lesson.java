import java.util.ArrayList;

/*
 * This is a lesson
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

public class Lesson {
    private String content;
    private String title;
    private Quiz quiz;

    public Lesson(String content, String title, Quiz quiz) {
        this.content = content;
        this.title = title;
        this.quiz = quiz;;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public Quiz getQuiz(){
        return quiz;
    }

    public String toString() {
        String result =  "Title: "+ this.title +
                        "\nContent: " + this.content;
                        result += "\nQuiz: " + quiz + "\n";
        result += "\n";
        return result;
    }
    public String miniToString() {
        String result =  "Title: "+ this.title +
                        "\nContent: " + this.content;
        result += "\n";
        return result;
    }
}