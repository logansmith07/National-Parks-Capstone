<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    

<c:import url="common/header.jsp"/>
<section id="main-content"  class="centeredPanel">
<c:url value="/survey/submit" var="surveySubmitURL" />
         <div><p class="surveyTitle">Please fill out the daily survey</p></div>
         <hr>

<div class="container">
<form:form action="${surveySubmitURL}" method="POST" modelAttribute="survey">
	<div class="dropdown">
    <label for="parkCode"><b>Favorite National Park</b></label>
	<form:select path="parkCode" name="parkCode" id="parkCode" class="custom-select custom-select mb-3">
		<option value="CVNP">Cuyahoga Valley National Park</option>
		<option value="ENP">Everglades National Park</option>
		<option value="GCNP">Grand Canyon National Park</option>
		<option value="GNP">Glacier National Park</option>
		<option value="GSMNP">Great Smokey Mountains National Park</option>
		<option value="GTNP">Grand Teton National Park</option>
		<option value="MRNP">Mount Rainier National Park</option>
		<option value="RMNP">Rocky Mountain National Park</option>
		<option value="YNP">Yellowstone National Park</option>
		<option value="YNP2">Yosemite National Park</option>
	</form:select>
	</div>
	
	 <div class="form-group">
            <label for="email"><b>Your Email</b></label>
			<form:input path="email" class="form-control"/>            
        	<form:errors path="email" cssClass="error"/>		
      </div>

    <div class="dropdown">
	    <label for="residenceState"><b>State of Residence</b></label>
		<form:select path="residenceState" name="residenceState" id="residenceState" class="custom-select custom-select mb-3">
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="DC">District of Columbia</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>			
		</form:select>
	</div>
	
	<label for="activityLevel"><b>Activity Level</b></label>
	
	<br>
	
	<div class="custom-control custom-radio custom-control-inline">
    <form:radiobutton class="custom-control-input" id="extremelyActive" path="activityLevel" name="activityLevel" value="Extremely Active"/>
    <label class="custom-control-label" for="extremelyActive">Extremely Active</label>
  	</div>
  	
  	<div class="custom-control custom-radio custom-control-inline">
    <form:radiobutton class="custom-control-input" id="active" path="activityLevel" name="activityLevel" value="Active"/>
    <label class="custom-control-label" for="active">Active</label>
  	</div>
  	
  	<div class="custom-control custom-radio custom-control-inline">
    <form:radiobutton class="custom-control-input" id="sedentary" path="activityLevel" name="activityLevel" value="Sedentary"/>
    <label class="custom-control-label" for="sedentary">Sedentary</label>
  	</div>
  	
  	<div class="custom-control custom-radio custom-control-inline">
    <form:radiobutton class="custom-control-input" id="inactive" path="activityLevel" name="activityLevel" value="Inactive"/>
    <label class="custom-control-label" for="inactive">Inactive</label>
  	</div>
  	
  		<form:errors class="alert alert-danger" path="activityLevel" cssClass="error"/>
    
   	<div>
   		<button id="submitButton" type="submit" class="btn btn-primary">Submit Survey</button>
   	</div>
        
        
</form:form>
</div>
</section>
<c:import url="common/footer.jsp"/>