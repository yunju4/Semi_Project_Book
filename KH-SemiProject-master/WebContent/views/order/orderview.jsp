<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.ArrayList, com.kh.order.model.vo.Order, java.util.Date"%>

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

.wrap2 {
	width: 80%;
	height: 1000px;
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
	line-height: 35px;
}

#search {
	width: 100%;
}
</style>
</head>

<body>
	<%@ include file="../common/main_top.jsp"%>
	<%@ include file="../common/mypage.jsp"%>
	
	<div class="wrap2">

		<div id="content">

			<h5>
				<b><br>주문/배송조회</b>
			</h5>

			<p style="color: gray; font-size: 12px;">
				- 주문 내역을 확인할 수 있습니다.<br> 
				- 주문한지 30일이 경과되면 자동으로 주문확정이 되며 반품은 불가합니다.
			</p>



			<div class="input-group mb-3">
				<input type="text" class="form-control" id="keyword"
					placeholder="주문한 책의 제목으로 검색할 수 있어요!">
				<div class="input-group-append">
					<button class="btn btn-dark" type="button"
						onclick="searchOrderList();">검색</button>
				</div>
			</div>


			<table id="order-table" class="table">
				<thead style="background-color : lightgray;">
					<tr align="center">
						<th width="150">주문일자</th>
						<th width="200">책제목</th>
						<th width="150">가격</th>
						<th width="150">수량</th>
						<th width="50">소계</th>
						<th width="150">진행여부</th>
						<th width="150">취소/반품</th>
					</tr>
				</thead>
				<tbody id="order-body">


					<!-- 리스트가 비었는지 차있는지 -->
					<%
						if (list.isEmpty()) {
					%>
					<tr>
						<td colspan="7">주문목록이 없습니다.</td>
					</tr>
					<%
						} else {
					%>

					<!--  향상된 for 문 -->
					<%
						for (Order o : list) {
					%>
					<tr>
						<input type="hidden" value="<%=o.getOrderNo()%>">
						<input type="hidden" value="<%=o.getStatus()%>">
						<input type="hidden" value="<%=o.getBookNo()%>">						
						<td><%=o.getOrderDate()%></td>
						<td><%=o.getBookTitle()%></td>
						<td><%=o.getPrice()%></td>
						<td><%=o.getCount()%></td>
						<td><%=o.getMultiply()%></td>
						<td>
							<%
								if (o.getStatus() == 0) {
							%> 배송중<%
								} else {
							%> 배송완료 <%
								}
							%>


						</td>
						<td>
							<%
								if (o.getStatus() == 0) {
							%>
							<button type="button" class="btn btn-sm btn-dark">취소하기</button>
							<%
								} else if (o.getConfirmation() == 0){
							%>
							<button type="button" class="btn btn-sm btn-dark">반품하기</button>
							<%
								} else {
							%> <b>주문확정 </b><%
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

					<script>
					
						$(function() {

							$("#order-body").on("click","button",function() {

										var ono = $(this).parent().siblings().eq(0).val();
										var status = $(this).parent().siblings().eq(1).val();
										var bookNo =  $(this).parent().siblings().eq(2).val();
										var count = $(this).parent().siblings().eq(6).text();		
										alert("취소 / 반품이 완료되었습니다.");
								
										location.href = "cancel.me?ono=" + ono 
												+"&bookNo=" + bookNo
												+ "&status=" + status
												+ "&count=" + count;
										
									});

						});
						
					</script>


					<script>
						function searchOrderList() {

							$.ajax({
										url : "search.od",
										data : {
											keyword : $("#keyword").val(),
					

										},
										success : function(list) {

											alert("검색을 완료했습니다");

											// 댓글갯수만큼 반복 => 누적(문자열)
											var result = "";

											if (list.length != 0) {
											for ( var i in list) { // for in

												var status = "";

												var btn = "<button type='button' class='btn btn-sm btn-dark'>취소하기</button>";

												var hidden1 = "<input type='hidden' value='" + list[i].orderNo + "'>"
												var hidden2 = "<input type='hidden' value='" + list[i].status + "'>"
												var hidden3 = "<input type='hidden' value='" + list[i].bookNo + "'>"
											

												if (list[i].status == 0) {
													status = "배송중";
												} else if (list[i].confirmation == 0) {

														status = "배송완료";
														btn = "<button type='button' class='btn btn-sm btn-dark'>반품하기</button>";
												} else {

														status = "배송완료";
														btn = "주문확정";
													}
											

												result += "<tr>" + hidden1 + hidden2 + hidden3
												+ "<td>" + list[i].orderDate + "</td>" 
												+ "<td>" + list[i].bookTitle + "</td>" 
												+ "<td>" + list[i].price + "</td>" 
												+ "<td>" + list[i].count + "</td>" 
												+ "<td>" + list[i].multiply + "</td>" 
												+ "<td>" + status + "</td>" 
												+ "<td>" + btn + "</td>" + "</tr>";
											}
											}else {
												
												result = "<tr><td colspan=7>검색된 결과가 없습니다 </td></tr>"
											}
											$("#order-table tbody").html(result);

										},
										error : function() {
											console.log("ajax 실패");
										}
									});

						}
					</script>




				</tbody>
			</table>
		</div>
		<div class="footer"></div>
	</div>

	<%@ include file="../common/admin_end.jsp"%>
</body>

</html>