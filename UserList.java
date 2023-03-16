import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class UserList {
    private static ArrayList<User> user;
    private static UserList userList = null;

    private UserList()
    {
        user = DataLoader.getUsers();
    }
    public static UserList getInstance(){
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }

    public void addUser(String firstName, String lastName, String email, Date birthday, String username, String type)
    {
        user.add(new User(firstName, lastName,email, birthday, username, type));
    }

    public ArrayList<User> getUser(String UserName){
        return user;
    }

    public ArrayList<User> getUser(UUID id){
        return user;
    } 

    public void logout(){
        DataWriter.saveUsers();
    }
}
