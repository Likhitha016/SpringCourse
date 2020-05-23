package OneToManyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import SessionCreation.SessionFactoryCreation;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory =SessionFactoryCreation.connect();
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			int theId = 2;
			Instructor tempInstructor = session.get(Instructor.class, theId);		
			Course tempCourse1 = new Course("DBMS");
			Course tempCourse2 = new Course("React");
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}
