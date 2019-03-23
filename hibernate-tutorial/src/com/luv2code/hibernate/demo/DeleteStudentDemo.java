package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session object
		Session session = factory.getCurrentSession();

		try {

			int studentId = 4;

			// begin a transaction
			System.out.println("Initiating transaction");
			session.beginTransaction();

			/*
			 * //retrieve student based on the id: primary key Student
			 * myStudent=session.get(Student.class,studentId); session.delete(myStudent);
			 * System.out.println("done");
			 */
			// commit transaction

			session.createQuery("delete from Student s where s.id=1").executeUpdate();
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

}
