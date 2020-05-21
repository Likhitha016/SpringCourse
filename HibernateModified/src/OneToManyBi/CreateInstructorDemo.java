package OneToManyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			Instructor tempInstructor = new Instructor("Surender", "Singh", "suri@gmail.com");
			InstructorDetail tempInstructorDetail =new InstructorDetail("weblink.com","Cricket");		
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);					
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}