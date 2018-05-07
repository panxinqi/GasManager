<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>   
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>" />
<meta charset="utf-8">
<title>Bootstrap Admin</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="resources/lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/stylesheets/theme.css">
<link rel="stylesheet" href="resources/lib/font-awesome/css/font-awesome.css">
<script src="resources/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="resources/jQueryvalidate/dist/jquery.validate.js" type="text/javascript"></script>

<!-- Demo page code -->
<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
.error{
	color:red;
}
</style>
</head>
<body class="">
	<form  action="system/userViewUpdate" method="post">
		<!-- 一定注意获取session中的userId 否则查找不到这个用户 -->
		<input type="hidden" name="userId" value="${userinfo.userId }"/>
		<div class="header"><h1 class="page-title">个人信息</h1></div>
		
		<ul class="breadcrumb">
		<!--使超链接失效  -->
			<li><a href="javascript:void(0)" target="_top">系统管理</a>
			 <span class="divider">/</span></li>
			<li class="active">个人信息</li>
		</ul>
	
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<button class="btn btn-primary" type="submit">
						<i class="icon-save"></i> 修改
					</button>
				</div>
				
				<div style="color:red" align="left">${myinfo }</div>
				
				<div class="well">
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
							<label>角色：${userinfo.role }</label>  <br/>
							<label>性别： ${userinfo.sex }</label>  <br/>
							<label style="color:red" >可用余额：${userinfo.balance }RMB</label>  <br/>
							
							<label>姓名</label> 
							<input type="text" name="userName"  value="${userinfo.userName }" placeholder="尚未填写" class="input-xsmall">
							<label>密码</label> 
							<input type="text" name="userPwd"  value="${userinfo.userPwd }" placeholder="尚未填写" class="input-xsmall"> 
							<label>地址</label> 
							<input type="text" name="address" value="${userinfo.address }" placeholder="尚未填写" class="input-xsmall">
							<label>电话</label> 
							<input type="text" name="phone"  value="${userinfo.phone }" placeholder="尚未填写" class="input-xsmall">
							
						</div>
					</div>
				</div>
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