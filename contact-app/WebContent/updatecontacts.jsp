<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Update Phone Number</h2>
	<form action = "UpdateContactPhoneServlet" method = "post">
	<label>
			Contact ID <input type = "text" name = "contactIdPhone">
		</label>
		<br />
		<label>
			Phone <input type = "text" name = "phone">
		</label>
		<br />
		<input type = "submit" value = "Update Number">
	</form>
	
	<h2>Update Password</h2>
	<form action = "UpdateContactNameServlet" method = "post">
	<label>
			Contact ID <input type = "text" name = "contactIdName">
		</label>
		<br />

		<label>
			Name <input type = "text" name = "name">
		</label>
		<br />
		<input type = "submit" value = "Update Name">
	</form>


</body>
</html>