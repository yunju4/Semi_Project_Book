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
 <%@ include file="../../common/admin_top.jsp" %>

<div class="container">
	<div class="row justify-content-center">
		<div class="col-lg-11">
    		<div class="card border-1 rounded-lg mt-5">
        		<div class="card-header"><h4 class="text-center font-weight-light my-1">1대1 문의 관리</h4></div>
        	
                
<!-- 문의내욕 -->
                    <div class="card-header"><h5 class="text-center font-weight-light my-1">문의 내역</h5></div>
                    <div class="card-body">
                        <div class="row mb-3">
                            <table  align="center" class="list-area" >
                            	<thead>
	                                <tr>
	                                    <th width="50">회원번호</th>
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
						             				
													<td><%= i.getUserNo() %></td>
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
        		<button  style="width:5%" class=" btn btn-dark btn-block" onclick="location.href='<%= contextPath %>/inquiryFormAdmin.in?currentPage=<%= currentPage - 1 %>'">&lt;</button>
        	<% } %>
        
        
            <% for(int i = startPage; i <= endPage; i++) { %>
            	
            	<% if(i != currentPage) { %>
            		<button  style="width:5%" class="btn btn-dark btn-block" onclick="location.href='<%= contextPath %>/inquiryFormAdmin.in?currentPage=<%= i %>'"><%= i %></button>
            	<% } else { %>
            	
            		<button  style="width:5%" class="btn btn-dark btn-block" disabled><%= i %></button>
            	<% } %>
            <% } %>
            
           
            <% if(currentPage != maxPage) { %>
            	<button style="width:5%" class="btn btn-dark btn-block" onclick="location.href='<%= contextPath %>/inquiryFormAdmin.in?currentPage=<%= currentPage + 1 %>'">&gt;</button>
            <% } %>
            
        </div>
            </div>
        </div>
    </div>
     </div>
     </div>
      </div>

<script>
        	$(function() {
        		
        		$(".list-area>tbody>tr").click(function() {
        			
        			
        			var userNo = $(this).children().eq(0).text(); 
        			var text = $(this).children().eq(1).text(); 
        			
        	
        			
        			location.href="<%= contextPath %>/DetailVeiw.in?userNo=" + userNo + "&text="+text;
        		
        			
        		});
        	});
</script>
<%@ include file="../../common/admin_end.jsp" %>
</body>
</html>