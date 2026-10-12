package model;

import java.io.Serializable;

public class Enrollment implements Serializable {

    
    private Student student;

   
    private Offering offering;

    
    private double grade = -1;

    
    public Enrollment(Student student, Offering offering) {
        this.student = student;
        this.offering = offering;
    }

    
    public Student getStudent() {
        return student;
    }

   
    public Offering getOffering() {
        return offering;
    }

   
    public double getGrade() {
        return grade;
    }

   
    public void setGrade(double grade) {

        if (grade < 0 || grade > 20) {
            throw new IllegalArgumentException(
                "Grade must be between 0 and 20"
            );
        }

        this.grade = grade;
    }

    
    public boolean hasGrade() {
        return grade >= 0;
    }


    public void displayInfo() {

        System.out.println(
            "Student: " + student.getName()
        );

        System.out.println(
            "Course: " +
            offering.getCourse().getCourseName()
        );

        System.out.println(
            "Semester: " + offering.getSemester()
        );

        if (hasGrade()) {
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Grade: Not registered yet");
        }
    }
}