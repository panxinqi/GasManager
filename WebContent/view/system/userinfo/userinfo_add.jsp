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

<script type="text/javascript">
//使用jquery validate
$(function() {
	$("#signupForm").validate({
		rules:{
			userAccount:{
				required:true,
			},
			userPwd:{
				required:true
			}
		},
		messages:{
			userAccount:{
				required:"用户名不能为空",
			},
			userPwd:{
				required:"密码不能为空"
			}
		
		}
		
	})
});
	
	
</script>
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
	<form id="signupForm" action="system/userAdd" method="post">
		<div class="header"><h1 class="page-title">添加用户</h1></div>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_top">系统管理</a> <span class="divider">/</span></li>
			<li><a href="view/system/userinfo/userinfo_list.jsp">用户管理</a> <span class="divider">/</span></li>
			<li class="active">添加用户</li>
		</ul>
	
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<button class="btn btn-primary" type="submit"><i class="icon-save"></i> 保存</button>
					<a href="system/userList" class="btn">返回上一级</a>
					<div class="btn-group"></div>
				</div>
				<!-- 获取session的值显示信息 -->
				<div  style="color:red" align="left">${info }</div>
				<div class="well">
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
							<label>余额</label> 
							<input type="text" name="balance"  value="${user.balance }" placeholder="金额" class="input-xsmall">
							<label>姓名</label> 
							<input type="text" name="userName"  value="${user.userName }" placeholder="请输入姓名" class="input-xsmall">
							<label>密码</label> 
							<input type="text" name="userPwd"  value="${user.userPwd }" placeholder="请输入密码" class="input-xsmall"> 
							<label>性别</label>
							<input type="radio" name="sex" value="男" ${user.sex eq '男' ? 'checked':'' } class="input-xsmall">男  
							<input type="radio" name="sex" value="女" ${user.sex eq '女' ? 'checked':'' } class="input-xsmall">女 
							<label>电话</label> 
							<input type="text" name="phone"  value="${user.phone }" placeholder="请输入电话号码" class="input-xsmall">
							<label>地址</label> 
							<input type="text" name="address"  value="${user.address }" placeholder="请输入电话号码" class="input-xsmall">
							
							<label>角色</label> 
							<select name="role" >
								<option value="普通用户" ${user.role eq '普通用户' ? 'selected':'' } >普通用户</option>
								<option value="抄表管理员" ${user.role eq '抄表管理员' ? 'selected':'' }>抄表管理员</option>
								<option value="超级管理员" ${user.role eq '超级管理员' ? 'selected':'' }>超级管理员</option>
							</select>
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