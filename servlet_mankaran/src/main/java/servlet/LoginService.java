 package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.connection.db_coonection;
@WebServlet("/login")
public class LoginService extends HttpServlet{

	static Connection con;
	static Cipher cipher ;
	
	static String INSERT_QUERY = "SELECT pass FROM emp where email=? and pass=?";
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession();
	    session.setMaxInactiveInterval(10); 
				
        //get PrintWriter
		res.setContentType("text/html");
		
        String n=req.getParameter("email");
		String p = req.getParameter("pass");
		System.out.println(n);
		System.out.println("pass"+p);
		

	   byte[] encrypt= Base64.getEncoder().encode(p.getBytes());
	    String str= new String (encrypt);

	    System.out.println("pass"+"           "+str);
		
		String result=checkPassword(n,str);
		 if(result == "valid")
		 {
			 
			 After_login2 after_Login = new After_login2();
		after_Login.doGet(req, res);
			//out.println("valid");
		 }
		 else if(result == "invalid"){
		out.println("invalid");
		 }
		 out.close();
	}
	protected String checkPassword(String email, String pass)
	{
		String correct=new String();
		try { Connection con =db_coonection.getConnection();
		 
 
  	     PreparedStatement ps = con.prepareStatement(INSERT_QUERY);	
  	     ps.setString(1, email);
  	     ps.setString(2, pass);
  	     System.out.println("password"+pass);
  	     
  	     ResultSet rs = ps.executeQuery();
  	   System.out.println(rs.getFetchSize());
  	     
  	     
  	   while (rs.next()) {
  		   
  		
	         correct = rs.getString(1);
	         System.out.println("correct"+correct);
	      }
  	   
            		      
        } catch (Exception e) {
 
           System.out.println("Connection failed"+e.toString());
        }
		

		if(correct.equals(pass))
		{
			return "valid";
		}
		else {
			return "invalid";
		}
		
		
	}
	
	
}