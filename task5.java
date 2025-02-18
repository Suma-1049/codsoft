import java.util.*;

class Course {
    String courseCode, title, description, schedule;
    int capacity, enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public boolean isAvailable() {
        return enrolledStudents < capacity;
    }

    public void enrollStudent() {
        if (isAvailable()) {
            enrolledStudents++;
        }
    }

    public void dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }

    public void displayCourse() {
        System.out.println(courseCode + " | " + title + " | " + description + " | Slots: " + (capacity - enrolledStudents) + "/" + capacity + " | Schedule: " + schedule);
    }
}

class Student {
    int studentID;
    String name;
    List<Course> registeredCourses = new ArrayList<>();

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void registerCourse(Course course) {
        if (course.isAvailable()) {
            registeredCourses.add(course);
            course.enrollStudent();
            System.out.println("✅ Successfully registered for " + course.title);
        } else {
            System.out.println("❌ Course is full! Cannot register.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.dropStudent();
            System.out.println("✅ Successfully dropped " + course.title);
        } else {
            System.out.println("❌ You are not registered for this course.");
        }
    }

    public void displayRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("⚠ No courses registered.");
        } else {
            System.out.println("📜 Courses registered by " + name + ":");
            for (Course course : registeredCourses) {
                System.out.println("- " + course.title);
            }
        }
    }
}

public class task5 {
    static List<Course> courses = new ArrayList<>();
    static List<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeCourses();

        while (true) {
            System.out.println("\n===== STUDENT COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. List Available Courses");
            System.out.println("2. Register Student");
            System.out.println("3. Register for a Course");
            System.out.println("4. Drop a Course");
            System.out.println("5. View Student Courses");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    registerStudent();
                    break;
                case 3:
                    enrollStudentInCourse();
                    break;
                case 4:
                    dropCourseForStudent();
                    break;
                case 5:
                    viewStudentCourses();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye! 👋");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void initializeCourses() {
        courses.add(new Course("CS101", "Data Structures", "Introduction to DS", 3, "Mon & Wed 10 AM"));
        courses.add(new Course("CS102", "Algorithms", "Fundamentals of Algorithms", 2, "Tue & Thu 2 PM"));
        courses.add(new Course("CS103", "Database Systems", "SQL & NoSQL Databases", 4, "Fri 11 AM"));
    }

    public static void listCourses() {
        System.out.println("\n📌 Available Courses:");
        for (Course course : courses) {
            course.displayCourse();
        }
    }

    public static void registerStudent() {
        System.out.print("\nEnter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        students.add(new Student(id, name));
        System.out.println("✅ Student registered successfully!");
    }

    public static void enrollStudentInCourse() {
        Student student = findStudent();
        if (student == null) return;

        listCourses();
        System.out.print("Enter Course Code to register: ");
        String code = scanner.next();

        Course course = findCourse(code);
        if (course == null) {
            System.out.println("❌ Invalid Course Code.");
            return;
        }

        student.registerCourse(course);
    }

    public static void dropCourseForStudent() {
        Student student = findStudent();
        if (student == null) return;

        student.displayRegisteredCourses();
        System.out.print("Enter Course Code to drop: ");
        String code = scanner.next();

        Course course = findCourse(code);
        if (course == null) {
            System.out.println("❌ Invalid Course Code.");
            return;
        }

        student.dropCourse(course);
    }

    public static void viewStudentCourses() {
        Student student = findStudent();
        if (student == null) return;

        student.displayRegisteredCourses();
    }

    public static Student findStudent() {
        System.out.print("\nEnter Student ID: ");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.studentID == id) {
                return student;
            }
        }

        System.out.println("❌ Student not found! Register first.");
        return null;
    }

    public static Course findCourse(String code) {
        for (Course course : courses) {
            if (course.courseCode.equalsIgnoreCase(code)) {
                return course;
            }
        }
        return null;
    }
}
