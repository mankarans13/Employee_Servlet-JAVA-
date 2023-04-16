package servlet.Details;



	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import db.connection.db_coonection;

	public class details extends HttpServlet {
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>All Employees</title></head>");
	    out.println("<body>");
	    out.println("<center><h1>All Employees</h1>");
	    Connection conn = null;
	    Statement stmt = null;
	    try {
	    	  conn =db_coonection.getConnection();
			 
	      stmt = conn.createStatement();
	      String orderBy = request.getParameter("sort");
	      if ((orderBy == null) || orderBy.equals("")) {
	        orderBy = "SSN";
	      }
	      String orderByDir = request.getParameter("sortdir");
	      if ((orderByDir == null) || orderByDir.equals("")) {
	        orderByDir = "asc";
	      }
	      String query = "SELECT * FROM emp" 
	          + ";";
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) {
	    	  String name = request.getParameter("name");
	          String id = request.getParameter("id");
	          String desg = request.getParameter("desg");
	          String email= request.getParameter("email");
	          String pass= request.getParameter("pass");
	          
	        out.print(name + "::");
	        out.print(id + "::");
	        out.print(desg + "::");
	        out.print(email + "::");
	        out.print(pass+ "::");
	      }
	    } catch (SQLException e) {
	      out.println("An error occured while retrieving " + "all employees: " 
	          + e.toString());
	    } finally {
	      try {
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (SQLException ex) {
	      }
	    }
	    out.println("</center>");
	    out.println("</body>");
	    out.println("</html>");
	    out.close();
	  }
	}