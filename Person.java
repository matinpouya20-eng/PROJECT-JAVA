import java.io.Serializable;
import java.sql.Date;


public abstract class Person implements Serializable {

    private String name;
    private String nationalId;
    private boolean isAlived;
    private Date birthDate;
  
    public Person(String name, String nationalId) {

        this.name = name;
        this.nationalId = nationalId;
    }

   
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }


    public String getNationalId() {
        return nationalId;
    }

  
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    
}
