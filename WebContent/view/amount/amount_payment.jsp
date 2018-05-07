<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>   

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>" />
<meta charset="utf-8">
<title>生成交费单</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="resources/lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/stylesheets/theme.css">
<link rel="stylesheet" href="resources/lib/font-awesome/css/font-awesome.css">
<script src="resources/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="resources/jQueryvalidate/dist/jquery.validate.js" type="text/javascript"></script>
<style type="text/css">
	#line-chart {height: 300px;width: 800px;margin: 0px auto;margin-top: 1em;}
	.brand {font-family: georgia, serif;}
	.brand .first { color: #ccc; font-style: italic; }
	.brand .second { color: #fff; font-weight: bold; }
	.error{ color:red; }
</style>
</head>
<body class="">
	<form id="signupForm" action="amount/amountToPayment" method="post">
		<!-- 设置隐藏文本框 报销单编码-->
		<input type="hidden" name="payId" value="${payment.payId }">
		<!-- 设置隐藏文本框 获取用户ID 也就是userId 从session中获取-->
		<input type="hidden" name="userId" value="${userinfo.userId }">
	 
	
		<div class="header"><h1 class="page-title">生成交费单</h1></div>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_top">抄表管理</a> <span class="divider">/</span></li>
			<li class="active">生成交费单</li>
		</ul>
	
		<div class="container-fluid">
			<div class="row-fluid">
				<!-- 获取session的值显示信息 -->
				<div  style="color:red" align="left">${topaymentInfo }</div>
				
				<h5 class="page-header alert-info" style="margin:0px;padding:10px;">缴费信息</h5>
					<div class="well" style="margin:0px;">
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active in" id="home">
								<lable>缴费单编号 ：${payment.payId } </lable><br/>
								<lable>总金额：${payment.payMoney }RMB</lable><br/>
								<lable>燃气用量：${amount.amount }升</lable><br/>
								<lable>月份：${amount.month }</lable><br/>
								<lable>状态：${payment.payMark }</lable><br/>
							</div>
						</div>
					</div>
					
					<h5 class="page-header alert-info" style="margin:0px;padding:10px;">用户信息</h5>
					<div class="well" style="margin:0px;">
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active in" id="home">
								<lable>用户名 ：${user.userName } </lable><br/>
								<lable>手机号：${user.phone }</lable><br/>
								<lable>地址：${user.address }</lable><br/>
	
							</div>
						</div>
					</div>
					
					<h5 class="page-header alert-info" style="margin:0px;padding:10px;">燃气信息</h5>
					<div class="well" style="margin:0px;">
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active in" id="home">
								<lable>燃气编号 ：${gs.gasId } </lable><br/>
								<lable>燃气名称：${gs.gasName }</lable><br/>
								<lable>燃气单价：${gs.gasPrice }</lable><br/>
	
							</div>
						</div>
					</div>
				</div>

			<div class="btn-toolbar">
				<a href="amount/amountList" class="btn btn-primary">返回上一级</a>
				
				<button class="btn btn-info" type="submit" >
				<i class="icon-save"></i> 生成交费单</button>
			</div>	
					
			<footer>
				<hr>
				<p class="pull-right">老潘<a href="" title=""target="_blank"></a></p>
				<p>&copy; 2017 <a href="#" target="_blank">老潘</a></p>
			</footer>
		</div>
	</form>

	<script src="resources/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>
</body>
</html>