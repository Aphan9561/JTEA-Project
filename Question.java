import java.util.ArrayList;

public class Question {
    
    public static final int maxAnswers = 4;
    public String question; 
    //public String[] answers = new String[maxAnswers];
    ArrayList<String> answers = new ArrayList<String>();
    public int correctAnswer;

    public Question(String question, ArrayList<String> answers, int correctAnswer) {
        this.question = question;
        //this.answers = answers;
        this.answers.addAll(answers);
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion(){
        return question;
    }

    public ArrayList<String> getAnswers(){
        return answers;
    }

    public int getCorrectAnswer(){
        return correctAnswer;
    }
}
