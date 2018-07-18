<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/styles.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>

<c:url value="/homepage" var="homepage"/>
<c:url value = "/survey" var="survey"/>

    <header>
    <nav>
    		<c:url value="/homepage" var="homepage" />
    		<c:url value="/img/ssg_logo.png" var="logoSrc" />
    		
        <a href="${homepage}">
        		<img id="hero-pic" src="img/logo.png" />
        </a>
        <ul>
            <li><a href="${homepage}">Home</a></li>
            <li><a href="${survey}">Survey</a></li>
        </ul>
    </nav>
    </header>
    


</html>