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
    <title>用户列表</title>
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
  <body > 
  <form action="system/userList" method="post">
  
        <div class="header">
            <h1 class="page-title">用户管理</h1>
        </div>
        <ul class="breadcrumb">
            <li><a href="javascript:void(0)">系统管理</a> <span class="divider">/</span></li>
            <li class="active">用户管理</li>
        </ul>

        <div class="container-fluid">
	        <div class="row-fluid">
				<div class="btn-toolbar">
				 <a href="#myqueryModal" role="button" data-toggle="modal"
				 	   class="btn btn-info">查询用户</a>
				 	   
			<c:if test="${userinfo.role eq '超级管理员' ? true:false }">
				  <a href="view/system/userinfo/userinfo_add.jsp" class="btn btn-primary">
				  		<i class="icon-plus"></i>添加用户</a>
			</c:if>
			
				  <div class="btn-group"></div>
				</div>
				<div style="color:red" align="center">${info }</div>
				<div class="well" style="background-color: white;">
				  	<d:table class="table" name="list" pagesize="10" requestURI="system/userList">
				  		<d:column title="编号" property="userId"></d:column>
				  		<d:column title="姓名" property="userName"></d:column>
				  		<d:column title="性别" property="sex"></d:column>
				  		<d:column title="电话" property="phone"></d:column>
				  		<d:column title="地址" property="address"></d:column>
				  		<d:column title="角色" property="role"></d:column>
				  	
					  	<c:if test="${userinfo.role eq '超级管理员' ? true:false }">
					  		<d:column title="" href="system/userUpdate" paramId="userId" paramProperty="userId" value="<i class='icon-pencil'>"></d:column>
					  		<d:column title="" href="system/userDel"    paramId="userId" paramProperty="userId" value="<i class='icon-remove'>"></d:column> 
					  	</c:if>
				  	</d:table>
				</div>
				
				
				
				
				<!-- 查询弹出框 -->
				<div class="modal small hide fade" id="myqueryModal" style="top:30%" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				    <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				        <h3 id="myModalLabel">查询条件</h3>
				    </div>
				    <div class="modal-body">
				        <div class="tab-pane active in" id="home">
							<label>姓名</label> 
							<input type="text" name="userName"class="input-xlarge"> 
							<label>地址</label> 
							<input type="text" name="address" class="input-xlarge"> 
						</div>
				    </div>
				    <div class="modal-footer">
				        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
				        <input type="submit"  class="btn btn-danger" value="查询" />
				    </div>
				</div>
				
	            <footer>
	                <hr>
	                <p class="pull-right">老潘 ${userinfo.role }<a href="" title="" target="_blank"></a></p>
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