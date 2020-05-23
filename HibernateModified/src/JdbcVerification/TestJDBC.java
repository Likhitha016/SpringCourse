package JdbcVerification;

import java.sql.*;

import com.sun.istack.logging.Logger;

import hibernateAnnotationDemo.StudentDemo;

public class TestJDBC {
	public static void main(String args[]) {
	
		try {
			Connection cc=null;
			Logger l=Logger.getLogger("sample", TestJDBC.class);
			
			cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate","likhitha","Loukya@1998");
			Statement s=cc.createStatement();
			ResultSet rs=s.executeQuery("select * from Student");
			while(rs.next()) {
				l.info("Creates");
				l.severe("Severe");
			}
			cc.close();
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
	}

}
