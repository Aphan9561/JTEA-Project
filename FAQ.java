import java.util.ArrayList;

/**
 * A FAQ
 * @author: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class FAQ {
    
    private String question;
    private ArrayList<String> answers = new ArrayList<String>();

    /**
     * Creates a FAQ
     * @param question a question
     * @param answers an array list of answers
     */
    public FAQ(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers.addAll(answers);
    }

    /**
     * Creates a FAQ
     * @param question a question
     * @param answer an answer
     */
    public FAQ(String question, String answer) {
        this.question = question;
        this.answers.add(answer);
    }

    /**
     * Creates a FAQ
     * @param question a question
     * @param answer an array of answers
     */
    public FAQ(String question, String[] answer) {
        this.question = question;
        for (int i = 0; i< answers.size(); i++){
            answers.add(new String(answer[i]));
        }
    }
    
    /**
     * Creates an FAQ from an FAQ
     * @param faq an FAQ
     */
    public FAQ(Question faq) {
        this.question = faq.getQuestion();
        this.answers = faq.getAnswers();
    }

    /**
     * Sets the question of FAQ
     * @param question a question
     */
    public FAQ(String question) {
        this.question = question;
    }

    /**
     * Adds an answer to the answers array list
     * @param answer an answer
     */
    public void answerQuestion(String answer) {
        answers.add(answer);
    }

    /**
     * Returns a question
     * @return a question
     */
    public String getQuestion(){
        return question;
    }
    
    /**
     * Returns an ArrayList of answers
     * @return an ArrayList of answers
     */
    public ArrayList<String> getAnswers(){
        return answers;
    }

    /**
     * Adds an answer to the answers array list
     * @param answer an answer
     */
    public void addAnswer(String answer) {
        answers.add(answer);
    }

    /**
     * Returns details of the FAQ
     * @return A string representation of a FAQ
     */
    public String toString() {
        String result = "Question: " + question + "\nAnswers: \n";
        for(String answer: answers) {
            result += answer;
            result += "\n";
        }
        return result;
    }

}
