<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<script>
	$(function() {
		$.ajax({
			type: "Post",
			contentType:"application/json",
			url:"/IStore/category/findall",
			processData:false,
			dataType:"json",
			data:"{}",
			success: function(data) {
				append2Dom(data);
			}
		})
	})
	function append2Dom(list) {
		/* if (isNull(list)) {
			return
		}else { */
			var item = "";
			for (var i = 0; i < list.length; i++) {
				var temp = "<li><a>"+list[i].name+"</a> |</li>";
				item = item+temp;
			}
			$('#selectAll').empty();
			$('#selectAll').append(item);
		/* } */
	}
</script>
</head>
<body>
	<div class="container">
		<h2>商品后台管理</h2>
		<%= "欢迎您"+session.getAttribute("admin") %><br/>
		<ul class="nav">
			<li class="nav-item"><a class="nav-link" href="#">首页</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li>
		</ul>
		
	</div>
</body>
</html>