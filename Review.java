import java.util.UUID;

/**
 * This is the review class to the allow user to review a course
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

public class Review {
    private double rating;
    private String comment;
    private UUID user;

    /**
     * Creates a new review
     * @param rating  rating of the course
     * @param comment comment on the course
     * @param user    user who is commenting
     */
    public Review(double rating, String comment, UUID user) {
        this.rating = rating;
        this.comment = comment;
        this.user = user;
    }

    /**
     * get review rating
     * @return rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * get review comment
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * gets the user who is making the review
     * @return user
     */
    public UUID getUser() {
        return user;
    }

    /**
     * Creates a string representation of the reivew
     */
    public String toString() {
        String result = rating + " stars\t" + user + ": \n" + comment + "\n";
        return result;
    }
}