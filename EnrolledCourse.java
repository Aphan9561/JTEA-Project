import java.util.ArrayList;
import java.util.UUID;

/**
 * An Enrolled Course
 * @author: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class EnrolledCourse {
    private UUID course;
    //private boolean enrolled;
    private Progress progress;
    //private int progressPercentage;
    private int currentModule;
    private int currentLesson;
    // private Grade grade;
    private int overallGrade;
    private ArrayList<Integer> gradesPerModule = new ArrayList<Integer>();

    /**
     * Creates an Enrolled Course
     * @param course a course
     * @param enrolled if user is enrolled in the course or not
     * @param progress the course progress
     */
    public EnrolledCourse(UUID course){
        this.course = course;
        //this.progress = NOT_STATRED;
        this.currentModule = 0;
        this.currentLesson = 0;
        this.overallGrade = 100;
    }

    public EnrolledCourse(UUID course, Progress progress, int currentModule, int currentLesson, int overallGrade, ArrayList<Integer> gradesPerModule) {
        this.course = course;
        this.progress = progress;
        this.currentModule = currentModule;
        this.currentLesson = currentLesson;
        this.overallGrade = overallGrade;
        this.gradesPerModule = gradesPerModule;
    }


    /**
     * Returns the progress percentage
     * @return the progress percentage
     */
    /*
    public int getProgressPercentage(){
        return progressPercentage;
    }*/

    /**
     * Returns progress of the Course
     * @return progress of the Course
     */
    public Progress getProgress(){
        return progress;
    }

    /**
     * Returns the current lesson
     * @return the current lesson
     */
    public int getCurrentLesson(){
        return currentLesson;
    }

    /**
     * Returns the Module last worked on
     * @return a course
     */
    /*
    public Module resumeModule(){
        return course.getModule(currentModule);
    }*/

    /**
     * Returns the Lesson last worked on
     * @return a lesson
     */
    /*
    public Lesson resumeLesson(){
        Module module = course.getModule(currentModule);
        return module.getLesson(currentLesson);
    }*/

    /**
     * Returns the current module
     * @return the current module
     */
    public int getCurrentModule() {
        return currentModule;
    }

    /**
     * Returns a course
     * @return a course
     */
    public UUID getCourse(){
        return this.course;
    }

    /**
     * Changes the index of the current module
     * @return the current module index
     */
    public int moveCurrentModule(){
        currentModule++;
        return currentModule;
    }

    /**
     * Changes the index of the current lesson
     * @return the current lesson index
     */
    public int moveCurrentLesson(){
        currentLesson++;
        return currentLesson;
    }

    public void startCourse() {
        
    }
}
