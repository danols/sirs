<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url='/view/head.jsp'/>
<body>
		<c:import url='/view/header.jsp'/>
		<br><br><br><br>
		<div class="panel panel-default">
			<div class="panel-heading">Lista de Vehículos</div>
		  	<div class="panel-body">
		   		<table class="table">
		   			<thead>
		   				<tr>
			   				<th>Matrícula</th>
			   				<th>Modelo</th>
			   				<th>Año</th>
			   				<th>Marca</th>
			   				<th>Delegación</th>
			   				<th>Tipo vehiculo</th>
			   				<th>Capacidad (Tons.)</th>
			   				
		   				</tr>
		   			</thead>
		   			<tbody>
						<c:forEach items="${trucks}" var="truck">
						<tr>
							<td><c:out value="${truck.getLicensePlate()}" /></td>
			   				<td><c:out value="${truck.getModel()}" /></td>
			   				<td><c:out value="${truck.getYear() }" /></td>
			   				<td><c:out value="${truck.getTrademark()}" /></td>
			   				<td><c:out value="${truck.getDistrict()}" /></td>
			   				<td><c:out value="${truck.getType()}" /></td>
			   				<td><c:out value="${truck.getCapacity()}" /></td>
			   				
			   				
						</tr>
						</c:forEach>
					</tbody>
				</table>
		  	</div>
		</div>
	</body>
</html>