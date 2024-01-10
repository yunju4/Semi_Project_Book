<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <div class="card-header"><h4 class="text-center font-weight-light my-1">신규도서등록</h4></div>
                        <div class="card-body">
                            <form id="enroll-form" action="<%= contextPath%>/productInsert.ad" method="post" enctype="multipart/form-data">
                                <div class="form-floating mb-3">
                                    <input class="form-control" name="bookTitle" type="text" placeholder="제일 상단 머릿말" maxlength="100"/>
                                    <label for="bookTitle">제일 상단 머릿말</label>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="author" type="text" placeholder="작가명" maxlength="16"/>
                                            <label for="author">작가명</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating"> 
                                            <select name="bookCode" style="height: 57px; width: 100%; border:1px solid #ced4da; border-radius: 0.25rem;">
                                                <option value="1">소설</option>
                                                <option value="2">에세이</option>
                                                <option value="3">역사</option>
                                                <option value="4">과학</option>
                                                <option value="5">정치</option>
                                                <option value="6">로맨틱</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="publisher" type="text" placeholder="출판사" maxlength="6"/>
                                            <label for="publisher">출판사</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <input class="form-control" name="pblctDate" type="text" placeholder="출간일" />
                                            <label for="pblctDate">출간일</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="tagContent1" type="text" placeholder="태그1" />
                                            <label for="tagContent1">태그1</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <input class="form-control" name="tagContent2" type="text" placeholder="태그2" />
                                            <label for="tagContent2">태그2</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="title" type="text" placeholder="책제목" maxlength="100"/>
                                            <label for="title">책제목</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <input class="form-control" name="price" type="number" placeholder="가격" />
                                            <label for="price">가격</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-floating mb-3">
                                    <input class="form-control" name="bookHead" type="text" placeholder="내용 중 첫번째 머리말"/>
                                    <label for="bookHead">내용 중 첫번째 머리말</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <textarea class="form-control" name="bookContent" type="textarea" placeholder="내용 중 첫번째 머리말"></textarea>
                                    <label for="bookContent">첫번째 머리말 하단 내용</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <textarea class="form-control" name="authorInfo" type="textarea" placeholder="저자 소개 부분 내용"></textarea>
                                    <label for="authorInfo">저자 소개 부분 내용</label>
                                </div>
<!--                                 <div class="row mb-3"> -->
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="stock" type="number" placeholder="재고" />
                                            <label for="stock">재고</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="btn btn-dark btn-block" name="upfile" type="file" style="margin-top: 10px;"></input>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                <div class="mt-4 mb-0">
                                    <div class="d-grid"><button class="btn btn-dark btn-block" type="submit">가랏! 신규등록!</button></div>
                                </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </main>
    <%@ include file="../../common/admin_end.jsp" %>
 </body>
</html>