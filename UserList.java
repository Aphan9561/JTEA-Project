import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class UserList {
    private static ArrayList<User> users;
    private static UserList userList;

    private UserList()
    {
        users = DataLoader.getUsers();
    }
    public static UserList getInstance(){
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }

    public void addUser(String firstName, String lastName, String email, Date birthday, String username, AccountType type)
    {
        users.add(new User(firstName, lastName,email, birthday, username, type));
        DataWriter.saveUsers();
    }

    public User getUser(UUID id) {
		for(User user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		
		return null;
	}

    public ArrayList<User> getUser(){
        return users;
    } 

    public void saveUsers(){
        DataWriter.saveUsers();
    }
}
