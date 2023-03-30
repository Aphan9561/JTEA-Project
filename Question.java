import java.util.ArrayList;
/**
 * This is the question class
 * @author: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class Question {
    
    public static final int maxAnswers = 4;
    public String question; 
    ArrayList<String> answers = new ArrayList<String>();
    public int correctAnswer;
    /**
     * Creates a new question
     * @param question quesion 
     * @param answers answers choices
     * @param correctAnswer correct answer choses
     */
    public Question(String question, ArrayList<String> answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
    /**
     * get the question
     * @return question
     */
    public String getQuestion(){
        return question;
    }
    /**
     * get answer choices
     * @return answer choices
     */
    public ArrayList<String> getAnswers(){
        return answers;
    }
    /**
     * get correct answer
     * @return correct answer choice
     */
    public int getCorrectAnswer(){
        return correctAnswer;
    }
    /**
     * Creates a string representation of the question
     */
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
    /**
     * Creates a string representation of the answers
     */
    public String answersToString() {
        String result = "";
        for(int i=0; i < answers.size(); i++) {
            result += "(";
            result += (i+1);
            result += ") ";
            result += answers.get(i);
            result += "\n";
        }
        return result;
    }
}
