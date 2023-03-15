import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{
    
    public ArrayList<User> getUsers() {
<<<<<<< HEAD
        ArrayList<User> users = new ArrayList<User>();
=======
        return null;
>>>>>>> b7834d0 (Updating Dataloader)

        try {
            FileReader reader = new FileReader(./JSON/course.json);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < peopleJSON.size(); i++) {
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Course> getCourses() {
        return null;

    }

    public ArrayList<FAQ> getFAQs() {
<<<<<<< HEAD

=======
        return null;
>>>>>>> b7834d0 (Updating Dataloader)
    }
}
