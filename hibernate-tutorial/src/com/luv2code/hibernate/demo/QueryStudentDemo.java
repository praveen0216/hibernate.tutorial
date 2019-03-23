package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session object
		Session session = factory.getCurrentSession();

		try {

			// begin a transaction
			System.out.println("Initiating transaction");
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student s where id=4 or s.firstName like '%nkit'")
					.getResultList();

			// display the student
			displayStudents(theStudents);

			// commit the transaction
			System.out.println("Commit transaction");
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error : " + e);

		}

		finally {
			System.out.println("Closing factory or connection");
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
