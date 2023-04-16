<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

.table-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

table {
  border-collapse: collapse;
  width: 50%;
}

th, td {
  border: 1px solid black;
  padding: 8px;
  text-align: left;
}

th {
  background-color: #f2f2f2;
}


.vertical-center {
  margin: 40%;
  position: absolute;
  bottom: 10%;
  -ms-transform: translateY(-50%);
  transform: translateY(-50%);
}


</style>
</head>
<body>
<div class="table-container">
  <table>
  <ul>
    <%@ page import="java.util.ArrayList" %>
    <% ArrayList<String> list = (ArrayList<String>) request.getAttribute("userList");
    %>
    
    <tr>
      <th>Employee</th>
      <th>Details</th>
     
    </tr>
    <tr>
      <td>Name</td>
      <td><%= list.get(0) %></td>
    </tr>
    <tr>
      <td>Emp_ID</td>
      <td><%=  list.get(1) %></td>
    </tr>
    <tr>
      <td>Designation</td>
      <td><%= list.get(2) %></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><%= list.get(3)%></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><%=  list.get(4)%></td>
    </tr>
  </ul>
  </table>
</div>


<div class="container">
  <div class="vertical-center">
    <button> Update</button>
     <button>Delete</button>
      <a href="image.jsp"> Upload </a>
     <a href="LoggOut.java">LogOut</a>
       <a href="http://localhost:8080/servlet_mankaran/addImage.jsp">
    <button type="submit">Add image</button>
    </a>
<a href="http://localhost:8080/servlet_mankaran/displayImage.jsp">
    <button type="submit">Display Image</button>
    </a>
  </div>
</div>
</body>
</html>