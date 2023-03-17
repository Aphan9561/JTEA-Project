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
    private Scanner keyboard;
    private LMSApplication application;

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
            default:
                break;
        }
        break;
       }
       keyboard.close();
    }

    private void loginIn()
    {
        System.out.println("To create an account please type 1 \n or \n To login please type 2");
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        boolean haveUser = false;
        while(haveUser == false){
            if(choice == 1)
            {
                System.out.println("Please give your first name below.\n"); 
                String firstName = keyboard.nextLine();
                System.out.println("\nPlease give your last name below. \n"); 
                String lastName = keyboard.nextLine();
                System.out.println("\nPlease give your email below.\n"); 
                String email = keyboard.nextLine();
                System.out.println("\nPlease give your birthday date below");
                String birthdayDate= keyboard.nextLine();
                Date date;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
              try 
                {  
                    date = formatter.parse(birthdayDate);  
                }   catch (ParseException e) {e.printStackTrace();}  
                System.out.println("\nPlease enter your username below.\n"); 
                String username = keyboard.nextLine();
                System.out.println("\nPlease enter your password below.\n");
                String password = keyboard.nextLine();
                application.createAccount(firstName, lastName, email, date, username, password);
                application.login(username, password);
                haveUser = true;
            }
        
        if(choice == 2)
        {  
            boolean loginedIn = false;
            while(loginedIn == false)
            {
                System.out.println("\nPlease enter your username below.\n"); 
                String username = keyboard.nextLine();
                System.out.println("\nPlease enter your password] below.\n");
                String password = keyboard.nextLine();
                User user = application.login(username, password);
                if(user != null)
                {
                    loginedIn = true;
                    haveUser = true;
                }
            }
         //If choice was not 1 or 2. It will continue to loop.
        }
    }

    public void displayMainMenu() 
    {

    }
    public static void main(String[] args) 
    {
        LMSUI lmsui = new LMSUI();
        lmsui.run();
    }
}