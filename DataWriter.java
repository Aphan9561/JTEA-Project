import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import java.util.UUID;
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
        userDetails.put(USER_BIRTHDAY, user.getBirthday().toString());
        userDetails.put(USER_USERNAME, user.getUsername());
        userDetails.put(USER_TYPE, user.getType().toString());

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
        courseDetails.put(COURSE_DIFFICULTY, course.getDifficulty().toString());
        courseDetails.put(COURSE_AUTHOR, course.getAuthor().getId().toString());
        courseDetails.put(COURSE_LANGUAGE, course.getLanguage());
        courseDetails.put(COURSE_DESCRIPTION, course.getDesciption());
        courseDetails.put(COURSE_SYLLABUS,course.getSyllabus());

        ArrayList<Module> modules = course.getModule();
        JSONArray moduleArray = new JSONArray();

        for(Module module: modules){
            JSONObject moduleObject = new JSONObject();
            moduleObject.put(COURSE_MODULES, module);

            moduleArray.add(moduleObject);

        }

        courseDetails.put(COURSE_RATING,course.getRating());

        ArrayList<Review> reviews = course.getReview();
        JSONArray reviewArray = new JSONArray();

        for(Review review: reviews){
            JSONObject reviewObject = new JSONObject();
            reviewObject.put(COURSE_REVIEWS, review);

            reviewArray.add(reviewObject);

        }

        ArrayList<Comment> comments = course.getComment();
        JSONArray commentArray = new JSONArray();

        for(Comment comment: comments){
            JSONObject commentObject = new JSONObject();
            commentObject.put(COURSE_COMMENTS, comment);

            commentArray.add(commentObject);

        }
        
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
    public static void main(String[] args){
        saveCourses();
        
    }
}
