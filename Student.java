import java.util.ArrayList;
import java.util.UUID;

public class Student {
    UUID id;
    private ArrayList<Integer> grades;

    public Student(UUID id){
        this.id = id;
        grades = new ArrayList<>();
    }

    public Student(UUID id, ArrayList<Integer> grade){
        this.id = id;
        this.grades.addAll(grade);
    }

    public String toString(){
        return "Student id: "+id+
            "Student grades: "+grades;
    }
}
