<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" com.kh.inquiry.model.vo.Inquiry"%>
<%
	
	Inquiry i = (Inquiry)request.getAttribute("i");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의내역 상세조회</title>
<style>
            .list-area{
             border: 1px solid white;
             text-align:center;
        }
</style>
</head>
<body>
<%@ include file="../../common/admin_top.jsp" %>

	<div class=" container">
                        <div class="row justify-content-center">
                            <div class="col-lg-11">
                                <div class="card border-1 rounded-lg mt-5">
                                    <div class="card-header"><h4 class="text-center font-weight-light my-1">1대1 문의</h4></div>
                                    <div class="card-body">

                            
                                            <div class="card-header"><h5 class="text-center font-weight-light my-1">1대1 문의 상세 </h5></div>
                                            <div class="card-body">
                                            
                                                    <div class="row mb-1 list-area ">
                                                        <div class="col-md-2">
                                                            <div class="form-floating">
                                                                <h5>작성일 :</h5>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                                <h5><%=i.getInquiryDate() %> </h5>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-floating">
                                                                <h5>작성자 :</h5>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                                <h5><%=i.getInquiryClass() %> </h5>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-floating">
                                                                <h5> 답변 여부 </h5>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                                <h5><%= i.getAnswerStatus() %></h5>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <div class="row mb-3 list-area">
                                                        <div class="col-md-3">
                                                            <div class="form-floating">
                                                                <h5>제목</h5>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-8">
                                                            <div class="form-floating mb-3 mb-md-0">
                                                                <h5> <%= i.getInquiryTitle() %></h5>
                                                            </div>
                                                        </div>
                                                      
                                                    </div>
                                                    <hr>
                                                    <div class="row mb-12">
                                                        <div class="col-md-12 list-area ">
                                                            <div class="form-floating">
                                                                <h5>문의내용</h5>
                                                            </div>
        
                                                        </div>
                                                        <hr>
                                                        <div class="col-md-12 list-area ">
                                                            <div class="form-floating mb-3 mb-md-0">
                                                                <textarea readonly cols="62" rows="20" name="message" style="resize:none"><%= i.getInquiryContent() %></textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <% if(!"N".equals(i.getAnswerStatus())) { %>
										              <!--답변이 있을때-->
                                                    	<div class="row mb-12">
                                                        <div class="col-md-12 list-area ">
                                                            <div class="form-floating">
                                                                <h5>답변 내용</h5>
                                                            </div>
        
                                                        </div>
                                                        <hr>
                                                        <div class="col-md-12 list-area ">
                                                            <div class="form-floating mb-3 mb-md-0">
                                                                <textarea readonly cols="62" rows="20" name="message" style="resize:none"><%= i.getAnswer() %></textarea>
                                                            </div>
                                                           
                                                    </div> </div>
                                                    
                                            
                                                    <% }else{ %>
                                                     <div class="card-body">
									                   <form id="enroll-form" action="<%= contextPath %>/Answer.in" method="post" >
									                   	<input name="userNo" type="hidden" value=<%=i.getUserNo() %>>
									                    <input name="title" type="hidden" value=<%=i.getInquiryTitle() %>>
									                    <input name="email" type="hidden" value=<%=i.getInquiryEmail() %>>
									                      <div class="row mb-12">
                                                        <div class="col-md-12 list-area ">
                                                            <div class="form-floating">
                                                                <h5>답변 내용</h5>
                                                            </div>
        
                                                        </div>
                                                        <hr>
                                                        <div class="col-md-12 list-area ">
                                                            <div class="form-floating mb-3 mb-md-0">
                                                                <textarea  cols="62" rows="20" name="message" style="resize:none"></textarea>
                                                            </div>
                                                        </div>
                                                    </div>
									                           <div class="mt-4 mb-0">
									                               <div class="d-grid"><button class="btn btn-dark btn-block" type="submit">답변 등록</button></div>
									                           </div>
									                       </form>
									                   </div>
                                                    <% } %>
											            
                                                        
                                            
                                     
                                              </div>
                                    </div>
                                    
                                  
                                </div>
                            </div>
                        </div>
                    </div>
<%@ include file="../../common/admin_end.jsp" %>

</body>
</html>