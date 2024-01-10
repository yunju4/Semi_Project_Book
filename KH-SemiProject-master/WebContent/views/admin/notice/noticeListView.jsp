<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.admin.notice.model.vo.Notice" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list"); 
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
    .notice:hover {
        cursor : pointer;
        background : lightyellow;
    }
</style>

</head>
<body>

	<%@ include file="../../common/main_top.jsp" %>

	 <header class="py-5">
            <div class="container px-lg-5">
                <div class="text-center">
                    <h1>공지사항</h1>
                </div>
                
                
                <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
                    <table id="table" class="table text-center">
                        <tr>
                            <th style="width:16%;">NO.</th>
                            <th style="width:40%;">공지사항</th>
                            <th>작성자</th>
                            <th>조회수</th>
                            <th>작성일</th>
                        </tr>
                        
                        <% if(list.isEmpty()) { %>
                        	<tr>
		                		<td colspan="5">존재하는 공지사항이 없습니다.</td>
		                	</tr>
                        <% } else { %>
	                        <% for(Notice n : list) { %>
	                        	<tr class="notice">
		                            <td><%= n.getNoticeNO() %></td>
		                            <td><%= n.getNoticeTitle() %></td>
		                            <td><%= n.getNoticeWriter() %></td>
		                            <td><%= n.getCount() %></td>
		                            <td><%= n.getCreateDate() %></td>
		                        </tr>
	                        <% } %>
                        <% } %>
                    </table>
                    <button type="button" class="btn btn-secondary" onclick="goMain();">뒤로가기</button>
                    
                    <script>
                    	$(function() {
                            $(".notice").click(function() {
                                var nno = $(this).children().eq(0).text();
                                
                                location.href="<%= request.getContextPath() %>/noticeDetail.ad?nno=" + nno;
                            })
                        });
                    	
                    	function goMain() {
                    		$(this).click(function() {
                    			location.href="<%= request.getContextPath() %>/main.mi"
                    		})
                    	}                    
                    </script>
                </div>
            </div>
        </header>
        
        <%@ include file="../../common/main_end.jsp" %>

</body>
</html>