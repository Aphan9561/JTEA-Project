import java.util.ArrayList;

public class Quiz {
    public static final int quizSize = 10;
    public static final int maxAnswers = 4;
    private ArrayList<Question> questions = new ArrayList<Question>();
    private ArrayList<Question> tempQuestions = new ArrayList<Question>();
    //private int[] grades = new int[quizSize];
    //private String[] answers = new String[maxAnswers];
    private int stars;

    public Quiz(ArrayList<Question> question) {
        questions.addAll(question);
    }

    public void addQuestion(String prompt, ArrayList<String> answers, int correctAnswer) {
        Question question = new Question(prompt, answers, correctAnswer);
        questions.add(question);
    }

    public double calculateScore(Question[] userAnswers) {
        Question[] answer = new Question[quizSize];
        double counter =0;
        for(int i=0; i<quizSize; i++){
            if(userAnswers[i] == answer[i]){
                counter++;
            }
        }
        return (counter/quizSize)*100;
    }

    public String giveStars(double score) {
        if(score >= 90){
            stars = stars +3;
        } else if (score < 90 && score >= 80){
            stars = stars +2;
        } else if (score < 80 && score >= 70){
            stars = stars +1;
        } 
        return "You have "+ stars + "star(s)";
    }


    public ArrayList<Question> getQuestion(){
        return questions;
    }

    public String toString() {
        String result = "~Quiz~ \n";
        for(Question question : questions) {
            result += question;
            System.out.println("Added question");
        }
        result += "\n";
        return result;
    }
    
}