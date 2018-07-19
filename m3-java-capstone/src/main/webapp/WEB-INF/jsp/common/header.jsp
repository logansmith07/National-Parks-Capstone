<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <link rel="stylesheet" href= "https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" />
    <c:url value="/css/styles.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
<c:url value="/homepage" var="homepage" />
<c:url value="/img/ssg_logo.png" var="logoSrc" />
<c:url value="/homepage" var="homepage"/>
<c:url value = "/survey" var="survey"/>
<div class="container">
  <div class="row">
  	<div class="col-sm-12">
 		<a href="${homepage}">
        	<img class="img-fluid" src="img/logo.png" />
        </a>
      </div> 
   </div>
</div>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link"href="${homepage}">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${survey}">Survey</a>
    </li>
  </ul>
</nav>
<br>



</html>