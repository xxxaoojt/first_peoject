<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<form action="${pageContext.request.contextPath}/article"
			method="post" style="text-align: center;">
			<input type="text" name="me" value="add" hidden="true" /> 标题：<input
				type="text" name="title" /><br> 内容：
			<textarea name="contents"></textarea>
			<br> 呢称：<input type="text" name="pubname" /><br> <input
				type="submit" value="发表" /> <input type="button" value="返回"
				onclick="javascript:history.go(-1)" />
		</form>
	</fieldset>
</body>
</html>