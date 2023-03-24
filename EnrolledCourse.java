import java.util.ArrayList;
import java.util.UUID;

/**
 * An Author User
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class EnrolledCourse {
    private UUID course;
    //private boolean enrolled;
    //private boolean enrolled;
    private Progress progress;
    //private int progressPercentage;
    private int currentModule;
    private int currentLesson;
    // private Grade grade;
    private int overallGrade;
    private ArrayList<Integer> gradesPerModule = new ArrayList<Integer>();
    private ArrayList<Integer> gradesPerLesson = new ArrayList<Integer>();

    /**
     * Creates a Enrolled Course
     * @param course
     * @param progress
     * @param currentModule
     * @param currentLesson
     * @param overallGrade
     * @param gradesPerModule
     */
    public EnrolledCourse(UUID course){
        this.course = course;
        this.progress = Progress.NOT_STARTED;
        this.currentModule = 0;
        this.currentLesson = 0;
        this.overallGrade = 100;
    }

    public EnrolledCourse(UUID course, Progress progress, int currentModule, int currentLesson, int overallGrade, ArrayList<Integer> gradesPerModule, ArrayList<Integer> gradesPerLesson) {
        this.course = course;
        this.progress = progress;
        this.currentModule = currentModule;
        this.currentLesson = currentLesson;
        this.overallGrade = overallGrade;
        this.gradesPerModule = gradesPerModule;
        this.gradesPerLesson = gradesPerLesson;
    }

    

    /**
     * Returns course id
     * @return course id
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
    public UUID getCourse(){
        return this.course;
    }

    public ArrayList<Integer> getGradesPerModule() {
        return gradesPerModule;
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
        //if()
        currentLesson++;
        return currentLesson;
    }

    public void startCourse() {
        progress = Progress.IN_PROGRESS;
    }

    public void completeCourse() {
        progress = Progress.COMPLETED;
    }

    public String toString() {
        String result = "Course" + course +
                "\nProgress: " + progress +
                "\nCurrent module: " + currentModule +
                "\nCurrent lesson: " + currentLesson +
                "\nOverall Grade: " + overallGrade +
                "\nGrades per module: ";
        for(Integer grade : gradesPerModule) {
            result += grade;
            result += ", ";
        }
        result += "\nGrades per lesson: ";
        for(Integer grade : gradesPerLesson) {
            result += grade;
            result += ", ";
        }
        result += "\n";
        return result;
    }

    /*
     *  public int calculateOverallQuizValue() {

    } 
     */
   
}
