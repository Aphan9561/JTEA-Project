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
    private double rating;
    private ArrayList<Review> reviews;
    private ArrayList<Comment> comments;

    public Course(String name, Author author, String description, Difficulty difficulty, Language language){
        setTitle(name);
        this.author = author;
        setDecription(description);
        setDifficulty(difficulty);
        this.language =language;
        reviews = new ArrayList<>();
        modules = new ArrayList<>();
    } 

    public String getTitle(){
        return name;
    }

    public void setTitle(String name){
        this.name = name;
    }

    public Author getAuthor(){
        return author;
    }

    public String getDesciption(){
        return description;
    }

    public void setDecription(String description){
        this.description = description;
    }
    
    public Difficulty getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
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

    public void addReview(User user, int rating, String comment){
        Review review = new Review(rating, comment, user);
        reviews.add(review);
    }

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
}
