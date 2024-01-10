<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.basket.model.vo.Basket" %>
<%@page import="com.kh.admin.product.model.vo.Attachment"%>
<%@page import="com.kh.admin.product.model.vo.BookMaster"%>
<%
	ArrayList<Basket> list = (ArrayList<Basket>)request.getAttribute("list");

	ArrayList<Basket> atList = (ArrayList<Basket>)request.getAttribute("atList");

	ArrayList<Attachment> atlist = (ArrayList<Attachment>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> <!-- 온라인 방식 -->
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
    .bookList>td {
        text-align : center;
        vertical-align : middle;
    }
</style>
    
</head>
<body>

	<%@ include file="../common/main_top.jsp"%>

	<%@ include file="../common/mypage.jsp"%>

	<!-- Header-->
	<div class="container">
		<div class="row justify-content-center">
			<div class="container px-lg-5">
				<div class="text-center">
					<h1>장바구니</h1>
				</div>


				<div class="p-4 p-lg-5 bg-light rounded-3 text-center">
					<table id="table" class="table text-center">
						<tr>
							<th style="width: 16%;">책 이미지</th>
							<th>책 제목</th>
							<th>가격</th>
							<th>수량</th>
							<th>소계</th>
							<th>비교</th>
							<!-- <th>주문 여부 선택</th> -->
						</tr>

						<%
							if (list.isEmpty()) {
							;
						%>
						<tr>
							<td colspan="7">조회된 리스트가 없습니다.</td>
						</tr>
						<script>
		                		function(){
		                			$("#buy").attr("disabled",true);
		                		}
		                	</script>
						<%
							} else {
						%>
						<%
							for (Basket b : atList) {
						%>
						<tr class="bookList">
							<td><img class="card-img-top" style="width: 80%;"
								src="<%=request.getContextPath()%>/<%=b.getTitleImg()%>"></td>
							<td class="title"><%=b.getBookTitle()%></td>
							<td class="price"><%=b.getPrice()%></td>
							<td class="count"><%=b.getCount()%></td>
							<td class="priceSum"><%=b.getSumPrice()%></td>
							<td><a
								href="<%=request.getContextPath()%>/delBasket.ba?bano=<%=b.getBasketSeq()%>"
								class="btn btn-danger delete"
								style="padding-top: 0px; padding-bottom: 0px;"> 삭제 </a></td>
							<!-- <td><input type="checkbox" class="check"></td> -->
							<!-- 시간 부족하니 빼자 -->
						</tr>
						<%
							}
						%>
						<tr>
							<td></td>
							<td></td>
							<td>총계</td>
							<td id="allCount"></td>
							<td id="allSum"></td>
							<td>
								<button class="btn btn-danger"
									style="padding-top: 0px; padding-bottom: 0px;"
									onclick="allSum(); allCount();">총계확인</button>
							</td>
						</tr>
						<script>
	                        function(){
	                			$("#buy").attr("disabled",false);
	                		}
		                	</script>
						<%
							}
						%>
					</table>

					<table style="width: 100%;">
						<tr>
							<td><a href="<%=request.getContextPath()%>/main.mi"><button
										class="btn btn-secondary" style="text-align: left;">
										계속 쇼핑하기</button></a></td>
							<td>
								<button id="buy" class="btn btn-success" onclick="buys()">주문하기</button>
							</td>
						</tr>

						<!-- 주문버튼 활성화 유무 -->
						<script>
                        	function buys() {
                        		location.href= "<%=request.getContextPath()%>/basket.pb";
                        	}
                        </script>

					</table>



					<!-- <button id="buy" class="btn btn-outline-success">주문하기</button> -->
				</div>
			</div>

			<!-- 
            <a href="####"><button class="btn btn-secondary" style="margin-left:12%">
                계속 쇼핑하기
            </button></a>
             -->
		</div>
	</div>

	<!-- 장바구니 삭제 및 주문버튼 클릭시 jQuery 시작 -->
        <script>
            function allSum() {
                var table = document.getElementById('table');

                var sum = 0;
                for(var i =1; i < table.rows.length - 1; i++) {
                    sum += parseInt(table.rows[i].cells[4].innerHTML);
                    console.log("sum : " + sum);
                }

                document.getElementById('allSum').innerHTML = parseInt(sum);
            }

            function allCount() {
                var table = document.getElementById('table');

                var sum = 0;
                for(var i =1; i < table.rows.length - 1; i++) {
                    sum += parseInt(table.rows[i].cells[3].innerHTML);
                    console.log("sum : " + sum);
                }

                document.getElementById('allCount').innerHTML = parseInt(sum);
            }

            $(function() {
                $(".delete").click(function() {
                	
                	
                    var clickedRow = $(this).parent().parent();
                    var cls = clickedRow.attr("class");
                 
                    // 각 항목의 첫번째 row를 삭제한 경우 다음 row에 td 하나를 추가해 준다.
                    if( clickedRow.find("td:eq(0)").attr("rowspan") ){
                        if( clickedRow.next().hasClass(cls) ){
                         clickedRow.next().prepend(clickedRow.find("td:eq(0)"));
                        }
                    }
 
                    clickedRow.remove();
 
                    // rowspan 조정
                    resizeRowspan(cls);
                });
            });
        </script>
        <!-- 장바구니 삭제 및 주문버튼 클릭시 jQuery 끝 -->
        
        <script>
        $(function() {
        	<% if(list.isEmpty()) { %>
      			$(function() {
      				$("#buy").attr("disabled", true);
      			});
         	<% } else { %>
	         	$(function() {
					$("#buy").attr("disabled", false);
				});
         	<% } %>
        })
       
        </script>
	
	
	<%@ include file="../common/main_end.jsp" %>

</body>
</html>	

