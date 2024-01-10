<%@page import="com.kh.admin.product.model.vo.BookMaster"%>

<%@page import="com.kh.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../common/admin_top.jsp" %>
           <main>
               <div class="container-fluid px-4 text-center" style="width:1500px;">
                   <h1 class="mt-4">회원제재 및 탈퇴</h1>
                   <ol class="breadcrumb mb-4">
                   </ol>
                   <div class="card mb-4">
                       <div class="card-header">
                           <i class="fas fa-table me-1"></i>
                           회원 목록
                       </div>
                       <div class="card-body">
                           <table id="datatablesSimple">
                               <thead>
                                   <!-- 세로 가운데정렬을 위해 head 부분에서 스타일 부여 -->
                                   <tr>
                                       <th>아이디</th>
                                       <th>비밀번호</th>
                                       <th>이메일</th>
                                       <th>주소</th>
                                       <th>전화번호</th>
                                       <th>회원제재</th>
                                   </tr>
                               </thead>
                               <!-- <tfoot>
                                   <tr>
                                       <th></th>
                                       <th>Position</th>
                                       <th>Office</th>
                                       <th>Age</th>
                                       <th>Start date</th>
                                       <th>Salary</th>
                                   </tr>
                               </tfoot> -->
                               <tbody>
                               <!-- 조회글 출력 : 조회글이 있는지 없는지 isEmpty() 이용 -->
	                        <% if(list.isEmpty()) { %>
	                        	<tr>
	                        		<td colspan="6">조회된 리스트가 없습니다.</td>
	                        	</tr>
	                        <% } else { %>
	                        	<!-- 반복 : list 에 있는 값을 순차적으로 뽑아오기 -->
	                        	
	                        	<% int cnt = 1;
	                        	for(Member m : list) { %>
	                        		<tr>
	                        			<td><%= m.getUserId() %></td>
	                        			<td><%= m.getUserPwd() %></td>
	                        			<td><%= m.getEmail() %></td>
	                        			<td><%= m.getAddress() %></td>
	                        			<td><%= m.getPhone() %></td>
	                        			<td>
	                        				<% if(m.getStatus().equals("Y")) { %>
												<a href="<%= request.getContextPath() %>/delMember.ad?userId=<%= m.getUserId() %>" class="btn btn-danger delete" style="padding-top:0px; padding-bottom:0px;">
				                                   	 삭제
				                                </a>
			                                <% } else { %>
			                                	<a href="<%= request.getContextPath() %>/backMember.ad?userId=<%= m.getUserId() %>" class="btn btn-danger delete" style="padding-top:0px; padding-bottom:0px;">
				                                	계정 복구
				                                </a>
			                                <% } %>
										</td>
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
                                  
                               </tbody>
                           </table>
                       </div>
                   </div>
               </div>
           </main>
 <%@ include file="../../common/admin_end.jsp" %>
</body>
</html>