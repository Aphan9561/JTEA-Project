/*
 * This is the review class to the allow user to review a course
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

public class Review {
    private double rating;
    private String comment;
    private User user;

    public Review(double rating, String comment, User user) {
        this.rating = rating;
        this.comment = comment;
        this.user = user;
    }
}