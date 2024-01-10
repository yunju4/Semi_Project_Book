<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.admin.notice.model.vo.Notice" %>
<%
	Notice n = (Notice)request.getAttribute("n");
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
</head>
<body>
	
	<%@ include file="../../common/main_top.jsp" %>
	
	 <header class="py-5">
            <div class="container px-lg-5">
                <div class="text-center">
                    <h1>공지사항</h1>
                </div>
                
                
                <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
                    <table id="table" class="table">
                        <tr>
                            <th width="100">제목</th>
                            <td width="350" colspan="3"><%= n.getNoticeTitle() %></td>
                        </tr>
                        <tr>
                            <th>작성자</th>
                            <td style="text-align:left"><%= n.getNoticeWriter() %></td>
                            <th>작성일</th>
                            <td style="text-align:left"><%= n.getCreateDate() %></td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td colspan="3">
                                <p style="height:150px; text-align:left;">
                                    <%= n.getNoticeContent() %>
                                </p>
                            </td>
                        </tr>
                        
                    </table>
                    <div align="center">
                        <a class="btn btn-secondary btn-sm nlist">목록가기</a>
                    </div>
                </div>
                
                <script>
                	$(function() {
                		$(".nlist").click(function() {
                			location.href = "<%= request.getContextPath() %>/noticeList.ad"
                		})
                	})
                </script>

                
            </div>

            <!-- 
            <a href="####"><button class="btn btn-secondary" style="margin-left:12%">
                계속 쇼핑하기
            </button></a>
             -->
        </header>
	
	<%@ include file="../../common/admin_end.jsp" %>
</body>
</html>