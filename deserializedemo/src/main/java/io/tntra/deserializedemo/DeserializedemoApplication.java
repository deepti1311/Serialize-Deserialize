package io.tntra.deserializedemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import student.Student;

@SpringBootApplication
public class DeserializedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeserializedemoApplication.class, args);

		Student s=null;

		try{
			FileInputStream filein=new FileInputStream("/home/deepti/Desktop/javaInDepth/Serialize-Deserialize/serializedemo/studentDetails.ser");
			ObjectInputStream in =new ObjectInputStream(filein);
			s=(Student) in.readObject();
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
