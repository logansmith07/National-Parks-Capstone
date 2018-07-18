<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="common/header.jsp"/>
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
	    	 <c:url var="formAction" value="/parkDetail"/>
	    	 <form action="${formAction}" method="POST" >
	    	 <button name="celsius" type="submit" value="true">Celsius</button>
			 <button name="celsius" type="submit" value="false">Fahrenheit</button>
	    	 <input type="hidden" name="parkCode" id="parkCode" value="${park.parkCode}" />
	    	 </form>
	    	 <div>
	    	 <img id="main-weather-img" src="img/weather/${weathers.get(0).forecast}.png"/>
			 <p>High <c:out value= "${weathers.get(0).getHigh(celsius)}"/></p> 
			 <p>Low <c:out value= "${weathers.get(0).getLow(celsius)}"/></p>
			 <h3>Alerts:</h3>
			 <ul>
			 <c:forEach var="warning"  items="${weathers.get(0).getWarnings()}">
			 <li><p>${warning}</p></li>
			 </c:forEach>
			 </ul>
			 
	    	 </div>
	    	 <c:forEach var="index" begin="1"  end="${weathers.size() -1}">
	    	 <table class="weatherTable">
					<tr>
					<th><img src="img/weather/${weathers.get(index).forecast}.png"/></th>
					</tr>
					<tr>
						<td>
						<p>High <c:out value= "${weathers.get(index).getHigh(celsius)}"/> </p> 
				
					   <p>Low <c:out value= "${weathers.get(index).getLow(celsius)}"/></p>
					   </td>
					   
					</tr>
			    </table>
			</c:forEach>
       

    </section>

    
<c:import url="common/footer.jsp"/>
</html>