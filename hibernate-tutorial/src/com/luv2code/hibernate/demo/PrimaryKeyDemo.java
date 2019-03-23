package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session object
		Session session=factory.getCurrentSession();
		
	   try
	   {
		   //create a student object 
		  System.out.println("creating a student object");
		   
		  Student student1=new Student("Ankit","Sharma","as@gmail.com"); 
		  Student student2=new Student("Deepak","Sharma","ds@gmail.com");
		  Student student3=new Student("Ronit","Sandhu","rs@gmail.com");
		   
		  // begin a  transaction
		  System.out.println("Initiating transaction");
		  session.beginTransaction();
		  
		   //save the student object
		  System.out.println("Saving oject to session");
		 //int theId=(Integer) session.save(student1);
		 
		 session.save(student1);
		 session.save(student2);
		 session.save(student3);
		 
		 
		   //commit the transaction
		 System.out.println("Commit transaction");
		   session.getTransaction().commit();
		   
		   
		   
	   }
	   catch(Exception e) {
		   System.out.println("Error : "+e);
		   
	   }
		
	   finally{
		   System.out.println("Closing factory or connection");
		   factory.close();
	   }
		

		

	}

}
