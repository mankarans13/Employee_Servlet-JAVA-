package servlet;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.connection.db_coonection;
@WebServlet("/DisplayImage")
public class showImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		String imgId=null;
		String imgfilename=null;
		String n=request.getParameter("id");
		try {
			 con =db_coonection.getConnection();
			 
			java.sql.Statement stmt;
			String query="Select * from image";
			stmt= con.createStatement();
			ResultSet rs=((java.sql.Statement) stmt).executeQuery(query);
			
			while(rs.next())
			{
				if(n==rs.getString("imageId"))
				{
					imgId=rs.getString("imageId");
					imgfilename=rs.getString("img");
					System.out.println(imgId);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd;
		request.setAttribute("id", imgId);
		request.setAttribute("img", imgfilename);
		rd=request.getRequestDispatcher("displayImage.jsp");
		rd.forward(request, response);	
	}
}

