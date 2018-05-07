<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	//获取绝对路径路径 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort()+ path + "/";
%> 
<!-- 引入分页标签 -->
<%@taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
    <meta charset="utf-8">
    <title>历史账单</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="resources/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="resources/stylesheets/theme.css">
    <link rel="stylesheet" href="resources/lib/font-awesome/css/font-awesome.css">
    <script src="resources/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="resources/js/highcharts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.highchartTable.js"></script>
    
<script type="text/javascript">
	$(document).ready(function() {
		  $('table.highchart').highchartTable();
	});
</script>
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
        #home{
        	display:block;
        	width:50%;
        	float:left;
        }
         #home2{
        	display:block;
        	width:50%;
        	float:left;
        }
        #home3{
        	display:block;
        	width:100%;
        	float:left;
        }
    </style> 
	
  </head>
  <body > 
  <form action="" method="post">
        <div class="header">
            <h1 class="page-title">历史账单</h1>
        </div>
        <ul class="breadcrumb">
            <li><a href="javascript:void(0)">费用管理</a> <span class="divider">/</span></li>
            <li class="active">历史账单</li>
        </ul>

        <div class="container-fluid">
	        <div class="row-fluid">
			   <div style="color:red" align="center">${payinfo }</div> 
			   
				<div class="well" style="background-color: white;">
				  	<d:table class="table" name="list" pagesize="10" requestURI="pay/paymentHist">
				  		<d:column title="交费单号" property="payId" /> 
				  		<d:column title="单据所属年月" property="amount.month" /> 
				  		<d:column title="缴费日期" property="payment.payDate"/> 
				  		<d:column title="缴费金额" property="payment.payMoney" style="color:red"/> 
				  		<d:column title="缴费状态" property="payment.payMark" /> 
				  		
				  		<d:column title="查看详情" value="查看详情" href="pay/paymentHistDetail" paramId="payId" paramProperty="payId" />
				  	</d:table>
				</div>
				
				<div class="header">
		            <h3 class="page-title">历史缴费图表</h3>
		        </div>
				<div class="tab-pane active in" id="home">
					<div id="tab">
						<table class="highchart" style="display:none" data-graph-container-before="1" data-graph-height="400" data-graph-type="pie" >
							<thead>
								<tr>
									<th>年月</th>
									<th>缴费金额(单位：RMB)</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list }" var="each">
									<tr>
										<td>${each.amount.month }</td>
										<td>${each.payment.payMoney }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="tab-pane active in" id="home2">
					<!--  
						data-graph-container-before="1"  报表容器
						data-graph-height="500"    报表高度
						data-graph-type="line"     类型 
						column表示一个柱形图   line 表示折线图    area区域  spline 曲线图  pie饼状图
					 -->
					<div id="tab">
						<table class="highchart" style="display:none" data-graph-container-before="1" data-graph-height="400" data-graph-type="column" >
							<thead>
								<tr>
									<!-- 第一行表示的是X轴的信息 -->
									<th>月份</th>
									<!-- 代表的是报表的个方面的信息 -->
									<th>缴费金额(单位：RMB)</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list }" var="each">
									<tr>
										<td>${each.amount.month }</td>
										<td>${each.payment.payMoney }</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
					</div>
				</div>
				<div class="header">
		            <h3 class="page-title">历史用量折线图</h3>
		        </div>
				<div class="tab-pane active in" id="home3">
					<div id="tab">
						<table class="highchart" style="display:none" data-graph-container-before="1" data-graph-height="400" data-graph-type="line" >
							<thead>
								<tr>
									<th>年月</th>
									<th>用量(单位：升)</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list }" var="each">
									<tr>
										<td>${each.amount.month }</td>
										<td>${each.amount.amount }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				
	            <footer>
	                <hr>
	                <p class="pull-right">老潘 <a href="" title="" target="_blank"></a></p>
	                <p>&copy; 2017 <a href="#" target="_blank">老潘</a></p>
	            </footer>
	         </div>
        </div>
	 </form>
  
    <script src="resources/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
   
  </body>
</html>