package hibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateAnnotationDemo.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {			
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Raj", "kapoor", "raj@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the student...");
			session.save(tempStudent);
			session.getTransaction().commit();
			//retrieving the objects
			System.out.println("Primary key of generated is :"+tempStudent.getId());
			session =factory.getCurrentSession();
			session.beginTransaction();
			Student s=session.get(Student.class, tempStudent.getId());
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
