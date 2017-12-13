<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
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

<h1>Wijn toevoegen aan mandje</h1>
<c:url var='urlNaarIndex' value='/index.htm'/>
<a href='${urlNaarIndex}'><em>Terug naar overzicht</em></a><br><br>

<table id="wijnInfo">
<tr><td>Land</td><td>${wijn.soort.land.naam}</td></tr>
<tr><td>Soort</td><td>${wijn.soort.naam}</td></tr>
<tr><td>Jaar</td><td>${wijn.jaar}</td></tr>
<tr>

<td>Beoordeling</td>
<td>
<c:forEach var='i' begin='1' end='${wijn.beoordeling}'>&#9733</c:forEach>
</td>
</tr>
<tr><td>Prijs</td><td><fmt:formatNumber value='${wijn.prijs}' minFractionDigits='2'
maxFractionDigits='2'/></td></tr>

</table>

<form method="post">
<label>
<br>
Aantal flessen <br>
<input name="flessen">
<input type="hidden" name="wijnid" value="${wijn.id}">
</label><span class="fout">${fout}</span>
<br>
<button type="submit">Toevoegen</button>

</form>

</body>
</html>