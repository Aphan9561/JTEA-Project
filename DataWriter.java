import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *  This is the data writer that writes data to json and text files and extends dataconstant.
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class DataWriter extends DataConstants{
    /**
     * This method saves the list of users. 
     */
    public static void saveUsers() {
        UserList user = UserList.getInstance();
        ArrayList<User> users = user.getUsers();

        JSONArray jsonUsers = new JSONArray();

        for(int i=0; i< users.size(); i++) {
			jsonUsers.add(getUserJSON(users.get(i)));
		}

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method converts a user into a JSONOBJECT
     * @param user
     * @return JSONOBJECT
     */
    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_BIRTHDAY, formattingDate(user.getBirthday()));
        userDetails.put(USER_USERNAME, user.getUsername());
        userDetails.put(USER_TYPE, user.getType().toString());
        userDetails.put(USER_PASSWORD, user.getPassword());

        return userDetails;
    }
    
    /**
     * This takes a Date and turns it into a String
     * @param input (Data)
     * @return String
     */
    public static String formattingDate(Date input){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(input);;
        return date;
    }
    
    /**
     * This saves the list of courses
     */
    public static void saveCourses() {
        CourseList course = CourseList.getInstance();
        ArrayList<Course> courses = course.getAllCourses();
        JSONArray jsonCourses = new JSONArray();

        for(int i =0; i<courses.size(); i++){
            jsonCourses.add(getCourseJSON(courses.get(i)));
        }

        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
 
            file.write(jsonCourses.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method converts a course into a JSONOBJECT
     * @param user
     * @return JSONOBJECT
     */
    public static JSONObject getCourseJSON(Course course) {
		JSONObject courseDetails = new JSONObject();
        courseDetails.put(COURSE_ID, course.getId().toString());
        courseDetails.put(COURSE_NAME, course.getTitle());
        courseDetails.put(COURSE_DIFFICULTY, course.getDifficulty().toString());
        courseDetails.put(COURSE_AUTHOR, course.getAuthor().toString());
        courseDetails.put(COURSE_LANGUAGE, course.getLanguage().toString());
        courseDetails.put(COURSE_DESCRIPTION, course.getDesciption());
        courseDetails.put(COURSE_SYLLABUS,course.getSyllabus());

        ArrayList<Module> modules = course.getModule();
        JSONArray moduleArray = new JSONArray();
        for(int i = 0; i <modules.size();i++){
            moduleArray.add(getModuleJSON(modules.get(i)));

        }

        courseDetails.put(COURSE_MODULES, moduleArray);

        courseDetails.put(COURSE_RATING,course.getRating());

        ArrayList<Review> reviews = course.getReview();
        JSONArray reviewArray = new JSONArray();

        for(Review review: reviews){
            JSONObject reviewObject = new JSONObject();
            reviewObject.put(COURSE_REVIEWS_USER, review.getUser().toString());
            reviewObject.put(COURSE_REVIEWS_RATING, review.getRating());
            reviewObject.put(COURSE_REVIEWS_COMMENT, review.getComment());
            
            reviewArray.add(reviewObject);

        }

        courseDetails.put(COURSE_REVIEWS, reviewArray);

        ArrayList<Student> students = course.getStudent();
        JSONArray studentArray = new JSONArray();

        for(Student student: students){
            JSONObject studentObject = new JSONObject();
            studentObject.put(COURSE_STUDENTS_ID, student.getId().toString());
    
            ArrayList<Integer> grades = student.getGrades();
            JSONArray gradeArray = new JSONArray();     
            
            for(Integer grade: grades){
                JSONObject gradeObject = new JSONObject();
                gradeArray.add(grade);
            }
            studentObject.put(COURSE_STUDENTS_GRADES, gradeArray);
            studentArray.add(studentObject);
        }

        courseDetails.put(COURSE_STUDENTS, studentArray);

        ArrayList<Comment> comments = course.getComment();
        JSONArray commentArray = new JSONArray();

        for(Comment comment: comments){
            JSONObject commentDetails = new JSONObject();
            commentDetails.put(COURSE_COMMENTS_USER, comment.getUser().toString());
            commentDetails.put(COURSE_COMMENTS_COMMENT, comment.getComment());
            
            ArrayList<Reply> replies = comment.getReply();
            JSONArray repliesArray = new JSONArray();

            for(Reply reply: replies){
                JSONObject replyObject = new JSONObject();
                replyObject.put(COURSE_COMMENTS_REPLIES_USER, reply.getUser().toString());
                replyObject.put(COURSE_COMMENTS_REPLIES_COMMENT, reply.getComment());

                repliesArray.add(replyObject);
            }
            commentDetails.put(COURSE_COMMENTS_REPLIES, repliesArray);
            commentArray.add(commentDetails);
        }
        courseDetails.put(COURSE_COMMENTS, commentArray);
        
        return courseDetails;
    }

    /**
     * This turns a module into a JSONObject
     * @param module
     * @return JSONObject
     */
    public static JSONObject getModuleJSON (Module module){
        JSONObject moduleObject = new JSONObject();

        moduleObject.put(COURSE_MODULES_NAME, module.getTitle());

        ArrayList<Lesson> lessons = module.getLesson();
        JSONArray lessonArray = new JSONArray();
        for (int i =0; i<lessons.size(); i++){
            lessonArray.add(getLessonJSON(lessons.get(i)));
        }

        moduleObject.put(COURSE_MODULES_LESSON, lessonArray);

        ArrayList<Comment> comments = module.getComment();
        JSONArray commentArray = new JSONArray();
        for(int i =0; i<comments.size(); i++){
            commentArray.add(getModuleCommentJSON(comments.get(i)));
        }

        moduleObject.put(COURSE_MODULES_COMMENTS, commentArray);

        return moduleObject;
    }

    /**
     * This turns lesson into a JSONObject
     * @param lesson
     * @return JSONObject
     */
    public static JSONObject getLessonJSON (Lesson lesson){
        JSONObject lessonObject = new JSONObject();
        lessonObject.put(COURSE_MODULES_LESSON_TITLE, lesson.getTitle());
        lessonObject.put(COURSE_MODULES_LESSON_CONTENT, lesson.getContent());

        //lessonObject.put(COURSE_MODULES_LESSON_QUIZ, lesson.getQuiz());

        ArrayList<Question> questions = lesson.getQuiz().getQuestion();
        JSONArray questionArray = new JSONArray();
        for(Question question: questions){
            JSONObject questionObject = new JSONObject();
            questionObject.put(COURSE_MODULES_LESSON_QUIZQUESTIONS_QUESTION, question.getQuestion());

            ArrayList<String> answers = question.getAnswers();
            JSONArray answerArray = new JSONArray();
            for(String answer: answers){
                answerArray.add(answer);
            }

            questionObject.put(COURSE_MODULES_LESSON_QUIZQUESTIONS_ANSWERS, answerArray);
            questionObject.put(COURSE_MODULES_LESSON_QUIZQUESTIONS_CORRECTANS, question.getCorrectAnswer());

            questionArray.add(questionObject);
        }  

        lessonObject.put(COURSE_MODULES_LESSON_QUIZ, questionArray);
    
        return lessonObject;
    }

    public static JSONObject getModuleCommentJSON(Comment comment){
        JSONObject commentObject = new JSONObject();
        commentObject.put(COURSE_MODULES_COMMENTS_USER, comment.getUser().toString());
        commentObject.put(COURSE_MODULES_COMMENTS_COMMENT, comment.getComment());

        ArrayList<Reply> replies = comment.getReply();
        JSONArray repliesArray = new JSONArray();
        for(Reply reply: replies){
            JSONObject replyObject = new JSONObject();
            replyObject.put(COURSE_MODULES_COMMENTS_REPLIES_USER, reply.getUser().toString());
            replyObject.put(COURSE_MODULES_COMMENTS_REPLIES_COMMENT, reply.getComment());

            repliesArray.add(replyObject);
        }

        commentObject.put(COURSE_MODULES_COMMENTS_REPLIES, repliesArray);
        return commentObject;
    }

    /**
     * This saves the list of FAQs
     */
    public static void saveFAQs() {
        FAQList faq = FAQList.getInstance();
        ArrayList<FAQ> FAQs = faq.getFAQ();
        JSONArray jsonFAQs = new JSONArray();

        for(int i =0; i<FAQs.size(); i++){
            jsonFAQs.add(getFAQJSON(FAQs.get(i)));
        }

        try (FileWriter file = new FileWriter(FAQ_FILE_NAME)) {
 
            file.write(jsonFAQs.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This turns a FAQ into a JSONObject
     * @param faq
     * @return JSONObject
     */
    public static JSONObject getFAQJSON(FAQ faq) {
		JSONObject FAQDetails = new JSONObject();
        FAQDetails.put(FAQ_QUESTION, faq.getQuestion());
        FAQDetails.put(FAQ_ANSWERS, faq.getAnswers());

        return FAQDetails;
    }

    /**
     * This prints a certification into a text file
     * @param certification
     * @return Whether or not it worked (True if did or false if not)
     */
    public static boolean CreateCertificationFile(Certification certification){
        boolean worked = false;
            FileWriter Certification;
            try {
                Certification = new FileWriter("Certification.txt");
                Certification.write(certification.toString());
                Certification.close();
                worked = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return worked;
    }

    /**
     * This prints a module of a course into a text file
     * @param module
     * @return Whether or not it worked (True if did or false if not)
     */
    public static boolean CreateCourseFile(Module module){
        boolean worked = false;
            FileWriter Course;
            try {
                Course = new FileWriter("Module.txt");
                Course.write(module.fileInfo()); 
                Course.close();
                worked = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return worked;
    }

    
    /*
     * This is the main method for this class. This saves all data that may have changed. Also a way to test that it is working correctly.
     */
    public static void main(String[] args){
        saveUsers();
        saveCourses();
    }
}
