import java.util.ArrayList;
import java.util.UUID;

public class Comment {
    private String comment;
    private UUID user;
    private ArrayList<Reply> replies;

    public Comment(String comment, UUID user){
        this.comment = comment;
        this.user = user;
    }

    public String getComment(){
        return comment;
    }

    public UUID getUser(){
        return user;
    }
}
