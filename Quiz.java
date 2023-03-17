public class Quiz {
    public static final int quizSize = 10;
    private Question[] questions = new Question[quizSize];
    private int[] grades = new int[quizSize];

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        for(int i=0; i<quizSize; i++){
            if(questions[i] == null){
                questions[i] = question;
                break;
            } else{
                System.out.print("Can't add question, Quiz full.");
                break;
            }
        }
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

    public void giveStars() {
        // I am unsure how to do this one :|
    }

    public Question getQuestion(int num){
        return questions[num];
    }
}