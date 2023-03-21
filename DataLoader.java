import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{
    
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
                AccountType type = makeAccountTypeEnum((String)personJSON.get(USER_TYPE));

                users.add(new User(id, firstName, lastName, email, birthday, username, type));
            }

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

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

                    JSONArray quizQuestionsJSON = (JSONArray)moduleJSON.get(COURSE_MODULES_QUIZ_QUIZQUESTION_QUESTION);
                    ArrayList<Question> quizQuestions = new ArrayList<Question>();
                    for(int k=0; k < quizQuestionsJSON.size(); k++) {
                        JSONObject quizQuestion = (JSONObject)quizQuestionsJSON.get(k);
                        String question = (String)quizQuestion.get(COURSE_MODULES_QUIZQUESTION);

                        JSONArray answersJSON = (JSONArray)quizQuestion.get(COURSE_MODULES_QUIZ_QUIZQUESTION_ANSWERS);
                        ArrayList<String> answers = new ArrayList<String>();
                        for(int l=0; l < answersJSON.size(); l++) {
                            answers.add((String)answersJSON.get(l));
                        }

                        int correctAnswer = Integer.parseInt((String)quizQuestion.get(COURSE_MODULES_QUIZ_QUIZQUESTION_CORRECTANS));
                        Question aQuestion = new Question(question, answers, correctAnswer);
                        quizQuestions.add(aQuestion);
                    }
                    Quiz quiz = new Quiz(quizQuestions);

                    JSONArray lessonsJSON = (JSONArray)moduleJSON.get(COURSE_MODULES_LESSON);
                    ArrayList<Lesson> lessons = new ArrayList<Lesson>();
                    for(int k=0; k < lessonsJSON.size(); k++) {
                        JSONObject lessonJSON = (JSONObject)lessonsJSON.get(k);
                        String title = (String)lessonJSON.get(COURSE_MODULES_LESSON_TITLE);
                        String content = (String)lessonJSON.get(COURSE_MODULES_LESSON_CONTENT);
                        Lesson lesson = new Lesson(content, title);
                        lessons.add(lesson);
                    }

                    JSONArray commentsJSON = (JSONArray)moduleJSON.get(COURSE_MODULES_COMMENTS);
                    ArrayList<Comment> comments = new ArrayList<Comment>();
                    for(int k=0; k < commentsJSON.size(); k++) {
                        JSONObject commentJSON = (JSONObject)commentsJSON.get(k);
                        UUID user = UUID.fromString((String)commentJSON.get(COURSE_MODULES_LESSON_TITLE));
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
                    }

                    Module module = new Module(moduleName, quiz, lessons, comments);
                }

                Language language = makeLanguageEnum((String)courseJSON.get(COURSE_LANGUAGE));

                JSONArray studentsJSON = (JSONArray)courseJSON.get(COURSE_STUDENTS);
                ArrayList<Student> students = new ArrayList<Student>();
                for(int j=0; j < studentsJSON.size(); j++) {
                    JSONObject studentJSON = (JSONObject)studentsJSON.get(j);
                    UUID studentID = UUID.fromString((String)studentJSON.get(COURSE_STUDENTS_ID));
                    
                    JSONArray gradesJSON = (JSONArray)studentJSON.get(COURSE_STUDENTS_GRADES);
                    int[] grades = new int[gradesJSON.size()];
                    for(int k=0; k < gradesJSON.size(); k++) {
                        int grade = Integer.parseInt((String)gradesJSON.get(k));
                        grades[k] = grade;
                    }
                }

                JSONArray commentsJSON = (JSONArray)courseJSON.get(COURSE_COMMENTS);
                ArrayList<Comment> comments = new ArrayList<Comment>();
                for(int k=0; k < commentsJSON.size(); k++) {
                    JSONObject commentJSON = (JSONObject)commentsJSON.get(k);
                    UUID user = UUID.fromString((String)commentJSON.get(COURSE_MODULES_LESSON_TITLE));
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


                    }

                //FAQs.add(new FAQ(question, answers));
            }

            return courses;

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

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
                for(int j=0; i < answersJSON.size(); j++) {
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

    public static Difficulty makeDifficultyEnum(String difficulty) {
        difficulty = difficulty.toUpperCase();
        Difficulty enumDifficulty = Difficulty.valueOf(difficulty);
        return enumDifficulty;
    }

    public static Language makeLanguageEnum(String language) {
        language = language.toUpperCase();
        Language enumLanguage = Language.valueOf(language);
        return enumLanguage;
    }

    public static AccountType makeAccountTypeEnum(String accountType) {
        accountType = accountType.toUpperCase();
        AccountType enumAccountType = AccountType.valueOf(accountType);
        return enumAccountType;
    }

    public static void main(String[] args) {
        ArrayList<User> testUsers = getUsers();
        for(User user: testUsers) {
            System.out.println(user);
            System.out.println();
        }

        System.out.println("\n************************\n");

        ArrayList<FAQ> testFAQs = getFAQs();
        for(FAQ faq: testFAQs) {
            System.out.println(faq);
        }
    }
}

