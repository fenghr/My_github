<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0">
	<input type="hidden" value="${pageContext.request.contextPath}" id="path" />
		<tr>
			<td>info_id</td>
			<td>typeid</td>
			<td>source</td>
			<td>title</td>
			<td>content</td>
			<td>memo</td>
			<td>creatorid</td>
			<td>create_time</td>
		</tr>
		<c:forEach items="${list }" var="v">
			<tr>
				<td>${v.info_id }</td>
				<td>${v.typeid }</td>
				<td>${v.source }</td>
				<td>${v.title }</td>
				<td>${v.content }</td>
				<td>${v.memo }</td>
				<td>${v.creatorid }</td>
				<td>${v.create_time }</td>
			</tr>
		</c:forEach>

	</table>
<form action="" id="form" method="post"></form>
	<input type="button"  onclick="fun();" value="导出">
	<script type="text/javascript">
		function fun(){
			var path = document.getElementById("path").value;
			var form2 = document.getElementById("form");
			form2.action = path+"/queryexc";
			$("#form").submit();
		}
	</script>
	<input type="button" onclick="" value="导入">
</body>
</html>