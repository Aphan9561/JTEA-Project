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
                String type = (String)personJSON.get(USER_TYPE);

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
                    JSONObject moduleJSON = (JSONObject)modulesJSON.get(i);
                    String moduleName = (String)moduleJSON.get(COURSE_MODULES_NAME);
                    
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
}

