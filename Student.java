import java.util.ArrayList;
import java.util.UUID;

public class Student {
    UUID id;
    private ArrayList<Integer> grades = new ArrayList<Integer>();

    public Student(UUID id){
        this.id = id;
        grades = new ArrayList<>();
    }

    public Student(UUID id, ArrayList<Integer> grade){
        this.id = id;
        this.grades.addAll(grade);
    }

    public UUID getId(){
        return id;
    }

    public ArrayList<Integer> getGrades(){
        return grades;
    }

    public String toString(){
        String result = "Student ID: " + id + "\tGrades: ";
        for(Integer grade : grades) {
            result += grade + ", ";
        }
        result += "\n";
        return result;

    }
}
