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

<h1>Mandje</h1>
<c:url var='urlNaarIndex' value='/index.htm'/>
<a href='${urlNaarIndex}'><em>Terug naar overzicht</em></a><br><br>

<table id="mandjeOverzicht">
<tr><th>Wijn</th><th>Prijs</th><th>Aantal</th><th>Te Betalen</th></tr>

<c:forEach var='bblijn' items='${mandje.lijnen}'>
<tr><td>${bblijn.wijn}</td><td>placeholder</td><td>placehodler</td><td>placeholder</td></tr>
</c:forEach>

</table>

</body>
</html>