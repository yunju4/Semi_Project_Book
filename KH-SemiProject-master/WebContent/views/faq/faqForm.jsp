<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ</title>
<link href="css/forFAQ.css" rel="stylesheet" />
</head>
 <%@ include file="../common/main_top.jsp" %>
 
<body>

	<div class="container">
         <div class="row justify-content-center">
             <div class="col-lg-11">
                 <div class="card border-1 rounded-lg mt-5">
                     <div class="card-header"><h4 class="text-center font-weight-light my-1">FAQ</h4></div>
                     <div class="card-body">
                             <div class="form-floating mb-3">
                                 <div class="alert alert-warning alert-dismissible" role="alert">
                                     
                                     <strong>자주 묻는 질문들 입니다 </strong><br> 더 궁금한 사항이 있으시면 1대1 문의를 이용해 주세요.<br>
         							 <a id="oneToOne" href="<%=contextPath %>//inquiryForm.in?currentPage=1">1대1문의 바로가기</a>
	           						
                                     
                                 </div>
                             </div>
                             <!-- 질문 div -->
                             <div>
                             	<span id="toc-toggle" onclick="openCloseToc()" ><h4>회원가입은 어디서 하나요?</h4></span>
                                 <ol id="toc-content" style="display : none">
								  	<div class="alert alert-warning alert-dismissible" role="alert">
                                     <!-- 답변 제목 -->
                                     <strong>회원가입 방법입니다. </strong>
                                     <!-- 내용-->
                                     <br> PC 홈페이지 접속 → 우측상단 로그인 버튼 클릭 → 회원가입 버튼클릭 하시면 회원가입이 가능합니다. <br>
                            
                                 </div>
								 </ol>
                             </div>
                              <!-- 질문 div -->
                             <div>
                             	<span id="toc-toggle" onclick="openCloseToc1()" ><h4>탈퇴는 어떻게 하나요 ?</h4></span>
                                 <ol id="toc-content1" style="display : none">
								  	<div class="alert alert-warning alert-dismissible" role="alert">
                                     <!-- 답변 제목 -->
                                     <strong>회원탈퇴 이용 방법 </strong>
                                     <!-- 내용-->
                                     <br> PC 홈페이지 접속 → [마이페이지] 접속 후  My정보 → 회원탈퇴에서 회원 탈퇴가 가능합니다. <br>
                            
                                 </div>
								 </ol>
                             </div>
                               <!-- 질문 div -->
                             <div>
                             	<span id="toc-toggle" onclick="openCloseToc2()" ><h4>주문한 상품은 언제 받을 수 있을까요 ?</h4></span>
                                 <ol id="toc-content2" style="display : none">
								  	<div class="alert alert-warning alert-dismissible" role="alert">
                                     <!-- 답변 제목 -->
                                     <strong>배송 예정일 </strong>
                                     <!-- 내용-->
                                     <br> 
											도서산간지역은 근무일 기준 3일 이내입니다.
											
											연휴/공휴일이 있을 경우 해당기간 제외 후 배송 기간을 산정합니다.
											
											택배사 사정이나 기상악화의 경우는 배송일이 다소 변경될 수 있습니다.
											
											3. 해피머니 문화상품권은 어떻게 사용하나요 ?
											북적북적에서는 아직 해피머니 문화상품권을 사용하실 수 없습니다.
                                     
                                     <br>
                            
                                 </div>
								 </ol>
                             </div>
                             
                                 <!-- 질문 div -->
                             <div>
                             	<span id="toc-toggle" onclick="openCloseToc3()" ><h4>배송비는 얼마인가요?</h4></span>
                                 <ol id="toc-content3" style="display : none">
								  	<div class="alert alert-warning alert-dismissible" role="alert">
                                     <!-- 답변 제목 -->
                                     <strong>배송비 관련 규정 </strong>
                                     <!-- 내용-->
                                     <br> 
											북적북적에서는 한 개 이상 구매시 모두 무료 배송입니다
                                     
                                     <br>
                            
                                 </div>
								 </ol>
                             </div>
                             
                                 <!-- 질문 div -->
                             <div>
                             	<span id="toc-toggle" onclick="openCloseToc4()" ><h4>북적북적에서 사용 가능한 결제수단은 어떤 것들이 있나요 ?</h4></span>
                                 <ol id="toc-content4" style="display : none">
								  	<div class="alert alert-warning alert-dismissible" role="alert">
                                     <!-- 답변 제목 -->
                                     <strong>결제 수단 </strong>
                                     <!-- 내용-->
                                     <br> 
											당사에서는 회원님들께 "신용카드 결제" 수단을 제공하고 있습니다
                                     
                                     <br>
                            
                                 </div>
								 </ol>
                             </div>
                             
                                   <!-- 질문 div -->
                             <div>
                             	<span id="toc-toggle" onclick="openCloseToc5()" ><h4>신용카드 결제 후, 부분 취소는 어떻게 하나요 ?</h4></span>
                                 <ol id="toc-content5" style="display : none">
								  	<div class="alert alert-warning alert-dismissible" role="alert">
                                     <!-- 답변 제목 -->
                                     <strong>환불규정</strong>
                                     <!-- 내용-->
                                     <br> 
											홈페이지 통해 직접 부분취소 하는 경우에는 신용카드 재승인으로 처리 되며,
											고객센터를 통한 부분취소 시에는 신용카드 부분 취소가 됩니다.(일부카드는 예치금으로 환불)
                                     
                                     <br>
                            
                                 </div>
								 </ol>
                             </div>
                             
                                    <!-- 질문 div -->
                             <div>
                             	<span id="toc-toggle" onclick="openCloseToc6()" ><h4>주문 취소는 어디서 하나요 ?</h4></span>
                                 <ol id="toc-content6" style="display : none">
								  	<div class="alert alert-warning alert-dismissible" role="alert">
                                     <!-- 답변 제목 -->
                                     <strong> 주문 취소방법</strong>
                                     <!-- 내용-->
                                     <br> 
											

											취소 방법은 아래와 같습니다.
											
											
											1) 마이페이지 > My 쇼핑 > 주문/배송 조회
											
											2) 주문내역/배송조회 페이지의 주문한 내역을 확인하고 주문번호를 클릭
											
											3) 취소하려는 상품 우측의 버튼 선택을 체크하고 [주문취소]를 클릭

                                     
                                     <br>
                            
                                 </div>
								 </ol>
                             </div>
                             
                             
                    
                     </div>
                 </div>
             </div>
         </div>
     </div>
