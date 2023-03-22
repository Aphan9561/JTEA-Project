import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        userDetails.put(USER_BIRTHDAY, formattingDate(user.getBirthday()));
        userDetails.put(USER_USERNAME, user.getUsername().toString());
        userDetails.put(USER_TYPE, user.getType().toString());
        userDetails.put(USER_PASSWORD, user.getPassword());

        return userDetails;
    }
    
    public static String formattingDate(Date input){
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String date = formatter.format(input);;
        return date;
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
        courseDetails.put(COURSE_AUTHOR, course.getAuthor().toString());
        courseDetails.put(COURSE_LANGUAGE, course.getLanguage().toString());
        courseDetails.put(COURSE_DESCRIPTION, course.getDesciption());
        courseDetails.put(COURSE_SYLLABUS,course.getSyllabus());
        courseDetails.put(COURSE_MODULES, course.getModule().toString());

        ArrayList<Module> modules = course.getModule();
        JSONArray moduleArray = new JSONArray();
        for(Module module: modules){
            JSONObject moduleObject = new JSONObject();

            moduleObject.put(COURSE_MODULES_NAME, module.getTitle());

            ArrayList<Lesson> lessons = module.getCurrentLesson();
            JSONArray lessonArray = new JSONArray();
            for (Lesson lesson: lessons){
                JSONObject lessonObject = new JSONObject();
                lessonObject.put(COURSE_MODULES_LESSON_TITLE, lesson.getTitle());
                lessonObject.put(COURSE_MODULES_LESSON_CONTENT, lesson.getContent());

                ArrayList<Quiz> quizzes = lesson.getQuiz();
                JSONArray quizArray = new JSONArray();
                for(Quiz quiz: quizzes){
                    JSONObject quizObject = new JSONObject();

                    ArrayList<Question> questions = quiz.getQuestion();
                    JSONArray questionArray = new JSONArray();
                    for(Question question: questions){
                        JSONObject questionObject = new JSONObject();
                        questionObject.put(COURSE_MODULES_LESSON_QUIZQUESTIONS_QUESTION, question.getQuestion());

                        ArrayList<String> answers = question.getAnswers();
                        JSONArray answerArray = new JSONArray();
                        for(String answer: answers){
                            JSONObject answerObject = new JSONObject();
                            answerObject.put(COURSE_MODULES_LESSON_QUIZQUESTIONS_ANSWERS,answer);

                            answerArray.add(answerObject);
                        }
                        
                        questionObject.put(COURSE_MODULES_LESSON_QUIZQUESTIONS_CORRECTANS, question.getCorrectAnswer());

                        questionArray.add(questionObject);
                    }
        
                quizArray.add(quizObject);
            }

                lessonArray.add(lessonObject);
            }

            ArrayList<Comment> comments = module.getComment();
            JSONArray commentArray = new JSONArray();
            for(Comment comment: comments){
                JSONObject commentObject = new JSONObject();
                commentObject.put(COURSE_MODULES_COMMENTS_USER, comment.getUser().toString());
                commentObject.put(COURSE_MODULES_COMMENTS_COMMENT, comment.getComment());

                ArrayList<Reply> replies = comment.getReply();
                JSONArray repliesArray = new JSONArray();
                for(Reply reply: replies){
                    JSONObject replyObject = new JSONObject();
                    replyObject.put(COURSE_MODULES_COMMENTS_REPLIES_USER, reply.getUser());
                    replyObject.put(COURSE_MODULES_COMMENTS_REPLIES_COMMENT, reply.getComment());

                    repliesArray.add(replyObject);
                }

                commentArray.add(commentObject);

            }

            moduleArray.add(moduleObject);

        }

        courseDetails.put(COURSE_RATING,course.getRating());
        courseDetails.put(COURSE_REVIEWS, course.getReview());

        ArrayList<Review> reviews = course.getReview();
        JSONArray reviewArray = new JSONArray();

        for(Review review: reviews){
            JSONObject reviewObject = new JSONObject();
            reviewObject.put(COURSE_REVIEWS_USER, review.getUser().toString());
            reviewObject.put(COURSE_REVIEWS_RATING, review.getRating());
            reviewObject.put(COURSE_REVIEWS_COMMENT, review.getComment());
            
            reviewArray.add(reviewObject);

        }

        courseDetails.put(COURSE_STUDENTS, course.getStudent().toString());

        ArrayList<Student> students = course.getStudent();
        JSONArray studentArray = new JSONArray();

        for(Student student: students){
            JSONObject studentObject = new JSONObject();
            studentObject.put(COURSE_STUDENTS_ID, student.getId().toString());

            ArrayList<Integer> grades = student.getGrades();
            JSONArray gradeArray = new JSONArray();

            for(Integer grade: grades){
                JSONObject gradeObject = new JSONObject();
                gradeObject.put(COURSE_STUDENTS_GRADES, grade);

                gradeArray.add(gradeObject);
            }
            
            studentArray.add(studentObject);

        }

        courseDetails.put(COURSE_COMMENTS, course.getComment());

        ArrayList<Comment> comments = course.getComment();
        JSONArray commentArray = new JSONArray();

        for(int i =0; i<comments.size(); i++){
            commentArray.add(getCommentJSON(comments.get(i)));
        }

        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
 
            file.write(commentArray.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return courseDetails;
    }

    public static JSONObject getCommentJSON(Comment comment){
        JSONObject commentDetails = new JSONObject();
        commentDetails.put(COURSE_COMMENTS_USER, comment.getUser().toString());
        commentDetails.put(COURSE_COMMENTS_COMMENT, comment.getComment());
        commentDetails.put(COURSE_COMMENTS_REPLIES, comment.getReply());

        ArrayList<Reply> replies = comment.getReply();
        JSONArray repliesArray = new JSONArray();

        for(int i = 0;i<replies.size();i++){
            repliesArray.add(getReplyJSON(replies.get(i)));
        }
        
        return commentDetails;
    }

    public static JSONObject getReplyJSON(Reply reply){
        JSONObject replyObject = new JSONObject();
        replyObject.put(COURSE_COMMENTS_REPLIES_USER, reply.getUser().toString());
        replyObject.put(COURSE_COMMENTS_REPLIES_COMMENT, reply.getComment());

        return replyObject;
    }

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
