package com.luv2code.hibernate.assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployee {
	
	public static void main(String args[])
	{
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		
		try {
			
			//get the object id which needs to be observed 
			
			int id =2 ;
			Employee employee3=new Employee("Ankit ","Sharma","BOI",null);

			
			System.out.println("begin Transaction ");
			session.beginTransaction();
			
			session.save(employee3);
			
			Employee employee=session.get(Employee.class,employee3.getId());
			
			session.getTransaction().commit();
			
			
			System.out.println("Employee extracted from Database \n"+employee.toString());
			
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			System.out.println("closing factory");
			
			session.close();
			factory.close();
			
			
		}
		
		
		
		
		
		
	}
}
