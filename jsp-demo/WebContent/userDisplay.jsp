<%@page import="com.hsbc.controller.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Display user details</h3>
	<h4 style="color:blue">Hello ${userKey.username}, phone number is ${userKey.phone} </h4>
	<hr />
</body>
</html>