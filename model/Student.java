package model;

public class Student extends Person {
    private String studentNumber;

    
    public Student(String name, String nationalId, String studentNumber) {

        super(name, nationalId);

        this.studentNumber = studentNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }


    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
public String tostring() {
return "student:"
+ getName()
+ " | student number: "
+ studentNumber;
}

public void add(Student student) {

    throw new UnsupportedOperationException("Unimplemented method 'add'");
}

}


    

