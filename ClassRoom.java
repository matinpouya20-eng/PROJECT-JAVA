
import java.io.Serializable;

public class ClassRoom implements Serializable {

    
    private String classCode;

    
    private String className;

    
    private String roomNumber;

    
    private int capacity;

   
    public ClassRoom(String classCode, String className,
                     String roomNumber, int capacity) {

        this.classCode = classCode;
        this.className = className;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

   
    public String getClassCode() {
        return classCode;
    }

    
    public String getClassName() {
        return className;
    }

    
    public String getRoomNumber() {
        return roomNumber;
    }


    public int getCapacity() {
        return capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    
    public void displayInfo() {
        System.out.println("Class Code: " + classCode);
        System.out.println("Class Name: " + className);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Capacity: " + capacity);
    }
}