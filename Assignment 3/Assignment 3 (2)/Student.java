import java.util.ArrayList;

/**
 * Student class - implements Registrable interface
 * Contains inner class CourseRegistration
 */
public class Student implements Registrable {
    private Integer studentId;
    private String name;
    private ArrayList<CourseRegistration> registrations;

    // Inner class to store course and grade together
    public class CourseRegistration {
        private Course course;
        private Double grade;

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

    public Student(Integer studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registrations = new ArrayList<>();
    }

    @Override
    public void registerCourse(Course course, Double grade) {
        registrations.add(new CourseRegistration(course, grade));
    }

    public void printReport() {
        StringBuilder report = new StringBuilder();

        report.append("\n========== STUDENT REPORT ==========\n");
        report.append("Student ID: ").append(studentId).append("\n");
        report.append("Name: ").append(name).append("\n");
        report.append("====================================\n");
        report.append("REGISTERED COURSES:\n");
        report.append("------------------------------------\n");

        if (registrations.isEmpty()) {
            report.append("No courses registered.\n");
        } else {
            for (CourseRegistration reg : registrations) {
                report.append("• ").append(reg.getCourse().getCourseName());
                report.append(" (ID: ").append(reg.getCourse().getCourseId()).append(")\n");
                report.append("  Credits: ").append(reg.getCourse().getCreditHours());
                report.append(" | Grade: ");

                if (reg.getGrade() != null) {
                    report.append(reg.getGrade());
                } else {
                    report.append("Not Assigned");
                }
                report.append("\n");
            }
        }

        report.append("====================================\n");
        System.out.println(report.toString());
    }

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