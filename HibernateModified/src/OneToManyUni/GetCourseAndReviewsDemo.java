package OneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import Entity.Student;
import SessionCreation.SessionFactoryCreation;

public class GetCourseAndReviewsDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory =SessionFactoryCreation.connect();
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			int theId = 7;
			Course tempCourse = session.get(Course.class, theId);
			System.out.println(tempCourse);
			// print the course reviews
			System.out.println(tempCourse.getReviews());
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			
			factory.close();
		}
	}
}
