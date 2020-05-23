package hibernateAnnotationDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import Entity.Student;
import SessionCreation.SessionFactoryCreation;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		SessionFactory factory =SessionFactoryCreation.connect();
		Session session = factory.getCurrentSession();
		try {			
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Gopi", "Nath", "gopi@gmail.com");
			//Student tempStudent1 = new Student("Gopi", "Nath", "gopi@gmail.com");
			//Student tempStudent2 = new Student("Gopal", "Shastri", "gopal@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the student...");
			session.saveOrUpdate(tempStudent);
			//session.save(tempStudent);
			//session.saveOrUpdate(tempStudent1);
			//session.save(tempStudent2);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
