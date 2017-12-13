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
		
		<c:url var='urlAnchor' value=''><c:param name='landid' value='${i}'/></c:url>
		<a href='${urlAnchor}'>
		
		<c:url var='urlImage' value='/images/${i}.png'/>
			<img src='${urlImage}'>
		
		
		</a>
			
		</c:forEach>
	<c:if test='${not empty mandje}'>
	<c:url var='naarMandjeUrl' value='/bestellen.htm'/>
	<c:url var='mandjeLogoUrl' value='/images/mandje.png'/>
	<div id="mandjeLogoContainer">
	<a href='${naarMandjeUrl}'>
	<img src='${mandjeLogoUrl}'/>
	</a>	
	</div>
	</c:if>
	<p></p>
	</div>

	</header>
	<c:if test='${not empty land}'>	
	
		<h2>Soorten uit ${land.naam}</h2>
	<c:forEach var='soort' items='${land.soorten}'>
	<c:url value='' var='url'>
	<c:param name='landid' value='${land.id}'/>
	<c:param name='soortid' value='${soort.id}'/>
	</c:url>
	<a href='${url}'>${soort.naam}</a>
	</c:forEach>	
	
	</c:if>
	
	<c:if test='${not empty gekozenSoort}'>
	<ul>
	<c:forEach var='wijn' items='${gekozenSoort.wijnen}'>
	
	<li>
	<c:url var='wijnUrl' value='/wijntoevoegen.htm'>
	<c:param name='wijnid' value='${wijn.id}'/>
	</c:url>
	<a href='${wijnUrl}'>	
	${wijn.jaar}
	<c:forEach var='i' begin='1' end='${wijn.beoordeling}'>
	&#9733	
	</c:forEach>	
	</a>	
	</li>
	
	
	</c:forEach>
	
	
	</ul>
	
	
	</c:if>

</body>
</html>