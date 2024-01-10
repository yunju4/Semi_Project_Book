<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.order.model.vo.Order"%>

<%
	ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

  
<style>
.table {
	margin: auto;
	
}

div, form {
	box-sizing: border-box;
}

.wrap {
	width: 80%;
	height: 1000px;
	margin: auto;
	display: inline-block;
}

#header {
	height: 5%;
	background: black;
	color: white;
}

#footer {
	height: 10%;
}

#content {
	height: 85%;
}

td {
	text-align: center;
	vertical-align: middle;

</style>
</head>

<body>
	<%@ include file="../common/main_top.jsp"%>
	<%@ include file="../common/mypage.jsp"%>
	<div class="wrap">

		<div id="content">

			<h5>
				<b><br>취소/반품조회</b>
			</h5>
			
				<p style="color: gray; font-size: 12px;">
                    - 취소/반품 신청한 내역을 확인할 수 있습니다.<br>
                    - 하단 목록에 없는 상품은 1:1 문의로 문의주세요.
                </p>

			
			<table id="order-table" class="table">
				<thead style="background-color : lightgray;">
					<tr align="center">
						<th width="150">취소/반품일자</th>
						<th width="200">책제목</th>
						<th width="150">가격</th>
						<th width="150">수량</th>
						<th width="50">소계</th>
						<th width="150">취소/반품</th>
					
					</tr>
				</thead>
				<tbody id="order-body">


					<!-- 리스트가 비었는지 차있는지 -->
					<%
						if (list.isEmpty()) {
					%>
					<tr>
						<td colspan="7">취소/반품 목록이 없습니다.</td>
					</tr>
					<%
						} else {
					%>

					<!--  향상된 for 문 -->
					<%
						for (Order o : list) {
					%>
					<tr>
						
						<td><%=o.getCancelDate()%></td>
						<td><%=o.getBookTitle()%></td>
						<td><%=o.getPrice()%></td>
						<td><%=o.getCount()%></td>
						<td><%=o.getMultiply()%></td>
						<td>
							<%
								if (o.getStatus() == 2) {
							%> 취소완료<%
								} else {
							%> 반품완료 <%
								}
							%>


						</td>
						
					</tr>

					<%
						}
					%>
					<%
						}
					%>

	

				</tbody>
			</table>
		</div>
		<div class="footer"></div>
	</div>
	<%@ include file="../common/admin_end.jsp"%>
</body>

</html>