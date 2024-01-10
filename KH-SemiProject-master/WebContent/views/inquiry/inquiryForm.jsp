<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.inquiry.model.vo.Inquiry, com.kh.common.model.vo.PageInfo"%>
<%
	
	
	ArrayList<Inquiry> list = (ArrayList<Inquiry>)request.getAttribute("list");
	
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	// 페이징바 만들때 필요한 변수 미리 셋팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>1대1문의</title>
<style>
   
    .list-area{
        border: 1px solid white;
        text-align:center;
    }
    .list-area>tbody>tr:hover{
        background: gray;
        cursor:pointer;
    }
</style>
</head>
<body>
 <%@ include file="../common/main_top.jsp" %>

 <%@ include file="../common/mypage.jsp" %>

<div class="container">
	<div class="row justify-content-center">
		<div class="col-lg-11">
    		<div class="card border-1 rounded-lg mt-5">
        		<div class="card-header"><h4 class="text-center font-weight-light my-1">1대1 문의</h4></div>
        	<div class="card-body">
				<div class="card-header"><h5 class="text-center font-weight-light my-1">1대1 문의 작성 </h5></div>
                <div class="card-body">
                    <form id="enroll-form" action="<%= contextPath %>/insert.in" method="post" >
                    	<input name="userNo" type="hidden" value=<%=loginUser.getUserNo() %>>
                        <div class="row mb-3">
                            <div class="col-md-3">
                                <div class="form-floating">
                                    <h3>분류</h3>
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="form-floating mb-3 mb-md-0">
                                    <select id="select_Q" name="select_Q">
                                        <option value="del">배송문의</option>
                                        <option value="pay">결제문의</option>
                                        <option value="etc">기타</option>
                                        <option selected>--선택--</option>
                                    </select>
                            
                                </div>
                            </div>
                            
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-3">
                                <div class="form-floating">
                                    <h3>제목</h3>
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="form-floating mb-3 mb-md-0">
                                    <input class="form-control" name="title" type="text"  />
                                    <label for="tag-content"></label>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-3">
                                <div class="form-floating">
                                    <h3>이메일</h3>
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="form-floating mb-3 mb-md-0">
                                    <input class="form-control" name="in_email" type="email"  />
                                    <label for="tag-content"></label>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-6">
                            <div class="col-md-3">
                                <div class="form-floating">
                                    <h3>문의내용</h3>
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="form-floating mb-3 mb-md-0">
                                    <textarea class="form-control"  id ="content" name="content" style="resize:none; height:500px;"></textarea>
                                    </div>
                                </div>
                            </div>

                            <div class="mt-4 mb-0">
                                <div class="d-grid"><button class="btn btn-dark btn-block" type="submit" onclick="return checkInput()">등록</button></div>
                            </div>
                        </form>
                    </div>
<!-- 문의내욕 -->
                    <div class="card-header"><h5 class="text-center font-weight-light my-1">문의 내역</h5></div>
                    <div class="card-body">
                        <div class="row mb-3">
                            <table  align="center" class="list-area" >
                            	<thead>
	                                <tr>
	                                    <th width="50">번호</th>
	                                    <th width="300">제목</th>
	                                    <th width="100">답변 유무 </th>
	                                    <th width="100">작성일 </th>
	                                </tr>
                                </thead>
                                <tbody>
                                	  <% if(list.isEmpty()) { %> <!-- 조회글 없음 -->
						               	<tr>
						               		<td colspan="4">조회된 리스트가 없습니다.</td>
						               	</tr>
						               <% } else { %>
						                	<!-- 반복 : list 에 있는 값을 순차적으로 접근해서 뽑아오기 -->
						                	<% for(Inquiry i : list) { %>
						                		<tr>
						             				
													<td><%= i.getInquirySeq() %></td>
													<td><%= i.getInquiryTitle() %></td>
													<td><%= i.getAnswerStatus() %></td>
													<td><%= i.getInquiryDate() %></td>
						                		</tr>
						                	<% } %>
						                <% } %>
                                </tbody>
                            </table>
                        </div>  
                    </div>
             <div align="center" class="paging-area">
        
        	
        	<% if(currentPage != 1) { %>
        		<button class="btn btn-dark btn-block" onclick="location.href='<%= contextPath %>/inquiryForm.in?currentPage=<%= currentPage - 1 %>'">&lt;</button>
        	<% } %>
        
        
            <% for(int i = startPage; i <= endPage; i++) { %>
            	
            	<% if(i != currentPage) { %>
            		<button class="btn btn-dark btn-block" onclick="location.href='<%= contextPath %>/inquiryForm.in?currentPage=<%= i %>'"><%= i %></button>
            	<% } else { %>
            	
            		<button  class="btn btn-dark btn-block" disabled><%= i %></button>
            	<% } %>
            <% } %>
            
           
            <% if(currentPage != maxPage) { %>
            	<button  class="btn btn-dark btn-block" onclick="location.href='<%= contextPath %>/inquiryForm.in?currentPage=<%= currentPage + 1 %>'">&gt;</button>
            <% } %>
            
        </div>
            </div>
        </div>
    </div>
     </div>
</div>
<script>
        	$(function() {
        		
        		$(".list-area>tbody>tr").click(function() {
        			
        			
        			var inNo = $(this).children().eq(0).text(); 
        			
        	
        			
        			location.href="<%= contextPath %>/detail.in?inNo=" + inNo;
        			
        		});
        	});
</script>
<%@ include file="../common/main_end.jsp" %>
</body>
</html>