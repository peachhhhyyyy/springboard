<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sp02 Index</title>
	</head>
	<body>
		<div style="text-align:center;">
			<h1>Sp02 Index</h1>
			<p>
				<a href="address/list.do">주소록 (with JDBC)</a><br>
				<a href="board/list.do">게시판 (with JDBC 미션)</a><br>
				<a href="address1/list.do">주소록1 (with myBatis)</a><br>
				<a href="address2/list.do">주소록2 (with myBatis - mapper 구현내용변경)</a><br>
				<a href="board1/list.do">게시판1 (with myBatis)</a>
			</p>
		</div>
	</body>
</html>