
import java.io.Serializable;

public class Course implements Serializable {

    private String courseCode;
    private String courseName;
    private int units;

    public Course(String courseCode, String courseName, int units) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.units = units;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getUnits() {
        return units;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void displayInfo() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Units: " + units);
    }
}









