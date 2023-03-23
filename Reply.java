import java.util.UUID;

public class Reply {
    private String comment;
    private UUID user;

    public Reply(String comment, UUID user) {
        this.comment = comment;
        this.user = user;
    }

    public String getComment(){
        return comment;
    }

    public UUID getUser(){
        return user;
    }

    public String toString() {
        String result = "\nUser: " + user + "\nComment: " + comment + "\n";
        return result;
    }
}
