<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

  <link>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>북적북적</title>
    <!-- <link href="css/forsignupstyles.css" rel="stylesheet" /> -->
    <script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="../common/main_top.jsp" %>
	
	<section>
		<form>
			<main>
			  <div class="container">
			      <div class="row justify-content-center">
			          <div class="col-lg-11">
			              <div class="card border-1 rounded-lg mt-5" style="margin-bottom: 150px;">
			                  <div class="card-header"><h4 class="text-center font-weight-light my-1">비밀번호 변경</h4></div>
			                 <div class="card-body">
			                      <form action="<%= contextPath %>/updatePwd.me" method="post">
			
			                          <div class="form-floating mb-3">
	                       				<input type="hidden" name="userId" value="<%=loginUser.getUserId() %>">
			                          
			  
			                             <table>         
			                                <tr>
			                                    <td><input class="form-control" type="password" name="userPwd"  placeholder="기존 비밀번호" required></td>
			                                </tr>
			                                <tr>
			                                    <td><input class="form-control" type="password" name="updatePwd" placeholder="변경할 비밀번호" required></td>
			                                </tr>
			                                <tr>
			                                    <td><input class="form-control" type="password" name="checkPwd" placeholder="변경할 비밀번호 재입력" required></td>
			                                </tr>
			                            </table>
			                          </div>
			
			                          <div class="mt-4 mb-0">
			                              <div class="d-grid"><button class="btn btn-dark btn-block" type="submit">변경완료</button></div>
			                          </div>
			                      </form>
			                     
						                      
			                  </div>
			              </div>
			          </div>
			      </div>
			  </div>
			</main>
	    </form>
	</section>

</body>
</html>