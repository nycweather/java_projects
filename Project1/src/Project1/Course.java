package Project1;

public class Course {
    private String name;
    private String courseId;

    public Course(String name, String courseId) {
        this.name = name;
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Course [name=" + name + ", courseId=" + courseId + "]";
    }
}
