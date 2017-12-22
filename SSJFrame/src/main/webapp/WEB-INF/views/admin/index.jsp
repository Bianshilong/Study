<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品后台管理页面</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<!-- javascript的方式 -->
<script type="text/javascript">
	//新增按钮
	function Add() {
		window.location.href="${pageContext.request.contextPath}/product/addUI";
	}
	//修改按钮
	function Mod() {
		var ids = [];
		$('#mytable :input:checked').each(function() {
			ids.push($(this).val());
		});
		if (ids.length==0 || ids.length>1) {
			alert("请选择一条记录更新！")
		}else{
			id = ids[0];
			window.location.href="${pageContext.request.contextPath}/product/getone/"+id;
		}
	}
	//查询所有
	function All(){
		window.location.href="${pageContext.request.contextPath}/product/getall";
	}
	//删除按钮
	function Del() {
		var ids = [];
		$('#mytable :input:checked').each(function() {
			ids.push($(this).val());
		});
		if (ids.length==0) {
			alert("您未选择记录，请选择后再删除！")
		}else{
			var list = "";
			for (var i = 0; i < ids.length-1; i++) {
				list = list+ids[i]+","
			}
			list = list+ids[ids.length-1];
			window.location.href="${pageContext.request.contextPath}/product/del/"+list;
		}
	}
	/* $(function() {
		window.location.href = "${pageContext.request.contextPath}/product/getall";
	}); */
	function goback() {
		var flag = confirm("是否确定退出");
		if (flag) {
			window.location.href="${pageContext.request.contextPath}/admin/quit";
		}
	}
</script>
</head>

<body>
	<div class="container">
		<h2>商品后台管理</h2>
		<%= "欢迎您"+session.getAttribute("admin") %><button id ="quit" onclick="goback()">退出</button><br/>
		<ul class="nav">
			<li class="nav-item"><a class="nav-link" href="#">首页</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li>
		</ul>
		<div>
			<ul>
				<%-- <li><a href ="<%= request.getContextPath()%>/product/addUI">新增商品</a></li>
				<li><a href ="<%= request.getContextPath()%>/product/getone/{id}">修改商品</a></li>
				<li><a>删除商品</a></li>
				<li><a href ="<%= request.getContextPath()%>/product/getall">所有商品</a></li> --%>
				<li><button id="add_pro" onclick="Add()" >新增商品</button></li>
				<li><button id="mod_pro" onclick="Mod()" >修改商品</button></li>
				<li><button id="del_pro" onclick="Del()" >删除商品</button></li>
				<li><button id="all_pro" onclick="All()">所有商品</button></li>
			</ul>
		</div>
		<div>
			<table id="mytable" border="1" cellspacing="0">
				<tr>
					<th>选择</th>
					<th>型号</th>
					<th>主机</th>
					<th>显示器</th>
					<th>价格</th>
					<th>生产日期</th>
				</tr>
				<c:forEach var="comp" items="${list }">
					<tr>
						<td>
							<input type="checkbox" id ="ids" value="${comp.id }" />
						</td>
						<td>${comp.code}</td>
						<td>${comp.host}</td>
						<td>${comp.vision}</td>
						<td>${comp.price}</td>
						<td>${comp.date}</td>
					</tr>	
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>