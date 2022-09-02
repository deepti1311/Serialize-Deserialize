package student;

import java.io.Serializable;

public class Student implements Serializable {

    public String name;
    public int contact;
    public String address;

    public void mailCheck(){
        System.out.println("sending mail to "+name+" "+address);
    }

    
}
