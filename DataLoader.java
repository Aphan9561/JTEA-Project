import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This is the data load that load data from json and extends dataconstant.
 * @author: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class DataLoader extends DataConstants{
    /**
     * This method allows the other classes to get the list of users for the application
     * @return list of users for the application
     */
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            for(int i=0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                UUID id = UUID.fromString((String)personJSON.get(USER_ID));
                String firstName = (String)personJSON.get(USER_FIRST_NAME);
                String lastName = (String)personJSON.get(USER_LAST_NAME);
                String email = (String)personJSON.get(USER_EMAIL);
                Date birthday = formatter.parse((String)personJSON.get(USER_BIRTHDAY));
                String username = (String)personJSON.get(USER_USERNAME);
                String password = (String)personJSON.get(USER_PASSWORD);

                /*JSONArray enrolledCoursesJSON = (JSONArray)personJSON.get(USER_ENROLLEDCOURSES);
                ArrayList<EnrolledCourse> enrolledCourses = new ArrayList<EnrolledCourse>();
                for(int j=0; j < enrolledCoursesJSON.size(); j++) {
                    JSONObject enrolledCourseJSON = (JSONObject)enrolledCoursesJSON.get(j);
                    UUID course = UUID.fromString((String)enrolledCourseJSON.get(USER_ENROLLEDCOURSES_COURSE));
                    Progress progress = makeProgressEnum((String)enrolledCourseJSON.get(USER_ENROLLEDCOURSES_PROGRESS));
                    int currentModule = ((Long)enrolledCourseJSON.get(USER_ENROLLEDCOURSES_CURRENTMODULE)).intValue();
                    int currentLesson = ((Long)enrolledCourseJSON.get(USER_ENROLLEDCOURSES_CURRENTLESSON)).intValue();
                    int overallGrade = ((Long)enrolledCourseJSON.get(USER_ENROLLEDCOURSES_OVERALLGRADE)).intValue();

                    JSONArray gradesPerModuleJSON = (JSONArray)enrolledCourseJSON.get(USER_ENROLLEDCOURSES_GRADESPERMODULE);
                    ArrayList<Integer> gradesPerModule = new ArrayList<Integer>();
                    for(int k=0; k < gradesPerModuleJSON.size(); k++) {
                        gradesPerModule.add(((Long)gradesPerModuleJSON.get(k)).intValue());
                    }

                    JSONArray gradesPerLessonJSON = (JSONArray)enrolledCourseJSON.get(USER_ENROLLEDCOURSES_GRADESPERLESSON);
                    ArrayList<Integer> gradesPerLesson = new ArrayList<Integer>();
                    for(int k=0; k < gradesPerLessonJSON.size(); k++) {
                        gradesPerLesson.add(((Long)gradesPerLessonJSON.get(k)).intValue());
                    }

                    enrolledCourses.add(new EnrolledCourse(course, progress, currentModule, currentLesson, overallGrade, gradesPerModule, gradesPerLesson));
                }*/

                AccountType type = makeAccountTypeEnum((String)personJSON.get(USER_TYPE));

                users.add(new User(id, firstName, lastName, email, birthday, username, password, type));
            }

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * This method allows the other classes to get the list of courses for the application
     * @return list of courses for the application
     */
    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<Course>();

        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray coursesJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < coursesJSON.size(); i++) {
                JSONObject courseJSON = (JSONObject)coursesJSON.get(i);
                UUID id = UUID.fromString((String)courseJSON.get(COURSE_ID));
                Difficulty difficulty = makeDifficultyEnum((String)courseJSON.get(COURSE_DIFFICULTY));
                String name = (String)courseJSON.get(COURSE_NAME);
                String description = (String)courseJSON.get(COURSE_DESCRIPTION);
                String syllabus = (String)courseJSON.get(COURSE_SYLLABUS);
                UUID author = UUID.fromString((String)courseJSON.get(COURSE_AUTHOR));

                JSONArray modulesJSON = (JSONArray)courseJSON.get(COURSE_MODULES);
                ArrayList<Module> modules = new ArrayList<Module>();
                for(int j=0; j < modulesJSON.size(); j++) {
                    JSONObject moduleJSON = (JSONObject)modulesJSON.get(j);
                    String moduleName = (String)moduleJSON.get(COURSE_MODULES_NAME);

                    JSONArray lessonsJSON = (JSONArray)moduleJSON.get(COURSE_MODULES_LESSON);
                    ArrayList<Lesson> lessons = new ArrayList<Lesson>();
                    for(int k=0; k < lessonsJSON.size(); k++) {
                        JSONObject lessonJSON = (JSONObject)lessonsJSON.get(k);
                        String title = (String)lessonJSON.get(COURSE_MODULES_LESSON_TITLE);
                        String content = (String)lessonJSON.get(COURSE_MODULES_LESSON_CONTENT);

                        JSONArray quizQuestionsJSON = (JSONArray)lessonJSON.get(COURSE_MODULES_LESSON_QUIZ);
                        ArrayList<Question> quizQuestions = new ArrayList<Question>();
                        for(int l=0; l < quizQuestionsJSON.size(); l++) {
                            JSONObject quizQuestion = (JSONObject)quizQuestionsJSON.get(l);
                            String question = (String)quizQuestion.get(COURSE_MODULES_LESSON_QUIZQUESTIONS_QUESTION);

                            JSONArray answersJSON = (JSONArray)quizQuestion.get(COURSE_MODULES_LESSON_QUIZQUESTIONS_ANSWERS);
                            ArrayList<String> answers = new ArrayList<String>();
                            for(int n=0; n < answersJSON.size(); n++) {
                                answers.add((String)answersJSON.get(n));
                            }

                            int correctAnswer = ((Long)quizQuestion.get(COURSE_MODULES_LESSON_QUIZQUESTIONS_CORRECTANS)).intValue();
                            Question aQuestion = new Question(question, answers, correctAnswer);
                            quizQuestions.add(aQuestion);
                            }
                            Quiz quiz = new Quiz(quizQuestions);
                            //quizzes.add(quiz);
                        

                        Lesson lesson = new Lesson(content, title, quiz);
                        lessons.add(lesson);
                    }

                    JSONArray commentsJSON = (JSONArray)moduleJSON.get(COURSE_MODULES_COMMENTS);
                    ArrayList<Comment> comments = new ArrayList<Comment>();
                    for(int k=0; k < commentsJSON.size(); k++) {
                        JSONObject commentJSON = (JSONObject)commentsJSON.get(k);
                        UUID user = UUID.fromString((String)commentJSON.get(COURSE_MODULES_COMMENTS_USER));
                        String comment = (String)commentJSON.get(COURSE_MODULES_COMMENTS_COMMENT);
                        
                        JSONArray repliesJSON = (JSONArray)commentJSON.get(COURSE_MODULES_COMMENTS_REPLIES);
                        ArrayList<Reply> replies = new ArrayList<Reply>();
                        for(int l=0; l < repliesJSON.size(); l++) {
                            JSONObject replyJSON = (JSONObject)repliesJSON.get(l);
                            String replyComment = (String)replyJSON.get(COURSE_MODULES_COMMENTS_REPLIES_COMMENT);
                            UUID replyUser = UUID.fromString((String)replyJSON.get(COURSE_MODULES_COMMENTS_REPLIES_USER));
                            Reply reply = new Reply(replyComment, replyUser);
                            replies.add(reply);
                        }

                        comments.add(new Comment(comment, user, replies));
                    }

                    Module module = new Module(moduleName, lessons, comments);
                    modules.add(module);
                }

                //System.out.println(modules);

                /*String temp = (String)courseJSON.get(COURSE_LANGUAGE);
                System.out.println(temp);*/
                Language language = makeLanguageEnum((String)courseJSON.get(COURSE_LANGUAGE));
                //Language language = makeLanguageEnum("PYTHON");

                JSONArray studentsJSON = (JSONArray)courseJSON.get(COURSE_STUDENTS);
                ArrayList<Student> students = new ArrayList<Student>();
                for(int j=0; j < studentsJSON.size(); j++) {
                    JSONObject studentJSON = (JSONObject)studentsJSON.get(j);
                    UUID studentID = UUID.fromString((String)studentJSON.get(COURSE_STUDENTS_ID));
                    
                    JSONArray gradesJSON = (JSONArray)studentJSON.get(COURSE_STUDENTS_GRADES);
                    ArrayList<Integer> grades = new ArrayList<Integer>();
                    for(int k=0; k < gradesJSON.size(); k++) {
                        int grade = (int)(long)gradesJSON.get(k);
                        grades.add(grade);
                    }

                    students.add(new Student(studentID, grades));
                }

                double rating = (double)courseJSON.get(COURSE_RATING);

                JSONArray commentsJSON = (JSONArray)courseJSON.get(COURSE_COMMENTS);
                ArrayList<Comment> comments = new ArrayList<Comment>();
                for(int k=0; k < commentsJSON.size(); k++) {
                    JSONObject commentJSON = (JSONObject)commentsJSON.get(k);
                    UUID user = UUID.fromString((String)commentJSON.get(COURSE_MODULES_COMMENTS_USER));
                    String comment = (String)commentJSON.get(COURSE_MODULES_COMMENTS_COMMENT);
                        
                    JSONArray repliesJSON = (JSONArray)commentJSON.get(COURSE_MODULES_COMMENTS_REPLIES);
                    ArrayList<Reply> replies = new ArrayList<Reply>();
                    for(int l=0; l < repliesJSON.size(); l++) {
                        JSONObject replyJSON = (JSONObject)repliesJSON.get(l);
                        String replyComment = (String)replyJSON.get(COURSE_MODULES_COMMENTS_REPLIES_COMMENT);
                        UUID replyUser = UUID.fromString((String)replyJSON.get(COURSE_MODULES_COMMENTS_REPLIES_USER));
                        Reply reply = new Reply(replyComment, replyUser);
                        replies.add(reply);
                    }
                    comments.add(new Comment(comment, user, replies));
                }

                JSONArray reviewsJSON = (JSONArray)courseJSON.get(COURSE_REVIEWS);
                ArrayList<Review> reviews = new ArrayList<Review>();
                for(int k=0; k < reviewsJSON.size(); k++) {
                    JSONObject reviewJSON = (JSONObject)reviewsJSON.get(k);
                    double reviewRating = (double)reviewJSON.get(COURSE_REVIEWS_RATING);
                    String reviewComment = (String)reviewJSON.get(COURSE_REVIEWS_COMMENT);
                    UUID reviewUser = UUID.fromString((String)reviewJSON.get(COURSE_REVIEWS_USER));
                    reviews.add(new Review(reviewRating, reviewComment, reviewUser));
                }

                courses.add(new Course(id, difficulty, name, description, syllabus, author, modules, language, students, rating, reviews, comments));
            }

            return courses;

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    /**
     * This method allows the other classes to get the list of FAQs for the application
     * @return list of FRQs for the application
     */
    public static ArrayList<FAQ> getFAQs() {
        ArrayList<FAQ> FAQs = new ArrayList<FAQ>();

        try {
            FileReader reader = new FileReader(FAQ_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray FAQS_JSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < FAQS_JSON.size(); i++) {
                JSONObject FAQ_JSON = (JSONObject)FAQS_JSON.get(i);
                String question = (String)FAQ_JSON.get(FAQ_QUESTION);
                
                JSONArray answersJSON = (JSONArray)FAQ_JSON.get(FAQ_ANSWERS);
                ArrayList<String> answers = new ArrayList<String>();
                for(int j=0; j < answersJSON.size(); j++) {
                    answers.add((String)answersJSON.get(j));
                }

                FAQs.add(new FAQ(question, answers));
            }

            return FAQs;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This converts a string into an enum called Difficulty
     * @param String difficulty
     * @return enum called Difficulty
     */
    public static Difficulty makeDifficultyEnum(String difficulty) {
        difficulty = difficulty.toUpperCase();
        Difficulty enumDifficulty = Difficulty.valueOf(difficulty);
        return enumDifficulty;
    }

    /**
     * This converts a string into an enum called Language
     * @param String language
     * @return enum called Language
     */
    public static Language makeLanguageEnum(String language) {
        language = language.toUpperCase();
        Language enumLanguage = Language.valueOf(language);
        return enumLanguage;
    }
    
    /**
     * This converts a string into an enum called AccountType
     * @param String accountType
     * @return enum called AccountType
     */
    public static AccountType makeAccountTypeEnum(String accountType) {
        accountType = accountType.toUpperCase();
        AccountType enumAccountType = AccountType.valueOf(accountType);
        return enumAccountType;
    }
    
    /**
     * This converts a string into an enum called Progress
     * @param String progress
     * @return enum called Progress
     */
    public static Progress makeProgressEnum(String progress) {
        Progress enumProgress = Progress.valueOf(progress);
        return enumProgress;
    }

    /*
     * This is the main method for this class. This calls all the data and loads into the classes as need be. Also a way to test that it is working correctly.
     */
    public static void main(String[] args) {
        ArrayList<User> testUsers = getUsers();
        for(User user : testUsers) {
            System.out.println(user);
            System.out.println();
        }

        System.out.println("\n************************\n");

        ArrayList<FAQ> testFAQs = getFAQs();
        for(FAQ faq : testFAQs) {
            System.out.println(faq);
        }
        
        System.out.println("\n************************\n");

        ArrayList<Course> testCourses = getCourses();
        for(Course course : testCourses) {
            System.out.println(course);
        }
    }
}

