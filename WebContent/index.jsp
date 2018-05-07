<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>天然气气费管理系统</title>
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
                <ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"><img src=""></i> ${userinfo.userName } 
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="view/system/userinfo/userinfo_view.jsp" target="rightmain">个人信息</a></li>
                            <!--  <li><a tabindex="-1"  href="#">密码修改</a></li>-->
                            <li><a tabindex="-1" href="login.jsp">退出系统</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="index.jsp"><span class="first">新奇</span> <span class="second">天然气气费管理系统</span></a>
        </div>
    </div>
    <div class="sidebar-nav">
    	<a href="right.jsp" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>我的工作台<i class="icon-chevron-up"></i></a>
        
        <c:forEach items="${mlist }" var="menu" varStatus="s">
        	<c:if test="${menu.superId == 0 }">
        		 <!-- 列表父级菜单 -->
	             <a href="#dashboard-menu${s.index }" class="nav-header" data-toggle="collapse"><i class="icon-dashboard">
	             </i>${menu.mName }<i class="icon-chevron-up"></i></a>
		         <!-- 列表子菜单 --><!-- 使用s.index  使ID的值不一样 -->
		         <ul id="dashboard-menu${s.index }" class="nav nav-list collapse">
		           <c:forEach items="${mlist }" var="me">
			           	<c:if test="${menu.mId == me.superId }">
			            	<li><a href="${me.mUrl }" target="rightmain">${me.mName }</a></li>
			            </c:if>
		            </c:forEach>
		         </ul>
        	</c:if>
		</c:forEach>
       
        <a href="help.jsp"  target="rightmain" class="nav-header" ><i class="icon-question-sign"></i>帮助说明</a>
        <a href="login.jsp" class="nav-header" ><i class="icon-comment"></i>退出系统</a>
    </div>
    <div class="content" >
    <iframe src="right.jsp" name="rightmain" id="iframe" frameborder="0" ></iframe>
	</div>
    <script src="resources/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
        
        $(function(){
        	$("#iframe").attr("width",$(window).width()-245);
        	$("#iframe").attr("height",$(window).height()+100);
        });
    </script>
    
  </body>
</html>