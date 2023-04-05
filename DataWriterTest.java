import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
    private UserList user = UserList.getInstance();
    private ArrayList<User> users = user.getUsers();

    @BeforeEach
    public void setup(){
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown(){
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }
    
    @Test
    void testWritingZeroUsers() {
		users = DataLoader.getUsers();
		assertEquals(0, user.size());
	}

    @Test
    void testWritingOneUser(){
        users.add(new User("Anne","Dennis","ADen@email.com",new Date(10/02/2023), "adennis2", "catsForLife",AccountType.STUDENT));
        DataWriter.saveUsers();
        assertEquals("adennis2", DataLoader.getUsers().get(0).getUsername());
    }
}
