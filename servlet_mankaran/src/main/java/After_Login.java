import java.io.*; 
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
import java.sql.*;  
import db.connection.db_coonection;
public class After_Login extends HttpServlet  
{    
	static String sql = "SELECT * FROM emp where email=? ";
 public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
  {  
	 PrintWriter out = res.getWriter(); 
     res.setContentType("text/html");  
     
     String m=req.getParameter("email");

     String p = req.getParameter("pass");
		
		
		 try 
	     {  
			 Connection con =db_coonection.getConnection();
			 
	         PreparedStatement ps = con.prepareStatement(sql);	
	  	     ps.setString(1, m);
	  	 //   ps.setString(2, p);
	  	     System.out.println("name"+m);
	  	     out.print("<table width=75% border=1>");
	  	    out.print("<caption>Employee Details : </caption><br/>");
	  	     ResultSet rs = ps.executeQuery(); 
	  	     ResultSetMetaData rsmd=rs.getMetaData();
	  	     int totalColumn = rsmd.getColumnCount();
	  	     out.print("<tr>");
	  	     for(int i=1;i<=totalColumn;i++)
	  	     {
	  	    	 out.print("<th>"+rsmd.getColumnName(i)+"</th>");
	  	     }
	  	     
	  	     out.print("</tr>");
	  	     while(rs.next())
	  	     {
	  	    	 out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>");
	  	     }
	  	   //  out.print("</table>);
	        }  
	         catch (Exception ep) 
	        {  
	        	 System.out.println("Connection failed"+ep.toString()); 
	     }
 }  
 
}