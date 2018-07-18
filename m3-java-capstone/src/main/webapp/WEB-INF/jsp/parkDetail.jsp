<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="common/header.jsp">
	<c:set var="title" value="${park.parkName}" />
</c:import>
    <section id="main-content">
	    	<div class = "park">
		    		<img id="parkImg" src = "img/parks/${park.parkCode}.jpg"/>
    		
    			<h2 id="heroHeading"> 
    			<c:out value="${park.parkName}" />
    			<c:out value="${park.state}" />
    			</h2>
    			 <p id="quote"> ${park.inspirationalQuote} - ${park.quoteSource} </p>
    			 <p id="description"> <c:out value="${park.description}" /> </p> 
    			 
    			 <table class="table">
					<tr>
					<th>Entry Fee</th>
					<th>Elevation</th>
					<th> Animal Species </th>
					<th> Year Founded </th>
					<th> Visitors per Year </th>
					<th> Acreage </th>
					<th> Miles of Trails </th>
					<th> Climate </th>
					<th> Campsites </th>
					</tr>
					<tr>
						<td> 
					   ${park.entryFee}
					   </td>
					   <td> 
					   ${park.elevation}
					   </td>
					   <td> 
					   ${park.numberAnimalSpecies}
					   </td>
					   <td> 
					   ${park.yearFounded}
					   </td>
					   <td> 
					   ${park.annualVisitorCount}
					   </td>
					   <td> 
					   ${park.acreage}
					   </td>
					   <td> 
					   ${park.milesOfTrail}
					   </td>
					   <td> 
					   ${park.climate}
					   </td>
					   <td> 
					   ${park.numberOfCampsites}
					   </td>
					</tr>
			    </table>
    			 
    			
	    	 </div> 
	    	 <hr>
	    	 <c:forEach var="weather" items="${FiveDayWeather}"></c:forEach>
	    	 <table class="weatherTable">
					<tr>
					<th><img src="img/${weather.forecast}.png"/></th>
					</tr>
					<tr>
						<td>
						<h3>High</h3> 
					   ${weather.high}
					   </td>
					   <td> 
					   <h3>Low</h3>
					   ${weather.low}
					   </td>
					</tr>
			    </table>

       

    </section>

    
<c:import url="common/footer.jsp"/>
</html>