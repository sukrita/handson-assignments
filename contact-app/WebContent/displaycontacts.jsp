<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>Contacts: ${listKey}</p>

	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "core" %>
	<ol>
		<core:forEach items="${listKey}" var="contact">
			<li>Id = ${contact.contactId}, Name = ${contact.name}, Phone = ${contact.phoneNumber}</li>
		</core:forEach>
	</ol>

</body>
</html>