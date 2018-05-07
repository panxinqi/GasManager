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
	$(function(){
		$("#signupForm").validate();
		//选择费用明细
		$("#selected").click(function(){
			//获取第一个表格
			var tab1 = $("#tab1");
			//获取第二个表格(弹出层)中的选中的复选框    
			//获取选中的复选框的Id  返回数组
			var costIds = $("input[id=costId]:checked") 
			//alert(costIds.length);
			//遍历数组
			costIds.each(function(){
				//获取和复选框同级的td  拿到他的ID和name
				//this表示当前复选框 
				//找到tab2中tr下面的所有的TD  返回的是数组形式
				var td = $(this).parent().parent().find("td");
				
				tab1.append(
						"<tr><td>"+td[1].innerHTML+"<input type='hidden' name='costIds' value='"+td[1].innerHTML+"' ></td>"+
						"<td>"+td[2].innerHTML+"</td>"+
						"<td><input type='text' value='${gasList[0].gasPrice }' id='gasPrice' name='gasPrice' class='form-control' style='width:100px'></td>"+
						"<td><input type='text' name='' id='accountTotal' class='form-control'></td>"+
						"<td><a href='javascript:void(0)' class='btn btn-danger' onclick='del(this)' >删除</a></td>"+
						" </tr>");
						//给文本框绑定事件
						$("input[id=gasPrice]").blur(function(){
							var sum = 0;
							sum = $("input[id=gasPrice]").val()*($("input[id=count]").val());
							//给总金额赋值
							$("#accountTotal").val(sum);
						});
			});
			//选择之后隐藏弹出层
			$("#myModal").modal("hide");			
		});
		
		
		//给普通按钮绑定事件并提交表单
		$("#btn").click(function(){
			$("#accountStatus").val("0");
			//提交表单
			$("#signupForm").submit();
			
		});
	})

	//删除函数
	function del(obj){
		if(confirm("确定要删除费用吗？")){
			//获取tr
			var tr = $(obj).parent().parent();
			//删除选中的tr
			tr.remove();
			
			var sum = 0;
			$("input[id=money]").each(function(){
				sum+=parseFloat($(this).val());
			});
			
			$("#accountTotal").val(sum);
		}
	}
	
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
	<form id="signupForm" action="amount/amountAdd" method="post">
	
		<div class="header"><h1 class="page-title">抄表</h1></div>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_top">抄表管理</a> <span class="divider">/</span></li>
			<li class="active">录入计量</li>
		</ul>
	
		<div class="container-fluid">
			<div class="row-fluid">
				
				<!-- 获取session的值显示信息 -->
				<div  style="color:red" align="left">${info }</div>
				
				<h5 class="page-header alert-info" style="margin:0px;padding:10px;">基本信息</h5>
					<div class="well" style="margin:0px;">
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active in" id="home">
							<input type="hidden" class="form-control" value="${userinfo.userId }" name="userId" readonly />
							<lable>抄表人员：<input type="text" name="enterUserName" class="form-control" value="${userinfo.userName }" readonly/></lable><br/>
							
							<lable>&nbsp;&nbsp;&nbsp;用户名：<input type="text" name="userName" value="" class="form-control" placeholder="请输入用户名" /></lable><br/>
							<lable>用户用量：<input type="text" name="amount" id ="count" value="" class="form-control" placeholder="请输入用量" />升</lable><br/>
							<!-- <lable>燃气单价：<input type="text" name="price"  value=""  lass="form-control" placeholder="请输入单价" />RMB</lable><br/> -->
							<lable>抄表日期：<input type="text" name="month" value="" class="form-control" placeholder="请输日期" /></lable><br/>

							</div>
						</div>
					</div>
				</div>
				<h5 class="page-header alert-info" style="margin:0px;padding:10px;">
					<button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal">选择燃气类型</button>
				</h5>
					<table class="table" id="tab1" >
						<tr>
							<th>用户编号</th>
							<th>用户名称</th>
							<th>燃气单价</th>
							<th>总金额</th>
						</tr>
					</table>
					
					
					<!--弹出层界面 Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">燃气</h4>
					      </div>
					      <div class="modal-body">
								<table class="table" id="tab2">
									<tr>
										<th></th>
										<th>编号</th>
										<th>燃气名称</th>
										<th>燃气单价</th>
									</tr>
									<c:forEach items="${gasList }" var="gas">
										<tr>
											<td><input type="checkbox" id="costId" value="${gasId }" /></td>
											<td>${gas.gasId }</td>
											<td>${gas.gasName }</td>
											<td>${gas.gasPrice }</td>
										</tr>
									</c:forEach>
								</table>       
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					        <button type="button" class="btn btn-primary" id="selected">选择</button>
					      </div>
					    </div>
					  </div>
					</div>					
				
			<div class="btn-toolbar">
				<button class="btn btn-info" id="btn" type="submit">
				<i class="icon-save"></i> 保存提交</button>
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