<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <link>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>북적북적</title>
    <script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
		<style>

			table td{
				width: 1000px;
			}
		</style>
  </head>
  <div>
  <body>
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<%@ include file="../common/main_top.jsp" %>
	<%@ include file="../common/mypage.jsp" %>
	
	<section>

	<div id="layoutSidenav_content">

	<main>
		 <div class="container" style="margin-top : 0px;">
            <div class="row justify-content-center">
                <div class="col-lg-11">
                    <div class="card border-1 rounded-lg mt-5" style="margin-bottom: 150px;">
                        <div class="card-header"><h4 class="text-center font-weight-light my-1">비밀번호 재확인</h4></div>
                        
                        <p style="text-align: center; font-size: 14px; padding-top: 50px;">My정보 변경을 하시려면 개인정보 보호를 위해 회원님의 비밀번호를 다시 한번 확인합니다.</p>
                        <div class="card-body">
                            <form action="<%= contextPath %>/checkPwd.me" method="post">
                            

	      
	                                <div class="form-floating mb-3">
	        
	                                  <table>         
	                                      <tr>
	                                          <td><input class="form-control mt-4 mb-0" type="password" name="checkPwd" placeholder="비밀번호를 입력해주세요."required></td>
	                                      </tr>
	                                  </table>
	                                  
	                                </div>
	      
	                                <div class="mt-4 mb-0">
	                                    <div class="d-grid"><button class="btn btn-dark btn-block" id="change" type="submit">확인</button></div>
	                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     </main>
     </div>
		
	</section>
	
	<%@ include file="../common/main_end.jsp" %>
	
</body>
</html>