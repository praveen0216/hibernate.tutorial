package com.luv2code.hibernate.assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class UpdateEmployeeDetails {

	public static void main(String[] args) {
		
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				
			.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			  session.beginTransaction();
			  
			  //session.beginTransaction();
			  session.createQuery("update Employee set company='TCS' where firstName='Ronit' OR firstName='Prachi' ").executeUpdate();
			  
			  session.getTransaction().commit();
			 
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			System.out.println("closing factory and session ");
			session.close();
			factory.close();
		}

	}

}
