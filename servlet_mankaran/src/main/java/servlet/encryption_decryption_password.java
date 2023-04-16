package servlet;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class encryption_decryption_password {

	

   
String setpass(String s)
{
	
	 String encryptedpassword = null;  
	    try   
	    {  
	        /* MessageDigest instance for MD5. */  
	        MessageDigest m = MessageDigest.getInstance("MD5");  
	          
	        /* Add plain-text password bytes to digest using MD5 update() method. */  
	        m.update(s.getBytes());  
	          
	        /* Convert the hash value into bytes */   
	        byte[] bytes = m.digest();  
	          
	        /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
	        StringBuilder s1 = new StringBuilder();  
	        for(int i=0; i< bytes.length ;i++)  
	        {  
	            s1.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
	        }  
	          
	        /* Complete hashed password in hexadecimal format */  
	        encryptedpassword = s1.toString();  
	    }   
	    catch (NoSuchAlgorithmException e)   
	    {  
	        e.printStackTrace();  
	    }  
	      
	    /* Display the unencrypted and encrypted passwords. */  
	    System.out.println("Plain-text password: " + s);  
	    System.out.println("Encrypted password using MD5: " + encryptedpassword);
		return encryptedpassword;  
		

} 
}
