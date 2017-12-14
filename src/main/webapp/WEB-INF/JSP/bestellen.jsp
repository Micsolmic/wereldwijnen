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

<h1>Mandje</h1>
<c:url var='urlNaarIndex' value='/index.htm'/>
<a href='${urlNaarIndex}'><em>Terug naar overzicht</em></a><br><br>

<table id="mandjeOverzicht">
<tr><th>Wijn</th><th>Prijs</th><th>Aantal</th><th>Te betalen</th></tr>

<c:forEach var='bestelregel' items='${mandje.lijnen}'>
<tr><td>${bestelregel.wijn.soort.land.naam} ${bestelregel.wijn.soort.naam} ${bestelregel.wijn.jaar}</td><td><fmt:formatNumber value='${bestelregel.wijn.prijs}' minFractionDigits='2'
maxFractionDigits='2'/></td><td>${bestelregel.aantal}</td><td>${bestelregel.wijn.prijs * bestelregel.aantal}</td></tr>
</c:forEach>
<tr><td colspan='3'></td><td id="grandTotal">Totaal: ${mandjeTotaal}</td></tr>
</table>
<br>
<form method="post">

<label>Naam <br> <input name="naam" value="${param.naam}"/></label><span class="invoerfout">${fouten.naam}</span><br>
<label>Straat <br> <input name="straat" value="${param.straat}"/></label><span class="invoerfout">${fouten.straat}</span><br>
<label>Huisnummer <br> <input name="huisnummer" value="${param.huisnummer}" /></label><span class="invoerfout">${fouten.huisnummer}</span><br>
<label>Postcode <br> <input name="postcode" value="${param.postcode}" /></label><span class="invoerfout">${fouten.postcode}</span><br>
<label>Gemeente <br> <input name="gemeente" value="${param.gemeente}"/></label><span class="invoerfout">${fouten.gemeente}</span><br><br>

<input type="radio" id="afhalen" name="bestelwijze" value="0" checked><label for="afhalen">Afhalen</label><br>
<input type="radio" id="opsturen" name="bestelwijze" value="1"><label for="opsturen">Opsturen</label>
<br><br>
<button id="submitknop" type="submit">Als bestelbon bevestigen</button>

</form>

</body>
<script>

var knop = document.getElementById("submitknop");
knop.onsubmit = function(){
	
	knop.disabled = true;
	
	
};


</script>
</html>