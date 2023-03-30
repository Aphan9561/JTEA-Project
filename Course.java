import java.util.ArrayList;
import java.util.UUID;

/**
 * A Course
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class Course {
    private UUID id;
    private Difficulty difficulty;
    private String name;
    private String description;
    private String syllabus;
    private UUID author;
    private ArrayList<Module> modules = new ArrayList<Module>();
    private Language language;
    private ArrayList<Student> students = new ArrayList<Student>();
    private double rating;
    private ArrayList<Review> reviews = new ArrayList<Review>();
    private ArrayList<Comment> comments = new ArrayList<Comment>();

    /**
     * Creates a Course
     * @param author UUID of Author
     * @param name name of Course
     * @param description description of Course
     * @param syllabus syllabus of Course
     * @param difficulty difficulty of Course
     * @param language language of Course
     * @param modules modules of Course
     */
    public Course(UUID author, String name, String description, String syllabus, Difficulty difficulty, Language language, ArrayList<Module> modules){
        this.id = UUID.randomUUID();
        this.author = author;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.language =language;
        this.syllabus = syllabus;
        this.modules = modules;
        /*reviews = new ArrayList<>();
        modules = new ArrayList<>();
        comments = new ArrayList<>();*/
    }

    /**
     * Creates a Course
     * @param id UUID of the User
     * @param difficulty difficulty of Course
     * @param name name of Course
     * @param description description of Course
     * @param syllabus syllabus of Course
     * @param author author of Course
     * @param modules modules of Course
     * @param language language of Course
     * @param students students of Course
     * @param rating rating of Course
     * @param reviews reviews of Course
     * @param comments comments of Course
     */
    public Course(UUID id, Difficulty difficulty, String name, String description, String syllabus, UUID author, ArrayList<Module> modules, Language language, ArrayList<Student> students, double rating, ArrayList<Review> reviews, ArrayList<Comment> comments) {
        this.id = id;
        this.difficulty = difficulty;
        this.name = name;
        this.description = description;
        this.syllabus = syllabus;
        this.author = author;
        this.modules = modules;
        this.language = language;
        this.students = students;
        this.rating = rating;
        this.reviews = reviews;
        this.comments = comments;
    }

    /**
     * Returns id
     * @return a UUID id
     */
    public UUID getId(){
        return id;
    }

    /**
     * Returns Title
     * @return name of Course
     */
    public String getTitle(){
        return name;
    }

    /**
     * Returns Author
     * @return author
     */
    public UUID getAuthor(){
        return author;
    }

    /**
     * Returns description
     * @return description
     */
    public String getDesciption(){
        return description;
    }

    /**
     * Returns difficulty
     * @return difficulty
     */
    public Difficulty getDifficulty(){
        return difficulty;
    }

    /**
     * Returns language
     * @return language
     */
    public Language getLanguage(){
        return language;
    }

    /**
     * Returns syllabus
     * @return syllabus
     */
    public String getSyllabus(){
        return syllabus;
    }

    /**
     * Adds a syllabus
     * @param syllabus syllabus of course
     */
    public void addSyllabus(String syllabus){
        this.syllabus = syllabus;
    } 

    /**
     * Returns rating
     * @return rating
     */
    public double getRating(){
        return rating;
    }

    /**
     * Sets course rating
     * @param rating int rating given
     */
    public void setRating(int rating){
        this.rating = rating;
    }

    /**
     * Returns reviews
     * @return An ArrayList of reviews
     */
    public ArrayList<Review> getReview(){
        return reviews;
    }

    /**
     * Adds a review
     * @param user review's user
     * @param rating the rating
     * @param comment the comment
     */
    public void addReview(User user, double rating, String comment){
        Review review = new Review(rating, comment, user.getId());
        reviews.add(review);
    }
    
    /**
     * Returns students
     * @return An ArrayList of students
     */
    public ArrayList<Student> getStudent(){
        return students;
    }

    /**
     * Returns how many modules in the Course
     * @return number of modules
     */
    public int getNumberOfModules(){
        return modules.size();
    }

    /**
     * Returns modules
     * @return An ArrayList of modules
     */
    public ArrayList<Module> getModule(){
        return modules;
    }

    /**
     * Returns a Module
     * @param num the module number wanted
     * @return a module
     */
    public Module getModule(int num){
        return modules.get(num);
    }

    /**
     * Adds a Module
     * @param title Module title
     * @param lessons ArrayList of Lessons
     */
    public void addModule(String title, ArrayList<Lesson> lessons){
        Module module = new Module(title, lessons);
        modules.add(module);
    }

    /**
     * Returns comments
     * @return An ArrayList of comments
     */
    public ArrayList<Comment> getComment(){
        return comments;
    }

    /**
     * Returns details of the Course
     * @return A string representation of a Course
     */
    public String toString(){
        String result = "Course ID: " + id + "\nDifficulty: " + difficulty + "\nName: " + name + "\nDescription: " + description + "\nSyllabus: " + syllabus + "\nAuthor ID: " + author;
                result += "\nModules: \n";
        for(Module module : modules) {
            result += module;
            System.out.println("Added module");
        }
                result += "\nLanguage: "+language+"\nActive Students:\n";
        for(Student student : students) {
            result += student;
        }
                result += "\nRating: "+rating;
                result += "\nReviews:";
        for(Review review : reviews) {
            result += review;
        }
                result += "\nComments: ";
        for(Comment comment : comments) {
            result += comment;
        }
        return result;
    }

    /**
     * Returns details of the Comment of Course
     * @return A string representation of a Comment of Course
     */
    public String commentsToString() {
        String result = "";
        for(Comment comment : comments) {
            result += comment;
        }
        return result;
    }

    /**
     * Adds a Comment to the comment ArrayList
     * @param comment a comment
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

}
