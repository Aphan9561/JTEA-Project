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
    private String[] menu = {"1: Find course by keyword","2: Find course","3: Get current courses ", "4: Go to author menu","5: Quit"};
    private String[] authorMenu = {"1: Create course","2: Enter course  to edit course ","4: Go to user menu","5: Quit"}; 

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
                System.out.println("What would would like to search for? Suggested terms to get the best result:/nFor lanuages: Python, Java/nDiffeculty: Easy, Medium, Hard");
                String keyword = keyboard.nextLine();
                keyword.toUpperCase();
                application.findCourse(keyword);
                break;
            case 2:
                application.findCourse(); 
                break;
            case 3:
                application.getCurrentCourse();
                break;
            case 4:
                runAuthor();
                break;
            case 5:
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
    // Why? Trying to understand why? How does this help? I have it set this.user equal to something valid every time. It is in a while until something valid happens- Eve
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

    private Date convertDate(String birthdayDate) //This does not seem to work. Why?
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
        System.out.println("Hello! Welcome to J Tea's system. Please press the number one the side to do that");
        for(int i = 0; i < menu.length; i++)
        {
            System.out.println(menu[i]);
        }
    }
    private void displayAuthorMenu()
    {
        System.out.println("Hello to the author side. Only use this side to make and edit course. Not able to do course in this mode");
        for(int i = 0; i < authorMenu.length; i++)
        {
            System.out.println(authorMenu[i]);
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
                 run();
                 break;
             case 5:
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