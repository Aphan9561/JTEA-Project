import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import java.util.zip.DataFormatException;
/**
 * This is a UI that allows the user to give input
 * @author: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

import javax.management.loading.PrivateClassLoader;

public class LMSUI {
    private Scanner keyboard;
    private LMSApplication application;
    private User user;
    private ArrayList<Course> courses = new ArrayList<Course>();
    private Course course;
    private Course editCourse;
    private Module editModule;
    private ArrayList<Module> modules = new ArrayList<Module>();;
    private ArrayList<Lesson> lessons = new ArrayList<Lesson>();
    private Difficulty diffStatus;
    private Language lang;

    final private String[] menu = {"Find course by title","Find all courses","Get current courses", "Go to author menu","View Grades","View FAQs","View Course","Quit"};
    private String[] authorMenu = {"Create course","Enter course to edit course ","Go to user menu","Quit"}; 

    /*
     * This method creates the application/facade to use the backend
     */
    public LMSUI() 
    {
        keyboard = new Scanner(System.in);
        application = LMSApplication.getInstance();
    }

    /*
     * This method runs the user side of the LMS.
     */
    public void run()
    {
        if(user == null){
        System.out.println("Hello! Welcome to J Tea's Learning Management System.");
        login();
        }
        while(true)
        {
            displayMainMenu(); 
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            switch (choice) 
            {   
            case 1:
                course = search();
                break;
            case 2:
                printAllCourses();
                break;
            case 3:
                System.out.println();
                printEnrolledCoures(application.getCurrentCourse());
                enterCourse(application.getCurrentCourse());
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
                viewFAQs();
                break; 
            case 7:
                System.out.println("Which Course would you like to view?");
                String c = keyboard.nextLine();
                Course course =  application.findCourseTitle(c);
                viewCourse(course);
                break;
            case 8:
                logout();
                keyboard.close();
                return;
            default:
                System.out.println("Invalid number. Try again");
                break;
            }
        }
    }
    
    /**
     * This method searchs for a course using a keyword 
     * @return: Course found by a keyword
     */
    private Course search()
    {
        System.out.println("What would course would you like to search for? ");
        String title = keyboard.nextLine();
        title.toUpperCase();
        return this.application.findCourseTitle(title);
    }
    
    /**
     * Prints all courses on console for user to see.
     * @return True that it has printed all courses out
     */
    private boolean printAllCourses()
    {
        System.out.println("Printing all courses:");
        ArrayList<Course> allCourses = application.findCourse();
        printCourses(allCourses);
        return true;
    }

    /**
     * This lets a user view a course and interact with a course. If the course is finished, they can print a certificate out. If it is not completed, they take the course
     * @param EnrolledCourse to interact with
     */
    private void enterCourse(ArrayList<EnrolledCourse> enrolledCourse) {
        System.out.println("Which course would you like to continue? Enter the number associated with it.");
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        
        if(choice <= enrolledCourse.size()){
        EnrolledCourse course = enrolledCourse.get(choice-1);
        //int module = course.getCurrentModule();
        //int lesson = course.getCurrentLesson();
        Course currentCourse = application.findCourse(course.getCourse());
        Module currentModule = currentCourse.getModule(course.getCurrentModule());
        Lesson currentLesson = currentModule.getLesson(course.getCurrentLesson());
            if(course.getProgress().equals(Progress.COMPLETED)){
                System.out.println("You have completed this course! Would you like to download the certification?");
                String answer = keyboard.nextLine();
                if(answer.equalsIgnoreCase("Yes")){
                    this.application.CreateCertificationFile(course);
                    System.out.println("Created Certification Text File called certification.txt for this course");
                    //Print the certificate out here too.
                }
            }
            else{ 
                /*module = course.getCurrentModule();
                lesson = course.getCurrentLesson();
                currentModule = currentCourse.getModule(module);
                currentLesson = currentModule.getLesson(lesson);*/
                    for(int i = course.getCurrentLesson(); i < currentModule.getLesson().size(); i++) {
                        System.out.println(currentLesson.miniToString());
                        System.out.println("Enter 1 to take the quiz. Any other number will take you back to your current courses.");
                        int readyChoice = keyboard.nextInt();
                        if(readyChoice == 1) {
                            int lessonGrade = takeQuiz(currentLesson.getQuiz());
                            double tempGrade = lessonGrade/100;
                            //int lessonToTempModuleGrade = 
                            //need to finish adding grades
                        } else {
                            System.out.println("Invalid input. Going back to your current courses.");
                            enterCourse(enrolledCourse);
                        }
                    } 
                }
                System.out.println(currentLesson.miniToString());
                int grade = takeQuiz(currentLesson.getQuiz());
                System.out.println("Grade from quiz: "+grade);
                System.out.println("1)Next lesson, 2)See comments, 3)Take again, 4)Print module out");
                choice = keyboard.nextInt();
                keyboard.nextLine();
                switch(choice){
                    case 1:
                        application.nextLesson(course); //Need more development
                        viewCourse(course);
                        break;
                    case 2: //Make method for this. 
                        ArrayList<Comment> comments = currentModule.getComment();
                        String commentString = "";
                        for(int i = 0; i < comments.size(); i++){
                            commentString += comments.get(i).toString();
                            commentString += "/n";
                        }
                        System.out.println(commentString);
                        break;
                    case 3:
                        System.out.println(currentLesson.miniToString());
                        grade = takeQuiz(currentLesson.getQuiz());
                        System.out.println("Grade from quiz: "+grade);
                        break;
                    case 4:
                    CreateCourseFile(currentModule);
                    break;
                    case 5: 
                        return;
                    default:
                        System.out.println("Invalid number. Try again");
                        break;
               }   
            }}
        
        /*} else {
        System.out.println("You gave a wrong number. Going back to the main menu.\n");
        }*/
    
    
    /**
     * This allows a user to take a course
     * @param Course: The course they want to take
     */
    private void viewCourse(EnrolledCourse course)
    {
        int module = course.getCurrentModule();
        int lesson = course.getCurrentLesson();
        Course currentCourse = application.findCourse(course.getCourse());
        Module currentModule = currentCourse.getModule(module);
        Lesson currentLesson = currentModule.getLesson(lesson);
        System.out.println(currentLesson.miniToString());
    }
    
    /**
     * This is the how the user logins in or make an account
     * @return true when they have finished and have a valued account
     */
    private boolean login()
    {
        boolean loop = true;
        while(loop == true)
        {
            System.out.println("********************* Login Menu *********************");
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
                    User temp = loginIn();
                    if(temp != null)
                    {
                        user = temp;
                        for(int i=0; i < user.getEnrolledCourse().size(); i++) {

                        }
                        return true;
                    }
                    break;
                case 4: 
                    logout();
                case 5:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid number. Try again");
                    break;
            }
        }
        return false; //The program should not reach here. This just make sure that the program know that it returns something.
    }
    /**
     * This is how the user creates an account
     * @param accountType: What type of account are they making
     * @return The User that just been created
     */
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
        if(application.createAccount(firstName, lastName, email, date, username, password, accountType)){
            System.out.println("Welcome "+ user.getFirstName()+" "+user.getLastName());
            this.user = application.getCurrentUser();
        } else {
            System.out.println("Sorry an account with that username already exists");
            this.user = null;
        }
        return this.user;
    }

    /**
     * This is how the user logins in
     * @return The User that just been created
     */
    private User loginIn()
    {
        System.out.println("Please enter your username below."); 
        String username = keyboard.nextLine();
        System.out.println("Please enter your password below.");
        String password = keyboard.nextLine();
        if(application.login(username, password)){
            this.user = application.getCurrentUser();
            System.out.println("Welcome "+ user.getFirstName()+" "+user.getLastName());
        }
        else{
            System.out.println("Invalid username or password");
            this.user = null;
        }
        return this.user;
    }

    /**
     * This is how the user logs out.
     */
    private void logout() {
        DataWriter.saveUsers();
        DataWriter.saveCourses();
        DataWriter.saveFAQs();
        System.out.println("You have sucessfully logged out!");
        user = null;
        //login();//goes back to the login screen once logged out
    }

    /**
     * This takes a string from the user and turns it into a data
     * @param birthdayDate: String from user
     * @return Date: Date equal to the string
     */
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

    /**
     * This displays the main menu and all the options the user has have as a student.
     */
    public void displayMainMenu() 
    {
        System.out.println("********************* Main Menu *********************");
        for(int i = 0; i < menu.length; i++)
        {
            System.out.println(i+1+": "+menu[i]);
        }
    }

    /**
     * This displays the main menu and all the options the user has have as a author.
     */
    private void displayAuthorMenu()
    {
        System.out.println("********************* Author Menu *********************");
        for(int i = 0; i < authorMenu.length; i++)
        {
            System.out.println(i+1+": "+authorMenu[i]);
        }
    }

    /**
     * This method lets the user use the LMS as an author. Create course and edit course.
     */
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
                    createCourse();
                    break;
                case 2:
                    editCourse();
                    break;
                case 3:
                    run();
                    return;
                case 4:
                    return;
                default:
                    System.out.println("Invalid number. Try again");
                    break;
            }
        }
    }
    
    /**
     * This creates a course
     * @return Course created by this method
     */
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
        int numberOfModules = keyboard.nextInt();
        keyboard.nextLine();
        for(int i = 0; i < numberOfModules; i++){
            addModule();
        }
        application.createCourse(user.id, name, description, syallbus, difficulty2, language2, modules);
        return this.course;
    }

    /**
     * This allows the author to add a module to their course they are making
     * @return True if it worked, false if it did not
     */
    private boolean addModule(){
        System.out.println("Module Title: ");
        String title = keyboard.nextLine();
        System.out.println("How many lessons?");
        int lessonNumber = keyboard.nextInt();
        keyboard.nextLine();
        for(int i = 0; i < lessonNumber; i++) {
            addLesson();
        }
        Module module = new Module(title, lessons);
        return modules.add(module);
    }

    /**
     * This allows the user to add a lesson to their module in their course they are making
     * @return True if it worked, false if it did not
     */
    private boolean addLesson(){
        System.out.println("Lesson Title: ");
        String title = keyboard.nextLine();
        System.out.println("Content: ");
        String content = keyboard.nextLine();
        System.out.println("How many questions in the quiz? ");
        ArrayList<Question> questions = new ArrayList<Question>();
        int numberOfQuestions = keyboard.nextInt();
        keyboard.nextLine();
        for(int i =0; i< numberOfQuestions; i++){
            System.out.println("Question: ");
            String ques = keyboard.nextLine();
            System.out.println("Enter 4 answer options: ");
            ArrayList<String> answers = new ArrayList<String>();
            for(int j =0; j< 4;j++){
                String input = keyboard.nextLine();
                answers.add(input);
            }
            System.out.println("Which answer is the correct one? Enter in the corresponding number. Starting at 0 to 3");
            int correctAnswer = keyboard.nextInt();
            keyboard.nextLine();

            Question question = new Question(ques, answers, correctAnswer);
            questions.add(question);
            
        }

        Quiz quiz = new Quiz(questions);
        Lesson lesson = new Lesson(content, title, quiz);

        return lessons.add(lesson);
    }

    /**
     * This converts a String into a enum called Difficulty
     * @param difficulty (Sting)
     * @return emun Difficulty
     */
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

     /**
     * This converts a String into a enum called Language
     * @param language (Sting)
     * @return emun Language
     */
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

    /**
     * This allows the author to edit a course
     */ 
    private void editCourse()
    {
        System.out.println("What course would you like to edit?");
        ArrayList<Course> list =  application.findCourse(); 
        
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId().equals(this.user.getId()));
            {
                System.out.print(i+": "+list.get(i).getTitle() +"\n");
            }
        }
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        for(int i = 0; i < list.size(); i++){
            if(i == choice){
               editCourse = list.get(i);
            }
        }

        System.out.println("\nList of Modules in "+editCourse.getTitle());
        for(int i = 0; i<editCourse.getNumberOfModules();i++){
            System.out.print(i+": "+editCourse.getModule().get(i).getTitle()+"\n");
        }

        
        while(true)
        {
            System.out.println("Would you like to add(1) a module, view(2) a module, or leave(3)?");
            choice = keyboard.nextInt();
            keyboard.nextLine();
            switch(choice){
            case 1:
                addNewModule();
                break;
            case 2:
                viewModule();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid number. Try again");
                break;
            } 
        }
    }

    /**
     * This allows an author to add a new module to existing course.
     */
    private void addNewModule(){
        System.out.println("Adding Module\n");
        System.out.println("Module Title: ");
        String title = keyboard.nextLine();
        System.out.println("How many lessons?");
        int lessonNumber = keyboard.nextInt();
        keyboard.nextLine();
        for(int i = 0; i < lessonNumber; i++) {
            addLesson();
        }
        editCourse.addModule(title, lessons);
        System.out.println("Module added!");
    }

    /**
     * This method allows the user to view a module in a course they are making
     */
    private void viewModule(){
        System.out.println("What module would to like to view?");
        int choice = keyboard.nextInt();
        keyboard.nextLine();

        for(int i = 0; i<editCourse.getNumberOfModules();i++){
            if(i == choice){
                editModule = editCourse.getModule().get(i);
             }
        }
        System.out.println("\nLessons in "+editModule.getTitle()+": ");
        for(int i = 0; i<editModule.getNumberOfLessons(); i++){
            System.out.println(i+": "+editModule.getLesson().get(i).getTitle());
        }

        System.out.println("Would you like to add(1) or view(2) a lesson?");
        choice = keyboard.nextInt();
        keyboard.nextLine();

        if(choice == 1){
            addNewLesson();
        } else if(choice == 2){
            viewLesson();
        } else {
            System.out.println("Invalid choice");
        }
    }

    /**
     * This allows an author to add a new lesson to a module in a existing course.
     */
    private void addNewLesson(){
        System.out.println("Lesson Title: ");
        String title = keyboard.nextLine();
        System.out.println("Content: ");
        String content = keyboard.nextLine();
        System.out.println("How many questions in the quiz? ");
        ArrayList<Question> questions = new ArrayList<Question>();
        int numberOfQuestions = keyboard.nextInt();
        keyboard.nextLine();
        for(int i =0; i< numberOfQuestions; i++){
            System.out.println("Question: ");
            String ques = keyboard.nextLine();
            System.out.println("Enter 4 answer options: ");
            ArrayList<String> answers = new ArrayList<String>();
            for(int j =0; j< 4;j++){
                String input = keyboard.nextLine();
                answers.add(input);
            }
            System.out.println("Which answer is the correct one? Enter in the corresponding number. Starting at 0 to 3");
            int correctAnswer = keyboard.nextInt();
            keyboard.nextLine();

            Question question = new Question(ques, answers, correctAnswer);
            questions.add(question);
            
        }

        Quiz quiz = new Quiz(questions);
        editModule.addLesson(content, title, quiz);
        System.out.println("Lesson added!");
    }

    /**
     * This method allows the user to view a lesson in a course they are making
     */
    private void viewLesson(){
        System.out.println("What lesson would to like to view?");
        int choice = keyboard.nextInt();
        keyboard.nextLine();

        for(int i = 0; i<editModule.getNumberOfLessons(); i++){
            if(choice == i){
                System.out.println(editModule.getLesson().get(i));
            }
        }
    }

    /**
     * This allows the user to view a course
     * @param course The course they want to view
     */
    private void viewCourse(Course course){
        String answer;
        int answer1;
        System.out.println("Here is the Course you requested and its Modules:");
        System.out.println(course.getTitle()+ ": ");
        for(int i = 0; i<course.getNumberOfModules(); i++){
            System.out.println((i+1)+".: "+course.getModule().get(i).getTitle());
        }
        System.out.println("Would you like to view the Lessons of a Module: (Y or N)");
        answer = keyboard.nextLine();
        if(answer.equalsIgnoreCase("Y")){
            System.out.println("Which Module, choose 1-"+course.getNumberOfModules());
            answer1 = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("Here is the Module you requested and its Lessons:");
            System.out.println(course.getModule().get(answer1-1).getTitle()+ ": ");
            for(int i = 0; i<course.getModule().get(answer1-1).getNumberOfLessons(); i++){
                System.out.println((i+1)+".: "+course.getModule().get(answer1-1).getLesson().get(i).getTitle());
            }
            System.out.println("Now Exiting View Course.");
        }  else{
            System.out.println("Oh, ok then. Now Exiting View Course.");
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
            System.out.print((i+1)+". ");
            System.out.println((application.findCourse(courses.get(i).getCourse())).getTitle());
        }
    }

    private void CreateCertificationFile(EnrolledCourse course){ 
        this.application.CreateCertificationFile(course);
    } 

    private void CreateCourseFile(Module module){ 
         this.application.CreateCourseFile(module);
    }

    public static void main(String[] args) 
    {
        LMSUI lmsui = new LMSUI();
        lmsui.run();
        System.out.println("Exiting the system. Have a good day!");
        System.exit(0);
    }
    
    private void viewFAQs() {
        System.out.println("Please view the FAQs below.\nYou can ask a question by entering 1, answer an FAQ by entering 2 or to go back to the main menu enter 0.");
        System.out.println(application.getFAQString());
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        if(choice == 0) {
            run();//need to double check if this is the right way to go to the main menu
        } else if(choice == 1) {
            System.out.println("Enter the question you would like to ask.");
            String newQuestion = keyboard.nextLine();
            if(application.askQuestion(newQuestion)) {
                System.out.println("Your question has been added!");
            } else {
                System.out.println("Invalid input.");
            }
            viewFAQs();//need to double check if this is the right way to go back to the FAQ menu
        } else if(choice == 2) {
            System.out.println(application.getFAQQuestionsString());
            System.out.println("Please enter the number associated with the question you want to answer");
            int questionChoice = keyboard.nextInt();
            keyboard.nextLine();
            questionChoice--;
            if(questionChoice >= 0 && questionChoice < application.getFAQs().size()) {
                System.out.println(application.getFAQat(questionChoice));
                System.out.println("Please enter the answer you would like to add.");
                String newAnswer = keyboard.nextLine();
                if(newAnswer != null) {
                    application.addAnswertoFAQ(questionChoice, newAnswer);
                    System.out.println("Your answer has been added!");
                } else {
                    System.out.println("Invalid input");
                }
                application.addAnswertoFAQ(questionChoice, newAnswer);
                System.out.println("Your answer has been added!");
                viewFAQs();//need to double check if this is the right way to go back to the FAQ menu
            } else {
                System.out.println("Invalid input.");
                viewFAQs();//need to double check if this is the right way to go back to the FAQ menu
            }
        } else {
            System.out.println("Invalid input.");
            run();//need to double check if this is the right way to go to the main menu
        }
    }

    public void viewCourseComments(){
        System.out.println("Please view the comments for the course below.\nYou can add a comment by entering 1, reply to a comment by entering 2 or to go back to the main menu enter 0.");
        application.setCourse(course);
        System.out.println(application.courseCommnetsToString());
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        if(choice == 0) {
            run();//need to double check if this is the right way to go to the main menu
        } else if(choice == 1) {
            System.out.println("Please enter the comment you'd like to add.");
            String newComment = keyboard.nextLine();
            if(application.addComment(newComment, user.getId())) {
                System.out.println("Your comment has been added!");
            } else {
                System.out.println("Invalid input.");
            }
            viewCourseComments();//need to double check if this is the right way to go to the comments menu
        } else if(choice == 2) {
            System.out.println(application.getCourseCommentsString());
            System.out.println("Please enter the number associated with the comment you want to reply to.");
            int commentChoice = keyboard.nextInt();
            keyboard.nextLine();
            commentChoice--;
            if(commentChoice >= 0 && commentChoice < course.getComment().size()) {
                System.out.print(application.getCommentUsername(application.getCommentAt(commentChoice).getUser()));
                System.out.print(": ");
                System.out.println(application.getCommentAt(commentChoice).getComment());
                System.out.println("Please enter your reply.");
                String newReply = keyboard.nextLine();
                if(application.addReply(commentChoice, newReply, user.getId())) {
                    System.out.println("Added your reply!");
                } else {
                    System.out.println("Invalid input.");
                }
                viewCourseComments();//need to double check if this is the right way to go to the comments menu
            } else {
                System.out.println("Invalid input.");
                viewCourseComments();//need to double check if this is the right way to go to the comments menu
            }
        } else {
            System.out.println("Invalid input.");
            run();//need to double check if this is the right way to go to the main menu
        }
    }

    /**
     * 
     * @param quiz
     * @return
     */
    public int takeQuiz(Quiz quiz) {
        int finalQuizGrade = 100;
        for(int i=0; i < quiz.getQuestion().size(); i++) {
            System.out.println(application.getQuizQuestion(quiz, i));
            System.out.println(application.getQuizAnswers(quiz, i));
            System.out.println("Please enter the number corresponding to your answer.");
            int answerChoice = keyboard.nextInt();
            keyboard.nextLine();
            finalQuizGrade = application.getQuestionGrade(quiz, i, answerChoice, finalQuizGrade);
        }
        return finalQuizGrade;
    }

    public void viewCompletedCourses(EnrolledCourse course) {
        ArrayList<UUID> completedCourses = new ArrayList<UUID>();
        for(int i=0; i < completedCourses.size(); i++) {
            System.out.println(application.completedCoursesToString(user.enrolledCourse));
            System.out.println("Enter 1 to view your module grades for a course, enter 2 to print out a certificate for a course, and enter 0 to go back to the main menu.");
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            if(choice == 1) {
                System.out.println(application.modulesAndGradesString(course));
                viewCompletedCourses(course);
            } else if(choice == 2) {
                System.out.println("Printing certificate for this course...");
                CreateCertificationFile(course);
                viewCompletedCourses(course);
            } else if (choice == 0) {
                System.out.println("Going back to the main menu.\n");
                run();
            } else {
                System.out.println("Invalid input. Going back to the main menu.\n");
                run();            
            }
        }
    }
    
}