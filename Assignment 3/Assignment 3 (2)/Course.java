/**
 * Represents a course in the system
 * Uses wrapper classes (Integer) for IDs and credit hours
 */
public class Course {
    private Integer courseId;      // Wrapper class for int
    private String courseName;
    private Integer creditHours;   // Wrapper class for int

    // Constructor
    public Course(Integer courseId, String courseName, Integer creditHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    // Getters
    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCreditHours() {
        return creditHours;
    }
}