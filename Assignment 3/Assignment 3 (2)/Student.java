import java.util.ArrayList;

/**
 * Represents a student in the system
 * Implements Registrable interface
 * Contains inner class CourseRegistration
 */
public class Student implements Registrable {
    private Integer studentId;     // Wrapper class for int
    private String name;
    private ArrayList<CourseRegistration> registrations;

    // ============================================
    // INNER CLASS: CourseRegistration
    // ============================================
    public class CourseRegistration {
        private Course course;
        private Double grade;      // Wrapper class for double

        public CourseRegistration(Course course, Double grade) {
            this.course = course;
            this.grade = grade;
        }

        public Course getCourse() {
            return course;
        }

        public Double getGrade() {
            return grade;
        }
    }
    // ============================================

    // Constructor
    public Student(Integer studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registrations = new ArrayList<>();
    }

    // Implementing interface method
    @Override
    public void registerCourse(Course course, Double grade) {
        // Creating inner class instance
        CourseRegistration registration = new CourseRegistration(course, grade);
        registrations.add(registration);
    }

    // Print report using StringBuilder
    public void printReport() {
        StringBuilder report = new StringBuilder();
        
        report.append("\n╔════════════════════════════════════════╗\n");
        report.append("║          STUDENT REPORT                ║\n");
        report.append("╠════════════════════════════════════════╣\n");
        report.append("║ Student ID: ").append(studentId).append("\n");
        report.append("║ Name: ").append(name).append("\n");
        report.append("╠════════════════════════════════════════╣\n");
        report.append("║ REGISTERED COURSES:                    \n");
        report.append("╠────────────────────────────────────────╣\n");

        if (registrations.isEmpty()) {
            report.append("║  No courses registered yet.\n");
        } else {
            for (CourseRegistration reg : registrations) {
                report.append("║  • ").append(reg.getCourse().getCourseName());
                report.append(" (ID: ").append(reg.getCourse().getCourseId()).append(")\n");
                report.append("║    Credits: ").append(reg.getCourse().getCreditHours());
                report.append(" | Grade: ");
                
                // Unboxing example: Double -> double
                if (reg.getGrade() != null) {
                    report.append(reg.getGrade());
                } else {
                    report.append("Not Assigned");
                }
                report.append("\n");
            }
        }
        
        report.append("╚════════════════════════════════════════╝\n");
        
        System.out.println(report.toString());
    }

    // Getters
    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<CourseRegistration> getRegistrations() {
        return registrations;
    }
}