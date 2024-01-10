<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errorMsg = (String)request.getAttribute("errorMsg");
	// 오브젝트형이므로 스트링형으로 형변환  시켜줌 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center" style="color:red;"><%= errorMsg %></h1>

</body>
</html>