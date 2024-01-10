<%@page import="com.kh.admin.product.model.vo.Attachment"%>
<%@page import="com.kh.admin.product.model.vo.BookMaster"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BookMaster p = (BookMaster)request.getAttribute("p");

	Attachment at = (Attachment)request.getAttribute("at");

	int bookNo = (int)request.getAttribute("bookNo");
	
	String review = (String)request.getAttribute("review");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../../common/main_top.jsp" %>
	<div class="container mt-5">
            <div align="center">
                <div class="col-lg-8">
                    <!-- content-->
                    <article>
                        <!-- page header-->
                        <header>
                            <!-- Post title-->
                            <h1 class="fw-bolder mb-1"><%= p.getBookTitle() %></h1>
                            <!-- Post meta content-->
                            <div class="text-muted "><%= p.getAuthor() %> |  <%= p.getPublisher() %>  | <%= p.getPblctDate() %> </div>
                            <!-- Post categories-->
                            <span class="badge bg-secondary text-decoration-none link-light">#<%= p.getTag1() %></span>
                            <span class="badge bg-secondary text-decoration-none link-light">#<%= p.getTag2() %></span>
                        </header>
                        <!-- Page content-->
                        <section>
                            <div class="px-4 px-lg-5 my-5">
                                <div class="row gx-4 gx-lg-5 align-items-center">
                                    <div class="col-md-6"><img class="card-img-top" style="width: 80%;" src="<%= contextPath %>/<%= at.getFilePath() + at.getChangeName() %>"></div>
                                    <div class="col-md-6">
                                        <h2 class="fw-bolder"><%= p.getTitle() %></h2>
                                        <div class="fs-5 mb-1" style="color: red;">30% 할인 ↓</div>
                                        <h3 class="fw-bolder mb-5">판매가 : <%= p.getPrice() %> 원</h3>
                                        <div class="d-flex" align="center" style="margin-left: 70px;">
                                        	<form action="<%= contextPath %>/addBasket.ba?bno=<%= bookNo %>" method="post">
                                            <table>
                                                 <tr>
                                                    <td>
                                                        <input class="form-control text-center me-3" id="inputQuantity" type="number" value="1" style="max-width: 4rem" name="count">
                                                    </td>
                                                    <td>
                                                       <button class="btn btn-outline-dark flex-shrink-0" type="submit">
                                                            <i class="bi-cart-fill me-1"></i>
                                                            Add to cart
                                                        </button>
                                                    </td>
                                                 </tr>
                                              </table>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <!-- Post content-->
                        <section class="mb-5" align="left">
                            <h2 class="fw-bolder mb-4"><%= p.getBookHead() %></h2>
                            <p class="fs-5 mb-3"><%= p.getBookContent() %></p>
                            <h2 class="fw-bolder mb-4 mt-5">저자소개</h2>
                            <p class="fs-5 mb-4"><%= p.getAuthorInfo() %></p>
                        
                        </section>
                    </article>
                    <!-- Comments section-->
                    <section class="mb-5">
                        <div class="card bg-light">
                            <div class="card-body">
                                <!-- Comment form-->
                                <div>
                                <p style="color:red;">로그인 시에만 작성이 가능합니다.</p>
                                <table width = "100%" height = "100%">
                                <tr>
                                	<td align="center" width = "80%" height="100%"><textarea id="scrollbottom" style="width: 100%; resize: none; display:inline-block" class="form-control" rows="3" placeholder="이 책에 대한 당신의 감상을 남기세요!"></textarea></td>
                                	<td align="center"   width = "20%"  height = "100%"><button class="btn btn-dark" style="display:inline=block; width:100%; height:100%" type="button" onclick="insertComment();">등록</button></td>
                                </tr>	
                                </table>
                                </div>
                                <!-- Comment with nested comments-->
                                <div id = "commentList">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
	<%@ include file="../../common/main_end.jsp" %>
<script type="text/javascript">
<%if(review != null) {%>
//포커스 이동
$('#scrollbottom').focus();
<% } %>

function commentList(){
	var obj = {};
	obj.bookNo = <%=bookNo%>;
	$.ajax ({
		url : "clist.co",
		data : obj,
		success : function(list) {
			var result = "";
        
			for(var i in list) { // for in
				result += '<div class="d-flex">'
		                      + '<div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>'
		                      + '<div class="ms-3">'
		                      + '<div class="fw-bold" align="left">' +list[i].userNo +'</div>'
		                      + list[i].cment 
                              + '</div>'
                              + '</div>';
			}
			$("#commentList").html(result);
		},
		
		error : function() {
			console.log("검색결과용 ajax 실패");
		}
	});
}

function insertComment(){

	var obj = {};
	obj.bookNo = <%=bookNo%>;
	obj.cment = $('#scrollbottom').val();
	$.ajax ({
		url : "insertcomment.co",
		data : obj,
		success : function(result) {
			$('#scrollbottom').val("");
			if(result == 0){
				alert("로그인 시에만 작성이 가능합니다.");
			}
			else if(result == -1){
				alert("해당 도서 구매자만 댓글 작성이 가능합니다.");
			}
			else{
				commentList();	
			}
		},
		error : function() {
			console.log("검색결과용 ajax 실패");
		}
});
}

commentList();
</script>
</body>
</html>