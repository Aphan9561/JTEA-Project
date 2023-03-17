import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    
    public static void saveUsers() {
        UserList user = UserList.getInstance();
        ArrayList<User> users = user.getUser();
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

    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_BIRTHDAY, user.getBirthday());
        userDetails.put(USER_USERNAME, user.getUsername());
        userDetails.put(USER_TYPE, user.getType());

        return userDetails;
    }
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

    public static JSONObject getCourseJSON(Course course) {
		JSONObject courseDetails = new JSONObject();
        courseDetails.put(COURSE_ID, course.getId().toString());
        courseDetails.put(COURSE_NAME, course.getTitle());
        courseDetails.put(COURSE_DIFFICULTY, course.getDifficulty());
        courseDetails.put(COURSE_AUTHOR, course.getAuthor().toString());
        courseDetails.put(COURSE_LANGUAGE, course.getLanguage());
        courseDetails.put(COURSE_DESCRIPTION, course.getDesciption());
        courseDetails.put(COURSE_SYLLABUS,course.getSyllabus());

        courseDetails.put(COURSE_MODULES,course.getModule(0));
        courseDetails.put(COURSE_MODULES_NAME, course.getModule(0).getTitle());
        courseDetails.put(COURSE_MODULES_LESSON, course.getModule(0).getCurrentLesson(0));
        courseDetails.put(COURSE_MODULES_LESSON_TITLE, course.getModule(0).getCurrentLesson(0).getTitle());
        courseDetails.put(COURSE_MODULES_LESSON_CONTENT, course.getModule(0).getCurrentLesson(0).getContent());
        courseDetails.put(COURSE_MODULES_QUIZ, course.getModule(0).getQuiz(0));
        courseDetails.put(COURSE_MODULES_QUIZ_QUESTION, course.getModule(0).getQuiz(0).getQuestion().getQuestion());
        courseDetails.put(COURSE_MODULES_QUIZ_ANSWERS, course.getModule(0).getQuiz(0).getQuestion().getAnswers());
        courseDetails.put(COURSE_MODULES_QUIZ_CORRECT_ANS, course.getModule(0).getQuiz(0).getQuestion().getCorrectAnswer());
        courseDetails.put(COURSE_MODULES_COMMENTS, course.getModule(0).getComment(0));
        courseDetails.put(COURSE_MODULES_COMMENTS_USER, course.getModule(0).getComment(0).getUser().getId().toString());
        courseDetails.put(COURSE_MODULES_COMMENTS_COMMENT, course.getModule(0).getComment(0).getComment());
        courseDetails.put(COURSE_MODULES_COMMENTS_REPLIES, );

        courseDetails.put(COURSE_RATING,course.getRating());
        courseDetails.put(COURSE_REVIEWS, course.getReview());
        courseDetails.put(COURSE_REVIEWS_RATING, course.getReview().getRating());
        courseDetails.put(COURSE_REVIEWS_COMMENT, course.getReview().getComment());
        courseDetails.put(COURSE_REVIEWS_USER, course.getReview().getUser().getId().toString());

        courseDetails.put(COURSE_COMMENTS, course.getComment(0));
        courseDetails.put(COURSE_COMMENTS_USER, course.getComment(0).getUser()) ;
        courseDetails.put(COURSE_COMMENTS_COMMENT, course.getComment(0).getComment());
        courseDetails.put(COURSE_COMMENTS_REPLIES);


        return courseDetails;
    }

    public static void saveFAQs() {
        FAQList faq = FAQList.getInstance();
        ArrayList<FAQ> FAQs = faq.getFAQ();
        JSONArray jsonFAQs = new JSONArray();

        for(int i =0; i<FAQs.size(); i++){
            jsonFAQs.add(getFAQJSON(FAQs.get(i)));
        }
        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
 
            file.write(jsonFAQs.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getFAQJSON(FAQ faq) {
		JSONObject FAQDetails = new JSONObject();
        FAQDetails.put(FAQ_QUESTION, faq.getQuestion());
        FAQDetails.put(FAQ_ANSWERS, faq.getAnswers());

        return FAQDetails;
    }
}
