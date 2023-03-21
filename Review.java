import java.util.UUID;

/*
 * This is the review class to the allow user to review a course
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

public class Review {
    private double rating;
    private String comment;
    private UUID user;

    public Review(double rating, String comment, UUID user) {
        this.rating = rating;
        this.comment = comment;
        this.user = user;
    }

    public double getRating(){
        return rating;
    }

    public String getComment(){
        return comment;
    }

    public UUID getUser(){
        return user;
    }

    public String toString(){
        return "User: "+user+
            "Rating: "+rating+
            "Comment: "+comment;
    }
}