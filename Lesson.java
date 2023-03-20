/*
 * This is a lesson
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */

public class Lesson {
    private String content;
    private String title;

    public Lesson(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public String toString() {
        return this.title+"\n "+this.content;
    }
}