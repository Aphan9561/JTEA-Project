import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * this is the user list
 * @author: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class UserList {
    private static ArrayList<User> users;
    private static UserList userList;
    /**
     * Gets the users from the JSON
     */
    private UserList() {
        users = DataLoader.getUsers();
    }
    /**
     * Creates a new user list
     * @return the new user list
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }
    /**
     * Checks if this user exist by looking for username
     * @param userName this is the user's username
     * @return wheather the username is already used
     */
    public boolean haveUser(String userName) {
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Checks if this user exist by looking for username and password
     * @param userName User's Username
     * @param password User's Password
     * @return wheather the username and password is already used
     */
    public boolean haveUser(String userName, String password) {
        for (User user : users) {
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Adding a new user
     * @param firstName user's first name
     * @param lastName user's last name
     * @param email user' email
     * @param birthday  user's birthday
     * @param username user's username
     * @param password user's password
     * @param type type of account the user is wanting
     * @return wheather the user is added or not
     */
    public boolean addUser(String firstName, String lastName, String email, Date birthday, String username,
            String password, AccountType type) {
        if (haveUser(username))
            return false;

        users.add(new User(firstName, lastName, email, birthday, username, password, type));
        saveUsers();
        return true;
    }
    /**
     * gets the user with id number
     * @param id user's id number
     * @return the user
     */
    public User getUser(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    /**
     * gets the user with username
     * @param userName user's username
     * @return the user
     */
    public User getUser(String userName) {
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }

        return null;
    }
    /**
     * list of users
     * @return users
     */
    public ArrayList<User> getUsers() {
        return users;
    }
    /**
     * saves the users and writes them to the user json
     */
    public void saveUsers() {
        DataWriter.saveUsers();
    }
    /**
     * get the size of the user list
     * @return the size of the user list
     */
    public int size() {
        return users.size();
    }
    /**
     * find the user with username
     * @param id user's id
     * @return the user
     */
    public String findUsername(UUID id) {
        User temp = null;
        for (User user : users) {
            if (user.getId().equals(id)) {
                temp = user;
            }
        }
        return temp.username;
    }
}
