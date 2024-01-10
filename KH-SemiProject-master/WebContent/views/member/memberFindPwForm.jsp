<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/forFormUI.css" rel="stylesheet" />
<title>비밀번호 찾기</title>
</head>
<body>
 <%@ include file="../common/main_top.jsp" %>

 <div id="layoutSidenav_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-11">
                                <div class="card border-1 rounded-lg mt-5">
                                    <div class="card-header"><h4 class="text-center font-weight-light my-1">비밀번호 찾기</h4></div>
                                    <div class="card-body">
                                        <form id="find-pw-form" action="<%= contextPath %>/findPw.me" method="post" >
                                        
                                        	 <!-- id -->
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="id" name="id" type="text" placeholder="아이디 입력" maxlength="15" required />
                                                <label >아이디 입력</label>
                                            </div>
                                            
                                            <!-- name -->
                                            <div class="form-floating mb-3">
                                                <input class="form-control" name="name"  id="name" type="text" placeholder="이름" maxlength="10" required />
                                                <label >이름</label>
                                            </div>
                                            
                                           
                                            
                                            
                                            <!-- Email -->                   
                                            <div class="row mb-3">
                                                <div class="col-md-9">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="email" name="email" type="email" placeholder="이메일 주소" />
                                                        <label>이메일 주소</label>
                                                
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-floating">
                                                   <button type="button" id="emailBtn" name="emailBtn" class="btn btn-dark btn-block" onclick="sendEmailClicked()" >인증번호 전송</button>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <div class="col-md-9">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="checknum" name="checknum" type="text" placeholder="인증번호 입력" required/>
                                                        <label for="tag-content">인증번호 입력</label>
                                                
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-floating">
                                                   <button  type="button" name="ckecknumBtn"  id="ckecknumBtn" class="btn btn-dark btn-block" onclick="checkNumClicked()" >인증번호 확인</button>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            
                                           
                                            <!-- summit Btn -->
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-dark btn-block"  type="submit" onclick="return checkInput();">비밀번호 찾기</button></div>
                                            </div>
                        		
                                        </form>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>  
<script>
//중복확인 눌렀을때 실행
	function checkNumClicked(){
		var inputNum = document.getElementById('checknum').value;

	
		if(inputNum.length==6){
			$.ajax({
				url : "checkNum.me", 
				data : { Num : inputNum },
				success : function(result) {
					if(result>0){
						alert("인증번호가 일치하지 않습니다. 다시 확인해주세요");
						$checkNum.focus(); // 다시 입력 유도
					}
					else{
						alert("인증번호인증 성공");
						$("#find-pw-form input[name=email]").attr("readonly", true);
						$("#find-pw-form input[name=ckecknum]").attr("readonly", true);
						$("#find-pw-form button[name=emailBtn]").attr("disabled", true);
						$("#find-pw-form button[name=ckecknumBtn]").attr("disabled", true);
					}
				},
				error : function() {
					console.log("인증번호 ajax 실패");
				}
			});
		}
		else{
			alert("인증번호의 형태가 올바르지 않습니다. (숫자 6자리)");
		}
	}
</script>
<script>
//이메일 형식 확인 함수
	function isEmail(str){ 
	    var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	    if(!reg_email.test(str)) {                            
	         return false;         
	    }                            
	    else {                       
	         return true;         
	    }                            
	}      
</script>
<script>
//이메일 전송버튼 눌렀을때 실행
	function sendEmailClicked(){
		var clientEmail = document.getElementById('email').value;
		var emailCheck = isEmail(clientEmail);
	
		if(emailCheck){
			$.ajax({
				url : "sendEmail.me", 
				data : { email : clientEmail },
				success : function(result) {
					if(result>0){
						alert("잠시후 다시 시도해 주세요");
					}
					else{
						alert("이메일 전송 완료. 메일 보관함을 확인해 주세요.");
					}
				},error : function() {
					console.log("이메일 보내기 ajax 실패");
				}
			});
		}
		else{
			alert("이메일 형식 확인 부탁드립니다 :)");
		}
		
	}
</script>
<script>
function checkInput(){
	 
	
	
    var regExp =/^([a-zA-z0-9]{6,15})$/;
	var id = document.getElementById('id').value;
	if(!regExp.test(id)) {
        alert("아이디형식을 확인해주세요 ((영 대소문자 숫자 6~15자리))");
        document.getElementById('id').focus();
        return false;
    }
	

	regExp = /^[가-힣]{2,}$/;
	var name = document.getElementById('name').value;
	if(!regExp.test(name)) {
        alert("이름을 확인해주세요");
        document.getElementById('name').focus();
        return false;
    }
	
	
	if(!($("#emailBtn").is(":disabled"))){
		 alert("이메일 전송버튼을 클릭해주세요");
	     document.getElementById('email').focus();
	     return false;
	}
	if(!($("#ckecknumBtn").is(":disabled"))){
		 alert("이메일 인증버튼을 클릭해주세요");
	     document.getElementById('checknum').focus();
	     return false;
	}

}

</script>
 <%@ include file="../common/main_end.jsp" %> 
</body>
</html>