<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST" >
		<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" required="true"/></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" required="true" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" required="true" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" onclick="ValidateEmail()"/></td>
					</tr>
				</tbody>
			</table>
		
					<script type="text/javascript">
						ValidateEmail() {
							 alert("entered function");
							String email=request.getParameter("email");
							String driver = "com.mysql.jdbc.Driver";
							String connectionUrl = "jdbc:mysql://localhost:3306/";
							String database = "web_customer_tracker";
							String userid = "springstudent";
							String password = "Student@98";
							Class.forName(driver);
						
						Connection c= DriverManager.getConnection(connectionUrl+database, userid, password);
						Statement s=c.createStatement();
						String sql ="select email from customer";
						ResultSet rs = s.executeQuery(sql);
						while(rs.next()){
							String temp=rs.getString("email");
							if(temp.equals(email)){
								out.println("email already exists");
								//msg.innerHTML="email already exists";
							}
						}
						
					}
					</script> 
					
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>