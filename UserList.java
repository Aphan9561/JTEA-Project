import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static User user = null;
    private static ArrayList<User> userList;

    private UserList()
    {
        userList = DataLoader.getUsers();
    }
    public static UserList getInstance(){
        if(user == null){
            user = new User(null, null, null, null, null, null);
        }

        return user;
    }

    public void addUser(User user)
    {

    }

    public ArrayList<User> getUser(String UserName){
        return null;
    }

    public UUID getUser(UUID id){
        return id;
    }

    public void editUser(String firstName, String lastName, String username){

    }

    public void saveUser(){
        
    }
}
