<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<c:import url='/view/head.jsp'/>
	<body>
		<c:import url='/view/header.jsp'/>
		<br><br><br><br>
		<div class="panel panel-default">
			<div class="panel-heading">Lista de Conductores</div>
		  	<div class="panel-body">
		   		<table class="table">
		   			<thead>
		   				<tr>
			   				<th>Id</th>
			   				<th>Nombre</th>
			   				<th>Apellido Paterno</th>
			   				<th>Apellido Materno</th>
			   				<th>CURP</th>
			   				<th>Licencia de Manejo</th>
			   				<th>Email</th>
			   				<th>Teléfonos</th>
		   				</tr>
		   			</thead>
		   			<tbody>
						<c:forEach items="${drivers}" var="driver">
						<tr>
							<td><c:out value="${driver.getId()}" /></td>
			   				<td><c:out value="${driver.getName()}" /></td>
			   				<td><c:out value="${driver.getLastName()}" /></td>
			   				<td><c:out value="${driver.getSurName()}" /></td>
			   				<td><c:out value="${driver.getCurp()}" /></td>
			   				<td><c:out value="${driver.getDrivingLicense()}" /></td>
			   				<td><c:out value="${driver.getEmail()}" /></td>
			   				<td><c:out value="${driver.printPhoneNumbers()}" /></td>
			   				<td><button type="button" class="btn btn-default btn-xs">Vehículos</button></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
		  	</div>
		</div>
	</body>
</html>