<script>
  function openCloseToc() {
    if(document.getElementById('toc-content').style.display === 'block') {
      document.getElementById('toc-content').style.display = 'none';
 
    } else {
      document.getElementById('toc-content').style.display = 'block';
   
    }
  }
</script>


<script>
  function openCloseToc1() {
    if(document.getElementById('toc-content1').style.display === 'block') {
      document.getElementById('toc-content1').style.display = 'none';
 
    } else {
      document.getElementById('toc-content1').style.display = 'block';
   
    }
  }
</script>
<script>
  function openCloseToc2() {
    if(document.getElementById('toc-content2').style.display === 'block') {
      document.getElementById('toc-content2').style.display = 'none';
 
    } else {
      document.getElementById('toc-content2').style.display = 'block';
   
    }
  }
</script>
<script>
  function openCloseToc3() {
    if(document.getElementById('toc-content3').style.display === 'block') {
      document.getElementById('toc-content3').style.display = 'none';
 
    } else {
      document.getElementById('toc-content3').style.display = 'block';
   
    }
  }
</script>
<script>
  function openCloseToc4() {
    if(document.getElementById('toc-content4').style.display === 'block') {
      document.getElementById('toc-content4').style.display = 'none';
 
    } else {
      document.getElementById('toc-content4').style.display = 'block';
   
    }
  }
</script>
<script>
  function openCloseToc6() {
    if(document.getElementById('toc-content6').style.display === 'block') {
      document.getElementById('toc-content6').style.display = 'none';
 
    } else {
      document.getElementById('toc-content6').style.display = 'block';
   
    }
  }
</script>
<script>
  function openCloseToc5() {
    if(document.getElementById('toc-content5').style.display === 'block') {
      document.getElementById('toc-content5').style.display = 'none';
 
    } else {
      document.getElementById('toc-content5').style.display = 'block';
   
    }
  }
</script>


 <%@ include file="../common/main_end.jsp" %>
</body>
</html>