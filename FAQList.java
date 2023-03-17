import java.util.ArrayList;

public class FAQList {
    
    private static ArrayList<FAQ> FAQs;
    private static FAQList FAQList;

    public FAQList() {
        FAQs = DataLoader.getFAQs();
    }
    
    public static FAQList getInstance() {
        if(FAQList == null){
            FAQList = new FAQList();
        }
        return FAQList;
    }

    public void addFAQ(Question question) {

    }

    public void addFAQ(String question) {

    }

    public ArrayList<FAQ> getFAQ(){
        return FAQs;
    } 
}
