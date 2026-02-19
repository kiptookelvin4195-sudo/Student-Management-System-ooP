// 1. ABSTRACTION: Abstract class defining a general Person
abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    // Abstract method to be implemented by subclasses (Polymorphism)
    public abstract void displayDetails();
}

// 2. ENCAPSULATION: Course details kept private with getters/setters
class Course {
    private String courseName;
    private String courseCode;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseInfo() {
        return courseCode + " - " + courseName;
    }
}

// 3. INHERITANCE: Student inherits from Person
class Student extends Person {
    private int studentId;
    private double marks;
    private Course enrolledCourse; // Composition: Student has a Course

    public Student(int studentId, String name, double marks, Course course) {
        super(name); // Calling parent constructor
        this.studentId = studentId;
        this.marks = marks;
        this.enrolledCourse = course;
    }

    // ENCAPSULATION: Getters and Setters
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    // Logic to calculate grade
    public String calculateGrade() {
        if (marks >= 70) return "A (Excellent)";
        else if (marks >= 60) return "B (Very Good)";
        else if (marks >= 50) return "C (Good)";
        else if (marks >= 40) return "D (Pass)";
        else return "F (Fail)";
    }

    // 4. POLYMORPHISM: Overriding the abstract method
    @Override
    public void displayDetails() {
        System.out.println("------- STUDENT REPORT -------");
        System.out.println("Student ID : " + studentId);
        System.out.println("Full Name  : " + name);
        System.out.println("Course     : " + enrolledCourse.getCourseInfo());
        System.out.println("Score      : " + marks + "%");
        System.out.println("Final Grade: " + calculateGrade());
        System.out.println("------------------------------\n");
    }
}

// 5. MAIN APPLICATION CLASS
public class StudentManagementSystem {
    public static void main(String[] args) {
        // Creating Course objects
        Course itCourse = new Course("Software Design", "SIT202");
        Course csCourse = new Course("Computer Science", "CSC101");

        // Creating Student objects (Demonstrating Class Design)
        Student student1 = new Student(1001, "Alice Munene", 85.5, itCourse);
        Student student2 = new Student(1002, "John Doe", 58.0, csCourse);
        Student student3 = new Student(1003, "Grace Hopper", 35.0, itCourse);

        // Displaying details
        student1.displayDetails();
        student2.displayDetails();
        student3.displayDetails();
    }
}
