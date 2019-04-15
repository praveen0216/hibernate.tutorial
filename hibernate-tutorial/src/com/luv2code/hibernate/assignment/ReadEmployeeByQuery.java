package com.luv2code.hibernate.assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployeeByQuery {

	public static void main(String args[]) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("begin Transaction ");
			session.beginTransaction();

			List<Employee> employee = session.createQuery("from Employee").getResultList();

			System.out.println("Display Employee list ");
			displayEmployee(employee);

			session.getTransaction().commit();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			System.out.println("closing factory");

			session.close();
			factory.close();

		}

	}

	public static void displayEmployee(List<Employee> employee) {

		for (Employee tempEmployee : employee) {
			System.out.println(tempEmployee.toString()+"\n\n------------------------------------------------------------------");

		}

	}
}
