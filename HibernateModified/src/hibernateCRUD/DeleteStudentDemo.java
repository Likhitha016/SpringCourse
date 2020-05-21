package hibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			int studentId = 1;
			session.beginTransaction();
			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Updating student...");
			myStudent.setFirstName("Karan");
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='fun@org.in'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
