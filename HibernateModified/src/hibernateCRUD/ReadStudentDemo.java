package hibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import Entity.Student;
import SessionCreation.SessionFactoryCreation;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory =SessionFactoryCreation.connect();

		Session session = factory.getCurrentSession();
		try {			
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("sammmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm",
					"RuthPrabhu", "samprabu@gmail.com");
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
