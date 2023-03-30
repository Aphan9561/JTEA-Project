import java.util.ArrayList;
import java.util.UUID;

/**
 * this is the student
 * @author: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
public class Student {
    UUID id;
    private ArrayList<Integer> grades = new ArrayList<Integer>();

    /**
     * Creates student with id
     * @param id user's id
     */
    public Student(UUID id) {
        this.id = id;
        grades = new ArrayList<>();
    }

    /**
     * creates student with id and grades
     * @param id    user's id
     * @param grade user's grades
     */
    public Student(UUID id, ArrayList<Integer> grade) {
        this.id = id;
        this.grades.addAll(grade);
    }

    /**
     * get student's id
     * @return student's id
     */
    public UUID getId() {
        return id;
    }

    /**
     * get student's grades
     * @return student's grades
     */
    public ArrayList<Integer> getGrades() {
        return grades;
    }

    /**
     * Creates a String representation of student
     * @return student information
     */
    public String toString() {
        String result = "Student ID: " + id + "\nGrades: ";
        for (Integer grade : grades) {
            result += grade + ", ";
        }
        result += "\n";
        return result;

    }
}
