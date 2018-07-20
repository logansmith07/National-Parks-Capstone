<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Home Page</title>
    <link rel="stylesheet" href="css/styles.css" />
</head>

<c:import url="common/header.jsp"/>
<div class="container-fluid">
    <h1>National Parks Survey Results</h1>
    <hr />
    	<c:forEach items="${parks}" var="park" >
    	<div class="row justify-content-center">
    		<div class="col-md-12">
    				<h1> 
    					<c:out value="${park.parkName}" />
    				</h1>
    			</div>
    		</div>
    	<div class="row justify-content-center">
    		<div class="col-md-8">
	    		<a href="parkDetail?parkCode=${park.parkCode}">
		    		<img id="parkImg img-fluid" src = "img/parks/${park.parkCode}.jpg"/>
		    	</a>
    		</div>
    			
    			<div class="col-sm-4">
	    			<div class="jumbotron jumbotron-fluid">
	    				<h1><c:out value="Votes: ${park.numberSurveys}" /></h1>
	    			</div>
		    	</div>		
	    	 
		 </div>
		 <hr />
	    </c:forEach>
</div>    


    
<c:import url="common/footer.jsp"/>
</html>