import java.util.UUID;

public class MakeUUID {
    public static void main(String[] args){
        for(int i=0; i < 10; i++){
            System.out.println(UUID.randomUUID());
        }
    }
}
