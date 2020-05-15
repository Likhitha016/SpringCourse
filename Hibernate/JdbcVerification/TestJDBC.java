package JdbcVerification;

import java.sql.*;

public class TestJDBC {
	public static void main(String args[]) {
	
		try {
			Connection cc=null;
			cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate","likhitha","Loukya@1998");
			Statement s=cc.createStatement();
			ResultSet rs=s.executeQuery("select * from sample");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			cc.close();
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
	}

}
