package hibernateCRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateAnnotationDemo.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {			
			
			session.beginTransaction();
			//querying
			List<Student> theStudents = session.createQuery("from Student").list();
		
			theStudents = session.createQuery("from Student s where s.lastName='Kumar'").getResultList();
			System.out.println("\n\nStudents who have last name of Kumar");
			displayStudents(theStudents);
			theStudents =session.createQuery("from Student s where"+ " s.lastName='Kumar' OR s.firstName='Ravi'").getResultList();
			System.out.println("\n\nStudents who have last name of Kumar OR first name Ravi");
			displayStudents(theStudents);
			theStudents = session.createQuery("from Student s where"+ " s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\n\nStudents whose email ends with gmail.com");			
			displayStudents(theStudents);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student t:theStudents) {
			System.out.println(t);
		}		
	}

}
