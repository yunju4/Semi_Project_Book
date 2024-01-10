<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member"%>
<%	
	String contextPath = request.getContextPath(); 
	Member loginUser = (Member)session.getAttribute("loginUser");
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>메인페이지</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="<%=contextPath%>">북적북적</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						href="<%=contextPath%>">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=contextPath%>/PwdForm.me">MyPage</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%= contextPath %>/faqForm.fa">고객센터</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%= contextPath %>/noticeList.ad">공지사항</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">Category</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item"
								href="<%= contextPath %>/main.mi?category=1">소설</a></li>
							<li><a class="dropdown-item"
								href="<%= contextPath %>/main.mi?category=2">에세이</a></li>
							<li><a class="dropdown-item"
								href="<%= contextPath %>/main.mi?category=3">역사</a></li>
							<li><a class="dropdown-item"
								href="<%= contextPath %>/main.mi?category=4">과학</a></li>
							<li><a class="dropdown-item"
								href="<%= contextPath %>/main.mi?category=5">정치</a></li>
							<li><a class="dropdown-item"
								href="<%= contextPath %>/main.mi?category=6">로맨틱</a></li>
						</ul></li>
				</ul>
			</div>
			<form class="d-flex">
				<a href="<%= contextPath %>/list.ba" class="btn btn-outline-light"
					type="submit"> <i class="bi-cart-fill me-1"></i> Cart <span
					class="badge bg-dark text-white ms-1 rounded-pill"></span>
				</a>&nbsp;&nbsp;&nbsp;
				<% if(loginUser == null) { %>
				<!-- 로그인 전 -->

				<button class="btn btn-outline-light" type="button"
					onclick="location.href = '<%= contextPath %>/loginForm.me'">

					Login</button>
				<!-- 로그인 후 -->
				<% } else { %>
				<button class="btn btn-outline-light" type="button"
					onclick="location.href = '<%= contextPath %>/logout.me'">

					Logout</button>
				&nbsp;&nbsp;&nbsp;
				<button style="color: withe;" class="btn btn-outline-light"
					type="button">
					<%=loginUser.getUserName() %>회원님 환영합니다.
				</button>
				<% } %>
			</form>
		</div>
	</nav>
	<!-- Header-->
	<header>
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<div class="container">
					<a href="<%= contextPath %>/main.mi"><img
						src="/semi/resources/logo.png" title="로고"></a>
				</div>
			</div>
		</div>
	</header>
	<!-- 알터 출력용 -->
	<script>
		var msg = "<%= alertMsg %>"; 
		
		if(msg != "null") { 
			alert(msg);
	
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>
</body>
</html>