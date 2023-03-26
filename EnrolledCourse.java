import java.util.ArrayList;

public class EnrolledCourse {
    private Course course;
    private boolean enrolled;
    private Progress progress;
    private int progressPercentage;
    private int currentModule;
    private int currentLesson;
    // private Grade grade;
    // private ArrayList<Grade> gradePerModule;

    public EnrolledCourse(Course course, boolean enrolled, Progress progress){
        
        this.course = course;
        this.enrolled = enrolled;
        this.progress = progress;
    }

    public EnrolledCourse(Course course, boolean enrolled){
        this.course = course;
        this.enrolled = enrolled;
    }

    public int getProgressPercentage(){
        return progressPercentage;
    }

    public Progress getProgress(){
        return progress;
    }

    public int getCurrentLesson(){
        return currentLesson;
    }

    public Module resumeModule()
    {
        return course.getModule(currentModule);
    }

    public Lesson resumeLesson()
    {
        Module module = course.getModule(currentModule);
        return module.getLesson(currentLesson);
    }
    public int getCurrentModule() {
        return currentModule;
    }

    public Course getCourse(){
        return this.course;
    }

    public int moveCurrentModule()
    {
        currentModule++;
        return currentModule;
    }

    public int moveCurrentLesson()
    {
        currentLesson++;
        return currentLesson;
    }
}
