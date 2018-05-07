<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	//获取绝对路径路径 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort()+ path + "/";
%> 
<!-- 引入分页标签 -->
<%@taglib prefix="d" uri="http://displaytag.sf.net" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
    <meta charset="utf-8">
    <title>抄表列表</title>
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
  <form action="" method="post">
        <div class="header">
            <h1 class="page-title">缴费查询</h1>
        </div>
        <ul class="breadcrumb">
            <li><a href="javascript:void(0)">费用管理</a> <span class="divider">/</span></li>
            <li class="active">缴费查询</li>
        </ul>

        <div class="container-fluid">
	        <div class="row-fluid">
			<!-- 年月份查询：<input type="text" name="amount.month" placeholder="年月份" />
			  <input type="submit" class="btn btn-info" style="margin-bottom:9px" value="查询"/> -->
			 <!-- 提示信息！ -->
			   <div style="color:red" align="center">${payinfo }</div> 
			   
				<div class="well" style="background-color: white;">
				  	<d:table class="table" name="list" pagesize="10" requestURI="pay/paymentList">
				  		<d:column title="交费单号" property="payId" /> 
				  		<d:column title="缴费金额" property="payMoney" style="color:red"/> 
				  		<d:column title="总用量" property="amount.amount" /> 
				  		<d:column title="年月份" property="amount.month" /> 
				  		<d:column title="缴费状态" property="payMark" /> 
				  		
				  		<d:column title="我要缴费" value="我要缴费" href="pay/paymentPayMoney" paramId="payId" paramProperty="payId" />
				  	</d:table>
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