import java.util.ArrayList;
import java.util.UUID;

/**
 * A Comment
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class Comment {
    private String comment;
    private UUID user;
    private ArrayList<Reply> replies = new ArrayList<Reply>();

    /**
     * Creates a Comment
     * @param comment the actual comment string
     * @param user the user of the comment
     * @param replies an array list of replies
     */
    public Comment(String comment, UUID user, ArrayList<Reply> replies){
        this.comment = comment;
        this.user = user;
        this.replies.addAll(replies);
    }

    /**
     * Creates a Comment
     * @param comment the actual comment string
     * @param user the user of the comment
     */
    public Comment(String comment, UUID user) {
        this.comment = comment;
        this.user = user;
    }

    /**
     * Returns the Comment
     * @return comment
     */
    public String getComment(){
        return comment;
    }

    /**
     * Returns the User
     * @return user
     */
    public UUID getUser(){
        return user;
    }

    /**
     * Returns the ArrayList Reply
     * @return replies
     */
    public ArrayList<Reply> getReply(){
        return replies;
    }

    /**
     * Returns details of the Comment
     * @return A string representation of a Comment
     */
    public String toString(){
        String result = "User: "+ user + "\nComment: " + comment + "\n";
        result += "Replies: \n";
        for(Reply reply : replies) {
            result += reply;
        }
        result += "\n";
        return result;
    }

    /**
     * Adds a Reply to the ArrayList
     * @param reply A reply object
     */
    public void addReply(Reply reply) {
        replies.add(reply);
    }

}
