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
                String password = (String)personJSON.get(USER_PASSWORD);
                AccountType type = makeAccountTypeEnum((String)personJSON.get(USER_TYPE));

                users.add(new User(id, firstName, lastName, email, birthday, username, password, type));
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

                    JSONArray lessonsJSON = (JSONArray)moduleJSON.get(COURSE_MODULES_LESSON);
                    ArrayList<Lesson> lessons = new ArrayList<Lesson>();
                    for(int k=0; k < lessonsJSON.size(); k++) {
                        JSONObject lessonJSON = (JSONObject)lessonsJSON.get(k);
                        String title = (String)lessonJSON.get(COURSE_MODULES_LESSON_TITLE);
                        String content = (String)lessonJSON.get(COURSE_MODULES_LESSON_CONTENT);

                        JSONArray quizzesJSON = (JSONArray)lessonJSON.get(COURSE_MODULES_LESSON_QUIZ);
                        ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
                        for(int l=0; l < quizzesJSON.size(); l++) {
                            JSONObject quizJSON = (JSONObject)quizzesJSON.get(l);
                            JSONArray quizQuestionsJSON = (JSONArray)quizJSON.get(COURSE_MODULES_LESSON_QUIZ_QUIZQUESTIONS);
                            ArrayList<Question> quizQuestions = new ArrayList<Question>();
                            for(int m=0; m < quizQuestionsJSON.size(); m++) {
                                JSONObject quizQuestion = (JSONObject)quizQuestionsJSON.get(k);
                                String question = (String)quizQuestion.get(COURSE_MODULES_LESSON_QUIZQUESTIONS_QUESTION);

                                JSONArray answersJSON = (JSONArray)quizQuestion.get(COURSE_MODULES_LESSON_QUIZQUESTIONS_ANSWERS);
                                ArrayList<String> answers = new ArrayList<String>();
                                for(int n=0; n < answersJSON.size(); n++) {
                                    answers.add((String)answersJSON.get(l));
                                }

                                int correctAnswer = (int)(long)quizQuestion.get(COURSE_MODULES_LESSON_QUIZQUESTIONS_CORRECTANS);
                                Question aQuestion = new Question(question, answers, correctAnswer);
                                quizQuestions.add(aQuestion);
                            }
                            Quiz quiz = new Quiz(quizQuestions);
                            quizzes.add(quiz);
                        }

                        Lesson lesson = new Lesson(content, title, quizzes);
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

                Language language = makeLanguageEnum((String)courseJSON.get(COURSE_LANGUAGE));

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

