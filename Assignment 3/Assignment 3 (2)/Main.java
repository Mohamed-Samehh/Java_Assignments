import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Main class - Entry point of the application
 * Demonstrates StringTokenizer and autoboxing/unboxing
 */
public class Main {
    // Data storage
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize some courses
        initializeCourses();
        
        System.out.println("Welcome to Student Registration System!");
        
        int choice;
        do {
            printMenu();
            choice = getIntInput();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    registerForCourses();
                    break;
                case 3:
                    printStudentReport();
                    break;
                case 4:
                    listAllCourses();
                    break;
                case 5:
                    listAllStudents();
                    break;
                case 6:
                    System.out.println("\nThank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
        
        scanner.close();
    }

    // Display menu
    private static void printMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Add Student");
        System.out.println("2. Register for Courses");
        System.out.println("3. Print Student Report");
        System.out.println("4. List All Courses");
        System.out.println("5. List All Students");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // Initialize default courses
    private static void initializeCourses() {
        // Autoboxing: int values automatically converted to Integer
        courses.add(new Course(101, "OOP", 3));
        courses.add(new Course(102, "Databases", 4));
        courses.add(new Course(103, "Data Structures", 3));
        courses.add(new Course(104, "Web Development", 3));
        courses.add(new Course(105, "Algorithms", 4));
        
        System.out.println("5 courses loaded into the system.");
    }

    // Add a new student
    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        
        System.out.print("Enter Student ID: ");
        int id = getIntInput();  // primitive int
        
        // Check if ID already exists
        if (findStudentById(id) != null) {
            System.out.println("Error: Student ID already exists!");
            return;
        }
        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        
        // Autoboxing: int -> Integer when passing to constructor
        Student student = new Student(id, name);
        students.add(student);
        
        System.out.println("✓ Student '" + name + "' added successfully!");
    }

    // Register student for courses using StringTokenizer
    private static void registerForCourses() {
        System.out.println("\n--- Register for Courses ---");
        
        if (students.isEmpty()) {
            System.out.println("No students in the system. Please add a student first.");
            return;
        }
        
        // Show available students
        listAllStudents();
        
        System.out.print("Enter Student ID: ");
        int studentId = getIntInput();
        
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        // Show available courses
        listAllCourses();
        
        System.out.println("\nEnter Course IDs separated by commas (e.g., 101,102,103):");
        System.out.print("Course IDs: ");
        String input = scanner.nextLine();
        
        // Using StringTokenizer to parse the input
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        
        System.out.println("\nRegistering courses...");
        
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            
            try {
                // Autoboxing happens here: int -> Integer
                int courseId = Integer.parseInt(token);
                
                Course course = findCourseById(courseId);
                
                if (course != null) {
                    System.out.print("Enter grade for " + course.getCourseName());
                    System.out.print(" (or -1 if not available): ");
                    double gradeInput = getDoubleInput();
                    
                    // Autoboxing: double -> Double
                    // If -1, we store null instead
                    Double grade = (gradeInput == -1) ? null : gradeInput;
                    
                    // Register using interface method
                    student.registerCourse(course, grade);
                    System.out.println("  ✓ Registered for: " + course.getCourseName());
                    
                } else {
                    System.out.println("  ✗ Course ID " + courseId + " not found!");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("  ✗ Invalid course ID: " + token);
            }
        }
        
        System.out.println("\nRegistration complete!");
    }

    // Print report for a student
    private static void printStudentReport() {
        System.out.println("\n--- Print Student Report ---");
        
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        
        listAllStudents();
        
        System.out.print("Enter Student ID: ");
        int studentId = getIntInput();
        
        Student student = findStudentById(studentId);
        
        if (student != null) {
            // This method uses StringBuilder internally
            student.printReport();
        } else {
            System.out.println("Student not found!");
        }
    }

    // List all courses
    private static void listAllCourses() {
        System.out.println("\n--- Available Courses ---");
        System.out.println("ID\tName\t\t\tCredits");
        System.out.println("----------------------------------------");
        
        for (Course course : courses) {
            // Unboxing: Integer -> int happens automatically in print
            System.out.println(course.getCourseId() + "\t" + 
                             course.getCourseName() + "\t\t" + 
                             course.getCreditHours());
        }
    }

    // List all students
    private static void listAllStudents() {
        System.out.println("\n--- All Students ---");
        
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }
        
        System.out.println("ID\tName");
        System.out.println("--------------------");
        
        for (Student student : students) {
            // Unboxing: Integer -> int
            System.out.println(student.getStudentId() + "\t" + student.getName());
        }
    }

    // Helper: Find student by ID
    private static Student findStudentById(int id) {
        for (Student student : students) {
            // Unboxing for comparison: Integer -> int
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    // Helper: Find course by ID
    private static Course findCourseById(int id) {
        for (Course course : courses) {
            // Unboxing for comparison: Integer -> int
            if (course.getCourseId() == id) {
                return course;
            }
        }
        return null;
    }

    // Helper: Get integer input safely
    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }

    // Helper: Get double input safely
    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return value;
    }
}