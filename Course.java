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
    private ArrayList<Review> reviews;
    private ArrayList<Comment> comments;

    public Course(String name, String description, Difficulty difficulty, Language language){
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.language =language;
        reviews = new ArrayList<>();
        modules = new ArrayList<>();
        comments = new ArrayList<>();
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

    public ArrayList<Review> getReview(){
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
}
