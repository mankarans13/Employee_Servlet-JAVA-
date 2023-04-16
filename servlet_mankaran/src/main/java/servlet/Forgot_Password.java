package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.connection.db_coonection;
@WebServlet("/update")
public class Forgot_Password extends HttpServlet{

	static Connection con;
	

public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
{
	String name=request.getParameter("name");
String id=request.getParameter("Id");
String password=request.getParameter("pass");

response.setContentType("text/html");
PrintWriter out=response.getWriter();

try
{
	
	 Connection con =db_coonection.getConnection();
	 
PreparedStatement stmt=con.prepareStatement
	("update emp set pass=? where name=? and id=?");
stmt.setString(1, password);
stmt.setString(2, name);
stmt.setString(3, id);

System.out.print(name);
System.out.print(password);
System.out.print(id);


int res=stmt.executeUpdate();
if(res==0)
out.println("<b>You are successfully update</b>");
con.close();
}
catch(Exception e)
{
out.println("<b> failed</b>");
out.println("<b>Error:</b>" +e);
}
}
}
