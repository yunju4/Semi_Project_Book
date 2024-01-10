<%@page import="com.kh.admin.product.model.vo.Attachment"%>
<%@page import="com.kh.admin.product.model.vo.BookMaster"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	BookMaster p = (BookMaster)request.getAttribute("p");
	// BookMaster 객체 중 saleCount랑 statu 제외한 모든 필드
	Attachment at = (Attachment)request.getAttribute("at");
	// 첨부파일번호, 원본명, 수정명, 저장경로 데려왔음 (업데이트에 사용되므로)
	int bookNo = (int)request.getAttribute("bookNo");
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
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-11">
                    <div class="card border-1 rounded-lg mt-5">
                        <div class="card-header"><h4 class="text-center font-weight-light my-1">도서정보수정 및 삭제</h4></div>
                        <div class="card-body">
                            <form id="enroll-form" action="<%= contextPath%>/productUpdate.ad" method="post" enctype="multipart/form-data">
                                <input type="hidden" name="bookNo" value="<%= p.getBookNo()%>">
                                <div class="form-floating mb-3">
                                    <input class="form-control" name="bookTitle" type="text" value="<%= p.getBookTitle() %>" placeholder="제일 상단 머릿말" />
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="author" type="text" value="<%= p.getAuthor() %>" placeholder="작가명" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating"> 
                                            <select name="bookCode" style="height: 57px; width: 100%; border:1px solid #ced4da; border-radius: 0.25rem;">
                                                <option value="1"<% if(p.getBookCode()==1) { %> selected="selected" <% } %> >소설</option>
                                                <option value="2"<% if(p.getBookCode()==2) { %> selected="selected" <% } %> >에세이</option>
                                                <option value="3"<% if(p.getBookCode()==3) { %> selected="selected" <% } %> > 역사</option>
                                                <option value="4"<% if(p.getBookCode()==4) { %> selected="selected" <% } %> >과학</option>
                                                <option value="5"<% if(p.getBookCode()==5) { %> selected="selected" <% } %> >정치</option>
                                                <option value="6"<% if(p.getBookCode()==6) { %> selected="selected" <% } %> >로맨틱</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="publisher" type="text" value="<%= p.getPublisher() %>" placeholder="출판사" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <input class="form-control" name="pblctDate" type="text" value="<%= p.getPblctDate() %>" placeholder="출간일" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="tagContent1" type="text" value="<%= p.getTag1() %>" placeholder="태그1" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <input class="form-control" name="tagContent2" type="text" value="<%= p.getTag2() %>" placeholder="태그2" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="title" type="text" value="<%= p.getTitle() %>" placeholder="책제목" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <input class="form-control" name="price" type="number" value="<%= p.getPrice() %>" placeholder="가격" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-floating mb-3">
                                    <input class="form-control" name="bookHead" type="text" value="<%= p.getBookHead() %>" placeholder="내용 중 첫번째 머리말" />
                                </div>
                                <div class="form-floating mb-3">
                                    <textarea class="form-control" name="bookContent" type="textarea" placeholder="내용 중 첫번째 머리말"><%= p.getBookContent() %></textarea>
                                </div>
                                <div class="form-floating mb-3">
                                    <textarea class="form-control" name="authorInfo" type="textarea" placeholder="저자 소개 부분 내용"><%= p.getAuthorInfo() %></textarea>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="stock" type="number" value="<%= p.getStock() %>" placeholder="재고" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="btn btn-dark btn-block" name="upfile" type="file" style="margin-top: 10px;" value=""><%= at.getChangeName() %></input>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                <div class="mt-4 mb-0">
                                    <div class="d-grid"><button class="btn btn-dark btn-block" type="submit">가랏! 정보수정!</button></div><br>
                                    <div class="d-grid"><button class="btn btn-warning btn-block" onclick="deleteClick();" type="button">가랏! 도서삭제!</button></div>
                                </div>
                                </div>
                            </form>
                            <script>
								function deleteClick(){
									location.href = "<%= contextPath %>/productDelete.ad?bookNo=<%= bookNo %>";
								}
							</script>  
                        </div> 
                    </div>
                </div>
            </div>
        </div>
    </main>
    <%@ include file="../../common/admin_end.jsp" %>
</body>
</html>