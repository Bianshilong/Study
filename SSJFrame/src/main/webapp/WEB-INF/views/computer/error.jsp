<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息错误页面</title>
</head>
<body>
	<!-- 数据验证，输入的数据未通过验证，在此页面显示 -->
	很抱歉，您输入的信息不符合要求！！！！<br/>
	<c:forEach var="err" items="${list }">
		${err.defaultMessage}<br/>
	</c:forEach>
	<a href="<%= request.getContextPath()%>/product/addUI">点此重新输入</a>
</body>
</html>
