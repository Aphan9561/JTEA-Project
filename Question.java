import java.util.ArrayList;

public class Question {
    
    public static final int maxAnswers = 4;
    public String question; 
    ArrayList<String> answers = new ArrayList<String>();
    public int correctAnswer;

    public Question(String question, ArrayList<String> answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
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

    public String toString() {
        String result = "\n" + question + "\n";
        for(int i=1; i <= answers.size(); i++) {
            result += i;
            result += "- ";
            result += answers.get(i-1);
            result += "\n";
        }
        //result += "\n";
        return result;
    }
}
