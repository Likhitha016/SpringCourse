package EagerVsLazyDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import SessionCreation.SessionFactoryCreation;

public class EagerLazyDemo {

	public static void main(String[] args) {

		SessionFactory factory =SessionFactoryCreation.connect();
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);		
			
			System.out.println("Instructor: " + tempInstructor);
		
			System.out.println("Courses: " + tempInstructor.getCourses());
			session.getTransaction().commit();
			session.close();
			System.out.println("\nThe session is now closed!\n");
			// option 1: call getter method while session is open
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			
			factory.close();
		}
	}
}
