import java.util.ArrayList;
import java.util.UUID;

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

    public Course(String name, String description, Difficulty difficulty, Language language){
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.language =language;
        /*reviews = new ArrayList<>();
        modules = new ArrayList<>();
        comments = new ArrayList<>();*/
    }

    public Course(UUID id, Difficulty difficulty, String name, String description, String syllabus, UUID author, ArrayList<Module> modules, Language language, ArrayList<Student> students, double rating, ArrayList<Review> reviews, ArrayList<Comment> comments) {
        this.id = id;
        this.difficulty = difficulty;
        this.name = name;
        this.description = description;
        this.syllabus = syllabus;
        this.author = author;
        this.modules.addAll(modules);
        this.language = language;
        this.students.addAll(students);
        this.rating = rating;
        this.reviews.addAll(reviews);
        this.comments.addAll(comments);
    }

    public UUID getId(){
        return id;
    }

    public String getTitle(){
        return name;
    }

    public UUID getAuthor(){
        return author;
    }

    public String getDesciption(){
        return description;
    }

    public Difficulty getDifficulty(){
        return difficulty;
    }

    public Language getLanguage(){
        return language;
    }

    public String getSyllabus(){
        return syllabus;
    }

    public void addSyllabus(String syllabus){
        this.syllabus = syllabus;
    } 

    public double getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public ArrayList<Review> getReview(){
        return reviews;
    }

    /* 
    public void addReview(User user, int rating, String comment){
        Review review = new Review(rating, comment, user);
        reviews.add(review);
    }
    */

    public ArrayList<Student> getStudent(){
        return students;
    }

    public int getNumberOfModules(){
        return modules.size();
    }

    public ArrayList<Module> getModule(){
        return modules;
    }

    public void addModule(String title, ArrayList<Lesson> lessons){
        Module module = new Module(title, lessons);
        modules.add(module);
    }

    public ArrayList<Comment> getComment(){
        return comments;
    }

    public String toString(){
        String result = "Course ID: " + id + "\nDifficulty: " + difficulty + "\nName: " + name + "\nDescription: " + description + "\nSyllabus: " + syllabus + "\nAuthor ID: " + author;
                result += "\nModules: ";
        for(Module module : modules) {
            result += module;
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

}
