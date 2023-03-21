import java.util.ArrayList;

/*
 * This is a module that holds lessons
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

 public class Module{
    private ArrayList<Lesson> lesson;
    private Quiz quiz;
    private ArrayList<Comment> comment;
    private String title;

    public Module(String title, ArrayList<Lesson> lesson) {
        this.title = title;
        this.lesson.addAll(lesson);
    }

    public Module(String name, Quiz quiz, ArrayList<Lesson> lessons, ArrayList<Comment> comments) {
        title = name;
        this.quiz = quiz;
        lesson.addAll(lessons);
        comment.addAll(comments);
    }

    public String getTitle(){
        return title;
    }

    public ArrayList<Lesson> getCurrentLesson() {
        return lesson; 
    }

    public Quiz getQuiz(){
        return quiz;
    }

    public ArrayList<Comment> getComment(){
        return comment;
    }
 }