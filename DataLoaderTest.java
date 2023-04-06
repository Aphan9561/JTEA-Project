import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();

    @BeforeEach
    public void setup() {
        users.clear();
        users.add(new User("John","Deere",))
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        //add 
        DataWriter.saveUsers();
    }

    //test get users size

    //test get users size 0

    //test get user id

    //test get user valid firstName

    //test get user null firstName

    //test get user valid lastName

    //test get user null lastName

    //test get user valid email

    //test get user null email

    //test get user valid birthday

    //test get user null birthday

    //test get user wrong format birthday

    //test get user valid username

    //test get user null username

    //test get user valid password

    //test get user null password

    //test get user valid type

    //test get user null type

    //test get user unknown type

    //test get courses size

    //test get courses size 0

    //test get FAQs size

    //test get FAQs size 0


    
}
