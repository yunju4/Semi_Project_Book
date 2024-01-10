<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.basket.model.vo.Basket" %>
<%
	ArrayList<Basket> atList = (ArrayList<Basket>)request.getAttribute("atList");
%>
<!-- 위 고길동 에 이거 사용하면 값 가져와짐 : (String)session.getAttribute("userName") [주소 또한 이와같이 해볼것]-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> <!-- 온라인 방식 -->
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- 다음 주소 검색 API -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style>
	.bookList>td {
        text-align : center;
        vertical-align : middle;
    }
</style>

</head>
<body>
		<%@ include file="../common/main_top.jsp" %>

	
		 <!-- Responsive navbar-->
		 <!-- 
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container px-lg-5">
                <a class="navbar-brand" href="#!">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="index.html">메인 페이지</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">마이 페이지</a></li>
                    </ul>
                </div>
            </div>
        </nav>
         -->
        <!-- Header-->
        <header class="py-5">


            <form action="<%= request.getContextPath() %>/order.ba" methd="post">
            <!-- 주문 상품 정보 -->
            <div class="container px-lg-5">
                <div class="text-center">
                    <h1>결 제</h1>
                </div>
                <div class="p-4 p-lg-5 bg-light rounded-3">
                    <b>● 주문 상품 정보</b>
                    <table id="table" class="table text-center">
                        <tr>
                            <th style="width:16%;">책 이미지</th>
                            <th>책 제목</th>
                            <th>가격</th>
                            <th>수량</th>
                            <th>소계</th>
                        </tr>
                        <% for(Basket b : atList) { %>
                        	<input type="hidden" value="<%= b.getBasketSeq() %>" name="basketNo">
	                        <tr class="bookList">
	                            <td><img src="<%= request.getContextPath() %>/<%= b.getTitleImg() %>" style="width:80%;"></td>
	                            <td class="title" name="title"><%= b.getBookTitle() %></td>
	                            <td class="price" name="price"><%= b.getPrice() %></td>
	                            <td class="count" name="count"><%= b.getCount() %></td>
	                            <td class="priceSum" name="priceSum"><%= b.getSumPrice() %></td>
	                        </tr>
                       	<% } %>
                        <!-- 
                        <tr>
                            <td><img src="http://image.yes24.com/momo/TopCate725/MidCate004/72435140.jpg" style="width:80%;"></td>
                            <td class="title" style="padding-top:8%;" name="title">장발장</td>
                            <td class="price" style="padding-top:8%;" name="price">6000</td>
                            <td class="count" style="padding-top:8%;" name="count">2</td>
                            <td class="priceSum" style="padding-top:8%;" name="priceSum">12000</td>
                        </tr>
						 -->
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>총계</td>
                        <td id="allCount" name="allCount"></td>
                        <td id="allSum" name="allSum">
                            
                        </td>
                    </tr>
                        
                    </table>

                    <script>
                        // 총계
                        var table = document.getElementById('table');
                            var sum = 0;
                        for(var i =1; i < table.rows.length - 1; i++) {
                            sum += parseInt(table.rows[i].cells[3].innerHTML);
                            console.log("sum : " + sum);
                        }

                        document.getElementById('allCount').innerHTML = parseInt(sum);
                    </script>

                    <table style="width:100%;">
                        <tr>
                            <td>
                                <a href="<%= request.getContextPath() %>/list.ba" class="btn btn-secondary" style="text-align:left;">장바구니 돌아가기</a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>

            <!-- 배송방법 선택 -->
            <!--
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5 bg-light rounded-3">
                    <b>● 배송 방법 선택</b>
                    <table id="table" class="table">
                        <tr>
                            <td style="width:20%"><b>배송방법</b></td>
                            <td>
                                    <input type="radio" id="post">택배 <br>
                                    <input type="radio" id="self">직접 수령 <br>   
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            -->

            <!-- 배송지 정보 입력 -->
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5 bg-light rounded-3">
                    <!-- 택배 -->
                    <b>● 배송지 정보 입력</b>
                    <p style="color:red; display:inline;  font-size:12px;">( * 필수 입력 항목 )</p>
                    
                    <table id="table" class="table">
                        <tr>
                            <tr>
                                <td>
                                    <p style="color:red; display:inline">*</p>
                                   	주문인
                                </td>
                                <td>
                                    <input id="order" type="text" name="order" required>
                                    <input type="button" onclick="getName();" value="현재 이름 가져오기">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p style="color:red; display:inline">*</p>
                                    	받으시는 분
                                </td>
                                <td>
                                    <input id="receipt" type="text" name="receipt" required>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p style="color:red; display:inline">*</p>
                                   	 주 소
                                </td>
                                <td>
                                    <!-- 다음 주소 API 검색 방법 사용 시작 -->
                                    <input type="text" id="postcode" placeholder="우편번호" name="postNo" required readonly>
									<input type="button" onclick="execDaumPostcode()" value="주소 찾기">
									<input type="button" onclick="getAllPost()" value="기록한 주소 가져오기"><br>
									<input type="text" id="roadAddress" placeholder="도로명주소" name="address" required readonly>
									<br>
									<span id="guide" style="color:#999;display:none"></span>
									<input type="text" id="detailAddress" placeholder="상세주소" required name="detailAddress" required>
									
									<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
									<script>
										// 회원정보에 입력된 내용 가져오기
										function getAllPost() {
											$(this).click(function() {
												$("#postcode").attr("value", "<%=loginUser.getPostNo() %>")
												$("#roadAddress").attr("value", "<%= loginUser.getAddress() %>")
												$("#detailAddress").attr("value", "<%= loginUser.getDetailAddress() %>")
											})
										}
									
									    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
									    function execDaumPostcode() {
									        new daum.Postcode({
									            oncomplete: function(data) {
									                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
									
									                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
									                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
									                var roadAddr = data.roadAddress; // 도로명 주소 변수
									                var extraRoadAddr = ''; // 참고 항목 변수
									
									                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
									                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
									                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
									                    extraRoadAddr += data.bname;
									                }
									                // 건물명이 있고, 공동주택일 경우 추가한다.
									                if(data.buildingName !== '' && data.apartment === 'Y'){
									                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
									                }
									                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
									                if(extraRoadAddr !== ''){
									                    extraRoadAddr = ' (' + extraRoadAddr + ')';
									                }
									
									                // 우편번호와 주소 정보를 해당 필드에 넣는다.
									                document.getElementById('postcode').value = data.zonecode;
									                document.getElementById("roadAddress").value = roadAddr;
									                document.getElementById("jibunAddress").value = data.jibunAddress;
									                
									                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
									                if(roadAddr !== ''){
									                    document.getElementById("extraAddress").value = extraRoadAddr;
									                } else {
									                    document.getElementById("extraAddress").value = '';
									                }
									
									                var guideTextBox = document.getElementById("guide");
									                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
									                if(data.autoRoadAddress) {
									                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
									                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
									                    guideTextBox.style.display = 'block';
									
									                } else if(data.autoJibunAddress) {
									                    var expJibunAddr = data.autoJibunAddress;
									                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
									                    guideTextBox.style.display = 'block';
									                } else {
									                    guideTextBox.innerHTML = '';
									                    guideTextBox.style.display = 'none';
									                }
									            }
									        }).open();
									    }
									</script>
                                    <!-- 다음 주소 API 검색 방법 끝 -->

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p style="color:red; display:inline; ">*</p>
                                   	휴대전화번호
                                </td>
                                <td>
                                    <input type="text" id="phone" name="phone" maxlength="13" placeholder="-포함여 13자리 입력하세요" required>
                                    <input type="button" onclick="getPhone()" value="전화번호 가져오기">
                                </td>
                            </tr>
                        </tr>
                    </table>
                    
                    <script>
                    	function getName() {
                    		$(this).click(function() {
                    			$("#order").attr("value", "<%= loginUser.getUserName() %>")
                    		})
                    	};
                    	
                    	function getPhone() {
	                		$(this).click(function() {
	                			$("#phone").attr("value","<%= loginUser.getPhone() %>")
	                		})
	                	};
                    </script>
                </div>
            </div>
            


            <!-- 결제 -->
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5 bg-light rounded-3">
                    <b>● 카드 비밀번호 입력</b>
                    <p style="color:red; display:inline; font-size:12px;">( 카드등록을 하지 않은 경우 결제를 진행할 수 없습니다.)</p>
                    <table id="table" class="table">
                        <tr>
                            <td>카드사</td>
                            <td>
                                <select id="cardName" name="cardName">
                                    <option value="신한">신한카드</option>
                                    <option value="BC">BC카드</option>
                                    <option value="케이뱅크">케이뱅크카드 (BC)</option>
                                    <option value="카카오뱅크">카카오뱅크 드(KB)</option>
                                    <option value="KB국민">KB국민카드</option>
                                    <option value="KB아이행복">KB아이행복(아이사랑)카드</option>
                                    <option value="KB고운맘">KB고운맘카드</option>
                                    <option value="삼성">삼성카드</option>
                                    <option value="현대">현대카드</option>
                                    <option value="롯데">롯데카드</option>
                                    <option value="하나">하나카드</option>
                                    <option value="하나BC">하나카드(BC카드)</option>
                                    <option value="NHBC">NH채움카드(BC카드)</option>
                                    <option value="NH"> NH채움카드</option>
                                    <option value="우리">우리카드</option>
                                    <option value="우리BC">우리카드(BC카드)</option>
                                    <option value="IBK">IBK기업(BC카드)</option>
                                    <option value="UnionPay">해외발급 Union Pay</option>
                                    <option value="VISA CARD">해외발급 VISA CARD</option>
                                    <option value="MASTER CARD">해외발급 MASTER CARD</option>
                                    <option value="JCB CARD">해외발급 JCB CARD</option>
                                    <option value="씨티">씨티카드</option>
                                    <option value="제주">제주카드</option>
                                    <option value="광주">광주카드</option>
                                    <option value="전북">전북카드</option>
                                    <option value="산업은행">산업은행카드</option>
                                    <option value="수협">수협카드</option>
                                    <option value="우체국">우체국카드</option>
                                    <option value="신협BC">신협카드(BC카드)</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>카드번호</td>
                            <td>
                                <input type="text" id="cardNum" name="cardNum" maxlength="19" placeholder="- 포함하여 입력하세요" required>
                            </td>
                        </tr>
                        <tr>
                            <td style="width:20%;">
                                	카드 비밀번호
                            </td>
                            <td>
                                <input type="password" id="cardPwd" name="cardPwd" required>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div  class="text-center">
                <button type="submit" class="btn btn-success" onclick="return payment();">결 제</button>
            </div>
            </form>
        </header>

        <script>
            // 총계
            var table = document.getElementById('table');
                var sum = 0;
            for(var i =1; i < table.rows.length - 1; i++) {
                sum += parseInt(table.rows[i].cells[4].innerHTML);
                console.log("sum : " + sum);
            }

            document.getElementById('allSum').innerHTML = parseInt(sum);

            function payment() {
                // 주문인
                var regExp = /^[가-힣]{2,}$/;
                var order = document.getElementById('order').value;
                
                if(!regExp.test(order)){
                    alert("'주문인' 부분이 잘못되었습니다. 다시 입력해 주세요.");
                    document.getElementById('order').focus();
                    return false;
                }

                var receipt = document.getElementById('receipt').value;
                // 받으시는 분
                if(!regExp.test(receipt)){
                    alert("'받으시는 분' 부분이 잘못되었습니다. 다시 입력해 주세요.");
                    document.getElementById('receipt').focus();
                    return false;
                }
                
                regExp = /^[0-9]{5}$/;
				
                
                // 주소
                /*
                // 우편번호
                var postcode = document.getElementById('postcode').value;
                if(!regExp.test(postcode)) {
                	alert("'우편번호' 부분이 잘못되었습니다. 다시 입력해 주세요.");
                	document.getElementById('postcode').focus();
                	return false;
                }
                */
                
                /*
                // 도로명 주소
                regExp = /^[가-힣0-9]{3,}$/;
                var roadAddress = document.getElementById('roadAddress').value;
                if(!regExp.test(roadAddress)) {
                	alert("'도로명주소' 부분이 잘못되었습니다. 다시 입력해 주세요.");
                	document.getElementById('roadAddress').focus();
                	return false;
                }
                */
                
                // 상세주소
                regExp = /^[가-힣0-9]{3,}$/;
                var detailAddress = document.getElementById('detailAddress').value;
                if(!regExp.test(detailAddress)) {
                	alert("'상세주소'' 부분이 잘못되었습니다. 다시 입력해 주세요.");
                	document.getElementById('detailAddress').focus();
                	return false;
                }
                
				
                // 휴대전화번호
                regExp = /^[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$/;
                var phone = document.getElementById('phone').value;
                
                if(!regExp.test(phone)) {
                    alert("휴대전화번호를 확인해 주세요.");
                    document.getElementById('phone').focus();
                    return false;
                }

                 // 카드 번호
                regExp = /^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$/;
                var cardNum = document.getElementById('cardNum').value;
               
                if(!regExp.test(cardNum)) {
                    alert("카드 번호를 확인해 주세요.");
                    document.getElementById('cardNum').focus();
                    return false;
                }


                // 카드 비밀번호
                regExp = /^\d{4}$/
                var cardPwd = document.getElementById('cardPwd').value;
                if(!regExp.test(cardPwd)) {
                    alert("카드 비밀번호를 확인해 주세요.");
                    document.getElementById('cardPwd').focus();
                    return false;
                }
            }

        </script>
        <!-- 장바구니 삭제 및 주문버튼 클릭시 jQuery 끝 -->
	
	<%@ include file="../common/main_end.jsp" %>

</body>
</html>