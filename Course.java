import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private UUID id;
    private Difficulty difficulty;
    private String name;
    private String description;
    private String syllabus;
    private Author author;
    private ArrayList<Module> modules;
    private Language language;
    private ArrayList<Student> students;
    private double rating;
    //private ArrayList<Review> reviews;
    private Review reviews;
    private ArrayList<Comment> comments;

    public Course(String name, String description, Difficulty difficulty, Language language){
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.language =language;
        this.reviews = reviews;
        //reviews = new ArrayList<>();
        modules = new ArrayList<>();

    } 

    public UUID getId(){
        return id;
    }

    public String getTitle(){
        return name;
    }

    public Author getAuthor(){
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

    public Review getReview(){
        return reviews;
    }

    /* 
    public void addReview(User user, int rating, String comment){
        Review review = new Review(rating, comment, user);
        reviews.add(review);
    }
    */

    public int getNumberOfModules(){
        return modules.size();
    }

    public Module getModule(int moduleNum){
        return modules.get(moduleNum);
    }

    public void addModule(String title, ArrayList<Lesson> lessons){
        Module module = new Module(title, lessons);
        modules.add(module);
    }

    public Comment getComment(int index){
        return comments.get(index);
    }

    public String toString(){
        return "UUID: "+id+"\nDifficulty: "+difficulty
                +"\nName: "+name+
                "\nDescription: "+description+
                "\nSyllabus: "+syllabus+
                "\nAuthor: "+author+
                "\nModules: "+modules+
                "\nLanguage: "+language+
                "\nRating: "+rating+
                "\nReviews: "+reviews+
                "\nComments: "+comments;
    }
}
