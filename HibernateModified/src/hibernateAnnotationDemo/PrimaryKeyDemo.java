package hibernateAnnotationDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {			
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Ram", "kumar", "ram@gmail.com");
			Student tempStudent1 = new Student("John", "Doe", "John@gmail.com");
			Student tempStudent2 = new Student("Ravi", "Shastri", "Ravi@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the student...");
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
