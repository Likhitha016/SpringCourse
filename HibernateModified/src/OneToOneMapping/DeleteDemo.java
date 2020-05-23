package OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Instructor;
import Entity.InstructorDetail;
import SessionCreation.SessionFactoryCreation;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory =SessionFactoryCreation.connect();		
		Session session = factory.getCurrentSession();
		try {			
			session.beginTransaction();
			int theId = 1;
			Instructor tempInstructor = 
					session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: " + tempInstructor);
			if (tempInstructor != null) {
			
				System.out.println("Deleting: " + tempInstructor);
				session.delete(tempInstructor);				
			}
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}