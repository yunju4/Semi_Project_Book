<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/style.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> <!-- 온라인 방식 -->
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="assets/demo/chart-area-demo.js"></script>
<script src="assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>

</head>
<body>

	<%@ include file="../../common/admin_top.jsp" %>

	<header class="py-5">
	
	<div class="container">
    	<div class="row justify-content-center">
        	<div class="col-lg-11">
            	<div class="card border-1 rounded-lg mt-5">
                	<div class="card-header"><h4 class="text-center font-weight-light my-1">공지사항 등록</h4></div>
                    <div class="card-body">
                    	<form action="<%= request.getContextPath() %>/noticeInsert.ad" method="post">
                                            
                        	<input type="hidden" name="userNo" value="1">

                            <table class="table text-center" align="center">
	                            <tr>
	                            	<th style="width:20%">제목</th>
	                            	<td style="width:80%"><input type="text" name="title" style="width:100%" required></td>
	                            </tr>
	                            <tr>
	                            	<th>내용</th>
	                                <td>
	                                	<textarea name="content" rows="10" style="resize:none; width:100%;" required></textarea>
	                                </td>
	                            </tr>
                            </table>
                            <br><br>

                            <div align="center">
	                            <button type="submit" class="btn btn-dark">등록하기</button>
	                            <button type="button" class="btn btn-secondary" onclick="history.back();">뒤로가기</button>
	                            
                            </div>

                       </form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>

	<%@ include file="../../common/admin_end.jsp" %>
</body>
</html>