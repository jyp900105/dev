<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is !!!</P>

${msg }<br>


<a href = "moveLogin">Login</a><br><br>
<a href = "moveRegUser">Join Us</a>
</body>
</html>
