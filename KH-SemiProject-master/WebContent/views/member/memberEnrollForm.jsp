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

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

 <div id="layoutSidenav_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-11">
                                <div class="card border-1 rounded-lg mt-5">
                                    <div class="card-header"><h4 class="text-center font-weight-light my-1">회원가입</h4></div>
                                    <div class="card-body">
                                        <form id="enroll-form" action="<%= contextPath %>/insert.me" method="post" >
                                        
                                        
                                        	<!-- ID -->
                                          
                                            <div class="row mb-3">
                                                <div class="col-md-9">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="id" name="id" type="text" placeholder="아이디입력"  maxlength="20" required/>
                                                        <label for="tag-content">아이디입력 </label>
                                                
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-floating">
                                                    <button type="button" id="checkBtn"  name="checkBtn" class="btn btn-dark btn-block" onclick="checkIdClicked()" >아이디 확인</button>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            
                                            <!-- PW -->
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="pw" name="pw" type="password" placeholder="비밀번호 입력" maxlength="15" required />
                                                <label >비밀번호 입력</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="pw_check"  name="pw_check" type="password" placeholder="비밀번호 확인" maxlength="15" required />
                                                <label >비밀번호 확인</label>
                                            </div>
                                            
                                            
                                            <!-- name -->
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="name"  name="name" type="text" placeholder="이름" maxlength="10" required />
                                                <label >이름</label>
                                            </div>
                                            
                                            
                                            <!-- Phone -->
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="phone"  name="phone" type="text" placeholder="전화번호" maxlength="13" required />
                                                <label >전화번호</label>
                                            </div>
                                            
                                            
                                            <!-- Email -->                   
                                            <div class="row mb-3">
                                                <div class="col-md-9">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="email" name="email" type="email" placeholder="이메일 주소" required/>
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
                                                   <button  type="button" id="ckecknumBtn" name="ckecknumBtn"  class="btn btn-dark btn-block" onclick="checkNumClicked()" >인증번호 확인</button>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            
                                            <!-- add -->
                                            <div class="row mb-3">
                                                <div class="col-md-9">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id = "postnum" name="postnum" type="text" placeholder="우편번호" required />
                                                        <label for="tag-content">우편 번호</label>
                                                
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-floating">
                                                    <button type="button" id = "postnumBnt"  name = "postnumBnt"  class="btn btn-dark btn-block" onclick="serchPostClicked()" >우편번호 찾기</button>
                                                    </div>
                                                  
                                                </div>
                                            </div>
                                           
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id = "add" name="add"  type="text" placeholder="주소" required />
                                                <label >주소</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="detailadd" name="detailadd" type="text" placeholder="상세 주소 입력"  required  />
                                                <label >상세 주소 입력</label>
                                            </div>
                                            <!-- summit Btn -->
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-dark btn-block"  type="submit" onclick="return checkInput();">회원 가입 완료</button></div>
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
//이메일 전송버튼 눌렀을때 실행
	function checkIdClicked(){
		var $userId = $("#enroll-form input[name=id]");
		
	
		$.ajax({
			url : "CheckId.me", 
			data : { checkId : $userId.val() },
			success : function(result) {
				
			
				if(result == "NNNNN") { 
					
					alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
					
					$userId.focus();
				}
				else { 
					var regExp = /^([a-zA-z0-9]{6,15})$/;
					var id=$userId.val()
					if(!regExp.test(id)){
						//정규식 검사 실패시
						alert("아이디 형식을 확인해 주세요 (6~15글자 영어 대소문자 , 숫자)");
						$userId.focus(); 
						return 0;
					}
					
			
					if(confirm("사용 가능한 아이디입니다. 사용하시겠습니까?")) { 
						$userId.attr("readonly", true);
						$("#enroll-form button[name=checkBtn]").attr("disabled", true);
					}
					else { 
						
						$userId.focus(); 
						
					}
					
				}
				
			},
			error : function() {
				console.log("아이디 중복체크용 ajax 실패");
			}
		});
		
	}
</script>
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
						$checkNum.focus();
					}
					else{
						alert("인증번호인증 성공");
						$("#enroll-form input[name=email]").attr("readonly", true);
						$("#enroll-form input[name=ckecknum]").attr("readonly", true);
						$("#enroll-form button[name=emailBtn]").attr("disabled", true);
						$("#enroll-form button[name=ckecknumBtn]").attr("disabled", true);
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
//우편번호 찾기 눌렀을때 실행
	function serchPostClicked(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	
	        	  var addr='';
	        	  
	        	  if(data.userSelectedType ==='R'){
	        		  addr=data.roadAddress;
	        	  }
	        	  else{
	        		  addr=data.jibunAddress;
	        	  }
	        	  document.getElementById('postnum').value=data.zonecode;
	        	  document.getElementById('add').value=addr;
	        	
	        	  $("#enroll-form button[name=postnumBnt]").attr("disabled", true);
	        	  document.getElementById('detailadd').focus();
	        	  
	        }
	  	}).open();
	   
	    }
</script>
<script>
function checkInput(){
	 
	
	
    var regExp = /^[0-9A-Za-z]{8,15}$/;
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
	regExp = /^[가-힣]{2,}$/;
	var name = document.getElementById('name').value;
	if(!regExp.test(name)) {
        alert("이름을 확인해주세요");
        document.getElementById('name').focus();
        return false;
    }
	regExp = /^[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$/;
	var phone = document.getElementById('phone').value;
	if(!regExp.test(phone)) {
        alert("전화번호 형식을 확인해주세요(-포함)");
        document.getElementById('phone').focus();
        return false;
    }
	if(!($("#checkBtn").is(":disabled"))){
		 alert("아이디 확인 버튼을 클릭해주세요");
	     document.getElementById('id').focus();
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
	if(!($("#postnumBnt").is(":disabled"))){
		 alert("우편번호 찾기버튼을 클릭해 주세요");
	     document.getElementById('postnum').focus();
	     return false;
	}
	
}

</script>

 <%@ include file="../common/main_end.jsp" %>
</body>

</html>