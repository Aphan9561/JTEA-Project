import java.util.ArrayList;
/**
 * This is the quiz class
 * @author: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class Quiz {
    public static final int quizSize = 10;
    public static final int maxAnswers = 4;
    private ArrayList<Question> questions = new ArrayList<Question>();
    //private ArrayList<Question> tempQuestions = new ArrayList<Question>();
    private int[] grades = new int[questions.size()];
    //private String[] answers = new String[maxAnswers];
    private int stars;
    private double score;
    
    /**
     * Creates a new quiz
     * @param question array of questions
     */
    public Quiz(ArrayList<Question> question) {
        this.questions = question;
    }

    /**
     * adding the question into the quiz
     * @param prompt the question 
     * @param answers the answer choices
     * @param correctAnswer the correct answer
     * @return true if the question is add
     */
    public boolean addQuestion(String prompt, ArrayList<String> answers, int correctAnswer) {
        Question question = new Question(prompt, answers, correctAnswer);
        questions.add(question);
        return true;
    }

    /**
     * calculate the score of the quiz
     * @param userAnswers array of user answers
     * @return grade of the quiz
     */
    public double calculateScore(Question[] userAnswers) {
        Question[] answer = new Question[quizSize];
        double counter =0;
        for (int i=0; i<quizSize; i++) {
            if (userAnswers[i] == answer[i]) {
                counter++;
            }
        }
        return (counter/quizSize)*100;
    }

    /**
     * give the student stars
     * @param score grade of the quiz
     * @return how many stars the user has
     */
    public String giveStars(double score) {
        if (score >= 90) {
            stars = stars +3;
        } else if (score < 90 && score >= 80) {
            stars = stars +2;
        } else if (score < 80 && score >= 70) {
            stars = stars +1;
        } 
        return "You have "+ stars + "star(s)";
    }

    /**
     * gets questions in quiz
     * @return
     */
    public ArrayList<Question> getQuestion() {
        return questions;
    }

    /**
     * Creates a string representation of the quiz
     * @return
     */
    public String toString() {
        String result = "~Quiz~ \n";
        for(Question question : questions) {
            result += question;
        }
        result += "\n";
        return result;
    }
    /**
     * Get the quiz grade
     * @return the grade of the quiz
     */
    public double getQuestionValue() {
        return (100)/questions.size();
    }
    /**
     * gets the next question in the quiz
     * @param questionNumber the question 
     * @return the question
     */
    public Question getNextQuestion(int questionNumber) {
        return null;
    }
    
}