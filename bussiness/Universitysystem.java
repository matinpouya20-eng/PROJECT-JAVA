package bussiness;

import model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Universitysystem implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Student> students = new ArrayList<>();


    private List<Teacher> teachers = new ArrayList<>();


    private List<Course> courses = new ArrayList<>();


    private List<ClassRoom> classRooms = new ArrayList<>();


    private List<Offering> offerings = new ArrayList<>();


    private List<Enrollment> enrollments = new ArrayList<>();


    public void addStudent(Student student) {
        students.add(student);
    }


    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }


    public void addCourse(Course course) {
        courses.add(course);
    }


    public void addClassRoom(ClassRoom classRoom) {
        classRooms.add(classRoom);
    }


    public void addOffering(Offering offering) {
        offerings.add(offering);
    }


    public Student findStudentByNumber(String studentNumber) {

        for (Student student : students) {

            if (student.getStudentNumber().equals(studentNumber)) {
                return student;
            }
        }


        return null;
    }


    public Course findCourseByCode(String courseCode) {

        for (Course course : courses) {

            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }

        return null;
    }


    public Offering findOfferingByCode(String offeringCode) {

        for (Offering offering : offerings) {

            if (offering.getOfferingCode().equals(offeringCode)) {
                return offering;
            }
        }

        return null;
    }


    public ClassRoom findClassRoom(String classCode) {

        for (ClassRoom classRoom : classRooms) {

            if (classRoom.getClassCode().equals(classCode)) {
                return classRoom;
            }
        }

        return null;
    }


    public boolean enrollStudent(
            String studentNumber,
            String offeringCode) {


        Student student = findStudentByNumber(studentNumber);


        Offering offering = findOfferingByCode(offeringCode);


        if (student == null || offering == null) {
            return false;
        }


        for (Enrollment enrollment : enrollments) {

            boolean sameStudent =
                    enrollment.getStudent()
                            .getStudentNumber()
                            .equals(studentNumber);

            boolean sameOffering =
                    enrollment.getOffering()
                            .getOfferingCode()
                            .equals(offeringCode);

            if (sameStudent && sameOffering) {
                return false;
            }
        }


        Enrollment enrollment =
                new Enrollment(student, offering);


        enrollments.add(enrollment);

        return true;
    }


    public boolean recordGrade(
            String studentNumber,
            String offeringCode,
            double grade) {

        for (Enrollment enrollment : enrollments) {

            boolean sameStudent =
                    enrollment.getStudent()
                            .getStudentNumber()
                            .equals(studentNumber);

            boolean sameOffering =
                    enrollment.getOffering()
                            .getOfferingCode()
                            .equals(offeringCode);

            if (sameStudent && sameOffering) {


                enrollment.setGrade(grade);

                return true;
            }
        }


        return false;
    }


    public void printTranscript(String studentNumber) {


        Student student = findStudentByNumber(studentNumber);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("===== STUDENT TRANSCRIPT =====");
        System.out.println("Student Number: " + studentNumber);
        System.out.println("Student Name: " + student.getName());

        boolean found = false;


        for (Enrollment enrollment : enrollments) {

            if (enrollment.getStudent()
                    .getStudentNumber()
                    .equals(studentNumber)) {

                found = true;

                System.out.println("------------------------------");

                System.out.println(
                        "Course: " +
                                enrollment.getOffering()
                                        .getCourse()
                                        .getCourseName()
                );

                System.out.println(
                        "Semester: " +
                                enrollment.getOffering().getSemester()
                );

                if (enrollment.hasGrade()) {

                    System.out.println(
                            "Grade: " + enrollment.getGrade()
                    );

                } else {

                    System.out.println("Grade: Not recorded");
                }
            }
        }

        if (!found) {
            System.out.println("No enrollments found.");
        }

        System.out.println("==============================");
    }


    public List<Enrollment> getEnrollments() {
        return enrollments;
    }


    public List<Teacher> getTeachers() {

        throw new UnsupportedOperationException("Unimplemented method 'getTeachers'");
    }
}
