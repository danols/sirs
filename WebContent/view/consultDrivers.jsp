<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<head>
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
		<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
      	<script type="text/javascript" src="js/materialize.min.js" ></script>
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<title>Conductores</title>
	</head>
	<body>
		<c:import url='/view/header.jsp'/>
		<c:forEach items="${drivers}" var="driver">
			<c:out value="${driver}" />
			<br>
		</c:forEach>
	</body>
</html>