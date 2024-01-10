<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>
<%	
	String contextPath = request.getContextPath(); // /jsp
	Member loginUser = (Member)session.getAttribute("loginUser");
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Insert title here</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
        div, form {
            box-sizing : border-box;
        }

        /* 전체를 감싸는 div */
        #header_2 {
            width : 600px;
            height : 250px;
            position: relative;
            margin-left: 25%;
        }
        /* 검색창 form에 대해서 속성 */
        #search_form {
            width : 80%;
            height: 20%;
            margin : auto;
            position: absolute;
            right: 0px;
            left : 0px;
            bottom: 0px;
            top : 0px;
        }

        /* 검색창 form 내부의 div 속성 */
        #search_form>div {
            height : 100%;
            float : left;
        }
        #search_text {
            width : 80%;
        }
        #search_btn {
            width : 20%;
        }

        /* input 태그들 늘려주기 */
        #search_form input {
            width : 100%;
            height : 100%;
        }
        #search_form button {
            width : 100%;
            height : 100%;
        }
    </style>
</head>
<body>
	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="<%=contextPath%>">북적북적</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                     <li class="nav-item"><a class="nav-link" href="<%=contextPath%>">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="<%=contextPath%>/PwdForm.me">MyPage</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%= contextPath %>/faqForm.fa">고객센터</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%= contextPath %>/noticeList.ad">공지사항</a></li>
                 
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Category</a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="<%= contextPath %>/main.mi?category=1">소설</a></li>
                            <li><a class="dropdown-item" href="<%= contextPath %>/main.mi?category=2">에세이</a></li>
                            <li><a class="dropdown-item" href="<%= contextPath %>/main.mi?category=3">역사</a></li>
                            <li><a class="dropdown-item" href="<%= contextPath %>/main.mi?category=4">과학</a></li>
                            <li><a class="dropdown-item" href="<%= contextPath %>/main.mi?category=5">정치</a></li>
                            <li><a class="dropdown-item" href="<%= contextPath %>/main.mi?category=6">로맨틱</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <form class="d-flex">
                <a href="<%= contextPath %>/list.ba" class="btn btn-outline-light" type="submit">
                    <i class="bi-cart-fill me-1"></i>
                    Cart
                    <span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                </a>&nbsp;&nbsp;&nbsp;
                
              <% if(loginUser == null) { %>
                <!-- 로그인 전 -->
                
	                <button class="btn btn-outline-light" type="button" onclick ="location.href = '<%= contextPath %>/loginForm.me'">
	                   
	                    Login
	                </button>
	            <!-- 로그인 후 -->
	            <% } else { %>
	            	<button class="btn btn-outline-light" type="button" onclick ="location.href = '<%= contextPath %>/logout.me'">
	                  
	                    Logout
	                </button>&nbsp;&nbsp;&nbsp;
	            	 <button style="color:withe;" class="btn btn-outline-light" type="button">
	                    <%=loginUser.getUserName() %>회원님 환영합니다.
	                </button>
	            <% } %>
	         
            </form>
        </div>
    </nav>
    <!-- Header-->
    <header>
        <div class="container px-4 px-lg-5 my-5">
            <div class="text-center text-white">
                <div class="container"> 
                    <a href="<%= contextPath%>/main.mi"><img src="/semi/resources/logo.png" title="로고" ></a>
                    <div id="header_2">
                        <form id="search_form">
                            <div id="search_text">
                                <input type="search" id="keyword" name="keyword">
                            </div>
                            <div id="search_btn">
                                <button class="btn btn-dark btn-block" type="button" style="padding: 0px;" onclick="bookSearch('keyword','','title');">검색</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
         <script>
        	var obj = {};
        	function bookSearch(type,category,sort) {
        		//ajax 
        		if(type != '') {
        			if(type == "keyword"){
        				obj.type = "keyword";
        				obj.keyword = $("#keyword").val();

            		}
            		else if(type == "new"){
            			obj.type = "new";

            		}
            		else if(type == "best"){
            			obj.type = "best";

            		}
            		else{
            			obj.type = "category";
            			obj.category = category;
            		}
        		}
        		obj.sort = sort;

        		$.ajax ({
        			
        			url : "productSearch.mi",
        			
        			data : obj,
        			
					success : function(list) {
						
						$("#mainSection").hide();
		        		
						$("#searchResult").show();
					
						var result = "";
                        
                    
						if(list.length != 0) {
							
							for(var i in list) { // for in
								
								result += "<tr>"
						                      + "<td style='width:16%;'><a href='<%= contextPath %>/productUserDetail.mi?bno="+list[i].bookNo +"'><img src='<%= contextPath %>/" + list[i].filePath + list[i].changeName + "' style='width:80%;'></td></a>"
						                      + "<td class='title' style='padding-top:8%;'><div>"+list[i].title +"</div><span style='font-size:0.7em;'>"+list[i].author +" | "+list[i].publisher +" | "+list[i].pblctDate +"</span></td>"
						                      + "<td class='price' style='padding-top:8%;'>"+list[i].price +"원</td>"
						                      + "<td style='padding-top:5%;'> "
						                      + "<a href='<%= contextPath %>/addBasket.ba?count=1&bno=" + list[i].bookNo + "' class='btn btn-outline-dark' style='padding-top:0px; padding-bottom:0px; width: 130px;'>장바구니 담기</a>"
						                      + "<br>"
			                                  + "<a href='<%= contextPath %>/buyNow.or?count=1&bno=" + list[i].bookNo + "' class='btn btn-outline-dark' style='padding-top:0px; padding-bottom:0px; width: 130px;'>바로구매</a>"
			                                  + "<br>"
			                                  + "<a href='<%= contextPath %>/productUserDetail.mi?bno="+list[i].bookNo +"&review=Y' class='btn btn-outline-dark' style='padding-top:0px; padding-bottom:0px; width: 130px;'>리뷰 보기</a></td>"
						                + "</tr>";
							}
						} else {
							result = "<tr><td>검색된 리스트가 없습니다.</td></tr>";
							
						}
						$("#searchTbody").html(result);
					},
					
					error : function() {
						console.log("검색결과용 ajax 실패");
					}
				});

			}
        </script>
            <!-- 알터 출력용 -->
		<script>
		
	
		
		var msg = "<%= alertMsg %>"; 
		
		if(msg != "null") { 
			alert(msg);
	
			<% session.removeAttribute("alertMsg"); %>
		}
	
	</script>
     
  </header>
</body>
</html>