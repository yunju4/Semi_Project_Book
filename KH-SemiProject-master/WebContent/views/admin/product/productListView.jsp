<%@page import="com.kh.admin.product.model.vo.BookMaster"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<BookMaster> list = (ArrayList<BookMaster>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.list-body tr:hover {
		cursor : pointer;
	}
</style>
</head>
<body>
	<%@ include file="../../common/admin_top.jsp" %>
	<main>
	    <div class="container-fluid px-4 text-center" style="width:1500px">
	        <h1 class="mt-4">상품 조회</h1>
	        <div class="breadcrumb mb-4">
	        </div>
	        <div class="card mb-4">
	            <div class="card-header">
	                <i class="fas fa-table me-1"></i>
	                	상품 목록
	            </div>
	            <div class="card-body">
	                <table id="datatablesSimple" class="list-body">
	                    <thead>
	                        <tr>
	                            <th>책제목</th>
	                            <th>작가명</th>
	                            <th>출판사</th>
	                            <th>출간일</th>
	                            <th>가격</th>
	                            <th>재고</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    	<!-- 조회글 출력 : 조회글이 있는지 없는지 isEmpty() 이용 -->
	                        <% if(list.isEmpty()) { %>
	                        	<tr>
	                        		<td colspan="6">조회된 리스트가 없습니다.</td>
	                        	</tr>
	                        <% } else { %>
	                        	<!-- 반복 : list 에 있는 값을 순차적으로 뽑아오기 -->
	                        	
	                        	<% int cnt = 1;
	                        	for(BookMaster bm : list) { %>
	                        		<tr data-bookNo ="<%= bm.getBookNo()%>" onclick="thClick(<%= bm.getBookNo()%>);">
	                        			<td><%= bm.getTitle() %></td>
	                        			<td><%= bm.getAuthor() %></td>
	                        			<td><%= bm.getPublisher() %></td>
	                        			<td><%= bm.getPblctDate() %></td>
	                        			<td><%= bm.getPrice() %>원</td>
	                        			<td><%= bm.getStock() %>권</td>
	                        		</tr>
	                        	<%cnt++; } %>
	                        <% } %>
	                    </tbody>
	                </table>

					<script>
						function thClick(bno){
							location.href = "<%= contextPath %>/productDetail.ad?bno=" + bno;
						}
						
					</script>
	            </div>
	        </div>
	    </div>
	</main>
<%@ include file="../../common/admin_end.jsp" %>
</body>
</html>