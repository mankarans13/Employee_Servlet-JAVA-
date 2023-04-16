package servlet.image;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.FileOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import db.connection.db_coonection;

/**
 * Servlet implementation class AddImage
 */
@MultipartConfig 
@WebServlet("/AddImage")
public class upload2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upload2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);

		PrintWriter out = response.getWriter();
        //set Content type
		response.setContentType("text/hmtl");
   
		
        String id = request.getParameter("id");
		
		System.out.println("in do post");
		Part file=request.getPart("image");
		Part file2=request.getPart("resume");
		
		String imageFileName = file.getSubmittedFileName();
		String imageFileName2 = file2.getSubmittedFileName();
		System.out.println("Slected image file name"+imageFileName);
		
		String uploadpath="C:\\Users\\Harkirat Kaur\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\servlet\\src\\main\\webapp\\images\\img\\"+imageFileName;
		String uploadpath2="C:\\Users\\Harkirat Kaur\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\servlet\\src\\main\\webapp\\images\\resume\\"+imageFileName2;
		System.out.println("Upload path:"+ uploadpath);
		System.out.println("Upload path:"+ uploadpath2);
   
             
		try {
			
			FileOutputStream fos=new FileOutputStream(uploadpath);
			
			FileOutputStream fos2=new FileOutputStream(uploadpath2);
			InputStream is=file.getInputStream();
			InputStream is2=file2.getInputStream();
			
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			is2.read(data);
			fos2.write(data);
			fos2.close();
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Connection con=null;
		try {
		 con  =db_coonection.getConnection();
		 
			PreparedStatement stmt;
			String query="insert into image (id,path,resume) values(?,?,?)";
			stmt=con.prepareStatement(query);
			stmt.setString(1, id);
			stmt.setString(2, imageFileName);
			stmt.setString(3, imageFileName2);
			int row=stmt.executeUpdate();
			if(row>0)
			{
				out.println("succesfull upload");
			}
			else {
				out.println(" error");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	

}

	