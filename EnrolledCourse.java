import java.util.ArrayList;
import java.util.UUID;

/**
 * An Author User
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class EnrolledCourse {
    private UUID course;
    //private boolean enrolled;
    private Progress progress;
    //private int progressPercentage;
    private int currentModule;
    private int currentLesson;
    private int overallGrade;
    private ArrayList<Integer> gradesPerModule = new ArrayList<Integer>();

    /**
     * Creates a Enrolled Course
     * @param course
     * @param progress
     * @param currentModule
     * @param currentLesson
     * @param overallGrade
     * @param gradesPerModule
     */
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

    /**
     * Creates an Enrolled Course
     * @param course a UUID
     */
    public EnrolledCourse(UUID course){
        this.course = course;
        this.currentModule = 0;
        this.currentLesson = 0;
        //this.enrolled = enrolled;
    }

    /**
     * Returns course id
     * @return course id
     */
    public UUID getCourse() {
        return course;
    }

    /*
    public int getProgressPercentage(){
        return progressPercentage;
    }
    */

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

    /*
    public Module resumeModule(){
        return course.getModule(currentModule);
    }

    public Lesson resumeLesson(){
        Module module = course.getModule(currentModule);
        return module.getLesson(currentLesson);
    }
    */

    /**
     * Returns the current module
     * @return the current module
     */
    public int getCurrentModule() {
        return currentModule;
    }

    /**
     * Returns the over all grade
     * @return the over all grade
     */
    public int getOverallGrade() {
        return overallGrade;
    }

    /**
     * Returns an Array List of grades per module
     * @return an Array List of grades per module
     */
    public ArrayList<Integer> getGradesPerModule() {
        return gradesPerModule;
    }

    /*
    public Course getCourse(){
        return this.course;
    }
    */

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
        //if()
        currentLesson++;
        return currentLesson;
    }
}
