import java.util.UUID;
/**
 * This is the reply class for the users to reply to a comment
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class Reply {
    private String comment;
    private UUID user;
    /**
     * Creates a new reply
     * @param comment user's comment
     * @param user user who is making the reply
     */
    public Reply(String comment, UUID user) {
        this.comment = comment;
        this.user = user;
    }
    /**
     * get the reply comment
     * @return comment
     */
    public String getComment() {
        return comment;
    }
    /**
     * get user who is making the reply
     * @return user who is replying
     */
    public UUID getUser() {
        return user;
    }
    /**
     * Creates a string representation of the reply
     */
    public String toString() {
        String result = "\nUser: " + user + "\nComment: " + comment + "\n";
        return result;
    }
}
