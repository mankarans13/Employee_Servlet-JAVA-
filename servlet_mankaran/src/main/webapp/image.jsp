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
               
                <input type="file" name="image" value="photo" accept="image/png, image/jpeg">
                <input type="file" name="resume"  accept=" image/pdf">
                <label for="">Id</label>
<input type="text" name="id" class="form-control" required>
                <input type="submit" value="Add Image">
               
                </form> 
                </div>
</body>
</html>