package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
	
		//create session factory
	SessionFactory factory= new Configuration()
			.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	// create session object
	Session session=factory.getCurrentSession();
	
   try
   {
	 
	   int studentId=1;
	   
	  // begin a  transaction
	  System.out.println("Initiating transaction");
	  session.beginTransaction();
	  
	   //retrieve student based on the id: primary key
	  System.out.println("Getting student with id: "+studentId);
	  
	  Student myStudent=session.get(Student.class,studentId);
	
	  System.out.println("updating student...");
	  myStudent.setFirstName("Scooby");
	  
	   //commit the transaction
	 System.out.println("Commit transaction");
	   session.getTransaction().commit();
	   
	 //new code
	   
	   session=factory.getCurrentSession();
	   session.beginTransaction();
	   
	   //update email for all students
	   
	   System.out.println("updating email for all atudents");
	   
	   session.createQuery("update Student s set s.email='foo@gmail.com' ").executeUpdate();
	   
	   System.out.println("done");
	   
	   //commit transaction
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
