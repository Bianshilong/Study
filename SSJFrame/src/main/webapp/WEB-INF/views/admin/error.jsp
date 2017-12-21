<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误页面</title>
</head>
<body>
	<!-- //实现数据验证功能 -->
	<form:form modelAttribute="admin_vo">
		<form:errors path="*"></form:errors>
	</form:form>
	${error_msg}
	<a href="${pageContext.request.contextPath }/admin/loginUI">点此重新登录</a>
</body>
</html>