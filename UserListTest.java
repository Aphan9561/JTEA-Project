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
    //Find one user name
    @Test
    public void testHaveUserValidFirstItemWithUsername() {
        boolean hasAnne = user.haveUser("adennis2");
        assertTrue(hasAnne);
    }
    //Find last user name
    @Test
    public void testHaveUserValidLastItemWithUsername(){
        boolean hasKim = user.haveUser("kNguyen");
        assertTrue(hasKim);
    }
    //Find invalid user
    @Test
    public void testHaveUserInValidWithUsername(){
        boolean hasMatt = user.haveUser("mSmith");
        assertFalse(hasMatt);
    }
    //Find empty username
    @Test
    public void testHaveUserEmptyWithUsername(){
        boolean hasEmpty = user.haveUser("");
        assertFalse(hasEmpty);
    }
    //Find null username
    @Test
    public void testHaveUserNullWithUsername(){
        boolean hasNull = user.haveUser(null);
        assertFalse(hasNull);
    }
    //Find first user with username and password
    @Test
    public void testHaveUserValidFirstItemWithUsernameAndPassword() {
        boolean hasAnne = user.haveUser("adennis2","catsForLife");
        assertTrue(hasAnne);
    }
    //Find last user with username and password
    @Test
    public void testHaveUserValidLastItemWithUsernameAndPassword(){
        boolean hasKim = user.haveUser("kNguyen","foodieForLife");
        assertTrue(hasKim);
    }
    //find invalid user with username and password
    @Test
    public void testHaveUserInValidWithUsernameAndPassword(){
        boolean hasMatt = user.haveUser("mSmith","alsdkf386jhhk$j");
        assertFalse(hasMatt);
    }
    //Find empty user with username and password
    @Test
    public void testHaveUserEmptyWithUsernameAndPassword(){
        boolean hasEmpty = user.haveUser("","");
        assertFalse(hasEmpty);
    }
    //find null user with username and password
    @Test
    public void testHaveUserNullWithUsernameAndPassword(){
        boolean hasNull = user.haveUser(null,null);
        assertFalse(hasNull);
    }
    //adding vaild user
    @Test
    public void testAddUserValid(){
        boolean addBill = user.addUser("Bill", "Dennis", "bdennis@gmail.com", new Date(01/12/2000), "bdennis", "DogLover3498", AccountType.AUTHOR);
        assertTrue(addBill);
    }
    //adding empty user
    @Test
    public void testAddUserEmpty(){
        boolean addEmpty = user.addUser("", "", "", new Date(), "", "", AccountType.STUDENT);
        assertTrue(addEmpty);
    }
    //adding invalid user
    @Test
    public void testAddUserInValid(){
        boolean addAndrew = user.addUser("Andrew", "Dennis", "aDennis@gmail.com", new Date(01/12/1923), "adennis2", "catsForLife", AccountType.STUDENT);
        assertFalse(addAndrew);
    }

}
