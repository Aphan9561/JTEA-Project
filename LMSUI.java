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
    //private Lesson tempLesson;
    // private Quiz quiz;
    // private Question question;
    private Difficulty diffStatus;
    private Language lang; 
    private Student student;
    final private String[] menu = {"Find course by keyword","Find course","Get current courses ", "Go to author menu","View Grades","Take Quiz", "View Course","Quit"};
    private String[] authorMenu = {"Create course","Enter course to edit course ","Go to user menu","Quit"}; 

    public LMSUI() 
    {
        keyboard = new Scanner(System.in);
        application = LMSApplication.getInstance();
    }

    public void run()
    {
        System.out.println("Welcome to Our program. Please choose one of the following.");
        login();
        while(true)
        {
            displayMainMenu(); 
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            switch (choice) 
            {   
            case 1:
                //This can be a method
                System.out.println("What would would like to search for? Suggested terms to get the best result:\nFor lanuages: Python, Java\nDiffeculty: Easy, Medium, Hard");
                String keyword = keyboard.nextLine();
                keyword.toUpperCase();
                //ArrayList<Course> resultList = application.findCourse(keyword);
                //printCourses(resultList);
                break;
            case 2:
                //This can be a method
                System.out.println("Printing all courses:");
                ArrayList<Course> allCourses = application.findCourse();
                printCourses(allCourses);
                break;
            case 3:
                //This can be a method
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
                viewGrades();
                break;
            case 6:
                takeQuiz();
                break;
            case 7:
                // for testing purposes it needs to be hard coded
                Course course = createCourse();
                EnrolledCourse enrolledCourse2 = new EnrolledCourse(course, true);
                ArrayList<EnrolledCourse> test = new ArrayList<EnrolledCourse>();
                test.add(enrolledCourse2);
                viewCourse(test);
                break;
            case 8:
                keyboard.close();
                return;
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

    private Course createCourse(){
        System.out.println("Course Title: ");
        String name = keyboard.nextLine();
        System.out.println("Difficulty (Options: EASY, MEDIUM, or HARD): ");
        String difficulty = keyboard.nextLine();
        Difficulty difficulty2 = getDifficlty(difficulty);
        System.out.println("Language (Options: PYTHON, JAVASCRIPT, or GITHUB): ");
        String language = keyboard.nextLine(); 
        Language language2 = getLanguage(language);
        System.out.println("Description: ");
        String description = keyboard.nextLine();
        System.out.println("Syllabus: ");
        String syallbus = keyboard.nextLine();
        System.out.println("How many module?");
        ArrayList<Module> modules = new ArrayList<Module>();
        int numberOfModules = keyboard.nextInt();
        keyboard.nextLine();
        for(int i = 0; i < numberOfModules; i++){
            System.out.println("Module Title: ");
            String Mtitle = keyboard.nextLine();
            System.out.println("How many lessons?");
            ArrayList<Lesson> lessons = new ArrayList<Lesson>();
            int lessonNumber = keyboard.nextInt();
            keyboard.nextLine();
            for(int j = 0; j < lessonNumber; j++)
            {
                System.out.println("Lesson Title: ");
                String Ltitle = keyboard.nextLine();
                System.out.println("Content: ");
                String content = keyboard.nextLine();
                System.out.println("How many questions in the quiz? ");
                ArrayList<Question> questions = new ArrayList<Question>();
                int numberOfQuestions = keyboard.nextInt();
                keyboard.nextLine();
                for(int l =0; l< numberOfQuestions; l++){
                    System.out.println("Question: ");
                    String ques = keyboard.nextLine();
                    System.out.println("Enter 4 answer options: ");
                    ArrayList<String> answers = new ArrayList<String>();
                    for(int m =0; m< 4;m++){
                        String input = keyboard.nextLine();
                        answers.add(input);
                    }
                    System.out.println("Which answer is the correct one? Enter in the corresponding number. Starting at 0 to 3");
                    int correctAnswer = keyboard.nextInt();
                    keyboard.nextLine();

                    Question question = new Question(ques, answers, correctAnswer);
                    questions.add(question);
                    
                }

                System.out.println(questions);

                Quiz quiz = new Quiz(questions);
                System.out.println(quiz);
                Lesson lesson = new Lesson(content, Ltitle, quiz);

                lessons.add(lesson);
            }

            Module module = new Module(Mtitle, lessons);
            modules.add(module);
        }
        this.course = application.createCourse(user.id, name, description, syallbus, difficulty2, language2, modules);
        System.out.println("this.course in CreateCourse\n"+this.course);
        return this.course;
    }

    private Difficulty getDifficlty(String difficulty){
        if(difficulty.equalsIgnoreCase("easy")){
            diffStatus = diffStatus.EASY;
        } else if (difficulty.equalsIgnoreCase("medium")){
            diffStatus = diffStatus.MEDIUM;
        } else if(difficulty.equalsIgnoreCase("hard")){
            diffStatus = diffStatus.HARD;
        } else {
            System.out.println("Incorrect input. Course has been set to EASY.");
        }
        return diffStatus;
    }

    private Language getLanguage(String language){ 
        if(language.equalsIgnoreCase("Python")){
            lang = lang.PYTHON;
        } else if(language.equalsIgnoreCase("JavaScript")){
            lang = lang.JAVASCRIPT;
        } else if(language.equalsIgnoreCase("GitHub")){
            lang = lang.GITHUB;
        } else {
            System.out.println("Incorrect input.");
        } 
        return lang;
    }

    private void editCourse()
    {
        System.out.println("What course would you like to edit?");
        ArrayList<Course> list =  application.findCourse(); 
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId().equals(this.user.getId()));
            {
                System.out.print(i+": "+list.get(i).getTitle());
            }
        }

        int choice = keyboard.nextInt();
        //Course editCourse = list.get(i);
        System.out.println("1: Add module \n2:Add Lessons \n3: Go back to author menu");
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
                    //addModule();
                }
            break;
            case 2:
                System.out.println("Add lesson. How many");
                int lessonNumber = keyboard.nextInt();
                for(int i = 0; i < lessonNumber; i++)
                {
                    //addLesson();
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

    

    private void takeQuiz(){
        // might not work
        System.out.println("Starting quiz: \n");
        application.takeQuiz();
    }


    private void viewCourse(ArrayList<EnrolledCourse> enrolledCourse){
        String answer;
        int answer1, answer2;
        System.out.println("Here are all your Enrolled Courses:");
        for(int i = 0; i<enrolledCourse.size(); i++){
            System.out.println((i+1)+".: "+ enrolledCourse.get(i).getCourse().getTitle());
        }
        System.out.println("Would you like to view a Course: (Y or N)");
        answer = keyboard.nextLine();
        if(answer.equalsIgnoreCase("Y")){
            System.out.println("Which Course, choose 1-"+enrolledCourse.size());
            answer1 = keyboard.nextInt();
            System.out.println(enrolledCourse.get(answer1).getCourse().getTitle());
            System.out.println("Would you like to view the Modules of this Course: (Y or N)");
            answer = keyboard.nextLine();
            if(answer.equalsIgnoreCase("Y")){
                for(int i = 0; i<enrolledCourse.get(answer1).getCourse().getNumberOfModules(); i++){
                    System.out.println((i+1)+".: "+ enrolledCourse.get(answer1).getCourse().getModule().get(i).getTitle());
                }
                System.out.println("Would you like to view a Module's content: (Y or N)");
                answer = keyboard.nextLine();
                if(answer.equalsIgnoreCase("Y")){
                    System.out.println("Which Module, choose 1-"+enrolledCourse.get(answer1).getCourse().getNumberOfModules());
                    answer2 = keyboard.nextInt();
                    for(int i = 0; i<enrolledCourse.get(answer1).getCourse().getModule(answer2).getNumberOfLessons(); i++){
                        System.out.println(enrolledCourse.get(answer1).getCourse().getModule(answer2).getLesson(i).getTitle());
                    }
                } else{
                    System.out.println("Oh, ok then.");
                }
            }  else{
                System.out.println("Oh, ok then.");
            }
        }  else{
            System.out.println("Oh, ok then.");
        }
    }


    private void viewGrades(){
        Student student = new Student(user.id);
        System.out.println("Here are your grades "+user.firstName);
        int grades = application.getGrades();
        System.out.println(grades);
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