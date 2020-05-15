package OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {	
			Instructor tempInstructor = new Instructor("Joe", "Darby", "Joe@gmail.com");
			InstructorDetail tempInstructorDetail =new InstructorDetail("http://www.joeofficial.com/youtube",
							"Singing!!!");	
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			System.out.println("Saving instructor: " + tempInstructor);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
