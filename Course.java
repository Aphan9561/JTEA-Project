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
    } 

    public String getTitle(){
        return "";
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

    public void getSyllabus(){
        
    }

    public String addSyllabus(){
        return "";
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

    }

    public int getNumberOfModules(){
        return 1;
    }

    public Module getCurrentModule(){
        return null;
    }

    public Module addModule(String title, ArrayList<Lesson> lessons){
        return null;
    }
}
