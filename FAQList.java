import java.util.ArrayList;

/**
 * A FAQList
 * @author: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class FAQList {
    
    private static ArrayList<FAQ> FAQs;
    private static FAQList FAQList;

    /**
     * Creates a new ArrayList of FAQ
     */
    public FAQList() {
        FAQs = DataLoader.getFAQs();
    }
    
    /**
     * Checks if there is a FAQList and if it isn't, it makes a new one.
     * If there is, it returns it. 
     * @return an instance of FAQList
     */
    public static FAQList getInstance() {
        if(FAQList == null){
            FAQList = new FAQList();
        }
        return FAQList;
    }

    /**
     * Adds a FAQ to the ArrayList FAQs
     * @param question a question
     */
    public void addFAQ(Question question) {
        FAQs.add(new FAQ(question));
    }

    /**
     * Adds a FAQ to the ArrayList FAQs
     * @param question a question
     */
    public void addFAQ(String question) {
        FAQs.add(new FAQ(question));
    }

    /**
     * Return ArrayList of FAQs
     * @return ArrayList of FAQs
     */
    public ArrayList<FAQ> getFAQ(){
        return FAQs;
    }

    /**
     * Returns details of the FAQ
     * @return A string representation of a FAQ
     */
    public String FAQstoString() {
        String result = "";
        for(FAQ faq : FAQs) {
            result += faq.toString();
        }
        return result;
    }
}
