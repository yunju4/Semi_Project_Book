<%@page import="com.kh.admin.product.model.vo.Attachment"%>
<%@page import="com.kh.admin.product.model.vo.BookMaster"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ArrayList<BookMaster> bmlist = (ArrayList<BookMaster>)request.getAttribute("bmlist");
	ArrayList<BookMaster> bmNewlist = (ArrayList<BookMaster>)request.getAttribute("bmNewlist");
	String category = (String)request.getAttribute("category");
	String sort = (String)request.getAttribute("sort");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적-메인페이지</title>

</head>
<body>
	<%@ include file="../common/search_head.jsp" %>
		<section class="py-5" style="border-top: 1px solid rgb(199, 196, 196);" id="mainSection">
            <div class="container px-4 px-lg-5 mt-1">
                <div>
                    <span class="fw-bolder display-6">베스트 도서</span>
                    <button class="btn btn-outline-dark mt-auto" style="float: right;" onclick="bookSearch('best','','title');">더보기</button>
                </div>
                <br>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center" style="clear: right;">
                    
                    <% for(int i = 0; i < bmlist.size(); i++) { %>
                        <div class="col mb-5">
                            <div class="card h-100">
                                <!-- Product image-->
                                <a href='<%= contextPath %>/productUserDetail.mi?bno=<%= bmlist.get(i).getBookNo() %>' style="height: 65%;"><img class="card-img-top"  style="height: 100%;" src="<%= contextPath %>/<%= bmlist.get(i).getFilePath() + bmlist.get(i).getChangeName() %>" /></a>
                                <!-- Product details-->
                                <div class="card-body p-4" style="border-top: 1px solid rgb(199, 196, 196);">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder"><%= bmlist.get(i).getTitle() %></h5>
                                        <!-- Product price-->
                                        <div style="color: red;">30% 할인 ↓</div>
                                        <span>할인가 <%= bmlist.get(i).getPrice() %> 원</span>
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center">
                                        <a href='<%= contextPath %>/productUserDetail.mi?bno=<%= bmlist.get(i).getBookNo() %>' class="btn btn-outline-dark mt-auto">자세히보기</a>
                                        <a href='<%= contextPath %>/productUserDetail.mi?bno=<%= bmlist.get(i).getBookNo() %>&review=Y' class="btn btn-outline-dark mt-auto">리뷰보기</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <% } %>
                </div>
            </div>
            <div class="container px-4 px-lg-5 mt-1">
                <div>
                    <span class="fw-bolder display-6">신간 도서</span>
                    <button class="btn btn-outline-dark mt-auto" style="float: right;" onclick="bookSearch('new','','title');">더보기</button>
                </div>
                <br>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <% for(int i = 0; i < bmNewlist.size(); i++) { %>
                        <div class="col mb-5">
                            <div class="card h-100">
                                <!-- Product image-->
                                <a href='<%= contextPath %>/productUserDetail.mi?bno=<%= bmNewlist.get(i).getBookNo() %>' style="height: 65%;"><img class="card-img-top" style="height: 100%;" src="<%= contextPath %>/<%= bmNewlist.get(i).getFilePath() + bmNewlist.get(i).getChangeName() %>" /></a>
                                <!-- Product details-->
                                <div class="card-body p-4" style="border-top: 1px solid rgb(199, 196, 196);">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder"><%= bmNewlist.get(i).getTitle() %></h5>
                                        <!-- Product price-->
                                        <div style="color: red;">30% 할인 ↓</div>
                                        <span>할인가 <%= bmNewlist.get(i).getPrice() %> 원</span>
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center">
                                        <a href='<%= contextPath %>/productUserDetail.mi?bno=<%= bmNewlist.get(i).getBookNo() %>' class="btn btn-outline-dark mt-auto">자세히보기</a>
                                        <a href='<%= contextPath %>/productUserDetail.mi?bno=<%= bmNewlist.get(i).getBookNo() %>&review=Y' class="btn btn-outline-dark mt-auto">리뷰보기</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <% } %>
                </div>
            </div>
            </section>
            <section class="py-5" style="border-top: 1px solid rgb(199, 196, 196);display: none;" id="searchResult" >
	            <header class="py-5">
		            <div class="container px-lg-5">
		                <div class="text-center">
		                    <h3 id="searchType">검색결과</h3>
		                </div>
		                
		                <div>
		                    <button class="btn btn-mini" onclick="bookSearch('','','title');">제목순</button>|<button class="btn btn-mini" onclick="bookSearch('','','dPub');">출간일</button>|<button class="btn btn-mini" onclick="bookSearch('','','lowPrice');">낮은가격</button> |<button class="btn btn-mini" onclick="bookSearch('','','highPrice');">높은가격</button> 
		                </div>
		                <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
		                    <table id="searchTable" class="table text-center" >
		                        <tbody id="searchTbody">
		                        </tbody>
		                    </table>
		                </div>
		            </div>
		        </header>
       		</section>
	<%@ include file="../common/main_end.jsp" %>
<script type="text/javascript">
<%if(category != null) {%>
bookSearch('category',<%=category%>,'title');
<% } %>
</script>
</body>
</html>