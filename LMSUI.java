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
    private String[] menu = {"1: Find course by keyword","2: Find course","3: Get current courses ", "4: Enter a course", "5: Go to author menu","6: Quit"};
    private String[] authorMenu = {"1: ","2: ","3: ","4: ","5: ", "6: ", "7: ","8: ", "9: ", "10: ","11: ","12: Go to user menu","13: Quit"}; 

    public LMSUI() 
    {
        keyboard = new Scanner(System.in);
        application = LMSApplication.getInstance();
    }

    public void run()
    {
        loginIn();
        boolean running = true;
       while(running == true)
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
                runAuthor();
                break;
            case 6:
                running = false;
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
                    this.user = signUp(AccountType.STUDENT);
                    if(this.user != null)
                    {
                        haveUser = true;
                    }
                    break;
                case 2:
                    //Sign up as author
                    this.user = signUp(AccountType.AUTHOR); 
                    if(this.user != null)
                    {
                        haveUser = true;
                    }
                    break;
                case 3:
                    boolean loginedIn = false;
                    while(loginedIn == false)
                     {
                        System.out.println("Please enter your username below.\n"); 
                        String username = keyboard.nextLine();
                        System.out.println("Please enter your password below.");
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

    private User signUp(AccountType accountType)
    {
        System.out.println("Please give your first name below."); 
        String firstName = keyboard.nextLine();
        System.out.println("Please give your last name below. "); 
        String lastName = keyboard.nextLine();
        System.out.println("Please give your email below."); 
        String email = keyboard.nextLine();
        System.out.println("Please give your birthday date below");
        String birthdayDate= keyboard.nextLine();
        Date date = convertDate(birthdayDate); 
        System.out.println("Please enter your username below."); 
        String username = keyboard.nextLine();
        System.out.println("Please enter your password below.");
        String password = keyboard.nextLine();
        this. user = application.createAccount(firstName, lastName, email, date, username, password, accountType);
        return this.user;
    }

    private Date convertDate(String birthdayDate)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        Date date = new Date();
        try
            {  
                date = formatter.parse(birthdayDate);  
            }   catch (ParseException e) {e.printStackTrace();}  
            return date;
    }

    public void displayMainMenu() 
    {
        //Make an array here for all the options so it is not. Then run though it. 
        //Make options more description??
        System.out.println("Hello! Welcome to J Tea's system. Please press the number one the side to do that");
        for(int i = 0; i < menu.length; i++)
        {
            System.out.println(menu[i]);
        }
    }
    private void displayAuthorMenu()
    {
        //Check if author done in switch in run
        //Make options more description??
        System.out.println("Hello to the author side. Only use this side to make and edit course. Not able to do course in this mode");
        for(int i = 0; i < authorMenu.length; i++)
        {
            System.out.println(menu[i]);
        }
    }

    private void runAuthor()
    {
        while(true)
        {
         displayAuthorMenu(); 
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
                 displayAuthorMenu();
                 break;
             case 13:
                 break;
             default:
                 break;
         }
         break;
        }
    }
    public static void main(String[] args) 
    {
        LMSUI lmsui = new LMSUI();
        lmsui.run();
    }
}