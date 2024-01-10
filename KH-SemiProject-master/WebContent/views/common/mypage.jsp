<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>

 <style>

        
        #wrap{
            float: left;
            padding: 10px;
            width: 15%;
        }

        #nav{
            width: 100%;
            height: 1000px;
            padding: 15px;
        }

        .a{
            list-style: none;
        }

        #nav a{
            text-decoration: none;
            color : black;
        }

        #nav>ul>li {
            padding: 5px;
        }

        #nav>li {
            font-size: large;
            font-family: Verdana, Geneva, Tahoma, sans-serif;
        }

    </style>
</head>
<body>


    <div id="wrap">
        <nav id="nav">
            <li class="a">My정보</li>
            <ul>
                <li><a href="<%=contextPath%>/MyPageForm.me">조회 및 수정</a></li>
                <li><a href="<%=contextPath%>/deleteForm.me">회원탈퇴</a></li>
            </ul>
    
            <li class="a">My쇼핑</li>
            <ul>
                <li><a href="<%=contextPath%>/list.ba">장바구니</a></li>
                <li><a href="<%=contextPath%>/order.me">주문/배송 조회</a></li>
                <li><a href="<%=contextPath%>/cancellist.me">취소/반품 조회</a></li>
            </ul>
    
            <li class="a">My문의</li>
            <ul>
         
                <li><a href="<%=contextPath%>/inquiryForm.in?currentPage=1">1대1 문의</a></li>
            </ul>
    
    
        </nav>

  
</div>
</body>
</html>