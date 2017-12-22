<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增页面</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$('#cancel').click(function() {
		window.location.href="${pageContext.request.contextPath}/admin/index"
	});
</script>
</head>
<body>
	<div class="container">
		<form id="add_form" action="<%=request.getContextPath() %>/product/mod" method="post">
			<div class="form-group">
				<label for="id">Id(编号):</label> 
				<input type="text" class="form-control"  name="id" value="${comp.id }" />
			</div>
			<div class="form-group">
				<label for="code">Code(型号):</label> 
				<input type="text" class="form-control"  name="code" value="${comp.code }" />
			</div>
			<div class="form-group">
				<label for="host">Host(主机):</label> 
				<input type="text" class="form-control" name="host" value="${comp.host }"/>
			</div>
			<div class="form-group">
				<label for="vision">Vision(显示器):</label> 
				<input type="text" class="form-control" name="vision" value="${comp.vision }" />
			</div>
			<div class="form-group">
				<label for="price">Price(价格):</label> 
				<input type="text" class="form-control" name="price" value="${comp.price }" />
			</div>
			<div class="form-group">
				<label for="date">ProduceDate(生产日期):</label> 
				<input type="text" class="form-control" name="date" value="${comp.date }" />
			</div>
			<input type="submit" class="btn btn-primary" value="提交">
			<button type="button" id="cancel" class="btn btn-primary" >返回</button>
		</form>
	</div>
</body>
</html>