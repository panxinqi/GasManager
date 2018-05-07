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
    <title>登录</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="resources/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="resources/stylesheets/theme.css">
    <link rel="stylesheet" href="resources/lib/font-awesome/css/font-awesome.css">
    <script src="resources/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
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
    </style>
</head>
 <body class=""> 
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right"> </ul>
                <a class="brand" href="index.html"> <span class="second">天然气气费收费管理系统</span></a>
        </div>
    </div>
    
 <div style="color:red" align="center">${logininfo }</div>
 
 <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">用户登录</p>
            <div class="block-body">
                <form action="system/login" method="post">
                    <label>帐号</label>
                    <input type="text" name="userName" class="span12">
                    <label>密码</label>
                    <input type="password" name="userPwd" class="span12">
                   <input type="submit" class="btn btn-primary pull-right" value="登录">
              
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
    </div>
</div>
 
</body>
</html>