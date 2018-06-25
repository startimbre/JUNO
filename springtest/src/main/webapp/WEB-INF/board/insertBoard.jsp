<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write content...</title>
</head>
<body>
<center>
<h1>reading board</h1>
<a href="logout.do">Logout</a>
<hr>
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
<table border="1px">
	<tr>
		<td>subject</td>
		<td>
		<input type="text" name="title">
		</td>
	</tr>
	<tr>
		<td>writer</td>
		<td><input type="text" name="writer"></td>
	</tr>
	
	<tr>
		<td>content</td>
		<td>
		<textarea name="content" cols="30" rows="10"></textarea>
		</td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">upload</td><td align="left">
		<input type="file" name="uploadFile"/></td>
	</tr>
	
	<tr>
		<td>
		<input type="submit" value="new content">
		</td>
		<td>
		<a href="boardList.do">cancel</a>
	</tr>

</table>
<hr>
</form>
</center>
</body>
</html>