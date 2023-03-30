import java.util.ArrayList;

/**
 * This is a lesson
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

public class Lesson {
    private String content;
    private String title;
    private Quiz quiz;

    /**
     * Creates a new lesson
     * @param content content in lesson
     * @param title title of the lesson
     * @param quiz quiz in the lesson
     */
    public Lesson(String content, String title, Quiz quiz) {
        this.content = content;
        this.title = title;
        this.quiz = quiz;
    }

    /**
     * get title of lesson
     * @return lesson title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * gets the content in the lesson
     * @return lesson content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * get the quiz in the lesson
     * @return lesson quiz
     */
    public Quiz getQuiz() {
        return this.quiz;
    }

    /**
     * Adding the quiz to the lesson
     * @param question the questions in the quiz
     */
    public void addQuiz(ArrayList<Question> question) {
        this.quiz = new Quiz(question);
    }

    /**
     * Creates a String representation of the lesson
     */
    public String toString() {
        String result = "Title: " + this.title +
                "\nContent: " + this.content;
        result += "\nQuiz: " + quiz + "\n";
        result += "\n";
        return result;
    }

    /**
     * Creates a string representation of the lesson title and content
     * @return
     */
    public String miniToString() {
        String result = "Title: " + this.title +
                "\nContent: " + this.content + "\n";
        return result;
    }
    /**
     * Take the quiz
     */
    public void takeQuiz() {
        double questionValue = quiz.getQuestionValue();
        for (int i = 1; i <= quiz.getQuestion().size(); i++) {
            System.out.print(i + ". ");
            System.out.println(quiz.getQuestion().get(i - 1));
        }
    }
}