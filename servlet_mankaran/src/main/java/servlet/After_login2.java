package servlet;


	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.*;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.connection.db_coonection;

public class After_login2 extends HttpServlet {
		
		
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
			
		
			
			PrintWriter out = res.getWriter();
			String email=req.getParameter("email");
	        //get PrintWriter
			res.setContentType("text/html");
			// Create a connection to the database
			 Connection con =db_coonection.getConnection();
			 
			// Prepare the SQL query
			PreparedStatement statement;
			try {
				statement = con.prepareStatement("SELECT * FROM emp where email=?");
				// Execute the query and get the result set
			//	String email=req.getParameter("email");
				statement.setString(1, email);
				System.out.print(email);
				ResultSet resultSet = statement.executeQuery();
				List<String> userList = new ArrayList<>();
				while (resultSet.next()) {
				    String[] user = new String[5];
				    userList.add(resultSet.getString("name"));
				    userList.add(resultSet.getString("id"));
				    userList.add(resultSet.getString("email"));
				    userList.add(resultSet.getString("desg"));
				    userList.add(resultSet.getString("pass"));
				    

					// Set the attribute in the request object
					req.setAttribute("userList", userList);
					for(String s:user)
					{
					System.out.println(s);
					}
					// Forward the request to the JSP file
					RequestDispatcher dispatcher = req.getRequestDispatcher("After_Login.jsp");
					dispatcher.forward(req, res);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			


	}

		
		
	}

