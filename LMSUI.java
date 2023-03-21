import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;
/*
 * This is a UI that allows the user to give input
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

public class LMSUI {
    // more constants
    private Scanner keyboard;
    private LMSApplication application;
    private User user;

    public LMSUI() 
    {
        keyboard = new Scanner(System.in);
        application = LMSApplication.getInstance();
    }

    public void run()
    {
        loginIn();
       while(true)
       {
        displayMainMenu(); //Library example
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        switch (choice) 
        {
            case 1: 
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5: 
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9: 
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            default:
                break;
        }
        break;
       }
       keyboard.close();
    }

    // return a user here instead of void
    private void loginIn()
    {
        System.out.println("To create an user account please type 1. To create an author account please type 2. \nTo login please type 3");
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        boolean haveUser = false;
        while(haveUser == false)
        {
            switch(choice)
            {
                case 1:
                    //Sign up as user
                    haveUser = signUp(AccountType.STUDENT);
                    break;
                case 2:
                    //Sign up as author
                    haveUser = signUp(AccountType.AUTHOR); 
                case 3:
                    boolean loginedIn = false;
                    while(loginedIn == false)
                     {
                        System.out.println("Please enter your username below.\n"); 
                        String username = keyboard.nextLine();
                        System.out.println("Please enter your password] below.");
                        String password = keyboard.nextLine();
                        User user = application.login(username, password);
                        if(user != null)
                        {
                            loginedIn = true;
                            haveUser = true;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private boolean signUp(AccountType accountType)
    {
        System.out.println("Please give your first name below."); 
        String firstName = keyboard.nextLine();
        System.out.println("Please give your last name below. "); 
        String lastName = keyboard.nextLine();
        System.out.println("Please give your email below."); 
        String email = keyboard.nextLine();
        System.out.println("Please give your birthday date below");
        String birthdayDate= keyboard.nextLine();
        // private helper method here
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        try 
            {  
                date = formatter.parse(birthdayDate);  
            }   catch (ParseException e) {e.printStackTrace();}  
        System.out.println("Please enter your username below."); 
        String username = keyboard.nextLine();
        System.out.println("Please enter your password below.");
        String password = keyboard.nextLine();
        // create the account and then return login to check if it worked 
        application.createAccount(firstName, lastName, email, date, username, password, accountType);
        application.login(username, password);
        return true;
    }

    public void displayMainMenu() 
    {
        String n = "\n"; //New line
        //Make options more description??
        String greeting = "Hello! Welcome to J Tea's system. Please press the number one the side to do that";
        String one = "1: Find Course by keyword";
        String two = "2: " ;
        String three = "3: ";
        String four = "4: " ;
        String five = "5: ";
        String six = "6: " ;
        String seven = "7 : ";
        String eight = "8: " ;
        String nine = "9: " ;
        String ten = "10 : ";
        String eleven = "11: " ;
        String twelve = "12: Go to author menu";
        String thirteen = "13: Quit";
        

        String menu = greeting + n + one + n + two + n + three + n + four + n + five + n + six + n + seven + n+ eight + n + nine + n + ten + n + eleven + n + twelve+ n + thirteen;
        System.out.println(menu);
    }

    // make name more action orentied
    private void authorMode()
    {
        if(this.user.getType == AccountType.AUTHOR)
        {

        }
        displayAuthorMenu();
    }

    private void displayAuthorMenu()
    {
        //Check if author done in switch in run
        String n = "\n"; //New line
        //Make options more description??
        String greeting = "Hello to the author side. Only use this side to make and edit course. Not able to do course in this mode";
        String one = "1: Find Course by keyword";
        String two = "2: " ;
        String three = "3: ";
        String four = "4: " ;
        String five = "5: ";
        String six = "6: " ;
        String seven = "7 : ";
        String eight = "8: " ;
        String nine = "9: " ;
        String ten = "10 : ";
        String eleven = "11: " ;
        String twelve = "12: Go to user menu";
        String thirteen = "13: Quit";
        

        String menu = greeting + n + one + n + two + n + three + n + four + n + five + n + six + n + seven + n+ eight + n + nine + n + ten + n + eleven + n + twelve+ n + thirteen;
        System.out.println(menu);
    }

    public static void main(String[] args) 
    {
        LMSUI lmsui = new LMSUI();
        lmsui.run();
    }
}