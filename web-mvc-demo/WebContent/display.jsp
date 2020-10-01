<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Users: ${listKey}</p>

<h3>We are using JSTL</h3><hr />
	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "core" %>
	<ol>
		<core:forEach items="${listKey}" var="u">
			<li>Id = ${u.userId}, Name = ${u.name}, Phone = ${u.phone}</li>
		</core:forEach>
	</ol>
</body>
</html>