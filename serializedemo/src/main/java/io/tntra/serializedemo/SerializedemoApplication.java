package io.tntra.serializedemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import student.Student;



@SpringBootApplication
public class SerializedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerializedemoApplication.class, args);



		Student s = new Student();

		s.name="deepti";
		s.contact=238537456;
		s.address="Tntra ";

		try{
			FileOutputStream fileout= new FileOutputStream("studentDetails.ser");

			ObjectOutputStream out= new ObjectOutputStream(fileout);

			out.writeObject(s);
			out.close();
			fileout.close();
			System.out.println("Serialized data is saved in /serialize/studentDetails.ser");
		}catch(IOException i){
              i.printStackTrace();
		}




		Student s1=null;

		try{
			FileInputStream filein=new FileInputStream("/home/deepti/Desktop/javaInDepth/Serialize-Deserialize/serializedemo/studentDetails.ser");
			ObjectInputStream in =new ObjectInputStream(filein);
			s1=(Student) in.readObject();
		    in.close();
		    filein.close();  
			System.out.println("File is Deserilized");  
		}catch(IOException i){
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c){
			System.out.println("Student class not found");
			c.printStackTrace();
			return;
		}
		
	}

}
