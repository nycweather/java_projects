package Project1;
import java.util.ArrayList;

public class StudentRecord {
    private Student student;
    private ArrayList<Course> courses;

    public StudentRecord(Student student) {
        this.student = student;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public boolean hasCourse(Course course) {
        return courses.contains(course);
    }

    public Student getStudent() {
        return student;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "StudentRecord [student=" + student + ", courses=" + courses + "]";
    }
}
