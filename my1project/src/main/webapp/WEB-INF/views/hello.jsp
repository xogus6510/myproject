<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="resources/jquery-3.6.0.min.js"></script>

		<script src="mybatis_spring.js" defer></script>
		<!--css 경로-->
		<link rel="stylesheet" href="css/main.css">

		<script type="text/javascript">
			$(document).ready(function () {
				//jquery code
			});
		</script>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	</head>

	<body>
		<div id="aa">${model}</div>
	</body>

	</html>