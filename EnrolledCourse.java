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
        this.enrolled = enrolled;
        this.progress = progress;
    }

    public int getProgressPercentage(){
        return progressPercentage;
    }

    public Progress getProgress(){
        return progress;
    }

    public void resumeLesson(){
        
    }
}
