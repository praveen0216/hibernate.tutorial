package com.luv2code.hibernate.assignment;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployee {
	
	
	public static void main(String argd[])
	{
		
		
			
		
		//create a seesion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Employee.class).buildSessionFactory();
		
		//create a session
		Session session= factory.getCurrentSession();
		
		System.out.println("Session object created");
		
		try {
		//create objects that needs to be inserted into the databse
			String theDateOfBirthStr = "31/12/1993";
			 
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
 
            

			
		Employee employee1=new Employee("Bidya","Dash","TCS",theDateOfBirth);
		
		Employee employee2=new Employee() ;
		employee2.setFirstName("Prachi");
		employee2.setLastName("Hota");
		employee2.setCompany("TCS");
		
		session.beginTransaction();
		
		//save the object S
		session.save(employee1);
		session.save(employee2);
		
		System.out.println("employee object : saved");
		session.getTransaction().commit();
		
		System.out.println("object committed");
		
		System.out.println("closing factory");
		factory.close();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			session.close();
		factory.close();	
		System.out.println("done!");
		}

		
		
	}

}
