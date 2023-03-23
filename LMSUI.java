import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;
/*
 * This is a UI that allows the user to give input
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

import javax.management.loading.PrivateClassLoader;

public class LMSUI {
    private Scanner keyboard;
    private LMSApplication application;
    private User user;
    final private String[] menu = {"1: Find course by keyword","2: Find course","3: Get current courses ", "4: Go to author menu","5: Quit"};
    private String[] authorMenu = {"1: Create course","2: Enter course  to edit course ","4: Go to user menu","5: Quit"}; 

    public LMSUI() 
    {
        keyboard = new Scanner(System.in);
        application = LMSApplication.getInstance();
    }

    public void run()
    {
        login();
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
                ArrayList<Course> resultList = application.findCourse(keyword);
                printCourses(resultList);
                break;
            case 2:
            System.out.println("Printing all courses:");
                ArrayList<Course> allCourses = application.findCourse();
                printCourses(allCourses);
                break;
            case 3:
                ArrayList<EnrolledCourse> enrolledCourse = application.getCurrentCourse();
                printEnrolledCoures(enrolledCourse);
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
    private boolean login()
    {
        boolean loop = true;
        while(loop == true)
        {
            System.out.println("To create an user account please type 1. To create an author account please type 2. \nTo login please type 3");
            int choice = keyboard.nextInt();
            keyboard.nextLine();

            switch(choice)
            {
                case 1:
                    //Sign up as user
                    if(signUp(AccountType.STUDENT) != null)
                    {
                        return true;
                    }
                    break;
                case 2:
                    //Sign up as author
                    if(signUp(AccountType.AUTHOR) != null)
                    {
                        return true;
                    }
                    break;
                case 3:
                     if(loginIn() != null)
                     {
                        return true;
                     }   
                    break;
                case 4: 
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        return false; //The program should not reach here. This just make sure that the program know that it returns something.
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

    private User loginIn()
    {
        System.out.println("Please enter your username below."); 
        String username = keyboard.nextLine();
        System.out.println("Please enter your password below.");
        String password = keyboard.nextLine();
        this.user = application.login(username, password);
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
        /*
         *  private String[] authorMenu = {"1: Create course","2: Enter course  to edit course ","3: Go to user menu","5: Quit"}; 
         */
        boolean running = true;
        while(running)
        {
         displayAuthorMenu(); 
         int choice = keyboard.nextInt();
         keyboard.nextLine();
         switch (choice) 
         {
             case 1: 
                createCourse();
                 break;
             case 2:
                editCourse();
                 break;
             case 4:
                 run();
                 break;
             case 5:
                running = false;
                 break;
             default:
                 break;
         }
         break;
        }
    }

    private void createCourse()
    {

    }

    private void editCourse()
    {
        
    }

    private void printCourses(ArrayList<Course> courses)
    {
        for(int i = 0; i < courses.size(); i++)
        {
            System.out.println(courses.get(i));
        }
    }
    
    private void printEnrolledCoures(ArrayList<EnrolledCourse> courses)
    {
        for(int i = 0; i < courses.size(); i++)
        {
            System.out.println(courses.get(i));
        }
    }

    public static void main(String[] args) 
    {
        LMSUI lmsui = new LMSUI();
        lmsui.run();
        System.out.println("Exiting the system. Have a good day!");
        System.exit(0);
    }
}