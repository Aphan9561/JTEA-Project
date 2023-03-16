import java.util.ArrayList;
import java.util.UUID;

public class Student {
    UUID id;
    private ArrayList<Grade> grades;

    public Student(UUID id){
        this.id = id;
        grades = new ArrayList<>();
    }

    public Student(UUID id, ArrayList<Grade> grade){
        this.id = id;
        this.grades.addAll(grade);
    }
}
