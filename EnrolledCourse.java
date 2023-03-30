import java.util.ArrayList;
import java.util.UUID;

public class EnrolledCourse {
    private UUID course;
    //private boolean enrolled;
    private Progress progress;
    //private int progressPercentage;
    private int currentModule;
    private int currentLesson;
    private int overallGrade;
    private ArrayList<Integer> gradesPerModule = new ArrayList<Integer>();

    
    public EnrolledCourse(UUID course, Progress progress, int currentModule, int currentLesson, int overallGrade, ArrayList<Integer> gradesPerModule){
        
        this.course = course;
        this.progress = progress;
        //this.progressPercentage = progressPercentage;
        this.currentModule = currentModule;
        this.currentLesson = currentLesson;
        //this.enrolled = enrolled;
        this.overallGrade = overallGrade;
        gradesPerModule.addAll(gradesPerModule);
    }

    public EnrolledCourse(UUID course){
        this.course = course;
        this.currentModule = 0;
        this.currentLesson = 0;
        //this.enrolled = enrolled;
    }

    public UUID getCourse() {
        return course;
    }

    /*
    public int getProgressPercentage(){
        return progressPercentage;
    }
    */

    public Progress getProgress(){
        return progress;
    }

    public int getCurrentLesson(){
        return currentLesson;
    }

    /*
    public Module resumeModule(){
        return course.getModule(currentModule);
    }

    public Lesson resumeLesson(){
        Module module = course.getModule(currentModule);
        return module.getLesson(currentLesson);
    }
    */

    public int getCurrentModule() {
        return currentModule;
    }

    public int getOverallGrade() {
        return overallGrade;
    }

    public ArrayList<Integer> getGradesPerModule() {
        return gradesPerModule;
    }

    /*
    public Course getCourse(){
        return this.course;
    }
    */

    public int moveCurrentModule(){
        currentModule++;
        return currentModule;
    }

    public int moveCurrentLesson(){
        //if()
        currentLesson++;
        return currentLesson;
    }
}
