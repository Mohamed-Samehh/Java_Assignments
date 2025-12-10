import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Simple Student Registration System
 * Demonstrates StringTokenizer and autoboxing/unboxing
 */
public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadCourses();
        System.out.println("Welcome to Student Registration System!\n");

        while (true) {
            showMenu();
            int choice = getInt();

            if (choice == 1)
                addStudent();
            else if (choice == 2)
                registerForCourses();
            else if (choice == 3)
                printStudentReport();
            else if (choice == 4)
                listAllCourses();
            else if (choice == 5)
                listAllStudents();
            else if (choice == 6) {
                System.out.println("\nGoodbye!");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
        scanner.close();
    }

    static void showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Add Student");
        System.out.println("2. Register for Courses");
        System.out.println("3. Print Student Report");
        System.out.println("4. List All Courses");
        System.out.println("5. List All Students");
        System.out.println("6. Exit");
        System.out.print("Choice: ");
    }

    static void loadCourses() {
        courses.add(new Course(101, "OOP", 3));
        courses.add(new Course(102, "Databases", 4));
        courses.add(new Course(103, "Data Structures", 3));
        courses.add(new Course(104, "Web Development", 3));
        courses.add(new Course(105, "Algorithms", 4));
        System.out.println("5 courses loaded.");
    }

    static void addStudent() {
        System.out.println("\n--- Add Student ---");
        System.out.print("Student ID: ");
        int id = getInt();

        if (findStudent(id) != null) {
            System.out.println("Error: ID already exists!");
            return;
        }

        System.out.print("Student Name: ");
        String name = scanner.nextLine();

        students.add(new Student(id, name));
        System.out.println("Student added!");
    }

    static void registerForCourses() {
        System.out.println("\n--- Register for Courses ---");

        if (students.isEmpty()) {
            System.out.println("No students. Add a student first.");
            return;
        }

        listAllStudents();
        System.out.print("Student ID: ");
        int studentId = getInt();

        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        listAllCourses();
        System.out.println("\nEnter Course IDs separated by commas (e.g., 101,102,103):");
        System.out.print("Course IDs: ");
        String input = scanner.nextLine();

        // StringTokenizer splits the input by commas
        StringTokenizer tokenizer = new StringTokenizer(input, ",");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            try {
                int courseId = Integer.parseInt(token);
                Course course = findCourse(courseId);

                if (course != null) {
                    System.out.print("Grade for " + course.getCourseName() + " (-1 if none): ");
                    double gradeInput = getDouble();

                    // Store null if -1, otherwise store the grade
                    Double grade = (gradeInput == -1) ? null : gradeInput;
                    student.registerCourse(course, grade);
                    System.out.println("  Registered!");
                } else {
                    System.out.println("  Course " + courseId + " not found!");
                }
            } catch (NumberFormatException e) {
                System.out.println("  Invalid ID: " + token);
            }
        }
        System.out.println("Registration complete!");
    }

    static void printStudentReport() {
        System.out.println("\n--- Student Report ---");

        if (students.isEmpty()) {
            System.out.println("No students.");
            return;
        }

        listAllStudents();
        System.out.print("Student ID: ");
        int studentId = getInt();

        Student student = findStudent(studentId);
        if (student != null) {
            student.printReport();
        } else {
            System.out.println("Student not found!");
        }
    }

    static void listAllCourses() {
        System.out.println("\n--- Courses ---");
        System.out.println("ID\tName\t\t\tCredits");
        System.out.println("----------------------------------------");
        for (Course c : courses) {
            System.out.println(c.getCourseId() + "\t" + c.getCourseName() + "\t\t" + c.getCreditHours());
        }
    }

    static void listAllStudents() {
        System.out.println("\n--- Students ---");
        if (students.isEmpty()) {
            System.out.println("No students.");
            return;
        }
        System.out.println("ID\tName");
        System.out.println("--------------------");
        for (Student s : students) {
            System.out.println(s.getStudentId() + "\t" + s.getName());
        }
    }

    static Student findStudent(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id)
                return s;
        }
        return null;
    }

    static Course findCourse(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id)
                return c;
        }
        return null;
    }

    static int getInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    static double getDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Enter a valid number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}