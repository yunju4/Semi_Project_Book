<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.admin.product.model.vo.BookMaster" %>
<%
	ArrayList<BookMaster> bml = (ArrayList<BookMaster>)request.getAttribute("bml");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        
        <%@ include file="../common/admin_top.jsp" %>
        
        	 <div>
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">관리자 메인 페이지</h1>
                        
                        
                        <div class="row">
                            <div class="col">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                       		 판매 수량
                                    </div>
                                    <div class="card-body"><canvas id="myAreaChart" width="100%" height="40"></canvas></div>
                                </div>
                            </div>
                        </div>
                        
                        <script>
                        // Area Chart Example
						var ctx = document.getElementById("myAreaChart");
						var myLineChart = new Chart(ctx, {
						  type: 'bar',
						  data: {
						    labels: ["<%= bml.get(0).getTitle() %>", "<%= bml.get(1).getTitle() %>", "<%= bml.get(2).getTitle() %>", "<%= bml.get(3).getTitle() %>", "<%= bml.get(4).getTitle() %>"],
						    datasets: [{
						      label: "Sessions",
						      lineTension: 0.1,
						      backgroundColor: "rgba(2,117,216,0.2)",
						      borderColor: "rgba(2,117,216,1)",
						      pointRadius: 5,
						      pointBackgroundColor: "rgba(2,117,216,1)",
						      pointBorderColor: "rgba(255,255,255,0.8)",
						      pointHoverRadius: 5,
						      pointHoverBackgroundColor: "rgba(2,117,216,1)",
						      pointHitRadius: 50,
						      pointBorderWidth: 2,
						      data: [<%= bml.get(0).getSaleCount() %>, <%= bml.get(1).getSaleCount() %>, <%= bml.get(2).getSaleCount() %>, <%= bml.get(3).getSaleCount() %>, <%= bml.get(4).getSaleCount() %>],
						    }],
						  },
						  options: {
						    scales: {
						      xAxes: [{
						        time: {
						          unit: 'date'
						        },
						        gridLines: {
						          display: false
						        },
						        ticks: {
						          // maxTicksLimit: 7
						        }
						      }],
						      yAxes: [{
						        ticks: {
						          min: 0,
						          max: 30,
						          maxTicksLimit: 5
						        },
						        gridLines: {
						          color: "rgba(0, 0, 0, .125)",
						        }
						      }],
						    },
						    legend: {
						      display: false
						    }
						  }
						});
						
                        </script>
                        
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                	매출 순위
                            </div>
                            <div class="card-body" style="text-align:center">
                                <table id="datatablesSimple">
                               	
                               	<thead>
                               		<tr class="bookList">
                               			<th class="title" width="70">순위</th>
				                            <th class="title">책 제목</th>
				                            <th class="count" width="130">총 판매 수량</th>
				                            <th class="price" width="130">총 판매 가격</th>
				                        </tr>
                               	</thead>
                               	
                                <tbody>
                                	<% if(bml.isEmpty()) { %>
			                        	<tr>
					                		<td colspan="3">조회된 리스트가 없습니다.</td>
					                	</tr>
			                        <% } else { %>
			                        	<% for(int i = 0; i < bml.size(); i++) { %>
				                        <tr class="bookList">
				                        	<td class="title"><%= i + 1 %></td>
				                            <td class="title"><%= bml.get(i).getTitle() %></td>
				                            <td class="count"><%= bml.get(i).getSaleCount() %>권</td>
				                            <td class="price"><%= bml.get(i).getPrice() %>원</td>
				                        </tr>
			                       		<% } %>
			                       	<% } %>
                                </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        
        <%@ include file="../common/admin_end.jsp" %>
    </body>
</html>
