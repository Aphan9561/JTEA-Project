import java.util.ArrayList;

public class FAQ {
    
    private String question;
    private ArrayList<String> answers = new ArrayList<String>();

    public FAQ(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers.addAll(answers);
    }

    public FAQ(String question, String answer) {
        this.question = question;
        this.answers.add(answer);
    }

    public FAQ(String question, String[] answer) {
        this.question = question;
        for (int i = 0; i< answers.size(); i++){
            answers.add(new String(answer[i]));
        }
    }

    public void answerQuestion(String answer) {
        answers.add(answer);
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
