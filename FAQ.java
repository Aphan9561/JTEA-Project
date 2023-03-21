import java.util.ArrayList;

public class FAQ {
    
    private String question;
    private ArrayList<String> answers = new ArrayList<String>();

    public FAQ(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers.addAll(answers);
    }

    public FAQ(String question, String answer) {
        
    }

    public FAQ(String question, String[] answer) {
        
    }

    public void answerQuestion(String answer) {
        
    }

    public String getQuestion(){
        return question;
    }
    
    public ArrayList<String> getAnswers(){
        return answers;
    }

    public String toString() {
        String result = "Question: " + question + "\nAnswers: \n";
        for(String answer: answers) {
            result += answer;
            result += "\n";
        }
        return result;
    }

}
