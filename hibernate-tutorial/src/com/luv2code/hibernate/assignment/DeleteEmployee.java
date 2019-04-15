package com.luv2code.hibernate.assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				
			.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			/*
			 * session.beginTransaction();
			 * 
			 * Employee employee=new Employee("testEmployee","testEmployee","NoWhere");
			 * 
			 * session.save(employee);
			 */
			  
			  session.beginTransaction();
			
			  session.
			  createQuery("delete from Employee where company='NoWhere' "
			  ).executeUpdate();
			 
			  
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
