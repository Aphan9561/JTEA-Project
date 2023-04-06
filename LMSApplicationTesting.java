import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LMSApplicationTesting {
    private ArrayList<User> userList = new ArrayList<User>();
    @BeforeEach
    public void setUp()
    {
        userList = userList.clear();
        userList.add(new User());
        userList.add(newUser());
    }

    @AfterEach
    public void tearDown()
    {

    }

    @Test
    void testSignUpValidUser()
    {

    }
    
    @Test
    void testSignUpNullUsername()
    {

    }
   
    @Test
    void testSignUpNullPassword()
    {

    }
    
    @Test
    void testSignUpNullFirstName()
    {

    }

    @Test
    void testSignUpNullLastName()
    {

    }

    @Test
    void testSignUpNullEmail()
    {

    }
    
    @Test
    void testSignUpInvalidEmail()
    {

    }
   
    @Test
    void testSignUpAllNumberPassword()
    {

    }
    
    @Test
    void testSignUpAllLowercasePassword()
    {

    }

    @Test
    void testSignUpInvalidUser()
    {

    }

    @Test
    void testSignUpFutureDate()
    {

    }
    
    @Test
    void testSignUpPastDate()
    {

    }
   
    @Test
    void testSignUpUsedEmail()
    {

    }
    
    @Test
    void testSignUpUsedUsername()
    {

    }

    @Test
    void testSignUpOldUser()
    {

    }
}
