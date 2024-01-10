<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	
	String contextPath = request.getContextPath(); 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
<script>
location.href = "<%= contextPath %>/main.mi"
</script>
 
</body>
</html>