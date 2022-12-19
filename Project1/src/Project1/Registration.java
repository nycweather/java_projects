package Project1;
import Project1.*;
import java.util.Scanner;


public class Registration {
    private static SortedLinkedList<StudentRecord> studentRecords = new SortedLinkedList<>();
    private static SortedLinkedList<CourseRoster> courseRosters = new SortedLinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Add course");
            System.out.println("3. Register student for course");
            System.out.println("4. Drop course for student");
            System.out.println("5. Search for course in student record");
            System.out.println("6. Search for student in course roster");
            System.out.println("7. Display student record");
            System.out.println("8. Display course roster");
            System.out.println("9. Display master list of student records");
            System.out.println("10. Display master list of course rosters");
            System.out.println("11. Exit");
            System.out.print("Enter option: ");
            int option = sc.nextInt();
            sc.nextLine();
            if (option == 1) {
                addStudent(sc);
            } else if (option == 2) {
                addCourse(sc);
            } else if (option == 3) {
                registerStudentForCourse(sc);
            } else if (option == 4) {
                dropCourseForStudent(sc);
            } else if (option == 5) {
                searchForCourseInStudentRecord(sc);
            } else if (option == 6) {
                searchForStudentInCourseRoster(sc);
            } else if (option == 7) {
                displayStudentRecord(sc);
            } else if (option == 8) {
                displayCourseRoster(sc);
            } else if (option == 9) {
                displayMasterListOfStudentRecords();
            } else if (option == 10) {
                displayMasterListOfCourseRosters();
            } else if (option == 11) {
                break;
            }
        }
        sc.close();
    }

    private static void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        Student student = new Student(name, studentId);
        studentRecords.add(new StudentRecord(student));
    }

    private static void addCourse(Scanner sc) {
        System.out.print("Enter course name: ");
        String name = sc.nextLine();
        System.out.print("Enter course ID");
        String courseID = sc.nextLine();
        Course crs = new Course(name, courseID);
        Course.add(new Course(crs));
    } //not working
    
    private static void registerStudentForCourse(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        StudentRecord studentRecord = getStudentRecordByStudentId(studentId);
        if (studentRecord == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine();
        CourseRoster courseRoster = getCourseRosterByCourseId(courseId);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        if (studentRecord.hasCourse(courseRoster.getCourse())) {
            System.out.println("Student already registered for this course.");
            return;
        }
        studentRecord.addCourse(courseRoster.getCourse());
        courseRoster.addStudent(studentRecord.getStudent());
    }

    private static void dropCourseForStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        StudentRecord studentRecord = getStudentRecordByStudentId(studentId);
        if (studentRecord == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine();
        CourseRoster courseRoster = getCourseRosterByCourseId(courseId);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        if (!studentRecord.hasCourse(courseRoster.getCourse())) {
            System.out.println("Student not registered for this course.");
            return;
        }
        studentRecord.removeCourse(courseRoster.getCourse());
        courseRoster.removeStudent(studentRecord.getStudent());
    }

    private static void searchForCourseInStudentRecord(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        StudentRecord studentRecord = getStudentRecordByStudentId(studentId);
        if (studentRecord == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine();
        Course course = getCourseByCourseId(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        if (studentRecord.hasCourse(course)) {
            System.out.println("Student is registered for this course.");
        } else {
            System.out.println("Student is not registered for this course.");
        }
    }

    private static void searchForStudentInCourseRoster(Scanner sc) {
        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine();
        CourseRoster courseRoster = getCourseRosterByCourseId(courseId);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        Student student = getStudentByStudentId(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        if (courseRoster.hasStudent(student)) {
            System.out.println("Student is registered for this course.");
        } else {
            System.out.println("Student is not registered for this course.");
        }
    }

    private static void displayStudentRecord(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        StudentRecord studentRecord = getStudentRecordByStudentId(studentId);
        if (studentRecord == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println(studentRecord);
    }

    private static void displayCourseRoster(Scanner sc) {
        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine();
        CourseRoster courseRoster = getCourseRosterByCourseId(courseId);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.println(courseRoster);
    }

    private static void displayMasterListOfStudentRecords() {
        System.out.println(studentRecords);
    }

    private static void displayMasterListOfCourseRosters() {
        System.out.println(courseRosters);
    }

    private static StudentRecord getStudentRecordByStudentId(String studentId) {
        for (StudentRecord studentRecord : studentRecords) {
            if (studentRecord.getStudent().getStudentId().equals(studentId)) {
                return studentRecord;
            }
        }
        return null;
    }

    private static CourseRoster getCourseRosterByCourseId(String courseId) {
        for (CourseRoster courseRoster : courseRosters) {
            if (courseRoster.getCourse().getCourseId().equals(courseId)) {
                return courseRoster;
            }
        }
        return null;
    }

    private static Course getCourseByCourseId(String courseId) {
        for (CourseRoster courseRoster : courseRosters) {
            if (courseRoster.getCourse().getCourseId().equals(courseId)) {
                return courseRoster.getCourse();
            }
        }
        return null;
    }

    private static Student getStudentByStudentId(String studentId) {
        for (StudentRecord studentRecord : studentRecords) {
            if (studentRecord.getStudent().getStudentId().equals(studentId)) {
                return studentRecord.getStudent();
            }
        }
        return null;
    }
}


    
        
