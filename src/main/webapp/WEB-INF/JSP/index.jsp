<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beginpagina</title>
<c:url var='cssUrl' value='/css/rules.css' />
<link rel="stylesheet" href="${cssUrl}">
<link rel="favicon" href="/images/favicon.ico">
</head>
<body>
	<c:url var='url' value='/images/intro.jpg'/>
	<header id="header" style="background-image: url(${url})"> 
	

	
	<p id="headerTitel">Wereldwijnen</p>
	<div id="vlaggen">

		<c:forEach var="i" begin="1" end="10">

			<c:url var='url' value='/images/${i}.png'/>
			<img src='${url}'>
		</c:forEach>

	</div>

	</header>
	
	<p>${land.naam}</p>
</body>
</html>