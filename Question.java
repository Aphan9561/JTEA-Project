public class Question {
    
    public static final int maxAnswers = 4;
    public String question;
    public String[] answers = new String[maxAnswers];
    public int correctAnswer;

    public Question(String question, String[] answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion(){
        return question;
    }

    public String[] getAnswers(){
        return answers;
    }

    public int getCorrectAnswer(){
        return correctAnswer;
    }
}
