package OneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import SessionCreation.SessionFactoryCreation;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory =SessionFactoryCreation.connect();
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			Course tempCourse = new Course("Pacman");
			// add some reviews
			tempCourse.addReview(new Review("Great course ... loved it!"));
			tempCourse.addReview(new Review("Cool course, job well done"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}
