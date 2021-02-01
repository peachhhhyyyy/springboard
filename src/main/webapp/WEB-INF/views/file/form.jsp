<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>File upload Form</title>
		<style>
			a{text-decoration:none}
		</style>
	</head>
	<body style="text-align:center">

		<h1>File upload Form</h1>
		<form action="/file/upload.do"  method="post" enctype="multipart/form-data">
					이름: <input name="name"><br/>
				파일: <input type='file' name='file'><br/>
			<input type='submit' value="전송">
		</form> 
		
	</body>
</html>