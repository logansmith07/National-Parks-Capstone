<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Home Page</title>
    <link rel="stylesheet" href="css/styles.css" />
</head>

<c:import url="common/header.jsp"/>
<div class="container">
    	<c:forEach var="park" items="${parks}">
    	<div class="row">
    		<div class ="col-md-6">
    			<a href="parkDetail?parkCode=${park.parkCode}">
		    		<img class="img-fluid border border-dark park-image" src = "img/parks/${park.parkCode}.jpg"/>
		    	</a>
		   </div>
		   <div class ="col-md-6">
	    		<h2> 
	    			<c:out value="${park.parkName}" />
    			</h2>
    			<h2>
    				<c:out value="${park.state}" />
    			</h2>
    			<p class="description"><c:out value="${park.description}" /></p>
    		</div>
    	  </div>
	    </c:forEach>
	  </div>


    
<c:import url="common/footer.jsp"/>
</html>