<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
<html>
<head>
<base href="<%=basePath%>" />
    <meta charset="utf-8">
    <title>员工管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="resources/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="resources/stylesheets/theme.css">
    <link rel="stylesheet" href="resources/lib/font-awesome/css/font-awesome.css">
    <script src="resources/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
</head>
<body>
		<div class="header">
			<h1 class="page-title">工作台</h1>
		</div>
		<ul class="breadcrumb">
			<li><a href="right.jsp">系统管理</a> <span class="divider">/</span></li>
			<li class="active">首页</li>
		</ul>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="row-fluid">
					<div class="block">
						<div id="page-stats" class="block-body collapse in">
							<div class="stat-widget-container">
								<h1 style="color:black">欢迎来到天然气气收费管理系统</h1>
							</div>
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="block span12">
						<a href="#widget1container" class="block-heading"
							data-toggle="collapse">系统简介 </a>
						<div id="widget1container" class="block-body collapse in">
							<p style="font-size:18px"><br/>
							  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;燃气公司在不断扩大营业规模和增加服务方式的今天，更加需要一套全面完善的业务管理系统，
							提高企业自身的管理方式，更好地服务于社会。现代科学技术的不断提高，计算机科学技术日渐成熟，
							计算机在现实社会中的强大功能已经为人们所深刻认识，它已经进入人类社会的各个领域并发挥着越来越重要的作用。
							信息技术的发展使得整个世界越来越小，这也意味着企业的竞争环境由区域化向全球化发展，由于信息管理在社会大生产中占有重要地位，
							其计算机化在发达国家已达到95%以上，在我国也达到了广泛的应用。计算机的出现和普及，为信息处理提供了物美价廉的手段，
							对于推动我国管理信息处理现代化起到了重要作用。<p/>
							  <p style="font-size:18px">   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							  本系统就是针对这个开发的一个小型的天然气气费收费管理系，主要目的是可以实现用户基本信息档案及用户计量表的设置和管理，
							抄表的管理；方便操作员快速录入每月的表读数和用气量等数据。实现一般的收费功能。以此满足一般的天然气公司或物业管理等部
							门的需要。</p>
						</div>
					</div>
				</div>
				<footer>
					<hr>
				</footer>
			</div>
		</div>
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