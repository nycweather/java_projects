package Project1;
import java.util.ArrayList;

public class CourseRoster {
    private Course course;
    private ArrayList<Student> students;

    public CourseRoster(Course course) {
        this.course = course;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "CourseRoster [course=" + course + ", students=" + students + "]";
    }
}
