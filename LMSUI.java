import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
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
    private Course course;
    private Module module;
    private Lesson lesson;
    private UUID authorId;
    private Question question;
    private Difficulty diffStatus;
    private Language lang; 
    final private String[] menu = {"Find course by keyword","Find course","Get current courses ", "Go to author menu","Quit"};
    private String[] authorMenu = {"Create course","Enter course  to edit course ","Go to user menu","Quit"}; 

    public LMSUI() 
    {
        keyboard = new Scanner(System.in);
        application = LMSApplication.getInstance();
    }

    public void run()
    {
        System.out.println("Welcome to Our program. Please choose one of the following.");
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
                System.out.println("What would would like to search for? Suggested terms to get the best result:\nFor lanuages: Python, Java\nDiffeculty: Easy, Medium, Hard");
                String keyword = keyboard.nextLine();
                keyword.toUpperCase();
                //ArrayList<Course> resultList = application.findCourse(keyword);
                //printCourses(resultList);
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
        this.user = application.createAccount(firstName, lastName, email, date, username, password, accountType);
        return this.user;
    }

    private User loginIn()
    {
        System.out.println("Please enter your username below."); 
        String username = keyboard.nextLine();
        System.out.println("Please enter your password below.");
        String password = keyboard.nextLine();
        this.user = application.login(username, password);
        System.out.println("Welcome "+ user.getFirstName()+" "+user.getLastName());
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

    private Course createCourse()
    {
        this.user.getId();
        System.out.println("Name:");
        String name = keyboard.nextLine();
        System.out.println("Difficulty (Options: Easy, Medium, or Hard): ");
        String difficulty = keyboard.nextLine();
            Difficulty difficulty2;
            if(difficulty.equalsIgnoreCase("easy")){
                difficulty2 = diffStatus.EASY;
            } else if (difficulty.equalsIgnoreCase("medium")){
                difficulty2 = diffStatus.MEDIUM;
            } else if(difficulty.equalsIgnoreCase("hard")){
                difficulty2 = diffStatus.HARD;
            } else {
                System.out.println("Incorrect input. Course has been set to EASY.");
                difficulty2 = diffStatus.EASY;
            }
        Language language2 = lang.PYTHON;
        boolean validLanguage = false;
        while(validLanguage){
            System.out.println("Language (Options: Python, Javascript, or GitHub): ");
            String language = keyboard.nextLine(); 
                if(language.equalsIgnoreCase("Python")){
                    language2 = lang.PYTHON;
                    validLanguage = true;
                } else if(language.equalsIgnoreCase("JavaScript")){
                    language2 = lang.JAVASCRIPT;
                    validLanguage = true;
                } else if(language.equalsIgnoreCase("GitHub")){
                    language2 = lang.GITHUB;
                    validLanguage = true;
                } else {
                    System.out.println("Incorrect input. Try again.");
                    validLanguage = false;
                }
        }
        System.out.println("Decription: ");
        String decription = keyboard.nextLine();
        System.out.println("Syllabus: ");
        String syallbus = keyboard.nextLine();
        System.out.println("How many module?");
        int numberOfModules = keyboard.nextInt();
        keyboard.nextLine();
        ArrayList<Module> modules = new ArrayList<>();
        for(int i = 0; i < numberOfModules; i++){
            Module module = addModule();
            modules.add(module);
        }
        this.course = application.createCourse(authorId, name, decription, syallbus, difficulty2, language2, modules);
        return this.course;
    }

    private void editCourse()
    {
        System.out.println("What course would you like to edit?");
        ArrayList<Course> list =  application.findCourse(); 
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId().equals(this.user.getId());
            {
                System.out.print(i+": "+list.get(i).getTitle());
            }
        }

        int choice = keyboard.nextInt();
        Course editCourse = list.get(i);
        System.out.println("1: Add module 2:Add Lessons 3: Go back to author menu");
        boolean run = true;
        while(run == true)
        {
            choice = keyboard.nextInt();
            switch(choice){
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
                run = false;
            break;
            default:
            break;
            } 
        }
    }

    private Module addModule()
    {
        System.out.println("What is the title?");
        String title = keyboard.nextLine();
        System.out.println("How many lessons?");
        ArrayList<Lesson> lessons = new ArrayList<>();
        int lessonNumber = keyboard.nextInt();
        keyboard.nextLine();
        for(int i = 0; i < lessonNumber; i++)
        {
            Lesson lesson = addLesson();
            lessons.add(lesson);
        }
        this.module = application.addModule(title, lessons);
        return this.module;
    }

    private Lesson addLesson()
    {
        System.out.println("Title: ");
        String title = keyboard.nextLine();
        System.out.println("Content: ");
        String content = keyboard.nextLine();
        System.out.println("How many questions in the quiz? ");
        int numberOfQuestions = keyboard.nextInt();
        keyboard.nextLine();
        ArrayList<Question> questions = new ArrayList<>(); //A quiz is an list a questions 
        Quiz quiz = new Quiz(questions);
        for(int i =0; i< numberOfQuestions; i++){
            Question question = addQuestion();
            questions.add(question);
        }
        
        this.lesson = application.addLesson(title, content, quiz);
        return this.lesson;
    }

    private Question addQuestion(){
        System.out.println("Question: ");
        String question = keyboard.nextLine();
        System.out.println("Enter 4 answer options: ");
        ArrayList<String> answers = new ArrayList<>();
        for(int i =0; i< 4;i++){
            String input = keyboard.nextLine();
            answers.add(input);
        }
        System.out.println("Which answer is the correct one? Enter in the corresponding number.");
        int correctAnswer = keyboard.nextInt();
        keyboard.nextLine();
        this.question = application.addQuestion(question, answers, correctAnswer);
        return this.question;
    }

    private void takeQuiz(ArrayList<Question> questions){
        System.out.println("Starting quiz: \n");
        for(int i=0; i < questions.size();i++){
            System.out.println(questions.get(i));
            //print questions and answer
            //ask user for answer and compare to correct answer
        }
    }

    private void viewCourse(EnrolledCourse course){
        System.out.println(course.toString());
    }

    private void viewGrades(EnrolledCourse course){
        //???
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