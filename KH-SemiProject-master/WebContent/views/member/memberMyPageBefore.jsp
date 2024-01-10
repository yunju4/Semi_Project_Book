<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>MyPage</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  
  	#wrap {
  		display:block;
  		
  		height:1000px;
  	}
	.fakeimg {
    height: 200px;
    background: #aaa;
  }

	.mb-3{
	  border-bottom: 1px solid #ccc;
	  margin: 20px;
	  padding-bottom: 20px;
	}
	
	.smallTitle{
	  font-weight: bold;
	  padding-bottom: 10px;
	}
	
	.btn-block{
	  margin-bottom: 10px; 
	  height: 30px;
	  padding: 0px;
	}

	.form-control div>p{
		margin: 10px;
	}
  </style>
</head>
<body>
	<%@ include file="../common/main_top.jsp" %>
	<%@ include file="../common/mypage.jsp" %>
	
	

	<%
		String userId = loginUser.getUserId();
		String userPwd = loginUser.getUserPwd();
		String userName = loginUser.getUserName();
		String address = loginUser.getAddress();
		String detailAddress = loginUser.getDetailAddress();
		String phone = loginUser.getPhone();
		String postNo = loginUser.getPostNo();
		String email = loginUser.getEmail();
	%>


	<section>
		<main>
			<div class="container">
				<div class="row justify-content-center">
					<div class="container" id="wrap"
						style="padding-bottom: 50px; margin: 0px; width: 1000px;">
						<div class="row justify-content-center">
							<div class="col-lg-11">
								<div class="card border-1 rounded-lg mt-5">
									<div class="card-header">
										<h4 class="text-center font-weight-light my-1">나의 정보</h4>
									</div>
									<div class="card-body">
										<form id="mypage-form" action="<%=contextPath%>/update.me"
											method="post">

											<div class="form-floating mb-3" style="border: 1px solid rgb(226, 226, 226);; background-color: rgb(245, 245, 245); padding: 10px;">
												정보 수정을 하시려면 아래 [비밀번호 재확인]을 클릭하시고 회원님의 "비밀번호"로 재인증해 주시기 바랍니다.
												<a class="nav-link" href="<%= contextPath %>/vailPwd.me"><b>비밀번호 재확인</b></a>
											</div>
											
											<div class="form-floating mb-3">
												<label class="smallTitle">이름</label><br>
												<br> <input class="form-control onlyRead" type="text"
													id="userName" name="userName" value="<%=userName%>"
													maxlength="6" style="padding: 20px;" readonly /><br>
											</div>

											<div class="form-floating mb-3">
												<label class="smallTitle">아이디</label><br>
												<br> <input class="form-control" name="userId"
													id="userId" type="text" value="<%=userId%>"
													maxlength="12" style="padding: 20px;" readonly /><br>
											</div>

											<div class="form-floating mb-3">

												<label class="smallTitle" style="padding: 0px;">비밀번호</label>
												<button type="button" class="btn btn-dark btn-sm"
													data-toggle="modal" data-target="#updatePwdForm"
													style="margin-left: 100px;" disabled>비밀번호변경</button>
											</div>

											<div class="form-floating mb-3">
												<label class="smallTitle">주소</label><br><br><br>
												<div>
													<p>우편번호</p>
													<input class="form-control" id="phone"
													name="phone" type="text" value="<%=postNo%>"
													style="padding: 20px;" readonly/><br>

													<p>주소</p>
													<input class="form-control" id="phone"
													name="phone" type="text" value="<%=address%>"
													style="padding: 20px;" readonly/><br>

													<p>상세 주소</p><input class="form-control" id="phone"
													name="phone" type="text" value="<%=detailAddress%>"
													style="padding: 20px;" readonly/><br>
												</div>
											</div>

											<div class="form-floating mb-3">
												<label class="smallTitle">전화번호</label><br>
												<br> <input class="form-control" id="phone"
													name="phone" type="text" value="<%=phone%>"
													style="padding: 20px;" readonly/><br>
											</div>

											<div class="form-floating mb-3">
												<label class="smallTitle">이메일</label><br>
												<br> <input class="form-control" id="email"
													name="email" type="text" value="<%=email%>"
													style="padding: 20px;"readonly /><br>
											</div>



											<div class="mt-4 mb-0">
												<div class="d-grid">
													<button class="btn btn-dark btn-block" id="userChange"
														type="submit" onclick="return reg(); "
														style="height: 50px;">회원정보 수정</button>
												</div>
											</div>
										</form>
									</div>

									
      

  


									<!-- The Modal : 비밀번호변경 -->
									<div class="modal" id="updatePwdForm">
										<div class="modal-dialog">
											<div class="modal-content">

												<!-- Modal Header -->
												<div class="modal-header">
													<h4 class="modal-title">비밀번호 변경</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>

												<!-- Modal body -->
												<div class="modal-body" align="center">

													<form action="<%=contextPath%>/updatePwd.me"
														method="post">
														<!-- 현재 비밀번호, 변경할 비밀번호, 변경할 비밀번호 확인 (재입력) -->

														<!-- 확실하게 주인을 판별할 수 있는 id 도 같이 넘겨야 한다. -->
														<input type="hidden" name="userId" value="<%=userId%>">

														<table>
															<tr>
																<td>현재 비밀번호</td>
																<td><input type="password" name="userPwd" required></td>
															</tr>
															<tr>
																<td>변경할 비밀번호</td>
																<td><input type="password" name="updatePwd"
																	required></td>
															</tr>
															<tr>
																<td>변경할 비밀번호 재입력</td>
																<td><input type="password" name="checkPwd" required></td>
															</tr>
														</table>

														<br>

														<button type="submit" class="btn btn-dark btn-sm"
															onclick="return validatePwd();">비밀번호 변경</button>
													</form>

													<script>
														function validatePwd() {

															if ($(
																	"input[name=updatePwd]")
																	.val() != $(
																	"input[name=checkPwd]")
																	.val()) {
																alert("비밀번호가 일치하지 않습니다.");

																return false;
															} else {
																return true;
															}

														}
													</script>

												</div>

											</div>
										</div>
									</div>

									<!-- The Modal : 정보수정허용 -->
									<div class="modal" id="writeOk">
										<div class="modal-dialog">
											<div class="modal-content">

												<!-- Modal Header -->
												<div class="modal-header">
													<h4 class="modal-title">정보 수정 허용</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>

												<!-- Modal body -->
												<div class="modal-body" align="center">

													<form action="<%=contextPath%>/vailPwd.me"
														method="post">
														<!-- 현재 비밀번호, 변경할 비밀번호, 변경할 비밀번호 확인 (재입력) -->

														<!-- 확실하게 주인을 판별할 수 있는 id 도 같이 넘겨야 한다. -->
														<input type="hidden" name="userId" value="<%=userId%>">

														<table>
															<tr>
																<td>현재 비밀번호</td>
																<td><input type="password" name="userPwd" required></td>
															</tr>
														</table>

														<br>

														<button type="submit" class="btn btn-dark btn-sm"
															onclick="return validateMy();">정보 수정 확인</button>
													</form>
													
													<script>
														function validateMy() {

															if ($("input[name=userPwd]").val() != <%=userPwd%> {
																alert("비밀번호가 일치하지 않습니다.");
																return false;
															} else {
																alert("비밀번호가 일치.");
																var inputs = document.getElementsByClassName('onlyRead');
																
																for (var i = 0; i<inputs.length; i++){
																	inputs[i].reandOnly = false;
																}
																
																return true;
															}

														}
													</script>
												</div>

											</div>
										</div>
									</div>




								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

		</main>

	</section>
	<script>
		function reg() {

			// 휴대전화번호
			var regExp = /^[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$/;
			var phone = document.getElementById('phone').value;

			if (!regExp.test(phone)) {
				alert("휴대전화번호를 확인해 주세요.");
				document.getElementById('phone').focus();
				return false;
			}

			// 우편번호
			regExp = /^([0-9]{5,6})$/;
			var postNo = document.getElementById("postNo").value;
			if (!regExp.test(postNo)) {
				alert("'우편번호' 부분이 잘못되었습니다. 다시 입력해 주세요.");
				document.getElementById('postNo').focus();
				return false;
			}

			// 이름
			regExp = /^([가-힣]{2,4})$/;
			var userName = document.getElementById("userName").value;

			if (!regExp.test(userName)) {
				alert("이름을 확인해 주세요.");
				document.getElementById('userName').focus();
				return false;
			}

			// 상세주소
			regExp = /^([가-힣0-9]{3,})$/;
			var detailAddress = document.getElementById('detailAddress').value;
			if (!regExp.test(detailAddress)) {
				alert("'상세주소'' 부분이 잘못되었습니다. 다시 입력해 주세요.");
				document.getElementById('detailAddress').focus();
				return false;
			}
		}
	</script>
</body>
</html>
