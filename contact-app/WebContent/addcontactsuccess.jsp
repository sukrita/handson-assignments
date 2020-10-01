<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Id: ${contactKey.contactId}, Name : ${contactKey.name}, Phone: ${contactKey.phoneNumber}</p>

<jsp:include page="addcontact.html"></jsp:include>

<a href = "profilesuccess.jsp">Back to Profile</a>

</body>
</html>