import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserListTest {
    private UserList user = UserList.getInstance();
    private ArrayList<User> users = user.getUsers();

    @BeforeEach
    public void setup() {
        users.clear();
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.STUDENT));
        users.add(new User("Kim","Nguyen","kNguyen@email.com",new Date(10/03/1960), "kNguyen", "foodieForLife",AccountType.AUTHOR));
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown(){
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @Test
    void testHaveUserValidFirstItemWithUsername() {
        boolean hasAnne = user.haveUser("adennis2");
        assertTrue(hasAnne);
    }

    @Test
    void testHaveUserValidLastItemWithUsername(){
        boolean hasKim = user.haveUser("kNguyen");
        assertTrue(hasKim);
    }
    
    @Test
    void testHaveUserValidFirstItemWithUsernameAndPassword() {
        boolean hasAnne = user.haveUser("adennis2","catsForLife");
        assertTrue(hasAnne);
    }

    @Test
    void testHaveUserValidLastItemWithUsernameAndPassword(){
        boolean hasKim = user.haveUser("kNguyen","foodieForLife");
        assertTrue(hasKim);
    }
}
