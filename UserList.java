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

    public boolean haveUser(String userName) {
		for(User user : users) {
			if(user.getUsername().equals(userName)) {
				return true;
			}
		}
		return false;
	}

    public boolean addUser(String firstName, String lastName, String email, Date birthday, String username, String password, AccountType type)
    {
        if(haveUser(username))
            return false;
    
        users.add(new User(firstName, lastName,email, birthday, username, password, type));
        DataWriter.saveUsers();
        return true;
    }

    public User getUser(UUID id) {
		for(User user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

    public User getUser(String userName, String password) {
		for(User user : users) {
			if(user.getUsername().equals(userName) && user.getPassword().equals(password)) {
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

    public int size() {
        return users.size();
    }
}
