import java.util.ArrayList;

public class EnrolledCourse {
    private boolean enrolled;
    private Progress progress;
    private int progressPercentage;
    private int currentModule;
    private int currentLesson;
    private Grade grade;
    private ArrayList<Grade> gradePerModule;

    public EnrolledCourse(Course course, boolean enrolled, Progress progress){
        
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public void setProgress(Progress progress) {

    }

    public int getProgressPercentage(){
        return 0;

    }

    public Progress getProgress(){
        return progress;
    }

    public void resumeLesson(){
        
    }
}
