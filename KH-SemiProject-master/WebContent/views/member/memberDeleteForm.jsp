<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
   <link href="css/forFormUI.css" rel="stylesheet" />
</head>
<body>
 <%@ include file="../common/main_top.jsp" %>
 <%@ include file="../common/mypage.jsp" %>
 <div id="layoutSidenav_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-11">
                                <div class="card border-1 rounded-lg mt-5">
                                    <div class="card-header"><h4 class="text-center font-weight-light my-1">회원탈퇴</h4></div>
                                    <div class="card-body">
                                        <form id="delete-form" action="<%= contextPath %>/delete.me" method="post" >
                                        	 <!-- ID -->
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="id" name="id" type="text" placeholder="아이디 입력" maxlength="15" required />
                                                <label >아이디 입력</label>
                                            </div>
                                        
                                            
                                            <!-- PW -->
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="pw" name="pw" type="password" placeholder="비밀번호 입력" maxlength="15" required />
                                                <label >비밀번호 입력</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="pw_check" name="pw_check" type="password" placeholder="비밀번호 확인" maxlength="15" required />
                                                <label >비밀번호 확인</label>
                                            </div>
                                    		
                                            <!-- summit Btn -->
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button  type="submit" class="btn btn-dark btn-block"  onclick = "return checkInput();" >회원탈퇴</button></div>
                                            </div>
                        		
                                        </form>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
 <script>
 function checkInput(){
	 	var regExp =/^([a-zA-z0-9]{6,15})$/;
		var id = document.getElementById('id').value;
		if(!regExp.test(id)) {
	        alert("아이디형식을 확인해주세요 ((영 대소문자 숫자 6~15자리))");
	        document.getElementById('id').focus();
	        return false;
	    }
		
	     regExp = /^[0-9A-Za-z]{8,15}$/;
		var pw = document.getElementById('pw').value;
		if(!regExp.test(pw)) {
	        alert("비밀번호 형식을 확인해주세요 (영 대소문자 숫자 8~15자리)");
	        document.getElementById('pw').focus();
	        return false;
	    }
	
		var pw_check = document.getElementById('pw_check').value;
		if(!regExp.test(pw_check)) {
	        alert("비밀번호 확인 형식을 확인해주세요 (영 대소문자 숫자 8~15자리)");
	        document.getElementById('pw_check').focus();
	        return false;
	    }
		if(!(pw === pw_check)){
			alert("비밀번호와 확인이 일치하지 않습니다.");
	        document.getElementById('pw').focus();
	        return false;
		}
		if(!((id===<%=loginUser.getUserId() %>) &&(pw===<%=loginUser.getUserPwd() %>)) ){
			alert("로그인한 회원의 정보와 다릅니다.");
			return false;
		}
		
		
		
	}
 </script>
 <%@ include file="../common/main_end.jsp" %> 
</body>
</html>