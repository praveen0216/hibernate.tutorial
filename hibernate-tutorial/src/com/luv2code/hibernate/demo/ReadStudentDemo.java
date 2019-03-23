package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
	   
	  Student student1=new Student("Ankit","Agarwal","ag@gmail.com"); 
	  Student student2=new Student("Monica","Singh","Ms@gmail.com");
	   
	  // begin a  transaction
	  System.out.println("Initiating transaction");
	  session.beginTransaction();
	  
	   //save the student object
	  System.out.println("Saving oject to session");
	 //int theId=(Integer) session.save(student1);
	 
	 session.save(student2);
	 session.save(student1);
	 
	   //commit the transaction
	 System.out.println("Commit transaction");
	   session.getTransaction().commit();
	   
	   //
	   System.out.println("saved student. Generated id:"+student1.getId());
	   
	   //now get a new session and start trnsaction
	   session=factory.getCurrentSession();
	   session.beginTransaction();
	   
	   //retrieve student based on the id: primary key
	   System.out.println("\n getting student with id: "+student1.getId());
	   
	   Student myStudent=session.get(Student.class,student1.getId());
	   
	   System.out.println("Get Complete: "+myStudent);
	   //commit the transaction
	   session.getTransaction().commit();
	   
	   System.out.println("done");
	   
	   
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
