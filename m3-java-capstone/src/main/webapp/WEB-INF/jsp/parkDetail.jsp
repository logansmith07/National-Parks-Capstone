<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="common/header.jsp"/>
    <div class="container">
     <div class="row">
     	<div class="col-sm-12 jumbotron mx-auto bg-success text-white">
     		<div class="text-center">
		    	<h2 class="bg-success text-white"> 
					<c:out value="${park.parkName}" />
					<c:out value="${park.state}" />
				</h2>
			</div>
		</div>
		</div>
   		 <div class="row">
    		<div class="col-sm-8">
    		
		    	<img class="rounded img-fluid park-image"  src = "img/parks/${park.parkCode}.jpg"/>
	    		<div class="card">
	    			<div class="card-header top-padding">
		    		<p id="quote"> ${park.inspirationalQuote} - ${park.quoteSource} </p>
	    			<p id="description"> <c:out value="${park.description}" /> </p> 
	    			</div>
    			</div>
    		  </div>
    		  
    		  <div class="col-sm-4">
    		 	<ul class="list-group">
				  <li class="list-group-item">Entry Fee: $${park.entryFee}</li>
				  <li class="list-group-item">Elevation: ${park.elevation}</li>
				  <li class="list-group-item">Animal Species: ${park.numberAnimalSpecies}</li>
				  <li class="list-group-item">Year Founded: ${park.yearFounded}</li>
				  <li class="list-group-item">Visitors per Year: ${park.annualVisitorCount}</li>
				  <li class="list-group-item">Acreage:  ${park.acreage}</li>
				  <li class="list-group-item">Miles of Trails: ${park.milesOfTrail}miles </li>
				  <li class="list-group-item">Climate:  ${park.climate}</li>
				  <li class="list-group-item">Campsites: ${park.numberOfCampsites}</li>
				</ul>
				
					</div>
				</div> 
	    	 <hr>
	    	 
	    	 <c:url var="formAction" value="/parkDetail"/>
	    	 <form action="${formAction}" method="POST" >
	    	 
		    	 <c:choose>
				  <c:when test="${celsius eq 'true'}">
				    <button class="btn btn-primary bn-lg" name="celsius" type="submit" value="false">Change to Fahrenheit</button>
				  </c:when>
				  <c:when test="${celsius eq 'false'}">
				   <button class="btn btn-primary bn-lg" name="celsius" type="submit" value="true">Change to Celsius</button>
				  </c:when>
				</c:choose>
				<input type="hidden" name="parkCode" id="parkCode" value="${park.parkCode}" />
	    	 </form>
	    	
	    	
	    	 <div class="row">
		    	 <div class="col-sm-4">
			    	 <img class="img-fluid" src="img/weather/${weathers.get(0).forecast}.png"/>
					 <p class="text-center">High <c:out value= "${weathers.get(0).getHigh(celsius)}"/></p> 
					 <p class="text-center">Low <c:out value= "${weathers.get(0).getLow(celsius)}"/></p>
				 </div>
			 
	    	 <c:forEach var="index" begin="1"  end="${weathers.size() -1}">
	    	 <div class="col-sm-2">
					<img class ="img-fluid" src="img/weather/${weathers.get(index).forecast}.png"/>
						
						<p class="text-center">High <c:out value= "${weathers.get(index).getHigh(celsius)}"/></p> 
				
					   <p class="text-center">Low <c:out value= "${weathers.get(index).getLow(celsius)}"/></p>
					  
			    </div>
			</c:forEach>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="card red-background">
					 	<div class="card-header">
							 <h3 class="text-danger text-center">Alerts</h3>
							 <ul class="list-group">
								 <c:forEach var="warning"  items="${weathers.get(0).getWarnings()}">
								 	<li class="list-group-item list-group-item-danger"><p>${warning}</p></li>
								 </c:forEach>
							 </ul>
						 </div>
					 </div>
				</div>
			</div>
	</div>


    
<c:import url="common/footer.jsp"/>
</html>