<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Home Page</title>
    <link rel="stylesheet" href="css/styles.css" />
</head>

<c:import url="common/header.jsp"/>
    <section id="main-content">
    <h1>National Parks Survey Results</h1>
    	<c:forEach items="${parks}" var="park" >
	    	<div class = "park">
	    		<a href="parkDetail?parkCode=${park.parkCode}">
		    		<img id="parkImg" src = "img/parks/${park.parkCode}.jpg"/>
		    	</a>
    		
    			<h2> 
    			<c:out value="${park.parkName}" />
 
    			</h2>
    			
    			<h1><c:out value="${park.numberSurveys}" /></h1>
		    			
	    	 </div>
		       
	    	 <hr>
	    </c:forEach>

       

    </section>

    
<c:import url="common/footer.jsp"/>
</html>