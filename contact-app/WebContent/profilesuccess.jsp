<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Welcome to Login Success Page</h3>
<p>Id: ${userKey.profileId}, Name : ${userKey.userName}, Phone: ${userKey.phoneNumber}, Date Of Birth: ${userKey.dateOfBirth}</p>

<a href ="updateprofile.html">Update Profile</a>
/
<a href = "addcontact.html">Add contacts</a>
/
<a href = "displaycontacts.jsp">Display Contacts</a>
/
<a href = "updatecontacts.jsp">Update Contacts</a>
/
 <a href = "index.html">Log Out</a>


</body>
</html>