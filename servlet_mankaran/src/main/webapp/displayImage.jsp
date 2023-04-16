<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red" align="center">Display Image
</h1>
<div align="center">
<form action="DisplayImage" method="get">
Enter Image id:
<input type="text" name="id">
<input type="submit" value="Show">
</form>
</div>
<%
String imgId=(String)request.getAttribute("id");
    String imgfilename=(String)request.getAttribute("img");
    System.out.println(imgfilename);
%>
<div align="center">
<table border="5px" style="width:600px">
<tr>
<th>Image id</th>
<th>Image</th>
</tr>
<%
    if(imgfilename!="" && imgId!="")
    {
%>
<tr>
<td><%=imgId %></td>
<td><img src="images/img/<%=imgfilename%>"></td>
<%
    }
%>
</table>
</div>
</body>
</html>