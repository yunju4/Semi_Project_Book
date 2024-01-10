<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <style>
    #etc  {
    	padding-left: 20px ;
   		margin:0 auto; 
        dispaly : inline-block;
        width :65%;
    }
</style>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
 <%@ include file="../common/main_top.jsp" %>

<h1 class="text-center font-weight-light my-1" >북적북적에 오신 것을 환영합니다.</h1>
 <div id="layoutSidenav_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-11">
                                <div class="card border-1 rounded-lg mt-5">
                                    <div class="card-header"><h4 class="text-center font-weight-light my-1">로그인</h4></div>
                                    <div class="card-body">
                                        <form id="login-form" action="<%= contextPath %>/login.me" method="post" >
                                        
                                        
                                        	<!-- ID -->
                                          
                                           
                                            <div class="form-floating mb-3">
                                                <input class="form-control" name="id" type="text" placeholder="아이디 입력" maxlength="15" required />
                                                <label >아이디 입력</label>
                                            </div>
                                            
                                            <!-- PW -->
                                            <div class="form-floating mb-3">
                                                <input class="form-control" name="pw" type="password" placeholder="비밀번호 입력" maxlength="15" required />
                                                <label >비밀번호 입력</label>
                                            </div>
                                           
                                 
                                        
                                            <!-- Login Btn -->
                                            <div class="mt-4 mb-3">
                                                <div class="d-grid"><button class="btn btn-dark btn-block" type="submit">Login</button></div>
                                            </div>
                                            
                                            <div id="etc"  class="row mb-3">
                                            	<!-- 회원가입 -->
                                               <div class="col-md-4">
                                                    <div class="form-floating">
                                                    <button type="button"class="btn btn-dark btn-block" onclick="changePage(0)">회원가입</button>
                                                    </div>
                                                </div>
                                                <!-- ID찾기 -->
                                                <div class="col-md-4">
                                                    <div class="form-floating">
                                                    <button type="button"class="btn btn-dark btn-block" onclick="changePage(1)" >ID 찾기</button>
                                                    </div>
                                                </div>
                                                <!-- PW찾기 -->
                                                <div class="col-md-4">
                                                    <div class="form-floating">
                                                    <button type="button"class="btn btn-dark btn-block" onclick="changePage(2)" >PW 찾기</button>
                                                    </div>
                                                </div>
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
	        	function changePage(num) {
	        		switch(num){
	        		case 0:
	        			location.href = "<%= contextPath %>/enrollForm.me";
	        			break;
	        		case 1:
	        			location.href = "<%= contextPath %>/findIdForm.me";
	        			break;
	        		default:
	        			location.href = "<%= contextPath %>/findPwForm.me";
	        			
	        		}
	        		
	        	}
	 </script>  
	  <%@ include file="../common/main_end.jsp" %>
   
</body>

</html>