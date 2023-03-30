import java.util.UUID;
/**
 * makes a random UUID
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class MakeUUID {
    public static void main(String[] args){
        for(int i=0; i < 10; i++){
            System.out.println(UUID.randomUUID());
        }
    }
}
