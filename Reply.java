import java.util.UUID;

public class Reply {
    private String comment;
    private UUID user;

    public Reply(String comment, UUID user) {
        this.comment = comment;
        this.user = user;
    }
}
