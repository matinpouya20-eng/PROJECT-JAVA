public class Teacher extends Person {

    private String employeeNumber;

    public Teacher(
            String name,
            String nationalId,
            String employeeNumber) {

        super(name, nationalId);

        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    @Override 
    public String toString() {
        return "Teacher: "
                + getName()
                + " | Employee Number: "
                + employeeNumber;
    }

    public static void add(Teacher teacher) {
       
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
