<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<c:forEach items="${articles}" var="article">
			<p>
			<h4>${article.title}</h4>
		${article.contents}<br>
			<br> ${article.pubName}【
		<fmt:formatDate pattern="yyyy-MM-dd" value="${article.pubDate}" />
		】
		<hr>
			</p>
		</c:forEach>
	</fieldset>
	<form action="${pageContext.request.contextPath}/article"
		style="text-align: center;" method="post">
		<input type="text" name="me" value="addUI" hidden="true"/>
		<input type="submit" value="发帖" />
	</form>
</body>
</html>