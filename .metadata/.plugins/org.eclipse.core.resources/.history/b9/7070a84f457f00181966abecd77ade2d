<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAOMybatis"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardList</title>
</head>
<body>
<h1>Message Board</h1>
<h3>${userName }!!! Welcome to board ^_^
<a href="logout.do">logout</a>
</h3>
<!-- search start -->
<form action = "boardList.do" method="post">
<table border = "1px">
	<tr>
		<td width="300">
		<select name="searchCondition">
		<c:forEach items="${conditionMap }" var="option">
			<option value="${option.value }">${option.key }
		</c:forEach>
		</select>
		<input type="text" name="searchKeyword">
		<input type="submit" name="search">
		</td>
	</tr>
	<tr>
		<th bgcolor="lightblue" width="100">num</th>
		<th bgcolor="lightblue" width="250">sub</th>
		<th bgcolor="lightblue" width="100">writer</th>
		<th bgcolor="lightblue" width="100">date</th>
		<th bgcolor="lightblue" width="100">count</th>
	</tr>
		<c:forEach items="${boardList }" var="board">
		<tr>
			<td>${board.seq}</td>
			<td>
			<a href="getBoard.do?seq=${board.seq}">
			${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.regDate}</td>
			<td>${board.cnt}</td>
		</tr>
		</c:forEach> 
</table>
</form>
	<a href="insertBoard.jsp">write new content</a>
</body>
</html>