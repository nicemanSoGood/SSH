<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px" cellspacing="0" width="1000px">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>学号</td>
			<td>手机号</td>
			<td>修改</td>
			<td>删除</td>
		</tr>
		<s:iterator value="list" var="l">
			<form action="student_update" method="post">
				<tr>
					<td><input type="text" name="sid" value="${l.sid }" onfocus=this.blur() /></td>
					<td><input type="text" name="sname" value="${l.sname }" /></td>
					<td><input type="text" name="snumber" value="${l.snumber }" /></td>
					<td><input type="text" name="sphone" value="${l.sphone }" /></td>
					<td><input type="submit" value="修改"/></td>
					<td><a href="student_delete?sid=${l.sid }">删除</a></td>
				</tr>
			</form>
		</s:iterator>
	</table>
</body>
</html>