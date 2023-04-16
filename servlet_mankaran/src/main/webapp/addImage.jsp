<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red" align ="center">Add image detail</h1>

<div align="center">

<form action="AddImage" method="post" enctype="multipart/form-data">
<label for="id">Enter ID:e</label>
    <input type="text" name="Id" id="id">
               Select Image:
                <input type="file" name="image">
                select resume
                <input type="file" name="resume">
                <input type="submit" value="upload">
               
                </form> 
                </div>
</body>
</html>