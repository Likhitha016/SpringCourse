package OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import Entity.Student;
import SessionCreation.SessionFactoryCreation;


public class Main {

	public static void main(String[] args) {
		SessionFactory factory =SessionFactoryCreation.connect();
		Session session = factory.getCurrentSession();
		try {
			InstructorDetail tempInstructorDetail =new InstructorDetail("david.com/youtube",
					"Artist");	
			Instructor tempInstructor = new Instructor("john", "Johnson", "david@gmail.com");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
