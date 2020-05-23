package hibernateAnnotationDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;

import com.sun.istack.logging.Logger;

import Entity.Student;
import SessionCreation.SessionFactoryCreation;

public class StudentDemo {

	public static void main(String[] args) {
		SessionFactory factory =SessionFactoryCreation.connect();
		Session session = factory.getCurrentSession();
		try {	
			
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("sravan", "kumar", "sravan@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the student...");
			session.save(tempStudent);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
