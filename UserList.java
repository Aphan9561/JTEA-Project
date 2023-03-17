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

    public void addUser(String firstName, String lastName, String email, Date birthday, String username, AccountType type)
    {
        user.add(new User(firstName, lastName,email, birthday, username, type));
        DataWriter.saveUsers();
    }

    public ArrayList<User> getUser(UUID id){
        return user;
    } 

    public void logout(){
        DataWriter.saveUsers();
    }
}
