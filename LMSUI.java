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
    final private String[] menu = {"Find course by keyword","Find course","Get current courses ", "Go to author menu","Quit"};
    private String[] authorMenu = {"Create course","Enter course  to edit course ","Go to user menu","Quit"}; 

    public LMSUI() 
    {
        keyboard = new Scanner(System.in);
        application = LMSApplication.getInstance();
    }

    public void run()
    {
        System.out.println("Welcome to Our program. Please choose one of the following.\n");
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
                if(this.user.getType().equals(AccountType.AUTHOR) )
                {
                    runAuthor();
                }
                else{
                    System.out.println("Access denied. You are not an author!");
                }
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

    private boolean login()
    {
        boolean loop = true;
        while(loop == true)
        {
            System.out.println("To create an user account please type 1. \nTo create an author account please type 2. \nTo login please type 3");
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
        System.out.println("Hello! Welcome to J Tea's system. Please press the number one the side to do that");
        for(int i = 0; i < menu.length; i++)
        {
            System.out.println(i+1+": "+menu[i]);
        }
    }
    private void displayAuthorMenu()
    {
        System.out.println("Hello to the author side. Only use this side to make and edit course. Not able to do course in this mode");
        for(int i = 0; i < authorMenu.length; i++)
        {
            System.out.println(i+1+": "+authorMenu[i]);
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
        System.out.println("Name:");
        String name = keyboard.nextLine();
        System.out.println("Description:");
        String description = keyboard.nextLine();
        System.out.println("Difficulty:");
        String difficultyString = keyboard.nextLine();
        Difficulty diffieculty = Difficulty.valueOf(difficultyString);
        String languageString = keyboard.nextLine();
        Language language = Language.valueOf(languageString);
        Course course = new Course(name, description, diffieculty, language);
        System.out.println("Add modules. How many");
        int moduleNumber = keyboard.nextInt();
        for(int i = 0; i < moduleNumber; i++)
        {
            addModule();
        }
    }

    private void editCourse()
    {
        System.out.println("What course would you like to edit?");
        //get the courses of the author and print them
        int choice = keyboard.nextInt();
        //Enter the course
        //Ask whether you would like add modules or add lesson
        boolean run = true;
        while(run == true)
        {
            choice = keyboard.nextInt();
            switch(choice)
            case 1:
                System.out.println("Add modules. How many");
                int moduleNumber = keyboard.nextInt();
                for(int i = 0; i < moduleNumber; i++)
                {
                    addModule();
                }
            break;
            case 2:
                System.out.println("Add lesson. How many");
                int lessonNumber = keyboard.nextInt();
                for(int i = 0; i < lessonNumber; i++)
                {
                    addLesson();
                }
            break;
            case 3:
                run =false;
            break;
            default:
            break;
        }
    }

    private void addModule()
    {
        System.out.println();

    }

    private void addLesson()
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