import java.util.ArrayList;
import java.util.UUID;

public class Comment {
    private String comment;
    private UUID user;
    private ArrayList<Reply> replies;

    public Comment(String comment, UUID user, ArrayList<Reply> replies){
        this.comment = comment;
        this.user = user;
        this.replies.addAll(replies);
    }

    public String getComment(){
        return comment;
    }

    public UUID getUser(){
        return user;
    }

    public String toString(){
        return "Comment: "+comment+ " "+
                "\nUser: "+user+
                "\nReplies: "+replies;
    }

}
