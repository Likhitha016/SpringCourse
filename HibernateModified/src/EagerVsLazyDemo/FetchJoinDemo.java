package EagerVsLazyDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			
			// option 2: Hibernate query with HQL
			int theId = 1;

			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
									+ "JOIN FETCH i.courses "
									+ "where i.id=:theInstructorId", 
							Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", theId);
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("luv2code: Instructor: " + tempInstructor);	
			session.getTransaction().commit();
			session.close();
			System.out.println("\nThe session is now closed!\n");
			System.out.println("Courses: " + tempInstructor.getCourses());
			System.out.println("Done!");
		}
		finally {
			session.close();
			
			factory.close();
		}
	}
}