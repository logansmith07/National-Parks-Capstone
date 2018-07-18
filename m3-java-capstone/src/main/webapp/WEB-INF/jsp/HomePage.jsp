<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Home Page</title>
    <link rel="stylesheet" href="css/styles.css" />
</head>
<body>
<c:import url="common/header.jsp"/>
    <section id="main-content">
    	<c:forEach var="park" items="${parks}">
	    	<div class = "park">
	    		<a href="parkDetail?parkId=${park.id}">
		    		<img id="parkImg" src = "img/${park.id}"/>
		    	</a>
    		
    			<h2 class = "inline"> 
    			<c:out value="${park.parkName}" />
    			<c:out value="${park.state}" />
    			</h2>
    			<p><c:out value="${park.description}" /></p>
		    			
	    	 </div>
		       
	    	 <hr>
	    </c:forEach>

       

    </section>

    
</body>
</html>