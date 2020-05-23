package OneToManyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import SessionCreation.SessionFactoryCreation;
public class DeleteCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory =SessionFactoryCreation.connect();
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			int theId = 1;
			Course tempCourse = session.get(Course.class, theId);
			System.out.println("Deleting course: " + tempCourse);
			session.delete(tempCourse);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}



