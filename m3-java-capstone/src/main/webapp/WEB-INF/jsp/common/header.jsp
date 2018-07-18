<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Solar System Geek</title>
    <c:url value="/css/solarsystemgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>

<c:url value="/homepage" var="homepage"/>
<c:url value = "/survey" var="survey"/>

    <header>
    <nav>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/ssg_logo.png" var="logoSrc" />
    		
        <a href="${homePageHref}">
        		<img src="img/logo.png" />
        </a>
        <h1>National Park Geek</h1>
        <ul>
            <li><a href="${homepage}">Home</a></li>
            <li><a href="${survey}">Survey</a></li>
        </ul>
    </nav>
    </header>
    

</body>
</html>